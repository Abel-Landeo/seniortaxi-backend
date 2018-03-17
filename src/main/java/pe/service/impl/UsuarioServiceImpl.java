package pe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.dao.UsuarioDao;
import pe.model.LoginForm;
import pe.model.Usuario;
import pe.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioDao usuarioDao;

	@Override
	public Usuario doLogin(LoginForm loginForm) {
		return usuarioDao.doLogin(loginForm);
	}

}
