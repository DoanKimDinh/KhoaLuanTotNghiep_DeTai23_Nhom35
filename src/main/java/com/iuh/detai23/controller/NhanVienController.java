package com.iuh.detai23.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iuh.detai23.entities.NhanVien;
import com.iuh.detai23.model.NhanVienModel;
import com.iuh.detai23.model.UpdateKhachHangModel;
import com.iuh.detai23.model.UpdateNhanVienModel;
import com.iuh.detai23.service.NhanVienService;
import com.iuh.detai23.service.QuyenTruyCapService;

@Controller
public class NhanVienController {
	@Autowired
	private NhanVienService nhanVienService;
	
	@Autowired 
	private QuyenTruyCapService quyenTruyCapService;
	
	@GetMapping("admin/quanlynhanvien")
	public ModelAndView getQuanLyNhanVien(HttpServletRequest request) {
		if(request.getSession().getAttribute("idAdmin") != null) {
			ModelAndView modelAndView = new ModelAndView("admin/quanLyNhanVien");
			List<NhanVien> listNhanVien = nhanVienService.findAll();
			modelAndView.addObject("listNhanVien", listNhanVien);
			return modelAndView;
		}
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping("admin/quanlynhanvien/edit/{id}")
	public ModelAndView getEditNhanVien(@PathVariable("id") int id, HttpServletRequest request) {
		if(request.getSession().getAttribute("idAdmin") != null) {
			ModelAndView modelAndView = new ModelAndView("admin/chinhSuaNhanVien");
			NhanVien nhanVien = nhanVienService.findById(id);
			UpdateNhanVienModel nhanVienModel = new UpdateNhanVienModel(nhanVien.getMaNhanVien(), nhanVien.getTenNhanVien(), nhanVien.getSoDienThoai(), nhanVien.getEmail(), nhanVien.getChungMinhNhanDan(), nhanVien.getDiaChi(), nhanVien.getGioiTinh(), nhanVien.getTenTaiKhoan(), nhanVien.getMatKhau());
			modelAndView.addObject("nhanVien", nhanVienModel);
			return modelAndView;
		}
		return new ModelAndView("redirect:/");
	}
	
	@PostMapping("admin/quanlynhanvien/edit/{id}")
	public String getEditNhanVienUpdate(@PathVariable("id") int id, @ModelAttribute UpdateNhanVienModel nhanVienModel, RedirectAttributes redirect) {
		NhanVien nhanVien = nhanVienService.findById(id);
		nhanVien.setTenNhanVien(nhanVienModel.getTenNhanVien());
		nhanVien.setSoDienThoai(nhanVienModel.getSoDienThoai());
		nhanVien.setEmail(nhanVienModel.getEmail());
		nhanVien.setChungMinhNhanDan(nhanVienModel.getChungMinhNhanDan());
		nhanVien.setDiaChi(nhanVienModel.getDiaChi());
		nhanVien.setMatKhau(nhanVienModel.getMatKhau());
		nhanVienService.save(nhanVien);
		redirect.addAttribute("success", "thanhCong");
		
		return "redirect:/admin/quanlynhanvien";
	}
	
	@PostMapping("/addNhanVien")
	public String addNhanVien(@ModelAttribute NhanVienModel nhanVienModel) {
		NhanVien nhanVien = new NhanVien();
		nhanVien.setTenNhanVien(nhanVienModel.getTenNhanVien());
		nhanVien.setSoDienThoai(nhanVienModel.getSoDienThoai());
		nhanVien.setEmail(nhanVienModel.getEmail());
		nhanVien.setChungMinhNhanDan(nhanVienModel.getChungMinhNhanDan());
		nhanVien.setDiaChi(nhanVienModel.getDiaChi());
		nhanVien.setGioiTinh(nhanVienModel.getGioiTinh());
		nhanVien.setTenTaiKhoan(nhanVienModel.getTenTaiKhoan());
		nhanVien.setMatKhau(nhanVienModel.getMatKhau());
		nhanVien.setQuyenTruyCap(quyenTruyCapService.findByMaQuyenTruyCap(nhanVienModel.getMaQuyenTruyCap()));
		nhanVienService.save(nhanVien);
		
		return "redirect:/admin/quanlynhanvien";
	}
}



