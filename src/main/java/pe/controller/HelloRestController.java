package pe.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/hello")
public class HelloRestController {
	
	@RequestMapping(value="/helloworld")
	public HashMap<String, Object> helloWorld(){
		HashMap<String, Object> res= new HashMap<>();
		res.put("status", "OK");
		res.put("msgServer", "Running in Tomcat 9");
		return res;
	}
}
