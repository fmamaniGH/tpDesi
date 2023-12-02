package tuti.desi.presentacion.impuestos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import tuti.desi.servicios.ImpuestoService;

@Controller
@RequestMapping("/impuestosBuscar")
public class ImpuestosBuscarController {

  /*  @Autowired
    private ImpuestoService impuestoService;

    @RequestMapping(method = RequestMethod.GET)
    public String mostrarFormularioBusqueda(Model model) {
        ImpuestosBuscarForm buscarForm = new ImpuestosBuscarForm();
        model.addAttribute("buscarForm", buscarForm);
        return "impuestosBuscar";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String buscarImpuestos(@ModelAttribute("buscarForm") ImpuestosBuscarForm buscarForm, Model model) {
        // lógica para buscar impuestos
        //  impuestoService para realizar la búsqueda en función de los datos del formulario
        // ejemplo: List<Impuesto> impuestosEncontrados = impuestoService.buscarImpuestos(buscarForm);

        // Una vez obtenidos los impuestos, los agregamos al modelo para mostrarlos en la vista
        // model.addAttribute("impuestosEncontrados", impuestosEncontrados);

        return "impuestosBuscarResultado"; // Nombre de la vista que mostrará los resultados
    } */
}
