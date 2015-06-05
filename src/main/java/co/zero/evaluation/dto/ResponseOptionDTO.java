//=======================================================================
// ARCHIVO ResponseOptionDTO.java
// FECHA CREACIÓN: 10/05/2011
//=======================================================================
package co.zero.evaluation.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import co.zero.common.dto.EntityDTO;

/**
 * Clase que representa a una opción de respuesta de una pregunta dada
 * @author Hernán Tenjo
 * @version 1.0
 */
public class ResponseOptionDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Texto que será mostrado en la opción a selección 
	private String label;
	//Determina si la opción no se tendrá en cuenta en lo análisis estadísticos
	private boolean notApply;
	//Valor asociado a la opción, util en los análisis estadísticos
	private double value;
	//Tipo de pregunta a la que pertenece la opción de respuesta
	private QuestionTypeDTO questionType;
	//Preguntas que dependen exclusivamente de una opción de respuesta seleccionada
	private Set<QuestionDTO> conditionalQuestion; 
			
	/**
	 * Método que permite obtener el label de la opcion de respuesta
	 * @return El texto representativo de la opción de respuesta
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Método que permite modificar el label de la opción de respuesta
	 * @param label El nuevo label que será asignado a la opción de respuesta
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Método que permite determinar si la respuesta corresponde a una opción No Aplica
	 * que no será tenida en cuenta en los análisis estadísticos
	 * @return True si la opción representa a un No Aplica, False de lo contrario
	 */
	public boolean isNotApply() {
		return notApply;
	}

	/**
	 * Método que permite modificar el estado de No Aplica de la opción de respuesta
	 * @param notApply True si se desea que la opción sea del tipo No Aplica, 
	 * False de lo contrario
	 */
	public void setNotApply(boolean notApply) {
		this.notApply = notApply;
	}

	/**
	 * Método que permite obtener el valor de la opción de respuesta
	 * @return El valor de la opción de respuesta
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Método que permite modificar el valor asociado a la opción de respuesta
	 * @param value El nuevo valor que tendrá la opción de respuesta
	 */
	public void setValue(double value) {
		this.value = value;
	}
	
	/**
	 * Metodo qu permite obtener el {@link QuestionTypeDTO} al que pertenece la entidad
	 * @return El {@link QuestionTypeDTO} propietario de la entidad
	 */
	public QuestionTypeDTO getQuestionType() {
		return questionType;
	}

	/**
	 * Metodo que permite modificar el {@link QuestionTypeDTO} al que pertence la entidad
	 * @param questionType El nuevo {@link QuestionTypeDTO} al que pertenecerá la entidad
	 */
	public void setQuestionType(QuestionTypeDTO questionType) {
		this.questionType = questionType;
	}
	
	/**
	 * Método que agrega una nueva pregunta condicional a la opcion de respuesta
	 * @param question La pregunta que se desea agregar a la opcion de respuesta
	 */
	public void addConditionalQuestion(QuestionDTO question){
		if(conditionalQuestion == null){
			conditionalQuestion = new LinkedHashSet<QuestionDTO>();
		}
		
		conditionalQuestion.add(question);
	}

	/**
	 * Métodoo que obtiene las preguntas condicionales asociadas en caso de existir
	 * @return Lista con las preguntas condicionales asociadas
	 */
	public Set<QuestionDTO> getConditionalQuestion() {
		return conditionalQuestion;
	}

	/**
	 * Método que modificar las preguntas condicionales asocidas
	 * @param conditionalQuestion Nuevo conjunto de preguntas asocidas
	 */
	public void setConditionalQuestion(Set<QuestionDTO> conditionalQuestion) {
		this.conditionalQuestion = conditionalQuestion;
	}
}