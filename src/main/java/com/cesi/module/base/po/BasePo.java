package com.cesi.module.base.po;

import java.io.Serializable;

import javax.persistence.Transient;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class BasePo implements Serializable{
	
	@Transient
	private Integer page = 1;
	@Transient
	private Integer limit = 1;
}
