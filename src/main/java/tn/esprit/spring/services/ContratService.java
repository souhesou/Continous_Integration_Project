package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratService {
	
	private static final Logger l = LogManager.getLogger(EmployeService.class);

	@Autowired
	ContratRepository ie ; 
	
	
	public Contrat addContrat(Contrat contrat)
	{
		return ie.save(contrat); 
		
	}
	
	public List<Contrat> retrieveAllContrat(){
		List<Contrat> contrats = null; 
		try {
	
			l.info("In retrieveAllContrats() : ");
			contrats = (List<Contrat>) ie.findAll();  
			for (Contrat cn : contrats) {
				l.debug("Contrat +++ : " + cn);
			} 
			l.info("Out of retrieveAllContrats() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllContrats() : " + e);
		}

		return contrats;
		
}

	public Contrat updateContrat(Contrat con) {
		// TODO Auto-generated method stub
		return ie.save(con);
	}
	

	public Contrat retrieveContrat(String id) {
		l.info("in  retrievecontrat id = " + id);
		Contrat e =  ie.findById(Integer.parseInt(id)).orElse(null);
		l.info("contrat returned : " + e);
		return e; 
	

	}
	
	
	public void remove(String idContrat)
	{
		ie.deleteById(Integer.parseInt(idContrat));
	}
}
