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
import sv.edu.udb.entity.Caso;
import sv.edu.udb.model.CasosModel;
import sv.edu.udb.model.GerenteModel;
import sv.edu.udb.model.MecanicoModel;
import sv.edu.udb.model.VehiculoModel;

/**
 *
 * @author neon
 */
@Controller
@RequestMapping("caso")
public class CasosController {

    CasosModel mecModel = new CasosModel();
    GerenteModel gerente = new GerenteModel();
    VehiculoModel vehiculo = new VehiculoModel();
    MecanicoModel meca = new MecanicoModel();

    @RequestMapping("list")
    public String listarCasos(Model model) {

        model.addAttribute("listarCasos", mecModel.listarCasos());
        if (model == null) {
            return null;
        } else {
            return "caso/listar";
        }
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String nuevoCasos(Model model) {
        //se le pasa a la vista el objeto que debe llenarse desde el formulario
        model.addAttribute("listaMecanicos", meca.listarMecanicos());
        model.addAttribute("listaVehiculo", vehiculo.listarVehiculos());
        model.addAttribute("listaGerente", gerente.listarGerentes());
        model.addAttribute("caso", new Caso());

        return "caso/nuevo";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String insertarCasos(@ModelAttribute("caso") Caso caso,
            Model model, RedirectAttributes atributos) {
        int variable = mecModel.insertarCaso(caso);
        System.out.println("Valor es" + variable);
        if (variable > 0) {
            //si se insertó, se pasa el mensaje de éxito
            atributos.addFlashAttribute("exito", "Caso registrado exitosamente");

            //redireccion en el caso hacia el metodo listarCasos()
            return "redirect:/caso/list";
        } else {
            //si no insertó regresamos al formulario de ingreso
            model.addAttribute("caso", caso);
            return "caso/nuevo";
        }
    }

    @RequestMapping(value = "edit/{codigo}", method = RequestMethod.GET)
    public String obtenerCasos(@PathVariable("codigo") int codigo, Model model) {
        model.addAttribute("caso", mecModel.obtenerCaso(codigo));

        return "caso/editar";
    }

    @RequestMapping(value = "edit/{codigo}", method = RequestMethod.POST)
    public String modificarCasos(Caso caso, Model model,
            RedirectAttributes atributos) {
        if (mecModel.modificarCaso(caso) > 0) {
            atributos.addFlashAttribute("exito", "Caso modificado exitosamente");

            return "redirect:/caso/list";
        } else {
            model.addAttribute("caso", caso);

            return "caso/editar";
        }
    }

    @RequestMapping("delete/{codigo}")
    public String eliminarCasos(@PathVariable("codigo") int codigo, Model model, RedirectAttributes atributos) {
        if (mecModel.eliminarCaso(codigo) > 0) {
            atributos.addFlashAttribute("exito", "Caso eliminado exitosamente");
        } else {
            atributos.addFlashAttribute("fracaso", "No se puede eliminar esta caso");
        }

        return "redirect:/caso/list";
    }

}
