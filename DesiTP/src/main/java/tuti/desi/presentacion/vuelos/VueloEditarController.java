package tuti.desi.presentacion.vuelos;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import tuti.desi.entidades.Aeronave;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Provincia;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.servicios.AeronaveService;
import tuti.desi.servicios.CiudadService;
import tuti.desi.servicios.ProvinciaService;
import tuti.desi.servicios.VueloService;


@Controller
@RequestMapping("/vueloEditar")
public class VueloEditarController {
	@Autowired
    private CiudadService servicioCiudad;
	
	@Autowired
    private VueloService servicioVuelo;
	
	@Autowired
    private AeronaveService servicioAeronave;
		
	
    @RequestMapping(path = {"", "/{id}"},method=RequestMethod.GET)
    public String preparaForm(Model modelo, @PathVariable("id") Optional<Long> id) throws Exception {
    	if (id.isPresent()) {
    		Vuelo entity = servicioVuelo.getById(id.get());
    		VueloForm form = new VueloForm(entity);
			modelo.addAttribute("formBean", form);
		} else {
 
	       modelo.addAttribute("formBean",new VueloForm());
		}
       return "VueloEditar";
    }
    
	
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public String deleteById(Model model, @PathVariable("id") Long id) 
	{
		servicioVuelo.deleteByid(id);
		return "redirect:/";
	}
 
     
    @ModelAttribute("allAeronaves")
    public List<Aeronave> getAllAeronaves() {
        return this.servicioAeronave.getAll();
    }
	

    @RequestMapping( method=RequestMethod.POST)
    public String submit(@ModelAttribute("formBean") @Valid  VueloForm formBean,BindingResult result, ModelMap modelo,@RequestParam String action) {
    	
    	
    	if(action.equals("Aceptar"))
    	{
    		if(result.hasErrors())
    		{   
    			modelo.addAttribute("formBean",formBean);
    			return "vueloEditar";
    		}
    		else
    		{
    			try {
					Vuelo p=formBean.toPojo();
					p.setAeronave(servicioAeronave.getById(formBean.getIdAeronave()));
					servicioVuelo.save(p);
					
					return "redirect:/vueloBuscar";
				} catch (Excepcion e) {
					if(e.getAtributo()==null) 
					{
						ObjectError error = new ObjectError("globalError", e.getMessage());
			            result.addError(error);
					}
					else
					{
			    		FieldError error1 = new FieldError("formBean",e.getAtributo(),e.getMessage());
			            result.addError(error1);

					}
		            modelo.addAttribute("formBean",formBean);
	    			return "vueloEditar"; 
				}
    		}
    	}
    
    	
    	if(action.equals("Cancelar"))
    	{
    		modelo.clear();
    		return "redirect:/vueloBuscar";
    	}
    		
    	return "redirect:/";
    	
    	
    }

}
