package tuti.desi.entidades;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Impuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Double cotizacionDolar;
   
    private Double montoTasaInternacional;
    
    private Double montoTasaNacional;        

     private Double porcentajeIva;    

    @ManyToOne
    private Vuelo vuelo;

    public Impuesto() {
    }

    public Impuesto(Long id, Double porcentajeIva, Double montoTasaNacional, Double montoTasaInternacional, Double cotizacionDolar, Vuelo vuelo) {
        this.id = id;
        this.porcentajeIva = porcentajeIva;
        this.montoTasaNacional = montoTasaNacional;
        this.montoTasaInternacional = montoTasaInternacional;
        this.cotizacionDolar = cotizacionDolar;
        this.vuelo = vuelo;
    }
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
    public Double getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(Double porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public Double getMontoTasaNacional() {
        return montoTasaNacional;
    }

    public void setMontoTasaNacional(Double montoTasaNacional) {
        this.montoTasaNacional = montoTasaNacional;
    }
    
    public Double getMontoTasaInternacional() {
        return montoTasaInternacional;
    }

    public void setMontoTasaInternacional(Double montoTasaInternacional) {
        this.montoTasaInternacional = montoTasaInternacional;
    }
    
    public Double getCotizacionDolar() {
        return cotizacionDolar;
    }

    public void setCotizacionDolar(Double cotizacionDolar) {
        this.cotizacionDolar = cotizacionDolar;
    }
    
    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

}
