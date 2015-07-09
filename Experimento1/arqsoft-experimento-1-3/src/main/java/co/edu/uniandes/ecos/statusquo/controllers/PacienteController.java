package co.edu.uniandes.ecos.statusquo.controllers;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import co.edu.uniandes.ecos.statusquo.business.PacienteEJB;
import co.edu.uniandes.ecos.statusquo.criteria.PacienteCriteria;
import co.edu.uniandes.ecos.statusquo.persistence.entities.Paciente;

@ManagedBean
@SessionScoped
public class PacienteController {

	@EJB
	private PacienteEJB pacienteEJB;
	
	private PacienteCriteria pacienteCriteria = new PacienteCriteria();
	
	private Paciente pacienteResult = new Paciente();
	
	private boolean hasResult;

	public PacienteCriteria getPacienteCriteria() {
		return pacienteCriteria;
	}

	public void setPacienteCriteria(PacienteCriteria pacienteCriteria) {
		this.pacienteCriteria = pacienteCriteria;
	}
	
	public Paciente getPacienteResult() {
		return pacienteResult;
	}

	public void setPacienteResult(Paciente pacienteResult) {
		this.pacienteResult = pacienteResult;
	}
	
	public boolean isHasResult() {
		return hasResult;
	}

	public void setHasResult(boolean hasResult) {
		this.hasResult = hasResult;
	}

	/*
	 * Métodos específicos de controlador
	 */
	public void buscarPaciente(){
		Paciente paciente = null;
		try {
			paciente = pacienteEJB.consultarIdentificacion(pacienteCriteria.getIdentificacion());
			if (paciente !=null){
				System.out.println(paciente.getPrimerNombre());
				hasResult = true;
			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_INFO, "Info", 
						"No existe el paciente con los criterios seleccionados");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_FATAL, "Error fatal", 
					"Ocurrió un problema en el funcionamiento del sistema");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		
	}
	
	
}
