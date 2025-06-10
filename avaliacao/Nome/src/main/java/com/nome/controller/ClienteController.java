package com.nome.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nome.entities.Cliente;
import com.nome.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;
	public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscaUsuarioControlId(@PathVariable Long id){
        Cliente cliente = clienteService.buscaId(id);
        if(cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Cliente>> buscaTodosUsuariosControl(){
        List<Cliente> clientes = com.nome.service.ClienteService.buscaTodosClientes();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping("/")
    public ResponseEntity<Cliente> salvaUsuariosControl(@RequestBody @Valid Cliente cliente){
        Cliente salvaCliente = clienteService.salvaCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvaCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> alteraUsuarioControl(@PathVariable Long id, @RequestBody @Valid Cliente cliente){
        Cliente alteraCliente = clienteService.alterarCliente(id, cliente);
        if(alteraCliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> apagaClienteControl(@PathVariable Long id){
        boolean apagar = clienteService.apagarUsuario(id);
        if (apagar) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}