//=======================================================================
// ARCHIVO EvaluationTemplateDTO.java
// FECHA CREACIÓN: 23/06/2011
//=======================================================================
package co.zero.evaluation.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.evaluation.EvaluationType;
import co.zero.common.validator.GenericValidator;
import co.zero.hcm.dto.CompanyDTO;

/**
 * Clase que representa la plantilla de una Evaluación del Módulo Evaluaciones
 * La plantilla funciona agrupando aquellos {@link Question} preexistentes de una
 * evaluación anterior 
 * @author Hernán Tenjo
 * @version 1.0
 */
public class EvaluationTemplateDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	
	//Empresa a la que pertenece la plantilla
	private CompanyDTO company;
	//Tipo de la evaluación para la que aplica la plantilla
	private EvaluationType type;
	//Nombre representativo de la evaluacion
	private String name;
	//Descripción corta del propósito de la evaluación
	private String description;
	//Preguntas predeterminadas de la plantilla
	private Set<QuestionDTO> questions = new LinkedHashSet<QuestionDTO>();
	
	/**
	 * Metodo que permite obtener la compañía a la que pertenece la evaluación 
	 * @return La compañía a la que pertenece la evaluación
	 */
	public CompanyDTO getCompany() {
		return company;
	}

	/**
	 * Metodo que permite modificar la compañía a la que pertenece la evaluación
	 * @param company La nueva compañía asociada a la evaluación
	 */
	public void setCompany(CompanyDTO company) {
		this.company = company;
	}

	/**
	 * Metodo que permite obtener el tipo de la evaluación de la plantilla
	 * @return El tipo de la evaluación de la plantilla 
	 */
	public EvaluationType getType() {
		return type;
	}

	/**
	 * Método que permite obtener el tipo de la evaluación de la plantilla
	 * @param type El tipo de la evaluación de la plantilla
	 */
	public void setType(EvaluationType type) {
		this.type = type;
	}

	/**
	 * Método que permite obtener el nombre de la evaluación de la plantilla
	 * @return El texto representativo de la plantilla
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo que permite modificar el nombre de la plantilla
	 * @param name El nuevo texto que servirá de nombre de la plantilla
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Método que permite obtener la descripción de la plantilla
	 * @return La descripción registrada de la plantilla
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Método que permite modificar la descripción de la plantilla
	 * @param description El nuevo texto que servirá de descripción de la plantilla
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Método que permite obtener las preguntas predeterminadas de la plantilla
	 * @return El conjunto de preguntas predeterminadas de la plantilla
	 */
	public Set<QuestionDTO> getQuestions() {
		return questions;
	}

	/**
	 * Método que permite modificar el conjunto de preguntas predeterminadas de la plantilla
	 * @param questions El nuevo conjunto de preguntas predeterminadas
	 */
	public void setQuestions(Set<QuestionDTO> questions) {
		this.questions = questions;
	}
	
	/**
	 * Método que permite agregar una pregunta a la plantilla
	 * @param question La pregunta que se desea agregar
	 */
	public void addQuestion(QuestionDTO question){
		if(!GenericValidator.isValidCollection(questions, 0)){
			questions = new LinkedHashSet<QuestionDTO>();
		}
		
		questions.add(question);
	}
}