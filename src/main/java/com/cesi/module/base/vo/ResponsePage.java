package com.cesi.module.base.vo;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper=false)
public class ResponsePage extends ResponseBase{
	
	public final static int PAGE_SIZE = 30;//默认页数
	
	private long pages;
	private long count;
	private List<Object> data;
	
}
