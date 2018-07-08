package com.jwt.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jwt.model.Client;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; 
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:spring-servlet.xml")
public class ClientControllerTest {

	@Autowired
    private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@After
	public void tearDown() throws Exception {
	} 

	@Test
	public final void testClientController() {
	}

	@Test
	public final void testListClient() throws Exception {
		this.mockMvc.perform(get("/clientlist"))
        .andExpect(status().isOk())
		.andExpect(view().name("ClientList"))
        .andExpect(forwardedUrl("/WEB-INF/pages/ClientList.jsp"));        
	}

	@Test
	public final void testNewContact() throws Exception {
		this.mockMvc.perform(get("/newClient"))
	            .andExpect(status().isOk())
	            .andExpect(view().name("ClientForm"))
	            .andExpect(forwardedUrl("/WEB-INF/pages/ClientForm.jsp"));
	}

	@Test
	public final void testSaveClient() throws Exception {
		this.mockMvc.perform(post("/saveClient")
        .param("name", "sabri")
        .param("email", "mah.sabr@gmail.co")
        .param("address", "maloussy")
        .param("tel1", "97278031")
        .param("tel2", "25803173")
        .param("telFixe", "71548963")
        .param("fax", "71544223")
		.param("numFacture", "2")
		.sessionAttr("client", new Client()))
        .andExpect(redirectedUrl("/"));      		
				
	}
	
	@Test
	public final void testSaveClient2() throws Exception {
		this.mockMvc.perform(post("/saveClient")
        .param("id", "2")
        .param("name", "sabri")
        .param("email", "mah.sabr@gmail.co")
        .param("address", "maloussy")
        .param("tel1", "97278031")
        .param("tel2", "25803173")
        .param("telFixe", "71548963")
        .param("fax", "71544223")
		.param("numFacture", "2")
		.sessionAttr("client", new Client()))
        .andExpect(redirectedUrl("/"));      		
				
	}

	@Test
	public final void testDeleteClient() throws Exception {
		this.mockMvc.perform(get("/deleteClient")
		        .param("id", "3"))
		        .andExpect(redirectedUrl("/"));      		
	}

	@Test
	public final void testEditContact() throws Exception {
		this.mockMvc.perform(get("/editClient")
		.param("id", "4"))
        .andExpect(status().isOk())
		.andExpect(view().name("ClientForm"))
        .andExpect(forwardedUrl("/WEB-INF/pages/ClientForm.jsp"));        
	}

}
