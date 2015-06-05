//=======================================================================
// ARCHIVO EmployeeDTO.java
// FECHA CREACIÓN: Oct 1, 2009
//=======================================================================
package co.zero.hcm.dto;




/**
 * Bean que contiene los atributos requeridos en la vista de un {@link EmployeeDTO} 
 * @author Hernán Tenjo
 * @version 1.0
 */
public class EmployeeDTO extends PersonDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Puesto de trabajo en el que se desempeña el empleado
	private EmploymentDTO employment;
	
	/**
	 * Método que obtiene el puesto de trabajo que ocupa el empleado en la organización
	 * @return El puesto de trabajo asociado al empleado
	 */
	public EmploymentDTO getEmployment() {
		return employment;
	}

	/**
	 * Método que modifica el puesto de trabajo que ocupa el empleado en la organización
	 * @param employment El nuevo puesto de trabajo al que se encuentra asociado el empleado
	 */
	public void setEmployment(EmploymentDTO employment) {
		this.employment = employment;
	}
}