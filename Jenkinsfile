pipeline {
    agent any
    environment {
        imagename = "onezo/sample-service"
        registryCredential = 'jenkins-docker'
        dockerImage = ''
    }
    stages {
        stage('git clone') {
            steps {
                echo 'Clonning Repository'
                git url: 'git@github.com:live-god-life/sample-service.git',
                branch: 'release',
                credentialsId: 'jenkins-git'
            }
            post {
                success {
                    echo 'Successfully Cloned Repository'
                }
                failure {
                    echo 'Git Clone fail'
                }
            }
        }

        stage('Build docker') {
            steps {
                echo 'Build Docker'
                script {
                    dockerImage = docker.build imagename
                }
            }
            post {
                success {
                    echo 'Successfully Docker Build'
                }
                failure {
                    echo 'Docker Build fail'
                }
            }
        }

        stage('Push Docker') {
            steps {
                echo 'Push Docker'
                script {
                    docker.withRegistry( '', registryCredential) {
                        dockerImage.push()
                    }
                }
            }
            post {
                success {
                    echo 'Successfully Docker Push'
                }
                failure {
                    echo 'Docker Push fail'
                }
            }
        }

        stage('Docker Run') {
            steps {
                echo 'Pull Docker Image & Docker Image Run'
                sh "ssh -o StrictHostKeyChecking=no root@106.10.40.232 -p 2222 'docker rm \$(docker ps -aq -f name=sample) && docker run -d -e SPRING_PROFILES_ACTIVE=prod --name sample-service -p 80:80 onezo/sample-service'"
//                 sh "ssh -o StrictHostKeyChecking=no root@106.10.40.232 -p 2222 'docker run -d -e SPRING_PROFILES_ACTIVE=prod --name sample-service -p 80:80 onezo/sample-service'"
            }
            post {
                success {
                    echo 'Successfully Docker Run'
                }
                failure {
                    echo 'Docker Run fail'
                }
            }
        }
    }
}