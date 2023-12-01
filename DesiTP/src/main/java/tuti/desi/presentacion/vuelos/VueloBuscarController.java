package tuti.desi.presentacion.vuelos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tuti.desi.entidades.Aeronave;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Vuelo;
import tuti.desi.presentacion.personas.PersonasBuscarForm;
import tuti.desi.servicios.CiudadService;
import tuti.desi.servicios.PersonaService;

@Controller
@RequestMapping("/vueloBuscar")
public class VueloBuscarController {

	@Autowired
    private CiudadService serviceCiudad;
    //private AeronaveService serviceAeronave;
     
    
   @RequestMapping(method=RequestMethod.GET)
   public String preparaForm(Model modelo) {
   	VueloBuscarForm form =  new VueloBuscarForm();
//   	form.setIdCiudadSeleccionada(1L); 
//   	 form.setCiudades(serviceCiudad.getAll());    
      modelo.addAttribute("formBean",form);
      return "vueloIndex";
   }
    
   @ModelAttribute("allCiudades")
   public List<Ciudad> getAllCiudades() {
       return this.serviceCiudad.getAll();
   }
   
   //@ModelAttribute("allAeronaves")
   //public List<Aeronave> getAllAeronaves() {
   //    return this.serviceAeronave.getAll();
   //}

}
