//=======================================================================
// ARCHIVO EmployeeLanguage.java
// FECHA CREACIÓN: 11/05/2012
//=======================================================================
package co.zero.hcm.dto;


/**
 * Bean que contiene los atributos requeridos en la vista de un {@link EmployeeLanguageDTO} 
 * @author Hernán Tenjo
 * @version 1.0
 */
public class EmployeeLanguageDTO extends HcmEntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Nombre del lenguaje que maneja el empleado
	private String name;
	//% de dominio en lectura
	private double readLevel;
	//% de dominio en escritura
	private double writeLevel;
	//% de dominio hablado
	private double speakLevel;
	//Empleado que maneja el idioma
	private EmployeeDTO employee;
	
	/**
	 * Método que obtiene el empleado que maneja el idioma
	 * @return El emplado dueño de la entidad
	 */
	public EmployeeDTO getEmployee() {
		return employee;
	}

	/**
	 * Método que modifica al empleado que maneja el idioma
	 * @param employee El nuevo empleado dueño de la entidad
	 */
	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}
	
	/**
	 * Método que obtiene el nombre del idioma que maneja el empleado
	 * @return El nombre configurado para el idioma
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Método que modifica el nombre del idioma que maneja el empleado
	 * @param name El nuevo nombre que será asignado al idioma
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Método que obtiene el nivel de lectura del empleado en el idioma
	 * @return Numero que identifica el nivel de lectura del empleado p.e. 100%
	 */
	public double getReadLevel() {
		return readLevel;
	}
	
	/**
	 * Método que modifica el nivel de lectura del empleado en el sistema
	 * @param readLevel Nuevo valor que identifica el nivel del lectura del empleado
	 */
	public void setReadLevel(double readLevel) {
		this.readLevel = readLevel;
	}
	
	/**
	 * Método que obtiene el nivel de escritura del empleado en el idioma
	 * @return Número que identifica el nivel de escritura del empleado p.e. 100%
	 */
	public double getWriteLevel() {
		return writeLevel;
	}
	
	/**
	 * Método que modifica el nivel de lectura del empleado en el sistema
	 * @param writeLevel Nuevo valor que identifica el nivel de escritura del empleado
	 */
	public void setWriteLevel(double writeLevel) {
		this.writeLevel = writeLevel;
	}
	
	/**
	 * Método que obtiene el nivel hablado del empleado en el idioma
	 * @return Número que identifica el nivel de escritura del empleado p.e. 50%
	 */
	public double getSpeakLevel() {
		return speakLevel;
	}
	
	/**
	 * Método que modifica el nivel hablado del empleado en el sistema
	 * @param speakLevel Nuevo valor que identifica el nivel hablado del empleado
	 */
	public void setSpeakLevel(double speakLevel) {
		this.speakLevel = speakLevel;
	}
}