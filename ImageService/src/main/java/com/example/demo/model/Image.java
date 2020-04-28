package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="image")
public class Image {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String desc;
	private String url;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Image(String desc, String url) {
		super();
		this.desc = desc;
		this.url = url;
	}
	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Image [id=" + id + ", desc=" + desc + ", url=" + url + "]";
	}
	
}
