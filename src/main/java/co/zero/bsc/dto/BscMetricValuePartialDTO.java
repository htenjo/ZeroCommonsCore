//=======================================================================
// ARCHIVO BscMetricValuePartialDTO.java
// FECHA CREACIÓN: 6/07/2011
//=======================================================================
package co.zero.bsc.dto;

import java.util.Calendar;
import java.util.Date;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.SemaphoreLevelType;

/**
 * Clase que permite modelar a los valores posibles que puede tener una metrica parcial
 * @author Hernan Tenjo
 * @version 1.0
 **/
public class BscMetricValuePartialDTO extends EntityDTO {
	// Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	private static final String COMPLIMENT_LEVEL_ATTRIBUTE = "complimentLevel";
	
	// Nombre que identificará al valor de la métrica
	private String label;
	// Metrica a la que pertenece el valor
	private BscMetricPartialDTO metric;
	// Valor inferior del rango
	private Double lowValue;
	// Valor superior del rango
	private Double highValue;
	//Valor inferior de un rango de fechas 
	private Date lowDateValue;
	//Valor superior de un rango de fechas
	private Date highDateValue;
	// Enumeración que permite relacionar un valor de métrica a un semaforo
	private SemaphoreLevelType complimentLevel = SemaphoreLevelType.RED_LIGHT;
	// Porcentaje asociado al semáforo
	private double complimentPercent;
	//Permite determinar si este es el valor esperado de cumplimiento
	private boolean expectedValue;

	//----- Atributos requeridos únicamente por la vista
	// Determina si el valor menor del rango se encuentra activo
    private boolean lowValueActive;
    //Determina si el valor mayor del rango se encuentra activo
    private boolean highValueActive;

