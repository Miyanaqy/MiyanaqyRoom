package com.miyanaqy.bean.entity;

import com.miyanaqy.base.entity.BaseEntity;

import lombok.Data;

@Data
public class CommentBean extends BaseEntity {
	
	private Long user_id;
	
	private Long article_id;
	
	private String comment_content;
	
	private String author;
	
	private Long comment_id;
	
	private int state;
	
	private int type;

}
