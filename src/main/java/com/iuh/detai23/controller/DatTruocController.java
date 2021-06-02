package com.iuh.detai23.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.TemplateEngine;

import com.iuh.detai23.entities.BanDatTruoc;
import com.iuh.detai23.entities.ChiTietHoaDon;
import com.iuh.detai23.entities.ChiTietHoaDonKey;
import com.iuh.detai23.entities.ChiTietMonDatTruoc;
import com.iuh.detai23.entities.ChiTietMonDatTruocKey;
import com.iuh.detai23.entities.HoaDon;
import com.iuh.detai23.entities.KhachHang;
import com.iuh.detai23.entities.MonAn;
import com.iuh.detai23.model.AddMonAnEditDatBanModel;
import com.iuh.detai23.model.AddMonAnModel;
import com.iuh.detai23.model.BanDatTruocAddModel;
import com.iuh.detai23.repositoties.ChiTietMonDatTruocRepository;
import com.iuh.detai23.service.BanDatTruocService;
import com.iuh.detai23.service.HoaDonService;
import com.iuh.detai23.service.KhachHangService;
import com.iuh.detai23.service.MonAnService;
import com.iuh.detai23.service.NhanVienService;
import com.iuh.detai23.type.TypeHoaDon;

@Controller
public class DatTruocController {
	@Autowired
	private MonAnService monAnService;

	@Autowired
	private TemplateEngine engine;

	@Autowired
	private BanDatTruocService banDatTruocService;

	@Autowired
	private KhachHangService khachHangService;
	
	@Autowired
	private NhanVienService nhanVienService;
	
	@Autowired 
	private HoaDonService hoaDonService;

	@GetMapping("client/datBan")
	public ModelAndView getDatBan(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("datban");
		try {
			if (request.getSession().getAttribute("idAccount") != null) {
				int id = (int) request.getSession().getAttribute("idAccount");
				KhachHang kh = khachHangService.findById(id);
				modelAndView.addObject("khachHang", kh);
				
			}
		} catch (Exception e) {

		}
		return modelAndView;
	}

	@PostMapping("client/datBan")
	public String getAddDatBan(HttpServletRequest request, @ModelAttribute BanDatTruocAddModel banDatTruoc,
			@RequestParam("action") String action, RedirectAttributes redirect) {

		if (action.toUpperCase().equals("ĐẶT MÓN")) {
			request.getSession().setAttribute("banDatTruoc", banDatTruoc);
			// redirect.addFlashAttribute("banDatTruoc", banDatTruoc);

			return "redirect:/client/checkoutDatBan";
		} else {
			banDatTruocService.save(banDatTruoc, new ArrayList<AddMonAnModel>());
			redirect.addFlashAttribute("datThanhCong", banDatTruoc);
			return "redirect:/";
		}	     
	}

	@GetMapping("/client/checkoutDatBan")
	public ModelAndView getCheckoutDatBan(@ModelAttribute("banDatTRuoc") BanDatTruocAddModel banDatTRuoc,
			HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("checkoutDatBan");
		List<MonAn> listMonAn = monAnService.findAll();

		if (request.getSession().getAttribute("list-cart-food") != null) {
			request.getSession().removeAttribute("list-cart-food");
		}

		if (listMonAn != null) {
			for (MonAn monAn : listMonAn) {
				monAn.setHinhAnh("http://localhost:8080/image/" + monAn.getHinhAnh());
				
			}
			modelAndView.addObject("listMonAn", listMonAn);
		}
		BanDatTruocAddModel fawef = (BanDatTruocAddModel) request.getSession().getAttribute("banDatTruoc");
		modelAndView.addObject("banDatTruoc", fawef);
		return modelAndView;
	}

