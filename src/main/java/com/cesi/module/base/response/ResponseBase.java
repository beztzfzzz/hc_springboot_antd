package com.cesi.module.base.response;


import com.cesi.module.base.constant.CommonEnum;
import lombok.Data;

import java.io.Serializable;



@Data
public abstract class ResponseBase implements Serializable {
	private int code = CommonEnum.ResponseCode.SUCCESS.getCode();
	private String msg;
}
