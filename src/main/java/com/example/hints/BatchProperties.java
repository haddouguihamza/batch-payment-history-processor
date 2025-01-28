package com.example.hints;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.application.batch.resource")
public class BatchProperties {
	
	private String fileName;

	/**
	 * @return the name
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param name the name to set
	 */
	public void setFileName(String name) {
		this.fileName = name;
	}

}
