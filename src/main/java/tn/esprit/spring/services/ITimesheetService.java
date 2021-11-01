package tn.esprit.spring.services;


import java.util.List;

import tn.esprit.spring.entities.Timesheet;

public interface ITimesheetService {

	
	public Timesheet addTimesheet(Timesheet timesheet);
	public List<Timesheet > retrieveAllTimesheet ();
	public void remove(String idTimesheet );
	public Timesheet  updateTimesheet (Timesheet  timesheet );
	public Timesheet  retrieveTimesheet (String id);
	
	
	
	
}
