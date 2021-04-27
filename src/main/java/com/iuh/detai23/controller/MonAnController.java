package com.iuh.detai23.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public ModelAndView getAdminMonAn() {
		ModelAndView modelAndView = new ModelAndView("admin/quanlymonan");
		List<MonAn> listMonAn = monAnService.findAll();
		for (MonAn monAn : listMonAn) {
			monAn.setHinhAnh("http://localhost:8080/download/"+monAn.getHinhAnh());
		}
		modelAndView.addObject("listMonAn", listMonAn);
		modelAndView.addObject("listLoaiMonAn", loaiMonAnService.findAll());
		modelAndView.addObject("monAn", new MonAnModel());
		return modelAndView;
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
	public String getDeletePost(@PathVariable("id") String id) {
		MonAn monAn = monAnService.findById(Integer.valueOf(id));
		monAn.setTinhTrang("NGUNG KINH DOANH");
		monAnService.save(monAn);
		return "redirect:/adminMonAn";
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
	public ModelAndView getEditMonAn(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView("admin/chinhSuaMonAn");
		
		MonAn monAn =  monAnService.findById(id);
		UpdateMonAnModel monAnModel = new UpdateMonAnModel(monAn.getMaMonAn(), monAn.getTenMonAn(), monAn.getDonGia(), monAn.getMoTa(), monAn.getHinhAnh(), monAn.getTinhTrang(), monAn.getLoaiMonAn().getMaLoaiMonAn());
		modelAndView.addObject("monAn",monAnModel);
		modelAndView.addObject("loaiMonAn",loaiMonAnService.findAll());
		return modelAndView;
	}
	@PostMapping("admin/monAn/edit/{id}")
	public String getEditMonAnUpdate(@PathVariable("id") int id, @ModelAttribute UpdateMonAnModel monAnModel, RedirectAttributes redirect) {
		ModelAndView modelAndView = new ModelAndView("admin/chinhSuaMonAn");
		
		MonAn monAn =  monAnService.findById(id);
		monAn.setTenMonAn(monAnModel.getTenMonAn());
		monAn.setDonGia(monAnModel.getDonGia());
		monAn.setMoTa(monAnModel.getMoTa());
		monAn.setLoaiMonAn(loaiMonAnService.findByMaLoaiMonAn(monAnModel.getMaLoaiMonAn()));
		monAnService.save(monAn);
		//monAnModel = new UpdateMonAnModel(monAn.getMaMonAn(), monAn.getTenMonAn(), monAn.getDonGia(), monAn.getMoTa(), monAn.getHinhAnh(), monAn.getTinhTrang(), monAn.getLoaiMonAn().getMaLoaiMonAn());
//		modelAndView.addObject("monAn",monAnModel);
//		modelAndView.addObject("loaiMonAn",loaiMonAnService.findAll());
		redirect.addAttribute("susscess", "thanhCong");
		return "redirect:/admin/monAn/";
	}
}