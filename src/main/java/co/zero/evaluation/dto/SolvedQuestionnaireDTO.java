//=======================================================================
// ARCHIVO SolvedQuestionnaireDTO.java
// FECHA CREACIÓN: 10/05/2011
//=======================================================================
package co.zero.evaluation.dto;

import co.zero.common.dto.EntityDTO;

/**
 * Clase que permite agrupar todas las respuestas dadas en un cuestionario 
 * @author Hernán Tenjo
 * @version 1.0
 */
public class SolvedQuestionnaireDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Individuo que realizó la evaluación
	private EvaluatorDTO evaluator;
	//Relacion que se está evaluando con el cuestionario
	private RelationDTO relation;
	//Atributo utilitario que permite determinar si todas las preguntas
	//del cuestionario han sido resueltas
	private boolean solved;
	//Atributo que permite determinar si el solvedQuestionnaire es de tipo social
	private boolean social;
	//Última página del cuestionario que el evaluador ha resuelto
	private int solvedPage;
	//Última página del cuestionario que el evaluador ha visitado
	private int navigationPage;

	// Tiempo restante para contestar la evaluacion
	private Integer availableTime; 
	
	/**
	 * Metodo que permite obtener la relación que se está evaluando
	 * @return La relación evaluada
	 */
	public RelationDTO getRelation() {
		return relation;
	}

	/**
	 * Método que permite modificar la relación que se está evaluando
	 * @param relation La nueva relación que se está evaluando
	 */
	public void setRelation(RelationDTO relation) {
		this.relation = relation;
	}
	
	/**
	 * Método que permite obtener el evaluador que está solucionando el cuestionario
	 * @return El evaluador que está a cargo del cuestionario
	 */
	public EvaluatorDTO getEvaluator() {
		return evaluator;
	}

	/**
	 * Método que permite modificar el evaluador que está solucionando el cuestionario
	 * @param evaluator El nuevo evaluador responsable del cuestionario
	 */
	public void setEvaluator(EvaluatorDTO evaluator) {
		this.evaluator = evaluator;
	}

	/**
	 * Método que permite determinar si el cuestionario ya ha sido resuelto en su totalidad
	 * @return True si el cuestionario ya fue resuelto, False de lo contrario
	 */
	public boolean isSolved() {
		return solved;
	}

	/**
	 * Método que permite modificar el estado terminado de un cuestionario
	 * @param solved True si el cuestionario ya fue resuelto, False de lo contrario
	 */
	public void setSolved(boolean solved) {
		this.solved = solved;
	}

	/**
	 * Método que permite determinar si el {@link SolvedQuestionnaireDTO} es de tipo social
	 * @return True si el cuestionario es de tipo social, false de lo contrario
	 */
	public boolean isSocial() {
		return social;
	}

	/**
	 * Método que permite modificar el estado social del cuestionario
	 * @param social True si se desea que el cuestionario sea de tipo social, false de lo contrario
	 */
	public void setSocial(boolean social) {
		this.social = social;
	}
	
	/**
	 * Método que permite obtener la última página del cuestionario que ha solucionando el evaluador
	 * @return La última página del cuestionario que resolvió el evaluador
	 */
	public int getSolvedPage() {
		return solvedPage;
	}
	
	/**
	 * Método que permite modificar la última página del cuestionario que ha solucionando el evaluador
	 * @param solvedPage La nueva página resuelta del cuestionario
	 */
	public void setSolvedPage(int solvedPage) {
		this.solvedPage = solvedPage;
	}
	
	/**
	 * Método que permite obtener la última página del cuestionario visitada por el evaluador
	 * @return El indice de la última página visitada por el evaluador
	 */
	public int getNavigationPage() {
		return navigationPage;
	}

	/**
	 * Método que permite modificar la última página del cuestionario visitada por el evaluador
	 * @param navigationPage La nueva página visitada por el evaluador
	 */
	public void setNavigationPage(int navigationPage) {
		this.navigationPage = navigationPage;
	}

	public Integer getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(Integer availableTime) {
		this.availableTime = availableTime;
	}
	
	
}