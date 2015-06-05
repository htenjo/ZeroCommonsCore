//=======================================================================
// ARCHIVO DivisionDTO.java
// FECHA CREACIÓN: Oct 1, 2009
//=======================================================================
package co.zero.hcm.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import co.zero.common.dto.EntityDTO;



/**
 * Bean que contiene los atributos requeridos en la vista de un {@link BusinessUnitDTO}
 *  
 * @author Youlyn Chinome
 */
public class BusinessUnitDTO extends EntityDTO{
	//Identificador requerido para la serialización
	private static final long serialVersionUID = 1L;
	//Compañía a la que pertenece la unidad 
	private CompanyDTO company;
	//Unidad padre de esta unidad
	private BusinessUnitDTO parent;
	//Atributo util que permite gestionar las jerarquias de las unidades
	private String position;
	//Nombre de la unidad
	private String name;
	//Id alfanumerico unico por compania
	private String code;
	//Lista de los empleados asignados a esta unidad de negocio
	private Set<EmployeeDTO> employees = new LinkedHashSet<EmployeeDTO>();
	
	/**
	 * Metodo que permite obtener el nombre de la unidad
	 * @return El nombre de la unidad
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo que permite modificar el nombre de la unidad
	 * @param name El nuevo nombre que tendrá la unidad
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Permite obtener la compañía a la que pertenece la unidad
	 * @return La compañía solicitada
	 */
	public CompanyDTO getCompany() {
		return company;
	}

	/**
	 * Permite modificar la compañía a la que pertenece la unidad
	 * @param company La nueva compañía a la que pertenecerá la unidad
	 */
	public void setCompany(CompanyDTO company) {
		this.company = company;
	}

	/**
	 * Metodo que permite obtener el padre (unidad) de esta unidad
	 * @return La unidad de la que depende esta unidad, 
	 * null si la unidad no tiene padre
	 */
	public BusinessUnitDTO getParent() {
		return parent;
	}

	/**
	 * Metodo que permite modificar el padre de la unidad
	 * @param parent La nueva unidad a ser asignada como padre
	 */
	public void setParent(BusinessUnitDTO parent) {
		this.parent = parent;
	}

	/**
	 * Metodo que permite obtener la posición jerarquica de la unidad
	 * @return La posición asignada a la unidad
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * Metodo que permite modificar la posicion jerarquica de la unidad
	 * @param position La nueva posición que se asignará a la unidad
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * Metodo que permite obtener el id alfanumerico unico por compania
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Metodo que permite modificar el id alfanumerico unico por compania
	 * @param code Id alfanumerico unico por compania
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Método que agrega un empleado para estar relacionado con la unidad
	 * @param employee El empleado que se desea relacionar
	 */
	public void addEmployee(EmployeeDTO employee){
		if(employees == null){
			employees = new LinkedHashSet<EmployeeDTO>();
		}
		
		employees.add(employee);
	}

	/**
	 * Método que obtiene los empleados que pertenecen a la unidad
	 * @return Conjunto de los empleados que pertenecen a la unidad
	 */
	public Set<EmployeeDTO> getEmployees() {
		return employees;
	}

	/**
	 * Método que modifica los empleados que pertenecen a la unidad
	 * @param employees El nuevo conjunto de los empleados que pertenecen a la unidad
	 */
	public void setEmployees(Set<EmployeeDTO> employees) {
		this.employees = employees;
	}
	
}