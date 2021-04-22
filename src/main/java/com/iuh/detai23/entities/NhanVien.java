package com.iuh.detai23.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.iuh.detai23.type.TypeGioiTinh;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien {
	@Id
	@SequenceGenerator(name = "maNhanVien_seq", allocationSize = 1)
	@GeneratedValue(generator = "maNhanVien_seq")
	private int maNhanVien;
	private String tenNhanVien;
	private String soDienThoai;
	private String email;
	private String chungMinhNhanDan;
	private String diaChi;
	private TypeGioiTinh gioiTinh;
	private String matKhau;

	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private QuyenTruyCap quyenTruyCap;

	public NhanVien(String tenNhanVien, String soDienThoai, String email, String chungMinhNhanDan, String diaChi,
			TypeGioiTinh gioiTinh, String matKhau) {
		super();
		this.tenNhanVien = tenNhanVien;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.chungMinhNhanDan = chungMinhNhanDan;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.matKhau = matKhau;
	}

	
	
}
