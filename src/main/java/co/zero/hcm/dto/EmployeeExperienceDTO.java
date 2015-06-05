//=======================================================================
// ARCHIVO EmployeeExperience.java
// FECHA CREACIÓN: 14/05/2012
//=======================================================================
package co.zero.hcm.dto;

import java.util.Date;

/**
 * Clase que representa las experiencias laborales que ha tenido un empleado
 * @author Hernán Tenjo
 * @version 1.0
 */
public class EmployeeExperienceDTO extends HcmEntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	
	//Nombre del cargo o experiencia laboral que desempeñó el empleado
	private String jobName;
	//Fecha de inicio en el cargo
	private Date startDate;
	//Fecha de finalización en el cargo, null si es el cargo actual
	private Date endDate;
	//Nombre de la empresa donde laboró el empleado
	private String companyName;
	//Empleado que presentó la experiencia laboral
	private EmployeeDTO employee;
	
	/**
	 * Método que obtiene el empleado dueño de la experiencia laboral
	 * @return El emplado dueño de la entidad
	 */
	public EmployeeDTO getEmployee() {
		return employee;
	}

	/**
	 * Método que modifica al empleado dueño de la experiencia
	 * @param employee El nuevo empleado dueño de la entidad
	 */
	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}
	
	/**
	 * Método que obtiene el nombre del cargo correspondiente a la experiencia laboral
	 * @return El nombre del cargo configurado en la experiencia del empleado
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * Método que modifica el nombre del cargo que corresponde con la experiencia laboral
	 * @param jobName Nombre del cargo que será asociado a la experiencia del empleado
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * Método que obtiene la fecha en la que inicio la experiencia del empleado en el cargo
	 * @return La fecha de inicio en el cargo
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Método que modificar la fecha en la que inició la experiencia del empleado en el cargo
	 * @param startDate La nueva fecha de inicio en el cargo
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 *Método que obtiene la fecha de finalización de la experiencia del empleado en el cargo
	 * @return La fecha de finalización en el cargo, null si es el cargo actual
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Método que modifica la fecha de finalización de la experiencia del empleado en el cargo
	 * @param endDate La nueva fecha de finalización en el cargo, null si es el cargo actual
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Método que obtiene el nombre de la empresa donde laboró el empleado
	 * @return El nombre de la empresa configurado en la experiencia del empleado
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * Método que modifica el nombre de la empresa donde laboró el empleado
	 * @param companyName El nuevo nombre de la empresa donde se desepeñó el empleado
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}