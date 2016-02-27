/**
 * 
 */
package com.fundit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fundit.beans.FundingBean;
import com.fundit.beans.ProjectBean;
import com.fundit.services.FundService;

/**
 * @author Kashif
 *
 */
@Controller
public class FundController {
	
	@Autowired
	private FundService fundService;
	
	@RequestMapping(value = "/fund", method = RequestMethod.GET)
	public ModelAndView fundPage(HttpServletRequest request,
			HttpServletResponse response, FundingBean fundingBean) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("AddFund");
		model.addObject("fundingBean", fundingBean);
		return model;

	}
	
	@RequestMapping(value = "/fund/add", method = RequestMethod.POST)
	public ModelAndView addFund(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("fundingBean") com.fundit.beans.FundingBean fundingBean) {
		
		ModelAndView model = new ModelAndView();
		System.out.println("Title: "+ fundingBean.getFund_added());
		fundingBean.setUser_id(request.getSession().getAttribute("loggedInUser").toString());
		
		if(fundService.addFund(fundingBean)){
			request.setAttribute("message", "Successfully add Fund to Project!!!");
			model.setViewName("Dashboard");
			model.addObject("fundingBean", fundingBean);
		}else{
			request.setAttribute("message", "Failed in adding fund toproject, please try again!!!");
			model.setViewName("Dashboard");
			model.addObject("fundingBean", fundingBean);
		}
		return model;
	}
	
	@RequestMapping(value = "/fund/{projectId}", method = RequestMethod.GET)
	public ModelAndView getFundByProjectId(@PathVariable("projectId") int projectId){
		
		System.out.println("projectId: "+ projectId);
		List<FundingBean> fundBeans= fundService.getAllFundsByProjectId(projectId);
		

		ModelAndView model = new ModelAndView();
		model.addObject(fundBeans);
		
		return model;
	}
	
	@RequestMapping(value = "/fund/{userId}", method = RequestMethod.GET)
	public ModelAndView getFundByUserId(@PathVariable("userId") int userId){
		
		System.out.println("userId: "+ userId);
		List<FundingBean> fundBeans= fundService.getAllFundsByUserId(userId);
		

		ModelAndView model = new ModelAndView();
		model.addObject(fundBeans);
		
		return model;
	}
	
	
	

}	
