package tuti.desi.entidades;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Persona {
	@Id
	private Long dni;

	private String nombre;

	private String apellido;

	private Date fechaNacimiento;

	private String email;

	private String pasaporte;

	/**
	 * propiedad utilizada por la capa de presentacion para saber si es una entidad
	 * ya persistida (la estoy actualizando) o es nueva, ya que si id es ingresado
	 * por el usuario, no puede ser usado como criterio para saber si fue persistida
	 * o no.
	 */
	@Transient
	private Boolean editando = false;

	@ManyToOne
	private Ciudad ciudad;

	public Persona() {
		super();
	}

	public Persona(Long dni, String nombre, String apellido, Date fechaNacimiento, String email, String pasaporte,
			Boolean editando, Ciudad ciudad) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.pasaporte = pasaporte;
		this.editando = editando;
		this.ciudad = ciudad;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}

	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
				+ fechaNacimiento + ", email=" + email + ", pasaporte=" + pasaporte + ", editando=" + editando
				+ ", ciudad=" + ciudad + "]";
	}
}
