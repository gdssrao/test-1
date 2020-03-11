package com.nileshrane.systemapi.service;

import com.nileshrane.systemapi.model.ProfileDetails;

public interface ProfileService {

	public boolean addProfile(ProfileDetails request);
	public boolean updateProfile(long profileId, ProfileDetails request);
	public ProfileDetails readProfile(long profileId);
	public void deleteProfile(long profileId);
	
}
