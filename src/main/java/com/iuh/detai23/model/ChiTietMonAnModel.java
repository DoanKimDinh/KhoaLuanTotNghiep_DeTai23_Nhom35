package com.iuh.detai23.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietMonAnModel {
	private String tenMonAn;
	private double donGia;
	private int soLuong;
}
