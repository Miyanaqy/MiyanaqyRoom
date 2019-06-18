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
	private Integer page_index;
	//@ApiModelProperty(value = "每页记录数")
	private Integer page_size;
	//@ApiModelProperty( value = "附加查询条件")
	private String main_condition;
	//@ApiModelProperty(value = "状态")
	private Integer state;
	//@ApiModelProperty(value = "状态")
	private Integer type;
	
	private Long userId;
	
}
