package com.iuh.detai23.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KhachHang {
	@Id
	@SequenceGenerator(name = "maKhachHang_seq", allocationSize = 1)
	@GeneratedValue(generator = "maKhachHang_seq")  
	private int maKhachHang;  
	private String tenKhachHang;  
	private String sdt;  
	private String email;  
	private String tenTaiKhoan;  
	private String matKhau;  
	private String diaChi;  
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private QuyenTruyCap quyenTruyCap;

	public KhachHang(String tenKhachHang, String sdt, String email, String tenTaiKhoan, String matKhau) {
		super();
		this.tenKhachHang = tenKhachHang;
		this.sdt = sdt;
		this.email = email;
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
	}
	
	
}
