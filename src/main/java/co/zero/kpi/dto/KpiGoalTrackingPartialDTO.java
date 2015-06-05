package co.zero.kpi.dto;

import co.zero.common.enumeration.SemaphoreLevelType;
import co.zero.common.exception.ZeroException;

/**
 * Clase que define la métrica general que se debe cumplir al finalizar el periodo para el objetivo asociado
 * 
 * @author Youlyn Chinome
 */
public class KpiGoalTrackingPartialDTO extends KpiGoalTrackingDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;

	//Pariodo que se está evaluando
	private KpiMetricPeriodDTO period;
	//Valor que permite llevar un registro del valor acumulado, cuando los valores valores 
	//acumulados no son la suma simple de los valores parciales
	private double accumulatedValue;
	//Valor que permite identificar problemas en el valor de cumplimiento
	private int successfulIndicator;
	//Cadena que contiene el codigo hexadecimal que identifica al successfulIndicator
	//p.e. Si el indicador se cree perdido, generalmente tomará el valor correspondiente al rojo
	private String successfulIndicatorFlag;
	//Determina si el tracking no se debe tener encuenta para los reportes
	private boolean notApply;
	
	//Atributo funcional que permite saber si el usuario desea eliminar el registro
	private boolean delete;
	
	/**
	 * Método que permite obtener el periodo que se está evaluando
	 * @return El periodo evaluado
	 */
	public KpiMetricPeriodDTO getPeriod() {
		return period;
	}

	/**
	 * Método que permite modificar el periodo evaluado
	 * @param period the period to set
	 */
	public void setPeriod(KpiMetricPeriodDTO period) {
		this.period = period;
	}

	/**
	 * Método que permite obtener el valor acumulado del valor de la métrica
	 * (Este valor sólo es útil cuando la métrica no tiene el valor total calculado)
	 * @return El valor acumulado hasta el momento luego de la evaluación parcial
	 */
	public double getAccumulatedValue() {
		return accumulatedValue;
	}

	/**
	 * Método que permite modificar el valor acumulado del valor de la métrica
	 * @param accumulatedValue El nuevo valor acumulado luego de la evaluación parcial
	 */
	public void setAccumulatedValue(double accumulatedValue) {
		this.accumulatedValue = accumulatedValue;
	}

	/**
	 * Método que permite obtener el identificador de exito de la métrica. Este indicador es un 
	 * número significativo para el cliente que le permite tomar decisiones para lograr alcanzar 
	 * las métas propuestas antes de que estas se encuentren totalmente perdidas
	 * @return El valor correspondiente al indicador de exito gestionado por cada empresa
	 */
	public int getSuccessfulIndicator() {
		return successfulIndicator;
	}

	/**
	 * Método que permite modificar el identificador de exito de la métrica.
	 * @param successfulIndicator El nuevo valor que servirá como indicador de exito de la métricas
	 */
	public void setSuccessfulIndicator(int successfulIndicator) {
		this.successfulIndicator = successfulIndicator;
	}

	/**
	 * Método que permite obtener el flag (Color) representativo del indicador de exito
	 * @return Cadena que representa en formato hexadecimal a un color representativo del indicador de exito
	 */
	public String getSuccessfulIndicatorFlag() {
		return successfulIndicatorFlag;
	}

	/**
	 * Método que permite modificar el flag representativo del indicador de exito
	 * @param successfulIndicatorFlag El nuevo color que representará al indicador de exito
	 */
	public void setSuccessfulIndicatorFlag(String successfulIndicatorFlag) {
		this.successfulIndicatorFlag = successfulIndicatorFlag;
	}
	
	/**
	 * Método que permite determinar si el tracking es relevante para la generación de reportes
	 * @return True si el tracking no se debe tener en cuenta, false de lo contrario
	 */
	public boolean isNotApply() {
		return notApply;
	}

	/**
	 * Método que permite modificar la relevancia del tracking para la generación de reportes
	 * @param notApply True si no desea que el tracking se tenga en cuenta 
	 * para cálculos, false de lo contrario
	 */
	public void setNotApply(boolean notApply) {
		this.notApply = notApply;
	}

	/**
	 * Método que permite obtener el porcentaje alcanzado por el objetivo
	 * 
	 * @return El valor del porcentaje de cumplimiento alcanzado por el objetivo
	 * @throws ZeroException
	 */
	public double getReachPercent() throws ZeroException{
		return period.getMetricPartial().findSemaphorePercentForValue(getRealValue(), getRealDateValue());
	}
	
	/**
	 * Método que permite obtener el nivel alcanzado del objetivo
	 * 
	 * @return El semaforo que representa el nivel alcanzado
	 * @throws ZeroException 
	 */
	public SemaphoreLevelType getReachLevel() throws ZeroException{
		return period.getMetricPartial().findSemaphoreLevelTypeForValue(getRealValue(), getRealDateValue());
	}

	/**
	 * Metodo que permite saber si se desea borrar este registro
	 * 
	 * @return
	 */
	public boolean isDelete() {
		return delete;
	}

	/**
	 * Metodo que permite elegir este registro para borrarlo
	 * 
	 * @param delete
	 */
	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	
}