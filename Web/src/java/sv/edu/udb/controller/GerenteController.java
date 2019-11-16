/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sv.edu.udb.entity.Gerente;
import sv.edu.udb.model.GerenteModel;

/**
 *
 * @author neon
 */
@Controller
@RequestMapping("gerente")
public class GerenteController {
 
    GerenteModel mecModel = new GerenteModel();
    
    @RequestMapping("list")
    public String listarGerente(Model model) {

        model.addAttribute("listarGerente", mecModel.listarGerentes());
        if(model == null){
            return null;
        }else{
          return "gerente/listar";   
        }       
    }
    
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String nuevoGerente(Model model){
        //se le pasa a la vista el objeto que debe llenarse desde el formulario
        model.addAttribute("gerente", new Gerente());
        
        return "gerente/nuevo";
    }
    
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String insertarGerente(@Valid @ModelAttribute("gerente") Gerente gerente,
            BindingResult result, Model model, RedirectAttributes atributos){
        
         if(result.hasErrors()){
            model.addAttribute("gerente", gerente);
            return "gerente/nuevo";
        }
            
        
        int variable = mecModel.insertarGerente(gerente);
        System.out.println("Valor es" + variable);
        if (variable>0) {
            //si se insertó, se pasa el mensaje de éxito
            atributos.addFlashAttribute("exito", "Gerente registrado exitosamente");
            
            //redireccion en el gerente hacia el metodo listarGerente()
            return "redirect:/gerente/list";
        }else{
            //si no insertó regresamos al formulario de ingreso
            model.addAttribute("gerente", gerente);
            return "gerente/nuevo";
        }
    }
    
    @RequestMapping(value = "edit/{codigo}", method = RequestMethod.GET)
    public String obtenerGerente(@PathVariable("codigo") int codigo, Model model){
        model.addAttribute("gerente", mecModel.obtenerGerente(codigo));
        
        return "gerente/editar";
    }
    
    @RequestMapping( value = "edit/{codigo}", method = RequestMethod.POST)
    public String modificarGerente(@Valid Gerente gerente, BindingResult result, Model model, 
            RedirectAttributes atributos){
        if(result.hasErrors()){
            model.addAttribute("gerente",gerente);
            return "gerente/editar";
        }
        
        if (mecModel.modificarGerente(gerente)>0) {
            atributos.addFlashAttribute("exito", "Gerente modificado exitosamente");
            
            return "redirect:/gerente/list";
        } else {
            model.addAttribute("gerente", gerente);
            
            return "gerente/editar";
        }
    }
    
    @RequestMapping("delete/{codigo}")
    public String eliminarGerente(@PathVariable("codigo") int codigo, Model model, RedirectAttributes atributos){
        if (mecModel.eliminarGerente(codigo)>0) {
            atributos.addFlashAttribute("exito", "Gerente eliminado exitosamente");
        } else {
            atributos.addFlashAttribute("fracaso", "No se puede eliminar esta gerente");
        }
        
        return "redirect:/gerente/list";
    }
    
}
