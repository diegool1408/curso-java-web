package br.com.tt.cliente;

import java.io.IOException;
import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.tt.model.CadastroReceita;
import br.com.tt.util.HttpClient;


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

	public CadastroReceita consultaReceita(String cnpj ) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		String url = "https://www.receitaws.com.br/v1/cnpj/00000000000191";
		String receitaJson = HttpClient.get(url);
		CadastroReceita cadReceita = mapper.readValue(receitaJson, CadastroReceita.class);
		
		System.out.println(cadReceita.getFantasia());
		return null;
		
	}
	
	public static void main(String[] args) throws Exception {
		
		new ClienteService().consultaReceita("");
		
	}
	
}
