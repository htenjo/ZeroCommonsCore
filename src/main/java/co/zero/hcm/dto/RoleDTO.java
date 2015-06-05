//=======================================================================
// ARCHIVO RoleDTO.java
// FECHA CREACIÓN: Oct 1, 2009
//=======================================================================
package co.zero.hcm.dto;

import java.util.HashSet;
import java.util.Set;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.RoleLevel;

/**
 * Clase que reune la información básica de un rol en el sistema
 * @author Hernán Tenjo
 * @version 1.0
 */
public class RoleDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Nombre del rol
	private String name;
	//Breve descripción de la funcionalidad del rol
	private String description;
	//Modulo al que pertenece el rol
	private ModuleDTO module;
	//Privilegios asociados al rol
	private Set<PrivilegeDTO> privileges = new HashSet<PrivilegeDTO>();	
	//Nivel del rol
	private RoleLevel level;
	
	/**
	 * Permite obtener el módulo en el que el rol
	 * tiene campo de acción
	 * @return El modulo al que está asociado el rol
	 */
	public ModuleDTO getModule() {
		return module;
	}

	/**
	 * Permite modificar el módulo al que se encuentra
	 * asociado el rol
	 * @param module El nuevo módulo en el que el rol
	 * se podrá desempeñar
	 */
	public void setModule(ModuleDTO module) {
		this.module = module;
	}

	/**
	 * Obtiene el nombre representativo del rol ej. ADMIN
	 * @return el nombre del rol
	 */
	public String getName() {
		return name;
	}

	/**
	 * Modifica el nombre del rol
	 * @param name Nueva cadena que representa al rol
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Obtiene la descripción del rol
	 * @return la descripción del rol
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Modifica la descripcion del rol. Esta
	 * descripción debería indicar para qué se crea
	 * el rol y cuales serían sus funcionalidades
	 * @param description la nueva descripción del rol
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

	/**
	 * Permite agregar un privilegio al role
	 * @param privilegeDTO El nuevo privilegio que sera asociado al rol
	 */
	public void addPrivilege(PrivilegeDTO privilegeDTO){
		privileges.add(privilegeDTO);
	}
	
	/**
	 * Permite obtener los privilegios asociados al rol
	 * @return Conjunto con los privilegios del rol
	 */
	public Set<PrivilegeDTO> getPrivileges() {
		return privileges;
	}

	/**
	 * Permite modificar los privilegios asociados al rol
	 * @param privileges Nuevo conjunto de privilegios asociados a rol
	 */
	public void setPrivileges(Set<PrivilegeDTO> privileges) {
		this.privileges = privileges;
	}
	
	/**
	 * Permite obtener el nivel del rol
	 * @return El nivel asociado al rol
	 */	
	public RoleLevel getLevel() {
		return level;
	}

	/**
	 * Permite modificar el nivel asociado al rol
	 * @param level El nuevo nivel a ser asociado
	 */
	public void setLevel(RoleLevel level) {
		this.level = level;
	}
}