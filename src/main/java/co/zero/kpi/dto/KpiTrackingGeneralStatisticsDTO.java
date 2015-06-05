//=======================================================================
// ARCHIVO KpiTrackingGeneralStatistics.java
// FECHA CREACIÓN: 2013/03/08
//=======================================================================
package co.zero.kpi.dto;

import java.util.Date;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.kpi.MetricTrendType;
import co.zero.common.enumeration.kpi.TrackingGeneralFormulaType;

/**
 * Clase que reune los datos estadísticos de los tracking calculados, que serán especialmente útiles
 * para los reportes del módulo
 * @author Hernán Tenjo
 * @version 1.0
 */
public class KpiTrackingGeneralStatisticsDTO extends EntityDTO{
	private static final long serialVersionUID = 1L;
	//Identificador de la evaluación de kpis a la que pertenece el seguimiento
	private long evaluationId;
	//Identificador de la estrategia a la que pertenece el indicador
	private long strategyId;
	//Identificador del tracking que generó la estadísticas
	private long trackingId;
	//Porcentaje de cumplimiento obtenido en el indicador
	private double complimentReal;
	//Porcentaje de cumplimiento esperado para el indicador
	private double complimentExpected;
	//Valor del indicador dependiendo del tipo
	private Date realDateValue;
	private Double realValue;
	//Valores reales esperados
	private Double minRealValueExpected;
	private Double maxRealValueExpected;
	private Date minRealDateValueExpected;
	private Date maxRealDateValueExpected;
	//Tendencia del indicador
	private MetricTrendType trend;
	//Label que identifica las unidades en las que se expresan los valores de la métrica
	private String unitValue;
	//Label que contiene el símbolo corto que representa a las unidades de los valores de la métrica
	private String unitValueSymbol;
	//Identificador del objetivo que se evaluó en el seguimiento
	private long goalId;
	//Nombre del indicador evaluado
	private String goalName;
	//Descripción del indicador evaluado
	private String goalDescription;
	//Porcentaje de aporte al padre
	private double parentContributeWeight;
	//Determina si el valor esperado es de tipo Fecha o de Tipo Numérico
	private boolean valueAsDate;
	//Atributo que determina si el valor del indicador será asignado directamente o calculado
	private TrackingGeneralFormulaType generalFormulaType;
	//Porcentaje de aporte personal para una de las personas responsables del tracking
	//Util para el reporte individual. En caso de requerir todos los % se deberá enviar en una estructura separada
	private double personalWeight;
	private Date startDate;
	private Date endDate;
	
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
	 * @return the strategyId
	 */
	public long getStrategyId() {
		return strategyId;
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
	 * @param strategyId the strategyId to set
	 */
	public void setStrategyId(long strategyId) {
		this.strategyId = strategyId;
	}
	/**
	 * @return the complimentReal
	 */
	public double getComplimentReal() {
		return complimentReal;
	}
	/**
	 * @param complimentReal the complimentReal to set
	 */
	public void setComplimentReal(double complimentReal) {
		this.complimentReal = complimentReal;
	}
	/**
	 * @return the complimentExpected
	 */
	public double getComplimentExpected() {
		return complimentExpected;
	}
	/**
	 * @param complimentExpected the complimentExpected to set
	 */
	public void setComplimentExpected(double complimentExpected) {
		this.complimentExpected = complimentExpected;
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
	 * @return the trend
	 */
	public MetricTrendType getTrend() {
		return trend;
	}
	/**
	 * @param trend the trend to set
	 */
	public void setTrend(MetricTrendType trend) {
		this.trend = trend;
	}
	/**
	 * @return the unitValue
	 */
	public String getUnitValue() {
		return unitValue;
	}
	/**
	 * @param unitValue the unitValue to set
	 */
	public void setUnitValue(String unitValue) {
		this.unitValue = unitValue;
	}
	/**
	 * @return the unitValueSymbol
	 */
	public String getUnitValueSymbol() {
		return unitValueSymbol;
	}
	/**
	 * @param unitValueSymbol the unitValueSymbol to set
	 */
	public void setUnitValueSymbol(String unitValueSymbol) {
		this.unitValueSymbol = unitValueSymbol;
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
	 * @return the goalName
	 */
	public String getGoalName() {
		return goalName;
	}
	/**
	 * @param goalName the goalName to set
	 */
	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}
	/**
	 * @return the goalDescription
	 */
	public String getGoalDescription() {
		return goalDescription;
	}
	/**
	 * @param goalDescription the goalDescription to set
	 */
	public void setGoalDescription(String goalDescription) {
		this.goalDescription = goalDescription;
	}
	/**
	 * @return the parentContributeWeight
	 */
	public double getParentContributeWeight() {
		return parentContributeWeight;
	}
	/**
	 * @param parentContributeWeight the parentContributeWeight to set
	 */
	public void setParentContributeWeight(double parentContributeWeight) {
		this.parentContributeWeight = parentContributeWeight;
	}
	/**
	 * @return the valueAsDate
	 */
	public boolean isValueAsDate() {
		return valueAsDate;
	}
	/**
	 * @param valueAsDate the valueAsDate to set
	 */
	public void setValueAsDate(boolean valueAsDate) {
		this.valueAsDate = valueAsDate;
	}
	/**
	 * @return the generalFormulaType
	 */
	public TrackingGeneralFormulaType getGeneralFormulaType() {
		return generalFormulaType;
	}
	/**
	 * @param generalFormulaType the generalFormulaType to set
	 */
	public void setGeneralFormulaType(TrackingGeneralFormulaType generalFormulaType) {
		this.generalFormulaType = generalFormulaType;
	}
	/**
	 * @return the personalWeight
	 */
	public double getPersonalWeight() {
		return personalWeight;
	}
	/**
	 * @param personalWeight the personalWeight to set
	 */
	public void setPersonalWeight(double personalWeight) {
		this.personalWeight = personalWeight;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
