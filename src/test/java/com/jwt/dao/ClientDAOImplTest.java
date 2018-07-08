package com.jwt.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.jwt.model.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-servlet.xml")
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class ClientDAOImplTest {
	
	@Autowired
	private ClientDAO clientDAO;
	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testAddClient() {
		Client client = new Client();
		client.setName("Mahfoudhi sabri");
		client.setEmail("mahfoudhi.sabri@hotmail.fr");
		client.setAddress("Maloussy");
		client.setTel1("97278031");
		client.setTel2("25803173");
		client.setTelFixe("71584785");
		client.setFax("71544896");
		client.setNumFacture(1);

		clientDAO.addClient(client);
		
		assertNotNull(client.getId());
        assertTrue(client.getId() > 0);
	}

	@Test
	public final void testGetAllClients() {
		List<Client> clients = clientDAO.getAllClients();
        assertEquals(1, clients.size());
	}

	@Test
	public final void testDeleteClient() {
		Client client = clientDAO.getClient(1);
		if (null != client) {
			clientDAO.deleteClient(1);
		}
	}

	@Test
	public final void testGetClient() {
		Client client = clientDAO.getClient(1);
		assertEquals(0, client.getNumFacture());
	}

	@Test
	public final void testUpdateClient() {
		Client client = clientDAO.getClient(1);
		client.setFax("00000000");
		clientDAO.updateClient(client);
	}

}
