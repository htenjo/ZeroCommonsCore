//=======================================================================
// ARCHIVO MetricValue.java
// FECHA CREACIÓN: 9/08/2011
//=======================================================================
package co.zero.bsc.dto;

import javax.faces.event.ActionEvent;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.SemaphoreLevelType;


/**
 * Descripción de la clase
 * @author Hernán Tenjo
 * @version 1.0
 */
public class BscMetricValuePartialComplimentDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	private static final String COMPLIMENT_LEVEL_ATTRIBUTE = "complimentLevel";
	//Métrica a la que pertenece  el valor de cumplimiento
	private BscMetricPartialDTO metric;
    // Enumeración que permite relacionar un valor de métrica a un semaforo
    private SemaphoreLevelType complimentLevel = SemaphoreLevelType.RED_LIGHT;
	//Valor inferior del rango
	private double lowPercent = 0;
	//Valor superior del rango
	private double highPercent = 0;
	
	/**
	 * Método que permite modificar el semáforo asociado al valor con un evento
	 * @param e Objeto con la información del evento generado
	 */
	public void changeComplimentLevel(ActionEvent e){
		String levelParameter = e.getComponent().getAttributes().get(COMPLIMENT_LEVEL_ATTRIBUTE).toString();
		this.complimentLevel = SemaphoreLevelType.valueOf(levelParameter);
	}	
	
	/**
	 * @return the metric
	 */
	public BscMetricPartialDTO getMetric() {
		return metric;
	}

	/**
	 * @param metric the metric to set
	 */
	public void setMetric(BscMetricPartialDTO metric) {
		this.metric = metric;
	}



	/**
	 * @return the lowPercent
	 */
	public double getLowPercent() {
		return lowPercent;
	}

	/**
	 * @param lowPercent the lowPercent to set
	 */
	public void setLowPercent(double lowPercent) {
		this.lowPercent = lowPercent;
	}

	/**
	 * @return the hightPercent
	 */
	public double getHighPercent() {
		return highPercent;
	}

	/**
	 * @param hightPercent the hightPercent to set
	 */
	public void setHighPercent(double hightPercent) {
		this.highPercent = hightPercent;
	}
	
	/**
	 * @return the complimentLevel
	 */
	public SemaphoreLevelType getComplimentLevel() {
		return complimentLevel;
	}

	/**
	 * @param complimentLevel the complimentLevel to set
	 */
	public void setComplimentLevel(SemaphoreLevelType complimentLevel) {
		this.complimentLevel = complimentLevel;
	}
}