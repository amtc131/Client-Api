package com.mx.Client_Rick_Martin_API.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Results {

	@JsonProperty("id")
	private int id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("status")
	private String status;

	@JsonProperty("species")
	private String species;

	@JsonProperty("type")
	private String type;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("origin")
	private Origin origin;

	@JsonProperty("location")
	private Location location;

	@JsonProperty("image")
	private String image;

	@JsonProperty("episode")
	private List<String> episodesUrl;

	@JsonProperty("url")
	private String url;

	@JsonProperty("created")
	private String created;

	@JsonProperty("dimension")
	private String dimension;

	@JsonProperty("residents")
	private List<String> residents;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public List<String> getResidents() {
		return residents;
	}

	public void setResidents(List<String> residents) {
		this.residents = residents;
	}

}
