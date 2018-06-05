package com.jwt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.FactureDAO;
import com.jwt.model.Facture;

@Service
@Transactional
public class FactureServiceImpl implements FactureService {

	@Autowired
	private FactureDAO factureDAO;

	@Override
	@Transactional
	public void addFacture(Facture facture) {
		factureDAO.addFacture(facture);
	}
	
	@Override
	@Transactional
	public List<Facture> getAllFactures() {
		return factureDAO.getAllFactures();
	}


	@Override
	@Transactional
	public void deleteFacture(Integer numFacture) {
		factureDAO.deleteFacture(numFacture);
	}

	public Facture getFacture(int numfact) {
		return factureDAO.getFacture(numfact);
	}

	public Facture updateFacture(Facture facture) {
		// TODO Auto-generated method stub
		return factureDAO.updateFacture(facture);
	}

	public void setFactureDAO(FactureDAO factureDAO) {
		this.factureDAO = factureDAO;
	}

}
