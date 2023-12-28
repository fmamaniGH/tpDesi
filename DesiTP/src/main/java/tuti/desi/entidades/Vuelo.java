package tuti.desi.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Vuelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true, name = "codigo")
	private String codigo;

	@Column(name = "cantidad_de_asientos", nullable = false, unique = true)
	private Integer cantidadDeAsientos;

	@Column(nullable = false, name = "fecha_hora")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime fechaYHora;

	@Column(name = "tipo_vuelo", nullable = false)
	private String tipoVuelo;

	@Column(nullable = false, precision = 10, scale = 2, name = "precio_pasaje")
	private BigDecimal precioPasaje;

	@ManyToOne
	@JoinColumn(name = "aeronave_id", nullable = false)
	private Aeronave aeronave;

	@ManyToOne
	@JoinColumn(name = "origen_id", nullable = false)
	private Ciudad origen;

	@ManyToOne
	@JoinColumn(name = "destino_id", nullable = false)
	private Ciudad destino;

	@Column(nullable = false)
	private String estado = "Normal";

	@OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Asiento> asientos = new ArrayList<Asiento>();

	public Vuelo() {
		super();
	}

	public Vuelo(Long id, String codigo, Integer cantidadDeAsientos, LocalDateTime fechaYHora, String tipoVuelo,
			BigDecimal precioPasaje, Aeronave aeronave, Ciudad origen, Ciudad destino, String estado,
			List<Asiento> asientos) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.cantidadDeAsientos = cantidadDeAsientos;
		this.fechaYHora = fechaYHora;
		this.tipoVuelo = tipoVuelo;
		this.precioPasaje = precioPasaje;
		this.aeronave = aeronave;
		this.origen = origen;
		this.destino = destino;
		this.estado = estado;
		this.asientos = asientos;
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

	public Aeronave getAeronave() {
		return aeronave;
	}

	public void setAeronave(Aeronave aeronave) {
		this.aeronave = aeronave;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Asiento> getAsientos() {
		return asientos;
	}

	public void setAsientos(List<Asiento> asientos) {
		this.asientos = asientos;
	}

	public void agregar(Asiento asiento) {
		if (this.asientos == null) {
			this.asientos = new ArrayList<>();
		}
		this.asientos.add(asiento);
	}

	@Override
	public String toString() {
		return "Vuelo [id=" + id + ", codigo=" + codigo + ", cantidadDeAsientos=" + cantidadDeAsientos + ", fechaYHora="
				+ fechaYHora + ", tipoVuelo=" + tipoVuelo + ", precioPasaje=" + precioPasaje + ", aeronave=" + aeronave
				+ ", origen=" + origen + ", destino=" + destino + ", estado=" + estado + ", asientos=" + asientos + "]";
	}
}
