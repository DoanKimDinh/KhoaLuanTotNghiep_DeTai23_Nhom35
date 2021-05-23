package com.iuh.detai23.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iuh.detai23.entities.MonAn;
import com.iuh.detai23.model.MonAnModel;
import com.iuh.detai23.model.UpdateMonAnModel;
import com.iuh.detai23.service.LoaiMonAnService;
import com.iuh.detai23.service.MonAnService;

@Controller
public class MonAnController {
	@Autowired
	private MonAnService monAnService;
	
	@Autowired
	private LoaiMonAnService loaiMonAnService;
	
	@GetMapping("/admin/monAn")
	public ModelAndView getAdminMonAn(HttpServletRequest request) {
			if(request.getSession().getAttribute("idAdmin") != null) {
				ModelAndView modelAndView = new ModelAndView("admin/quanlymonan");
				List<MonAn> listMonAn = monAnService.finDall();
				for (MonAn monAn : listMonAn) {
					monAn.setHinhAnh("http://localhost:8080/download/"+monAn.getHinhAnh());
				}
				modelAndView.addObject("listMonAn", listMonAn);
				modelAndView.addObject("listLoaiMonAn", loaiMonAnService.findAll());
				modelAndView.addObject("monAn", new MonAnModel());
				return modelAndView;
			}
			return new ModelAndView("redirect:/");
	}

	@PostMapping("/addMonAn")
	public String addMonAn(@ModelAttribute MonAnModel monanmodel,@RequestParam("file") MultipartFile file) {
		try {
			FileCopyUtils.copy(file.getBytes(), new File(System.getProperty("user.dir") +"\\"+ file.getOriginalFilename()));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		MonAn monAn = new MonAn();
		monAn.setHinhAnh(file.getOriginalFilename());
		monAn.setDonGia(monanmodel.getDonGia());
		
		monAn.setLoaiMonAn(loaiMonAnService.findByMaLoaiMonAn(monanmodel.getIdLoaiMonAn()));
		monAn.setMoTa(monanmodel.getMoTa());
		monAn.setTenMonAn(monanmodel.getTenMonAn());
		
		monAnService.save(monAn);
		return "redirect:/admin/monAn";
	}
	
	@GetMapping("/deleteMonAn/{id}")
	public String getDeletePost(@PathVariable("id") int id) {
		MonAn monAn = monAnService.findById(id);
		monAn.setTinhTrang("NgungKinhDoanh");
		System.err.println(monAn.getMaMonAn());
		monAnService.save(monAn);
		return "redirect:/admin/monAn";
	}
	
	@GetMapping("/getMonAn/{id}")
	@ResponseBody
	public MonAn getGetMonAn(@PathVariable("id") String id) {
		//System.out.println(postM);
		//postService.deletePost(postModel.getId());
		MonAn monAn = monAnService.findBy(Integer.valueOf(id)).get();
		return monAn;
	}
	
	@GetMapping("admin/monAn/edit/{id}")
	public ModelAndView getEditMonAn(@PathVariable("id") int id, HttpServletRequest request) {
		if(request.getSession().getAttribute("idAdmin") != null) {
			ModelAndView modelAndView = new ModelAndView("admin/chinhSuaMonAn");
			MonAn monAn =  monAnService.findById(id);
			UpdateMonAnModel monAnModel = new UpdateMonAnModel(monAn.getMaMonAn(), monAn.getTenMonAn(), monAn.getDonGia(), monAn.getMoTa(), monAn.getHinhAnh(), monAn.getTinhTrang(), monAn.getLoaiMonAn().getMaLoaiMonAn());
			modelAndView.addObject("monAn",monAnModel);
			modelAndView.addObject("loaiMonAn",loaiMonAnService.findAll());
			return modelAndView;
		}
		return new ModelAndView("redirect:/");
	}
	
	@PostMapping("admin/monAn/edit/{id}")
	public String getEditMonAnUpdate(@PathVariable("id") int id, @ModelAttribute UpdateMonAnModel monAnModel, RedirectAttributes redirect) {
			MonAn monAn =  monAnService.findById(id);
			monAn.setTenMonAn(monAnModel.getTenMonAn());
			monAn.setDonGia(monAnModel.getDonGia());
			monAn.setMoTa(monAnModel.getMoTa());
			monAn.setLoaiMonAn(loaiMonAnService.findByMaLoaiMonAn(monAnModel.getMaLoaiMonAn()));
			monAnService.save(monAn);
			redirect.addAttribute("susscess", "thanhCong");
			return "redirect:/admin/monAn/";
	}
	
//	@PostMapping("admin/monAn/delete/{id}")
//	public String deleteMonAn(@PathVariable("id") int id, @ModelAttribute UpdateMonAnModel monAnModel, RedirectAttributes redirect) {
//		//ModelAndView modelAndView - new ModelAndView("");
//		MonAn monAn = monAnService.findById(id);
//		monAn.setTinhTrang(monAnModel.getTinhTrang());
//		monAnService.save(monAn);
//		redirect.addAttribute("susscess", "thanhCong");
//		return "redirect:/admin/monAn";
//	}
	
//	@PostMapping("/admin/monAn/deleteMonAn")
//	public Optional<MonAn> deleteMonAn(@RequestBody MonAn monAn){
//		monAn.setTinhTrang("");
//		monAnService.save(monAn);
//		return Optional.ofNullable(monAn);
//	}
	
	@GetMapping("/monan")
	public ModelAndView getMonAn() {
		ModelAndView modelAndView = new ModelAndView("menu");
		List<MonAn> listMonAn = monAnService.finDall();
		for (MonAn monAn : listMonAn) {
			monAn.setHinhAnh("http://localhost:8080/download/"+monAn.getHinhAnh());
		}
		modelAndView.addObject("listMonAn", listMonAn);
		modelAndView.addObject("listLoaiMonAn", loaiMonAnService.findAll());
		return modelAndView;
	}
}
