package com.devnaldo.domain.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devnaldo.domain.execption.NegocioException;
import com.devnaldo.domain.model.Cliente;
import com.devnaldo.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
		Cliente clienteExistente2 = clienteRepository.findBycpf(cliente.getCpf());
		
		
		if (clienteExistente != null && !clienteExistente.equals(cliente) && clienteExistente2 != null && !clienteExistente2.equals(cliente)) {
			throw new NegocioException("Já existe um cliente cadastrado com este e-mail e cpf.");
		}
		
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
	
}