	/**
	 * Metodo que permite determinar si un valor numérico dado pertenece 
	 * al rango DISCRETO especificado por el valor de métrica
	 * @param value Valor que se desea verificar
	 * @return True si el valor pertenece al rango, false de lo contrario
	 */
	public boolean rangeContainDiscreteValue(double value){
		if(lowValue != null && highValue != null){
			return lowValue <= value && value <= highValue;
		}else if(lowValue != null && highValue == null){
			return lowValue <= value;
		}else if(lowValue == null && highValue != null){
			return value <= highValue;
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
		}else if(lowValue == null && highValue != null){
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
	 * Método que permite obtener el valor inferior de tipo fecha en un formato numérico
	 * @return El número de día del año representado por la fecha
	 */
	public double getLowValueAsDouble(){
		if(metric.isExpectedDate()){
			return getLowDateValueAsDays();
		}else{
			return lowValue;
		}
	}
	
	/**
	 * Método que permite obtener el valor superior de tipo fecha en un formato numérico
	 * @return El número de día del año representado por la fecha
	 */
	public double getHighValueAsDouble(){
		if(metric.isExpectedDate()){
			return getHighDateValueAsDays();
		}else{
			return highValue;
		}
	}
	
	//========================== Métodos requeridos por la vista ================================
    /**
	 * Método que permite modificar el semáforo asociado al valor con un evento
	 * @param e Objeto con la información del evento generado
	 */
	public void changeComplimentLevel(ActionEvent e){
		String levelParameter = e.getComponent().getAttributes().get(COMPLIMENT_LEVEL_ATTRIBUTE).toString();
		this.complimentLevel = SemaphoreLevelType.valueOf(levelParameter);
	}
	
	/**
	 * Método que permite modificar el estado activo del valor inferior con un evento
	 * @param e Objeto con la información del evento generado
	 */
	public void changeLowValueActive(ValueChangeEvent e){
		if(e.getNewValue() instanceof Boolean){
			lowValueActive = (Boolean)e.getNewValue();
		}else{
			lowValueActive = false;
		}
		
		if(lowValueActive == false){
			lowValue = null;
			lowDateValue = null;
		}
	}
	
	/**
	 * Método que permite mofiicacr el estado activo del valor superior con un evento
	 * @param e Objeto con la información del evento generado
	 */
	public void changeHighValueActive(ValueChangeEvent e){
		if(e.getNewValue() instanceof Boolean){
			highValueActive = (Boolean)e.getNewValue(); 
		}else{
			highValueActive = false;
		}
		
		if(highValueActive == false){
			highValue = null;
			highDateValue = null;
		}
	}
	
	/**
	 * Método similar a getLowValue(), pero que permite que el valor sea formateado en la vista 
	 * @return El valor inferior del rango
	 */
	public Number getLowValueNumber() {
		return lowValue;
	}

	/**
	 * Método similar a setLowValue(), pero que permite que el valor sea formateado en la vista
	 * @param lowValue El nuevo valor que será asignado al valor inferior del rango
	 */
	public void setLowValueNumber(Number lowValue) {
		this.lowValue = lowValue.doubleValue();
	}

	/**
	 * Método similar a getHighValue(), pero que permite que el valor sea formateado en la vista 
	 * @return El valor superior del rango
	 */
	public Number getHighValueNumber() {
		return highValue;
	}
	
	/**
	 * Método similar a setHighValue(), pero que permite que el valor sea formateado en la vista 
	 * @param hightValue El nuevo valor que será asignado al valor superior del rango
	 */
	public void setHighValueNumber(Number hightValue) {
		this.highValue = hightValue.doubleValue();
	}
	//========================== Métodos Get/Set del POJO ================================
	
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
	public BscMetricPartialDTO getMetric() {
		return metric;
	}

	/**
	 * Metodo que permite modificar la metrica a la que pertenece el valor
	 * @param metric La nueva métrica a la que será asociado el valor
	 */
	public void setMetric(BscMetricPartialDTO metric) {
		this.metric = metric;
	}

	/**
	 * Metodo que permite obtener el semaforo asociado al {@link BscMetricValue}
	 * @return El semaforo asociado
	 */
	public SemaphoreLevelType getComplimentLevel() {
		return complimentLevel;
	}

	/**
	 * Metodo que permite modificar el semaforo asociado al {@link BscMetricValue}
	 * @param semaphore El nuevo semaforo que será asociado al valor
	 */
	public void setComplimentLevel(SemaphoreLevelType semaphore) {
		this.complimentLevel = semaphore;
	}

	/**
	 * Método que permite obtener el valor inferior del rango soportado por el valor de métrica
	 * @return El valor inferior del rango
	 */
	public Double getLowValue() {
		return lowValueActive ? lowValue : Double.NEGATIVE_INFINITY;
	}

	/**
	 * Metodo que permite modificar el valor inferior del rango soportado por el valor de métrica
	 * @param lowValue El nuevo valor que será asignado al valor inferior del rango
	 */
	public void setLowValue(Double lowValue) {
		this.lowValueActive |= lowValue != null;
		this.lowValue = lowValue;
	}

	/**
	 * Método que permite obtener el valor superior del rango soportado por el valor de métrica
	 * @return El valor superior del rango
	 */
	public Double getHighValue() {
		return highValueActive ? highValue: Double.POSITIVE_INFINITY;
	}
	
	/**
	 * Metodo que permite modificar el valor superior del rango soportado por el valor de métrica
	 * @param hightValue El nuevo valor que será asignado al valor superior del rango
	 */
	public void setHighValue(Double hightValue) {
		this.highValueActive |= hightValue != null;
		this.highValue = hightValue;
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
	 * @param semaphorePercent El nuevo valor que tomará el porcentaje
	 */
	public void setComplimentPercent(double semaphorePercent) {
		this.complimentPercent = semaphorePercent;
	}
	
	/**
	 * Método que permite obtener el valor inferior del rango, cuando el valor
	 * esperado es de tipo fecha
	 * @return La fecha correspondiente al rango inferior del valor de la métrica
	 */
	public Date getLowDateValue() {
		return lowDateValue;
	}

	/**
	 * Método que permite modificar el valor inferior del rango, cuando el valor
	 * esperado es de tipo fecha
	 * @param lowDateValue La nueva fecha que servirá como límite inferior del rango
	 */
	public void setLowDateValue(Date lowDateValue) {
		this.lowValueActive |= lowDateValue != null;
		this.lowDateValue = lowDateValue;
	}

	/**
	 * Método que permite obtener el valor superior del rango, cuando el valor
	 * esperado es de tipo fecha
	 * @return La fecha correspondiente al rango superior del valor de la métrica
	 */
	public Date getHighDateValue() {
		return highDateValue;
	}

	/**
	 * Método que permite modificar el valor superior del rango, cuando el valor
	 * esperado es de tipo fecha
	 * @param hightDateValue La nueva fecha que servirá como límite superior del rango
	 */
	public void setHighDateValue(Date hightDateValue) {
		this.highValueActive |= hightDateValue != null;
		this.highDateValue = hightDateValue;
	}
	
	/**
	 * Método que permite determinar si el valor inferior se encuentra activo
	 * @return True si el valor se encuentra activo, false de lo contrario
	 */
	public boolean isLowValueActive() {
		return lowValueActive;
	}
	
	/**
	 * Método que permite modificar el estado del valor inferior
	 * @param lowValueActive True si se desea que el valor inferior se encuentre
	 * activo, false de lo contrario
	 */
	public void setLowValueActive(boolean lowValueActive) {
		this.lowValueActive = lowValueActive;
	}
	
	/**
	 * Método que permite determinar si el valor superior se encuentra activos
	 * @return True si el valor se encuentra activo, false de lo contrario
	 */
	public boolean isHighValueActive() {
		return highValueActive;
	}
	
	/**
	 * Método que permite modificar el estado del valor superior
	 * @param hightValueActive True si se desea que el valor superior se encuentre
	 * activo, false de lo contrario
	 */
	public void setHighValueActive(boolean hightValueActive) {
		this.highValueActive = hightValueActive;
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
}