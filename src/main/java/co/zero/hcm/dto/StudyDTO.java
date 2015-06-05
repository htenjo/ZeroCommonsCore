package co.zero.hcm.dto;

import java.util.Date;


public class StudyDTO extends HcmEntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Empleado al que pertenece el estudio realizado
	private EmployeeDTO employeeDTO;
	//Descripción del estudio realizado por el empleado
	private String description;
	//Nombre del titulo del estudio
	private String name;
	//Fecha de inicio del estudio
	private Date startDate;
	//Fecha de finalización del estudio
	private Date endDate;
	
	/**
	 * Metodo que permite obtener el empleado asociado e un estido
	 * @return el empleado asociado al estudio
	 */
	public EmployeeDTO getEmployeeDTO() {
		return employeeDTO;
	}
	/**
	 * Metodo que permite modificar el empleado asociado a un estudio
	 * @param employeeDTO el empleado para modificar
	 */
	public void setEmployeeDTO(EmployeeDTO employeeDTO) {
		this.employeeDTO = employeeDTO;
	}
	/**
	 * Metodo que permite obtener la descripcion asociada a un estudio
	 * @return la descripcion del estudio
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Metodo que permite modificar la descripcion asociada a un estudio
	 * @param description la descripcion para modificar
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Metodo que permite obtener el titulo del estudio
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * Metodo que permite modificar el titulo del estudio
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Metodo que permite obtener la fecha en la que se inicio el estudio
	 * @return
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * Metodo que permite modificar la fecha en la que se inicio el estudio
	 * @param startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * Metodo que permite obtener la fecha en que se finalizo el estudio
	 * @return
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * Metodo que permite modificar la fecha en que se finalizo el estudio
	 * @param endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
