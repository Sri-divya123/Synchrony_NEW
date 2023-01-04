package com.synchrony.Synchrony.Entites;

import java.util.Arrays;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class ImageEntitiy {
	
	@Id
	private Long id;
	private String name;
	private String type;
	
	@Lob
	private byte[] imageData;

	public ImageEntitiy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImageEntitiy(Long id, String name, String type, byte[] imageData) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.imageData = imageData;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	@Override
	public String toString() {
		return "ImageEntitiy [id=" + id + ", name=" + name + ", type=" + type + ", imageData="
				+ Arrays.toString(imageData) + "]";
	}

	

}
