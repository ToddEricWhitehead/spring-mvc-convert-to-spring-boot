package com.seleniumexpress.lc.api;

import org.springframework.stereotype.Component;

@Component
public class Info {

	private String serverIp = "122.222.333.22";

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}
	
	
	
}
