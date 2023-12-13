package tuti.desi.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.IVueloRepo;
import tuti.desi.entidades.Persona;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.vuelos.VueloBuscarForm;
import tuti.desi.presentacion.vuelos.VueloForm;

@Service
public class VueloServiceImpl implements VueloService {
	@Autowired
	IVueloRepo repo;
	
	@Override
	public Vuelo getById(Long idVuelo) {
		return repo.findById(idVuelo).get();
	}

	@Override
	public List<Vuelo> filter(String filter) throws Excepcion {
		
		if (filter == "")
			return repo.findByCodigoAll();
		else
			return repo.findByCodigo(filter);
		
	}

	@Override
	public List<Vuelo> filterVuelo(String codigo, int year, int month, int day) {
		return repo.findByCodigoAndDate(codigo, year, month, day);
		
	}
	
	@Override
	public void deleteByid(Long id) {
		repo.deleteById(id);
		
	}

	@Override
	public void save(Vuelo c) throws Excepcion {
		repo.save(c);
		
	}
	
	@Override
	public List<Vuelo> getAll() {
		
		return repo.findAll();
	}

}
