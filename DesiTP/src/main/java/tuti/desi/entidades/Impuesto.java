package tuti.desi.entidades;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Impuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private BigDecimal porcentajeIva;
    
    private BigDecimal montoTasaNacional;
        
    private BigDecimal montoTasaInternacional;
    
    private BigDecimal cotizacionDolar;

    @ManyToOne
    private Vuelo vuelo;

    public Impuesto() {
    }

    public Impuesto(Long id, BigDecimal porcentajeIva, BigDecimal montoTasaNacional, BigDecimal montoTasaInternacional, BigDecimal cotizacionDolar, Vuelo vuelo) {
        this.id = id;
        this.porcentajeIva = porcentajeIva;
        this.montoTasaNacional = montoTasaNacional;
        this.montoTasaInternacional = montoTasaInternacional;
        this.cotizacionDolar = cotizacionDolar;
        this.vuelo = vuelo;
    }
    
    public BigDecimal getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(BigDecimal porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public BigDecimal getMontoTasaNacional() {
        return montoTasaNacional;
    }

    public void setMontoTasaNacional(BigDecimal montoTasaNacional) {
        this.montoTasaNacional = montoTasaNacional;
    }
    
    public BigDecimal getMontoTasaInternacional() {
        return montoTasaInternacional;
    }

    public void setMontoTasaInternacional(BigDecimal montoTasaInternacional) {
        this.montoTasaInternacional = montoTasaInternacional;
    }
    
    public BigDecimal getCotizacionDolar() {
        return cotizacionDolar;
    }

    public void setCotizacionDolar(BigDecimal cotizacionDolar) {
        this.cotizacionDolar = cotizacionDolar;
    }
    
    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

}
