package com.naruto.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年4月5日
 */
public class SchoolEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	private String name;

	private String code;

	private String memo;

	private String prop1;

	private String prop2;

	private String adduser;

	private Date addtime;

	private String modifyuser;

	private Date modifytime;

	public SchoolEntity() {
		super();
	}

	public SchoolEntity(long id, String name, String code, String memo, String prop1, String prop2, String adduser, Date addtime,
			String modifyuser, Date modifytime) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.memo = memo;
		this.prop1 = prop1;
		this.prop2 = prop2;
		this.adduser = adduser;
		this.addtime = addtime;
		this.modifyuser = modifyuser;
		this.modifytime = modifytime;
	}

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

	@Override
	public String toString() {
		return "SchoolEntity [id=" + id + ", name=" + name + ", code=" + code + ", memo=" + memo + ", prop1=" + prop1 + ", prop2=" + prop2
				+ ", adduser=" + adduser + ", addtime=" + addtime + ", modifyuser=" + modifyuser + ", modifytime=" + modifytime + "]";
	}

}
