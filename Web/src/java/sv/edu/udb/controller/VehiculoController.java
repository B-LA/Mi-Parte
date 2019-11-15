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
import sv.edu.udb.entity.Vehiculo;
import sv.edu.udb.model.ClienteModel;
import sv.edu.udb.model.VehiculoModel;

/**
 *
 * @author neon
 */
@Controller
@RequestMapping("vehiculo")
public class VehiculoController {
    
    VehiculoModel mecModel = new VehiculoModel();
    ClienteModel cli = new ClienteModel();
    
    @RequestMapping("list")
    public String listarVehiculo(Model model) {

        model.addAttribute("listarVehiculo", mecModel.listarVehiculos());
        if(model == null){
            return null;
        }else{
          return "vehiculo/listar";   
        }       
    }
    
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String nuevoVehiculo(Model model){
        //se le pasa a la vista el objeto que debe llenarse desde el formulario
        model.addAttribute("listarClientes", cli.listarClientes());
        model.addAttribute("vehiculo", new Vehiculo());
        
        return "vehiculo/nuevo";
    }
    
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String insertarVehiculo(@ModelAttribute("vehiculo") Vehiculo vehiculo,
            Model model, RedirectAttributes atributos){
        int variable = mecModel.insertarVehiculo(vehiculo);
        System.out.println("Valor es" + variable);
        if (variable>0) {
            //si se insertó, se pasa el mensaje de éxito
            atributos.addFlashAttribute("exito", "Vehiculo registrado exitosamente");
            
            //redireccion en el vehiculo hacia el metodo listarVehiculo()
            return "redirect:/vehiculo/list";
        }else{
            //si no insertó regresamos al formulario de ingreso
            model.addAttribute("vehiculo", vehiculo);
            return "vehiculo/nuevo";
        }
    }
    
    @RequestMapping(value = "edit/{codigo}", method = RequestMethod.GET)
    public String obtenerVehiculo(@PathVariable("codigo") int codigo, Model model){
        model.addAttribute("vehiculo", mecModel.obtenerVehiculo(codigo));
        
        return "vehiculo/editar";
    }
    
    @RequestMapping( value = "edit/{codigo}", method = RequestMethod.POST)
    public String modificarVehiculo(Vehiculo vehiculo, Model model, 
            RedirectAttributes atributos){
        if (mecModel.modificarVehiculo(vehiculo)>0) {
            atributos.addFlashAttribute("exito", "Vehiculo modificado exitosamente");
            
            return "redirect:/vehiculo/list";
        } else {
            model.addAttribute("vehiculo", vehiculo);
            
            return "vehiculo/editar";
        }
    }
    
    @RequestMapping("delete/{codigo}")
    public String eliminarVehiculo(@PathVariable("codigo") int codigo, Model model, RedirectAttributes atributos){
        if (mecModel.eliminarVehiculo(codigo)>0) {
            atributos.addFlashAttribute("exito", "Vehiculo eliminado exitosamente");
        } else {
            atributos.addFlashAttribute("fracaso", "No se puede eliminar esta vehiculo");
        }
        
        return "redirect:/vehiculo/list";
    }
    
}
