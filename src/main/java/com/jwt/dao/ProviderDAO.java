package com.jwt.dao;

import java.util.List;
import com.jwt.model.Provider;

public interface ProviderDAO {

	public void addProvider(Provider provider);

	public List<Provider> getAllProvider();

	public void deleteProvider(Integer providerId);

	public Provider updateProvider(Provider provider);

	public Provider getProvider(int providerid);
}
