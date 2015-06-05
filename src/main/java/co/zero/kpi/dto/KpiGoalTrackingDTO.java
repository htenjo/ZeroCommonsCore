package co.zero.kpi.dto;

import java.util.Date;

import co.zero.common.dto.EntityDTO;

/**
 * Clase que permite establecer registrar las evaluaciones de un objetivo
 * 
 * @author Youlyn Chinome
 */
public abstract class KpiGoalTrackingDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	
	//Objetivo que se va a evaluar
	private KpiGoalDTO goal;
	//Valor real alcanzado en el objetivo cuando la métrica es numérica
	private double realValue;
	//Valor real alcanzado en el objetivo, cuando la métrica es de fechas
	private Date realDateValue;
	//Si se desea se pueden agregar algunos comentarios a la evaluación
	private String comment;
	//Indica si el registro del tracking se genero a partir de un goal por division o compania
	//de tal forma que no se han agregado las relaciones con los empleados evaluados
	private boolean massive;

	/**
	 * Metodo que permite obtener el objetivo que se esta evaluando
	 * 
	 * @return
	 */
	public KpiGoalDTO getGoal() {
		return goal;
	}

	/**
	 * Metodo que permite modificar el objetivo que se esta evaluando
	 * 
	 * @param goal
	 */
	public void setGoal(KpiGoalDTO goal) {
		this.goal = goal;
	}

	/**
	 * Metodo que permite obtener el valor real alcanzado en el objetivo cuando la métrica es numérica
	 * 
	 * @return
	 */
	public double getRealValue() {
		return realValue;
	}

	/**
	 * Metodo que permite modificar el valor real alcanzado en el objetivo cuando la métrica es numérica
	 * 
	 * @param realValue
	 */
	public void setRealValue(double realValue) {
		this.realValue = realValue;
	}

	/**
	 * Metodo que permite obtener el valor real alcanzado en el objetivo, cuando la métrica es de fechas
	 * 
	 * @return
	 */
	public Date getRealDateValue() {
		return realDateValue;
	}

	/**
	 * Metodo que permite modificar el valor real alcanzado en el objetivo, cuando la métrica es de fechas
	 * 
	 * @param realDateValue
	 */
	public void setRealDateValue(Date realDateValue) {
		this.realDateValue = realDateValue;
	}

	/**
	 * Metodo que permite obtener los comentarios agregados a la evaluación
	 * 
	 * @return
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Metodo que permite modificar los comentarios agregados a la evaluación
	 * 
	 * @param comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * Metodo que permite saber si el registro es masivo, es decir si es la evaluacion
	 * de un objetivo por division/compania y por tanto no se le han creado las relaciones
	 * con los empleados evaluados
	 * @return
	 */
	public boolean isMassive() {
		return massive;
	}

	/**
	 * Metodo que permite modificar si el registro es masivo, es decir si es la evaluacion
	 * de un objetivo por division/compania y por tanto no se le han creado las relaciones
	 * con los empleados evaluados
	 * @param massive
	 */
	public void setMassive(boolean massive) {
		this.massive = massive;
	}
		
	/*
	 * (non-Javadoc)
	 * @see co.zero.common.dto.EntityDTO#toString()
	 */
	@Override
	public String toString() {
		long goalId = this.goal == null ? 0 : this.goal.getId();
		StringBuilder text = new StringBuilder(super.toString());
		text.append(" [goal="+goalId+"]");
		text.append(" [realValue="+this.realValue+"]");
		text.append(" [realDateValue="+this.realDateValue+"]");
		text.append(" [comment="+this.comment+"]");
		return text.toString();
	}
	
}