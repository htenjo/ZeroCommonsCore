
package co.zero.kpi.dto;

import java.util.Date;

import co.zero.common.dto.EntityDTO;

/**
 * Clase que reune los datos estadísticos de los tracking parciales calculados, que serán especialmente útiles
 * para los reportes del módulo
 * @author Hernán Tenjo
 * @version 1.0
 */
public class KpiTrackingPartialStatisticsDTO extends EntityDTO{
	private static final long serialVersionUID = 1L;
	//Atributos que serán utilies para la generación de los reportes
	private long evaluationId;
	private long trackingId;
	private long goalId;
	private long periodId;
	private Date startDate;
	private Date endDate;
	private double realCompliment;
	private double expectedCompliment;
	//Valor del indicador dependiendo del tipo
	private Date realDateValue;
	private Double realValue;
	//Valores reales esperados
	private Double minRealValueExpected;
	private Double maxRealValueExpected;
	private Date minRealDateValueExpected;
	private Date maxRealDateValueExpected;	
	private boolean notApply;
	
	/**
	 * @return the evaluationId
	 */
	public long getEvaluationId() {
		return evaluationId;
	}

	/**
	 * @param evaluationId the evaluationId to set
	 */
	public void setEvaluationId(long evaluationId) {
		this.evaluationId = evaluationId;
	}

	/**
	 * @return the goalId
	 */
	public long getGoalId() {
		return goalId;
	}

	/**
	 * @param goalId the goalId to set
	 */
	public void setGoalId(long goalId) {
		this.goalId = goalId;
	}
	
	/**
	 * @return the trackingId
	 */
	public long getTrackingId() {
		return trackingId;
	}

	/**
	 * @param trackingId the trackingId to set
	 */
	public void setTrackingId(long trackingId) {
		this.trackingId = trackingId;
	}

	/**
	 * @return the periodId
	 */
	public long getPeriodId() {
		return periodId;
	}

	/**
	 * @param periodId the periodId to set
	 */
	public void setPeriodId(long periodId) {
		this.periodId = periodId;
	}

	/**
	 * @return the realCompliment
	 */
	public double getRealCompliment() {
		return realCompliment;
	}

	/**
	 * @param realCompliment the realCompliment to set
	 */
	public void setRealCompliment(double realCompliment) {
		this.realCompliment = realCompliment;
	}

	/**
	 * @return the expectedCompliment
	 */
	public double getExpectedCompliment() {
		return expectedCompliment;
	}

	/**
	 * @param expectedCompliment the expectedCompliment to set
	 */
	public void setExpectedCompliment(double expectedCompliment) {
		this.expectedCompliment = expectedCompliment;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	

	/**
	 * @return the realDateValue
	 */
	public Date getRealDateValue() {
		return realDateValue;
	}

	/**
	 * @param realDateValue the realDateValue to set
	 */
	public void setRealDateValue(Date realDateValue) {
		this.realDateValue = realDateValue;
	}

	/**
	 * @return the realValue
	 */
	public Double getRealValue() {
		return realValue;
	}

	/**
	 * @param realValue the realValue to set
	 */
	public void setRealValue(Double realValue) {
		this.realValue = realValue;
	}

	/**
	 * @return the minRealValueExpected
	 */
	public Double getMinRealValueExpected() {
		return minRealValueExpected;
	}

	/**
	 * @param minRealValueExpected the minRealValueExpected to set
	 */
	public void setMinRealValueExpected(Double minRealValueExpected) {
		this.minRealValueExpected = minRealValueExpected;
	}

	/**
	 * @return the maxRealValueExpected
	 */
	public Double getMaxRealValueExpected() {
		return maxRealValueExpected;
	}

	/**
	 * @param maxRealValueExpected the maxRealValueExpected to set
	 */
	public void setMaxRealValueExpected(Double maxRealValueExpected) {
		this.maxRealValueExpected = maxRealValueExpected;
	}

	/**
	 * @return the minRealDateValueExpected
	 */
	public Date getMinRealDateValueExpected() {
		return minRealDateValueExpected;
	}

	/**
	 * @param minRealDateValueExpected the minRealDateValueExpected to set
	 */
	public void setMinRealDateValueExpected(Date minRealDateValueExpected) {
		this.minRealDateValueExpected = minRealDateValueExpected;
	}

	/**
	 * @return the maxRealDateValueExpected
	 */
	public Date getMaxRealDateValueExpected() {
		return maxRealDateValueExpected;
	}

	/**
	 * @param maxRealDateValueExpected the maxRealDateValueExpected to set
	 */
	public void setMaxRealDateValueExpected(Date maxRealDateValueExpected) {
		this.maxRealDateValueExpected = maxRealDateValueExpected;
	}
	
	/**
	 * @return the notApply
	 */
	public boolean isNotApply() {
		return notApply;
	}

	/**
	 * @param notApply the notApply to set
	 */
	public void setNotApply(boolean notApply) {
		this.notApply = notApply;
	}
}
