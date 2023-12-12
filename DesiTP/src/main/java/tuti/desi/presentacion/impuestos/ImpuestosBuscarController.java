package tuti.desi.presentacion.impuestos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import tuti.desi.servicios.CiudadService;
import tuti.desi.servicios.ImpuestoService;
import tuti.desi.servicios.VueloService;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Impuesto;
import tuti.desi.entidades.Vuelo;
import tuti.desi.presentacion.vuelos.VueloBuscarForm;

@Controller
@RequestMapping("/impuestosBuscar")
public class ImpuestosBuscarController {
		
	@Autowired
    private ImpuestoService serviceImpuesto;
    //private AeronaveService serviceAeronave;
     
    
   @RequestMapping(method=RequestMethod.GET)
   public String preparaForm(Model modelo) {
   	ImpuestosBuscarForm form =  new ImpuestosBuscarForm();
      modelo.addAttribute("formBean",form);
      return "impuestosBuscar";
   }   
   
   @RequestMapping( method=RequestMethod.POST)
   public String submit( @ModelAttribute("formBean")  @Valid  ImpuestosBuscarForm formBean,BindingResult result, ModelMap modelo,@RequestParam String action) {

   	if(action.equals("Buscar"))
   	{   		
   		
   		try {
   			List<Impuesto> impuestos = serviceImpuesto.obtenerTodosLosImpuestos();
           	modelo.addAttribute("resultados",impuestos);
			} catch (Exception e) {
				ObjectError error = new ObjectError("globalError", e.getMessage());
	            result.addError(error);
			}
       	modelo.addAttribute("formBean",formBean);
       	return "impuestosBuscar";
   	}
   
   	
   	if(action.equals("Cancelar"))
   	{
   		modelo.clear();
   		return "redirect:/";
   	}
   	
   	if(action.equals("Registrar"))
   	{
   		modelo.clear();
   		return "redirect:/impuestosEditar";
   	}
   		
   	return "redirect:/";
   	
   	
   }

	
}

