package com.iuh.detai23.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMonAnEditDatBanModel {
	private int id;
	private int soLuong;
	private String tenMonAn;
	private double tongTien;
	private int stt;
}
