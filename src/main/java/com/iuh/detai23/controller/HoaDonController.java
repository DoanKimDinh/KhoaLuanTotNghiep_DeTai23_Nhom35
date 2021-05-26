package com.iuh.detai23.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iuh.detai23.entities.ChiTietHoaDon;
import com.iuh.detai23.entities.HoaDon;
import com.iuh.detai23.entities.MonAn;
import com.iuh.detai23.model.AddMonAnModel;
import com.iuh.detai23.model.ChiTietHoaDonModel;
import com.iuh.detai23.model.ChiTietMonAnModel;
import com.iuh.detai23.service.HoaDonService;
import com.iuh.detai23.service.KhachHangService;
import com.iuh.detai23.service.MonAnService;

@Controller
public class HoaDonController {
	
	@Autowired
	private HoaDonService hoaDonService;
	
	@Autowired
	private MonAnService monAnService;
	
	@Autowired
	private KhachHangService khachHangService;
	
	@GetMapping("admin/hoadon")
	public ModelAndView getHoaDon() {
		ModelAndView modelAndView = new ModelAndView("admin/hoadon");
		List<HoaDon> hoaDon = hoaDonService.findAll();
		modelAndView.addObject("listHoaDon", hoaDon);
		return modelAndView;
	}
	
	@GetMapping("/admin/hoadon/thongke/thang/{year}/{month}")
	public ModelAndView getHoaDon(@PathVariable("year") int year, @PathVariable("month") int month) {
		ModelAndView modelAndView = new ModelAndView("admin/thongke");
		double moneytotal = hoaDonService.getTotalMoney();
		
		modelAndView.addObject("totalMoney", moneytotal);
		return modelAndView;
	}
	
	@PostMapping("/admin/hoadon/thongke/thang")
	public ModelAndView getHoaDon(@RequestParam("yearSelect") int year, @RequestParam("monthSelect") int month, RedirectAttributes redirect) {
		System.out.println(year + "======" + month);
		ModelAndView modelAndView = new ModelAndView("admin/thongke");
//		System.out.println(hoaDonService.getTotalMoneyWithMonth(year, month));

		double moneytotal = hoaDonService.getTotalMoney();
		modelAndView.addObject("selectMonth", month);
		modelAndView.addObject("selectYear", year);
		modelAndView.addObject("totalMoneyMonth", hoaDonService.getTotalMoneyWithMonth(year, month));
		modelAndView.addObject("totalMoney", moneytotal);
		modelAndView.addObject("totalBill", hoaDonService.findAll().size());
		modelAndView.addObject("totalCustomer", khachHangService.findAll().size());
		return modelAndView;
	}
	
	
	@GetMapping("/admin/thongke")
	public ModelAndView getPageThongKe() {
		ModelAndView modelAndView = new ModelAndView("admin/thongke");
		modelAndView.addObject("selectMonth", 4);
		modelAndView.addObject("selectYear", 2021);
		modelAndView.addObject("totalMoneyMonth", hoaDonService.getTotalMoneyWithMonth(2021, 4));
		modelAndView.addObject("totalMoney", hoaDonService.getTotalMoney());
		modelAndView.addObject("totalBill", hoaDonService.findAll().size());
		modelAndView.addObject("totalCustomer", khachHangService.findAll().size());
		return modelAndView;
	}
	
	
	@PostMapping("/admin/getHoaDon")
	@ResponseBody
	public ChiTietHoaDonModel getGetHoaDon(@RequestBody AddMonAnModel monAn, HttpServletRequest request) {
		//System.out.println(postM);
		//postService.deletePost(postModel.getId());
		System.out.println(monAn.getId());
		HoaDon hoaDon = hoaDonService.findById(Integer.valueOf(monAn.getId())).get();
		ChiTietHoaDonModel hd = new ChiTietHoaDonModel();
		hd.setTenKhachHang(hoaDon.getKhachHang().getTenKhachHang());
		hd.setSdt(hoaDon.getKhachHang().getSdt());
		hd.setDiaChi(hoaDon.getKhachHang().getDiaChi());
		hd.setDiaChiEmail(hoaDon.getKhachHang().getDiaChi());
		hd.setNgayLapHoaDon(hoaDon.getNgayLapHoaDon().toString());
		
		List<ChiTietMonAnModel> list = new ArrayList<ChiTietMonAnModel>();
		for (ChiTietHoaDon chiTietHoaDon : hoaDon.getChiTietHoadon()) {
			list.add(new ChiTietMonAnModel(chiTietHoaDon.getMonAn().getTenMonAn(), chiTietHoaDon.getMonAn().getDonGia(), chiTietHoaDon.getSoLuong()));
		}
		for (ChiTietMonAnModel chiTietMonAnModel : list) {
			System.out.println(chiTietMonAnModel.getTenMonAn());
			System.out.println(chiTietMonAnModel.getDonGia());
			System.out.println(chiTietMonAnModel.getSoLuong());
		}
		
		hd.setChiTiet(list);
		return hd;
	}
}
