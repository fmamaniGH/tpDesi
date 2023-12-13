package tuti.desi.presentacion.impuestos;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import tuti.desi.servicios.ImpuestoService;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import tuti.desi.entidades.Aeronave;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Impuesto;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.vuelos.VueloForm;
import tuti.desi.servicios.ImpuestoService;
import tuti.desi.servicios.VueloService;

@Controller
@RequestMapping("/impuestosEditar")
public class ImpuestosEditarController {

	@Autowired
    private ImpuestoService serviceImpuesto;
	
	@Autowired
	private VueloService serviceVuelo;
	
    @RequestMapping(path = {"", "/{id}"},method=RequestMethod.GET)
    public String preparaForm(Model modelo, @PathVariable("id") Optional<Long> id) throws Exception {
    	if (id.isPresent()) {
    		Impuesto entity = serviceImpuesto.obtenerImpuestoPorId(id.get());
    		ImpuestosForm form = new ImpuestosForm(entity);
			modelo.addAttribute("formBean", form);
		} else {
 
	       modelo.addAttribute("formBean",new ImpuestosForm());
		}
       return "ImpuestosEditar";
    }
    
	
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public String deleteById(Model model, @PathVariable("id") Long id) 
	{
		serviceImpuesto.eliminaByid(id);
		return "redirect:/";
	}
	
	@ModelAttribute("allVuelos")
    public List<Vuelo> getAllVuelos() {
        return this.serviceVuelo.getAll();
    }
      
	/*
    @ModelAttribute("allAeronaves")
    public List<Aeronave> getAllAeronaves() {
        return this.serviceAeronave.getAll();
    }
	 */
	
    @RequestMapping( method=RequestMethod.POST)
    public String submit(@ModelAttribute("formBean") @Valid  ImpuestosForm formBean,BindingResult result, ModelMap modelo,@RequestParam String action) throws Exception {
    	    	
    	if(action.equals("Aceptar"))
    	{    		
    		if(result.hasErrors())
    		{   
    			modelo.addAttribute("formBean",formBean);
    			return "impuestosEditar";
    		}
    		else
    		{
				Impuesto i=formBean.toPojo();	
				i.setVuelo(serviceVuelo.getById(formBean.getIdVuelo()));
				serviceImpuesto.guardarImpuesto(i); 

				return "redirect:/impuestosBuscar";
    		}
    	}    
    	
    	if(action.equals("Cancelar"))
    	{
    		modelo.clear();
    		return "redirect:/impuestosBuscar";
    	}
    		
    	return "redirect:/";
    	
    	
    }
}
