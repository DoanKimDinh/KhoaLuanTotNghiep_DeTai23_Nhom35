package com.iuh.detai23.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iuh.detai23.entities.KhachHang;
import com.iuh.detai23.entities.QuyenTruyCap;
import com.iuh.detai23.service.KhachHangService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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

//	@Autowired
//	private ModelAndView modelAndView;

	@GetMapping("/admin/quanlykhachhang")
	public ModelAndView getQuanLyKhachHang() {
		ModelAndView modelAndView = new ModelAndView();
		List<KhachHang> listKhachHang = khachHangService.findAll();
		modelAndView.addObject("listKhachHang",listKhachHang);
		return modelAndView;
	}
	@PostMapping("client/dangKyTaiKhoan")
	public String getDangKyTaiKhoan(@ModelAttribute KhachHang khachHang, RedirectAttributes redirectAttributes, HttpServletRequest request) {
	//	ModelAndView modelAndView = new ModelAndView("");
		System.out.println(khachHang.getDiaChi());
		System.out.println(khachHang.getEmail());
		System.out.println(khachHang.getSdt());
		System.out.println(khachHang.getTenKhachHang());
		System.out.println(khachHang.getTenTaiKhoan());
		System.out.println(khachHang.getMatKhau());
		khachHang.setQuyenTruyCap(quyenTruyCapService.findById(1).get());

		//int id = (int) request.getSession().getAttribute("id");
		//System.out.println(id);
		KhachHang kh = khachHangService.save(khachHang);
		if(kh!=null) {
			//redirectAttributes.addFlashAttribute("message", "Thêm thành công");
			//request.getSession().setAttribute("id", kh.getMaKhachHang());
		}


		return "redirect:/";
	}
	
//	  @PostMapping("client/dangNhap") public String getDangNhap(DangNhapModel
//	  dangNhapModel,RedirectAttributes redirectAttributes, HttpServletRequest
//	  request) { boolean flag = khachHangService.checkDangNhap(dangNhapModel);
//	  System.out.println("hello"); if(flag) { KhachHang kh =
//	  khachHangService.getKhachHangByAccount(dangNhapModel.getTenDangNhap());
//	  //redirectAttributes.addFlashAttribute("idAccount", kh.getMaKhachHang());
//	  request.getSession().setAttribute("idAccount", kh.getMaKhachHang());
//	  System.out.println("da vao nha");
//	  redirectAttributes.addFlashAttribute("message", "Thêm thành công"); }
//	  
//	  return "redirect:/"; }
	 

	@GetMapping("client/dangXuat")
	public String destroySession(HttpServletRequest request) {
		if(request.getSession().getAttribute("idAccount")!=null) {
			request.getSession().removeAttribute("idAccount");
			request.getSession().removeAttribute("idAdmin");
		}
		return "redirect:/";
	}
	
	@GetMapping("admin/quanlykhachhang/edit/{id}")
	public ModelAndView getEditKhachHang(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView("admin/chinhSuaKhachHang");
		KhachHang khachHang = khachHangService.findById(id);
		UpdateKhachHangModel khacHangModel = new UpdateKhachHangModel(khachHang.getMaKhachHang(),khachHang.getTenKhachHang(), khachHang.getSdt(), khachHang.getEmail(), khachHang.getTenTaiKhoan(), khachHang.getMatKhau(), khachHang.getDiaChi(), khachHang.getQuyenTruyCap().getMaQuyenTruyCap());
		modelAndView.addObject("khachHang", khacHangModel);
		modelAndView.addObject("quyenTruyCap", quyenTruyCapService.findAll());
		
		return modelAndView;
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
