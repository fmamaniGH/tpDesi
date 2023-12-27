package tuti.desi.presentacion.vuelos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import tuti.desi.entidades.Vuelo;

public class VueloForm {

	private Long id;

	@NotNull(message = "el codigo no puede ser nulo")
	@Size(min = 5, max = 10, message = "Longitud entre 5 y 10 caracteres")
	private String codigo;

	public Integer cantidadDeAsientos;

	@NotNull(message = "la fecha y hora no puede ser nulo")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime fechaYHora;

	@NotNull(message = "el tipo de vuelo no puede ser nulo")
	private String tipoVuelo;

	@NotNull(message = "el precio no puede ser nulo")
	@Min(value = 0, message = "el precio debe ser mayor a 0")
	@DecimalMin(value = "0.0", inclusive = false)
	@Digits(integer = 7, fraction = 2)
	private BigDecimal precioPasaje;

	@NotNull(message = "la aeronave no puede ser nula")
	private Long idAeronave;

	@NotNull(message = "el origen no puede ser nulo")
	private Long idOrigen;

	@NotNull(message = "el destino no puede ser nulo")
	private Long idDestino;

	private String estado;

	private Boolean editando = false;

	public VueloForm() {
		super();
	}

	public VueloForm(Vuelo vuelo) {
		super();
		this.id = vuelo.getId();
		this.codigo = vuelo.getCodigo();
		this.cantidadDeAsientos = vuelo.getCantidadDeAsientos();
		this.fechaYHora = vuelo.getFechaYHora();
		this.tipoVuelo = vuelo.getTipoVuelo();
		this.precioPasaje = vuelo.getPrecioPasaje();
		this.idAeronave = vuelo.getAeronave().getId();
		this.idOrigen = vuelo.getOrigen().getId();
		this.idDestino = vuelo.getDestino().getId();
		this.estado = vuelo.getEstado();
		this.editando = true;
	}

	public Vuelo toPojo() {
		Vuelo vuelo = new Vuelo();
		if (this.editando) {
			vuelo.setId(this.getId());
		}
		vuelo.setCodigo(this.codigo);
		vuelo.setFechaYHora(this.fechaYHora);
		vuelo.setPrecioPasaje(this.precioPasaje);

		return vuelo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getCantidadDeAsientos() {
		return cantidadDeAsientos;
	}

	public void setCantidadDeAsientos(Integer cantidadDeAsientos) {
		this.cantidadDeAsientos = cantidadDeAsientos;
	}

	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}

	public void setFechaYHora(LocalDateTime fechaYHora) {
		this.fechaYHora = fechaYHora;
	}

	public String getTipoVuelo() {
		return tipoVuelo;
	}

	public void setTipoVuelo(String tipoVuelo) {
		this.tipoVuelo = tipoVuelo;
	}

	public BigDecimal getPrecioPasaje() {
		return precioPasaje;
	}

	public void setPrecioPasaje(BigDecimal precioPasaje) {
		this.precioPasaje = precioPasaje;
	}

	public Long getIdAeronave() {
		return idAeronave;
	}

	public void setIdAeronave(Long idAeronave) {
		this.idAeronave = idAeronave;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}
}
