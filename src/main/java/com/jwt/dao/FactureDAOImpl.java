package com.jwt.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.Facture;

@Repository
public class FactureDAOImpl implements FactureDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addFacture(Facture facture) {
		sessionFactory.getCurrentSession().saveOrUpdate(facture);

	}
	
	@SuppressWarnings("unchecked")
	public List<Facture> getAllFactures() {

		return sessionFactory.getCurrentSession().createQuery("from Facture")
				.list();
	}


	@Override
	public void deleteFacture(Integer numFacture) {
		Facture facture = (Facture) sessionFactory.getCurrentSession().load(
				Facture.class, numFacture);
		if (null != facture) {
			this.sessionFactory.getCurrentSession().delete(facture);
		}

	}

	public Facture getFacture(int numfact) {
		return (Facture) sessionFactory.getCurrentSession().get(
				Facture.class, numfact);
	}

	@Override
	public Facture updateFacture(Facture facture) {
		sessionFactory.getCurrentSession().update(facture);
		return facture;
	}

}