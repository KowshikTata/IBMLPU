package com.example.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Image {
	private String imageID;
	private String imageUrl;
	private boolean isAvailable;
	{
		this.imageID=UUID.randomUUID().toString();
	}
	
}
