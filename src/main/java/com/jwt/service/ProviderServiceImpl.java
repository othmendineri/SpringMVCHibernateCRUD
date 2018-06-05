package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.ProviderDAO;
import com.jwt.model.Provider;

@Service
@Transactional
public class ProviderServiceImpl implements ProviderService {

	@Autowired
	private ProviderDAO providerDAO;

	@Override
	@Transactional
	public void addProvider(Provider provider) {
		providerDAO.addProvider(provider);
	}

	@Override
	@Transactional
	public List<Provider> getAllProvider() {
		return providerDAO.getAllProvider();
	}

	@Override
	@Transactional
	public void deleteProvider(Integer providerId) {
		providerDAO.deleteProvider(providerId);
	}

	public Provider getProvider(int prvid) {
		return providerDAO.getProvider(prvid);
	}

	public Provider updateProvider(Provider provider) {
		// TODO Auto-generated method stub
		return providerDAO.updateProvider(provider);
	}

	public void setProviderDAO(ProviderDAO providerDAO) {
		this.providerDAO = providerDAO;
	}

}
