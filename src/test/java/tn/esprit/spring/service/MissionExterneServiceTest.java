package tn.esprit.spring.service;

	import java.text.ParseException;
	import java.util.List;

	import org.junit.Assert;
	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.test.context.junit4.SpringRunner;

	import tn.esprit.spring.entities.MissionExterne;
	import tn.esprit.spring.entities.Role;
	import tn.esprit.spring.services.IMissionExterneService;

	@RunWith(SpringRunner.class)
	@SpringBootTest
	
	public class MissionExterneServiceTest {
		
		@Autowired
		IMissionExterneService ms ;
		
		@Test
		public void testRetrieveAllMissionExterne() {
			List<MissionExterne> listMissionExterne = ms.retrieveAllMissionExterne();
			// if there are 7 users in DB : 
			Assert.assertEquals(15, listMissionExterne.size());
		}

		@Test
		public void testAddMissionExterne() throws ParseException {
			
			MissionExterne m = new MissionExterne("3046278688391172322L", null, null, 0);
			MissionExterne mission = ms.addMissionExterne(m) ;
			Assert.assertEquals(m.getName(), mission.getName());
		}
		
		@Test
		public void testModifyEmploye() throws ParseException   {
			
			MissionExterne m = new MissionExterne();
			MissionExterne missionModified = ms.updateMissionExterne(m) ;
			Assert.assertEquals(m.getName(), missionModified.getName());
		}
		
		@Test
		public void testDeleteMissionExterne() {
			ms.remove("2");
			Assert.assertNull(ms.retrieveMissionExterne("2"));
			
			
		}
		
	}

}
