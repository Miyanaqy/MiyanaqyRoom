package com.miyanaqy.bean.entity;

import com.miyanaqy.base.entity.BaseEntity;

import lombok.Data;

@Data
public class AlbumBean extends BaseEntity {
	
	private Long user_id;
	
	private String album_title;
	
	private String album_describe;
	
	private String album_cover;	
	
	private int state;
	
	private int type;

}
