//=======================================================================
// ARCHIVO EntityMetadataDTO.java
// FECHA CREACIÓN: Oct 1, 2009
//=======================================================================
package co.zero.hcm.dto;

import co.zero.common.dto.EntityDTO;


/**
 * Bean que contiene los atributos requeridos en la vista 
 * de un {@link EntityMetadataDTO} 
 * @author Hernán Tenjo
 * @version 1.0
 */
public class EntityMetadataDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Compañía a la que pertenece la configuración
	private CompanyDTO company;
	//Definicion de la entidad para la que se definen los campos dinámicos 
	private PersistentEntityMetadataDTO entity;
	//Detemina si la información de esta entidad se debe diligenciar al crear una instancia
	private boolean required;
	//Permite establecer un orden de importancia sobre las entidades a diligenciar
	private int priority;
	
	/**
	 * Permite obtener la compañía en la que se definió la metadata
	 * @return la compañia a la que pertenece la metadata
	 */
	public CompanyDTO getCompany(){
		return company;
	}
	
	/**
	 * Permite modificar la compañia a la que pertenece la metadata
	 * @param company La nueva compañía a la que se asociará la metadata
	 */
	public void setCompany(CompanyDTO company) {
		this.company = company;
	}
	
	/**
	 * Permite obtener la entidad a la cual se le esta 
	 * asociando la metadata que describe sus campos
	 * @return La entidad a la que define la metadata
	 */
	public PersistentEntityMetadataDTO getEntity() {
		return entity;
	}
	
	/**
	 * Permite modificar la entidad a la que esta definiendo
	 * la metadata
	 * @param entity La nueva entidad a la que será asociada
	 * la metadata que define sus campos
	 */
	public void setEntity(PersistentEntityMetadataDTO entity) {
		this.entity = entity;
	}
	

	/**
	 * Método que determina si la información de la entidad debe ser diligenciada de forma obligatoria
	 * @return True si se requiere la información de la entidad, false de lo contrario
	 */
	public boolean isRequired() {
		return required;
	}

	/**
	 * Método que modifica el estado requerido de la información de la entidad
	 * @param required True si se desea hacer requerida la información de la entida, false de lo contrario
	 */
	public void setRequired(boolean required) {
		this.required = required;
	}

	/**
	 * Método que obtiene la prioridad de la entidad
	 * @return La prioridad de la entidad
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Método que modifica la importancia de una entidad. Esta prioridad se maneja de forma ascendente
	 * para efectos prácticos de visualización, es decir, la entidad más importante es la de menor prioridad. 
	 * @param priority La nueva prioridad de la entidad
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
}

