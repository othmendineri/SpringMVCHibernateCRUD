package com.jwt.service;

import java.util.List;

import com.jwt.model.Client;

public interface ClientService {
	
	public void addClient(Client client);

	public List<Client> getAllClients();

	public void deleteClient(Integer clientId);

	public Client getClient(int clientid);

	public Client updateClient(Client client);
}
