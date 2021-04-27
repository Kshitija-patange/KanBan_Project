package com.cg.fsd4.kanban_board.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



@Entity
@Table(name = "team_Lead_info")
@JsonRootName("TeamLeadEntity")
@JsonInclude(content = Include.NON_NULL)
public class TeamLeadEntity  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1267502394698508718L;

	public TeamLeadEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public TeamLeadEntity(String name)
	{
		super();
		this.teamLeaderName=name;
	}
	public TeamLeadEntity(int id ,String name)
	{
		super();
		this.employeeId=id;
		this.teamLeaderName=name;
	}
	

	@Id
	@JsonProperty
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int teamLeaderId;

	@Column
	@JsonProperty
	@NotNull
	private String teamLeaderName;

	@Column
	@JsonProperty
	@NotNull
	private long employeeId;

	@ManyToOne
	@JoinColumn(name = "projectId")
	@JsonIgnoreProperties("teamLeadList")
	private ProjectEntity projectEntity;
	
	@Column
	@JsonProperty
	@NotNull
	private String projectPassword;

	public int getTeamLeaderId() {
		return teamLeaderId;
	}

	public void setTeamLeaderId(int teamLeaderId) {
		this.teamLeaderId = teamLeaderId;
	}

	public String getTeamLeaderName() {
		return teamLeaderName;
	}

	public void setTeamLeaderName(String teamLeaderName) {
		this.teamLeaderName = teamLeaderName;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	

	public ProjectEntity getProjectEntity() {
		return projectEntity;
	}

	public void setProjectEntity(ProjectEntity projectEntity) {
		this.projectEntity = projectEntity;
		projectPassword = this.projectEntity.getProjectPassword();
	}

	public String getProjectPassword() {
		return projectPassword;
	}

	public void setProjectPassword(String projectPassword) {
		this.projectPassword = projectPassword;
	}

	
}
