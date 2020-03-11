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
public class Skill {
	@JsonProperty("tool_name")
	private String tool;
	@JsonProperty("years_of_experience")
	private int yearsOfExperience;
	@JsonProperty("months_of_experience")
	private int monthsOfExperience;
	@JsonProperty("recently_used")
	private boolean recentlyUsed;
}
