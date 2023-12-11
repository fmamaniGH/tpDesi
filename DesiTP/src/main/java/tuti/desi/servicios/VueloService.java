package tuti.desi.servicios;

import java.util.List;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.vuelos.VueloBuscarForm;
import tuti.desi.presentacion.vuelos.VueloForm;

public interface VueloService {
	
	Vuelo getById(Long idVuelo) ;
	
	List<Vuelo> filter(String filter) throws Excepcion;
	
	List<Vuelo> filterVuelo(String codigo, int year, int month, int day);
	
	void deleteByid(Long id);

	void save(Vuelo c) throws Excepcion;

}
