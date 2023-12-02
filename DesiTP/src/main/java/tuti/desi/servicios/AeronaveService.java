package tuti.desi.servicios;

import java.util.List;

import tuti.desi.entidades.Aeronave;


public interface AeronaveService {	

	List<Aeronave> getAll();

	Aeronave getById(Long id) ;
}