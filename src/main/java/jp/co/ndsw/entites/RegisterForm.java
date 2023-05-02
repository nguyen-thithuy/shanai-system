package jp.co.ndsw.entites;

import jakarta.validation.constraints.NotBlank;

public class RegisterForm {
	@NotBlank
	private String no;
	
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    public RegisterForm() {
    }

    public String getNo() {
    	return no;
    }
    public void setNo(String no) {
    	this.no = no;
    }
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
