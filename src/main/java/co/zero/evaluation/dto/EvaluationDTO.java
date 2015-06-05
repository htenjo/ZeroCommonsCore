//=======================================================================
// ARCHIVO EvaluationDTO.java
// FECHA CREACIÓN: 9/05/2011
//=======================================================================
package co.zero.evaluation.dto;

import java.util.Date;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.evaluation.EvaluationType;
import co.zero.hcm.dto.CompanyDTO;

/**
 * Clase que representa una evaluación en el sistema
 * (p.e. Evaluación de 360°, de ClimateDTO, etc) 
 * @author Hernán Tenjo
 * @version 1.0
 */
public abstract class EvaluationDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	
	//Empresa a la que pertenece la evaluacion
	private CompanyDTO company;
	//Nombre representativo de la evaluacion
	private String name;
	//Descripción corta del propósito de la evaluación
	private String description;
	//Fecha de inicio de la evaluacion
	private Date startDate;
	//Fecha de finalización de la evaluación
	private Date endDate;
	//Tipo de la evaluación que se llevará acabo
	private EvaluationType type;
	//Objeto que contiene toda la configuración de la evaluación
	private EvaluationConfigurationDTO configuration;
	
	/**
	 * Método constructor por defecto para la entidad
	 */
	public EvaluationDTO(){
		setType(getDefaultType());
	}
	
	/**
	 * Método que garantiza la asignación inicial del tipo
	 * de la evaluación según cada modelo de evaluación seleccionado
	 */
	protected abstract EvaluationType getDefaultType();
	
	/**
	 * Metodo que permite obtener la compañía a la que pertenece la evaluación 
	 * @return La compañía a la que pertenece la evaluación
	 */
	public CompanyDTO getCompany() {
		return company;
	}

	/**
	 * Metodo que permite modificar la compañía a la que pertenece la evaluación
	 * @param company La nueva compañía asociada a la evaluación
	 */
	public void setCompany(CompanyDTO company) {
		this.company = company;
	}

	/**
	 * Método que permite obtener el nombre de la evaluación
	 * @return El texto representativo de la entidad
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo que permite modificar el nombre ede la evaluación
	 * @param name El nuevo texto que servirá de nombre a la evaluación
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Método que permite obtener la descripción del propósito de la evaluación
	 * @return La descripción registrada de la evaluación
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Método que permite modificar la descripción del propósito de la evaluación
	 * @param description El nuevo texto que servirá de descripción a la evaluación
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Método que permite obtener la fecha de inicio de la evaluación
	 * @return La fecha de inicio de la evaluacion
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Método que permite modificar la fecha de inicio de la evaluación
	 * @param startDate La nueva fecha de finalización de la evaluación
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Método que permite obtener la fecha de finalización de la evaluación
	 * @return La fecha de finalización de la evaluación
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Método que permite modificar la fecha de finalización de la evaluación
	 * @param endDate La nueva fecha de finalización de la evaluación
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Metodo que permite obtener el tipo de la evaluación
	 * @return El tipo configurado de la evaluación
	 */
	public EvaluationType getType() {
		return type;
	}

	/**
	 * Método que permite obtener el tipo de la evaluación
	 * @param type El tipo configurado de la evaluación
	 */
	public void setType(EvaluationType type) {
		this.type = type;
	}

	/**
	 * Método que permite obtener la configuración de la evaluación
	 * @return Objeto con la configuración de la evaluación
	 */
	public EvaluationConfigurationDTO getConfiguration() {
		return configuration;
	}

	/**
	 * Método que permite modificar la configuración de la evaluación
	 * @param configuration Objeto con los nuevos parámetros de configuración de la evaluación
	 */
	public void setConfiguration(EvaluationConfigurationDTO configuration) {
		this.configuration = configuration;
	}
}