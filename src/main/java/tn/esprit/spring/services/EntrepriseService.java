package tn.esprit.spring.services;

import org.springframework.stereotype.Service;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service

public class EntrepriseService implements IEntrepriseService {

	private static final Logger l = LogManager.getLogger(EntrepriseService.class);

	@Autowired
	EntrepriseRepository ie;
	
	
	@Override
	public Entreprise addEntreprise(Entreprise entreprise) {
		return ie.save(entreprise);
	}

	@Override
	public List<Entreprise> retrieveAllEntreprise() {
		List<Entreprise> entreprises = null; 
		try {
	
			l.info("In retrieveAllEntreprise() : ");
			entreprises = (List<Entreprise>) ie.findAll();  
			for (Entreprise entreprise : entreprises) {
				l.debug("entreprise +++ : " + entreprise);
			} 
			l.info("Out of retrieveAllEntreprise() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllEntreprise() : " + e);
		}

		return entreprises;
	}

	@Override
	public void remove(String id) {
		ie.deleteById(Integer.parseInt(id));
		
	}

	@Override
	public Entreprise updateEntreprise(Entreprise entreprise) {
		return ie.save(entreprise);
		
	}

	@Override
		
	public Entreprise retrieveEntreprise(String id) {
		l.info("in  retrieveEntreprise id = " + id);
		Entreprise e =  ie.findById(Integer.parseInt(id)).orElse(null);
		l.info("entreprise returned : " + e);
		return e; 
	

	}
	
	
	
	
	
	
	

}
