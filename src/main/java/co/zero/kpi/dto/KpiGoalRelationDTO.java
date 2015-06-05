package co.zero.kpi.dto;

import co.zero.common.dto.EntityDTO;

/**
 * Clase que define una relacion entre un empleado y un objetivo (responsable)
 * 
 * @author Youlyn Chinome
 */
public abstract class KpiGoalRelationDTO extends EntityDTO{
	//Identificador requerido para la serialización
	private static final long serialVersionUID = 1L;
	//Objetivo al que es asigando el employment
	protected KpiGoalDTO goal;
	//Ponderación de la colaboración al objetivo
	protected double contributeWeight;
	
	/**
	 * Metodo que permite obtener el objetivo al que es asigando el employment
	 * @return El objetivo al que es asigando el employment
	 */
	public KpiGoalDTO getGoal() {
		return goal;
	}

	/**
	 * Metodo que permite modificar el objetivo al que es asigando el employment
	 * @param parent El objetivo al que es asigando el employment
	 */
	public void setGoal(KpiGoalDTO goal) {
		this.goal = goal;
	}
	
	/**
	 * Metodo que permite obtener la ponderación de la colaboración al objetivo
	 * @return Ponderación de la colaboración al objetivo
	 */
	public double getContributeWeight() {
		return contributeWeight;
	}

	/**
	 * Método que permite modificar la ponderación de la colaboración al objetivo
	 * @param contributeWeight La nueva ponderación de la colaboración al objetivo
	 */
	public void setContributeWeight(double contributeWeight){
		this.contributeWeight = contributeWeight;
	}
	
	/*
	 * (non-Javadoc)
	 * @see co.zero.common.dto.EntityDTO#toString()
	 */
	@Override
	public String toString() {
		StringBuilder text = new StringBuilder(super.toString());
		long goalId = this.goal == null ? 0 : this.goal.getId();
		text.append(" [goal="+goalId+"]");
		text.append(" [contributeWeight="+this.contributeWeight+"]");
		return text.toString();
	}
}