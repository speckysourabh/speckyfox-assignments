package com.sft.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	@NotBlank(message = "Email cannot be blank")
	@NotNull(message = "Email cannot be null")
	@Email(message = "Field should be a valid email")
	private String email;
	@NotBlank(message = "Password cannot be blank")
	@NotNull(message = "Password cannot be null")
	@Size(min = 5, message = "Password length should be atleast of 5 characters")
	private String password;
	@NotBlank(message = "Role cannot be blank")
	@NotNull(message = "Role cannot be null")
	private String role;
}