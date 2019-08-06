package com.cesi.module.base.vo;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper=false)
public class ResponseList extends ResponseBase{
	
	private List<Object> data;

}
