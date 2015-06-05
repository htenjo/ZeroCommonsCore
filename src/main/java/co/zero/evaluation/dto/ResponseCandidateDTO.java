//=======================================================================
// ARCHIVO ResponseCandidateDTO.java
// FECHA CREACIÓN: 10/05/2011
//=======================================================================
package co.zero.evaluation.dto;

import co.zero.common.dto.EntityDTO;

/**
 * Clase que permite modelar las posibles ponderaciones que un {@link ResponseOptionDTO} 
 * puede tener sobre un {@link QuestionDTO}. Esto se presenta principalmente en el cuestionario
 * de emparejamiento, cuando una pregunta puede tener varias opciones correctas, pero en
 * diferente proporción. P.E. Matar es: (a) Lo peor del mundo (b) Un crimen (c) Un acto de maldad
 * En el ejemplo, todas las opciones pueden ser válidas para la proposición, pero unas pueden
 * ser más acertadas que otras. 
 * @author Hernán Tenjo
 * @version 1.0
 */
public class ResponseCandidateDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Pregunta a la que serán asociadas las opciones de respuesta
	private QuestionDTO question;
	//Opcion de respuesta posiblemente correcta para la pregunta relacionada
	private ResponseOptionDTO option;
	//Valor (eventualmente un %) que será tenido en cuenta paralelamente al valor
	//de la opción de respuesta
	private double value;
	
	/**
	 * Método que permite obtener la pregunta asociada a la entidad
	 * @return La pregunta configurada
	 */
	public QuestionDTO getQuestion() {
		return question;
	}

	/**
	 * Metodo que permite modificar la pregunta asociada a la entidad
	 * @param question La nueva pregunta que será asociada a la entidad
	 */
	public void setQuestion(QuestionDTO question) {
		this.question = question;
	}

	/**
	 * Metodo que permite obtener la opcion de respuesta asociada
	 * @return La opcion de respuesta configurada
	 */
	public ResponseOptionDTO getOption() {
		return option;
	}

	/**
	 * Método que permite modificar la opción de respuesta asociada
	 * @param option La nueva opción de respuesta asociada
	 */
	public void setOption(ResponseOptionDTO option) {
		this.option = option;
	}

	/**
	 * Método que permite obtener el valor de poderación de una respuesta
	 * sobre la pregunta relacionada
	 * @return El valor de ponderación configurado
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Método que permite modificar el valor de ponderación de la respuesta
	 * sobre la pregunta relacionada
	 * @param value El nuevo valor de ponderación
	 */
	public void setValue(double value) {
		this.value = value;
	}
}