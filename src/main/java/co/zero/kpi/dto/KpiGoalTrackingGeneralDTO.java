package co.zero.kpi.dto;

import co.zero.common.enumeration.SemaphoreLevelType;
import co.zero.common.enumeration.kpi.TrackingGeneralFormulaType;
import co.zero.common.exception.ZeroException;

/**
 * Clase que define la evaluacion para la metrica general del objetivo al finalizar el periodo
 * 
 * @author Youlyn Chinome
 */
public class KpiGoalTrackingGeneralDTO extends KpiGoalTrackingDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	
	//Atributo que determina si el valor del objetivo será asignado directamente  
	private TrackingGeneralFormulaType generalFormulaType;

	/**
	 * Método que permite obtener el tipo de asignación con 
	 * la que se realiza el calculo del valor final del objetivo
	 * @return El tipo de asignación configurada en el tracking
	 */
	public TrackingGeneralFormulaType getGeneralFormulaType() {
		return generalFormulaType;
	}

	/**
	 * Método que permite modificar el tipo de asignacion con la que
	 * se realiza el calculo del valor final del objetivo
	 * @param assignedValueType the assignedValueType to set
	 */
	public void setGeneralFormulaType(TrackingGeneralFormulaType generalFormulaType) {
		this.generalFormulaType = generalFormulaType;
	}
	
	/**
	 * Método que permite obtener el nivel alcanzado del objetivo
	 * @return El semaforo que representa el nivel alcanzado
	 * @throws ZeroException 
	 */
	public SemaphoreLevelType getReachLevel() throws ZeroException{
		return getGoal().getMetric().findSemaphoreLevelTypeForValue(getRealValue(), getRealDateValue());
	}
	
	/**
	 * Método que permite obtener el porcentaje alcanzado por el objetivo
	 * @return El valor del porcentaje de cumplimiento alcanzado por el objetivo
	 * @throws ZeroException
	 */
	public double getReachPercent() throws ZeroException{
		return getGoal().getMetric().findSemaphorePercentForValue(getRealValue(), getRealDateValue());
	}
	
}
