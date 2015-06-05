//=======================================================================
// ARCHIVO BscMetricPeriodDTO.java
// FECHA CREACIÓN: 6/07/2011
//=======================================================================
package co.zero.bsc.dto;

import java.util.Date;

import co.zero.common.dto.EntityDTO;

/**
 * Clase que permite establecer las pautas para evaluar el desempeño
 * de un objetivo con respecto a una meta dada
 * @author Hernán Tenjo
 * @version 1.0
 */
public class BscMetricPeriodDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Fecha de inicio del periodo de la métrica
	private Date startDate;
	//Fecha de finalización del periodo de la métrica
	private Date endDate;
	//Métrica a la que pertenece el periodo
	private BscMetricDTO metric;
	//Atributo que permite determinar si el periodo se encuestra 
	//disponible para ser usado por una métrica parcial
	private boolean available;
	//Métrica parcial con la que será evaluado el periodo
	private BscMetricPartialDTO metricPartial;
	
	/**
	 * Método que permite determinar si este periodo es anterior a uno dado
	 * Un periodo A es anterior a otro B, si y sólo si, la fecha de finalización
	 * de A es menor que la fecha de inicio de B
	 * @param period El periodo que se desea comparar
	 * @return True si el periodo dado es posterior que este periodo, false de lo contrario
	 */
	public boolean isBefore(BscMetricPeriodDTO period){
		return this.getEndDate().before(period.getStartDate());
	}
	
	/**
	 * Método que permite obtener la fecha inicial del periodo
	 * @return La fecha inicial configurada para el periodo
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Método que permite modificar la fecha inicial del periodo
	 * @param startDate La nueva fecha inicial del periodo
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Método que permite obtener la fehca inicial del periodo
	 * @return La fecha final configurada para el periodo
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Método que permite modificar la fecha de finalización del periodo
	 * @param endDate La nueva fecha final del periodo
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Método que permite obtener la métrica a la que pertenece el periodo
	 * @return La métrica configurada a la que pertenece el periodo
	 */
	public BscMetricDTO getMetric() {
		return metric;
	}

	/**
	 * Métrica que permite modificar la métrica a la que pertenece el periodo
	 * @param metric La nueva métrica dueña del periodo
	 */
	public void setMetric(BscMetricDTO metric) {
		this.metric = metric;
	}

	/**
	 * Método que permite determinar si el periodo se encuentra disponible
	 * para ser asociado a una métrica parcial
	 * @return True si el periodo está disponible, False de lo contrario
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * Método que permite modificar la disponibilidad del periodo
	 * @param available True si se desea que el periodo se encuentre
	 * disponible, false de lo contrario.
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	/**
	 * Método que permite obtener la métrica parcial asociada al periodo
	 * @return La métrica parcial asociada al periodo
	 */
	public BscMetricPartialDTO getMetricPartial() {
		return metricPartial;
	}

	/**
	 * Método que permite modificar la métrica parcial del periodo
	 * @param metricPartial La nueva métrica que será asociada al perido
	 */
	public void setMetricPartial(BscMetricPartialDTO metricPartial) {
		this.metricPartial = metricPartial;
	}
}