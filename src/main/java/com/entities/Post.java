package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Post")
@Table(name = "Post")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Serializable{
	@Id
	@Column(name="id", columnDefinition = "int")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPost;
	
	@Column(name="title", columnDefinition = "nvarchar(50)")
	private String title;

	@Column(name="content", columnDefinition = "nvarchar(50)")
	private String content;
	
	@Column(name="tags", columnDefinition = "nvarchar(50)")
	private String tags;
	
	@Column(name="status", columnDefinition = "nvarchar(50)")
	private String status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time", columnDefinition = "datetime")
	private Date createTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time", columnDefinition = "datetime")
	private Date updateTime;
	
	@OneToMany(mappedBy = "post",cascade=CascadeType.ALL)
	private Set<Comment> comments;
	
	@ManyToOne
	@JoinColumn(name = "author_id",  referencedColumnName ="id" )
	private User user;

	@Override
	public String toString() {
		return "Post [idPost=" + idPost + ", title=" + title + ", content=" + content + ", tags=" + tags + ", status="
				+ status + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	
	
}
