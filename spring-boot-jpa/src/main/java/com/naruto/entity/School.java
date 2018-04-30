package com.naruto.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年4月15日
 */
@Entity
@DynamicUpdate // 设置为true,表示update对象的时候,生成动态的update语句,如果这个字段的值是null就不会被加入到update语句中, 在更新时获取到实体对象 不加这个注解时 默认值为false
public class School implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(length = 50)
	private String name;

	@Column
	private String code;

	@Column
	private String memo;

	@Column
	private String prop1;

	@Column
	private String prop2;

	@Column
	private String adduser;

	@Column
	private Date addtime;

	@Column
	private String modifyuser;

	@Column
	private Date modifytime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getProp1() {
		return prop1;
	}

	public void setProp1(String prop1) {
		this.prop1 = prop1;
	}

	public String getProp2() {
		return prop2;
	}

	public void setProp2(String prop2) {
		this.prop2 = prop2;
	}

	public String getAdduser() {
		return adduser;
	}

	public void setAdduser(String adduser) {
		this.adduser = adduser;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getModifyuser() {
		return modifyuser;
	}

	public void setModifyuser(String modifyuser) {
		this.modifyuser = modifyuser;
	}

	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + ", code=" + code + ", memo=" + memo + ", prop1=" + prop1 + ", prop2=" + prop2
				+ ", adduser=" + adduser + ", addtime=" + addtime + ", modifyuser=" + modifyuser + ", modifytime=" + modifytime + "]";
	}

}
