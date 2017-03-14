package com.study.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "userId", nullable = false)
	private String userId;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "userName", nullable = false)
	private String userName;
	
	public User() {}
	
	public User(Long id, String userId, String password, String userName) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.userName = userName;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/*
	 * Overriding Method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", password=" + password + ", userName=" + userName + "]";
	}	
	
	/*
	 * Custom Method
	 */
	public boolean isMatchUserId(String userId) {
		return this.userId.equals(userId);
	}
	
	public boolean isMatchPassword(String password) {
		return this.password.equals(password);
	}
}
