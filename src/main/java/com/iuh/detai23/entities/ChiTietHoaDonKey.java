package com.iuh.detai23.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ChiTietHoaDonKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "maMonAn_key")
	private int maMonAn;
	@Column(name = "maHoaDon_key")
	private int maHoaDon;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHoaDonKey other = (ChiTietHoaDonKey) obj;
		if (maHoaDon != other.maHoaDon)
			return false;
		if (maMonAn != other.maMonAn)
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maHoaDon;
		result = prime * result + maMonAn;
		return result;
	}
	
	
}
