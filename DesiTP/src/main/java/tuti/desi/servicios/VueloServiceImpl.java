package tuti.desi.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.IVueloRepo;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.vuelos.VueloBuscarForm;

@Service
public class VueloServiceImpl implements VueloService {
	@Autowired
	IVueloRepo repo;
	
	@Override
	public Vuelo getById(Long idVuelo) {
		return repo.findById(idVuelo).get();
	}

	@Override
	public List<Vuelo> filter(VueloBuscarForm filter) throws Excepcion {
		/*
		if(filter.getCodigo() ==null)
			throw new Excepcion("Es necesario al menos un filtro");
		else
			return repo.findByCodigo(filter.getCodigo());

		 */
		
		if (filter.getCodigo() == "")
			return repo.findByCodigoAll();
		else
			return repo.findByCodigo(filter.getCodigo());
		
	}

	@Override
	public void deleteByid(Long id) {
		repo.deleteById(id);
		
	}

	@Override
	public void save(Vuelo c) throws Excepcion {
		repo.save(c);
		
	}

}
