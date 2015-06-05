//=======================================================================
// ARCHIVO KpiMetricPeriod.java
// FECHA CREACIÓN: 2012/08/16
//=======================================================================
package co.zero.kpi.dto;

import java.util.Date;

import co.zero.common.dto.EntityDTO;

/**
 * Clase que establece un periodo que debe ser evaluado por una métrica parcial
 * @author Hernán Tenjo
 * @version 1.0
 */
public class KpiMetricPeriodDTO  extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	
	//Métrica a la que pertenece el periodo
	private KpiMetricGeneralDTO metric;
	//Métrica parcial con la que será evaluado el periodo
	private KpiMetricPartialDTO metricPartial;
	//Fecha de inicio del periodo
	private Date startDate;
	//Fecha de finalización del periodo
	private Date endDate;
	//Atributo que permite determinar si el periodo se encuestra 
	//disponible para ser usado por una métrica parcial
	private boolean available;
	
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
	public KpiMetricGeneralDTO getMetric() {
		return metric;
	}

	/**
	 * Métrica que permite modificar la métrica a la que pertenece el periodo
	 * @param metric La nueva métrica dueña del periodo
	 */
	public void setMetric(KpiMetricGeneralDTO metric) {
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
	public KpiMetricPartialDTO getMetricPartial() {
		return metricPartial;
	}

	/**
	 * Método que permite modificar la métrica parcial del periodo
	 * @param metricPartial La nueva métrica que será asociada al perido
	 */
	public void setMetricPartial(KpiMetricPartialDTO metricPartial) {
		this.metricPartial = metricPartial;
	}
}