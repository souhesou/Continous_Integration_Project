package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.MissionExterne;

public interface IMissionExterneService {
	public MissionExterne addMissionExterne(MissionExterne mission);
	public List<MissionExterne> retrieveAllMissionExterne();
	public void remove(String idMissionExterne);
	public MissionExterne updateMissionExterne(MissionExterne mission);
	public MissionExterne retrieveMissionExterne(String id);
	
}
