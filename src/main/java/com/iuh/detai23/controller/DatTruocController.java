package com.iuh.detai23.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.TemplateEngine;

import com.iuh.detai23.entities.KhachHang;
import com.iuh.detai23.entities.MonAn;
import com.iuh.detai23.model.BanDatTruocAddModel;
import com.iuh.detai23.model.AddMonAnModel;
import com.iuh.detai23.service.BanDatTruocService;
import com.iuh.detai23.service.KhachHangService;
import com.iuh.detai23.service.MonAnService;

import javassist.expr.NewArray;

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

	@GetMapping("client/datBan")
	public ModelAndView getDatBan(HttpServletRequest request) {

//		System.out.println(engine.getTemplateResolvers().);
		ModelAndView modelAndView = new ModelAndView("datban");
		try {
			if (request.getSession().getAttribute("idAccount") != null) {
				int id = (int) request.getSession().getAttribute("idAccount");
				KhachHang kh = khachHangService.findById(id).get();
				modelAndView.addObject("khachHang", kh);
			}
		} catch (Exception e) {

		}
		// System.out.println(id+"============>");
		// modelAndView.addObject("datBan",new BanDatTruocAddModel());
		return modelAndView;
	}

	@PostMapping("client/datBan")
	public String getAddDatBan(HttpServletRequest request, @ModelAttribute BanDatTruocAddModel banDatTruoc,
			@RequestParam("action") String action, RedirectAttributes redirect) {

		System.out.println(banDatTruoc.getSoNguoi());
		if (action.toUpperCase().equals("ĐẶT MÓN")) {
			request.getSession().setAttribute("banDatTruoc", banDatTruoc);
			// redirect.addFlashAttribute("banDatTruoc", banDatTruoc);

			return "redirect:/client/checkoutDatBan";
		} else {
			banDatTruocService.save(banDatTruoc);
			return "redirect:/";
		}
//		System.out.println(banDatTruoc.getSoNguoi());
//		System.out.println(banDatTruoc.getNgayDen());
//		System.out.println(banDatTruoc.getThoiGianDen());
//		System.out.println(banDatTruoc.getGhiChu());
//		System.out.println(banDatTruoc.getTenKhachHang());
//		System.out.println(banDatTruoc.getEmail());
//		System.out.println(banDatTruoc.getPhone());
//		System.out.println(banDatTruoc.getDiaChi());		     
	}

	@GetMapping("/client/checkoutDatBan")
	public ModelAndView getCheckoutDatBan(@ModelAttribute("banDatTRuoc") BanDatTruocAddModel banDatTRuoc,
			HttpServletRequest request) {
		System.out.println("=====================>>>>>");
		System.out.println(banDatTRuoc.getTenKhachHang());
		ModelAndView modelAndView = new ModelAndView("checkoutDatBan");
		List<MonAn> listMonAn = monAnService.findAll();

		if (request.getSession().getAttribute("list-cart-food") != null) {
			request.getSession().removeAttribute("list-cart-food");
		}

		if (listMonAn != null) {
			for (MonAn monAn : listMonAn) {
				monAn.setHinhAnh("http://localhost:8080/download/" + monAn.getHinhAnh());
			}
			modelAndView.addObject("listMonAn", listMonAn);
		}
		BanDatTruocAddModel fawef = (BanDatTruocAddModel) request.getSession().getAttribute("banDatTruoc");
		System.out.println("hihi" + fawef.getSoNguoi());
		modelAndView.addObject("banDatTruoc", fawef);
		return modelAndView;
	}

	@PostMapping("/client/addRowMonAn")
	@ResponseBody
	public List<AddMonAnModel> addRowMonAn(@RequestBody AddMonAnModel monAn, HttpServletRequest request) {
		System.out.println(monAn.getId());
		System.out.println(monAn.getSoLuong());
		System.out.println(monAn.getTenMonAn());
		ArrayList<AddMonAnModel> list;
		if (request.getSession().getAttribute("list-cart-food") == null) {
			list = new ArrayList<AddMonAnModel>();
			list.add(monAn);
			request.getSession().setAttribute("list-cart-food", list);
		} else {

			list = (ArrayList<AddMonAnModel>) request.getSession().getAttribute("list-cart-food");
			int tamp = 0;
			for (int i =0;i<list.size();i++) {
				System.out.println(monAn.getId()+"=========="+list.get(i).getId());
				if (list.get(i).getId() == monAn.getId()) {
					System.out.println("con don");
					list.get(i).setSoLuong(list.get(i).getSoLuong() + monAn.getSoLuong());
					tamp = 1;
				}
			}
			if (tamp == 0) {
				System.err.println("da vao");
				list.add(monAn);
			}
		}
		return list;
	}
	
	@PostMapping("/client/removeRowMonAn")
	@ResponseBody
	public List<AddMonAnModel> removeRowMonAn(@RequestBody AddMonAnModel monAn, HttpServletRequest request) {
		System.out.println(monAn.getId());
		ArrayList<AddMonAnModel> list;
		ArrayList<AddMonAnModel> listNew = new ArrayList<AddMonAnModel>();
		if (request.getSession().getAttribute("list-cart-food") == null) {
			list = new ArrayList<AddMonAnModel>();
			request.getSession().setAttribute("list-cart-food", list);
			
		} else {
			list = (ArrayList<AddMonAnModel>) request.getSession().getAttribute("list-cart-food");
			
			for (int i =0;i<list.size();i++) {
				if (list.get(i).getId()!=monAn.getId()) {
					listNew.add(list.get(i));
				}
			}
			request.getSession().setAttribute("list-cart-food", listNew);
		}
		return listNew;
	}
	
	@PostMapping("/client/completedDatBan")
	public String completedDatBan(HttpServletRequest request) {
		BanDatTruocAddModel bn = (BanDatTruocAddModel)request.getSession().getAttribute("banDatTruoc");
		ArrayList<AddMonAnModel> list = (ArrayList<AddMonAnModel>) request.getSession().getAttribute("list-cart-food");
		
		System.err.println(bn.getTenKhachHang()+"ffffffffffffffff");
		System.out.println(list.get(0).getTenMonAn());
		return "redirect:/";
	}
}