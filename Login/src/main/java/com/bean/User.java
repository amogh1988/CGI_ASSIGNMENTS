package com.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class User {
private String emailid;
private String password;
private String usertyp;

public User() {
	super();
}
public User(String emailid, String password, String usertyp) {
	super();
	this.emailid = emailid;
	this.password = password;
	this.usertyp = usertyp;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUsertyp() {
	return usertyp;
}
public void setUsertyp(String usertyp) {
	this.usertyp = usertyp;
}
@Override
public String toString() {
	return "User [emailid=" + emailid + ", password=" + password + ", usertyp=" + usertyp + "]";
}

}
