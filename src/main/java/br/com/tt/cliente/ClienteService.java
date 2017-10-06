package br.com.tt.cliente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository; 
	
	List<Cliente> consulta(){
		/*	List<Cliente> clientes = new ArrayList<>();

		clientes.add(new Cliente(1L, "Carlos", "032", new Date()));
		clientes.add(new Cliente(2L, "Jose", "033", new Date()));
		clientes.add(new Cliente(3L, "Maria", "034", new Date()));
		clientes.add(new Cliente(4L, "Joao", "035", new Date()));*/
		

		
		return repository.findAll();
	}

	public void salvar(Cliente cliente) {
		repository.save(cliente);
		
	}

	
	
}
