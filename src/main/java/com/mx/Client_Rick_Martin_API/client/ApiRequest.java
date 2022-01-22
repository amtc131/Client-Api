package com.mx.Client_Rick_Martin_API.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.mx.Client_Rick_Martin_API.error.ServiceException;

public class ApiRequest {

	private final static Logger LOGGER = LoggerFactory.getLogger(ApiRequest.class);

	private static final String ENDPOINT = "https://rickandmortyapi.com/api";

	private final String path;

	private final HttpMethod method;

	private RestTemplate restTemplate;

	public ApiRequest(HttpMethod method, String path) {
		this.path = path;
		this.method = method;
		this.restTemplate = new RestTemplate();
	}

	public static String fullApiUrl(final String path) {
		return ENDPOINT.concat(path);
	}

	public JsonNode execute() throws ResourceAccessException, Exception {

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<>(headers);

		ResponseEntity<JsonNode> response = restTemplate.exchange(fullApiUrl(path), method, request, JsonNode.class);
		
		if (response.getStatusCodeValue() == 200) {
			return response.getBody();
		} else {
			throw new ServiceException(
					"Error: La API de Rick and Morty, entrega el siguiente status:" + response.getStatusCode());
		}
	}

}
