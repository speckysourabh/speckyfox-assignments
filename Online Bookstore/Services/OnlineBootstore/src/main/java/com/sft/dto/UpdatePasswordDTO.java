package com.sft.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdatePasswordDTO {

	@NotNull
	@NotBlank
	private String email;
	@NotNull
	@NotBlank
	private String currentPassword;
	@NotNull
	@NotBlank
	@Size(min = 5, message = "Password length should be atleast of 5 characters")
	private String newPassword;
	@NotNull
	@NotBlank
	private String confirmPassword;

}
