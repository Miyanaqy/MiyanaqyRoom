package com.miyanaqy.bean.entity;

import com.miyanaqy.base.entity.BaseEntity;

import lombok.Data;

@Data
public class ArticleBean extends BaseEntity {
	
	private Long user_id;
	
	private String article_title;
	
	private String article_content;
	
	private String article_cover;
	
	private String article_describe;
	
	private String author;
	
	private int state;
	
	private int type;

}
