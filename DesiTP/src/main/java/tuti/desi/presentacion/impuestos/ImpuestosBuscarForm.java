package tuti.desi.presentacion.impuestos;

import java.util.Map;

public class ImpuestosBuscarForm {

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

}