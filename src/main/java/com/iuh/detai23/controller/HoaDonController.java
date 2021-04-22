package com.iuh.detai23.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iuh.detai23.entities.HoaDon;
import com.iuh.detai23.entities.MonAn;
import com.iuh.detai23.service.HoaDonService;

@Controller
public class HoaDonController {
	
	@Autowired
	private HoaDonService hoaDonService;
	
	@GetMapping("admin/hoadon")
	public ModelAndView getHoaDon() {
		ModelAndView modelAndView = new ModelAndView("admin/hoadon");
		List<HoaDon> hoaDon = hoaDonService.findAll();
		modelAndView.addObject("listHoaDon", hoaDon);
		return modelAndView;
	}
	
	@GetMapping("admin/getHoaDon/{id}")
	@ResponseBody
	public HoaDon getGetHoaDon(@PathVariable("id") String id) {
		//System.out.println(postM);
		//postService.deletePost(postModel.getId());
		HoaDon hoaDon = hoaDonService.findById(Integer.valueOf(id)).get();
		return hoaDon;
	}
}
