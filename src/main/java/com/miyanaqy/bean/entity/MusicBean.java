package com.miyanaqy.bean.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.miyanaqy.base.entity.BaseEntity;

import lombok.Data;

@Data
@Entity
@Table(name = "music_bean")
public class MusicBean extends BaseEntity {
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "music_title")
	private String musicTitle;
	
	@Column(name = "music_describe")
	private String musicDescribe;
	
	@Column(name = "music_cover")
	private String musicCover;
	
	@Column(name = "music_url")
	private String musicUrl;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "state")
	private int state;
	
	@Column(name = "type")
	private int type;
	
	@Column(name = "delete_flag")
	private Integer deleteFlag = 0;//删除标记，0，不删，1已删

    @Column(name = "create_time", columnDefinition = "timestamp", insertable = false, updatable = false)
    @Generated(GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;//创建时间

    @Column(name = "update_time", columnDefinition = "timestamp", insertable = false, updatable = false)
    @Generated(GenerationTime.ALWAYS)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;//更新时间
}
