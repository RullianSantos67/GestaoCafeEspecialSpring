package br.edu.ifsuldeminas.mch.springbootcrud.controller;

import br.edu.ifsuldeminas.mch.springbootcrud.model.entity.Fazenda;
import br.edu.ifsuldeminas.mch.springbootcrud.model.repository.FazendaRepository;
import br.edu.ifsuldeminas.mch.springbootcrud.model.repository.ProdutorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
public class FazendaController {

    @Autowired
    private FazendaRepository fazendaRepository;
    @Autowired
    private ProdutorRepository produtorRepository;

    @GetMapping("/fazendas")
    public String listar(Model model) {
        model.addAttribute("fazendas", fazendaRepository.findAll());
        return "fazendas/list";
    }

    @GetMapping("/fazendas/novo")
    public String novo(Model model) {
        model.addAttribute("fazenda", new Fazenda());
        model.addAttribute("produtores", produtorRepository.findAll());
        return "fazendas/form";
    }

    @PostMapping("/fazendas/salvar")
    public String salvar(@Valid @ModelAttribute("fazenda") Fazenda fazenda, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Se houver erros, recarrega a lista de produtores para o formulário
            model.addAttribute("produtores", produtorRepository.findAll());
            return "fazendas/form";
        }
        fazendaRepository.save(fazenda);
        return "redirect:/fazendas";
    }

    @GetMapping("/fazendas/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Optional<Fazenda> fazendaOpt = fazendaRepository.findById(id);
        if (fazendaOpt.isEmpty()) {
            throw new IllegalArgumentException("Fazenda inválida.");
        }
        model.addAttribute("fazenda", fazendaOpt.get());
        model.addAttribute("produtores", produtorRepository.findAll());
        return "fazendas/form";
    }

    @GetMapping("/fazendas/deletar/{id}")
    public String deletar(@PathVariable("id") Long id) {
        if (!fazendaRepository.existsById(id)) {
            throw new IllegalArgumentException("Fazenda inválida.");
        }
        fazendaRepository.deleteById(id);
        return "redirect:/fazendas";
    }
}