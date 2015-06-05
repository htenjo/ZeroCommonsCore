//=======================================================================
// ARCHIVO RelationDTO.java
// FECHA CREACIÓN: 9/05/2011
//=======================================================================
package co.zero.evaluation.dto;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.evaluation.ThreesixtyRelationType;

/**
 * Clase que modela una relación entre un evaluador y un evaluado
 * en una evaluacion de 360°
 * @author Hernán Tenjo
 * @version 1.0
 */
public class RelationDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;	
	//Individuo que realizará las evaluaciones
	private EvaluatorDTO evaluator;
	//Individuo que será evaluado
	private EvaluatedDTO evaluated;
	//Tipo de relación existente entre los individuos relacionados
	private ThreesixtyRelationType type;
	//Atributo que determina si la relación ya fue evaluada 
	//completemente (El cuestionario asociado ya fue terminado)
	private boolean finished;
	
	/**
	 * Método que permite obtener el evaluador de la relación
	 * @return El evaluador configurado para la relacion
	 */
	public EvaluatorDTO getEvaluator() {
		return evaluator;
	}
	
	/**
	 * Metodo que permite obtener el evaluador de la relación
	 * @param evaluator El nuevo evaluador de la relación
	 */
	public void setEvaluator(EvaluatorDTO evaluator) {
		this.evaluator = evaluator;
	}
	
	/**
	 * Método que permite obtener el evaluado de la relación
	 * @return El evaluado configurado en la relación
	 */
	public EvaluatedDTO getEvaluated() {
		return evaluated;
	}
	
	/**
	 * Metodo que permite modificar el evaluado de la relación
	 * @param evaluated El nuevo evaluado de la relacion
	 */
	public void setEvaluated(EvaluatedDTO evaluated) {
		this.evaluated = evaluated;
	}
	
	/**
	 * Método que permite obtener el tipo de relación configurada
	 * entre el evaluador y el evaluado
	 * @return El tipo de relacion configurado entre las partes
	 */
	public ThreesixtyRelationType getType() {
		return type;
	}
	
	/**
	 * Método que permite modificar el tipo de relación configurada
	 * entre el evaluador y el evaluado
	 * @param type El nuevo tipo de relación entre las partes
	 */
	public void setType(ThreesixtyRelationType type) {
		this.type = type;
	}

	/**
	 * Método que permite determinar si la relación ya fue evaluada
	 * @return True si la relacion ya fue evaluada, False de lo contrario
	 */
	public boolean isFinished() {
		return finished;
	}

	/**
	 * Método que permite modificar la terminación de la evaluación de la relación
	 * @param finished El nuevo valor que determina si la relación ya fue evaluada
	 */
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
}