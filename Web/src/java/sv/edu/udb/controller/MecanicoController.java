/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sv.edu.udb.entity.Mecanico;
import sv.edu.udb.model.MecanicoModel;

/**
 *
 * @author neon
 */
@Controller
@RequestMapping("mecanico")
public class MecanicoController {
    
    MecanicoModel mecModel = new MecanicoModel();
    
    @RequestMapping("list")
    public String listarMecanico(Model model) {

        model.addAttribute("listarMecanico", mecModel.listarMecanicos());

        return "mecanico/listar";
    }
    
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String nuevoMecanico(Model model){
        //se le pasa a la vista el objeto que debe llenarse desde el formulario
        model.addAttribute("mecanico", new Mecanico());
        
        return "mecanico/nuevo";
    }
    
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String insertarMecanico(@ModelAttribute("mecanico") Mecanico mecanico,
            Model model, RedirectAttributes atributos){
        
        if (mecModel.insertarMecanico(mecanico)>0) {
            //si se insertó, se pasa el mensaje de éxito
            atributos.addFlashAttribute("exito", "Mecanico registrado exitosamente");
            
            //redireccion en el cliente hacia el metodo listarMecanico()
            return "redirect:/mecanico/list";
        }else{
            //si no insertó regresamos al formulario de ingreso
            model.addAttribute("mecanico", mecanico);
            return "mecanicos/nuevo";
        }
    }
    
    @RequestMapping(value = "edit/{codigo}", method = RequestMethod.GET)
    public String obtenerMecanico(@PathVariable("codigo") int codigo, Model model){
        model.addAttribute("mecanico", mecModel.obtenerMecanico(codigo));
        
        return "mecanico/editar";
    }
    
    @RequestMapping( value = "edit/{codigo}", method = RequestMethod.POST)
    public String modificarMecanico(Mecanico mecanico, Model model, 
            RedirectAttributes atributos){
        if (mecModel.modificarMecanico(mecanico)>0) {
            atributos.addFlashAttribute("exito", "Mecanico modificado exitosamente");
            
            return "redirect:/mecanico/list";
        } else {
            model.addAttribute("mecanico", mecanico);
            
            return "mecanico/editar";
        }
    }
    
    @RequestMapping("delete/{codigo}")
    public String eliminarMecanico(@PathVariable("codigo") String codigo, Model model, RedirectAttributes atributos){
        if (mecModel.eliminarMecanico(codigo)>0) {
            atributos.addFlashAttribute("exito", "Mecanico eliminado exitosamente");
        } else {
            atributos.addFlashAttribute("fracaso", "No se puede eliminar esta mecanico");
        }
        
        return "redirect:/mecanico/list";
    }
    
}


