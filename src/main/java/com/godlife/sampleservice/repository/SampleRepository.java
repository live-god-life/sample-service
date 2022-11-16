package com.godlife.sampleservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.godlife.sampleservice.domain.Sample;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {
}
