//=======================================================================
// ARCHIVO BscMetricPartialDTO.java
// FECHA CREACIÓN: 6/07/2011
//=======================================================================
package co.zero.bsc.dto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.SemaphoreLevelType;
import co.zero.common.exception.ZeroException;
import co.zero.common.validator.GenericValidator;
import co.zero.hcm.exception.HcmException;

/**
 * Clase que define las métricas parciales que se pueden establecer con 
 * @author Hernán Tenjo
 * @version 1.0
 */
public class BscMetricPartialDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	
	//Nombre que representa a la métrica parcial
	private String name;
	//Breve descripción del propósito de la métrica parcial
	private String description;
	//Valor que determina si los porcentajes de cumplimiento serán
	//continuos o discretos (Continuos por defecto)
	private boolean continuous = true;
	//Periodo que evaluará la métrica parcial
	private BscMetricPeriodDTO period;
	//Este atributo determina si el valor esperado es de tipo Fecha o de Tipo Numérico
	private boolean expectedDate;
	//Label que identifica las unidades en las que se expresan los valores de la métrica
	private String unitValue;
	//Label que contiene el símbolo corto que representa a las unidades de los valores de la métrica
	private String unitValueSymbol;
	//Valor que se esperaria tener acumulado durante el periodo de esta métrica
	private double expectedAccumulatedValue;
	//Valores asociados a la métrica parcial
	private List<BscMetricValuePartialDTO> values = new ArrayList<BscMetricValuePartialDTO>();
	//Valores de cumplimiento requeridos cuando la métrica es continua
	private List<BscMetricValuePartialComplimentDTO> complimentValues = new ArrayList<BscMetricValuePartialComplimentDTO>();
	
	/**
	 * Metodo que permite agregar un valor a la lista de valores relacionados a la métrica
	 * @param value Nuevo valor que se desea agregar
	 */
	public void addValue(BscMetricValuePartialDTO value){
		if(values == null){
			values = new ArrayList<BscMetricValuePartialDTO>();
		}
		
		value.setMetric(this);
		values.add(value);
	}
	
	/**
	 * Método que permite agregar una valor a la lista de valores de cumplimiento de la métrica
	 * @param value Nuevo valor que se desea agregar
	 */
	public void addComplimentValue(BscMetricValuePartialComplimentDTO value){
		if(complimentValues == null){
			complimentValues = new ArrayList<BscMetricValuePartialComplimentDTO>();
		}
		
		value.setMetric(this);
		complimentValues.add(value);
	}
	
	public double getExpectedRealValue(){
		for(BscMetricValuePartialDTO value : values){
			if(value.isExpectedValue()){
				return value.getHighValue();
			}
		}
		
		return 0;
	}
	
	public Date getExpectedRealDateValue(){
		for(BscMetricValuePartialDTO value : values){
			if(value.isExpectedValue()){
				return value.getHighDateValue();
			}
		}
		
		return null;
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
		GenericValidator.validateCollection(BscMetricValuePartialDTO.class, values, 1);
		
		if(continuous){
			if(isProportionalDirectly()){
				return getLevelPercentFromDirectlyProportionalContinuousMetric(realValue, realDateValue);
			}else{
				return getLevelPercentFromInverselyProportionalContinuousMetric(realValue, realDateValue);
			}
		}else{
			return expectedDate ? findSemaphorePercentForDiscreteValue(realDateValue)
					: findSemaphorePercentForDiscreteValue(realValue);
		}
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
		GenericValidator.validateCollection(BscMetricValuePartialDTO.class, values, 1);
		BscMetricValuePartialComplimentDTO lowerCompliment = null, higherCompliment = null;
		double percent;
		
		if(continuous){
			if(isProportionalDirectly()){
				percent = getLevelPercentFromDirectlyProportionalContinuousMetric(realValue, realDateValue);
			}else{
				percent = getLevelPercentFromInverselyProportionalContinuousMetric(realValue, realDateValue);
			}
			
			for(BscMetricValuePartialComplimentDTO complimentValue : complimentValues){
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
			percent = expectedDate ? findSemaphorePercentForDiscreteValue(realDateValue)
					: findSemaphorePercentForDiscreteValue(realValue);
			
			for(BscMetricValuePartialDTO metricValue : values){
				if(metricValue.getComplimentPercent() == percent){
					return metricValue.getComplimentLevel();
				}
			}
		}
		
		//TODO: Acá se prodría generar mejor una excepción que indique la inconsistencia de la métrica
		return SemaphoreLevelType.RED_LIGHT;
	}
	
	/**
	 * Método que permite determinar si los valores de la métrica son directa o inversamente 
	 * proporcionales con los porcentajes de cumplimiento
	 * @return True si los valores son proporcionales, false de lo contrario
	 * @throws ZeroException Si no se tiene por lo menos un valor de comparación
	 */
	public boolean isProportionalDirectly() throws ZeroException{
		BscMetricValuePartialDTO firstElement, lastElement;
		boolean proportionalDirectly = true;
		
		if(values != null && values.size() > 0){
			Collections.sort(values, new MetricValuePartialContinuosComparator());
			firstElement = values.get(0);
			lastElement = values.get(values.size() - 1);
			
			proportionalDirectly = expectedDate ? firstElement.getHighDateValueAsDays() <= 
				lastElement.getHighDateValueAsDays() : firstElement.getHighValue() <= lastElement.getHighValue();
		}else{
			GenericValidator.validateCollection(BscMetricValuePartialDTO.class, values, 1);
		}
		
		return proportionalDirectly;
	}
	
	/**
	 * Metodo que permite obtener el valor del porcentaje del semáfono
	 * del MetricValue al que pertenece el valor
	 * @param value Valor de tipo numérico que se desea analizar
	 * @return El valor del semáforo si el valor pertenece a algún 
	 * MetricValue, 0 en cualquier otro caso
	 */
	private double findSemaphorePercentForDiscreteValue(double value){
		if(values != null){
			for(BscMetricValuePartialDTO metricValue : values){
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
		if(values != null){
			for(BscMetricValuePartialDTO metricValue : values){
				if(metricValue.rangeContainDiscreteValue(value)){
					return metricValue.getComplimentPercent();
				}
			}
		}
		
		return 0;
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
	private double getLevelPercentFromDirectlyProportionalContinuousMetric(
			double realValue, Date realDateValue) throws ZeroException{
		GenericValidator.validateCollection(BscMetricValuePartialDTO.class, values, 1);
		BscMetricValuePartialDTO lowerValue = values.get(0);
		BscMetricValuePartialDTO higherValue = values.get(values.size() - 1);
		
		if(expectedDate){
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
	 * Método que permite calcular el valor del porcentaje alcanzado por un valor en una 
	 * métrica continua que presenta valores inversamente proporcionales con los porcentajes de cumplimientodo
	 * @param realValue El valor numérico que se desea analizar, para obtener el porcentaje alcanzado
	 * @param realDateValue El valor de tipo fecha que se desea analizar, para obtener 
	 * el porcentaje alcanzado
	 * @return El porcentaje continuo alcanzado por el valor real analizado
	 * @throws ZeroException 
	 */
	private double getLevelPercentFromInverselyProportionalContinuousMetric(
			double realValue, Date realDateValue) throws ZeroException{
		GenericValidator.validateCollection(BscMetricValuePartialDTO.class, values, 1);
		BscMetricValuePartialDTO lowerValue = values.get(0);
		BscMetricValuePartialDTO higherValue = values.get(values.size() - 1);
		
		if(expectedDate){
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
		BscMetricValuePartialDTO point1, point2;
		
		if(directlyProportional){
			for(int i=0; i < values.size(); i++){
				if(value <= values.get(i).getHighValueAsDouble() ){
					indexP1 = i;
					break;
				}
			}
		}else{
			for(int i=0; i < values.size(); i++){
				if(value >= values.get(i).getHighValueAsDouble()){
					indexP1 = i;
					break;
				}
			}
		}
		
		if(indexP1 > 0){
			indexP2 = indexP1 - 1;	
			point1 = values.get(indexP1);
			point2 = values.get(indexP2);
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
	
	//========================== Métodos Get/Set del POJO ================================
	/**
	 * Metodo que permite obtener el nombre de la metrica 
	 * @return El nombre asociado a la metrica
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo que permite modificar el nombre de la metrica
	 * @param name El nuevo nombre de la metrica
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Metodo que permite obtener la descripción de la metrica
	 * @return La descripción de la metrica
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Metodo que permite modificar la descripcion de la metrica
	 * @param description La nueva descripcion que será asociada a la metrica
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Metodo que permite obtener la lista de valores de la métrica
	 * @return La lista de valores de la métrica
	 */
	public List<BscMetricValuePartialDTO> getValues() {
		return values;
	}
	
	/**
	 * Metodo que permite obtener el periodo que evaluará la métrica parcial
	 * @return El periodo a evaluar por la metrica parcial
	 */
	public BscMetricPeriodDTO getPeriod() {
		return period;
	}

	/**
	 * Metodo que permite modificar el periodo que evaluará la métrica
	 * @param period El nuevo periodo a evaluar por la metrica parcial
	 */
	public void setPeriod(BscMetricPeriodDTO period) {		
		this.period = period;
	}

	/**
	 * Método que permite determinar si la métrica es continua o discreta
	 * @return True si la métrica es continua, False si es discreta
	 */
	public boolean isContinuous() {
		return continuous;
	}

	/**
	 * Método que permite modifar la continuidad de la métrica
	 * @param continuous True si se desea que la métrica sea continua,
	 * False si se desea que la métrica sea Discreta
	 */
	public void setContinuous(boolean continuous) {
		this.continuous = continuous;
	}
	
	/**
	 * Método que permite modificar la lista de valores de la métrica
	 * @param values La nueva lista de valores
	 */
	public void setValues(List<BscMetricValuePartialDTO> values) {
		this.values = values;
	}
	
	/**
	 * Método que permite determinar si la métrica manejara valores numéricos o fechas
	 * @return True si la métrica maneja fechas, false si maneja números
	 */
	public boolean isExpectedDate() {
		return expectedDate;
	}
	
	/**
	 * Método que permite modificar el tipo de valor esperado por la métrica
	 * @param expectedDate True si se desea que la métrica maneje fechas, false
	 * si se desea que la métrica maneje números
	 */
	public void setExpectedDate(boolean expectedDate) {
		this.expectedDate = expectedDate;
	}
	
	/**
	 * Método que permite obtener la cadena que representa a las unidades manejadas
	 * por los valores de la métrica
	 * @return La cadena que representa a las unidades de los valores de la métrica
	 */
	public String getUnitValue() {
		return unitValue;
	}

	/**
	 * Método que permite modificar la cadena que representa a las unidades manejadas
	 * por los valores de la métrica (p.e. Pesos, Veces, Personas, etc)
	 * @param unitValue La nueva unidad que manejará la métrica
	 */
	public void setUnitValue(String unitValue) {
		this.unitValue = unitValue;
	}

	/**
	 * Método que permite obtener el símbolo que representa a la unidad de la métrica
	 * @return El simbolo de unidades actual para los valores de la métrica.
	 */
	public String getUnitValueSymbol() {
		return unitValueSymbol;
	}

	/**
	 * Método que permite modificar el símbolo que representa a la unidad de la métrica
	 * @param unitValueSymbol El nuevo símbolo que representará a la unidad de la métrica
	 */
	public void setUnitValueSymbol(String unitValueSymbol) {
		this.unitValueSymbol = unitValueSymbol;
	}
	
	/**
	 * Método que permite obtener la lista de valores de cumplimiento de la métrica
	 * @return La lista de valores de cumplimiento de la métrica
	 */
	public List<BscMetricValuePartialComplimentDTO> getComplimentValues() {
		return complimentValues;
	}

	/**
	 * Método que permite modificar la lista de valores de cumplimiento de la métrica
	 * @param complimentValues La nueva lista de valores de cumplimiento
	 */
	public void setComplimentValues(List<BscMetricValuePartialComplimentDTO> complimentValues) {
		this.complimentValues = complimentValues;
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
	 * Clase que permite definir un comparador exclusivo para un {@link BscMetricValuePartialDTO}
	 */
	private class MetricValuePartialContinuosComparator implements Comparator<BscMetricValuePartialDTO>{
		@Override
		public int compare(BscMetricValuePartialDTO value1, BscMetricValuePartialDTO value2) {
			if(value1.getComplimentPercent() < value2.getComplimentPercent()){
				return -1;
			}else if(value1.getComplimentPercent() > value2.getComplimentPercent()){
				return 1;
			}else{
				return 0;
			}
		}
	}
}