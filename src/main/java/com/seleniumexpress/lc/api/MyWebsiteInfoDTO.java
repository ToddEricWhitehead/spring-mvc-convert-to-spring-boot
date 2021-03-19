package com.seleniumexpress.lc.api;

public class MyWebsiteInfoDTO {

	public MyWebsiteInfoDTO() {
		System.out.println("MyWebsiteInfoDTO constructor");
	}
	private String websiteName;
	private String websiteCategory;
	
	public String getWebsiteName() {
		return websiteName;
	}
	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}
	public String getWebsiteCategory() {
		return websiteCategory;
	}
	public void setWebsiteCategory(String websiteCategory) {
		this.websiteCategory = websiteCategory;
	}
	
}
