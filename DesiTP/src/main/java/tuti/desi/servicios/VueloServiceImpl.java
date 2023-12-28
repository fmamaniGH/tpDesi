package tuti.desi.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.IAsientoRepo;
import tuti.desi.accesoDatos.IVueloRepo;
import tuti.desi.entidades.Asiento;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;

@Service
public class VueloServiceImpl implements VueloService {

	@Autowired
	IVueloRepo repo;

	@Autowired
	IAsientoRepo asientoRepository;

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
	public void save(Vuelo vuelo) throws Excepcion {
		repo.save(vuelo);
		crearAsientos(vuelo);
	}

	@Override
	public List<Vuelo> getAll() {
		return repo.findAll();
	}

	public List<Asiento> obtenerAsientosDisponibles(Long vueloId) {
		Vuelo vuelo = repo.findById(vueloId).orElse(null);

		if (vuelo != null) {
			return vuelo.getAsientos().stream().filter(asiento -> asiento.getPersona() == null)
					.collect(Collectors.toList());
		}

		return null;
	}

	private List<Asiento> crearAsientos(Vuelo vuelo) {
		List<Asiento> asientosDisponibles = new ArrayList<>();
		Integer capacidadAeronave = vuelo.getAeronave().getCapacidad();

		for (int fila = 1; fila <= capacidadAeronave / 6; fila++) {
			for (int columna = 1; columna <= 6; columna++) {
				Asiento asiento = new Asiento();
				asiento.setFila(fila);
				asiento.setColumna(columna);
				asiento.setPersona(null);
				asiento.setVuelo(null);
				asiento.setVuelo(vuelo);

				asientoRepository.save(asiento);
			}
		}
		return asientosDisponibles;
	}
}
