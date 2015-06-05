//=======================================================================
// ARCHIVO BscGoalTrackingDTO.java
// FECHA CREACIÓN: 10/02/2011
//=======================================================================
package co.zero.bsc.dto;

import java.util.Date;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.SemaphoreLevelType;
import co.zero.common.enumeration.kpi.TrackingGeneralFormulaType;
import co.zero.common.exception.ZeroException;

/**
 * Clase que permite modelar las evaluaciones que se realizarán a los objetivos
 * @author Hernán Tenjo
 * @version 1.0
 */
public class BscGoalTrackingDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Relacion Cargo-Objetivo que se está evaluando
	private BscJobGoalDTO jobGoal;
	//Atributo que determina si el valor del objetivo será asignado directamente  
	private TrackingGeneralFormulaType assignedValueType;
	//Valor real alcanzado por el empleado en el objetivo cuando la métrica es numérica
	private double realValue;
	//Valor real alcanzado por el empleado en el objetivo, cuando la métrica es de fechas
	private Date realDateValue;
	//Si se desea se pueden agregar algunos comentarios a la evaluación
	private String comment;
	
	/**
	 * Metodo que permite obtener la relación evaluada
	 * @return La relación evaluada
	 */
	public BscJobGoalDTO getJobGoal() {
		return jobGoal;
	}

	/**
	 * Metodo que permite modificar la relación evaluada
	 * @param jobGoal La nueva relación que será evaluada
	 */
	public void setJobGoal(BscJobGoalDTO jobGoal) {
		this.jobGoal = jobGoal;
	}

	/**
	 * Metodo que permite obtener el comentario realizado en la evaluación
	 * @return El comentario realizado en la evaluación
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Metodo que permite modificar el comentario realizado en la evaluación
	 * @param comment El nuevo comentario de la evaluacion
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * Metodo que permite obtener el valor real alcanzado por el empleado
	 * con respecto a la métrica
	 * @return El valor real alcanzado por el empleado
	 */
	public double getRealValue() {
		return realValue;
	}

	/**
	 * Metodo que permite modificar el valor real alcanzado por el empleado
	 * @param realValue El nuevo valor alcanzado por el empleado
	 */
	public void setRealValue(double realValue) {
		this.realValue = realValue;
	}
	
	/**
	 * Método que permite obtener el nivel alcanzado del objetivo
	 * @return El semaforo que representa el nivel alcanzado
	 * @throws ZeroException 
	 */
	public SemaphoreLevelType getReachLevel() throws ZeroException{
		return jobGoal.getGoal().getMetric().findSemaphoreLevelTypeForValue(realValue, realDateValue);
	}
	
	/**
	 * Método que permite obtener el porcentaje alcanzado por el objetivo
	 * @return El valor del porcentaje de cumplimiento alcanzado por el objetivo
	 * @throws ZeroException
	 */
	public double getReachPercent() throws ZeroException{
		return jobGoal.getGoal().getMetric().findSemaphorePercentForValue(realValue, realDateValue);
	}
	
	/**
	 * Método que permite obtener el tipo de asignación con 
	 * la que se realiza el calculo del valor final del objetivo
	 * @return El tipo de asignación configurada en el tracking
	 */
	public TrackingGeneralFormulaType getAssignedValueType() {
		return assignedValueType;
	}

	/**
	 * Método que permite modificar el tipo de asignacion con la que
	 * se realiza el calculo del valor final del objetivo
	 * @param assignedValueType the assignedValueType to set
	 */
	public void setAssignedValueType(TrackingGeneralFormulaType assignedValueType) {
		this.assignedValueType = assignedValueType;
	}
	
	/**
	 * Método que permite obtener el valor real alcanzado cuando se están manejando fechas
	 * @return La fecha correspondiente al valor real alcanzado
	 */
	public Date getRealDateValue() {
		return realDateValue;
	}

	/**
	 * Método que permite modificar el valor real alcanzado cuando se están manejando fechas
	 * @param realDateValue La nueva fecha correspondiente al valor real alcanzado
	 */
	public void setRealDateValue(Date realDateValue) {
		this.realDateValue = realDateValue;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.zero.common.dto.EntityDTO#toString()
	 */
	@Override
	public String toString() {
		long jobGoalId = jobGoal == null ? 0 : jobGoal.getId();
		return String.format("[jobGoalId = %s][realValue = %s][realDateValue = %s][comment = %s][assignedType = %s]"
				, jobGoalId, realValue, realDateValue, comment, assignedValueType);
	}
}