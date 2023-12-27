package tuti.desi.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aeronave {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String modelo;

	@Column(nullable = false)
	private String fabricante;

	@Column(nullable = false)
	private Integer capacidad;

	public Aeronave() {
		super();
	}

	public Aeronave(Long id, String modelo, String fabricante, Integer capacidad) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.capacidad = capacidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "Aeronave [id=" + id + ", modelo=" + modelo + ", fabricante=" + fabricante + ", capacidad=" + capacidad
				+ "]";
	}
}
