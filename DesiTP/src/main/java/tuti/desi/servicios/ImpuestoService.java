package tuti.desi.servicios;

import tuti.desi.entidades.Impuesto;

import java.math.BigDecimal;
import java.util.List;

public interface ImpuestoService {
    
    List<Impuesto> obtenerTodosLosImpuestos();
    
    Impuesto obtenerImpuestoPorId(Long id);
    
    void guardarImpuesto(Impuesto impuesto);
    
    void actualizarImpuesto(Impuesto impuesto);
    
    List<Impuesto> obtenerImpuestosPorFiltros(
            BigDecimal porcentajeIva,
            BigDecimal montoTasaNacional,
            BigDecimal montoTasaInternacional,
            BigDecimal cotizacionDolar
    );
}
