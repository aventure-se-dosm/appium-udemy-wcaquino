package br.dev.marcelodeoliveira.appium.tests.model.dto;

public class UserSignUpDTO {
	public UserSignUpDTO(String name, UserLoginDTO user) {
		super();
		this.name = name;
		this.email = user.getEmail();
		this.password = user.getPassword();
	}

	public UserSignUpDTO(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public UserSignUpDTO(String email, String password) {
		this("NO_NAME", email, password);
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public UserLoginDTO getLoginUserDTO() {
		return new UserLoginDTO(getEmail(), getPassword());
	}

	private String name, email, password;
}
