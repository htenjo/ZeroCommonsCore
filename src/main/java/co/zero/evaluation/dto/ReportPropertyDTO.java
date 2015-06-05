//=======================================================================
// ARCHIVO ReportProperty.java
// FECHA CREACIÓN: 05/06/2012
//=======================================================================
package co.zero.evaluation.dto;

import co.zero.common.dto.EntityDTO;

/**
 * Clase que representa a una propiedad o parámetro de un reporte
 * @author Hernán Tenjo
 * @version 1.0
 */
public class ReportPropertyDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	
	//Configuración de reporte a la que pertenece el parámetro
	private ReportConfigurationDTO configuration;
	//Nombre del parámetro del reporte
	private String name;
	//Valor del parámetro del reporte
	private String value;
	//Valor mínimo, cuando el valor del parámetro es un rango
	private double minValue;
	//Valor máximo, cuando el valor del parámetro es un rango
	private double maxValue;
	
	/**
	 * Método que obtiene el nombre del parámetro del reporte
	 * @return Nombre del parámetro del reporte
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Método que modifica el nombre del parámetro del reporte
	 * @param name Nuevo nombre que tendrá el parámetro del reporte
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Método que obtiene el valor del parámetro del reporte
	 * @return Valor del parámetro representado como cadena
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Método que modifica el valor del parámetro del reporte 
	 * @param value Nuevo valor que tendrá el parámetro del reporte
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Método que obtiene la configuración de reporte a la que pertenece el parámetro
	 * @return La configuración a la que pertenece el parámetro
	 */
	public ReportConfigurationDTO getConfiguration() {
		return configuration;
	}

	/**
	 * Método que modifica la configuracón de reporte a la que pertenece el parámetro
	 * @param configuration La nueva configuración a la que pertenece el parámetro
	 */
	public void setConfiguration(ReportConfigurationDTO configuration) {
		this.configuration = configuration;
	}

	/**
	 * Método que obtiene el valor mínimo del parámetro del reporte
	 * @return El valor mínimo configurado como parámetro del reporte
	 */
	public double getMinValue() {
		return minValue;
	}

	/**
	 * Método que modifica el valor mínimo del parámetro del reporte
	 * @param minValue El nuevo valor mínimo del parámetro
	 */
	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}

	/**
	 * Método que obtiene el valor máximo del parámetro del reporte
	 * @return El valor máximo configurado como parámetro del reporte
	 */
	public double getMaxValue() {
		return maxValue;
	}

	/**
	 * Método que modifica el valor máximo del parámetro del reporte
	 * @param maxValue El nuevo valor máximo del parámetro
	 */
	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}
}
