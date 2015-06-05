//=======================================================================
// ARCHIVO KpiMetricPartialDTO.java
// FECHA CREACIÓN: 2012/08/15
//=======================================================================
package co.zero.kpi.dto;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import co.zero.common.enumeration.SemaphoreLevelType;
import co.zero.common.exception.ZeroException;
import co.zero.common.validator.GenericValidator;
import co.zero.hcm.exception.HcmException;

/**
 * Clase que permite establecer las pautas para evaluar el desempeño de un objetivo con respecto a una meta dada
 * @author Hernán Tenjo
 * @version 1.0
 */
public class KpiMetricPartialDTO extends KpiMetricDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Periodo que evaluará la métrica parcial
	private KpiMetricPeriodDTO period;
	//Valor que se esperaría tener acumulado durante el periodo de esta métrica
	private double expectedAccumulatedValue;
	
	/**
	 * Metodo que permite obtener el periodo que evaluará la métrica parcial
	 * @return El periodo a evaluar por la metrica parcial
	 */
	public KpiMetricPeriodDTO getPeriod() {
		return period;
	}

	/**
	 * Metodo que permite modificar el periodo que evaluará la métrica
	 * @param period El nuevo periodo a evaluar por la metrica parcial
	 */
	public void setPeriod(KpiMetricPeriodDTO period) {
		this.period = period;
	}
	
	/**
	 * Método que permite obtener el valor esperado para el accumulado del periodo
	 * @return La meta para el valor acumulado en el periodo
	 */
	public double getExpectedAccumulatedValue() {
		return expectedAccumulatedValue;
	}

	/**
	 * Método que permite modificar el valor esperado para ela acumulado del periodo
	 * @param expectedAccumulatedValue La nueva meta para el valor acumulado 
	 */
	public void setExpectedAccumulatedValue(double expectedAccumulatedValue) {
		this.expectedAccumulatedValue = expectedAccumulatedValue;
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
			return isValueAsDate() ? findSemaphorePercentForDiscreteValue(realDateValue) : findSemaphorePercentForDiscreteValue(realValue);
		}
	}
	
	/**
	 * Método que permite determinar si los valores de la métrica son directa o inversamente 
	 * proporcionales con los porcentajes de cumplimiento
	 * @return True si los valores son proporcionales, false de lo contrario
	 * @throws ZeroException Si no se tiene por lo menos un valor de comparación
	 */
	public boolean isProportionalDirectly() throws ZeroException{
		KpiMetricValueDTO firstElement, lastElement;
		boolean proportionalDirectly = true;
		
		if(getValues() != null && getValues().size() > 0){
			Collections.sort(getValues(), new MetricValuePartialContinuosComparator());
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
	private class MetricValuePartialContinuosComparator implements Comparator<KpiMetricValueDTO>{
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
	private double getLevelPercentFromDirectlyProportionalContinuousMetric(double realValue, Date realDateValue) throws ZeroException {
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
				//Si el valor real sobrepasa el valor máximo, se asigna el porcentaje máximo de la métrica
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
	private double getLevelPercentFromInverselyProportionalContinuousMetric(double realValue, Date realDateValue) throws ZeroException {
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
	 * Metodo que permite obtener el semáforo correspondiente al valor de desempeño dado
	 * 
	 * @param realValue Valor numérico que se desea verificar
	 * @param realDateValue Valor de tipo fecha que se desea verificar 
	 * @return El nivel del semaforo detectado (Se utilizará el valor correspondiente al tipo 
	 * de dato manejado por la métrica, para realizar el análisis)
	 * @throws ZeroException 
	 */
	public SemaphoreLevelType findSemaphoreLevelTypeForValue(double realValue, Date realDateValue) throws ZeroException{
		GenericValidator.validateCollection(KpiMetricValueDTO.class, getValues(), 1);
		KpiMetricValueComplimentDTO lowerCompliment = null, higherCompliment = null;
		double percent;
		
		if(isContinuous()){
			if(isProportionalDirectly()){
				percent = getLevelPercentFromDirectlyProportionalContinuousMetric(realValue, realDateValue);
			}else{
				percent = getLevelPercentFromInverselyProportionalContinuousMetric(realValue, realDateValue);
			}
			
			for(KpiMetricValueComplimentDTO complimentValue : getComplimentValues()){
				lowerCompliment = lowerCompliment == null ? complimentValue : lowerCompliment;
				higherCompliment = higherCompliment == null ? complimentValue : higherCompliment;
				lowerCompliment = lowerCompliment.getLowPercent() > complimentValue.getLowPercent() ? complimentValue : lowerCompliment;
				higherCompliment = higherCompliment.getHighPercent() < complimentValue.getLowPercent() ? complimentValue : higherCompliment;
				
				if(complimentValue.getLowPercent() <= percent && percent <= complimentValue.getHighPercent()){
					return complimentValue.getComplimentLevel();
				}
			}
			
			if (percent < lowerCompliment.getLowPercent()){
				return lowerCompliment.getComplimentLevel();
			}else if(percent > higherCompliment.getHighPercent()){
				return higherCompliment.getComplimentLevel();
			}
		}else{
			percent = isValueAsDate() ? findSemaphorePercentForDiscreteValue(realDateValue)
					: findSemaphorePercentForDiscreteValue(realValue);
			
			for(KpiMetricValueDTO metricValue : getValues()){
				if(metricValue.getComplimentPercent() == percent && metricValue.getComplimentLevel() != null){
					return metricValue.getComplimentLevel();
				}
			}
		}
		
		//TODO: Acá se prodría generar mejor una excepción que indique la inconsistencia de la métrica
		return SemaphoreLevelType.RED_LIGHT;
	}
	
}