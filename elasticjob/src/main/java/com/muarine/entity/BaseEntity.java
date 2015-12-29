package com.muarine.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * POJO公共类
 * @author maoyun@rtmap.com
 *
 */
@SuppressWarnings("serial")
public class BaseEntity  implements Serializable{

	private Long id;

	private Date create_time;

    private Date modify_time;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	
}
