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

import br.com.sistemaclinica.clinica.entity.Consulta;
import br.com.sistemaclinica.clinica.service.ClienteService;
import br.com.sistemaclinica.clinica.service.ConsultaService;
import br.com.sistemaclinica.clinica.service.MedicoService;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    // Injeção de dependências da service de consultas e de Medicos e pacientes(clientes)
    
    @Autowired
    private ConsultaService service;

    // Envia lista cliente
    @Autowired
    private ClienteService clienteService;

    // Envia lista medico
    @Autowired
    private MedicoService medicoService;



    @GetMapping("/listar")
    public String Listar(Model model) {
        List<Consulta> consultas = service.findAll();
        model.addAttribute("consultas", consultas);
        return "consulta/listarConsultas";
    }

    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("consulta", new Consulta());
        // Envia as listas cliente e médico
        model.addAttribute("clientes", clienteService.findAll());
        model.addAttribute("medicos", medicoService.findAll());
        return "consulta/formularioConsultas";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Consulta consulta){
        service.save(consulta);
        return "redirect:/consultas/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable("id") Integer id, Model model){
        Consulta consulta = service.findById(id);
        model.addAttribute("consulta", consulta);
        // Envia as listas cliente e medico
        model.addAttribute("clientes", clienteService.findAll());
        model.addAttribute("medicos", medicoService.findAll());
        return "consulta/formularioConsultas";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id){
        service.deleteById(id);
        return "redirect:/consultas/listar";
    }

}
