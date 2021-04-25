package com.iuh.detai23.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMonAnModel {
	private int maMonAn;
	private String tenMonAn;
	private double DonGia;
	private String moTa;
	private String hinhAnh;
	private String tinhTrang;
	private int maLoaiMonAn;
}
