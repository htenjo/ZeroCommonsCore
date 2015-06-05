//=======================================================================
// ARCHIVO WizardEntityMetadataDTO.java
// FECHA CREACIÓN: 15/05/2012
//=======================================================================
package co.zero.hcm.dto;

import co.zero.common.dto.EntityDTO;
import co.zero.hcm.dto.ui.FieldGroupDTO;

/**
 * Objeto que contiene la información requerida por la vista para el manejo del Wizard de entidades
 * @author Hernán Tenjo
 * @version 1.0
 */
public class WizardEntityMetadataDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Entidad configurada para la compañía, que se desea involucrar en el proceso
	private EntityMetadataDTO entityMetadata;
	//Grupo de campos que se desean integrar en el wizard para el entityMetadata
	private FieldGroupDTO fieldGroup;
	//Privilegio que identifica el proceso que se desea modelar con el wizard 
	private PrivilegeDTO privilege;
	
	/**
	 * Método que obtiene el {@link EntityMetadataDTO} asociado al wizard
	 * @return El {@link EntityMetadataDTO} configurado en la instancia del wizard
	 */
	public EntityMetadataDTO getEntityMetadata() {
		return entityMetadata;
	}
	
	/**
	 * Método que modifica el {@link EntityMetadataDTO} asociado al wizard
	 * @param entityMetadata Nuevo {@link EntityMetadataDTO} que será configurado en el wizard
	 */
	public void setEntityMetadata(EntityMetadataDTO entityMetadata) {
		this.entityMetadata = entityMetadata;
	}
	
	/**
	 * Método que obtiene el {@link FieldGroupDTO} asociado al wizard
	 * @return El {@link FieldGroupDTO} configurado en la instancia del wizard
	 */
	public FieldGroupDTO getFieldGroup() {
		return fieldGroup;
	}
	
	/**
	 * Método que modifica el {@link FieldGroupDTO} asociado al wizard
	 * @param fieldGroup Nuevo {@link FieldGroupDTO} que será configurado en el wizard
	 */
	public void setFieldGroup(FieldGroupDTO fieldGroup) {
		this.fieldGroup = fieldGroup;
	}
	
	/**
	 * Método que obtiene el {@link PrivilegeDTO} asociado al wizard
	 * @return El {@link PrivilegeDTO} configurado en la instancia del wizard
	 */
	public PrivilegeDTO getPrivilege() {
		return privilege;
	}
	
	/**
	 * Método que modifica el {@link PrivilegeDTO} asociado al wizard
	 * @param privilege Nuevo {@link PrivilegeDTO} que será configurado en el wizard
	 */
	public void setPrivilege(PrivilegeDTO privilege) {
		this.privilege = privilege;
	}
}