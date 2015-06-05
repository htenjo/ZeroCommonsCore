//=======================================================================
// ARCHIVO CompanyRelation.java
// FECHA CREACIÓN: Sep 18, 2009
//=======================================================================
package co.zero.hcm.dto;

import co.zero.common.dto.EntityDTO;

/**
 * Bean que contiene los atributos requeridos en la vista 
 * de un {@link CompanyRelationDTO} 
 * @author Hernán Tenjo
 * @version 1.0
 */
public class CompanyRelationDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Identificador del tipo de relación 
	private String name;
	//Breve descripción de la funcionalidad de la relación
	private String description;
	//Compañía en la que se encuentra definida la relación
	private CompanyDTO company;
		
	/**
	 * Nombre que identifica a la relación ej. BOSS
	 * @return el nombre de la relación entre los empleados
	 */
	public String getName() {
		return name;
	}

	/**
	 * Modifica el nombre de la relación
	 * @param name El nuevo nombre de la relación
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Obtiene la descripción de la relación
	 * @return Una breve descripción del proposito de la relación 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Modifica la descripción breve de la relación
	 * @param description El texto de la nueva descripción
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Permite obtener la compañía en la que se encuentra
	 * definida la relación
	 * @return La compañía en la que la relación se encuentra definida 
	 */
	public CompanyDTO getCompany() {
		return company;
	}

	/**
	 * Permite modificar la compañía en la que se encuentra
	 * definida la relación
	 * @param company La nueva compañía asociada a la relación
	 */
	public void setCompany(CompanyDTO company) {
		this.company = company;
	}
}