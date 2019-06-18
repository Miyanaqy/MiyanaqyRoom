package com.miyanaqy.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;


@Mapper
public interface BaseMapper<T> {

	@InsertProvider(type = DaoSQLCreator.class, method = "insert")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	int insert(T entity);
	
	
	/**
	 * 插入指定表数据
	 * @param entity
	 * @param tableName 表名称
	 * @return
	 */
	@InsertProvider(type = DaoSQLCreator.class, method = "insertTable")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	int insertTable(T entity, String tableName);

	@InsertProvider(type = DaoSQLCreator.class, method = "insertAll")
	@Options(useGeneratedKeys = false)
	int insertAll(@Param("list") List<T> entitys);


	@InsertProvider(type = DaoSQLCreator.class, method = "insertTableAll")
	@Options(useGeneratedKeys = false)
	int insertTableAll(@Param("list") List<T> entitys, @Param("tableName") String tableName);

	@UpdateProvider(type = DaoSQLCreator.class, method = "updateByPK")
	int updateByPrimaryKey(T entity);

	/**
	 * 更新指定表数据
	 * @param entity
	 * @param tableName 表名称
	 * @return
	 */
	@UpdateProvider(type = DaoSQLCreator.class, method = "updateTableByPK")
	int updateTableByPrimaryKey(T entity, String tableName);
	
	@SelectProvider(type = DaoSQLCreator.class, method = "getObjectById")
	T getObjectById(T entity);
	
	@SelectProvider(type = DaoSQLCreator.class, method = "getObjectAll")
	List<T> getObjectAll(T entity);

}
