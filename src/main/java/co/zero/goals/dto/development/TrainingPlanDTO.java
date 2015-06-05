//=======================================================================
// ARCHIVO TrainingPlan.java
// FECHA CREACIÓN: 26/07/2010
//=======================================================================
package co.zero.goals.dto.development;

import java.util.Date;

import co.zero.common.dto.EntityDTO;
import co.zero.hcm.dto.CompanyDTO;

/**
 * Clase que permite establecer diferentes capacitaciones en el 
 * tiempo para un mismo conjunto de compentencias de una compañia
 * @author Hernán Tenjo
 * @version 1.0
 */
public class TrainingPlanDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Nombre de los campos que se podrán ignorar en un versión basica para JSON del DTO
	private static final String[] complexFieldsToIgnoreInJSON = 
			new String[]{"company", "createdDate", "lastUpdatedDate", "complexFieldsToIgnoreInJSON"};
	//Empresa en la que se realizará el plan de capacitación
	private CompanyDTO company;
	//Fecha en la que se espera empezar el plan de capacitaciones
	private Date startDate;
	//Fecha en la que se espera terminar el plan de capacitaciones 
	private Date endDate;
	//Nombre que se dará al plan de capacitaciones
	private String name;
	//Breve descripción del plan de capacitaciones planeado
	private String description;
	
	/**
	 * Metodo que permite obtener la compañía del plan de entrenamiento
	 * @return La compañía a la que pertenece el plan
	 */
	public CompanyDTO getCompany() {
		return company;
	}
	
	/**
	 * Metodo que permite modificar la compañía asociada al plan 
	 * de entrenamiento
	 * @param company La nueva compañía a la que será asociado el plan
	 */
	public void setCompany(CompanyDTO company) {
		this.company = company;
	}
	
	/**
	 * Metodo que permite obtener la fecha en la que se espera iniciar
	 * el plan de capacitacion
	 * @return La fecha inicial configurada
	 */
	public Date getStartDate() {
		return startDate;
	}
	
	/**
	 * Metodo que permite modificar la fecha de inicio del plan de 
	 * capacitación
	 * @param startDate La nueva fecha de inicio de las capacitaciones
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * Metodo que permite obtener la facha en la que se espera
	 * terminen las capacitaciones propuestas
	 * @return La fecha de finalización de capacitaciones esperada 
	 */
	public Date getEndDate() {
		return endDate;
	}
	
	/**
	 * Metodo que permite modificar la fecha en la que se espera
	 * terminen las capacitaciones propuestas
	 * @param endDate La nueva fecha de finalizacion de capacitaciones
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Metodo que permite obtener la descripcion del plan de capacitaciones
	 * @return La descripción del plan de capacitaciones
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Metodo que permite modificar la descripcion del plan de capacitaciones
	 * @param description La nueva descripcion del plan
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Metodo que permite obtener el nombre asignado al plan de capacitaciones
	 * @return El nombre asignado al plan de capacitaciones
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo que permite modificar el nombre del plan de capacitacion
	 * @param name El nuevo nombre que sera asignado al plan de capacitacion
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Método que obtiene la lista de campos que no se tendrán en cuenta
	 * cuando se haga un parse básico del DTO con JSON
	 * @return
	 */
	public static String[] getComplexFieldsToIgnoreInJSON(){
		return complexFieldsToIgnoreInJSON;
	}
}