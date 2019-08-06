package com.cesi.module.base.controller;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.cesi.module.base.binder.DateEditor;
import com.cesi.module.base.binder.StringEscapeEditor;
import com.cesi.module.base.constant.CommonEnum;
import com.cesi.module.base.response.ResponseMsg;

import java.util.Date;

/**
 * @description：基础 controller
 */
public abstract class BaseController {

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        /**
         * 自动转换日期类型的字段格式
         */
        binder.registerCustomEditor(Date.class, new DateEditor());

        /**
         * 防止XSS攻击
         */
        binder.registerCustomEditor(String.class, new StringEscapeEditor());
    }


    /**
     * ajax失败
     * @param msg 失败的消息
     * @return {Object}
     */
    public Object renderError(String msg) {
    	ResponseMsg result = new ResponseMsg();
    	result.setCode(CommonEnum.ResponseCode.FAIL.getCode());
        result.setMsg(msg);
        return result;
    }

    /**
     * ajax成功
     * @return {Object}
     */
    public Object renderSuccess() {
    	ResponseMsg result = new ResponseMsg();
        result.setSuccess(true);
        return result;
    }

    /**
     * ajax成功
     * @param msg 消息
     * @return {Object}
     */
    public Object renderSuccess(String msg) {
        ResponseMsg result = new ResponseMsg();
        result.setSuccess(true);
        result.setMsg(msg);
        return result;
    }

    /**
     * ajax成功
     * @param obj 成功时的对象
     * @return {Object}
     */
    public Object renderSuccess(Object obj) {
    	ResponseMsg result = new ResponseMsg();
        result.setSuccess(true);
        result.setData(obj);
        return result;
    }
    
}
