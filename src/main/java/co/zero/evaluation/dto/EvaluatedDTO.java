//=======================================================================
// ARCHIVO EvaluatedDTO.java
// FECHA CREACIÓN: 9/05/2011
//=======================================================================
package co.zero.evaluation.dto;

import co.zero.common.dto.EntityDTO;
import co.zero.hcm.dto.EmployeeDTO;

/**
 * Clase que representa a un empleado evaluado en el sistema en una evaluación específica
 * @author Hernán Tenjo
 * @version 1.0
 */
public class EvaluatedDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Evaluación a la que pertenece el evaluado
	private EvaluationDTO evaluation;
	//Empleado que será evaluado en la evaluación
	private EmployeeDTO employee;
	
	/**
	 * Metodo que permite obtener la evaluación a la que pertenece el evaluado
	 * @return La evaluación a la que pertenece el evaluated
	 */
	public EvaluationDTO getEvaluation() {
		return evaluation;
	}

	/**
	 * Método que permite modificar la evaluacion a la que pertenece el evaluado
	 * @param evaluation La nueva evaluación asociada al evaluado
	 */
	public void setEvaluation(EvaluationDTO evaluation) {
		this.evaluation = evaluation;
	}

	/**
	 * Método que permite obtener el empleado asociado del evaluado
	 * @return El empleado asociado al evaluado
	 */
	public EmployeeDTO getEmployee() {
		return employee;
	}

	/**
	 * Método que permite modificar el empleado asociado del evaluado
	 * @param employee El nuevo empleado asociado al evaluado
	 */
	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}
}