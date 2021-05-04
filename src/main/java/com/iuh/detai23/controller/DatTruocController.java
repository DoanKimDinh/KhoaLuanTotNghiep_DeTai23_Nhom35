package com.iuh.detai23.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.TemplateEngine;

import com.iuh.detai23.entities.HoaDon;
import com.iuh.detai23.entities.KhachHang;
import com.iuh.detai23.model.BanDatTruocAddModel;
import com.iuh.detai23.service.KhachHangService;
import com.iuh.detai23.service.MonAnService;


@Controller
public class DatTruocController {
	@Autowired
	private MonAnService monAnService;

	@Autowired
	private TemplateEngine engine;

	@Autowired
	private KhachHangService khachHangService;

	@GetMapping("client/datBan")
	public ModelAndView getDatBan(HttpServletRequest request) {
//		System.out.println(engine.getTemplateResolvers().);
		System.out.println("doan kimd inh");
		ModelAndView modelAndView = new ModelAndView("datban");
		try {
			if(request.getSession().getAttribute("idAccount")!=null) {
				int id = (int)request.getSession().getAttribute("idAccount");
				KhachHang kh = khachHangService.findById(id).get();
				System.out.println(kh);
				modelAndView.addObject("khachHang", kh);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		//System.out.println(id+"============>");
		//	modelAndView.addObject("datBan",new BanDatTruocAddModel());
		return modelAndView;
	} 

	@PostMapping("datBan")
	public String getAddDatBan(@ModelAttribute BanDatTruocAddModel banDatTruoc) {
		System.out.println(banDatTruoc.getDiaChi());
		System.out.println(banDatTruoc.getGhiChu());
		System.out.println(banDatTruoc.getNgayDen());
		System.out.println(banDatTruoc.getSoNguoi());
		System.out.println(banDatTruoc.getThoiGianDen());
		return "redirect:\\";
	}

}