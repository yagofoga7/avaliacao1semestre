package com.nome.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.nome.entities.Cliente;
import com.nome.repository.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public List<Cliente> buscaTodosUsuarios() {
		return clienteRepository.findAll();
	}

	public Cliente buscaId(Long id) {
		Optional<Cliente> cliente = java.util.Optional.empty();
		return cliente.orElse(null);
	}

	public Cliente salvaCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente alterarCliente(Long id, Cliente alterarU) {
		Optional<Cliente> existeCliente = clienteRepository.findById(id);
		if (existeCliente.isPresent()) {
			alterarU.setId(id);
			return clienteRepository.save(alterarU);
		}
		return null;
	}

public boolean apagarUsuario(Long id) {
	Optional<Cliente> existeCliente = clienteRepository.findById(id);
	if (existeCliente.isPresent()) {
		clienteRepository.deleteById(id);
		return true;
	}
	return false;
}

public static List<Cliente> buscaTodosClientes() {
	return null;
   }


}