//=======================================================================
// ARCHIVO CompanyDTO.java
// FECHA CREACIÓN: Oct 1, 2009
//=======================================================================
package co.zero.hcm.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Bean que contiene los atributos requeridos de una {@link CompanyDTO}
 * por la vista
 * @author Hernán Tenjo
 * @version 1.0
 */
public class CompanyDTO extends HcmEntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Modulos que tiene configurados una compañía
	private List<ModuleDTO> modules = new ArrayList<ModuleDTO>();
	//Atributos duplicados de los extrafields, requeridos por 
	//algunos módulos para poder tener acceso directo a la informacion
	private String name;

	/**
	 * Metodo que permite obtener los módulos que tiene
	 * configurado la compañía 
	 * @return Los módulos configurados para la compañía
	 */
	public List<ModuleDTO> getModules() {
		return modules;
	}
	
	/**
	 * Metodo que permite modificar los módulos asignados a la compañía
	 * @param modules La nueva lista de modulos asociados a la compañía
	 */
	public void setModules(List<ModuleDTO> modules) {
		this.modules = modules;
	}
	
	/**
	 * Metodo que permite agregar un nuevo módulo a la
	 * lista de modulos configurados para la empresa
	 * @param module Nuevo módulo que tendrá la compañía
	 */
	public void addModule(ModuleDTO module){
		if(modules == null){
			modules = new ArrayList<ModuleDTO>();
		}
		
		modules.add(module);
	}
		
	/**
	 * Metodo que permite asignar el nombre del extrafield
	 * que contiene el nombre de la compañía
	 * @return El nombre del extrafield que contiene la info
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo que permite modificar el nombre del extrafield
	 * que contiene el nombre de la compañía
	 * @param name El nuevo nombre del extrafield
	 * que contendrá la información requerida
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * @see co.zero.hcm.dto.EntityDTO#toString()
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder(super.toString());
		s.append(this.getExtrafields());		
		return s.toString();
	}
}