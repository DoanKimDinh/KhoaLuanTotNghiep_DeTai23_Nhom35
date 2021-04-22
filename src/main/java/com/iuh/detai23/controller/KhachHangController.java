package com.iuh.detai23.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ListFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iuh.detai23.entities.KhachHang;
import com.iuh.detai23.service.KhachHangService;

@Controller
public class KhachHangController {
	@Autowired
	private KhachHangService khachHangService;
	
	@GetMapping("admin/quanlykhachhang")
	public ModelAndView getQuanLyKhachHang() {
		ModelAndView modelAndView = new ModelAndView();
		List<KhachHang> listKhachHang = khachHangService.findAll();
		modelAndView.addObject("listKhachHang",listKhachHang);
		return modelAndView;
	}
}
