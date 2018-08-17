package com.candidjava.spring.bean;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

	@SuppressWarnings("serial")
	@Document
	public abstract class BaseEntity implements Serializable {
	    @Id
	    private String id;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
	    

	}
