package co.zero.hcm.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import co.zero.common.dto.EntityDTO;



/**
 * Bean que contiene los atributos requeridos en la vista de un {@link ZoneDTO}
 *  
 * @author Youlyn Chinome
 */
public class ZoneDTO extends EntityDTO{
	//Identificador requerido para la serialización
	private static final long serialVersionUID = 1L;
	//Compañía a la que pertenece la zona 
	private CompanyDTO company;
	//Zona padre de esta zona
	private ZoneDTO parent;
	//Atributo util que permite gestionar las jerarquias de las zonas
	private String position;
	//Nombre de la zona
	private String name;
	//Id alfanumerico unico por compania
	private String code;
	//Lista de los empleados asignados a esta zona
	private Set<EmployeeDTO> employees = new LinkedHashSet<EmployeeDTO>();
	
	/**
	 * Metodo que permite obtener el nombre de la zona
	 * @return El nombre de la zona
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo que permite modificar el nombre de la zona
	 * @param name El nuevo nombre que tendrá la zona
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Permite obtener la compañía a la que pertenece la zona
	 * @return La compañía solicitada
	 */
	public CompanyDTO getCompany() {
		return company;
	}

	/**
	 * Permite modificar la compañía a la que pertenece la zona
	 * @param company La nueva compañía a la que pertenecerá la zona
	 */
	public void setCompany(CompanyDTO company) {
		this.company = company;
	}

	/**
	 * Metodo que permite obtener el padre (zona) de esta zona
	 * @return La zona de la que depende esta zona, 
	 * null si la zona no tiene padre
	 */
	public ZoneDTO getParent() {
		return parent;
	}

	/**
	 * Metodo que permite modificar el padre de la zona
	 * @param parent La nueva zona a ser asignada como padre
	 */
	public void setParent(ZoneDTO parent) {
		this.parent = parent;
	}

	/**
	 * Metodo que permite obtener la posición jerarquica de la zona
	 * @return La posición asignada a la zona
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * Metodo que permite modificar la posicion jerarquica de la zona
	 * @param position La nueva posición que se asignará a la zona
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
	 * Método que agrega un empleado para estar relacionado con la zona
	 * @param employee El empleado que se desea relacionar
	 */
	public void addEmployee(EmployeeDTO employee){
		if(employees == null){
			employees = new LinkedHashSet<EmployeeDTO>();
		}
		
		employees.add(employee);
	}

	/**
	 * Método que obtiene los empleados que pertenecen a la zona
	 * @return Conjunto de los empleados que pertenecen a la zona
	 */
	public Set<EmployeeDTO> getEmployees() {
		return employees;
	}

	/**
	 * Método que modifica los empleados que pertenecen a la zona
	 * @param employees El nuevo conjunto de los empleados que pertenecen a la zona
	 */
	public void setEmployees(Set<EmployeeDTO> employees) {
		this.employees = employees;
	}
	
}