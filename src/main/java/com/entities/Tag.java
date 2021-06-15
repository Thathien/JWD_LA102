package com.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Tag")
@Table(name="Tag")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tag implements Serializable{
	@Id
	@Column(name="id", columnDefinition = "int")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTag;
	
	@Column(name="name", columnDefinition = "nvarchar(50)")
	private String name;
	
	@Column(name="frequency", columnDefinition = "nvarchar(50)")
	private String frequency;

	@Override
	public String toString() {
		return "Tag [idTag=" + idTag + ", name=" + name + ", frequency=" + frequency + "]";
	}
	
}
