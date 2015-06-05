//=======================================================================
// ARCHIVO KpiMetricDTO.java
// FECHA CREACIÓN: 2012/08/15
//=======================================================================
package co.zero.kpi.dto;

import java.util.ArrayList;
import java.util.List;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.kpi.MetricTrendType;

/**
 * Clase que permite establecer las pautas para evaluar el desempeño de un objetivo con respecto a una meta dada
 * @author Hernán Tenjo
 * @version 1.0
 */
public abstract class KpiMetricDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	
	//Nombre que representa a la métrica
	private String name;
	//Breve descripción del propósito de la métrica
	private String description;
	//Valor que determina si los porcentajes de cumplimiento serán continuos o discretos
	private boolean continuous;
	//Determina si el valor esperado es de tipo Fecha o de Tipo Numérico
	private boolean valueAsDate;
	//Label que identifica las unidades en las que se expresan los valores de la métrica
	private String unitValue;
	//Label que contiene el símbolo corto que representa a las unidades de los valores de la métrica
	private String unitValueSymbol;
	//Lista con los valores de la metrica
	private List<KpiMetricValueDTO> values;
	//Lista con los valores de cumplimiento de la métrica (Exclusivamente para métricas continuas)
	private List<KpiMetricValueComplimentDTO> complimentValues;
	//Tendencia de la metrica
	private MetricTrendType trend;

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
	public List<KpiMetricValueDTO> getValues() {
		return values;
	}

	/**
	 * Método que permite modificar la lista de valores de la métrica
	 * @param values La nueva lista de valores
	 */
	public void setValues(List<KpiMetricValueDTO> values) {
		this.values = values;
	}
	
	/**
	 * Método que permite obtener la lista de valores de cumplimiento de la métrica
	 * @return La lista de valores de cumplimiento de la métrica
	 */
	public List<KpiMetricValueComplimentDTO> getComplimentValues() {
		return complimentValues;
	}

	/**
	 * Método que permite modificar la lista de valores de cumplimiento de la métrica
	 * @param complimentValues La nueva lista de valores de cumplimiento
	 */
	public void setComplimentValues(List<KpiMetricValueComplimentDTO> complimentValues) {
		this.complimentValues = complimentValues;
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
	 * Método que permite determinar si la métrica manejara valores numéricos o fechas
	 * @return True si la métrica maneja fechas, false si maneja números
	 */
	public boolean isValueAsDate() {
		return valueAsDate;
	}
	
	/**
	 * Método que permite modificar el tipo de valor esperado por la métrica
	 * @param expectedDate True si se desea que la métrica maneje fechas, false
	 * si se desea que la métrica maneje números
	 */
	public void setValueAsDate(boolean valueAsDate) {
		this.valueAsDate = valueAsDate;
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
	 * Metodo que permite agregar un valor a la lista de valores relacionados a la métrica
	 * @param value Nuevo valor que se desea agregar
	 */
	public void addValue(KpiMetricValueDTO value){
		if(values == null){
			values = new ArrayList<KpiMetricValueDTO>();
		}
		
		value.setMetric(this);
		values.add(value);
	}
	
	/**
	 * Método que permite agregar una valor a la lista de valores de cumplimiento de la métrica
	 * @param value Nuevo valor que se desea agregar
	 */
	public void addComplimentValue(KpiMetricValueComplimentDTO value){
		if(complimentValues == null){
			complimentValues = new ArrayList<KpiMetricValueComplimentDTO>();
		}
		
		value.setMetric(this);
		complimentValues.add(value);
	}

	/**
	 * Método que determina la tendencia de la métrica
	 * @return La tendencia asociada a la métrica
	 */
	public MetricTrendType getTrendType() {
		return trend;
	}

	/**
	 * Metodo que permite modificar la tendencia de la metrica
	 * @param trend La nueva tendencia de la métrica
	 */
	public void setTrendType(MetricTrendType trend) {
		this.trend = trend;
	}
}