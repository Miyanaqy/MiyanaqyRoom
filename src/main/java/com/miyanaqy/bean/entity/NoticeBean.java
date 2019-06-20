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
@Table(name = "notice_bean")
public class NoticeBean extends BaseEntity {
	
	@Column(name = "notice_title")
	private String noticeTitle;
	
	@Column(name = "notice_content")
	private String noticeContent;
	
	@Column(name = "notice_describe")
	private String noticeDescribe;
	
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
