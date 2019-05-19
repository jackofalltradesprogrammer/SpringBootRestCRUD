package com.harpreet.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"field1", "field2"})
public class SomeBean {
	
	private String field1;
	private String field2;
	
	// We can use @JsonIgnore to ignore this field in the JSON repsonse
//	@JsonIgnore
	private String field3;
	
	public SomeBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}
	public final String getField1() {
		return field1;
	}
	public final void setField1(String field1) {
		this.field1 = field1;
	}
	public final String getField2() {
		return field2;
	}
	public final void setField2(String field2) {
		this.field2 = field2;
	}
	public final String getField3() {
		return field3;
	}
	public final void setField3(String field3) {
		this.field3 = field3;
	}
	
}
