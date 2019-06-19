package com.miyanaqy.bean.entity;

import com.miyanaqy.base.entity.BaseEntity;

import lombok.Data;

@Data
public class MusicBean extends BaseEntity {
	
	private Long user_id;
	
	private String music_title;
	
	private String music_describe;
	
	private String music_cover;
	
	private String music_url;
	
	private int state;
	
	private int type;

}
