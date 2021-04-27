package com.cg.fsd4.kanban_board.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.fsd4.kanban_board.entity.ProjectEntity;
import com.cg.fsd4.kanban_board.entity.TeamLeadEntity;
import com.cg.fsd4.kanban_board.exception.TeamLeadNotFoundException;
import com.cg.fsd4.kanban_board.repo.ProjectRepo;
import com.cg.fsd4.kanban_board.repo.TeamLeadRepo;
import com.cg.fsd4.kanban_board.services.TeamLeadService;
import com.cg.fsd4.kanban_board.services.TeamLeadServiceImpl;

import static org.mockito.BDDMockito.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TeamLeadServiceImplIntegrationTest {

	@TestConfiguration
	static class teamLeadServiceImplTestContextConfiguration {

		@Bean
		public TeamLeadService teamLeadService()
		{
			return new TeamLeadServiceImpl();
		}
	}

	@Autowired
	private TeamLeadService teamLeadService;

	@MockBean
	private TeamLeadRepo teamLeadRepo;
	
	@MockBean
	private ProjectRepo projectRepo;

	@Test
    public void getTeamLeadByIdTest()
    {
      
		Mockito.when(teamLeadRepo.findById(1)).thenReturn(Optional.of(new TeamLeadEntity("Kshitija")));
        
        TeamLeadEntity teamLead=teamLeadService.viewTeamLeadById(1);
        
        assertEquals("Kshitija", teamLead.getTeamLeaderName());
        
    }
	@Test
	public void NotgetTeamLeadByIdTest()
	{
		Mockito.when(teamLeadRepo.findById(1)).thenReturn(Optional.empty());
		
		TeamLeadEntity teamLead=teamLeadService.viewTeamLeadById(1);
	}
	@Test
	public void getAllTeamLead()
	{
		Mockito.when(teamLeadRepo.findAll()).thenReturn(Arrays.asList(
				new TeamLeadEntity("Kshitija"),
				new TeamLeadEntity("Bhavana"),
				new TeamLeadEntity("Yash")
				));
		
		List <TeamLeadEntity> list=teamLeadService.getAllTeamLead();
		assertEquals("Kshitija",list.get(0).getTeamLeaderName());
		assertEquals("Bhavana",list.get(1).getTeamLeaderName());
		assertEquals("Yash",list.get(2).getTeamLeaderName());
	}
	
//	@Test
//	public void updateProjectStatus()
//	{
//		ProjectEntity project =new ProjectEntity(1,"Started","React Project");
//		given(projectRepo.save(project)).willReturn(project);
//		
//		final ProjectEntity expected=teamLeadService.UpdateStatus(project.getProjectStatus(),project.getProjectId());
//		assertThat(expected).isNotNull();
//	
//		
//	}
}
