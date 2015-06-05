//=======================================================================
// ARCHIVO Job.java
// FECHA CREACIÓN: Sep 18, 2009
//=======================================================================
package co.zero.hcm.dto;

import co.zero.common.dto.EntityDTO;

/**
 * Clase que representa un "Pruesto de trabajo" en la organización. Esto con el fin de poder tener
 * varios empleados asignados a un cargo, pero manteniendo la individualidad de sus relaciones
 * y responsabilidades adquiridas 
 * @author Hernán Tenjo
 * @version 1.0
 */
public class EmploymentDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Nombre del puesto de trabajo
	private String name;
	//El cargo al que pertenece el puesto de trabajo
	private JobDTO job;
	//El empleado que esta ocupando el puesto de trabajo.
	private EmployeeDTO employee;
	//Nivel del cargo, donde 1 es el mas bajo y N el más alto (Presidente, Generentes, etc)
	private int level;
	//Nombre que representa el nivel del cargo
	private String levelName;
	
	/**
	 * Metodo que permite obtener el nombre del puesto de trabajo
	 * @return El nombre del puesto de trabajo
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo que permite modificar el nombre del puesto de trabajo
	 * @param name El nuevo nombre que tendrá el puesto de trabajo
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Método que obtiene el cargo al que pertenece el puesto de trabajo
	 * @return El cargo al que pertenece el puesto de trabajo
	 */
	public JobDTO getJob() {
		return job;
	}

	/**
	 * Método que modifica el cargo al que pertenece el puesto de trabajo
	 * @param job El nuevo cargo asociado al puesto de trabajo
	 */
	public void setJob(JobDTO job) {
		this.job = job;
	}

	/**
	 * Método que obtiene el Empleado que ocupa el puesto de trabajo
	 * @return El empleado que ocupa el puesto de trabajo, null si el puesto
	 * presenta una vacante
	 */
	public EmployeeDTO getEmployee() {
		return employee;
	}

	/**
	 * Método que modifica el Empleado que ocupa el puesto de trabajo
	 * @param employee El nuevo empleado que ocupará el puesto de trabajo, null
	 * si se considera el puesto como una vacante
	 */
	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}
	
	/**
	 * Método que obtiene el nivel del cargo
	 * @return El índice que representa al nivel del cargo
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Método que modifica el nivel del cargo
	 * @param level Indice que identifica el nivel del cargo
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Método que obtiene el nombre del nivel del cargo
	 * @return Nombre que representa el nivel del cargo
	 */
	public String getLevelName() {
		return levelName;
	}

	/**
	 * @param levelName the levelName to set
	 */
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
}