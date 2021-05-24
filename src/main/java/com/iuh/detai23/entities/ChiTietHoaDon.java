package com.iuh.detai23.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "ChiTietHoaDon")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ChiTietHoaDon {
	
	@EmbeddedId
	private ChiTietHoaDonKey chiTietHoaDon;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "maMonAn_key")
	@MapsId(value = "maMonAn")
	private MonAn monAn;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "maHoaDon_key")
	@MapsId(value = "maHoaDon")
	private HoaDon hoaDon;
	
	private int soLuong; 
	private double donGia;
	public ChiTietHoaDon(MonAn monAn, HoaDon hoaDon, int soLuong, double donGia) {
		super();
		this.monAn = monAn;
		this.hoaDon = hoaDon;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}
	
	
}
