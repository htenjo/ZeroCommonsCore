//=======================================================================
// ARCHIVO FieldDTO.java
// FECHA CREACIÓN: 6/05/2010
//=======================================================================
package co.zero.hcm.dto.ui;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.ui.ComponentType;
import co.zero.hcm.dto.ExtrafieldDTO;
import co.zero.hcm.dto.ExtrafieldMetadataDTO;

/**
 * Objeto que tiene la información del campo
 * @author Hernán Tenjo
 * @version 1.0
 */
public class FieldDTO extends EntityDTO{
	//Identificador requerido para el proceso de serializacion
	private static final long serialVersionUID = 1L;
	//ExtrafieldMetadata que se está adaptando al entorno gráfico
	private ExtrafieldMetadataDTO extrafieldMD;
	//Informacion del extrafield que será mostrado
	private ExtrafieldDTO extrafield;
	//Grupo al que pertenece el campo
	private FieldGroupDTO fieldGroup;
	//Tipo del campo que se va a presentar
	private ComponentType type;
	//En caso de que el valor del field se encuentre basado en un conjunto de opciones
	private DataGroupDTO dataGroup;
	//Valor que permite gestionar el orden de aparición del campo en el fieldGroup
	private int priority;
	
	/**
	 * @return the fieldGroup
	 */
	public FieldGroupDTO getFieldGroup() {
		return fieldGroup;
	}
	
	/**
	 * @param fieldGroup the fieldGroup to set
	 */
	public void setFieldGroup(FieldGroupDTO fieldGroup) {
		this.fieldGroup = fieldGroup;
	}
	
	/**
	 * @return the type
	 */
	public ComponentType getType() {
		return type;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(ComponentType type) {
		this.type = type;
	}
	
	/**
	 * @return the extrafieldMD
	 */
	public ExtrafieldMetadataDTO getExtrafieldMD() {
		return extrafieldMD;
	}
	
	/**
	 * @param extrafieldMD the extrafieldMD to set
	 */
	public void setExtrafieldMD(ExtrafieldMetadataDTO extrafieldMD) {
		this.extrafieldMD = extrafieldMD;
	}

	/**
	 * @return the extrafield
	 */
	public ExtrafieldDTO getExtrafield() {
		return extrafield;
	}

	/**
	 * @param extrafield the extrafield to set
	 */
	public void setExtrafield(ExtrafieldDTO extrafield) {
		this.extrafield = extrafield;
	}

	/**
	 * @return the dataGroup
	 */
	public DataGroupDTO getDataGroup() {
		return dataGroup;
	}

	/**
	 * @param dataGroup the dataGroup to set
	 */
	public void setDataGroup(DataGroupDTO dataGroup) {
		this.dataGroup = dataGroup;
	}
	
	/**
	 * Método que obtiene la prioridad de aparición del campo, 
	 * siendo 0 la prioridad más baja 
	 * @return Numero que identifica la prioridad de aparición del campo
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Método que modifica la prioridad de aparición del campo
	 * @param priority Número con la prioridad de aparición del campo
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
}