	@PostMapping("/client/addRowMonAn")
	@ResponseBody
	public List<AddMonAnModel> addRowMonAn(@RequestBody AddMonAnModel monAn, HttpServletRequest request) {		
		ArrayList<AddMonAnModel> list;
		if (request.getSession().getAttribute("list-cart-food") == null) {
			list = new ArrayList<AddMonAnModel>();
			list.add(monAn);
			request.getSession().setAttribute("list-cart-food", list);
		} else {

			list = (ArrayList<AddMonAnModel>) request.getSession().getAttribute("list-cart-food");
			int tamp = 0;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getId() == monAn.getId()) {
				
					list.get(i).setSoLuong(list.get(i).getSoLuong() + monAn.getSoLuong());
					tamp = 1;
				}
			}
			if (tamp == 0) {
				
				list.add(monAn);
			}
		}
		return list;
	}

	@PostMapping("/client/removeRowMonAn")
	@ResponseBody
	public List<AddMonAnModel> removeRowMonAn(@RequestBody AddMonAnModel monAn, HttpServletRequest request) {
		ArrayList<AddMonAnModel> list;
		ArrayList<AddMonAnModel> listNew = new ArrayList<AddMonAnModel>();
		if (request.getSession().getAttribute("list-cart-food") == null) {
			list = new ArrayList<AddMonAnModel>();
			request.getSession().setAttribute("list-cart-food", list);

		} else {
			list = (ArrayList<AddMonAnModel>) request.getSession().getAttribute("list-cart-food");

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getId() != monAn.getId()) {
					listNew.add(list.get(i));
				}
			}
			request.getSession().setAttribute("list-cart-food", listNew);
		}
		return listNew;
	}

	@PostMapping("/client/completedDatBan")
	public String completedDatBan(HttpServletRequest request, RedirectAttributes redirect) {
		BanDatTruocAddModel banDatTruoc = (BanDatTruocAddModel) request.getSession().getAttribute("banDatTruoc");
		ArrayList<AddMonAnModel> list = (ArrayList<AddMonAnModel>) request.getSession().getAttribute("list-cart-food");

		banDatTruocService.save(banDatTruoc, list);
		redirect.addFlashAttribute("datThanhCong", banDatTruoc);


		return "redirect:/";
	}
	
	@GetMapping("/admin/banDatTruoc/edit/pay")
	public String getEditMonAnPAY(@RequestParam("idBanDatTruoc") int id, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("admin/chinhSuaBanDatTruoc");
		// @RequestBody AddMonAnModel monAn
		BanDatTruoc banDatTruoc = banDatTruocService.findById(id).get();
		List<ChiTietMonDatTruoc> listChiTietMonDatTruocs = banDatTruoc.getChiTietMonDatTruoc();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		HoaDon hoaDon = new HoaDon(LocalDate.parse( banDatTruoc.getNgayDen(),formatter).atStartOfDay(), LocalDateTime.now(), TypeHoaDon.DaThanhToan, banDatTruoc.getGhiChu());
		List<ChiTietHoaDon> listcthd = new ArrayList<ChiTietHoaDon>();
		hoaDon.setKhachHang(banDatTruoc.getKhachHang());
		hoaDon.setNhanVien(nhanVienService.findById(Integer.parseInt(request.getSession().getAttribute("idAdmin").toString())));
		
		for (ChiTietMonDatTruoc chiDatTruoc : banDatTruoc.getChiTietMonDatTruoc()) {
			listcthd.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), chiDatTruoc.getMonAn(), hoaDon, chiDatTruoc.getSoLuong(), chiDatTruoc.getMonAn().getDonGia()));
		}
		hoaDon.setChiTietHoadon(listcthd);
		
		hoaDonService.save(hoaDon);
		
		banDatTruocService.delete(id);

		return "redirect:/admin/banDatTruoc";
	}
	
	
	@PostMapping("/admin/banDatTruoc/edit/updateThongTin")
	public String updateThongTin(RedirectAttributes redirect,@RequestParam("id") int id,@RequestParam("soNguoi") int soNguoi,@RequestParam("ngayDen") String ngayDen,@RequestParam("thoiGianDen") String thoiGianDen,@RequestParam("ghiChu") String ghiChu, HttpServletRequest request) {
		
		BanDatTruoc banDatTruoc = banDatTruocService.findById(id).get();
		banDatTruoc.setSoNguoi(soNguoi);
		banDatTruoc.setNgayDen(ngayDen);
		banDatTruoc.setThoiGianDen(thoiGianDen);
		banDatTruoc.setGhiChu(ghiChu);
		
		redirect.addFlashAttribute("editsucceess", "dft");
		
		banDatTruocService.save(banDatTruoc);

		return "redirect:/admin/banDatTruoc/edit/"+id;
	}
	

	@GetMapping("/admin/banDatTruoc/edit/{id}")
	public ModelAndView getEditMonAn(@PathVariable("id") int id, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("admin/chinhSuaBanDatTruoc");
		// @RequestBody AddMonAnModel monAn
		BanDatTruoc banDatTruoc = banDatTruocService.findById(id).get();
		modelAndView.addObject("banDatTruoc", banDatTruoc);

		List<AddMonAnEditDatBanModel> listMonAnEdit = new ArrayList<AddMonAnEditDatBanModel>();
		int i = 0;
		double tongTien = 0;
		for (ChiTietMonDatTruoc chiTietMonAnDatTruoc : banDatTruoc.getChiTietMonDatTruoc()) {
			listMonAnEdit.add(new AddMonAnEditDatBanModel(chiTietMonAnDatTruoc.getMonAn().getMaMonAn(),
					chiTietMonAnDatTruoc.getSoLuong(), chiTietMonAnDatTruoc.getMonAn().getTenMonAn(),
					chiTietMonAnDatTruoc.getMonAn().getDonGia() * chiTietMonAnDatTruoc.getSoLuong(), ++i));
			tongTien+=chiTietMonAnDatTruoc.getMonAn().getDonGia()*chiTietMonAnDatTruoc.getSoLuong();
		}
		modelAndView.addObject("listMonDatTruoc", listMonAnEdit);
		modelAndView.addObject("listMonAn", monAnService.findAll());
		if(tongTien!=0) {
			modelAndView.addObject("tongTien", tongTien);
		}
		

		request.getSession().setAttribute("edit-banDatTruoc", banDatTruoc);
		request.getSession().setAttribute("list-food-edit", banDatTruoc.getChiTietMonDatTruoc());

		return modelAndView;
	}

	@GetMapping("/admin/banDatTruoc/edit/add/{idDatTruoc}/{idMonAn}")
	public String getEditMonAnAdd(@PathVariable("idDatTruoc") int id, @PathVariable("idMonAn") int idMonAn,
			HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("admin/chinhSuaBanDatTruoc");
		// @RequestBody AddMonAnModel monAn
		BanDatTruoc banDatTruoc = banDatTruocService.findById(id).get();
		MonAn monAn = monAnService.findById(idMonAn);

		List<ChiTietMonDatTruoc> list = banDatTruoc.getChiTietMonDatTruoc();
		int tamp = 0;
		for (ChiTietMonDatTruoc chiTietMonDatTruoc : list) {
			if (chiTietMonDatTruoc.getMonAn().getMaMonAn() == monAn.getMaMonAn()) {
				chiTietMonDatTruoc.setSoLuong(chiTietMonDatTruoc.getSoLuong() + 1);
				tamp = 1;
			}
		}
		if (tamp == 0) {
			list.add(new ChiTietMonDatTruoc(new ChiTietMonDatTruocKey(), monAn, banDatTruoc, 1, monAn.getDonGia()));
		}
		banDatTruoc.setChiTietMonDatTruoc(list);
		banDatTruocService.save(banDatTruoc);
		

		modelAndView.addObject("banDatTruoc", banDatTruoc);

		List<AddMonAnEditDatBanModel> listMonAnEdit = new ArrayList<AddMonAnEditDatBanModel>();

		int i = 0;
		for (ChiTietMonDatTruoc chiTietMonAnDatTruoc : banDatTruoc.getChiTietMonDatTruoc()) {
			listMonAnEdit.add(new AddMonAnEditDatBanModel(chiTietMonAnDatTruoc.getMonAn().getMaMonAn(),
					chiTietMonAnDatTruoc.getSoLuong(), chiTietMonAnDatTruoc.getMonAn().getTenMonAn(),
					chiTietMonAnDatTruoc.getMonAn().getDonGia() * chiTietMonAnDatTruoc.getSoLuong(), ++i));
		}
		modelAndView.addObject("listMonDatTruoc", listMonAnEdit);

		modelAndView.addObject("listMonAn", monAnService.findAll());

//		request.getSession().setAttribute("edit-banDatTruoc", banDatTruoc);
//		request.getSession().setAttribute("list-food-edit", banDatTruoc.getChiTietMonDatTruoc());

		return "redirect:/admin/banDatTruoc/edit/"+id;
	}
	
	
	@Autowired
	ChiTietMonDatTruocRepository ctmdtRepo;
	
	
	
	
	
	@PostMapping("/admin/banDatTruoc/edit/remove")
	public String getEditMonAnRemove(RedirectAttributes redirect,@RequestParam("soLuong") int soLuong,@RequestParam("action") String action,@RequestParam("idDatTruoc") int id,  @RequestParam("id") int idMonAn,
			HttpServletRequest request) {
		
		redirect.addFlashAttribute("editsucceess", "hihi");
		
		if(action.toLowerCase().equals("xóa bỏ")||soLuong==0) {
			BanDatTruoc banDatTruoc = banDatTruocService.findById(id).get();
			MonAn monAn = monAnService.findById(idMonAn);
			
			
			for (ChiTietMonDatTruoc chiTietMonDatTruoc : banDatTruoc.getChiTietMonDatTruoc()) {
				if (chiTietMonDatTruoc.getMonAn().getMaMonAn() == monAn.getMaMonAn()) {
					banDatTruoc.getChiTietMonDatTruoc().remove(chiTietMonDatTruoc);
					banDatTruocService.save(banDatTruoc);
					ctmdtRepo.delete(chiTietMonDatTruoc);
					break;
				}
			}
			
//			 Iterator i = (Iterator) banDatTruoc.getChiTietMonDatTruoc();
//			
//			while (i.hasNext()) {
//				ChiTietMonDatTruoc chiTietMonDatTruoc = (ChiTietMonDatTruoc)i.next();
//				if (chiTietMonDatTruoc.getMonAn().getMaMonAn() == monAn.getMaMonAn()) {
//					//banDatTruoc.getChiTietMonDatTruoc().remove(chiTietMonDatTruoc);
//					i.remove();
//					ctmdtRepo.delete(chiTietMonDatTruoc);
//				}
//			}
//			banDatTruocService.save(banDatTruoc);
			

		}
		else {
			BanDatTruoc banDatTruoc = banDatTruocService.findById(id).get();
			MonAn monAn = monAnService.findById(idMonAn);
			for (ChiTietMonDatTruoc chiTietMonDatTruoc : banDatTruoc.getChiTietMonDatTruoc()) {
				if (chiTietMonDatTruoc.getMonAn().getMaMonAn() == monAn.getMaMonAn()) {
					chiTietMonDatTruoc.setSoLuong(soLuong);
					break;
				}
			}
			banDatTruocService.save(banDatTruoc);
		}
		

		return "redirect:/admin/banDatTruoc/edit/"+id;
	}
	

	@PostMapping("/admin/chinhSuaMonAn/AddRowMonAn")
	public String addRowMonAnEdit(@RequestBody AddMonAnModel monAn, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("admin/chinhSuaBanDatTruoc");
		// @RequestBody AddMonAnModel monAn

		BanDatTruoc banDatTruoc = (BanDatTruoc) request.getSession().getAttribute("edit-banDatTruoc");
		List<ChiTietMonDatTruoc> listChiTiet = (List<ChiTietMonDatTruoc>) request.getSession()
				.getAttribute("list-food-edit");

		int tamp = 0;
		for (ChiTietMonDatTruoc chiTietMonDatTruoc : listChiTiet) {
			if (chiTietMonDatTruoc.getMonAn().getMaMonAn() == monAn.getId()) {
				chiTietMonDatTruoc.setSoLuong(chiTietMonDatTruoc.getSoLuong() + monAn.getSoLuong());
				tamp = 1;
			}
		}
		if (tamp == 0) {
			listChiTiet.add(new ChiTietMonDatTruoc(new ChiTietMonDatTruocKey(), monAnService.findById(monAn.getId()),
					banDatTruoc, monAn.getSoLuong(), monAn.getDonGia()));
		}

		banDatTruocService.save(banDatTruoc);

		// BanDatTruoc banDatTruoc = banDatTruocService.findById(id).get();
//		modelAndView.addObject("banDatTruoc", banDatTruoc);
//		modelAndView.addObject("listMonDatTruoc", banDatTruoc.getChiTietMonDatTruoc());
//		modelAndView.addObject("listMonAn", monAnService.findAll());

//		request.getSession().setAttribute("edit-banDatTruoc", banDatTruoc);
//		request.getSession().setAttribute("list-food-edit", banDatTruoc.getChiTietMonDatTruoc());
	
		return "redirect:/admin/banDatTruoc/edit/" + banDatTruoc.getMaDatTruoc();
	}
	@GetMapping("/deleteBanDatTruoc/{id}")
	public String deleteBanDatTruoc(@PathVariable("id") int id) {
		
		banDatTruocService.delete(id);
		
		return "redirect:/admin/banDatTruoc";
	}
}