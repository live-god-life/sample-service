package com.godlife.sampleservice.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.godlife.sampleservice.service.SampleService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
public class SampleController {
	private final SampleService sampleService;
	@GetMapping("/sample/{id}")
	public ResponseEntity sample(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(sampleService.sample(id));
	}
}
