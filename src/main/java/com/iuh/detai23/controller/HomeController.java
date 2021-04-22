package com.iuh.detai23.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iuh.detai23.entities.BanDatTruoc;
import com.iuh.detai23.entities.LoaiMonAn;
import com.iuh.detai23.entities.MonAn;
import com.iuh.detai23.model.MonAnModel;
import com.iuh.detai23.service.BanDatTruocService;
import com.iuh.detai23.service.LoaiMonAnService;
import com.iuh.detai23.service.MonAnService;


@Controller
public class HomeController {
	
	@Autowired
	private MonAnService monAnService;
	@Autowired
	private LoaiMonAnService loaiMonAnService;
	
	@Autowired
	private BanDatTruocService banDatTruocService;
	
	@GetMapping("/home")
	public ModelAndView getHome() {
		ModelAndView modelAndView = new ModelAndView("index");
		List<MonAn> listMonAn = monAnService.findAll();
		System.out.println(listMonAn.size());
		for (MonAn monAn : listMonAn) {
			monAn.setHinhAnh("http://localhost:8080/download/"+monAn.getHinhAnh());
			System.out.println(monAn.getTenMonAn());
		}
		modelAndView.addObject("listMonAn", listMonAn);
		modelAndView.addObject("listLoaiMonAn", loaiMonAnService.findAll());
		return modelAndView;
	}
	
	
	@GetMapping("/admin/banDatTruoc")
	public ModelAndView getAdminBanDatTruoc() {
		ModelAndView modelAndView = new ModelAndView("admin/bandattruoc");
		List<BanDatTruoc> listBanDatTruoc = banDatTruocService.findAll();
		
		modelAndView.addObject("listBanDatTruoc", listBanDatTruoc);
		modelAndView.addObject("listLoaiMonAn", loaiMonAnService.findAll());
		modelAndView.addObject("monAn", new MonAnModel());
		return modelAndView;
	}
	
	@GetMapping("/admin/chinhSuaBanDatTruoc")
	public ModelAndView getAdminEditDatTruoc() {
		ModelAndView modelAndView = new ModelAndView("admin/chinhSuaBanDatTruoc");
		List<BanDatTruoc> listBanDatTruoc = banDatTruocService.findAll();
		
		modelAndView.addObject("listBanDatTruoc", listBanDatTruoc);
		modelAndView.addObject("listLoaiMonAn", loaiMonAnService.findAll());
		modelAndView.addObject("monAn", new MonAnModel());
		return modelAndView;
	}
	
	@GetMapping("/download/{filename}")
	public ResponseEntity downloadFile(@PathVariable("filename") String file) {
		Path path = Paths.get(file);
		System.out.println(path);
		Resource resource = null; 
		try {
			resource = new UrlResource(path.toUri());
			System.out.println(path.toAbsolutePath());
			System.out.println(path.getFileSystem());
			System.out.println(path.getRoot());
			System.out.println(path.getParent());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ResponseEntity.ok().body(resource);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/doUpload", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String uploadImage(@RequestParam("upload") MultipartFile[] files) {
		
		MultipartFile multipartFile = files[0];
		String filename = multipartFile.getOriginalFilename();

		System.out.println(System.getProperty("user.dir"));
		
		try {
			FileCopyUtils.copy(multipartFile.getBytes(), new File(System.getProperty("user.dir") +"\\"+ filename));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.err.println(filename+" day la file name");
		String path ="file:///"+ System.getProperty("user.dir")+"\\"+filename;
		path = "http://localhost:8080/download/"+filename;
		return "{\"url\":\""+path+"\"}";
	}
	
	
	
	
	@GetMapping("/admin/thongke")
	public ModelAndView getPageThongKe() {
		ModelAndView modelAndView = new ModelAndView("admin/thongke");
		List<BanDatTruoc> listBanDatTruoc = banDatTruocService.findAll();
		
		modelAndView.addObject("listBanDatTruoc", listBanDatTruoc);
		modelAndView.addObject("listLoaiMonAn", loaiMonAnService.findAll());
		modelAndView.addObject("monAn", new MonAnModel());
		return modelAndView;
	}
	
}
