package com.mx.Client_Rick_Martin_API.utils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.Client_Rick_Martin_API.DTO.Request;

public class ApiRestUtils {

	private static ObjectMapper mapper = new ObjectMapper();

	public <T> List<T> converterToListOfObject(JsonNode json, TypeReference<List<T>> typeRf) throws IOException {
		List<T> response = mapper.convertValue(json, typeRf);
		System.out.println("class name: " + response.get(0).getClass().getName());
		return response;
	}

	public <T> T converterToOfObject(JsonNode json, TypeReference<T> typeRf) throws IOException {
		return (T) mapper.convertValue(json, typeRf);
	}

	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public static <T> T createRequest(Request request) throws IllegalArgumentException, IllegalAccessException {
		StringBuilder parameters = new StringBuilder("");
		if (Objects.nonNull(request)) {
			parameters.append(request.getClassName());
			
			if(evaluateTypeParameter(request)){
				parameters.append("/?");
				Class aClass = Request.class;
				Field[] fields = request.getClass().getDeclaredFields();
				for (Field field : fields) {
					field.setAccessible(true);
					if (Objects.nonNull(field.get(request)) && StringUtils.compare(field.getName(), "serialVersionUID") != 0
							&& field.getType() != List.class && StringUtils.compare(field.getName(), "className") != 0) {
						parameters.append(field.getName()).append("=").append(field.get(request)).append("&");
					}
				}
			}else {
				parameters.append("/").append(request.getIds());
			}

		}

		if (StringUtils.isNotBlank(parameters) && parameters.toString().contains("&")) {
			int idx = parameters.lastIndexOf("&");
			parameters = parameters.deleteCharAt(idx);
		}

		return (T) parameters.toString();
	}

	
	private static boolean evaluateTypeParameter(Request request) {
		return CollectionUtils.isEmpty(request.getIds());
	}
	
}
