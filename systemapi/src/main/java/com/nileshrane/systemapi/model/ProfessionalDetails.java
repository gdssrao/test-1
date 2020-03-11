package com.nileshrane.systemapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionalDetails {
	private int experience;
	@JsonProperty("primary_skill")
	private String primarySkill;
	private String designation;
}
