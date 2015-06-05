//=======================================================================
// ARCHIVO KpiMetricGeneralDTO.java
// FECHA CREACIÓN: 2012/08/15
//=======================================================================
package co.zero.kpi.dto;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import co.zero.common.enumeration.PeriodicType;
import co.zero.common.enumeration.SemaphoreLevelType;
import co.zero.common.enumeration.kpi.TrackingGeneralFormulaType;
import co.zero.common.enumeration.kpi.TrackingPartialTotalFormulaType;
import co.zero.common.exception.ZeroException;
import co.zero.common.validator.GenericValidator;
import co.zero.hcm.dto.EmploymentDTO;
import co.zero.hcm.exception.HcmException;

/**
 * Clase que define la métrica general que se debe cumplir al finalizar el periodo para el objetivo asociado
 * @author Hernán Tenjo
 * @version 1.0
 */
public class KpiMetricGeneralDTO extends KpiMetricDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	// Evaluación a la que pertenece la métrica
	private KpiEvaluationDTO evaluation;
	// Employment dueño de la métrica
	private EmploymentDTO owner;
	// Fecha de inicio de vigencia de la métrica
	private Date startDate;
	// Fecha de finalización de la vigencia de la métrica
	private Date endDate;
	//Determina si la métrica presenta evaluaciones periódicas
	private boolean periodic;
	//Determina si el total acumulado es la suma de los valores parciales
	//o si es un valor que debe ser ingresado en el momento de la evaluación
	private boolean totalCalculated;
	//La periodicidad de la métrica (Esto permite determinar la cantidad de métricas parciales que se deben generar)
	private PeriodicType periodicity;
	//Define la forma de totalizar los valores parciales, en caso de que la métrica requiera el total calculado
	private TrackingPartialTotalFormulaType partialFormulaType;
	//Atributo que determina si el valor del objetivo será asignado directamente o calculado  
	private TrackingGeneralFormulaType generalFormulaType;
	//Código que permitirá relacionar la métrica con otras entidades en los cargadores masivos
	private String code;
	//Atributo que determina si el valor esperado será calculado con base en la métricas parciales
	private boolean expectedValueCalculated;

	/**
	 * Método que obtiene la evaluación a la que pertenece la métrica
	 * @return La evaluación asociada a la métrica
	 */
	public KpiEvaluationDTO getEvaluation() {
		return evaluation;
	}

	/**
	 * Método que modifica la evaluación a la que pertenece la métrica
	 * @param evaluation La nueva evaluación a la que pertenece la métrica
	 */
	public void setEvaluation(KpiEvaluationDTO evaluation) {
		this.evaluation = evaluation;
	}

	/**
	 * Método que obtiene el {@link Employment} dueño de la métrica
	 * @return El puesto de trabajo que creó la métrica
	 */
	public EmploymentDTO getOwner() {
		return owner;
	}

	/**
	 * Método que modifica el {@link Employment} dueño de la métrica
	 * @param owner El nuevo propietario de la métrica
	 */
	public void setOwner(EmploymentDTO owner) {
		this.owner = owner;
	}

	/**
	 * Metodo que permite obtener la fecha de inicio de la vigencia de la métrica
	 * @return La fecha de inicio de la vigencia de la métrica
	 */
	public Date getStartDate() {
		return startDate;
	}
	
	/**
	 * Método que obtiene el código de la métrica, que aunque no es requerido, 
	 * si se encuentra deberá ser único por evaluación
	 * @return El código con el que se identificará a la métrica
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Método que modifica el código de la métrica
	 * @param code El nuevo código con el que se identificará la métrica en una evaluación
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Metodo que permite modificar la fecha de inicio de la vigencia de la métrica
	 * @param startDate La nueva fecha de inicio de la vigencia de la métrica
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Metodo que permite obtener la fecha de finalización de la vigencia de la métrica
	 * @return La fecha de finalización de la vigencia de la métrica
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Metodo que permite modificar la fecha de finalización de la vigencia de la métrica
	 * @param endDate La nueva fecha de finalización de la vigencia de la métrica
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * Método que permite determinar si la métrica presenta periodicidad
	 * @return True si la métrica presenta periodicidad
	 */
	public boolean isPeriodic() {
		return periodic;
	}

	/**
	 * Método que permite modificar la condición de periodicidad de la métrica
	 * @param periodic True si se desea que la métrica presente periodicidad,
	 * false de lo contrario
	 */
	public void setPeriodic(boolean periodic) {
		if(periodic){
			this.periodic = true;
		}else{
			this.periodic = false;
			this.totalCalculated = false;
			this.periodicity = null;
			this.partialFormulaType = null;		
		}
	}

	/**
	 * Método que permite obtener la periodicidad de la métrica
	 * @return La periodicidad de la métrica
	 */
	public PeriodicType getPeriodicity() {
		return periodicity;
	}

	/**
	 * Método que permite modificar la periodicidad de la métrica
	 * @param period La nueva periodicidad de la métrica
	 */
	public void setPeriodicity(PeriodicType period) {
		this.periodicity = period;
	}
	
	/**
	 * Método que permite determinar en caso ser una métrica periódica
	 * si el valor total acumulado es la suma de los valores parciales, o
	 * si se debe ingresar en el momento de la evaluación 
	 * @return True si el valor total es la suma de los valores parciales reales,
	 * false si se desea obtener el valor del usuario evaluador
	 */
	public boolean isTotalCalculated() {
		return totalCalculated;
	}

	/**
	 * Método que permite modificar la manera de calcular el valor total acumulado
	 * @param totalCalculated true si se desea que el valor total sea la suma
	 * de los valores parciales, false si se desea que el total sea un valor ingresado
	 */
	public void setTotalCalculated(boolean totalCalculated) {
		if(totalCalculated){
			this.totalCalculated = true;			
		}else{
			this.totalCalculated = false;
			this.partialFormulaType = null;
		}
	}
	
	/**
	 * Método que determina si el valor esperado del indicador debe ser calculado con
	 * base el los valores esperados de cada periodo
	 * @return True si el valor esperado va a ser calculado, false de lo contrario
	 */
	public boolean isExpectedValueCalculated() {
		return expectedValueCalculated;
	}

	/**
	 * Método que modifica el hecho de calcular el valor esperado del indicador
	 * @param expectedValueCalculated True si se desea calcular el valor esperado del indicador
	 * false de lo contrario
	 */
	public void setExpectedValueCalculated(boolean expectedValueCalculated) {
		this.expectedValueCalculated = expectedValueCalculated;
	}

	/**
	 * Método que permite obtener la forma de totalizar los valores parciales de la métrica
	 * @return La forma en la que se totalizarán los valores parciales
	 */
	public TrackingPartialTotalFormulaType getPartialFormulaType() {
		return partialFormulaType;
	}

	/**
	 * Método que permite modificar la forma de totalizar los valores parciales de la métrica
	 * @param partialFormulaType La nueva forma de totalizar los valores parciales de la métrica
	 */
	public void setPartialFormulaType(TrackingPartialTotalFormulaType partialFormulaType) {
		this.partialFormulaType = partialFormulaType;
	}
	
	/**
	 * Método que permite obtener la forma de calcular el valor final del indicador
	 * @return La forma de calcular el valor final del indicador:
	 * - CALCULATED_FROM_CHILDREN: El valor final será la suma de los resultados de los hijos directos 
	 * - ASSIGNED_BY_PARTIALS: El valor final será una operación sobre los resultados parciales
	 * - ASSIGNED_DIRECTLY: El valor final será dado por el usuario de forma arbitraria.
	 */
	public TrackingGeneralFormulaType getGeneralFormulaType() {
		return generalFormulaType;
	}

	/**
	 * Método que modifica la forma de calcular el valor final del indicador
	 * @param assignedValueType Valor de enumaración que determinará la forma de calcular el valor final
	 */
	public void setGeneralFormulaType(TrackingGeneralFormulaType trackingGeneralFormulaType) {
		this.generalFormulaType = trackingGeneralFormulaType;
	}
	
	/**
	 * Metodo que permite obtener el semáforo correspondiente al valor de desempeño dado
	 * @param realValue Valor numérico que se desea verificar
	 * @param realDateValue Valor de tipo fecha que se desea verificar 
	 * @return El nivel del semaforo detectado (Se utilizará el valor correspondiente al tipo 
	 * de dato manejado por la métrica, para realizar el análisis)
	 * @throws ZeroException 
	 */
	public SemaphoreLevelType findSemaphoreLevelTypeForValue(double realValue, Date realDateValue) throws ZeroException{
		GenericValidator.validateCollection(KpiMetricValueDTO.class, getValues(), 1);
		double percent;
		
		if(isContinuous()){
			if(isProportionalDirectly()){
				percent = getLevelPercentFromDirectlyProportionalContinuousMetric(realValue, realDateValue);
			}else{
				percent = getLevelPercentFromInverselyProportionalContinuousMetric(realValue, realDateValue);
			}
		}else{
			percent = isValueAsDate() ? findSemaphorePercentForDiscreteValue(realDateValue) : findSemaphorePercentForDiscreteValue(realValue);
		}
		
		return findSemaphoreLevelTypeForPercent(percent);
	}
	
	/**
	 * Método que permite determinar si los valores de la métrica son directa o inversamente 
	 * proporcionales con los porcentajes de cumplimiento
	 * @return True si los valores son proporcionales, false de lo contrario
	 * @throws ZeroException Si no se tiene por lo menos un valor de comparación
	 */
	private boolean isProportionalDirectly() throws ZeroException{
		KpiMetricValueDTO firstElement, lastElement;
		boolean proportionalDirectly = true;
		
		if(getValues() != null && getValues().size() > 0){
			Collections.sort(getValues(), new MetricValueContinuosComparator());
			firstElement = getValues().get(0);
			lastElement = getValues().get(getValues().size() - 1);
			
			proportionalDirectly = isValueAsDate() ? firstElement.getHighDateValueAsDays() <= lastElement.getHighDateValueAsDays() 
					: firstElement.getHighValue() <= lastElement.getHighValue();
		}else{
			GenericValidator.validateCollection(KpiMetricValueDTO.class, getValues(), 1);
		}
		
		return proportionalDirectly;
	}
	
	/**
	 * Clase que permite definir un comparador exclusivo para un {@link KpiMetricValueDTO}
	 */
	private class MetricValueContinuosComparator implements Comparator<KpiMetricValueDTO>{
		@Override
		public int compare(KpiMetricValueDTO value1, KpiMetricValueDTO value2) {
			if(value1.getComplimentPercent() < value2.getComplimentPercent()){
				return -1;
			}else if(value1.getComplimentPercent() > value2.getComplimentPercent()){
				return 1;
			}else{
				return 0;
			}
		}
	}
	
	/**
	 * Método que permite calcular el valor del porcentaje alcanzado por un valor en una 
	 * métrica continua que presenta valores directamente proporcionales con los porcentajes de cumplimientodo
	 * @param realValue El valor numérico que se desea analizar, para obtener el porcentaje alcanzado
	 * @param realDateValue El valor de tipo fecha que se desea analizar, para obtener 
	 * el porcentaje alcanzado
	 * @return El porcentaje continuo alcanzado por el valor real analizado
	 * @throws ZeroException 
	 */
	private double getLevelPercentFromDirectlyProportionalContinuousMetric(double realValue, Date realDateValue) throws ZeroException{
		GenericValidator.validateCollection(KpiMetricValueDTO.class, getValues(), 1);
		KpiMetricValueDTO lowerValue = getValues().get(0);
		KpiMetricValueDTO higherValue = getValues().get(getValues().size() - 1);
		
		if(isValueAsDate()){
			Calendar realDate = Calendar.getInstance();
			realDate.setTime(realDateValue);
			int realDays = realDate.get(Calendar.DAY_OF_YEAR);
			int lowDays = lowerValue.getHighDateValueAsDays();
			int highDays = higherValue.getHighDateValueAsDays();
			
			if(realDays <= lowDays){
				//Si el valor real no alcanza ni siquiera el valor mínimo, se asigna el porcentaje mínimo
				return lowerValue.getComplimentPercent();
			}else if(realDays >= highDays){
				//Si el valor rela sobrepasa el valor máximo, se asigna el porcentaje máximo de la métrica
				return higherValue.getComplimentPercent();
			}else{
				//Si el valor está en los rangos de la métrica, se calcula el porcentaje alcanzado
				return findRealContinuousPercent(true, realDays);
			}
		}else{
			if(realValue <= lowerValue.getHighValue()){
			//Si el valor real no alcanza ni siquiera el valor mínimo, se asigna el porcentaje mínimo 
				return lowerValue.getComplimentPercent();
			}else if(realValue >= higherValue.getHighValue()){
			//Si el valor rela sobrepasa el valor máximo, se asigna el porcentaje máximo de la métrica	
				return higherValue.getComplimentPercent();
			}else{
			//Si el valor está en los rangos de la métrica, se calcula el porcentaje alcanzado
				return findRealContinuousPercent(true, realValue);
			}
		}
	}
	
	/**
	 * Método que permite determinar el valor del porcentaje de cumplimiento en una distribución lineal de valores
	 * @param directlyProportional Determina si la relación entre los valores y los porcentajes de cumplimiento
	 * es directa o inversamente proporcional
	 * @param value El valor real alcanzado, del que se desea conocer el porcentaje real de cumplimiento
	 * @return El porcentaje real de cumplimiento, logrado por el valor real dado
	 * @throws ZeroException Si los valores de la métrica son inconsistentes y no se puede encontrar el 
	 * rango que permita general la ecuación que permite encontrar el valor buscado
	 */
	private double findRealContinuousPercent(boolean directlyProportional, double value) throws ZeroException{
		int indexP1 = -1, indexP2;
		KpiMetricValueDTO point1, point2;
		
		if(directlyProportional){
			for(int i=0; i < getValues().size(); i++){
				if(value <= getValues().get(i).getHighValueAsDouble() ){
					indexP1 = i;
					break;
				}
			}
		}else{
			for(int i=0; i < getValues().size(); i++){
				if(value >= getValues().get(i).getHighValueAsDouble()){
					indexP1 = i;
					break;
				}
			}
		}
		
		if(indexP1 > 0){
			indexP2 = indexP1 - 1;	
			point1 = getValues().get(indexP1);
			point2 = getValues().get(indexP2);
			return calculateRealContinuousPercent(point1.getHighValueAsDouble(), point1.getComplimentPercent(), 
					point2.getHighValueAsDouble(), point2.getComplimentPercent(), value);
		}else{
			throw new HcmException(HcmException.COLLECTION_INVALID);
		}
	}
	
	/**
	 * Método que permite calcular el porcentaje de cumplimiento dado el valor real alcanzado,
	 * basándose en que los valores del rango se distribuyen de forma lineal. Por lo anterior si tenemos
	 * P1(x1, y1), P2(x2, y2) y dado un valor x3 podremos calcular el valor y3 por medio de la ecuación
	 * de un recta.
	 * @param x1 Valor real esperado para el punto 1 de la recta
	 * @param y1 Porcentaje de cumplimiento para el punto 1 de la recta
	 * @param x2 Valor real esperado para el punto 2 de la recta
	 * @param y2 Porcentaje de cumplimiento para el punto 2 de la recta
	 * @param x3 Valor real alcanzado por el cliente
	 * @return Porcentaje real alcanzado por el cliente sobre una distribución lineal de valores
	 */
	private double calculateRealContinuousPercent(double x1, double y1, double x2, double y2, double x3){
		//1. Se calcula la pendiente de la recta
		double gradient = (y2 - y1) / (x2 - x1);
		//2. Se calcula el intercepto de la recta tomando como referencia al punto 1
		double intercept = y1 - (gradient * x1);
		//3. Se calcula el valor de y3 correspondiente al porcentaje de cumplimiento del punto x3
		return (gradient * x3) + intercept; 
	}
	
	/**
	 * Método que permite calcular el valor del porcentaje alcanzado por un valor en una 
	 * métrica continua que presenta valores inversamente proporcionales con los porcentajes de cumplimientodo
	 * @param realValue El valor numérico que se desea analizar, para obtener el porcentaje alcanzado
	 * @param realDateValue El valor de tipo fecha que se desea analizar, para obtener 
	 * el porcentaje alcanzado
	 * @return El porcentaje continuo alcanzado por el valor real analizado
	 * @throws ZeroException 
	 */
	private double getLevelPercentFromInverselyProportionalContinuousMetric(double realValue, Date realDateValue) throws ZeroException{
		GenericValidator.validateCollection(KpiMetricValueDTO.class, getValues(), 1);
		KpiMetricValueDTO lowerValue = getValues().get(0);
		KpiMetricValueDTO higherValue = getValues().get(getValues().size() - 1);
		
		if(isValueAsDate()){
			Calendar realDate = Calendar.getInstance();
			realDate.setTime(realDateValue);
			int realDays = realDate.get(Calendar.DAY_OF_YEAR);
			int lowDays = lowerValue.getHighDateValueAsDays();
			int highDays = higherValue.getHighDateValueAsDays();
			
			if(realDays >= lowDays){
				//Si el valor real no alcanza ni siquiera el valor mínimo, se asigna el porcentaje mínimo
				return lowerValue.getComplimentPercent();
			}else if(realDays <= highDays){
				//Si el valor rela sobrepasa el valor máximo, se asigna el porcentaje máximo de la métrica
				return higherValue.getComplimentPercent();
			}else{
				//Si el valor está en los rangos de la métrica, se calcula el porcentaje alcanzado
				return findRealContinuousPercent(false, realDays);
			}
		}else{
			if(realValue >= lowerValue.getHighValue()){
			//Si el valor real no alcanza ni siquiera el valor mínimo, se asigna el porcentaje mínimo 
				return lowerValue.getComplimentPercent();
			}else if(realValue <= higherValue.getHighValue()){
			//Si el valor rela sobrepasa el valor máximo, se asigna el porcentaje máximo de la métrica	
				return higherValue.getComplimentPercent();
			}else{
			//Si el valor está en los rangos de la métrica, se calcula el porcentaje alcanzado
				return findRealContinuousPercent(false, realValue);
			}
		}
	}

	/**
	 * Metodo que permite obtener el valor del porcentaje del semáfono
	 * del MetricValue al que pertenece el valor
	 * @param value Valor de tipo numérico que se desea analizar
	 * @return El valor del semáforo si el valor pertenece a algún 
	 * MetricValue, 0 en cualquier otro caso
	 */
	private double findSemaphorePercentForDiscreteValue(double value){
		if(getValues() != null){
			for(KpiMetricValueDTO metricValue : getValues()){
				if(metricValue.isExpectedValue() && metricValue.rangeContainDiscreteValue(value)){
					return metricValue.getComplimentPercent();
				}
			}
			
			for(KpiMetricValueDTO metricValue : getValues()){
				if(metricValue.rangeContainDiscreteValue(value)){
					return metricValue.getComplimentPercent();
				}
			}
		}
		
		return 0;
	}
	
	/**
	 * Metodo que permite obtener el valor del porcentaje del semáfono
	 * del MetricValue al que pertenece el valor
	 * @param value Valor de tipo fecha que se desea analizar
	 * @return El valor del semáforo si el valor pertenece a algún 
	 * MetricValue, 0 en cualquier otro caso
	 */
	private double findSemaphorePercentForDiscreteValue(Date value){
		if(getValues() != null){
			for(KpiMetricValueDTO metricValue : getValues()){
				if(metricValue.rangeContainDiscreteValue(value)){
					return metricValue.getComplimentPercent();
				}
			}
		}
		
		return 0;
	}
	
	/**
	 * Metodo que permite obtener el semáforo correspondiente al porcentaje de desempeño
	 * @param percent Valor que se desea verificar 
	 * @return El nivel del semaforo detectado
	 */
	public SemaphoreLevelType findSemaphoreLevelTypeForPercent(double percent){
		KpiMetricValueComplimentDTO lowerCompliment = null, higherCompliment = null;
		
		if(isContinuous()){
			for(KpiMetricValueComplimentDTO complimentValue : getComplimentValues()){
				lowerCompliment = lowerCompliment == null ? complimentValue : lowerCompliment;
				higherCompliment = higherCompliment == null ? complimentValue : higherCompliment;
				lowerCompliment = lowerCompliment.getLowPercent() > complimentValue.getLowPercent() ? complimentValue : lowerCompliment;
				higherCompliment = higherCompliment.getHighPercent() < complimentValue.getLowPercent() ? complimentValue : higherCompliment;
				
				if(complimentValue.getLowPercent() <= percent && percent <= complimentValue.getHighPercent()){
					return complimentValue.getComplimentLevel();
				}
			}
			
			if (lowerCompliment != null && percent < lowerCompliment.getLowPercent()){
				return lowerCompliment.getComplimentLevel();
			}else if(higherCompliment != null && percent > higherCompliment.getHighPercent()){
				return higherCompliment.getComplimentLevel();
			}
		}else{
			for(KpiMetricValueDTO metricValue : getValues()){
				if(metricValue.getComplimentPercent() == percent && metricValue.getComplimentLevel() != null){
					return metricValue.getComplimentLevel();
				}
			}
		}
		
		//TODO: Acá se prodría generar mejor una excepción que indique la inconsistencia de la métrica
		return SemaphoreLevelType.RED_LIGHT;
	}
	
	/**
	 * Metodo que permite obtener el semáforo correspondiente al valor de desempeño dado
	 * @param realValue Valor numérico que se desea verificar
	 * @param realDateValue Valor de tipo fecha que se desea verificar 
	 * @return El nivel del semaforo detectado (Se utilizará el valor correspondiente al tipo 
	 * de dato manejado por la métrica, para realizar el análisis)
	 * @throws ZeroException 
	 */
	public double findSemaphorePercentForValue(double realValue, Date realDateValue) throws ZeroException{
		GenericValidator.validateCollection(KpiMetricValueDTO.class, getValues(), 1);
		
		if(isContinuous()){
			if(isProportionalDirectly()){
				return getLevelPercentFromDirectlyProportionalContinuousMetric(realValue, realDateValue);
			}else{
				return getLevelPercentFromInverselyProportionalContinuousMetric(realValue, realDateValue);
			}
		}else{
			return isValueAsDate() ? findSemaphorePercentForDiscreteValue(realDateValue)
					: findSemaphorePercentForDiscreteValue(realValue);
		}
	}
	
}
