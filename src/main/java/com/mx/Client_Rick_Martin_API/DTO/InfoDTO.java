package com.mx.Client_Rick_Martin_API.DTO;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;

@ApiModel("info")
public class InfoDTO implements Serializable {

	private static final long serialVersionUID = -6237429225170456042L;

	@JsonProperty("count")
	private int count;

	@JsonProperty("pages")
	private int pages;

	@JsonProperty("next")
	private String next;

	@JsonProperty("prev")
	private String prev;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrev() {
		return prev;
	}

	public void setPrev(String prev) {
		this.prev = prev;
	}

}
