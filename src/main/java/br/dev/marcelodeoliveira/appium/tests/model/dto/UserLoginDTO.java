package br.dev.marcelodeoliveira.appium.tests.model.dto;

public class UserLoginDTO {
	public UserLoginDTO(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	private String email, password;
}
