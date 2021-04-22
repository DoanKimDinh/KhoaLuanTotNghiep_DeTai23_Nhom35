package com.iuh.detai23.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.iuh.detai23.type.TypeQuuyen;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuyenTruyCap {
	@Id
	@SequenceGenerator(name = "maQuyenTruyCap_seq", allocationSize = 1)
	@GeneratedValue(generator = "maQuyenTruyCap_seq")
	private int maQuyenTruyCap;
	private TypeQuuyen tenQuyenTruyCap;
	public QuyenTruyCap(TypeQuuyen tenQuyenTruyCap) {
		super();
		this.tenQuyenTruyCap = tenQuyenTruyCap;
	}
	
	
}
