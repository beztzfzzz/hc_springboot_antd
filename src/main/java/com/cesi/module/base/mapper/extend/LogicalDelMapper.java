package com.cesi.module.base.mapper.extend;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.UpdateProvider;

import com.cesi.module.base.mapper.extend.provider.LogicalDelProvider;


public interface LogicalDelMapper<T> {
	
	@UpdateProvider(type = LogicalDelProvider.class, method = "dynamicSQL")
    @Options(useCache = false, useGeneratedKeys = false)
    int logicalDelByPrimaryKey(Object key);
	
	@UpdateProvider(type = LogicalDelProvider.class, method = "dynamicSQL")
	@Options(useCache = false, useGeneratedKeys = false)
	int logicalDel(T record);
}
