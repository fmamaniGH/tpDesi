package tuti.desi.accesoDatos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tuti.desi.entidades.Impuesto;
import tuti.desi.entidades.Vuelo;

import java.math.BigDecimal;
import java.util.List;

public interface IImpuestoRepo extends JpaRepository<Impuesto, Long> {

	@Query("FROM Impuesto i")
	List<Impuesto> findAll();
}
//commit