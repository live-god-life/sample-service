package com.godlife.sampleservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godlife.sampleservice.domain.Sample;

public interface SampleRepository extends JpaRepository<Sample, Long> {
}
