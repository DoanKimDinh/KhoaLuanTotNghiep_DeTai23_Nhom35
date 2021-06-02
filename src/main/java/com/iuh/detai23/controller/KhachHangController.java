package com.iuh.detai23.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iuh.detai23.entities.KhachHang;
import com.iuh.detai23.entities.NhanVien;
import com.iuh.detai23.entities.QuyenTruyCap;
import com.iuh.detai23.service.KhachHangService;
import com.iuh.detai23.service.NhanVienService;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iuh.detai23.model.CheckRegisterModel;
import com.iuh.detai23.model.DangNhapModel;
import com.iuh.detai23.model.KhachHangModel;
import com.iuh.detai23.model.MonAnModel;
import com.iuh.detai23.model.UpdateKhachHangModel;
import com.iuh.detai23.model.UpdateMonAnModel;
import com.iuh.detai23.service.QuyenTruyCapService;

@Controller
public class KhachHangController {
	@Autowired
	private KhachHangService khachHangService;
	
	@Autowired 
	private QuyenTruyCapService quyenTruyCapService;
	
	@Autowired
	private NhanVienService nhanVienService;

//	@Autowired
//	private ModelAndView modelAndView;

	@GetMapping("/admin/quanlykhachhang")
	public ModelAndView getQuanLyKhachHang(HttpServletRequest request) {
		if(request.getSession().getAttribute("idAdmin") != null) {
			ModelAndView modelAndView = new ModelAndView();
			List<KhachHang> listKhachHang = khachHangService.findAll();
			modelAndView.addObject("listKhachHang",listKhachHang);
			return modelAndView;
		}
		return new ModelAndView("redirect:/");
	}
	@PostMapping("client/dangKyTaiKhoan")
	public String getDangKyTaiKhoan(@ModelAttribute KhachHang khachHang, RedirectAttributes redirectAttributes, HttpServletRequest request) {
		khachHang.setQuyenTruyCap(quyenTruyCapService.findById(1).get());
		khachHangService.save(khachHang);
		redirectAttributes.addFlashAttribute("registerSuccess", "Đăng ký thành công");
		return "redirect:/";
	}
	
	
	@PostMapping("/client/check/dangKyTaiKhoan")
	@ResponseBody
	public CheckRegisterModel checkDangKyTaiKhoan(@RequestBody CheckRegisterModel checkRegis, RedirectAttributes redirectAttributes, HttpServletRequest request) {

		CheckRegisterModel checkRegisterModel = new CheckRegisterModel();
		
		for (KhachHang khachHang : khachHangService.findAll()) {
			if(checkRegis.getAccountString().equals(khachHang.getTenTaiKhoan())) {
				checkRegis.setAccount(false);
			}
			if(checkRegis.getEmailString().equals(khachHang.getEmail())) {
				checkRegis.setEmail(false);
			}
			if(checkRegis.getSdtString().equals(khachHang.getSdt())) {
				checkRegis.setSdt(false);
			}
		}
		
		for (NhanVien nhanVien : nhanVienService.findAll()) {
			if(checkRegis.getAccountString().equals(nhanVien.getTenTaiKhoan())) {
				checkRegis.setAccount(false);
			}
			if(checkRegis.getEmailString().equals(nhanVien.getEmail())) {
				checkRegis.setEmail(false);
			}
			if(checkRegis.getSdtString().equals(nhanVien.getSoDienThoai())) {
				checkRegis.setSdt(false);
			}
		}
		
		return checkRegis;
	}
	
	@GetMapping("client/dangXuat")
	public String destroySession(HttpServletRequest request) {
		if((request.getSession().getAttribute("idAccount")!=null)||(request.getSession().getAttribute("idAdmin")!=null)) {
			request.getSession().removeAttribute("idAccount");
			request.getSession().removeAttribute("idAdmin");
			request.getSession().removeAttribute("idAdminMaster");
		}
		return "redirect:/";
	}
	
	@GetMapping("admin/quanlykhachhang/edit/{id}")
	public ModelAndView getEditKhachHang(@PathVariable("id") int id, HttpServletRequest request) {
		if(request.getSession().getAttribute("idAdmin") != null) {
			ModelAndView modelAndView = new ModelAndView("admin/chinhSuaKhachHang");
			KhachHang khachHang = khachHangService.findById(id);
			UpdateKhachHangModel khacHangModel = new UpdateKhachHangModel(khachHang.getMaKhachHang(),khachHang.getTenKhachHang(), khachHang.getSdt(), khachHang.getEmail(), khachHang.getTenTaiKhoan(), khachHang.getMatKhau(), khachHang.getDiaChi(), khachHang.getQuyenTruyCap().getMaQuyenTruyCap());
			modelAndView.addObject("khachHang", khacHangModel);
			modelAndView.addObject("quyenTruyCap", quyenTruyCapService.findAll());
			
			return modelAndView;
		}
		return new ModelAndView("redirect:/");
	}
	
	@PostMapping("admin/quanlykhachhang/edit/{id}")
	public String getEditKhachHangUpdate(@PathVariable("id") int id, @ModelAttribute UpdateKhachHangModel khachHangModel, RedirectAttributes redirect) {
		KhachHang khachHang = khachHangService.findById(id);
		khachHang.setTenKhachHang(khachHangModel.getTenKhachHang());
		khachHang.setSdt(khachHangModel.getSdt());
		khachHang.setDiaChi(khachHangModel.getDiaChi());
		khachHang.setEmail(khachHangModel.getEmail());
		khachHang.setMatKhau(khachHangModel.getMatKhau());
		khachHangService.save(khachHang);
		redirect.addAttribute("success", "thanhCong");
		
		return "redirect:/admin/quanlykhachhang/";
	}
	
	@PostMapping("/addKhachHang")
	public String addKhacHang(@ModelAttribute KhachHangModel khachHangModel) {
		KhachHang khachHang = new KhachHang();
		khachHang.setTenKhachHang(khachHangModel.getTenKhachHang());
		khachHang.setSdt(khachHangModel.getSdt());
		khachHang.setEmail(khachHangModel.getEmail());
		khachHang.setDiaChi(khachHangModel.getDiaChi());
		khachHang.setTenTaiKhoan(khachHangModel.getTenTaiKhoan());
		khachHang.setMatKhau(khachHangModel.getMatKhau());
		khachHang.setQuyenTruyCap(quyenTruyCapService.findByMaQuyenTruyCap(khachHangModel.getMaQuyenTruyCap()));
		khachHangService.save(khachHang);
		
		return "redirect:/admin/quanlykhachhang";  
	}
}
