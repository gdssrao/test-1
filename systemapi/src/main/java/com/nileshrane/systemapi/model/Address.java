package com.nileshrane.systemapi.model;

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
public class Address {
	@JsonIgnore
	@JsonProperty("address_id")
	private long addressId;
	
	@JsonProperty("unit")
	private String unit;

	@JsonProperty("street")
	private String street;

	@JsonProperty("state")
	private String state;

	@JsonProperty("country")
	private String country;

	@JsonProperty("zipcode")
	private Integer zipcode;
}
