package com.iuh.detai23.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoaiMonAn {
	@Id
	@SequenceGenerator(name = "maLoaiMonAn_seq", allocationSize = 1)
	@GeneratedValue(generator = "maLoaiMonAn_seq")
	private int maLoaiMonAn;
	private String tenLoai;
	private String moTa;

	public LoaiMonAn(String tenLoai, String moTa) {
		super();
		this.tenLoai = tenLoai;
		this.moTa = moTa;
	}

}
