package tuti.desi.servicios;

import tuti.desi.entidades.Impuesto;
import java.util.List;

public interface ImpuestoService {
    
    List<Impuesto> obtenerTodosLosImpuestos();
    
    Impuesto obtenerImpuestoPorId(Long id);
    
    void guardarImpuesto(Impuesto impuesto);
    
    void actualizarImpuesto(Impuesto impuesto);
}
