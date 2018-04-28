package com.wesai.utils.sqlUtils;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Spring管理动态数据源类
 * 这个类必须继承AbstractRoutingDataSource， 
 * 且必须实现方法determineCurrentLookupKey，该方法返回一个Object一般是返回字符串 
 */
public class DynamicDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceHandle.getDataSourceType();  
	}
	
}
