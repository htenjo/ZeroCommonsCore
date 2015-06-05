//=======================================================================
// ARCHIVO ModuleDTO.java
// FECHA CREACIÓN: Oct 6, 2009
//=======================================================================
package co.zero.hcm.dto;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.ModuleType;

/**
 * Bean que contiene los atributos requeridos en la vista 
 * de un {@link ModuleDTO} 
 * @author Hernán Tenjo
 * @version 1.0
 */
public class ModuleDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Nombre del módulo, debe ser preferiblemente único por módulo
	private ModuleType name;
	//Breve descripción del proposito del módulo
	private String description;
	
	/**
	 * Permite obtener el nombre del módulo
	 * @return El nombre característico del módulo
	 */
	public ModuleType getName() {
		return name;
	}
	
	/**
	 * Permite modificar el nombre del módulo
	 * @param name El nuevo nombre del módulo
	 */
	public void setName(ModuleType name) {
		this.name = name;
	}
	
	/**
	 * Permite obtener una breve descripcion del 
	 * proposito o la funcionalidad del módulo
	 * @return La descripción del módulo
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Permite modificar la descripción del módulo
	 * @param description La nueva cadena que describe al módulo
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/*
	 * (non-Javadoc)
	 * @see co.zero.hcm.dto.EntityDTO#toString()
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder(super.toString());
		s.append("[name=");
		s.append(this.getName());
		s.append("][description=");
		s.append(this.getDescription());
		s.append("]");
		return s.toString();
	}
}

