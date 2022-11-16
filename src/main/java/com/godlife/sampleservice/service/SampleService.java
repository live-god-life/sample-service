package com.godlife.sampleservice.service;

import org.springframework.stereotype.Service;

import com.godlife.sampleservice.domain.Sample;
import com.godlife.sampleservice.repository.SampleRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SampleService {
	private final SampleRepository sampleRepository;
	public Sample sample(Long id) {
		return sampleRepository.findById(id).get();
	}
}
