package pe.model;

import java.io.Serializable;

public class LoginForm implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public String login;
	public String clave;
	
	public LoginForm() {
	
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
}
