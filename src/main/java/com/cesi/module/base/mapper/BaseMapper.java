package com.cesi.module.base.mapper;


import com.cesi.module.base.mapper.extend.LogicalDelMapper;

import tk.mybatis.mapper.common.Mapper;

public interface BaseMapper<T> extends Mapper<T>, LogicalDelMapper<T> {

}
