/**
 * 
 */
package co.zero.evaluation.dto;

import co.zero.common.dto.EntityDTO;

/**
 * @author Hernán Tenjo
 */
public abstract class ResponseDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Agrupa todas las respuestas provenientes del mismo cuestionario 
	protected SolvedQuestionnaireDTO solvedQuestionnaire;
	//Pregunta que responde esta entidad
	protected QuestionDTO question;

	/**
	 * Método que permite obtener el cuestionario al que pertenece la respuesta
	 * @return El cuestionario al que pertenece la respuesta
	 */
	public SolvedQuestionnaireDTO getSolvedQuestionnaire() {
		return solvedQuestionnaire;
	}

	/**
	 * Método que permite modificar el cuestionario al que pertenece la respuesta
	 * @param solvedQuestionnaire El nuevo cuestionario al que será relacionada la respuesta
	 */
	public void setSolvedQuestionnaire(SolvedQuestionnaireDTO solvedQuestionnaire) {
		this.solvedQuestionnaire = solvedQuestionnaire;
	}

	/**
	 * Método que permite obtener la pregunta que responde esta entidad
	 * @return La pregunta relacionada con la respuesta dada
	 */
	public QuestionDTO getQuestion() {
		return question;
	}

	/**
	 * Método que permite modificar la pregunra que responde esta entidad
	 * @param question La nueva pregunta relacionada con la respuesta dada
	 */
	public void setQuestion(QuestionDTO question) {
		this.question = question;
	}
}
