package tuti.desi.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.IAsientoRepo;
import tuti.desi.entidades.Asiento;

@Service
public class AsientoServiceImpl implements AsientoService {

	@Autowired
	IAsientoRepo asientoRepository;

	@Override
	public Asiento obtenerAsientoPorId(Long id) {
		return asientoRepository.findById(id).orElse(null);
	}

	@Override
	public Boolean update(Asiento asientoReservado) {
		Asiento asiento = asientoRepository.findById(asientoReservado.getId()).orElse(null);
		if (asiento != null) {
			asientoRepository.save(asiento);
			return true;
		}
		return false;
	}

	@Override
	public List<Asiento> determinarAsientosDisponibles(int capacidadAeronave, List<Asiento> asientosAsociados) {
		List<Asiento> asientosDisponibles = new ArrayList<>();

		for (int fila = 1; fila <= capacidadAeronave / 6; fila++) {
			for (int columna = 1; columna <= 6; columna++) {
				Asiento asiento = new Asiento();
				asiento.setFila(fila);
				asiento.setColumna(columna);
				asiento.setPersona(null);
				asiento.setVuelo(null);

				if (!asientosAsociados.contains(asiento)) {
					asientosDisponibles.add(asiento);
					asientoRepository.save(asiento);
				}
			}
		}
		return asientosDisponibles;
	}
}
