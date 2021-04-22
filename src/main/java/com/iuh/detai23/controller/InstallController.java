package com.iuh.detai23.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.iuh.detai23.entities.BanDatTruoc;
import com.iuh.detai23.entities.ChiTietHoaDon;
import com.iuh.detai23.entities.ChiTietHoaDonKey;
import com.iuh.detai23.entities.ChiTietMonDatTruoc;
import com.iuh.detai23.entities.ChiTietMonDatTruocKey;
import com.iuh.detai23.entities.HoaDon;
import com.iuh.detai23.entities.KhachHang;
import com.iuh.detai23.entities.LoaiMonAn;
import com.iuh.detai23.entities.MonAn;
import com.iuh.detai23.entities.NhanVien;
import com.iuh.detai23.entities.QuyenTruyCap;
import com.iuh.detai23.service.BanDatTruocService;
import com.iuh.detai23.service.HoaDonService;
import com.iuh.detai23.service.KhachHangService;
import com.iuh.detai23.service.LoaiMonAnService;
import com.iuh.detai23.service.MonAnService;
import com.iuh.detai23.service.NhanVienService;
import com.iuh.detai23.service.QuyenTruyCapService;
import com.iuh.detai23.type.TypeDatTruoc;
import com.iuh.detai23.type.TypeGioiTinh;
import com.iuh.detai23.type.TypeHoaDon;
import com.iuh.detai23.type.TypeQuuyen;

@RestController
public class InstallController {
	@Autowired
	private MonAnService monAnService;
	
	@Autowired
	private LoaiMonAnService loaiMonAnService;
	
	@Autowired
	private BanDatTruocService banDatTruocService;
	
	@Autowired
	private QuyenTruyCapService quyenTruyCapService;
	
	@Autowired
	private KhachHangService khachHangService;
	
	@Autowired 
	private NhanVienService nhanVienService;
	
	@Autowired 
	private HoaDonService hoaDonService;
	
