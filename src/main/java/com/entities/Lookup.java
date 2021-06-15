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

@Entity(name = "Lookup")
@Table(name="Lookup")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lookup implements Serializable{
	@Id
	@Column(name="id", columnDefinition = "int")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLookup;
	
	@Column(name="name", columnDefinition = "nvarchar(50)")
	private String name;
	
	@Column(name="code", columnDefinition = "nvarchar(50)")
	private String code;
	
	@Column(name="type", columnDefinition = "nvarchar(50)")
	private String type;
	
	@Column(name="position", columnDefinition = "nvarchar(50)")
	private String position;

	@Override
	public String toString() {
		return "Lookup [idLookup=" + idLookup + ", name=" + name + ", code=" + code + ", type=" + type + ", position="
				+ position + "]";
	}
	
}
