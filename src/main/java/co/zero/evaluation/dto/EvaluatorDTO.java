//=======================================================================
// ARCHIVO EvaluatorDTO.java
// FECHA CREACIÓN: 9/05/2011
//=======================================================================
package co.zero.evaluation.dto;

import co.zero.common.dto.EntityDTO;
import co.zero.hcm.dto.EmployeeDTO;
import co.zero.hcm.dto.PersonDTO;

/**
 * Clase que representa a las personas que realizarán evaluaciones
 * (Esta clase representa al tipo de evaluador más básico disponible,
 * por ejemplo para realizar encuestas de clima).
 * @author Hernán Tenjo
 * @version 1.0
 */
public class EvaluatorDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Evaluación a la que pertenece el evaluador
	private EvaluationDTO evaluation;
	//Persona que está realizando las evaluaciones, no necesariamente un empleado.
	private PersonDTO person;
	//Attributo utilitario que permite determinar si un evaluador ha terminado
	//con todas las evaluaciones asignadas
	private boolean evaluationCompleted;
	
	//Atributo de utileria para indicar si el evaluador ha sido seleccionado para mandar email
	private boolean selected;
	
	/**
	 * Método que permite obtener la evaluatión a la que pertenece el evaluador
	 * @return La evaluación asociada al evaluador
	 */
	public EvaluationDTO getEvaluation() {
		return evaluation;
	}

	/**
	 * Método que permite modificar la evaluación a la que pertenece el evaluador
	 * @param evaluation La nueva evaluación asociada al evaluador
	 */
	public void setEvaluation(EvaluationDTO evaluation) {
		this.evaluation = evaluation;
	}

	/**
	 * Método que permite obtener la persona relacionada al evaluador
	 * @return La persona configurada para ser la evaluadora
	 */
	public PersonDTO getPerson() {
		return person;
	}

	/**
	 * Método que permite modificar la persona responsable del evaluador
	 * @param person La nueva persona que responderá como evaluador
	 */
	public void setPerson(PersonDTO person) {
		this.person = person;
	}

	/**
	 * Método que permite determinar si el evaluador ha terminado con todas las evaluaciones
	 * @return True si el evaluador ha completado todas sus evaluaciones, false de lo contrario
	 */
	public boolean isEvaluationCompleted() {
		return evaluationCompleted;
	}

	/**
	 * Metodo que permite modificar si el evaluador ha acabado con todas las evaluaciones asignadas
	 * @param evaluationCompleted El nuevo estado de terminación para el empleado
	 */
	public void setEvaluationCompleted(boolean evaluationCompleted) {
		this.evaluationCompleted = evaluationCompleted;
	}

	/**
	 * Metodo que permite saber si el evaluador ha sido elegido para mandar correo
	 * 
	 * @return
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * Metodo que permite modificar si el evaluador se elige para envio de correos
	 * 
	 * @param selected
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	/**
	 * Método que permite determinar si la persona que está evaluando es un empleado
	 * @return True si el evaluador es un empleado, False de lo contrario
	 */
	public boolean isEvaluatorEmployee(){
		return person instanceof EmployeeDTO;
	}
	
	/**
	 * Método que permite obtener la persona del evaluador convertida en empleado si es el caso
	 * @return El empleado asociado si corresponde, null de lo contrario (Se deberá usar getPerson en tal caso)
	 */
	public EmployeeDTO getEvaluatorPersonAsEmployee(){
		if(isEvaluatorEmployee()){
			return (EmployeeDTO)person;
		}else{
			return null;
		}
	}
}