	@GetMapping("/install")
	public LoaiMonAn ten() {
		LoaiMonAn loaiMonAn1 = new LoaiMonAn("Lẫu", "Lẩu Tươi Sống");
		LoaiMonAn loaiMonAn2 = new LoaiMonAn("Hải Sản", "Hải Sản Tươi");
		LoaiMonAn loaiMonAn3 = new LoaiMonAn("Gỏi", "Gỏi Nhẹ");

		loaiMonAnService.save(loaiMonAn1);
		loaiMonAnService.save(loaiMonAn2);
		loaiMonAnService.save(loaiMonAn3);

		MonAn monAn1 = new MonAn("Lẩu Thái", 120000, "Món Ăn Hà Nội", "img-01.jpg", loaiMonAn1);
		MonAn monAn2 = new MonAn("Lẩu Hải Sản", 130000, "Món Ăn Hà Nội", "img-02.jpg", loaiMonAn1);
		MonAn monAn3 = new MonAn("Lẩu Cá Kèo", 140000, "Món Ăn Hà Nội", "img-03.jpg", loaiMonAn1);
		MonAn monAn4 = new MonAn("Tôm Sú", 160000, "Món Ăn Hà Nội", "img-04.jpg", loaiMonAn2);
		MonAn monAn5 = new MonAn("Tôm Càng", 110000, "Món Ăn Hà Nội", "img-05.jpg", loaiMonAn2);
		MonAn monAn6 = new MonAn("Tôm Hùm", 220000, "Món Ăn Hà Nội", "img-06.jpg", loaiMonAn2);
		MonAn monAn7 = new MonAn("Cá Lăng", 320000, "Món Ăn Hà Nội", "img-07.jpg", loaiMonAn2);
		MonAn monAn8 = new MonAn("Gỏi Cá Trích", 1220000, "Món Ăn Hà Nội", "img-08.jpg", loaiMonAn3);
		MonAn monAn9 = new MonAn("Gỏi Tiến Vua", 1210000, "Món Ăn Hà Nội", "img-09.jpg", loaiMonAn3);
		
		monAnService.save(monAn1);
		monAnService.save(monAn2);
		monAnService.save(monAn3);
		monAnService.save(monAn4);
		monAnService.save(monAn5);
		monAnService.save(monAn6);
		monAnService.save(monAn7);
		monAnService.save(monAn8);
		monAnService.save(monAn9);
		
		QuyenTruyCap quyen1 = new QuyenTruyCap(TypeQuuyen.KhachHang);
		QuyenTruyCap quyen2 = new QuyenTruyCap(TypeQuuyen.NguoiQuanLy);
		QuyenTruyCap quyen3 = new QuyenTruyCap(TypeQuuyen.NhanVien);
		
		
		quyenTruyCapService.save(quyen1);
		quyenTruyCapService.save(quyen2);
		quyenTruyCapService.save(quyen3);
		
		
		KhachHang kh1 = new KhachHang("Doan Kim Dinh", "01231231234", "dinh@gmail.com", "doankimdinh", "123456");
		kh1.setQuyenTruyCap(quyen1);
		KhachHang kh2 = new KhachHang("Tran Minh Truc", "03434234234", "truc@gmail.com", "tranminhtruc", "123456");
		kh2.setQuyenTruyCap(quyen1);
		KhachHang kh3 = new KhachHang("Nguyen Bao Thy", "023423432543", "thy@gmail.com", "nguyenbaothy", "123456");
		kh3.setQuyenTruyCap(quyen1);
		
		
		khachHangService.save(kh1);
		khachHangService.save(kh2);
		khachHangService.save(kh3);		
		
		
		
		NhanVien nv1 = new NhanVien("Nguyen Tien Linh", "0123432323", "linh@gmail.com", "342356443", "Quan 1", TypeGioiTinh.Nam, "123456");
		NhanVien nv2 = new NhanVien("Mac Hong Quan", "0234232323", "quan@gmail.com", "342356445", "Quan 2", TypeGioiTinh.Nam, "123456");
		NhanVien nv3 = new NhanVien("Nguyen Trong Hoang", "0464232323", "hoang@gmail.com", "342356466", "Quan 3", TypeGioiTinh.Nu, "123456");
		
		nv1.setQuyenTruyCap(quyen2);
		nv2.setQuyenTruyCap(quyen2);
		nv3.setQuyenTruyCap(quyen2);
		
		nhanVienService.save(nv1);
		nhanVienService.save(nv2);
		nhanVienService.save(nv3);
		
		
		BanDatTruoc ban1 = new BanDatTruoc(LocalDateTime.now(), 12, "ghi chú 1", TypeDatTruoc.ChuaXacNhan);	
		System.out.println(ban1.getMaDatTruoc()+"===>");
		List<ChiTietMonDatTruoc> listct1 = new ArrayList<ChiTietMonDatTruoc>();
		listct1.add(new ChiTietMonDatTruoc( new ChiTietMonDatTruocKey(),monAn1, ban1, 2, monAn1.getDonGia()));
		listct1.add(new ChiTietMonDatTruoc( new ChiTietMonDatTruocKey(),monAn2, ban1, 4, monAn2.getDonGia()));
		ban1.setChiTietMonDatTruoc(listct1);
		ban1.setKhachHang(kh2);
		
		BanDatTruoc ban2 = new BanDatTruoc(LocalDateTime.now(), 12, "ghi chú 1", TypeDatTruoc.ChuaXacNhan);
		List<ChiTietMonDatTruoc> listct2 = new ArrayList<ChiTietMonDatTruoc>();
		listct2.add(new ChiTietMonDatTruoc( new ChiTietMonDatTruocKey(),monAn2, ban2, 4, monAn2.getDonGia()));
		ban2.setChiTietMonDatTruoc(listct2);
		ban2.setKhachHang(kh3);
		
		
		BanDatTruoc ban3 = new BanDatTruoc(LocalDateTime.now(), 12, "ghi chú 1", TypeDatTruoc.ChuaXacNhan);
		List<ChiTietMonDatTruoc> listct3 = new ArrayList<ChiTietMonDatTruoc>();
		ban3.setChiTietMonDatTruoc(listct3);
		ban3.setKhachHang(kh1);
		
	
		banDatTruocService.save(ban1);
		banDatTruocService.save(ban2);
		banDatTruocService.save(ban3);
		
		
		
		HoaDon hoaDon1= new HoaDon(LocalDateTime.of(2021, 4, 12, 4, 2), LocalDateTime.now(), TypeHoaDon.DaThanhToan, "khách đến trễ 20'");
		List<ChiTietHoaDon> listcthd1 = new ArrayList<ChiTietHoaDon>();
		System.out.println(hoaDon1.getMaHoaDon()+"====");
		hoaDon1.setKhachHang(kh1);
		hoaDon1.setNhanVien(nv1);
		listcthd1.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), monAn1, hoaDon1, 3, 120000));
		listcthd1.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), monAn2, hoaDon1, 5, 150000));
		listcthd1.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), monAn3, hoaDon1,12, 20000));
		hoaDon1.setChiTietHoadon(listcthd1);
		
		
		
		HoaDon hoaDon2= new HoaDon(LocalDateTime.now(), LocalDateTime.now(), TypeHoaDon.DaThanhToan, "khách thanh toán sau");
		List<ChiTietHoaDon> listcthd2 = new ArrayList<ChiTietHoaDon>();
		listcthd2.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), monAn5, hoaDon2, 3, 120000));
		
		hoaDon2.setChiTietHoadon(listcthd2);
		hoaDon2.setKhachHang(kh2);
		hoaDon2.setNhanVien(nv1);
		
		HoaDon hoaDon3= new HoaDon(LocalDateTime.now(), LocalDateTime.now(), TypeHoaDon.DaThanhToan, "");
		List<ChiTietHoaDon> listcthd3 = new ArrayList<ChiTietHoaDon>();
		listcthd3.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), monAn2, hoaDon3, 3, 150000));
		listcthd3.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), monAn6, hoaDon3, 5, 150000));
		
		hoaDon3.setChiTietHoadon(listcthd3);
		hoaDon3.setKhachHang(kh1);
		hoaDon3.setNhanVien(nv3);
		
		
		
		hoaDonService.save(hoaDon1);
		hoaDonService.save(hoaDon2);
		hoaDonService.save(hoaDon3);
		
		return loaiMonAn1;
	}
	
	
}
