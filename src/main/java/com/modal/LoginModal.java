package com.modal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginModal {
	
	@NotBlank(message="Username must be not bank")
	@Length(min=1, max=40, message="UserName min charater is 1 and max is 40")
	private String username;
	
	@NotBlank(message="Username must be not bank")
	@Length(min=1, max=40, message="UserName min charater is 1 and max is 40")
	private String password;
}
