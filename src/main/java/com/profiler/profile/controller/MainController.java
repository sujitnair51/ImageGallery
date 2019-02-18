package com.profiler.profile.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.profiler.profile.domain.Activity;
import com.profiler.profile.domain.Resource;
import com.profiler.profile.repository.ActivityRepository;
import com.profiler.profile.repository.ResourceRepository;
import com.profiler.profile.utility.ImageFileReader;

@Controller
public class MainController {
	
	@Autowired
	private ImageFileReader imageFileReader;
	
	@Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
private ResourceRepository resourceRepository;
	
	@Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
private ActivityRepository activityRepository;
	
	private static List<Resource> stars = new ArrayList<Resource>();
	
	
	static {
		

	}
	
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("isChecked", true);
		Map<String, Resource> starMap = new HashMap<>();
		
		for(Resource resource : stars) {
			//starMap.put(star.getId(), star);
		}
		model.addAttribute("resources", starMap);
		return "index";
	}
	
	@RequestMapping(value = "/profile/{id}")
	public String profile(Model model, @PathVariable("id") String id) {
		model.addAttribute("isChecked", true);
		
		Map<Long, Activity> activityMap = new HashMap<>();
		Resource resource = resourceRepository.findById(Integer.parseInt(id)).get();
		
		Activity activity1 = new Activity();
		activity1.setActivityName("Activity1");
		activity1.setActivityDescription("New Activity");
		activity1.setIntoUrl("/static/charlie/scenes/scene1/intro/intro.jpg");
		activity1.setImgGrpNo(1);
		activity1.setImgGrpUrl("/static/charlie/scenes/scene1/intro/intro.jpg");
		activity1.setImgSoloNo(1);
		activity1.setImgSoloUrl("/static/charlie/scenes/scene1/intro/intro.jpg");
		activity1.setVdoGrpUrl("/static/charlie/scenes/scene1/intro/intro.jpg");
		activity1.setVdoSoloUrl("/static/charlie/scenes/scene1/intro/intro.jpg");
		
		resource.getActivities().add(activity1);
		
		model.addAttribute("profileUrl", resource.getProfileUrl());
		model.addAttribute("resourceName", resource.getResourceName());
		model.addAttribute("resourceIntro", resource.getResourceIntro());
		
		resource = resourceRepository.save(resource);
		List<Activity> activityList = resource.getActivities();		

		model.addAttribute("activities", activityList);

		return "profile";
	}
	
	@RequestMapping(value = "/profile/{activityId}/gallary/{type}")
	public String gallery(Model model, @PathVariable("activityId") String activityId, @PathVariable("type") String type) {
		
		Activity activity = activityRepository.findById(Long.parseLong(activityId)).get();
		if(type.equalsIgnoreCase("solo")) {
			model.addAttribute("noi", Integer.toString(activity.getImgSoloNo()));
			model.addAttribute("images", activity.getImgSoloUrl());
			model.addAttribute("activityId", activityId);
		}
		
		return "gallery";
	}	
	
	@RequestMapping(value = "/profile/{activityId}/gallary/{type}/view/{imageNo}")
	public String viewImage(Model model, @PathVariable("activityId") String activityId, @PathVariable("type") String type, @PathVariable("imageNo") String imageNo) {
		
		Activity activity = activityRepository.findById(Long.parseLong(activityId)).get();
		if(type.equalsIgnoreCase("solo")) {
			model.addAttribute("noi", Integer.toString(activity.getImgSoloNo()));
			model.addAttribute("images", activity.getImgSoloUrl());
			model.addAttribute("imageNo", imageNo);
		}
		
		return "view";
	}	

	
	@RequestMapping(path="/stars", method=RequestMethod.POST) // Map ONLY GET Requests
	public @ResponseBody String addNewStar (@RequestBody Resource resource) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Resource n = new Resource();
		n.setResourceName(resource.getResourceName());
		n.setProfileUrl(resource.getProfileUrl());
		n.setResourceIntro(resource.getResourceIntro());
		n.setRating(resource.getRating());
		n.setActivities(resource.getActivities());
		resourceRepository.save(n);
		return "Saved";
	}

	@GetMapping(path="/all")
	public String getAllStars(Model model) {
		// This returns a JSON or XML with the users
		
		 Activity activity1 = new Activity();
		 
			activity1.setActivityName("Activity1");
			activity1.setActivityDescription("New Activity");
			activity1.setIntoUrl("/static/charlie/scenes/scene1/intro/intro.jpg");
			activity1.setImgGrpNo(1);
			activity1.setImgGrpUrl("/static/charlie/scenes/scene1/intro/intro.jpg");
			activity1.setImgSoloNo(10);
			activity1.setImgSoloUrl("/static/charlie/scenes/scene1/solo");
			activity1.setVdoGrpUrl("/static/charlie/scenes/scene1/intro/intro.jpg");
			activity1.setVdoSoloUrl("/static/charlie/scenes/scene1/intro/intro.jpg");
			
			Resource resource1 = new Resource();
			resource1.setResourceName("Charlie");
			resource1.setResourceIntro("Charle");
			resource1.setRating("5");
			resource1.setProfileUrl("/static/charlie/profile/profile.jpg");
			resource1.getActivities().add(activity1);
			
			resourceRepository.save(resource1);
		
		
		
		
		model.addAttribute("isChecked", true);
		Map<Integer, Resource> starMap = new HashMap<>();
		//Map<String, String> imgList = new Hash<>();
		Iterable<Resource> starListIterable = resourceRepository.findAll();
		
				
		for(Resource star : starListIterable) {
			starMap.put(star.getResourceID(), star);
			System.out.println(star.getProfileUrl());
		}
		model.addAttribute("resources", starMap);
		return "index";
	
	}

}
