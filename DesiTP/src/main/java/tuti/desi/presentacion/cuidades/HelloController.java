package tuti.desi.presentacion.cuidades;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String Saludo() {
		return "HELLO WORLD ! ";
	}
}
