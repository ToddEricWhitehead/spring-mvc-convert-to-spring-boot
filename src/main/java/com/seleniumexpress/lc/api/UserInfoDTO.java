package com.seleniumexpress.lc.api;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInfoDTO {
	
	@NotBlank(message = "* Your Name can Not be blank")
	@Size(min=3, max=15, message="{userName.size}")
	private String userName; // = "Mr Macho";

	@NotBlank(message = "* Crush Name can Not be blank")
	@Size(min=3, max=15, message="* Crush Name should be at least 3 characters")
	private String crushName; // = "Doll Face";
	
//	@AssertTrue(message="You have to agree")
	private boolean termAndCondition;
	
	private String result;
	
	public UserInfoDTO() {
		System.out.println("Called UserInfoDTO()");
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCrushName() {
		return crushName;
	}
	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}

	public boolean isTermAndCondition() {
		return termAndCondition;
	}
	public void setTermAndCondition(boolean termAndCondition) {
		this.termAndCondition = termAndCondition;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "UserInfoDTO [userName=" + userName + ", crushName=" + crushName + ", termAndCondition="
				+ termAndCondition + ", result=" + result + "]";
	}
	
	
	
}
