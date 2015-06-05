//=======================================================================
// ARCHIVO DivisionDTO.java
// FECHA CREACIÓN: Oct 1, 2009
//=======================================================================
package co.zero.hcm.dto;

import org.apache.commons.lang.StringUtils;

import co.zero.common.constant.GenericConstants;



/**
 * Bean que contiene los atributos requeridos en la vista 
 * de un {@link DivisionDTO} 
 * @author Hernán Tenjo
 * @version 1.0
 */
public class DivisionDTO extends HcmEntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Compañía a la que pertenece la division
	private CompanyDTO company;
	//Division padre de esta division
	private DivisionDTO parent;
	//Atributos duplicados de los extrafields, requeridos por 
	//algunos módulos para poder tener acceso directo a la informacion
	private String name;
	//Atributo util que permite gestionar las jerarquias de las divisiones
	private String position;
	
	/**
	 * Permite obtener la compañía a la que pertenece la division
	 * @return La compañía solicitada
	 */
	public CompanyDTO getCompany() {
		return company;
	}

	/**
	 * Permite modificar la compañía a la que pertenece la divisio
	 * @param company La nueva compañía a la que pertenecerá la division
	 */
	public void setCompany(CompanyDTO companyDTO) {
		this.company = companyDTO;
	}
	

	/**
	 * Metodo que permite obtener el padre (division) de esta division
	 * @return La division de la que depende esta division, 
	 * null si la division no tiene padre
	 */
	public DivisionDTO getParent() {
		return parent;
	}

	/**
	 * Metodo que permite modificar el padre de la division
	 * @param parent La nueva division a ser asignada como padre
	 */
	public void setParent(DivisionDTO parent) {
		this.parent = parent;
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
	 * @param nameParameter El nuevo nombre del extrafield
	 * que contendrá la información requerida
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Metodo que permite obtener la posición jerarquica de la division
	 * @return La posición asignada a la division
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * Metodo que permite modificar la posicion jerarquica de la division
	 * @param position La nueva posición que se asignará a la division
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
	 * Metodo que permite determinar el nivel jerarquico de la división
	 * p.e. Si el position de la division es 1.2.4.2 el nivel = 4
	 * @return Nivel asociado a la posicion de la division
	 */
	public int getLevel(){
		return StringUtils.split(position, GenericConstants.DOT).length;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s [%s]", super.toString(), this.getName());
	}
}