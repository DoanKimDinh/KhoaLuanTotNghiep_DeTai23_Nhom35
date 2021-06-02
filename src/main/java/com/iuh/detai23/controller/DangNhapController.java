package com.iuh.detai23.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iuh.detai23.entities.KhachHang;
import com.iuh.detai23.entities.NhanVien;
import com.iuh.detai23.entities.QuyenTruyCap;
import com.iuh.detai23.model.DangNhapModel;
import com.iuh.detai23.service.DangNhapService;
import com.iuh.detai23.service.KhachHangService;
import com.iuh.detai23.type.TypeGioiTinh;

import lombok.Data;



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
			request.getSession().setAttribute("userName", kh.getTenKhachHang());
			redirectAttributes.addFlashAttribute("message", "Đăng nhập thành công");
		} else if(flag == 2) {
			NhanVien nv = dangNhapService.getNhanVienByTenTaiKhoan(dangNhapModel.getTenDangNhap());
			request.getSession().setAttribute("idAccount", nv.getMaNhanVien());
			request.getSession().setAttribute("idAdmin", nv.getMaNhanVien());
			request.getSession().setAttribute("userName", nv.getTenNhanVien());
			redirectAttributes.addFlashAttribute("message", "Đăng nhập thành công");
		}
		else if(flag==3) {
			NhanVien nv = dangNhapService.getNhanVienByTenTaiKhoan(dangNhapModel.getTenDangNhap());
			request.getSession().setAttribute("idAccount", nv.getMaNhanVien());
			request.getSession().setAttribute("idAdmin", nv.getMaNhanVien());
			request.getSession().setAttribute("idAdminMaster", nv.getMaNhanVien());
			request.getSession().setAttribute("userName", nv.getTenNhanVien());
			redirectAttributes.addFlashAttribute("message", "Đăng nhập thành công");
		}
		else if(flag == 0) {
//			request.getSession().setAttribute("idUser", "Không thành công");
			redirectAttributes.addFlashAttribute("faild", "Đăng nhập không thành công");
		}
		
		return "redirect:/";
	}
	
}
