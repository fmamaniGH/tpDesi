package tuti.desi.presentacion.vuelos;

public class VueloBuscarForm {

	private String codigo;
	//private Long IdCiudadSeleccionada;
	

	public String getCodigo() {
		if(codigo!=null)
			return codigo;
		else
			return null;
	}

	public void setcodigo(String codigo) {
		this.codigo = codigo;
	}
	
	//public Long getIdCiudadSeleccionada() {
	//	return IdCiudadSeleccionada;
	//}
	//public void setIdCiudadSeleccionada(Long idCiudadSeleccionada) {
	//	IdCiudadSeleccionada = idCiudadSeleccionada;
	//}
}
