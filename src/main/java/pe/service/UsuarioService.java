package pe.service;

import pe.model.LoginForm;
import pe.model.Usuario;

public interface UsuarioService {
	
	public Usuario doLogin(LoginForm loginForm);

}
