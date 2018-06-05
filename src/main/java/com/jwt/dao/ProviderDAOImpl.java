package com.jwt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.Provider;

@Repository
public class ProviderDAOImpl implements ProviderDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addProvider(Provider provider) {
		sessionFactory.getCurrentSession().saveOrUpdate(provider);

	}

	@SuppressWarnings("unchecked")
	public List<Provider> getAllProvider() {

		return sessionFactory.getCurrentSession().createQuery("from Provider")
				.list();
	}

	@Override
	public void deleteProvider(Integer providerId) {
		Provider provider = (Provider) sessionFactory.getCurrentSession().load(
				Provider.class, providerId);
		if (null != provider) {
			this.sessionFactory.getCurrentSession().delete(provider);
		}

	}

	public Provider getProvider(int prvid) {
		return (Provider) sessionFactory.getCurrentSession().get(
				Provider.class, prvid);
	}

	@Override
	public Provider updateProvider(Provider provider) {
		sessionFactory.getCurrentSession().update(provider);
		return provider;
	}

}