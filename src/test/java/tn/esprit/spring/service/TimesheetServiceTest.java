package tn.esprit.spring.service;

import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.services.ITimesheetService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetServiceTest {
	
	@Autowired
	ITimesheetService ts ;
	

	
	@Test
	public void testRetrieveAllTimesheet() {
		List<Timesheet> listTimesheets = ts.retrieveAllTimesheet();
		// if there are 7 users in DB : 
		Assert.assertEquals(5, listTimesheets.size());
	}

	@Test
	public void testAddTimesheet() throws ParseException {
		
		Timesheet t = new Timesheet(64L, false,"wassel");
		Timesheet timesheetadded = ts.addTimesheet(t) ;
		Assert.assertEquals(t.getName(), timesheetadded.getName());
	}
	
	
	@Test
	public void testModifyTimesheet() throws ParseException   {
		
		Timesheet t = new Timesheet(64L, false,"wassel1");
		Timesheet timesheetModified = ts.updateTimesheet(t) ;
		Assert.assertEquals(t.getName(), timesheetModified.getName());
	}
	
	
	
	@Test
	public void testDeleteTimesheet() {
		ts.remove("64");
		Assert.assertNull(ts.retrieveTimesheet("64"));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
