package com.jwt.service;


import java.util.List;

import com.jwt.model.Facture;

public interface FactureService {
	
	public void addFacture(Facture facture);
	
	public List<Facture> getAllFactures();

	public void deleteFacture(Integer numFacture);

	public Facture updateFacture(Facture facture);

	public Facture getFacture(int numfacture);
}
