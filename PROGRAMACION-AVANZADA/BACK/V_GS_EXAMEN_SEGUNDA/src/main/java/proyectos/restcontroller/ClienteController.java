package proyectos.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyectos.modelo.entity.Cliente;
import proyectos.modelo.repository.ClienteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private ClienteRepository crepo;
	
	@GetMapping("/todos")
	public List<Cliente> getMethodName() {
		return crepo.findAll();
	}
	

}
