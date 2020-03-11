package com.nileshrane.systemapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDetails {
	@JsonIgnore
	@JsonProperty("profile_id")
	private long profileId;
	@JsonProperty("personal_details")
	private PersonalDetails personalDetails;
	@JsonProperty("professional_details")
	private ProfessionalDetails professionalDetails;
	private List<Skill> skills;
}
