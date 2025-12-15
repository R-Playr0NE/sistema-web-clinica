package br.com.sistemaclinica.clinica.entity;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idMedico;

    @Column(nullable = false, length = 40)
    private String nomeMedico;

    private Integer crm;
    
    @Column(nullable = false, length = 50)
    private String especialidade;

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas;

}
