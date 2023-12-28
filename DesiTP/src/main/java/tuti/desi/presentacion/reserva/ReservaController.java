package tuti.desi.presentacion.reserva;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import tuti.desi.entidades.Asiento;
import tuti.desi.entidades.Persona;
import tuti.desi.entidades.Vuelo;
import tuti.desi.servicios.AsientoService;
import tuti.desi.servicios.PersonaService;
import tuti.desi.servicios.VueloService;

@Controller
@RequestMapping("/reservar")
public class ReservaController {

	@Autowired
	private VueloService vueloService;

	@Autowired
	private AsientoService asientoService;

	@Autowired
	private PersonaService personaService;

	@GetMapping("/{dni}")
	public String preparaForm(Model model, @PathVariable("dni") Long dni,
			@RequestParam(name = "vuelo", required = false) Long idVuelo) throws Exception {
		if (dni != null) {
			model.addAttribute("dni", dni);
			model.addAttribute("vuelos", vueloService.getAll());
			model.addAttribute("idVuelo", idVuelo);
		}
		if (idVuelo != null) {
			Vuelo vuelo = vueloService.getById(idVuelo);
			model.addAttribute("precio", vuelo.getPrecioPasaje());
			model.addAttribute("asientos", vuelo.getAsientos());
		}
		model.addAttribute("reservaForm", new ReservaForm());
		return "reservar";
	}

	@ModelAttribute("allVuelos")
	public List<Vuelo> getAllVuelos() {
		return this.vueloService.getAll();
	}

	@PostMapping("/{dni}/{idVuelo}")
	public String procesarReserva(Model model, @PathVariable("dni") Long dni, @PathVariable Long idVuelo,
			@RequestParam(name = "asiento", required = false) Long idAsiento, @Valid ReservaForm reservaForm,
			BindingResult result) throws Exception {
		try {
			Vuelo vuelo = vueloService.getById(idVuelo);
			Asiento asientoReservado = asientoService.obtenerAsientoPorId(idAsiento);
			Persona nuevaPersona = personaService.getPersonaById(dni);
			Persona personaExistente = asientoReservado.getPersona();

			model.addAttribute("allVuelos", vueloService.getAll());
			model.addAttribute("precio", vuelo.getPrecioPasaje());
			model.addAttribute("reservaForm", reservaForm);

			if (personaExistente == nuevaPersona && asientoReservado.getVuelo().getId() == idVuelo) {
				model.addAttribute("error", "El cliente ya posee reservado este asiento");
				return "reservar";
			} else if (personaExistente != null) {
				model.addAttribute("error", "El asiento ya se encuentra reservado");
				return "reservar";
			}

			asientoReservado.setPersona(nuevaPersona);

			Boolean reservado = asientoService.update(asientoReservado);
			if (!reservado) {
				model.addAttribute("error", "No se pudo reservar el asiento");
				return "reservar";
			}
			model.addAttribute("exito", "Pasaje reservado con exito");
			return "reservar";
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("error", "Error al reservar el asiento: " + e.getMessage());
			return "reservar";
		}
	}
}
