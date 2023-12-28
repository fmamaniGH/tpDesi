package tuti.desi.servicios;

import java.util.List;

import tuti.desi.entidades.Asiento;

public interface AsientoService {

	Asiento obtenerAsientoPorId(Long id);

	Boolean update(Asiento asientoReservado);

	List<Asiento> determinarAsientosDisponibles(int capacidadAeronave, List<Asiento> asientosAsociados);
}
