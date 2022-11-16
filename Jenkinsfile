pipeline {
    agent any
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
    }
}