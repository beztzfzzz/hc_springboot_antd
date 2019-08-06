package com.cesi.module.base.constant;

public final class CommonEnum {
	
	private CommonEnum() {}
	
	public static enum ResponseCode {
		SUCCESS(0),FAIL(-1);
		int code;
		ResponseCode(int code) {
			this.code = code;
		}
		public int getCode() {
			return this.code;
		}
	}
	
	public static enum Status {
		INVALID(0,"无效"),
		VALID(1,"有效");
		int value;
		String name;
		Status(int value, String name){
			this.value = value;
			this.name = name;
		}
		public int getValue() {
			return this.value;
		}
	}
	
	public static enum LogType{
		INFO(1,"info"),
		ERROR(2,"error");
		int value;
		String name;
		LogType(int value, String name){
			this.value = value;
			this.name = name;
		}
		public int getValue() {
			return this.value;
		}
		public String getName() {
			return this.name;
		}
	}
	
	public static enum YesOrNo {
		NO,YES
	}
	
	public static enum IsDel{
		NO(0,"否"),
		YES(1,"是");
		int value;
		String name;
		IsDel(int value, String name){
			this.value = value;
			this.name = name;
		}
		public int getValue() {
			return this.value;
		}
		public String getName() {
			return this.name;
		}
		public static String getNameByValue(Integer value){
			if(value == null) return null;
			for(IsDel e: IsDel.values()) {
				if(e.value == value) {
					return e.name;
				}
			}
			return null;
		}
	}
}
