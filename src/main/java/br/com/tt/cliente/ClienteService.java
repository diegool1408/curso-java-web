package br.com.tt.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	public Cliente salvar(Cliente cliente) {
		return repository.save(cliente);
		
	}

	public Cliente buscar(Long id) {
						
		return repository.findOne(id);
	}

	public void excluir(Long id) {
		
		repository.delete(id);
		
	}

	
	
}
