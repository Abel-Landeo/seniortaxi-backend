package pe.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.model.LoginForm;
import pe.model.Usuario;
import pe.service.UsuarioService;

@RestController
@RequestMapping(value="/login")
public class LoginController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value="/doLogin", method=RequestMethod.POST, consumes="application/json")
	public HashMap<String, Object> doLogin(@RequestBody LoginForm loginForm){
		HashMap<String, Object> res = new HashMap<>();
		Usuario usuario = usuarioService.doLogin(loginForm);
		if(usuario == null) {
			res.put("status", "NOT_FOUND");
		}else {
			res.put("status", "OK");
			res.put("usuario",usuario);
		}
		return res;
	}

}
