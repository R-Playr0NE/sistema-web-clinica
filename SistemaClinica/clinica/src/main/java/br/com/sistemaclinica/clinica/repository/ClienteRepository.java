package br.com.sistemaclinica.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistemaclinica.clinica.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
}
