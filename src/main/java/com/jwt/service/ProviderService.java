package com.jwt.service;

import java.util.List;

import com.jwt.model.Provider;

public interface ProviderService {
	
	public void addProvider(Provider provider);

	public List<Provider> getAllProvider();

	public void deleteProvider(Integer providerId);

	public Provider getProvider(int providerid);

	public Provider updateProvider(Provider provider);
}
