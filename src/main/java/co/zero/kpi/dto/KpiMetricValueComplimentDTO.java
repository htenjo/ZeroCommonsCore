/**
 * 
 */
package co.zero.kpi.dto;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.SemaphoreLevelType;

/**
  * Clase que permite modelar a los valores de cumplimiento posibles que puede tener una metrica con valores continuos 
  * @author Hernan Tenjo
  * @version 1.0
  **/
public class KpiMetricValueComplimentDTO  extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	
	//Métrica a la que pertenece  el valor de cumplimiento
	private KpiMetricDTO metric;
    // Enumeración que permite relacionar un valor de métrica a un semaforo
    private SemaphoreLevelType complimentLevel;
	//Valor inferior del rango
	private double lowPercent = 0;
	//Valor superior del rango
	private double highPercent = 0;
	
	/**
	 * Método que permite obtener la métrica a la que pertenece el valor de cumplimiento
	 * @return La métrica a la que pertenece el valor de cumplimiento
	 */
	public KpiMetricDTO getMetric() {
		return metric;
	}
	
	/**
	 * Método que permite modificar la métrica a la que pertenece el valor de cumplimiento
	 * @param metric La nueva métrica a al que pertenece el valor de cumplimiento
	 */
	public void setMetric(KpiMetricDTO metric) {
		this.metric = metric;
	}
	
	/**
	 * Método que permite obtener el nivel de cumplimiento
	 * @return El nivel de cumplimiento (Semáforo) obtenido
	 */
	public SemaphoreLevelType getComplimentLevel() {
		return complimentLevel;
	}
	
	/**
	 * Método que permite modificar el nivel de cumplimiento
	 * @param complimentLevel EL nuevo nivel de cumplimiento
	 */
	public void setComplimentLevel(SemaphoreLevelType complimentLevel) {
		this.complimentLevel = complimentLevel;
	}
	
	/**
	 * Método que permite obtener el porcentaje inferior del rango de cumplimiento
	 * @return El porcentaje inferior del valor de cumplimiento
	 */
	public double getLowPercent() {
		return lowPercent;
	}
	
	/**
	 * Método que permite modificar el porcentaje inferior del rango de cumplimiento
	 * @param lowPercent El nuevo porcentaje del límite inferior para el valor de cumplimiento 
	 */
	public void setLowPercent(double lowPercent) {
		this.lowPercent = lowPercent;
	}
	
	/**
	 * Método que permite obtener el porcentaje superior del rango de cumplimiento
	 * @return El porcentaje superior del valor de cumplimiento
	 */
	public double getHighPercent() {
		return highPercent;
	}
	
	/**
	 * Métodoq que permite modificar el porcentaje superior del rango de cumplimiento
	 * @param hightPercent El nuevo porcentaje del límite superior para el valor de cumplimiento
	 */
	public void setHighPercent(double hightPercent) {
		this.highPercent = hightPercent;
	}
}
