//=======================================================================
// ARCHIVO ReportConfigurationDTO.java
// FECHA CREACIÓN: 05/06/2012
//=======================================================================
package co.zero.evaluation.dto;

import java.util.ArrayList;
import java.util.List;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.evaluation.ReportType;

/**
 * Clase que reune la configuración realizada de un reporte para una evaluación
 * @author Hernán Tenjo
 * @version 1.0
 */
public class ReportConfigurationDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	
	//Evaluación en la que ha sido configurado el reporte
	private EvaluationDTO evaluation;
	//Tipo de reporte que ha sido configurado
	private ReportType reportType;
	//Espacio que puede ser utilizado para el key i18n del nombre del reporte x cliente
	private String name;
	//Url donde se encuentra el reporte
	private String reportUrl;
	//Url del listado de items del que se seleccionará al que se le va a generar el reporte
	private String reportItemsUrl;
	//Determina si el reporte necesita seleccionar un item en especial para generar el reporte
	//p.e. en los reportes personales se necesita seleccionar el empleado objetivo
	private boolean requiredItemSelection;
	//Determina si el reporte se puede descargar sin ninguna operación diferente de seleccionar el reporte deseado
	private boolean directDownload;
	//Propiedades/Parámetros dinámicos asociados al reporte
	private List<ReportPropertyDTO> properties;
	
	/**
	 * Método que obtiene la evaluación en la que ha sido configurado el reporte
	 * @return Evaluación a la que pertenece la configuración
	 */
	public EvaluationDTO getEvaluation() {
		return evaluation;
	}

	/**
	 * Método que modifica la evaluación en la que ha sido configurado el reporte
	 * @param evaluation Nueva evaluación a la que pertenece la configuración
	 */
	public void setEvaluation(EvaluationDTO evaluation) {
		this.evaluation = evaluation;
	}

	/**
	 * Método que obtiene el tipo de reporte configurado para la evaluación
	 * @return Tipo del reporte que se encuentra disponible para la evaluación
	 */
	public ReportType getReportType() {
		return reportType;
	}

	/**
	 * Método que modifica el tipo de reporte configurado para la evaluación
	 * @param reportType Nuevo tipo de reporte que se encontrará disponible para la evaluación 
	 */
	public void setReportType(ReportType reportType) {
		this.reportType = reportType;
	}
	

	/**
	 * Método que obtiene el nombre del reporte (puede ser el key i18n)
	 * @return El nombre del reporte x evaluación x cliente
	 */
	public String getName() {
		return name;
	}

	/**
	 * Método que modifica el nombre del reporte
	 * @param name El nuevo nombre del reporte
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Método que obtiene la url del reporte que se va a generar
	 * @return Url del reporte a generar
	 */
	public String getReportUrl() {
		return reportUrl;
	}

	/**
	 * Método que modifica la url del reporte que se va a generar
	 * @param reportUrl Nueva Url del reporte a generar 
	 */
	public void setReportUrl(String reportUrl) {
		this.reportUrl = reportUrl;
	}

	/**
	 * Método que obtiene la url del listado de items seleccionables para el reporte
	 * @return Url del listado de items a seleccionar para el reporte
	 */
	public String getReportItemsUrl() {
		return reportItemsUrl;
	}

	/**
	 * Método que modifica la url del listado de items seleccionables para el reporte
	 * @param reportItemsUrl La nueva url del listado de items
	 */
	public void setReportItemsUrl(String reportItemsUrl) {
		this.reportItemsUrl = reportItemsUrl;
	}

	/**
	 * Método que determina si el reporte requiere seleccionar un item para la generación del reporte
	 * @return True si se requiere seleccionar un item para el reporte, false de lo constrario
	 */
	public boolean isRequiredItemSelection() {
		return requiredItemSelection;
	}

	/**
	 * Método que modifica el hecho de necesitar un item para la generación del reporte
	 * @param requiredItemSelection True si se requiere un item, false de lo contrario
	 */
	public void setRequiredItemSelection(boolean requiredItemSelection) {
		this.requiredItemSelection = requiredItemSelection;
	}

	/**
	 * Método que obtiene las propiedades dinámicas del reporte
	 * @return Las propiedades dinámicas del reporte
	 */
	public List<ReportPropertyDTO> getProperties() {
		return properties;
	}
	
	/**
	 * Método que determina si el reporte puede ser descargado de forma directa
	 * @return True si se puede generar el reporte sin ninguna operación adicional
	 */
	public boolean isDirectDownload() {
		return directDownload;
	}

	/**
	 * Método que modifica el hecho de hacer un reporte descargable directamente
	 * @param directDownload True si se desea que el reporte sea descargado directamente, false de lo contrario
	 */
	public void setDirectDownload(boolean directDownload) {
		this.directDownload = directDownload;
	}

	/**
	 * Método que obtiene el valor de una propiedad por el nombre si existe.
	 * @param propertyName Nombre de la propiedad que se desea analizar
	 * @return Valor de la propiedad si existe, null de lo contrario
	 */
	public String getPropertyByName(String propertyName){
		String propertyValue = null;
		
		for(ReportPropertyDTO property : properties){
			if(property.getName().equals(propertyName)){
				return property.getValue();
			}
		}
		
		return propertyValue;
	}
	
	/**
	 * Método que obtiene el valor de una propiedad por el nombre si existe.
	 * @param propertyName Nombre de la propiedad que se desea analizar
	 * @return Valor de la propiedad si existe, null de lo contrario
	 */
	public Double getPropertyMinValueByName(String propertyName){
		double minimum = 0;
		
		for(ReportPropertyDTO property : properties){
			if(property.getName().equals(propertyName)){
				return property.getMinValue();
			}
		}
		
		return minimum;
	}
	
	/**
	 * Método que obtiene el valor de una propiedad por el nombre si existe.
	 * @param propertyName Nombre de la propiedad que se desea analizar
	 * @return Valor de la propiedad si existe, null de lo contrario
	 */
	public Double getPropertyMaxValueByName(String propertyName){
		double maximum = 0;
		
		for(ReportPropertyDTO property : properties){
			if(property.getName().equals(propertyName)){
				return property.getMaxValue();
			}
		}
		
		return maximum;
	}
	
	/**
	 * Método que modifica las propiedades dinámicas del reporte
	 * @param properties Las nuevas propiedades dinámicas del reporte
	 */
	public void setProperties(List<ReportPropertyDTO> properties) {
		this.properties = properties;
	}
	
	/**
	 * Metodo que devuelve una lista de los valores de las propiedades que 
	 * empiezan con el prefijo indicado
	 * @param propertyName Prefijo con el que empieza el nombred e la propiedad
	 * @return Lsita de los valores
	 */
	public List<String> getPropertiesByName(String propertyName){
		List<String> propertiesValues = new ArrayList<String>();
		
		for(ReportPropertyDTO property : properties){
			if(property.getName().startsWith(propertyName)){
				propertiesValues.add(property.getValue());
			}
		}
		
		return propertiesValues;
	}
	
	public void addProperty(ReportPropertyDTO property){
		if(properties == null){
			properties = new ArrayList<ReportPropertyDTO>();
		}
		
		properties.add(property);
	}
}
