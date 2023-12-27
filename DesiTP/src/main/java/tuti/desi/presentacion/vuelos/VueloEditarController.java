package tuti.desi.presentacion.vuelos;

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
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import tuti.desi.entidades.Aeronave;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.servicios.AeronaveService;
import tuti.desi.servicios.CiudadService;
import tuti.desi.servicios.VueloService;

@Controller
@RequestMapping("/vueloEditar")
public class VueloEditarController {
	@Autowired
	private CiudadService serviceCiudad;

	@Autowired
	private VueloService serviceVuelo;

	@Autowired
	private AeronaveService serviceAeronave;

	@RequestMapping(path = { "", "/{id}" }, method = RequestMethod.GET)
	public String preparaForm(Model modelo, @PathVariable("id") Optional<Long> id) throws Exception {
		if (id.isPresent()) {
			Vuelo entity = serviceVuelo.getById(id.get());
			VueloForm form = new VueloForm(entity);
			modelo.addAttribute("formBean", form);
		} else {

			modelo.addAttribute("formBean", new VueloForm());
		}
		return "VueloEditar";
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public String deleteById(Model model, @PathVariable("id") Long id) {
		serviceVuelo.deleteByid(id);
		return "redirect:/";
	}

	@ModelAttribute("allAeronaves")
	public List<Aeronave> getAllAeronaves() {
		return this.serviceAeronave.getAll();
	}

	@ModelAttribute("allCiudadesOrigen")
	public List<Ciudad> getAllCiudadesOrigen() {
		return this.serviceCiudad.getAll();
	}

	@ModelAttribute("allCiudadesDestino")
	public List<Ciudad> getAllCiudadesDestino() {
		return this.serviceCiudad.getAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("formBean") @Valid VueloForm formBean, BindingResult result, ModelMap modelo,
			@RequestParam String action) throws Exception {

		if (action.equals("Aceptar")) {

			if (result.hasErrors()) {
				modelo.addAttribute("formBean", formBean);
				return "vueloEditar";
			} else {
				try {

					if (formBean.getEditando()) {
						Vuelo v = formBean.toPojo();
						v.setAeronave(serviceAeronave.getById(formBean.getIdAeronave()));
						v.setOrigen(serviceCiudad.getById(formBean.getIdOrigen()));
						v.setDestino(serviceCiudad.getById(formBean.getIdDestino()));
						v.setTipoVuelo(formBean.getTipoVuelo());

						serviceVuelo.save(v);
					} else {
						int year = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(formBean.getFechaYHora()))
								.getYear();
						int month = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(formBean.getFechaYHora()))
								.getMonthValue();
						int day = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(formBean.getFechaYHora()))
								.getDayOfMonth();

						List<Vuelo> vuelos = serviceVuelo.filterVuelo(formBean.getCodigo(), year, month, day);
						if (vuelos.size() == 0) {
							Vuelo v = formBean.toPojo();
							v.setAeronave(serviceAeronave.getById(formBean.getIdAeronave()));
							v.setOrigen(serviceCiudad.getById(formBean.getIdOrigen()));
							v.setDestino(serviceCiudad.getById(formBean.getIdDestino()));
							v.setTipoVuelo(formBean.getTipoVuelo());

							serviceVuelo.save(v);
						} else {
							throw new Exception("Duplicate key '" + formBean.getCodigo() + "'.");
						}
					}

					return "redirect:/vueloBuscar";
				} catch (Excepcion e) {
					if (e.getAtributo() == null) {
						ObjectError error = new ObjectError("globalError", e.getMessage());
						result.addError(error);
					} else {
						FieldError error1 = new FieldError("formBean", e.getAtributo(), e.getMessage());
						result.addError(error1);

					}
					modelo.addAttribute("formBean", formBean);
					return "vueloEditar";
				}
			}
		}

		if (action.equals("Cancelar")) {
			modelo.clear();
			return "redirect:/vueloBuscar";
		}

		return "redirect:/";

	}

}
