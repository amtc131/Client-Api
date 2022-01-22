package com.mx.Client_Rick_Martin_API.client;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.web.client.ResourceAccessException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.mx.Client_Rick_Martin_API.DTO.ApiResponseDTO;
import com.mx.Client_Rick_Martin_API.DTO.Episode;
import com.mx.Client_Rick_Martin_API.DTO.Location;
import com.mx.Client_Rick_Martin_API.DTO.Request;
import com.mx.Client_Rick_Martin_API.DTO.Results;
import com.mx.Client_Rick_Martin_API.utils.ApiRestUtils;

public class ClientApi {

	public void getAllCharacter(Request request) throws ResourceAccessException, Exception {
		JsonNode response = execute(request);

		ApiResponseDTO<Results> character = new ApiRestUtils().converterToOfObject(response,
				new TypeReference<ApiResponseDTO<Results>>() {
				});

		System.out.println(character.getResults().size());

		character.getResults().forEach(r -> {
			System.out.println("Name: " + r.getName());
			System.out.println("Species: " + r.getSpecies());
		});
	}

	public void getMultipleCharacter(Request request) throws ResourceAccessException, Exception {
		JsonNode response = execute(request);

		List<Results> result = new ApiRestUtils().converterToListOfObject(response, new TypeReference<List<Results>>() {
		});

		result.forEach(e -> {
			System.out.println("Id: " + e.getId());
			System.out.println("Name: " + e.getName());
			System.out.println("Episode: " + e.getDimension());
			System.out.println("Air_date:" + e.getGender());
		});

	}

	public void getAllLoacations(Request request) throws ResourceAccessException, Exception {
		JsonNode response = execute(request);

		ApiResponseDTO<Location> character = new ApiRestUtils().converterToOfObject(response,
				new TypeReference<ApiResponseDTO<Location>>() {
				});

		System.out.println(character.getResults().size());

		character.getResults().forEach(r -> {
			System.out.println("Name: " + r.getName());
			System.out.println("Dimension: " + r.getDimension());
		});
	}

	public void getMultipleLoacations(Request request) throws ResourceAccessException, Exception {
		JsonNode response = execute(request);

		List<Location> episodes = new ApiRestUtils().converterToListOfObject(response,
				new TypeReference<List<Location>>() {
				});

		episodes.forEach(e -> {
			System.out.println("Name: " + e.getName());
			System.out.println("Residents" + e.getResidents());
		});
	}

	public void getAllEpisodes(Request request) throws ResourceAccessException, Exception {
		JsonNode response = execute(request);

		ApiResponseDTO<Episode> character = new ApiRestUtils().converterToOfObject(response,
				new TypeReference<ApiResponseDTO<Episode>>() {
				});

		System.out.println(character.getResults().size());

		character.getResults().forEach(r -> {
			System.out.println("Name: " + r.getName());
			System.out.println("Episode: " + r.getEpisode());
		});
	}

	public void getMultipleEpisodes(Request request) throws ResourceAccessException, Exception {
		JsonNode response = execute(request);

		List<Episode> episodes = new ApiRestUtils().converterToListOfObject(response,
				new TypeReference<List<Episode>>() {
				});

		episodes.forEach(e -> {
			System.out.println("Name: " + e.getName());
			System.out.println("Episode: " + e.getEpisode());
			System.out.println("Air_date:" + e.getAirDate());
		});
	}

	private JsonNode execute(Request request) throws ResourceAccessException, Exception {
		String qury = ApiRestUtils.createRequest(request);
		ApiRequest client = new ApiRequest(HttpMethod.GET, String.format("/%s", qury));
		return client.execute();
	}

}
