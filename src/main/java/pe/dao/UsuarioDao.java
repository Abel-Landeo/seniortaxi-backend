package pe.dao;

import pe.model.LoginForm;
import pe.model.Usuario;

public interface UsuarioDao {
	
	public Usuario doLogin(LoginForm loginForm);

}
