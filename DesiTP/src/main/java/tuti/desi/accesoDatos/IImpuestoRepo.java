package tuti.desi.accesoDatos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tuti.desi.entidades.Impuesto;

import java.math.BigDecimal;
import java.util.List;

public interface IImpuestoRepo extends JpaRepository<Impuesto, Long> {

    @Query("SELECT i FROM Impuesto i " +
            "WHERE i.porcentajeIva = :porcentajeIva " +
            "AND i.montoTasaNacional = :montoTasaNacional " +
            "AND i.montoTasaInternacional = :montoTasaInternacional " +
            "AND i.cotizacionDolar = :cotizacionDolar")
    List<Impuesto> buscarPorFiltros(
            @Param("porcentajeIva") BigDecimal porcentajeIva,
            @Param("montoTasaNacional") BigDecimal montoTasaNacional,
            @Param("montoTasaInternacional") BigDecimal montoTasaInternacional,
            @Param("cotizacionDolar") BigDecimal cotizacionDolar
    );
}
