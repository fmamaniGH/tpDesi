package tuti.desi.presentacion.impuestos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import tuti.desi.servicios.ImpuestoService;

@Controller
@RequestMapping("/impuestosEditar")
public class ImpuestosEditarController {

  //  @Autowired
  //  private ImpuestoService impuestoService;

    @RequestMapping(method = RequestMethod.GET)
    public String mostrarFormularioEdicion(Model model) {
        ImpuestosForm impuestosForm = new ImpuestosForm();
        model.addAttribute("impuestosForm", impuestosForm);
        return "impuestosEditar";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String editarImpuestos(@ModelAttribute("impuestosForm") ImpuestosForm impuestosForm, Model model) {
        // manejar la lógica para editar los impuestos
        // usar impuestoService para actualizar los datos de impuestos
        // impuestoService.actualizarImpuestos(impuestosForm);

        return "redirect:/impuestosBuscar"; // Redirigir a la página de búsqueda de impuestos
    }
}
