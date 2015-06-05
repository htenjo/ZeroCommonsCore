package co.zero.hcm.dto;

import java.util.Date;

import co.zero.common.enumeration.Weekday;
import co.zero.common.enumeration.Workday;


public class IndustrialAccidentDTO extends HcmEntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Empleado al que pertenece el estudio realizado
	private EmployeeDTO employeeDTO;
	//Fecha en la que ocurrio el accidente laboral
	private Date accidentDate;
	//Dia de la semana en el cual ocurrio el accidente laboral
	private Weekday weekday;
	//Jornada laboral en la que ocurrio el accidente laboral
	private Workday workday;
	//Indica si el empleado se encontraba trabajando en el momento del accidente
	private boolean working;
	//Si no estaba trabajando entonces se debe indicar que actividad estaba realizando
	private String workDone;
	//Tiempo laborado antes del accidente indicado en horas y minutos
	private String timeWorkedBeforeAccident;
	//Indica si el accidente causo la muerte del empleado
	private boolean employeeDied;
	//Descripcion del accidente
	private String description;
	
	/**
	 * Obtiene el empleado que sufrio el accidente
	 * @return el empleado que sufrio el accidente
	 */
	public EmployeeDTO getEmployeeDTO() {
		return employeeDTO;
	}
	
	/**
	 * Metodod que permite modificar el empleado que sufrio el accidente
	 * @param el empleado que va a reemplazar al empleado que sufrio el accidente
	 */
	public void setEmployeeDTO(EmployeeDTO employeeDTO) {
		this.employeeDTO = employeeDTO;
	}
	
	/**
	 * Metodo que permite obtener la fecha en la que ocurrio el accidente laboral
	 * @return
	 */
	public Date getAccidentDate() {
		return accidentDate;
	}
	
	/**
	 * Metodo que permite modificar la fecha en la que ocurrio el accidente laboral
	 * @param accidentDate
	 */
	public void setAccidentDate(Date accidentDate) {
		this.accidentDate = accidentDate;
	}
	
	/**
	 * Método que permite obtener el dia de la semana en el cual ocurrio el accidente laboral
	 * @return El dia de la semana en el cual ocurrio el accidente laboral
	 */
	public Weekday getWeekday() {
		return weekday;
	}
	
	/**
	 * Método que permite modificar el dia de la semana en el cual ocurrio el accidente laboral
	 * @param El dia de la semana en el cual ocurrio el accidente laboral
	 */
	public void setWeekday(Weekday weekday) {
		this.weekday = weekday;
	}
	
	/**
	 * Método que permite obtener la jornada laboral en la que ocurrio el accidente laboral
	 * @return La jornada laboral en la que ocurrio el accidente laboral
	 */
	public Workday getWorkday() {
		return workday;
	}
	
	/**
	 * Método que permite modificar la jornada laboral en la que ocurrio el accidente laboral
	 * @param La jornada laboral en la que ocurrio el accidente laboral
	 */
	public void setWorkday(Workday workday) {
		this.workday = workday;
	}
	
	/**
	 * Metodo que permite determinar si el empleado se encontraba trabajando en el momento del accidente
	 * @return true si el empleado se encontraba trabajando en el momento del accidente, false de lo contrario
	 */
	public boolean isWorking() {
		return working;
	}
	
	/**
	 * Metodo que permite modificar si el empleado se encontraba trabajando en el momento del accidente
	 * @param Valor que determina si el empleado se encontraba trabajando en el momento del accidente
	 */
	public void setWorking(boolean working) {
		this.working = working;
	}
	
	/**
	 * Metodo que permite Obtener la descripcion de la actividad estaba que realizando el empleado
	 * @return actividad estaba que realizando el empleado
	 */
	public String getWorkDone() {
		return workDone;
	}
	
	/**
	 * Metodo que permite modificar la descripcion de la actividad estaba que realizando el empleado 
	 * @param descripcion de la actividad estaba que realizando el empleado
	 */
	public void setWorkDone(String workDone) {
		this.workDone = workDone;
	}
	
	/**
	 * Metodo que permite Obtener el tiempo laborado antes del accidente indicado en horas y minutos
	 * @return tiempo laborado antes del accidente indicado en horas y minutos
	 */
	public String getTimeWorkedBeforeAccident() {
		return timeWorkedBeforeAccident;
	}
	
	/**
	 * Metodo que permite modificar el tiempo laborado antes del accidente indicado en horas y minutos 
	 * @param tiempo laborado antes del accidente indicado en horas y minutos
	 */
	public void setTimeWorkedBeforeAccident(String timeWorkedBeforeAccident) {
		this.timeWorkedBeforeAccident = timeWorkedBeforeAccident;
	}
	
	/**
	 * Metodo que permite determinar si el accidente causo la muerte del empleado
	 * @return true si el accidente causo la muerte del empleado, false de lo contrario
	 */
	public boolean isEmployeeDied() {
		return employeeDied;
	}
	
	/**
	 * Metodo que permite modificar si el accidente causo la muerte del empleado
	 * @param Valor que determina si el accidente causo la muerte del empleado
	 */
	public void setEmployeeDied(boolean employeeDied) {
		this.employeeDied = employeeDied;
	}

	/**
	 * Metodo que permite obtener la descripcion del accidente
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Metodod que permite modificar la descripcion del accidente
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
