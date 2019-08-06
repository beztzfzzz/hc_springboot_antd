package com.cesi.module.base.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper=false)
public class ResponseMsg extends ResponseBase{
	private boolean success = false;
	private String url;
	private Object data;

	public ResponseMsg() {
		
	}
	public ResponseMsg(String msg) {
		this.success = true;
		super.setMsg(msg);
	}
}
