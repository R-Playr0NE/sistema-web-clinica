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

import br.com.sistemaclinica.clinica.entity.Cliente;
import br.com.sistemaclinica.clinica.service.ClienteService;
import br.com.sistemaclinica.clinica.service.ConsultaService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    /* Acrescentei */

    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/listar")
    public String Listar(Model model) {
        List<Cliente> clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "cliente/listarcliente";
    }

    @GetMapping("/criar")
    public String criarForm(Model model){
        model.addAttribute("cliente", new Cliente());
        // Acrescentei
        model.addAttribute("consultas", consultaService.findAll());
        return "cliente/formularioCliente";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/clientes/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable("id") Integer id, Model model){
        Cliente cliente = clienteService.findById(id);
        model.addAttribute("cliente", cliente);
        // Acrescentei
        model.addAttribute("consultas", consultaService.findAll());
        return "cliente/formularioCliente";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id){
        clienteService.deleteById(id);
        return "redirect:/clientes/listar";
    }

}
