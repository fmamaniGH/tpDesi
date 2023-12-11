package tuti.desi.accesoDatos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.Vuelo;

@Repository
public interface IVueloRepo extends JpaRepository<Vuelo, Long> {

	@Query("FROM Vuelo v WHERE v.codigo like ?1")
	List<Vuelo> findByCodigo(String codigo);
	
	
	@Query("FROM Vuelo v")
	List<Vuelo> findByCodigoAll();
	
	@Query("FROM Vuelo v where v.codigo =?1 and year(v.fechaYHora)=?2 and month(v.fechaYHora)=?3 and day(v.fechaYHora)=?4")
	List<Vuelo> findByCodigoAndDate(String codigo, int year, int month, int day);
}