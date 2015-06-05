//=======================================================================
// ARCHIVO QualificationDTO.java
// FECHA CREACIÓN: 9/05/2011
//=======================================================================
package co.zero.evaluation.dto;

import co.zero.common.dto.EntityDTO;

/**
 * Clase que modela un elemento calificable en el sistema de evaluaciones.
 * Este elemento puede ser una Competencia (360°), un Factor (ClimateDTO)
 * o cualquier otro elemento que se considere evaluable.
 * @author Hernán Tenjo
 * @version 1.0
 */
public class QualificationGroupDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Nombre del grupo de elementos de calificacion
	private String name;
	//Breve descripción del propósito del grupo
	private String description;
	//No siempre el nombre es suficiente para describir en la vista al qualification
	//eventualmente se requieren estilos y cosas adicionales que no se deben mostrar en los
	//Reportes. Este atributo permite almacenar este tipo de información
	private String label;
	//Evaluación a la que pertenece el grupo de competencias
	private EvaluationDTO evaluation;
	
	/**
	 * Metodo que permite obtener el nombre del grupo de {@link QualificationDTO}
	 * @return El nombre configurado para el grupo de {@link QualificationDTO}
	 */
	public String getName() {
		return name;
	}

	/**
	 * Método que permite modificar el nombre del grupo de {@link QualificationDTO}
	 * @param name El nuevo nombre que será asignado al grupo
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Método que permite obtener la descripción del grupo de {@link QualificationDTO}
	 * @return La descripción asociada al grupo
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Método que permite modificar la descripción del grupo de {@link QualificationDTO}
	 * @param description El nuevo texto a asociar como descripción del grupo
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	

	/**
	 * Método que permite obtener el texto representativo del {@link QualificationDTO}
	 * @return El texto que representa al {@link QualificationDTO}
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Método que permite modificar el texto representativo del {@link QualificationDTO}
	 * @param label El nuevo texto que será asociado al {@link QualificationDTO}
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * Método que obtiene la evaluación a la que pertenece el grupo de competencias
	 * @return the evaluation La evaluación asociada al grupo
	 */
	public EvaluationDTO getEvaluation() {
		return evaluation;
	}

	/**
	 * Método que modifica la evaluación a la que pertenece el grupo de competencias
	 * @param evaluation La nueva evaluación a la que será asociado el grupo de competencias
	 */
	public void setEvaluation(EvaluationDTO evaluation) {
		this.evaluation = evaluation;
	}
}