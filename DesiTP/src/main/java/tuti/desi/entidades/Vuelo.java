package tuti.desi.entidades;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Vuelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	private String codigo;
	//private String origen;

	//private String destino;	

	private Date fechaYHora;

	private String tipoVuelo;	

	@OneToOne
	private Aeronave aeronave;
	
	@ManyToOne
	private Ciudad origen;
	
	@ManyToOne
	private Ciudad destino;

	public Date getFechaYHora() {
		return fechaYHora;
	}

	public void setFechaYHora(Date fechaYHora) {
		this.fechaYHora = fechaYHora;
	}

	public String getTipoVuelo() {
		return tipoVuelo;
	}

	public void setTipoVuelo(String tipoVuelo) {
		this.tipoVuelo = tipoVuelo;
	}
	
	public Ciudad getOrigen() {
		return origen;
	}
	public void setOrigen(Ciudad origen) {
		this.origen = origen;
	}
	
	public Ciudad getDestino() {
		return destino;
	}
	public void setDestino(Ciudad destino) {
		this.destino = destino;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
