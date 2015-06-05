//=======================================================================
// ARCHIVO DivisionDTO.java
// FECHA CREACIÓN: Oct 1, 2009
//=======================================================================
package co.zero.hcm.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import co.zero.common.dto.EntityDTO;



/**
 * Bean que contiene los atributos requeridos en la vista de un {@link ProcessDTO}
 *  
 * @author Youlyn Chinome
 */
public class ProcessDTO extends EntityDTO{
	//Identificador requerido para la serialización
	private static final long serialVersionUID = 1L;
	//Compañía a la que pertenece el proceso
	private CompanyDTO company;
	//Proceso padre de esta proceso
	private ProcessDTO parent;
	//Atributo util que permite gestionar las jerarquias de los procesos
	private String position;
	//Nombre del proceso
	private String name;
	//Id alfanumerico unico por compania
	private String code;
	//Lista de los empleados asignados a este proceso
	private Set<EmployeeDTO> employees = new LinkedHashSet<EmployeeDTO>();
	
	/**
	 * Metodo que permite obtener el nombre del proceso
	 * @return El nombre del proceso
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo que permite modificar el nombre del proceso
	 * @param name El nuevo nombre que tendrá el proceso
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Permite obtener la compañía a la que pertenece el proceso
	 * @return La compañía solicitada
	 */
	public CompanyDTO getCompany() {
		return company;
	}

	/**
	 * Permite modificar la compañía a la que pertenece el proceso
	 * @param company La nueva compañía a la que pertenecerá el proceso
	 */
	public void setCompany(CompanyDTO company) {
		this.company = company;
	}

	/**
	 * Metodo que permite obtener el padre (proceso) de este proceso
	 * @return El proceso del que depende este proceso, 
	 * null si el proceso no tiene padre
	 */
	public ProcessDTO getParent() {
		return parent;
	}

	/**
	 * Metodo que permite modificar el padre del proceso
	 * @param parent El nuevo proceso a ser asignado como padre
	 */
	public void setParent(ProcessDTO parent) {
		this.parent = parent;
	}

	/**
	 * Metodo que permite obtener la posición jerarquica del proceso
	 * @return La posición asignada al proceso
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * Metodo que permite modificar la posicion jerarquica del proceso
	 * @param position La nueva posición que se asignará al proceso
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
	 * Método que agrega un empleado para estar relacionado con el proceso
	 * @param employee El empleado que se desea relacionar
	 */
	public void addEmployee(EmployeeDTO employee){
		if(employees == null){
			employees = new LinkedHashSet<EmployeeDTO>();
		}
		
		employees.add(employee);
	}

	/**
	 * Método que obtiene los empleados que pertenecen al proceso
	 * @return Conjunto de los empleados que pertenecen al proceso
	 */
	public Set<EmployeeDTO> getEmployees() {
		return employees;
	}

	/**
	 * Método que modifica los empleados que pertenecen al proceso
	 * @param employees El nuevo conjunto de los empleados que pertenecen al proceso
	 */
	public void setEmployees(Set<EmployeeDTO> employees) {
		this.employees = employees;
	}
	
}