
package tuti.desi.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.IAeronaveRepo;
import tuti.desi.entidades.Aeronave;

@Service
public class AeronaveServiceImpl implements AeronaveService {
	
	@Autowired
	IAeronaveRepo repo;

	@Override
	public List<Aeronave> getAll() {
		return repo.findAll();
	}

	@Override
	public Aeronave getById(Long id) {
		return repo.findById(id).get();
	}

}