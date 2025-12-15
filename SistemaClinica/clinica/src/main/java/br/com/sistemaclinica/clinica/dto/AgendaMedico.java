package br.com.sistemaclinica.clinica.dto;

import java.time.LocalDateTime;

public class AgendaMedico {

    private String nomeMedico;
    private String especialidade;
    // consulta
    private LocalDateTime dataehoraConsulta;
    private String observacoes;

    public AgendaMedico() {
    }

    // Construtor com campos o medico
    public AgendaMedico(String nomeMedico, String especialidade) {
        this.nomeMedico = nomeMedico;
        this.especialidade = especialidade;

    }

    // Construtor com campos de consulta (se a query retornar também data/obs)
    public AgendaMedico(String nomeMedico, String especialidade,
                        LocalDateTime dataehoraConsulta, String observacoes) {
        this.nomeMedico = nomeMedico;
        this.especialidade = especialidade;
        this.dataehoraConsulta = dataehoraConsulta;
        this.observacoes = observacoes;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }
    public String getEspecialidade(){
        return especialidade;
    }
    // consulta
    public LocalDateTime getDataehoraConsulta() {
        return dataehoraConsulta;
    }
    public String getObservacoes() {
        return observacoes;
    }

}
