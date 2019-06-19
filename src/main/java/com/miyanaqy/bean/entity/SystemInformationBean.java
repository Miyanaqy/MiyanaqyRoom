package com.miyanaqy.bean.entity;

import com.miyanaqy.base.entity.BaseEntity;

import lombok.Data;

@Data
public class SystemInformationBean extends BaseEntity {
	
	private String si_title;
	
	private String si_content;
	
	private String si_describe;
	
	private String send_ids;
	
	private int state;
	
	private int type;

}
