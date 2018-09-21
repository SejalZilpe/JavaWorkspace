package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
import com.beans.VngMem;
 
@Controller
public class JBTJdbcController {
 
	@Autowired
	com.service.SpringJdbcService Service;
 
	@RequestMapping(value = "/searchJdbcContact", method = RequestMethod.GET)
	public ModelAndView searchContact() {
		ModelAndView mav = new ModelAndView("JdbcSearch");
		VngMem bean = new VngMem(null, null, null, null, null, 0, null);
 
		mav.addObject("searchUserGet", bean);
		return mav;
	}
 
	@RequestMapping(value = "/searchJdbcContact", method = RequestMethod.POST)
	public ModelAndView searchContact(
			@ModelAttribute("searchlist2") VngMem vngmem) {
		ModelAndView mav = new ModelAndView("JdbcSearchResult");
 
		VngMem bean1 = null;
		try {
			bean1 = Service.searchMemDts(vngmem);
		} catch (Exception e) {
		}
 
		mav.addObject("searchResultPost", bean1);
		return mav;
	}
 
	@RequestMapping(value = "/insertJdbcContact", method = RequestMethod.GET)
	public ModelAndView insertMemDtls() {
		ModelAndView mav = new ModelAndView("JdbcInsert");
 
		VngMem bean = new VngMem(null, null, null, null, null, 0, null);
		mav.addObject("insertUser", bean);
		mav.addObject("status", "success");
		return mav;
	}
 
	@RequestMapping(value = "/insertJdbcContact", method = RequestMethod.POST)
	public ModelAndView insertContact(
			@ModelAttribute("insertUser") VngMem vngmem) {
		ModelAndView mav = new ModelAndView("JdbcInsert");
		try {
			Service.insertMemDts(vngmem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("searchResultPost", vngmem);
		return mav;
	}
}
