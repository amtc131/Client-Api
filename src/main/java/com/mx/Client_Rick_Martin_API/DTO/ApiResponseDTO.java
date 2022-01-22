package com.mx.Client_Rick_Martin_API.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiResponseDTO <T>{

	@JsonProperty("info")
	private InfoDTO info;

	@JsonProperty("results")
	private List<T> results;

	
	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	public InfoDTO getInfo() {
		return info;
	}

	public void setInfo(InfoDTO info) {
		this.info = info;
	}

}
