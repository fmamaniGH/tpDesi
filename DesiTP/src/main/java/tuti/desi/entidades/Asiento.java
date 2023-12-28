package tuti.desi.entidades;

import jakarta.persistence.*;

@Entity
public class Asiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private int fila;

	@Column(nullable = false)
	private int columna;

	@ManyToOne
	@JoinColumn(name = "persona_id")
	private Persona persona;

	@ManyToOne
	@JoinColumn(name = "vuelo_id", nullable = true)
	private Vuelo vuelo;

	public Asiento() {
		super();
	}

	public Asiento(int fila, int columna, boolean ocupado, Vuelo vuelo) {
		super();
		this.fila = fila;
		this.columna = columna;
		this.persona = null;
		this.vuelo = vuelo;
	}

	// Getters
	public Long getId() {
		return id;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public int getFila() {
		return this.fila;
	}

	public int getColumna() {
		return this.columna;
	}

	public Persona getPersona() {
		return this.persona;
	}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Asiento [id=" + id + ", fila=" + fila + ", columna=" + columna + ", persona=" + persona + ", vuelo="
				+ vuelo + "]";
	}
}
