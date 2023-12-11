package tuti.desi.servicios;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.accesoDatos.IImpuestoRepo;
import tuti.desi.entidades.Impuesto;

/*@Service
public class ImpuestoServiceImpl implements ImpuestoService {

    @Autowired
    private IImpuestoRepo repo;

    public void guardarImpuesto(Impuesto imp) {
        validarImpuesto(imp);
        repo.save(imp);
    }

    public void actualizarImpuesto(Impuesto imp) {
        validarImpuesto(imp);
        repo.save(imp);
    }

    public List<Impuesto> obtenerTodosLosImpuestos() {
        return repo.findAll();
    }

    public Impuesto obtenerImpuestoPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Impuesto> obtenerImpuestosPorFiltros(
            BigDecimal porcentajeIva,
            BigDecimal montoTasaNacional,
            BigDecimal montoTasaInternacional,
            BigDecimal cotizacionDolar
    ) {
        // Realizar la búsqueda en el repositorio utilizando los filtros
       return repo.findByPorcentajeIvaAndMontoTasaNacionalAndMontoTasaInternacionalAndCotizacionDolar(
                porcentajeIva, montoTasaNacional, montoTasaInternacional, cotizacionDolar
        );
    }

    private void validarImpuesto(Impuesto imp) {
        // Lógica de validación según los criterios de la historia de usuario
        if (imp.getPorcentajeIva() == null || imp.getMontoTasaNacional() == null ||
                imp.getMontoTasaInternacional() == null || imp.getCotizacionDolar() == null) {
            throw new ExcepcionDatoObligatorio("Todos los datos son requeridos.");
        }

        if (imp.getPorcentajeIva().compareTo(BigDecimal.ZERO) < 0 ||
                imp.getPorcentajeIva().compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new ExcepcionPorcentajeInvalido("El IVA debe estar entre 0 y 100.");
        }

        if (imp.getMontoTasaNacional().compareTo(BigDecimal.ZERO) < 0 ||
                imp.getMontoTasaInternacional().compareTo(BigDecimal.ZERO) < 0 ||
                imp.getCotizacionDolar().compareTo(BigDecimal.ZERO) < 0) {
            throw new ExcepcionDatoObligatorio("Todos los valores deben ser numéricos positivos.");
        }

        if (imp.getMontoTasaNacional().scale() != 2 || imp.getMontoTasaInternacional().scale() != 2 ||
                imp.getCotizacionDolar().scale() != 2) {
            throw new ExcepcionDecimalesInvalido("Todos los valores deben tener dos decimales.");
        }
    }
}
*/





 //otra version

/*
@Service
public class ImpuestoServiceImpl implements ImpuestoService {

    @Autowired
    private IImpuestoRepo repo;

    public void guardarImpuesto(Impuesto imp) {
      
        if(imp.getPorcentajeIva() < 0 || imp.getPorcentajeIva() > 100) {
            throw new ExcepcionPorcentajeInvalido();
        }

        if(imp.getMontoTasaNacional() == null) {
            throw new ExcepcionDatoObligatorio(); 
        }
        
        if(imp.getMontoTasaInternacional() == null) {
            throw new ExcepcionDatoObligatorio();
        }
        
        if(imp.getCotizacionDolar() == null) {
            throw new ExcepcionDatoObligatorio();
        }

        if(imp.getMontoTasaNacional().scale() != 2) {
            throw new ExcepcionDecimalesInvalido();
        }

        if(imp.getMontoTasaInternacional().scale() != 2) {
            throw new ExcepcionDecimalesInvalido();
        }
        
        if(imp.getCotizacionDolar().scale() != 2) {
            throw new ExcepcionDecimalesInvalido();
        }

        repo.save(imp);
    }
    
    
    public void actualizarImpuesto(Impuesto imp) {
      
        // misma validación que en guardar
      
        repo.save(imp);
    }

    public List<Impuesto> obtenerTodosLosImpuestos() {
        return repo.findAll();
    }

    public Impuesto obtenerImpuestoPorId(Long id){
        return repo.findById(id).orElse(null);
    }

}*/