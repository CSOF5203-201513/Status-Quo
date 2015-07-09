package co.edu.uniandes.ecos.statusquo.criteria;

import java.util.Date;

/**
 * Criterios de búsqueda en el formulario web
 * @author Zamir
 *
 */
public class PacienteCriteria {
	
	/**
	 * Identificación del paciente
	 */
	private Long identificacion;
	
	/**
	 * Fecha de inicio de los episodios de dolor 
	 */
	private Date fechaInicio;
	
	/**
	 * Fecha fin de episodios de dolor
	 */
	private Date fechaFin;

	public Long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	

}
