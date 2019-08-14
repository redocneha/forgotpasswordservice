package com.example.demo;

public class Person {
private String email;
@Override
public String toString() {
	return "Person [email=" + email + "]";
}
private String password;
private String confpass;
private String option;
private String otp;
public String getOtp() {
	return otp;
}
public void setOtp(String otp) {
	this.otp = otp;
}
public String getOption() {
	return option;
}
public void setOption(String option) {
	this.option = option;
}
private String ans1;
private String ans2;
public String getAns1() {
	return ans1;
}
public void setAns1(String ans1) {
	this.ans1 = ans1;
}
public String getAns2() {
	return ans2;
}
public void setAns2(String ans2) {
	this.ans2 = ans2;
}
public String getChoice() {
	return choice;
}
public void setChoice(String choice) {
	this.choice = choice;
}
private String choice;
public String getConfpass() {
	return confpass;
}
public void setConfpass(String confpass) {
	this.confpass = confpass;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
