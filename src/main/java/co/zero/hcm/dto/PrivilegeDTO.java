//=======================================================================
// ARCHIVO PrivilegeDTO.java
// FECHA CREACIÓN: Marzo 24, 2010
//=======================================================================
package co.zero.hcm.dto;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.PrivilegeLevel;

/**
 * Clase que modela las funcionalidades que se pueden otorgar a los
 * diferentes roles (p.e. Listar empleados)
 * @author Hernán Tenjo
 * @version 1.0
 */
public class PrivilegeDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//El nombre descriptivo del privilegio 
	private String name;
	//La descripcion sobre la funcionalidad del privilegio
	private String description;
	//Código alfanumerico que identifica al privilegio
	private String code;
	//Nivel de accion que tiene el privilegio
	private PrivilegeLevel level;
	
	/**
	 * Obtiene el nombre descriptivo del privilegio
	 * @return El nombre del privilegio
	 */	
	public String getName() {
		return name;
	}

	/**
	 * Modifica el nombre asignado al privilegio
	 * @param name El nuevo nombre del privilegio
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Obtiene el identificador secundario del privilegio
	 * @return El codigo asociado al privilegio
	 */	
	public String getCode() {
		return code;
	}

	/**
	 * Permite modificar el codigo asociado al privilegio
	 * @param code El nuevo código a asociar 
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Breve descripcion de la funcionalidad del privilegio
	 * @return La descripcion del privilegio
	 */	
	public String getDescription() {
		return description;
	}

	/**
	 * Permite modificar la descripcion del privilegio
	 * @param description La nueva descripcion del privilegio
	 */
	public void setDescription(String description) {
		this.description = description;
	}	
	
	/**
	 * Permite obtener el nivel del privilegio
	 * @return El nivel del privilegio
	 */
	public PrivilegeLevel getLevel() {
		return level;
	}

	/**
	 * Permite modificar el nivel del privilegio
	 * @param level El nuevo nivel a ser asignado
	 */
	public void setLevel(PrivilegeLevel level) {
		this.level = level;
	}
}