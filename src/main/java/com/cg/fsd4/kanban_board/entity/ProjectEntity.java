package com.cg.fsd4.kanban_board.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



@Entity
@Table(name = "project_info")
@JsonRootName("ProjectEntity")
@JsonInclude(content = Include.NON_NULL)
public class ProjectEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3026639104601499038L;

	public ProjectEntity() {

	}
	public ProjectEntity(int id ,String status ,String name) {

		super();
		this.projectId=id;
		this.projectName=name;
		this.projectStatus=status;
	}

	@Id
	@JsonProperty
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int projectId;

	@Column
	@JsonProperty
	@NotNull
	private String projectName;

	@Column
	@JsonProperty
	@NotNull
	private String projectDescription;
	

	@Column
	@JsonProperty
	@NotNull
	private String projectStatus;

	@Column
	@JsonProperty
	@NotNull
	@JsonFormat(pattern="yyyy-mm-dd")
	private Date startDate;

	@Column
	@JsonProperty
	@NotNull
	@JsonFormat(pattern="yyyy-mm-dd")
	private Date endDate; 
	
	@Column
	@JsonProperty
	@NotNull
	private String projectPassword; 
	
	@ManyToOne
	@JoinColumn(name = "userId")
	@JsonIgnoreProperties("projectList")
	@JsonIgnore
	private UserEntity userEntity;
	
	@OneToMany(mappedBy="projectEntity" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("projectEntity")
	@JsonIgnore
	private List<TeamMemberEntity> teamMemberList;
	
	@OneToMany(mappedBy="projectEntity" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("projectEntity")
	@JsonIgnore
	private List<TeamLeadEntity> teamLeadList;

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public List<TeamMemberEntity> getTeamMemberList() {
		return teamMemberList;
	}

	public void setTeamMemberList(List<TeamMemberEntity> teamMemberList) {
		this.teamMemberList = teamMemberList;
	}


	

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public List<TeamLeadEntity> getTeamLeadList() {
		return teamLeadList;
	}

	public void setTeamLeadList(List<TeamLeadEntity> teamLeadList) {
		this.teamLeadList = teamLeadList;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getProjectPassword() {
		return projectPassword;
	}

	public void setProjectPassword(String projectPassword) {
		this.projectPassword = projectPassword;
	}

}
