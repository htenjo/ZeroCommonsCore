package co.zero.kpi.dto;

import java.util.Calendar;
import java.util.Date;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.SemaphoreLevelType;

/**
  * Clase que permite modelar a los valores posibles que puede tener una metrica 
  * @author Hernan Tenjo
  * @version 1.0
  **/
public class KpiMetricValueDTO  extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;

	// Metrica a la que pertenece el valor
    private KpiMetricDTO metric;
	// Nombre que identificará a la metrica 
	private String label;
	//Valor inferior del rango
	private Double lowValue;
	//Valor superior del rango
	private Double hightValue;
	//Valor inferior de un rango de fechas 
	private Date lowDateValue;
	//Valor superior de un rango de fechas
	private Date highDateValue;
	//Valor del porcentaje de cumplimiento del valor de la métrica
    private double complimentPercent;
	//Permite determinar si este es el valor esperado de cumplimiento
	private boolean expectedValue;
    //Nivel de cumplimiento del valor de la métrica (Para las métricas discretas)
    private SemaphoreLevelType complimentLevel;
    	
	/**
	 * Metodo que permite obtener el label del valor de metrica
	 * @return El label del valor
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Metodo que permite modificar el label del valor de metrica
	 * @param label El nuevo label que será asignado al valor de metrica
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Metodo que permite obtener la metrica a la que pertenece el valor
	 * @return La metrica a la que pertenece el valor
	 */
	public KpiMetricDTO getMetric() {
		return metric;
	}
	
	/**
	 * Metodo que permite modificar la metrica a la que pertenece el valor
	 * @param metric La nueva métrica a la que será asociado el valor
	 */
	public void setMetric(KpiMetricDTO metric) {
		this.metric = metric;
	}
		
    /**
     * Metodo que permite obtener el semaforo asociado al {@link KpiMetricValueDTO}
	 * @return El semaforo asociado
	 */
	public SemaphoreLevelType getComplimentLevel() {
		return complimentLevel;
	}

	/**
	 * Metodo que permite modificar el semaforo asociado al {@link KpiMetricValueDTO}
	 * @param semaphore El nuevo semaforo que será asociado al valor
	 */
	public void setComplimentLevel(SemaphoreLevelType complimentLevel) {
		this.complimentLevel = complimentLevel;
	}
	
	/**
	 * Método que permite obtener el valor inferior del rango soportado
	 * por el valor de métrica
	 * @return El valor inferior del rango
	 */
	public Double getLowValue() {
		return lowValue;
	}

	/**
	 * Metodo que permite modificar el valor inferior del rango soportado
	 * por el valor de métrica
	 * @param lowValue El nuevo valor que será asignado al valor inferior del rango
	 */
	public void setLowValue(Double lowValue) {
		this.lowValue = lowValue;
	}

	/**
	 * Método que permite obtener el valor superior del rango soportado
	 * por el valor de métrica
	 * @return El valor superior del rango
	 */
	public Double getHighValue() {
		return hightValue;
	}

	/**
	 * Metodo que permite modificar el valor superior del rango soportado
	 * por el valor de métrica
	 * @param hightValue El nuevo valor que será asignado al valor superior del rango
	 */
	public void setHighValue(Double hightValue) {
		this.hightValue = hightValue;
	}

	/**
	 * Método que permite obtener el valor inferior del rango soportado, 
	 * cuando el tipo de valor de la métrica es una Fecha
	 * @return El valor inferior del rango de fechas
	 */
	public Date getLowDateValue() {
		return lowDateValue;
	}

	/**
	 * Método que permite modificar el valor inferior del rango soportado,
	 * cuando el tipo de valor de la métrica es una fecha
	 * @param lowDateValue La nueva fecha que será asignada como límite
	 * inferior del rango de fechas
	 */
	public void setLowDateValue(Date lowDateValue) {
		this.lowDateValue = lowDateValue;
	}

	/**
	 * Método que permite obtener el valor superior del rango soportado,
	 * cuando el tipo de valor de la métrica es una fecha
	 * @return El valor superior del rango de fechas
	 */
	public Date getHighDateValue() {
		return highDateValue;
	}

	/**
	 * Método que permite modificar el valor superior del rango soportado,
	 * cuando el tipo de valor de la métrica es una fecha
	 * @param hightDateValue La nueva fecha que será asignada como límite
	 * superior del rango de fechas
	 */
	public void setHighDateValue(Date hightDateValue) {
		this.highDateValue = hightDateValue;
	}

	/**
	 * Método que permite obtener el porcentaje que este valor de métrica
	 * representa para el desempeño obtenido por el empleado
	 * @return El porcentaje asociado al desempeño del empleado
	 */
	public double getComplimentPercent() {
		return complimentPercent;
	}

	/**
	 * Metodo que permite modificar el porcentaje que este valor de métrica
	 * representa para el desempeño obtenido por el empleado
	 * @param complimentPercent El nuevo valor que tomará el porcentaje
	 */
	public void setComplimentPercent(double complimentPercent) {
		this.complimentPercent = complimentPercent;
	}

	/**
	 * Método que permite determinar si este valor de métrica es el valor esperado
	 * o valor meta de la métrica
	 * @return True si este valor es el valor esperado, false de lo contrario
	 */
	public boolean isExpectedValue() {
		return expectedValue;
	}

	/**
	 * Método que permite modificar si este es el valor esperado de la métrica
	 * @param expectedValue True si se desea que el valor sea el esperado, false de lo contrario
	 */
	public void setExpectedValue(boolean expectedValue) {
		this.expectedValue = expectedValue;
	}
	
	/**
	 * Método que permite obtener el valor superior de tipo fecha en un formato
	 * fácil de trabajar (Días del año)para los cálculos
	 * @return Cantidad de días que representa el valor superior de tipo fecha
	 */
	public int getHighDateValueAsDays(){
		Calendar highDays = Calendar.getInstance();
		
		if(highDateValue != null){
			highDays.setTime(highDateValue);
			return highDays.get(Calendar.DAY_OF_YEAR);
		}else{
			return highDays.getMaximum(Calendar.DAY_OF_YEAR);
		}
	}
	
	/**
	 * Método que permite obtener el valor superior de tipo fecha en un formato numérico
	 * @return El número de día del año representado por la fecha
	 */
	public double getHighValueAsDouble(){
		if(metric.isValueAsDate()){
			return getHighDateValueAsDays();
		}else{
			return getHighValue();
		}
	}

	/**
	 * Metodo que permite determinar si un valor numérico dado pertenece 
	 * al rango DISCRETO especificado por el valor de métrica
	 * @param value Valor que se desea verificar
	 * @return True si el valor pertenece al rango, false de lo contrario
	 */
	public boolean rangeContainDiscreteValue(double value){
		if(lowValue != null && hightValue != null){
			return lowValue <= value && value <= hightValue;
		}else if(lowValue != null && hightValue == null){
			return lowValue <= value;
		}else if(lowValue == null && hightValue != null){
			return value <= hightValue;
		}else{
			//Nunca se debería presentar este caso si el valor de metrica está bien formado
			return false;
		}
	}
	
	/**
	 * Metodo que permite determinar si un valor de tipo fecha dado 
	 * pertenece al rango DISCRETO especificado por el valor de métrica
	 * @param value Valor que se desea verificar
	 * @return True si el valor pertenece al rango, false de lo contrario
	 */
	public boolean rangeContainDiscreteValue(Date value){
		Calendar realDate = Calendar.getInstance();
		realDate.setTime(value);
		int realDays = realDate.get(Calendar.DAY_OF_YEAR);
		int lowDays = getLowDateValueAsDays();
		int highDays = getHighDateValueAsDays();
		
		if(lowDateValue != null && highDateValue != null){
			return lowDays <= realDays && realDays <= highDays;
		}else if(lowDateValue != null && highDateValue == null){
			return lowDays <= realDays;
		}else if(lowValue == null && highDateValue != null){
			return realDays <= highDays;
		}else{
			//Nunca se debería presentar este caso si el valor de metrica está bien formado
			return false;
		}
	}
	
	/**
	 * Método que permite obtener el valor inferior de tipo fecha en un formato
	 * fácil de trabajar (Días del año) para los cálculos
	 * @return Cantidad de días que representa el valor inferior de tipo fecha
	 */
	public int getLowDateValueAsDays(){
		Calendar lowDays = Calendar.getInstance();
		
		if(lowDateValue != null){
			lowDays.setTime(lowDateValue);
			return lowDays.get(Calendar.DAY_OF_YEAR);
		}else{
			return lowDays.getMinimum(Calendar.DAY_OF_YEAR);
		}
	}
	
}