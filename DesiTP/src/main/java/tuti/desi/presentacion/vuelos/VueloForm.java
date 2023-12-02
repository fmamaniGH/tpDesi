package tuti.desi.presentacion.vuelos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import tuti.desi.entidades.Aeronave;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Vuelo;

public class VueloForm {
	private Long id;
	
	@NotNull
	private Long idAeronave;
	
	
	public VueloForm() {
		super();
	}
	public VueloForm(Vuelo c) {
		super();
		this.id=c.getId();
		this.idAeronave=c.getAeronave().getId();
		
	}	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	
	public Long getIdAeronave() {
		return idAeronave;
	}
	public void setIdAeronave(Long idAeronave) {
		this.idAeronave= idAeronave;
	}
	
	
	public Vuelo toPojo()
	{
		Vuelo v = new Vuelo();
		Aeronave a = new Aeronave();
		a.setId(idAeronave);		
		v.setAeronave(a);
		return v;
	}

	
}
