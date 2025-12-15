package br.com.sistemaclinica.clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sistemaclinica.clinica.dto.AgendaMedico;
import br.com.sistemaclinica.clinica.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    
    // Listar nome e especialidade do médico
    @Query("SELECT new br.com.sistemaclinica.clinica.dto.AgendaMedico(m.nomeMedico, m.especialidade) FROM Medico m")
    List<AgendaMedico> buscarNomeEspecialidade();

    // Incluir dados de CONSULTA (retorna uma Agenda por consulta)
    // Observe o uso exato do nome do atributo da entidade: dataehoraConsulta
    @Query("SELECT new br.com.sistemaclinica.clinica.dto.AgendaMedico(m.nomeMedico, m.especialidade, c.dataehoraConsulta, c.observacoes) " +
           "FROM Consulta c JOIN c.medico m")
    List<AgendaMedico> buscarAgendaComConsultas();
}
