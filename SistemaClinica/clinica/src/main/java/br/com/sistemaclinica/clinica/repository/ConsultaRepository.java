package br.com.sistemaclinica.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistemaclinica.clinica.entity.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
    
}
