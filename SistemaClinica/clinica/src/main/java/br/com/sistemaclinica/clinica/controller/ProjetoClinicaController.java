package br.com.sistemaclinica.clinica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/clinica")
public class ProjetoClinicaController {
    
    @GetMapping
    public String index(Model model){
        return "index";
    }

}
