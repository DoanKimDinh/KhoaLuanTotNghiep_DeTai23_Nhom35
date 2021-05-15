package com.iuh.detai23.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iuh.detai23.entities.KhachHang;
import com.iuh.detai23.entities.NhanVien;
import com.iuh.detai23.model.DangNhapModel;
import com.iuh.detai23.service.DangNhapService;
import com.iuh.detai23.service.KhachHangService;

@Controller
public class DangNhapController {
	
	@Autowired
	private KhachHangService khachHangService;
	
	/*
	 * @Autowired private QuyenTruyCapService quyenTruyCapService;
	 */
	
	@Autowired
	private DangNhapService dangNhapService;
	
	@PostMapping("/user/dangNhap")
	public String userDangNhap(DangNhapModel dangNhapModel,RedirectAttributes redirectAttributes, HttpServletRequest request) {
		int flag = dangNhapService.checkUserDangNhap(dangNhapModel);
		if(flag == 1) {
			KhachHang kh = dangNhapService.getKhachHangByTenTaiKhoan(dangNhapModel.getTenDangNhap());
			request.getSession().setAttribute("idAccount", kh.getMaKhachHang());
			redirectAttributes.addFlashAttribute("message", "Thêm thành công");
		} else if(flag == 2) {
			NhanVien nv = dangNhapService.getNhanVienByTenTaiKhoan(dangNhapModel.getTenDangNhap());
			request.getSession().setAttribute("idAccount", nv.getMaNhanVien());
			request.getSession().setAttribute("idAdmin", nv.getMaNhanVien());
			redirectAttributes.addFlashAttribute("message", "Thêm thành công");
		}
		return "redirect:/";
	}
}