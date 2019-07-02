 package com.miyanaqy.bean.vo;

import lombok.Data;

/**
 * 查询Bean
 * @author lin
 */
@Data
public class QueryBean {
	//@ApiModelProperty(value = "名称")
	private String name;
	private Integer examine;
	//@ApiModelProperty(value = "开始时间")
	private String start_time;
	//@ApiModelProperty(value = "结束时间")
	private String end_time;
	//@ApiModelProperty(value = "页数",dataType="Integer")
	private Integer pageIndex;
	//@ApiModelProperty(value = "每页记录数")
	private Integer pageSize;
	//@ApiModelProperty( value = "附加查询条件")
	private String mainCondition;
	//@ApiModelProperty(value = "状态")
	private Integer state;
	//@ApiModelProperty(value = "状态")
	private Integer type;
	
	private String title;
	
	private Long userId;
	
	public Integer getPageIndex() {
		if (pageIndex == null) return 0;
		return pageIndex - 1;
	}
	
	public Integer getPageSize() {
		if (pageSize == null) return 10;
		return pageSize;
	}
	
}
