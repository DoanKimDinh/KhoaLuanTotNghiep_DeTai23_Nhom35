package com.iuh.detai23.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

import com.iuh.detai23.entities.BanDatTruoc;
import com.iuh.detai23.entities.ChiTietHoaDon;
import com.iuh.detai23.entities.ChiTietHoaDonKey;
import com.iuh.detai23.entities.ChiTietMonDatTruoc;
import com.iuh.detai23.entities.HoaDon;
import com.iuh.detai23.entities.MonAn;
import com.iuh.detai23.model.AddMonAnModel;
import com.iuh.detai23.model.ChiTietHoaDonModel;
import com.iuh.detai23.model.ChiTietMonAnModel;
import com.iuh.detai23.service.BanDatTruocService;
import com.iuh.detai23.service.HoaDonService;
import com.iuh.detai23.service.KhachHangService;
import com.iuh.detai23.service.MonAnService;
import com.iuh.detai23.service.NhanVienService;
import com.iuh.detai23.type.TypeHoaDon;

@Controller
public class HoaDonController {
	
	@Autowired
	private HoaDonService hoaDonService;
	
	@Autowired
	private MonAnService monAnService;
	
	@Autowired
	private KhachHangService khachHangService;
	
	@Autowired
	private BanDatTruocService banDatTruocService;
	
	@Autowired
	private NhanVienService nhanVienService;
	
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
		ModelAndView modelAndView = new ModelAndView("admin/thongke");

		double moneytotal = hoaDonService.getTotalMoney();
		
		modelAndView.addObject("selectMonth", month);
		modelAndView.addObject("selectYear", year);
		modelAndView.addObject("totalMoneyMonth", hoaDonService.getTotalMoneyWithMonth(year, month));
		modelAndView.addObject("totalMoney", moneytotal);
		//modelAndView.addObject("totalBill", hoaDonService.findAll().size());
		modelAndView.addObject("totalBill", hoaDonService.getListHoaDonByMonth(year, month).size());
		
		//modelAndView.addObject("totalCustomer", khachHangService.findAll().size());
		modelAndView.addObject("totalCustomer", hoaDonService.getTotalAmountPersonInBill(year, month));
		
		modelAndView.addObject("listHoaDon", hoaDonService.getListHoaDonByMonth(year, month));
		modelAndView.addObject("selectPresent", String.valueOf(month));
		modelAndView.addObject("selectPresentYear", String.valueOf(year));
		return modelAndView;
	}
	
	
	@GetMapping("/admin/thongke")
	public ModelAndView getPageThongKe() {
		ModelAndView modelAndView = new ModelAndView("admin/thongke");
		modelAndView.addObject("selectMonth", 4);
		modelAndView.addObject("selectYear", 2021);
		modelAndView.addObject("totalMoneyMonth", hoaDonService.getTotalMoneyWithMonth(2021, 4));
		modelAndView.addObject("totalMoney", hoaDonService.getTotalMoney());
		modelAndView.addObject("totalBill", hoaDonService.getListHoaDonByMonth(2021, 4).size());
		modelAndView.addObject("totalCustomer", hoaDonService.getTotalAmountPersonInBill(2021, 4));
		modelAndView.addObject("listHoaDon", hoaDonService.getListHoaDonByMonth(2021, 4));
		modelAndView.addObject("selectPresent", "4");
		modelAndView.addObject("selectPresentYear", "2021");
		return modelAndView;
	}
	

	
	@PostMapping("/admin/getHoaDon")
	@ResponseBody
	public ChiTietHoaDonModel getGetHoaDon(@RequestBody AddMonAnModel monAn, HttpServletRequest request) {

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
		
		hd.setChiTiet(list);
		return hd;
	}
	
	@PostMapping("/admin/getChiTietDatTruoc")
	@ResponseBody
	public ChiTietHoaDonModel getChiTietDatTRuoc(@RequestBody AddMonAnModel monAn, HttpServletRequest request) {
		BanDatTruoc banDatTruoc = banDatTruocService.findById(monAn.getId()).get();
		
		ChiTietHoaDonModel hd = new ChiTietHoaDonModel();
		hd.setTenKhachHang(banDatTruoc.getKhachHang().getTenKhachHang());
		hd.setSdt(banDatTruoc.getKhachHang().getSdt());
		hd.setDiaChi(banDatTruoc.getKhachHang().getDiaChi());
		hd.setDiaChiEmail(banDatTruoc.getKhachHang().getDiaChi());
		hd.setNgayLapHoaDon(LocalDate.now().toString());
		System.out.println(banDatTruoc.getKhachHang().getTenKhachHang());
		System.out.println(banDatTruoc.getKhachHang().getSdt());
		System.out.println(banDatTruoc.getKhachHang().getDiaChi());

		
		List<ChiTietMonAnModel> list = new ArrayList<ChiTietMonAnModel>();
		for (ChiTietMonDatTruoc chiTietHoaDon : banDatTruoc.getChiTietMonDatTruoc()) {
			list.add(new ChiTietMonAnModel(chiTietHoaDon.getMonAn().getTenMonAn(), chiTietHoaDon.getMonAn().getDonGia(), chiTietHoaDon.getSoLuong()));
			System.out.println(chiTietHoaDon.getMonAn().getTenMonAn() + " - - - "+ chiTietHoaDon.getSoLuong());
		}
		
		hd.setChiTiet(list);
		
		//thanh toan
		
		
		// @RequestBody AddMonAnModel monAn
		
		List<ChiTietMonDatTruoc> listChiTietMonDatTruocs = banDatTruoc.getChiTietMonDatTruoc();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		HoaDon hoaDon = new HoaDon(LocalDate.parse(banDatTruoc.getNgayDen(), formatter).atStartOfDay(),
				LocalDateTime.now(), TypeHoaDon.DaThanhToan, banDatTruoc.getGhiChu());
		List<ChiTietHoaDon> listcthd = new ArrayList<ChiTietHoaDon>();
		hoaDon.setKhachHang(banDatTruoc.getKhachHang());
		hoaDon.setNhanVien(
				nhanVienService.findById(Integer.parseInt(request.getSession().getAttribute("idAdmin").toString())));

		for (ChiTietMonDatTruoc chiDatTruoc : banDatTruoc.getChiTietMonDatTruoc()) {
			listcthd.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), chiDatTruoc.getMonAn(), hoaDon,
					chiDatTruoc.getSoLuong(), chiDatTruoc.getMonAn().getDonGia()));
		}
		hoaDon.setChiTietHoadon(listcthd);
		hoaDonService.save(hoaDon);
		banDatTruocService.delete(monAn.getId());
//		
		
		
		return hd;
	}
}
