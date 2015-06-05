package co.zero.kpi.dto;

import co.zero.hcm.dto.DivisionDTO;

/**
 * Clase que define una relacion entre una division y un objetivo
 * 
 * @author Youlyn Chinome
 */
public class KpiGoalRelationDivisionDTO extends KpiGoalRelationDTO{
	//Identificador requerido para la serialización
	private static final long serialVersionUID = 1L;
	//Division que esta asignado al objetivo
	private DivisionDTO division;
	
	/**
	 * Metodo que permite obtener la division que esta asignada al objetivo
	 * @return La division que esta asignada al objetivo
	 */
	public DivisionDTO getDivision() {
		return division;
	}

	/**
	 * Metodo que permite modificar la division que esta asignada al objetivo
	 * @param division La division que esta asignada al objetivo
	 */
	public void setDivision(DivisionDTO division){
		this.division = division;
	}
	
	/*
	 * (non-Javadoc)
	 * @see co.zero.common.dto.EntityDTO#toString()
	 */
	@Override
	public String toString() {
		StringBuilder text = new StringBuilder(super.toString());
		long divisionId = this.division == null ? 0 : this.division.getId();
		long goalId = this.goal == null ? 0 : this.goal.getId();
		text.append(" [division="+divisionId+"]");
		text.append(" [goal="+goalId+"]");
		text.append(" [contributeWeight="+this.contributeWeight+"]");
		return text.toString();
	}
}