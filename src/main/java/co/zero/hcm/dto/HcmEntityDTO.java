//=======================================================================
// ARCHIVO HcmEntityDTO.java
// FECHA CREACIÓN: Sep 25, 2009
//=======================================================================
package co.zero.hcm.dto;

import java.util.HashMap;
import java.util.Map;

import co.zero.common.dto.EntityDTO;

/**
 * Interface que deben extender todos los DTOs del módulo HCM
 * Agrega la complejidad en el manejo de los extrafiels propios del módulo
 * @author Hernán Tenjo
 * @version 1.0
 */
public abstract class HcmEntityDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Para las entidades que aplique, son los campos adicionales
	//configurados por compañia, donde el key=fieldName & value=Extrafield
	protected Map<String, ExtrafieldDTO> extrafields = new HashMap<String, ExtrafieldDTO>();

	/**
	 * Metodo que permite obtener toda la información de la
	 * entidad en forma de extrafields
	 * @return La lista de extrafields con la informacion de la entidad
	 */
	public Map<String, ExtrafieldDTO> getExtrafields() {
		return extrafields;
	}

	/**
	 * Permite modificar los extrafields que pertenecen a la entidad
	 * @param extrafields La nueva lista de extrafields de la entidad
	 */
	public void setExtrafields(Map<String, ExtrafieldDTO> extrafields) {
		this.extrafields = extrafields;
	}
	
	/**
	 * Metodo que permite agregar un nuevo extrafield a la
	 * lista de extrafields de la entidad
	 * @param extrafield Nuevo extrafield a agregar 
	 */
	public void addExtrafield(ExtrafieldDTO extrafield){
		if(extrafields == null){
			extrafields =  new HashMap<String, ExtrafieldDTO>();
		}
		
		extrafields.put(extrafield.getMetadata().getFieldName(), extrafield);
	}
}