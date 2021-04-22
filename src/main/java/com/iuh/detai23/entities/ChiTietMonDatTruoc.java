package com.iuh.detai23.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data

@NoArgsConstructor
@AllArgsConstructor
public class ChiTietMonDatTruoc {
	
	
	@EmbeddedId
	private ChiTietMonDatTruocKey chiTietMonDatTruoc;
	
	@ManyToOne
	@JoinColumn
	@MapsId(value = "maMonAn")
	private MonAn monAn;
	
	@ManyToOne
	@JoinColumn
	@MapsId(value = "maDatTruoc")
	private BanDatTruoc banDatTruoc;
	
	private int soLuong;
	private double donGia;
	public ChiTietMonDatTruoc(MonAn monAn, BanDatTruoc banDatTruoc, int soLuong, double donGia) {
		super();
		this.monAn = monAn;
		this.banDatTruoc = banDatTruoc;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}
	
	
}
