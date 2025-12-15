package br.com.sistemaclinica.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemaclinica.clinica.dto.AgendaMedico;
import br.com.sistemaclinica.clinica.entity.Medico;
import br.com.sistemaclinica.clinica.repository.MedicoRepository;

@Service
public class MedicoService {
    
    @Autowired
    private MedicoRepository repository;

    public Medico save(Medico medico){
        return repository.save(medico);
    }

    public List<Medico> findAll(){
        return repository.findAll();
    }

    public Medico findById(Integer id){
        return repository.findById(id).orElse(null);
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    //Método para buscar o nome e a especialidade do médico
    public List<AgendaMedico> buscarNomeEspecialidade() {
        return repository.buscarNomeEspecialidade();
    }

    //Método para busccar os dados da consulta
    public List<AgendaMedico> buscarAgendaComConsultas() {
        return repository.buscarAgendaComConsultas();
    }

}
