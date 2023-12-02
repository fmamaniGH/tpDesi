package tuti.desi.servicios;

import java.util.List;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.vuelos.VueloBuscarForm;

public interface VueloService {
	
	Vuelo getById(Long idVuelo) ;
	
	List<Vuelo> filter(VueloBuscarForm filter) throws Excepcion;

	void deleteByid(Long id);

	void save(Vuelo c) throws Excepcion;

}
