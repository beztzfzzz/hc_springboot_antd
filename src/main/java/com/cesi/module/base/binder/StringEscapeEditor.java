package com.cesi.module.base.binder;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang3.StringEscapeUtils;

import com.cesi.module.base.util.StringUtils;


public class StringEscapeEditor extends PropertyEditorSupport{

	@Override
	public void setAsText(String text) {
		setValue(StringUtils.isBlank(text) ? null : StringEscapeUtils.escapeHtml4(text.trim()));
	}
}
