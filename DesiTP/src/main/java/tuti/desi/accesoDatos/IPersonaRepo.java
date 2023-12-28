package tuti.desi.accesoDatos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.Persona;

@Repository
public interface IPersonaRepo extends JpaRepository<Persona, Long> {
	List<Persona> findByNombreOrDni(String nombre, Long dni);

	@Query("SELECT p FROM Persona p WHERE "
			+ "(:nombre IS NULL OR UPPER(p.nombre) LIKE UPPER(CONCAT('%', :nombre, '%'))) "
			+ "AND (:dni IS NULL OR p.dni = :dni) " + "AND (:idCiudad IS NULL OR p.ciudad.id = :idCiudad)")
	List<Persona> findByNombreOrDniOrIdCiudad(@Param("nombre") String nombre, @Param("dni") Long dni,
			@Param("idCiudad") Long idCiudad);
}
