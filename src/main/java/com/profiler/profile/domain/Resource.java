package com.profiler.profile.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cascade;

@Entity(name = "RESOURCE") 
public class Resource {

	@Id
	@Column(name = "RESOURCE_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int resourceID;
	
	@Column(name = "RESOURCE_NAME")
	private String resourceName;
	
	@Column(name = "PROFILE_URL")
	private String profileUrl;
	
	@Column(name = "RESOURCE_INTRO")
	private String resourceIntro;
	
	@Column(name = "RATING")
	private String rating;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="RES_ACTIVITY",
    joinColumns=
    @JoinColumn(name="RESOURCE_ID"),
inverseJoinColumns=
    @JoinColumn(name="ACTIVITY_ID")
)
	private List<Activity> activities = new ArrayList<Activity>(); 

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public int getResourceID() {
		return resourceID;
	}

	public void setResourceID(int resourceID) {
		this.resourceID = resourceID;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getResourceIntro() {
		return resourceIntro;
	}

	public void setResourceIntro(String resourceIntro) {
		this.resourceIntro = resourceIntro;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	
	
	

}
