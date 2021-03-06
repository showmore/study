package cn.joyair.mvcproject.model;

import java.util.Date;

public class User {
	private String id;
	private String name;
	private String identity;
	private int type;
	private String phone;
	private String identity_type;
	private int gender;
	private Date birthday;
	private String belongs_to;
	
	public User() {
		super();
	}
	
	public User(String id, String name, String identity, int type, String phone, String identity_type, int gender,
			Date birthday, String belongs_to) {
		super();
		this.id = id;
		this.name = name;
		this.identity = identity;
		this.type = type;
		this.phone = phone;
		this.identity_type = identity_type;
		this.gender = gender;
		this.birthday = birthday;
		this.belongs_to = belongs_to;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", identity=" + identity + ", type=" + type + ", phone=" + phone
				+ ", identity_type=" + identity_type + ", gender=" + gender + ", birthday=" + birthday + ", belongs_to="
				+ belongs_to + "]";
	}

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIdentity_type() {
		return identity_type;
	}
	public void setIdentity_type(String identity_type) {
		this.identity_type = identity_type;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getBelongs_to() {
		return belongs_to;
	}
	public void setBelongs_to(String belongs_to) {
		this.belongs_to = belongs_to;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	
	
}
