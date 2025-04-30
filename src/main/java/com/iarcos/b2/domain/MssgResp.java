package com.iarcos.b2.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MssgResp implements Serializable {
	
	
	private static final long serialVersionUID = -3568526210855425908L;
	
	private int statusCode;
	private Date timestamp;
	private String message;
	private String descrip;

}
