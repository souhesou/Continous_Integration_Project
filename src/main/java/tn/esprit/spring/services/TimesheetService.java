package tn.esprit.spring.services;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.repository.TimesheetRepository;

@Service
public class TimesheetService implements ITimesheetService  {

	
	private static final Logger l = LogManager.getLogger(EmployeService.class);

	@Autowired
	TimesheetRepository ti;
	
	
	@Override
	public Timesheet addTimesheet(Timesheet timesheet) {
		
		return ti.save(timesheet); 
	}
	
	
	
	@Override
	public List<Timesheet> retrieveAllTimesheet() {
		List<Timesheet> timesheets = null; 
		try {
	
			l.info("In retrieveAllTimesheet() : ");
			timesheets = (List<Timesheet>) ti.findAll();  
			for (Timesheet timesheet : timesheets) {
				l.debug("timesheet +++ : " + timesheet);
			} 
			l.info("Out of retrieveAlltimesheets() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAlltimesheets() : " + e);
		}

		return timesheets;
		
	}
	
	

	@Override
	public void remove(String idTimesheet) {
		ti.deleteById(Long.parseLong(idTimesheet));
		
	}

	@Override
	public Timesheet retrieveTimesheet(String id) {
		l.info("in  retrieveTimesheet id = " + id);
		Timesheet t =  ti.findById(Long.parseLong(id)).orElse(null) ;
		l.info("employe returned : " + t);
		return t; 
	
	}
	
	
	@Override
	public Timesheet updateTimesheet(Timesheet timesheet) {
		// TODO Auto-generated method stub
		return ti.save(timesheet);
	}
	
}
