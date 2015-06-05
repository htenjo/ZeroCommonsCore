//=======================================================================
// ARCHIVO BscJobGoalDTO.java
// FECHA CREACIÓN: 23/12/2010
//=======================================================================
package co.zero.bsc.dto;

import co.zero.common.dto.EntityDTO;
import co.zero.hcm.dto.JobDTO;

/**
 * Clase que representa la relación existente entre un cargo y un objetivo
 * @author Hernán Tenjo
 * @version 1.0
 */
public class BscJobGoalDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	
	//Cargo que se está relacionado con el objetivo
	private JobDTO job;
	//Objetivo que deberá alcanzar la persona responsable del cargo
	private BscGoalDTO goal;
	//Atributo utilitario que permite determinar facilmente si el
	//objetivo ya ha sido finalizado o se encuentra vigente
	private boolean finalized;
	//Ponderación del objetivo dentro de los objetivos del cargo
	private double weight;
	//Cadena que contiene la expresion a evaluar para los reportes
	private String expression;
		
	/**
	 * Metodo que permite determinar si el objetivo de la relación
	 * ya ha sido finalizado
	 * @return True si el objetivo ya ha finalizado, False de lo contrario
	 */
	public boolean isFinalized() {
		return finalized;
	}

	/**
	 * Metodo que permite modificar el estado finalizado del objetivo de la relación
	 * @param finalized True si el objetivo ya finalizó, False de lo contrario
	 */
	public void setFinalized(boolean finalized) {
		this.finalized = finalized;
	}

	/**
	 * Metodo que permite obtener el cargo de la relación
	 * @return El cargo configurado en la relación
	 */
	public JobDTO getJob() {
		return job;
	}

	/**
	 * Metodo que permite modificar el cargo de la relación
	 * @param job El nuevo cargo que será asignado a la relación
	 */
	public void setJob(JobDTO job) {
		this.job = job;
	}

	/**
	 * Metodo que permite obtener el objetivo asociado a la relación
	 * @return El objetivo configurado en la relación
	 */
	public BscGoalDTO getGoal() {
		return goal;
	}

	/**
	 * Metodo que permite modificar el objetivo asociado a la relación
	 * @param goal El nuevo objetivo asociado a la relación
	 */
	public void setGoal(BscGoalDTO goal) {
		this.goal = goal;
	}
	
	/**
	 * Método que permite obtener la ponderación del objetivo para el cargo
	 * @return El porcentaje de impacto del objetivo sobre el cargo
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Método que permite modificar la ponderación del objetivo para el cargo
	 * @param weight El nuevo porcentaje de ponderación del objetivo sobre el cargo
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
		
	/**
	 * Metodo que permite obtener la expresion asociada a la estrategia
	 * @return La expresion configurada hasta el momento en la estrategia
	 */
	public String getExpression() {
		return expression;
	}

	/**
	 * Metodo que permite modificar la expresion asociada a la estrategia
	 * @param expression La nueva expresion asociada a la estrategia
	 */
	public void setExpression(String expression) {
		this.expression = expression;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.zero.common.dto.EntityDTO#toString()
	 */
	@Override
	public String toString() {
		StringBuilder text = new StringBuilder(super.toString());
		long goalId = this.goal == null ? 0 : this.goal.getId();
		long jobId = this.job == null ? 0 : this.job.getId();		
		text.append(" [finalized="+this.finalized+"]");
		text.append(" [weight="+this.weight+"]");
		text.append(" [jobId = " + jobId + "]");
		text.append(" [goalId = " + goalId + "]");
		return text.toString();
	}
}