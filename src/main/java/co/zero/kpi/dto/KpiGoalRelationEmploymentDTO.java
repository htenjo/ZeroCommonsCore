package co.zero.kpi.dto;

import co.zero.hcm.dto.EmploymentDTO;

/**
 * Clase que define una relacion entre un empleado y un objetivo (responsable)
 * 
 * @author Youlyn Chinome
 */
public class KpiGoalRelationEmploymentDTO extends KpiGoalRelationDTO{
	//Identificador requerido para la serialización
	private static final long serialVersionUID = 1L;
	//Employment que esta asignado al objetivo
	private EmploymentDTO employment;
	
	/**
	 * Metodo que permite obtener el employment que esta asignado al objetivo
	 * @return El employment que esta asignado al objetivo
	 */
	public EmploymentDTO getEmployment() {
		return employment;
	}

	/**
	 * Metodo que permite modificar el employment que esta asignado al objetivo
	 * @param employment El employment que esta asignado al objetivo
	 */
	public void setEmployment(EmploymentDTO employment){
		this.employment = employment;
	}
	
	/*
	 * (non-Javadoc)
	 * @see co.zero.common.dto.EntityDTO#toString()
	 */
	@Override
	public String toString() {
		StringBuilder text = new StringBuilder(super.toString());
		long employmentId = this.employment == null ? 0 : this.employment.getId();
		long goalId = this.goal == null ? 0 : this.goal.getId();
		text.append(" [employment="+employmentId+"]");
		text.append(" [goal="+goalId+"]");
		text.append(" [contributeWeight="+this.contributeWeight+"]");
		return text.toString();
	}
}