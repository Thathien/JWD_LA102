package com.modal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostUpdateModal {
	@NotNull
	private String id;
	@NotBlank(message="Tittle not blank")
	@Length(min=10, max=150,message="Tittle has charater between 10 and 150")
	private String title;
	@NotBlank(message="content not blank")
	@Length(min=10, max=150,message="content has charater between 10 and 150")
	private String content;
	@NotBlank(message="content not blank")
	@Length(min=10, max=150,message="content has charater between 10 and 150")
	private String tags;
	@Range(min=1,max=3,message="status invalid")
	private String status;
}
