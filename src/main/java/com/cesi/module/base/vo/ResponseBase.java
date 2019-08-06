package com.cesi.module.base.vo;


import lombok.Data;

import java.io.Serializable;

import com.cesi.module.base.constant.CommonEnum;

@SuppressWarnings("serial")
@Data
public abstract class ResponseBase implements Serializable {
	
	private int code = CommonEnum.ResponseCode.SUCCESS.getCode();
	private String msg;
}
