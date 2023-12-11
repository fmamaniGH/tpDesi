package tuti.desi.presentacion.vuelos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import tuti.desi.entidades.Aeronave;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Persona;
import tuti.desi.entidades.Vuelo;

public class VueloForm {
	
	private Long id;
	
	@NotNull(message = "el codigo no puede ser nulo")
	@Size(min=5, max=10, message = "Longitud entre 5 y 10 caracteres")
	private String codigo;

	@NotNull(message = "la fecha y hora no puede ser nulo")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fechaYHora;

	@NotNull(message = "el tipo de vuelo no puede ser nulo")
	private String tipo_vuelo;	
	
	@NotNull(message = "el dni no puede ser nulo")
	@Min(value = 0, message = "el precio debe ser mayor a 0")
	@DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=7, fraction=2)
	private Double precio;
	
	@NotNull(message = "la aerona no puede ser nula")
	private Long idAeronave;
	
	@NotNull(message = "el origen no puede ser nulo")
	private Long idOrigen;
	
	@NotNull(message = "el destino no puede ser nulo")
	private Long idDestino;

	
	public VueloForm() {
		super();
	}
	
	public VueloForm(Vuelo c) {
		super();
		this.id=c.getId();
		this.codigo =c.getCodigo();
		this.fechaYHora =c.getFechaYHora();
		this.precio = c.getPrecio();
		this.idAeronave=c.getAeronave().getId();		
		this.idOrigen = c.getOrigen().getId();
		this.idDestino = c.getDestino().getId();
		this.tipo_vuelo=c.getTipo_vuelo();
	}	
	
	public Vuelo toPojo()
	{
		//Vuelo v = new Vuelo();
		//Aeronave a = new Aeronave();
		//a.setId(idAeronave);		
		//v.setAeronave(a);
		//return v;
		
		Vuelo v = new Vuelo();
		v.setId(this.getId());
		v.setCodigo(this.codigo);
		v.setFechaYHora(fechaYHora);
		v.setPrecio(precio);
	
		/*
		if(!this.editando)
		{
			p.setDni(this.getDni());
		}
		p.setApellido(this.getApellido());
		p.setNombre(this.getNombre());
		p.setDni(this.getDni());
		p.setFechaNacimiento(this.getFechaNacimiento());
		p.setEditando(this.getEditando());
		*/
		
		return v;		
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
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Date getFechaYHora() {
		return fechaYHora;
	}
	public void setFechaYHora(Date fechaYHora) {
		this.fechaYHora = fechaYHora;
	}
	public String getTipo_vuelo() {
		return tipo_vuelo;
	}
	public void setTipo_vuelo(String tipo_vuelo) {
		this.tipo_vuelo = tipo_vuelo;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Long getIdOrigen() {
		return idOrigen;
	}

	public void setIdOrigen(Long idOrigen) {
		this.idOrigen = idOrigen;
	}

	public Long getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(Long idDestino) {
		this.idDestino = idDestino;
	}
	
}
