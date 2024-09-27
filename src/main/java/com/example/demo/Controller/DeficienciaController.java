package com.example.demo.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Optional;
import com.example.demo.Form.Pessoa.DeficienciaForm;
import com.example.demo.Model.Categoria;
import com.example.demo.Model.Deficiencia;
import com.example.demo.Repository.CategoriaRepository;
import com.example.demo.Repository.DeficienciaRepository;
import com.example.demo.Service.DeficienciaService;


import jakarta.validation.Valid;

@Controller
public class DeficienciaController {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Autowired
    private DeficienciaService deficienciaService;

    @GetMapping("/deficiencia")
    public String index(){
        return "deficiencia/listar";
    }
    
    
    @GetMapping("/deficiencia/create")
    public String create(Model model) {
        DeficienciaForm deficienciaForm = new DeficienciaForm();
        
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        deficienciaForm.setListCategorias(listaCategorias);
    
        model.addAttribute("deficienciaForm", deficienciaForm);
    
        return "deficiencia/create";
    }
    
    @PostMapping("/deficiencia/create")
    public String create(@Valid DeficienciaForm deficienciaForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        deficienciaForm.setListCategorias(listaCategorias);
    
        model.addAttribute("deficienciaForm", deficienciaForm);
        
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/deficiencia/create";
        }
    
        redirectAttributes.addFlashAttribute("successMessage", "Salvo com sucesso!");
        deficienciaService.create(deficienciaForm);
        
        return "redirect:/deficiencia";
    }
    
    // @GetMapping("/deficiencia/update/{id}")
    // public String update(@PathVariable Long id, Model model){
    //     Optional<Deficiencia> deficiencia = deficienciaRepository.findById(id);
    
    //     DeficienciaForm deficienciaForm = new DeficienciaForm(deficiencia.orElseThrow());
    
    //     List<Deficiencia> listaDeficiencias = deficienciaRepository.findAll();
    //     deficienciaForm.setListDeficiencias(listaDeficiencias);
    
    //     model.addAttribute("deficienciaForm", deficienciaForm);
    //     model.addAttribute("id", deficiencia.orElseThrow().getId());
    
    //     return "/deficiencia/update";
    // }
    
    // @GetMapping("/deficiencia/visualizar/{id}")
    // public String visualizar(@PathVariable Long id, Model model){
    //     Optional<Deficiencia> deficiencia = deficienciaRepository.findById(id);
    
    //     DeficienciaForm deficienciaForm = new DeficienciaForm(deficiencia.orElseThrow());
    
    //     List<Deficiencia> listaDeficiencias = deficienciaRepository.findAll();
    //     deficienciaForm.setListDeficiencias(listaDeficiencias);
    
    //     model.addAttribute("deficienciaForm", deficienciaForm);
    //     model.addAttribute("id", deficiencia.orElseThrow().getId());
    
    //     return "/deficiencia/visualizar";
    // }
    
    // @PostMapping("/deficiencia/update/{id}")
    // public String update(@PathVariable Long id, @Valid DeficienciaForm deficienciaForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
    //     List<Deficiencia> listaDeficiencias = deficienciaRepository.findAll();
    //     deficienciaForm.setListDeficiencias(listaDeficiencias);
    
    //     model.addAttribute("deficienciaForm", deficienciaForm);
    
    //     if(bindingResult.hasErrors()){
    //         model.addAttribute("errors", bindingResult.getAllErrors());
    //         return "/deficiencia/update";
    //     }
    
    //     deficienciaService.update(deficienciaForm, id);      
    
    //     redirectAttributes.addFlashAttribute("successMessage", "Alterado com sucesso!");
    //     return "redirect:/deficiencia";
    // }
    
    // @GetMapping("/deficiencia/remover/{id}")
    // public String remover(@PathVariable Long id, RedirectAttributes redirectAttributes) {
    //     Optional<Deficiencia> deficiencia = this.deficienciaRepository.findById(id);
    //     Deficiencia deficienciaModel = deficiencia.get();
    
    //     if (deficienciaModel.isAtivo()) {
    //         deficienciaModel.setAtivo(false);    
    //         redirectAttributes.addFlashAttribute("successMessage", 
    //         "Excluído com sucesso!");
    //     }else{
    //         deficienciaModel.setAtivo(true);
    //         redirectAttributes.addFlashAttribute("successMessage", 
    //         "Recuperado com sucesso!");
    //     }
        
    //     this.deficienciaRepository.save(deficienciaModel);
        
    //     return "redirect:/deficiencia";        
    // }
    
}
