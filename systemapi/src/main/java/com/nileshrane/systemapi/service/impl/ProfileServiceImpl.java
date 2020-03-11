package com.nileshrane.systemapi.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.nileshrane.systemapi.model.Address;
import com.nileshrane.systemapi.model.PersonalDetails;
import com.nileshrane.systemapi.model.ProfessionalDetails;
import com.nileshrane.systemapi.model.ProfileDetails;
import com.nileshrane.systemapi.model.Skill;
import com.nileshrane.systemapi.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

	private Map<Long, ProfileDetails> profiles = new HashMap<>();
	
	@Override
	public boolean addProfile(ProfileDetails request) {
		
		if(!profiles.containsKey(request.getProfileId())) {
			profiles.put(request.getProfileId(),request);
		return true;
		}
		
		return false;
	}
	@Override
	public boolean updateProfile(long profileId, ProfileDetails request) {
		if(profiles.containsKey(profileId)) {
			profiles.put(request.getProfileId(),request);
		return true;
		}
		return false;
	}

	@Override
	public ProfileDetails readProfile(long profileId) {
		return profiles.get(profileId);
	}

	@Override
	public void deleteProfile(long profileId) {
		profiles.remove(profileId);
	}
	
	@PostConstruct
	public void createProfiles() {

		for (int i = 1; i <= 10; i++) {
			ProfileDetails profileDetails = ProfileDetails.builder().profileId(i)
					.personalDetails(PersonalDetails.builder().applicantId(i).email("profile" + i + "@example.com")
							.phone(String.valueOf(new Random().nextInt(999999999) + 900000000)).firstName("profile" + i)
							.lastName("lastName" + i)
							.addresses(Arrays.asList(Address.builder().addressId(1).unit("unit" + i).street("street" + i).build())).build())
					.professionalDetails(ProfessionalDetails.builder().experience(new Random().nextInt(9) + i)
							.primarySkill("Java").designation("Software Engineer").build())
					.skills(Arrays.asList(
							Skill.builder().tool("Java").yearsOfExperience(new Random().nextInt(9) + i)
									.monthsOfExperience(new Random().nextInt(9) + i).recentlyUsed(true).build(),
							Skill.builder().tool("Spring").yearsOfExperience(new Random().nextInt(9) + i)
									.monthsOfExperience(new Random().nextInt(9) + i).recentlyUsed(true).build(),
							Skill.builder().tool("JPA").yearsOfExperience(new Random().nextInt(9) + i)
									.monthsOfExperience(new Random().nextInt(9) + i).recentlyUsed(true).build()))
					.build();
			profiles.put(Long.valueOf(i), profileDetails);
		}

	}

}
