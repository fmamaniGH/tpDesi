package tuti.desi.presentacion.impuestos;
import jakarta.validation.constraints.NotNull;
import tuti.desi.entidades.Impuesto;

public class ImpuestosForm {
	
    private Long id;
    
    private Double cotizacionDolar;
   
    private Double montoTasaInternacional;
    
    private Double montoTasaNacional;        

    private Double porcentajeIva;    
     
	private Boolean editando=false;
	
	private String codigoVuelo;   
	
	@NotNull
	private Long idVuelo;
	
	public ImpuestosForm() {
		super();
	}
	
	public ImpuestosForm(Impuesto i) {
		super();
		
		this.setId(i.getId());
		this.setCotizacionDolar(i.getCotizacionDolar());
		this.setMontoTasaInternacional(i.getMontoTasaInternacional());
		this.setMontoTasaNacional(i.getMontoTasaNacional());
		this.setPorcentajeIva(i.getPorcentajeIva());
		this.setCodigoVuelo(codigoVuelo);
		this.idVuelo=i.getVuelo().getId();
		this.setEditando(true);
	}
	
	public Impuesto toPojo()
	{		
		Impuesto i = new Impuesto();
		if(this.getEditando())
		{
			i.setId(this.getId());
		}
		i.setCotizacionDolar(this.getCotizacionDolar());
		i.setMontoTasaInternacional(this.getMontoTasaInternacional());
		i.setMontoTasaNacional(this.getMontoTasaNacional());
		i.setPorcentajeIva(this.getPorcentajeIva());
		
		return i;		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getCotizacionDolar() {
		return cotizacionDolar;
	}

	public void setCotizacionDolar(Double cotizacionDolar) {
		this.cotizacionDolar = cotizacionDolar;
	}

	public Double getMontoTasaInternacional() {
		return montoTasaInternacional;
	}

	public void setMontoTasaInternacional(Double montoTasaInternacional) {
		this.montoTasaInternacional = montoTasaInternacional;
	}

	public Double getMontoTasaNacional() {
		return montoTasaNacional;
	}

	public void setMontoTasaNacional(Double montoTasaNacional) {
		this.montoTasaNacional = montoTasaNacional;
	}

	public Double getPorcentajeIva() {
		return porcentajeIva;
	}

	public void setPorcentajeIva(Double porcentajeIva) {
		this.porcentajeIva = porcentajeIva;
	}		
	
	public Boolean getEditando() {
		return editando;
	}
	public void setEditando(Boolean editando) {
		this.editando = editando;
	}

	public String getCodigoVuelo() {
		return codigoVuelo;
	}

	public void setCodigoVuelo(String codigoVuelo) {
		this.codigoVuelo = codigoVuelo;
	}

	public Long getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(Long idVuelo) {
		this.idVuelo = idVuelo;
	}	
	
}
