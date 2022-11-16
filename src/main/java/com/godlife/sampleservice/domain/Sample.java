package com.godlife.sampleservice.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "samples")
public class Sample {
	private Long id;
	private String name;
}
