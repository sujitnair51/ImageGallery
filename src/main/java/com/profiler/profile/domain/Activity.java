package com.profiler.profile.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="ACTIVITY")
public class Activity {

	@Id
	@Column(name = "ACTIVITY_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long activityId;
	
	@Column(name = "RESOURCE_ID")
	private int resourceId;
	
	@Column(name = "ACTIVITY_NAME")
	private String activityName;
	
	@Column(name = "ACTIVITY_DESC")
	private String activityDescription;
	
	@Column(name = "IMG_SOLO_URL")
	private String imgSoloUrl;
	
	@Column(name = "IMG_GRP_URL")
	private String imgGrpUrl;
	
	@Column(name = "IMG_SOLO_NO")
	private int imgSoloNo;
	
	@Column(name = "IMG_GRP_NO")
	private int imgGrpNo;
	
	@Column(name = "VDO_SOLO_URL")
	private String vdoSoloUrl;
	
	@Column(name = "VDO_GRP_URL")
	private String vdoGrpUrl;
	
	@Column(name = "INTRO_URL")
	private String intoUrl;
	
	@ManyToMany(mappedBy="activities")
    private List<Resource> resources = new ArrayList<Resource>();

	public long getActivityId() {
		return activityId;
	}

	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityDescription() {
		return activityDescription;
	}

	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	public String getImgSoloUrl() {
		return imgSoloUrl;
	}

	public void setImgSoloUrl(String imgSoloUrl) {
		this.imgSoloUrl = imgSoloUrl;
	}

	public String getImgGrpUrl() {
		return imgGrpUrl;
	}

	public void setImgGrpUrl(String imgGrpUrl) {
		this.imgGrpUrl = imgGrpUrl;
	}

	public int getImgSoloNo() {
		return imgSoloNo;
	}

	public void setImgSoloNo(int imgSoloNo) {
		this.imgSoloNo = imgSoloNo;
	}

	public int getImgGrpNo() {
		return imgGrpNo;
	}

	public void setImgGrpNo(int imgGrpNo) {
		this.imgGrpNo = imgGrpNo;
	}

	public String getVdoSoloUrl() {
		return vdoSoloUrl;
	}

	public void setVdoSoloUrl(String vdoSoloUrl) {
		this.vdoSoloUrl = vdoSoloUrl;
	}

	public String getVdoGrpUrl() {
		return vdoGrpUrl;
	}

	public void setVdoGrpUrl(String vdoGrpUrl) {
		this.vdoGrpUrl = vdoGrpUrl;
	}

	public String getIntoUrl() {
		return intoUrl;
	}

	public void setIntoUrl(String intoUrl) {
		this.intoUrl = intoUrl;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
	
	
}
