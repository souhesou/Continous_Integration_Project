package tn.esprit.spring.services;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.MissionExterne;
import tn.esprit.spring.repository.MissionExterneRepository;

@Service
public class MissionExterneService implements IMissionExterneService {
	
	private static final Logger l = LogManager.getLogger(MissionExterneService.class);
	
	@Autowired
	MissionExterneRepository im;
	
	@Override
	public MissionExterne addMissionExterne(MissionExterne mission)
	{
		return im.save(mission); 
		
	}
	@Override
	public List<MissionExterne> retrieveAllMissionExterne(){
		List<MissionExterne> missions = null; 
		try {
	
			l.info("In retrieveAllMissionExterne() : ");
			missions = (List<MissionExterne>) im.findAll();  
			for (MissionExterne mission : missions) {
				l.debug("mission +++ : " + mission);
			} 
			l.info("Out of retrieveAllMissionExterne() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllMissionExterne() : " + e);
		}

		return missions;
		
	}
	
	
	@Override
	public void remove(String idMissionExterne)
	{
		im.deleteById(Long.parseLong(idMissionExterne));
	}
	
	@Override
	public MissionExterne updateMissionExterne(MissionExterne mission)
	{
		return im.save(mission);

	}
	@Override
	public MissionExterne retrieveMissionExterne(String id) {
		l.info("in  retrieveMissionExterne id = " + id);
		MissionExterne m =  im.findById(Long.parseLong(id)).get(); 
		l.info("MissionExterne returned : " + m);
		return m; 
	

	}
	
	

}
