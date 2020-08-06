package com.computer.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
 
@Entity
@Table(name = "App_User", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "APP_USER_UK", columnNames = "User_Name") })
public class AppUser {
 
    @Id
    @GeneratedValue
    @Column(name = "User_Id", nullable = false)
    private Long userId;
 
    @Column(name = "User_Name", length = 36, nullable = false)
    private String userName;
 
    @Column(name = "Encryted_Password", length = 128, nullable = false)
    private String encrytedPassword;
 
    @Column(name = "Enabled", length = 1, nullable = false)
    private boolean enabled;
    
    @Column(name = "SDT_USER", length = 11, nullable = true)
    private String sdt_user;
    
    @Column(name = "CMND_USER", length = 20, nullable = true)
    private String cmnd_user;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) 
    private Collection<Hoadon> hoadon;
    
    
    public Collection<Hoadon> getHoadon() {
		return hoadon;
	}

	public void setHoadon(Collection<Hoadon> hoadon) {
		this.hoadon = hoadon;
	}

	public String getSdt_user() {
		return sdt_user;
	}

	public void setSdt_user(String sdt_user) {
		this.sdt_user = sdt_user;
	}

	public String getCmnd_user() {
		return cmnd_user;
	}

	public void setCmnd_user(String cmnd_user) {
		this.cmnd_user = cmnd_user;
	}

	public Long getUserId() {
        return userId;
    }
 
    public void setUserId(Long userId) {
        this.userId = userId;
    }
 
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    public String getEncrytedPassword() {
        return encrytedPassword;
    }
 
    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }
 
    public boolean isEnabled() {
        return enabled;
    }
 
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
 
}
