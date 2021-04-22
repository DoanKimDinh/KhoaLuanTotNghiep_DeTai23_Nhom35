package com.iuh.detai23.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iuh.detai23.entities.NhanVien;
import com.iuh.detai23.service.NhanVienService;

@Controller
public class NhanVienController {
	@Autowired
	private NhanVienService nhanVienService;
	
	@GetMapping("admin/quanlynhanvien")
	public ModelAndView getQuanLyNhanVien() {
		ModelAndView modelAndView = new ModelAndView("admin/quanLyNhanVien");
		List<NhanVien> listNhanVien = nhanVienService.findAll();
		modelAndView.addObject("listNhanVien", listNhanVien);
		return modelAndView;
	}
}
