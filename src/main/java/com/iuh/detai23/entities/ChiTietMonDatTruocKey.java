package com.iuh.detai23.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChiTietMonDatTruocKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "maMonAn")
	private int maMonAn;
	@Column(name = "maDatTruoc")
	private int maDatTruoc;
}
