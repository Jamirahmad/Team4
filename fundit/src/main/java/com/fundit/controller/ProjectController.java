/**
 * 
 */
package com.fundit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fundit.beans.LoginBean;
import com.fundit.beans.ProjectBean;
import com.fundit.services.ProjectService;
import com.fundit.utils.JacksonJsonMapper;

/**
 * @author Kashif
 *
 */
@Controller
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request,
			HttpServletResponse response, ProjectBean projectBean) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("CreateProj");
		model.addObject("projectBean", projectBean);
		return model;

	}
	
	@RequestMapping(value = "/project/add", method = RequestMethod.POST)
	public ModelAndView addProject(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("projectBean") com.fundit.beans.ProjectBean projectBean) {
		
		ModelAndView model = new ModelAndView();
		System.out.println("Title: "+ projectBean.getProject_title());
		projectBean.setUser_id(request.getSession().getAttribute("loggedInUser").toString());
		
		if(projectService.addProject(projectBean)){
			request.setAttribute("message", "Successfully add business proposal!!!");
			model.setViewName("CreateProj");
			model.addObject("projectBean", projectBean);
		}else{
			request.setAttribute("message", "Failed in adding project, please try again!!!");
			model.setViewName("CreateProj");
			model.addObject("projectBean", projectBean);
		}
		return model;
	}
	
	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET)
	public ModelAndView getProject(@PathVariable("projectId") int projectId){
		
		System.out.println("projectId: "+ projectId);
		ProjectBean projectBean = projectService.getProject(projectId);
		System.out.println("Project Title: "+ projectBean.getProject_title());

		ModelAndView model = new ModelAndView();
		model.addObject(projectBean);
		
		return model;
	}
	
	@RequestMapping(value = "/project/all", method = RequestMethod.GET)
	public ModelAndView getAllProject(HttpServletRequest request,
			HttpServletResponse response){

		List<ProjectBean> projectBeans = projectService.getAllProject();
		ModelAndView model = new ModelAndView("Explore");
		model.addObject("projectBeans",projectBeans);
		
		return model;
	}
	
	/*@RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET)
	public HttpEntity<ProjectBean> getProject(@PathVariable("projectId") int projectId){
		
		System.out.println("projectId: "+ projectId);
		ProjectBean projectBean = projectService.getProject(projectId);
		System.out.println("Project Title: "+ projectBean.getProject_title());
		
		HttpEntity<ProjectBean> entity = JacksonJsonMapper.createEntity(projectBean);
		System.out.println("JSON ==> "+ entity);
		//ModelAndView model = new ModelAndView();
		return entity;
	}
	
	@RequestMapping(value = "/project/all", method = RequestMethod.GET)
	public HttpEntity<List<ProjectBean>> getAllProject(HttpServletRequest request,
			HttpServletResponse response){

		List<ProjectBean> projectBeans = projectService.getAllProject();
		HttpEntity<List<ProjectBean>> entity = JacksonJsonMapper.createEntity(projectBeans);
		System.out.println("JSON ==> "+ entity);
		return entity;
	}*/
	

}	
