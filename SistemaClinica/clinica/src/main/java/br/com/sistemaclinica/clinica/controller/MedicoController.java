package br.com.sistemaclinica.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sistemaclinica.clinica.dto.AgendaMedico;
import br.com.sistemaclinica.clinica.entity.Medico;
import br.com.sistemaclinica.clinica.service.ConsultaService;
import br.com.sistemaclinica.clinica.service.MedicoService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/medicos")
public class MedicoController {
    
    @Autowired
    private MedicoService service;

    /* Acrescentei */

    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/listar")
    public String Listar(Model model) {
        List<Medico> medicos = service.findAll();
        model.addAttribute("medicos", medicos);
        return "medico/listarmedico";
    }

    @GetMapping("/criar")
    public String criarForm(Model model){
        model.addAttribute("medico", new Medico());
        // Acrescentei
        model.addAttribute("consultas", consultaService.findAll());
        return "medico/formularioMedico";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Medico medico){
        service.save(medico);
        return "redirect:/medicos/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable("id") Integer id, Model model){
        Medico medico = service.findById(id);
        model.addAttribute("medico", medico);
        //Acrescentei
        model.addAttribute("consultas", consultaService.findAll());
        return "medico/formularioMedico";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id){
        service.deleteById(id);
        return "redirect:/medicos/listar";
    }

    // Para Listar o nome nome e a especialidade do médico(DTO)
    @GetMapping("/listar-nome-especialidade")
    public String listarNomeEspecialidade(Model model) {
        List<AgendaMedico> medicos = service.buscarNomeEspecialidade();
        model.addAttribute("Medicos", medicos);
        return "medico/listarMedico";
    }

    // endpoint que retorna a lista da DTO (agenda)
    @GetMapping("/agenda")
    public String listarAgenda(Model model) {
        List<AgendaMedico> agenda = service.buscarAgendaComConsultas();
        model.addAttribute("agendaMedicos", agenda); // nome claro e minúsculo
        return "medico/agenda"; // view: src/main/resources/templates/medico/agenda.html
    }
    
}
