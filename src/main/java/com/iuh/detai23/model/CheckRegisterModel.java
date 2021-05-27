package com.iuh.detai23.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data 
public class CheckRegisterModel {
	private boolean sdt;
	private boolean email;
	private boolean account;
	private String sdtString;
	private String emailString;
	private String accountString;
	
}
