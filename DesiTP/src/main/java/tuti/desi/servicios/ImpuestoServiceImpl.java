package tuti.desi.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.accesoDatos.IImpuestoRepo;
import tuti.desi.entidades.Impuesto;

@Service
public class ImpuestoServiceImpl implements ImpuestoService {

    @Autowired
    private IImpuestoRepo repo;

    @Override
    public List<Impuesto> obtenerTodosLosImpuestos() {
        return repo.findAll();
    }

    @Override
    public Impuesto obtenerImpuestoPorId(Long id) {
        return repo.findById(id).orElse(null);
    }
    
    @Override
    public void guardarImpuesto(Impuesto imp) {
        //validarImpuesto(imp);
        repo.save(imp);
    }

    @Override
    public void actualizarImpuesto(Impuesto imp) {
        //validarImpuesto(imp);
        repo.save(imp);
    }


}