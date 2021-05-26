package com.iuh.detai23.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

		MonAn monAn1 = new MonAn("Lẩu Thái", 35000, "Món Ăn Hà Nội", "img-01.jpg", loaiMonAn1,"DangKinhDoanh");
		MonAn monAn2 = new MonAn("Lẩu Hải Sản", 20000, "Món Ăn Hà Nội", "img-02.jpg", loaiMonAn1,"DangKinhDoanh");
		MonAn monAn3 = new MonAn("Lẩu Cá Kèo", 50000, "Món Ăn Hà Nội", "img-03.jpg", loaiMonAn1,"DangKinhDoanh");
		MonAn monAn4 = new MonAn("Tôm Sú", 10000, "Món Ăn Hà Nội", "img-04.jpg", loaiMonAn2,"DangKinhDoanh");
		MonAn monAn5 = new MonAn("Tôm Càng", 12000, "Món Ăn Hà Nội", "img-05.jpg", loaiMonAn2,"DangKinhDoanh");
		MonAn monAn6 = new MonAn("Tôm Hùm", 22000, "Món Ăn Hà Nội", "img-06.jpg", loaiMonAn2,"DangKinhDoanh");
		MonAn monAn7 = new MonAn("Cá Lăng", 32000, "Món Ăn Hà Nội", "img-07.jpg", loaiMonAn2,"DangKinhDoanh");
		MonAn monAn8 = new MonAn("Gỏi Cá Trích", 32000, "Món Ăn Hà Nội", "img-08.jpg", loaiMonAn3,"NgungKinhDoanh");
		MonAn monAn9 = new MonAn("Gỏi Tiến Vua", 40000, "Món Ăn Hà Nội", "img-09.jpg", loaiMonAn3,"NgungKinhDoanh");
		
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
		
		
		KhachHang kh1 = new KhachHang("Đoàn Kim Định", "0123456789", "kimdinh@gmail.com", "doankimdinh", "123456");
		kh1.setDiaChi("Gò Vấp");
		kh1.setQuyenTruyCap(quyen1);
		KhachHang kh2 = new KhachHang("Trần Minh Trúc", "0123456781", "minhtruc@gmail.com", "tranminhtruc", "123456");
		kh2.setDiaChi("Quận 1");
		kh2.setQuyenTruyCap(quyen1);
		KhachHang kh3 = new KhachHang("Nguyễn Bảo Thy", "0123456782", "baothy@gmail.com", "nguyenbaothy", "123456");
		kh3.setDiaChi("Quận 2");
		kh3.setQuyenTruyCap(quyen1);
		KhachHang kh4 = new KhachHang("Nguyễn Đình Quốc", "0123456783", "dinhquoc@gmail.com", "nguyendinhquoc", "123456");
		kh4.setDiaChi("Quận 4");
		kh4.setQuyenTruyCap(quyen1);
		KhachHang kh5 = new KhachHang("Nguyễn Văn Hoàng", "0123456784", "vanhoang@gmail.com", "nguyenvanhoang", "123456");
		kh5.setDiaChi("Quận 5");
		kh5.setQuyenTruyCap(quyen1);
		KhachHang kh6 = new KhachHang("Nguyễn Thiên Chí", "0123456785", "thienchi@gmail.com", "nguyenthienchi", "123456");
		kh6.setDiaChi("Quận 6");
		kh6.setQuyenTruyCap(quyen1);
		KhachHang kh7 = new KhachHang("Dương Thiện Hải", "0123456786", "thienhai@gmail.com", "duongthienhai", "123456");
		kh7.setDiaChi("Quận 5");
		kh7.setQuyenTruyCap(quyen1);
		KhachHang kh8 = new KhachHang("Nguyễn Văn Vương", "0123456787", "nguyenvanvuong@gmail.com", "nguyenvanvuong", "123456");
		kh8.setDiaChi("Quận 2");
		kh8.setQuyenTruyCap(quyen1);
		KhachHang kh9 = new KhachHang("Châu Nhật Đăng", "0123456788", "chaunhatdang@gmail.com", "chaunhatdang", "123456");
		kh9.setDiaChi("Quận 3");
		kh9.setQuyenTruyCap(quyen1);
		
		
		khachHangService.save(kh1);
		khachHangService.save(kh2);
		khachHangService.save(kh3);		
		khachHangService.save(kh4);
		khachHangService.save(kh5);
		khachHangService.save(kh6);
		khachHangService.save(kh7);
		khachHangService.save(kh8);
		khachHangService.save(kh9);
		
		NhanVien nv1 = new NhanVien("Nguyen Tien Linh", "0123432323", "linh@gmail.com", "342356443", "Quan 1", TypeGioiTinh.Nam, "nguyentienlinh", "123456");
		NhanVien nv2 = new NhanVien("Mac Hong Quan", "0234232323", "quan@gmail.com", "342356445", "Quan 2", TypeGioiTinh.Nam, "machongquan", "123456");
		NhanVien nv3 = new NhanVien("Nguyen Trong Hoang", "0464232323", "hoang@gmail.com", "342356466", "Quan 3", TypeGioiTinh.Nu, "nguyentronghoang", "123456");
		
		
		nv1.setQuyenTruyCap(quyen2); 
		nv2.setQuyenTruyCap(quyen2); 
		nv3.setQuyenTruyCap(quyen3);
		
		nhanVienService.save(nv1);
		nhanVienService.save(nv2);
		nhanVienService.save(nv3);
		
		
		BanDatTruoc ban1 = new BanDatTruoc(LocalDate.now().toString(), 12, "ghi chú 1", TypeDatTruoc.ChuaXacNhan);
		ban1.setThoiGianDen(LocalTime.of(9, 30).toString());
		System.out.println(ban1.getMaDatTruoc()+"===>");
		List<ChiTietMonDatTruoc> listct1 = new ArrayList<ChiTietMonDatTruoc>();
		listct1.add(new ChiTietMonDatTruoc( new ChiTietMonDatTruocKey(),monAn1, ban1, 2, monAn1.getDonGia()));
		listct1.add(new ChiTietMonDatTruoc( new ChiTietMonDatTruocKey(),monAn2, ban1, 4, monAn2.getDonGia()));
		ban1.setChiTietMonDatTruoc(listct1);
		ban1.setKhachHang(kh2);
		
		BanDatTruoc ban2 = new BanDatTruoc(LocalDate.now().toString(), 12, "ghi chú 1", TypeDatTruoc.ChuaXacNhan);
		ban2.setThoiGianDen(LocalTime.of(8, 30).toString());
		List<ChiTietMonDatTruoc> listct2 = new ArrayList<ChiTietMonDatTruoc>();
		listct2.add(new ChiTietMonDatTruoc( new ChiTietMonDatTruocKey(),monAn2, ban2, 4, monAn2.getDonGia()));
		ban2.setChiTietMonDatTruoc(listct2);
		ban2.setKhachHang(kh3);
		
		
		BanDatTruoc ban3 = new BanDatTruoc(LocalDate.now().toString(), 12, "ghi chú 1", TypeDatTruoc.ChuaXacNhan);
		ban3.setThoiGianDen(LocalTime.of(7, 30).toString());
		List<ChiTietMonDatTruoc> listct3 = new ArrayList<ChiTietMonDatTruoc>();
		ban3.setChiTietMonDatTruoc(listct3);
		ban3.setKhachHang(kh1);
		
	
		banDatTruocService.save(ban1);
		banDatTruocService.save(ban2);
		banDatTruocService.save(ban3);
		
		
		
		HoaDon hoaDon1= new HoaDon(LocalDateTime.of(2021, 4, 21, 8, 07), LocalDateTime.of(2021, 4, 21, 8, 07), TypeHoaDon.DaThanhToan, "khách đến trễ 20'");
		List<ChiTietHoaDon> listcthd1 = new ArrayList<ChiTietHoaDon>();
		hoaDon1.setKhachHang(kh1);
		hoaDon1.setNhanVien(nv1);
		listcthd1.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), monAn1, hoaDon1, 3, monAn1.getDonGia()));
		listcthd1.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), monAn2, hoaDon1, 5, monAn2.getDonGia()));
		listcthd1.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), monAn3, hoaDon1,12, monAn3.getDonGia()));
		hoaDon1.setChiTietHoadon(listcthd1);
		
		
		
		HoaDon hoaDon2= new HoaDon(LocalDateTime.of(2021, 4, 22, 9, 7), LocalDateTime.of(2021, 4, 22, 10, 8), TypeHoaDon.DaThanhToan, "khách thanh toán sau");
		List<ChiTietHoaDon> listcthd2 = new ArrayList<ChiTietHoaDon>();
		listcthd2.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), monAn5, hoaDon2, 3, monAn5.getDonGia()));
		
		hoaDon2.setChiTietHoadon(listcthd2);
		hoaDon2.setKhachHang(kh2);
		hoaDon2.setNhanVien(nv1);
		
		
		
		HoaDon hoaDon3= new HoaDon(LocalDateTime.of(2021, 5, 2, 9, 7), LocalDateTime.of(2021, 5, 2, 10, 8), TypeHoaDon.DaThanhToan, "");
		List<ChiTietHoaDon> listcthd3 = new ArrayList<ChiTietHoaDon>();
		listcthd3.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), monAn2, hoaDon3, 3, monAn2.getDonGia()));
		listcthd3.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), monAn6, hoaDon3, 5, monAn6.getDonGia()));
		
		hoaDon3.setChiTietHoadon(listcthd3);
		hoaDon3.setKhachHang(kh1);
		hoaDon3.setNhanVien(nv3);
		
		
		HoaDon hoaDon4= new HoaDon(LocalDateTime.of(2021, 5, 3, 9, 7), LocalDateTime.of(2021, 5, 3, 11, 8), TypeHoaDon.DaThanhToan, "");
		List<ChiTietHoaDon> listcthd4 = new ArrayList<ChiTietHoaDon>();
		listcthd4.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), monAn3, hoaDon4, 3, monAn3.getDonGia()));
		listcthd4.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), monAn6, hoaDon4, 5, monAn6.getDonGia()));
		
		hoaDon4.setChiTietHoadon(listcthd4);
		hoaDon4.setKhachHang(kh2);
		hoaDon4.setNhanVien(nv2);
		
		
		HoaDon hoaDon5= new HoaDon(LocalDateTime.of(2021, 5, 4, 13, 7), LocalDateTime.of(2021, 5, 4, 13, 30), TypeHoaDon.DaThanhToan, "");
		List<ChiTietHoaDon> listcthd5 = new ArrayList<ChiTietHoaDon>();
		listcthd5.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), monAn3, hoaDon5, 1, monAn3.getDonGia()));
		listcthd5.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), monAn1, hoaDon5, 7, monAn1.getDonGia()));
		
		hoaDon5.setChiTietHoadon(listcthd5);
		hoaDon5.setKhachHang(kh2);
		hoaDon5.setNhanVien(nv2);
		
		
		HoaDon hoaDon6= new HoaDon(LocalDateTime.of(2021, 5, 4, 12, 7), LocalDateTime.of(2021, 5, 4, 13, 30), TypeHoaDon.DaThanhToan, "");
		List<ChiTietHoaDon> listcthd6 = new ArrayList<ChiTietHoaDon>();
		listcthd6.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), monAn2, hoaDon6, 2, monAn2.getDonGia()));
		listcthd6.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), monAn1, hoaDon6, 4, monAn1.getDonGia()));
		
		hoaDon6.setChiTietHoadon(listcthd6);
		hoaDon6.setKhachHang(kh1);
		hoaDon6.setNhanVien(nv2);
		
		HoaDon hoaDon7= new HoaDon(LocalDateTime.of(2021, 5, 5, 12, 7), LocalDateTime.of(2021, 5, 5, 13, 30), TypeHoaDon.DaThanhToan, "");
		List<ChiTietHoaDon> listcthd7 = new ArrayList<ChiTietHoaDon>();
		listcthd7.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), monAn2, hoaDon7, 2, monAn2.getDonGia()));
		listcthd7.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), monAn3, hoaDon7, 1, monAn3.getDonGia()));
		
		hoaDon7.setChiTietHoadon(listcthd7);
		hoaDon7.setKhachHang(kh5);
		hoaDon7.setNhanVien(nv2);
		
		
		HoaDon hoaDon8= new HoaDon(LocalDateTime.of(2021, 5, 6, 12, 7), LocalDateTime.of(2021, 5, 6, 13, 30), TypeHoaDon.DaThanhToan, "");
		List<ChiTietHoaDon> listcthd8 = new ArrayList<ChiTietHoaDon>();
		listcthd8.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), monAn1, hoaDon8, 2, monAn1.getDonGia()));
		listcthd8.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), monAn3, hoaDon8, 1, monAn3.getDonGia()));
		
		hoaDon8.setChiTietHoadon(listcthd8);
		hoaDon8.setKhachHang(kh8);
		hoaDon8.setNhanVien(nv1);
		
		HoaDon hoaDon9= new HoaDon(LocalDateTime.of(2021, 5, 7, 12, 7), LocalDateTime.of(2021, 5, 7, 13, 30), TypeHoaDon.DaThanhToan, "");
		List<ChiTietHoaDon> listcthd9 = new ArrayList<ChiTietHoaDon>();
		listcthd9.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), monAn4, hoaDon9, 1, monAn4.getDonGia()));
		listcthd9.add(new ChiTietHoaDon(new ChiTietHoaDonKey(), monAn3, hoaDon9, 1, monAn3.getDonGia()));
		
		hoaDon9.setChiTietHoadon(listcthd9);
		hoaDon9.setKhachHang(kh7);
		hoaDon9.setNhanVien(nv2);
	
		
		
		hoaDonService.save(hoaDon1);
		hoaDonService.save(hoaDon2);
		hoaDonService.save(hoaDon3);
		hoaDonService.save(hoaDon4);
		hoaDonService.save(hoaDon5);
		hoaDonService.save(hoaDon6);
		hoaDonService.save(hoaDon7);
		hoaDonService.save(hoaDon8);
		hoaDonService.save(hoaDon9);
		
		return loaiMonAn1;
	}
	
	
}
