package br.com.tt.cliente;

import static br.com.tt.util.HttpClient.get;
import static br.com.tt.util.Util.jsonToObject;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.tt.exception.SistemaException;
import br.com.tt.model.CadastroReceita;
import br.com.tt.util.HttpClient;
import br.com.tt.util.Util;


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

	public CadastroReceita consultaReceita(String cnpj ) throws SistemaException {
		
		
		return jsonToObject(get("https://www.receitaws.com.br/v1/cnpj/"+cnpj), CadastroReceita.class);
		
	}
	
	public static void main(String[] args) throws SistemaException {
		
		CadastroReceita cad = new ClienteService().consultaReceita("00000000000191");
		
		System.out.println(cad.getFantasia());
		
	}
	
}
