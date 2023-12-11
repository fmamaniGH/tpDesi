package tuti.desi.presentacion.impuestos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tuti.desi.servicios.ImpuestoService;
import tuti.desi.entidades.Impuesto;

@Controller
@RequestMapping("/impuestosBuscar")
public class ImpuestosBuscarController {/*

    @Autowired
    private ImpuestoService impuestoService;

    @RequestMapping(method = RequestMethod.GET)
    public String mostrarFormularioBusqueda(Model model) {
        model.addAttribute("porcentajeIva", 0); // Valores por defecto para el formulario
        model.addAttribute("montoTasaNacional", BigDecimal.ZERO);
        model.addAttribute("montoTasaInternacional", BigDecimal.ZERO);
        model.addAttribute("cotizacionDolar", BigDecimal.ZERO);
        return "impuestosBuscar";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String buscarImpuestos(@ModelAttribute("porcentajeIva") Integer porcentajeIva,
                                  @ModelAttribute("montoTasaNacional") BigDecimal montoTasaNacional,
                                  @ModelAttribute("montoTasaInternacional") BigDecimal montoTasaInternacional,
                                  @ModelAttribute("cotizacionDolar") BigDecimal cotizacionDolar,
                                  Model model) {
        try {
            // Validar los datos recibidos según los criterios de la historia de usuario
            if (porcentajeIva < 0 || porcentajeIva > 100 ||
                montoTasaNacional == null || montoTasaNacional.compareTo(BigDecimal.ZERO) < 0 ||
                montoTasaInternacional == null || montoTasaInternacional.compareTo(BigDecimal.ZERO) < 0 ||
                cotizacionDolar == null || cotizacionDolar.compareTo(BigDecimal.ZERO) < 0) {
                throw new ExcepcionDatoInvalido();
            }

            // Realizar la búsqueda de impuestos utilizando los filtros recibidos
            List<Impuesto> impuestosEncontrados = impuestoService.obtenerImpuestosPorFiltros(porcentajeIva, montoTasaNacional, montoTasaInternacional, cotizacionDolar);

            model.addAttribute("impuestosEncontrados", impuestosEncontrados);
        } catch (ExcepcionDatoInvalido e) {
            model.addAttribute("error", e.getMessage());
            return "errorPage"; // Página de error para manejar las excepciones específicas
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error inesperado.");
            return "errorPage"; // Página de error genérica para otros errores no controlados
        }

        return "impuestosBuscarResultado";
    }*/
}

