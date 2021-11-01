package tn.esprit.spring.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.ContratService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceTest {
	
	@Autowired
	ContratService ser ; 
	
	
	@Test
	public void testAddContrat() throws ParseException {
		
		
		//Date date = new SimpleDateFormat("yyyy-mm-dd").parse("2021-10-31");
	
		java.util.Date date=new java.util.Date();
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		Contrat contrat = new Contrat(sqlDate ,"test",12);
		Contrat Contratadded = ser.addContrat(contrat);
		Assert.assertEquals(contrat.getTypeContrat(), Contratadded.getTypeContrat());
	}
	
	@Test
	public void testRetrieveAllContrat() {
		List<Contrat> listcontrats = ser.retrieveAllContrat();
		// if there are 4 users in DB : 
		Assert.assertEquals(1, listcontrats.size());
	}
	
	@Test
	public void testModifyContrat() throws ParseException   {
		java.util.Date date=new java.util.Date();
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		Contrat con = new Contrat(7,sqlDate ,"test",13);
		Contrat contratModified = ser.updateContrat(con);
		Assert.assertEquals(con.getTypeContrat(), contratModified.getTypeContrat());
	}
	
	@Test
	public void testDeleteContrat() {
		ser.remove("7");
		Assert.assertNull(ser.retrieveContrat("7"));
		
		
	}

}
