package com.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Comment")
@Table(name = "Comment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable{
	@Id
	@Column(name="id", columnDefinition = "int")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idComment;
	
	@Column(name="content", columnDefinition = "nvarchar(50)")
	private String content;
	
	@Column(name="status", columnDefinition = "nvarchar(50)")
	private String status;
	
	@Temporal(TemporalType.TIME)
	@Column(name="create_time", columnDefinition = "time")
	private Date create_time;
	
	@Column(name="author", columnDefinition = "nvarchar(50)")
	private String author;
	
	@Column(name="email", columnDefinition = "nvarchar(50)")
	private String email;
	
	@Column(name="url", columnDefinition = "nvarchar(50)")
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "id_post", referencedColumnName = "id" )
	private Post post;

	@Override
	public String toString() {
		return "Comment [idComment=" + idComment + ", content=" + content + ", status=" + status + ", create_time="
				+ create_time + ", author=" + author + ", email=" + email + ", url=" + url + "]";
	}
	
	
}
