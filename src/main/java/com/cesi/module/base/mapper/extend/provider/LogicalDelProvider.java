package com.cesi.module.base.mapper.extend.provider;

import org.apache.ibatis.mapping.MappedStatement;

import com.cesi.module.base.constant.CommonEnum;

import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

public class LogicalDelProvider extends MapperTemplate{

	public LogicalDelProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
		super(mapperClass, mapperHelper);
	}
	
	public String logicalDelByPrimaryKey(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
        sql.append(" set is_del = " + CommonEnum.IsDel.YES.getValue());
        sql.append(SqlHelper.wherePKColumns(entityClass));
        return sql.toString();
    }
	
	public String logicalDel(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
        sql.append(" set is_del = " + CommonEnum.IsDel.YES.getValue());
        sql.append(SqlHelper.whereAllIfColumns(entityClass, isNotEmpty()));
        return sql.toString();
    }
}
