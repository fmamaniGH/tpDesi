package tuti.desi.presentacion.vuelos;

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
import tuti.desi.entidades.Aeronave;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Persona;
import tuti.desi.entidades.Vuelo;
import tuti.desi.presentacion.personas.PersonasBuscarForm;
import tuti.desi.servicios.CiudadService;
import tuti.desi.servicios.PersonaService;
import tuti.desi.servicios.VueloService;

@Controller
@RequestMapping("/vueloBuscar")
public class VueloBuscarController {

	@Autowired
    private CiudadService serviceCiudad;
	
	@Autowired
    private VueloService serviceVuelo;
    //private AeronaveService serviceAeronave;
     
    
   @RequestMapping(method=RequestMethod.GET)
   public String preparaForm(Model modelo) {
   	VueloBuscarForm form =  new VueloBuscarForm();
//   	form.setIdCiudadSeleccionada(1L); 
//   	 form.setCiudades(serviceCiudad.getAll());    
      modelo.addAttribute("formBean",form);
      return "vueloBuscar";
   }
    
   @ModelAttribute("allCiudades")
   public List<Ciudad> getAllCiudades() {
       return this.serviceCiudad.getAll();
   }
   
   //@ModelAttribute("allAeronaves")
   //public List<Aeronave> getAllAeronaves() {
   //    return this.serviceAeronave.getAll();
   //}
   
   
   @RequestMapping( method=RequestMethod.POST)
   public String submit( @ModelAttribute("formBean")  @Valid  VueloBuscarForm formBean,BindingResult result, ModelMap modelo,@RequestParam String action) {

   	if(action.equals("Buscar"))
   	{   		
   		
   		try {
   			List<Vuelo> vuelos = serviceVuelo.filter(formBean.getCodigo());
           	modelo.addAttribute("resultados",vuelos);
			} catch (Exception e) {
				ObjectError error = new ObjectError("globalError", e.getMessage());
	            result.addError(error);
			}
       	modelo.addAttribute("formBean",formBean);
       	return "vueloBuscar";
   	}
   
   	
   	if(action.equals("Cancelar"))
   	{
   		modelo.clear();
   		return "redirect:/";
   	}
   	
   	if(action.equals("Registrar"))
   	{
   		modelo.clear();
   		return "redirect:/vueloEditar";
   	}
   		
   	return "redirect:/";
   	
   	
   }

}
