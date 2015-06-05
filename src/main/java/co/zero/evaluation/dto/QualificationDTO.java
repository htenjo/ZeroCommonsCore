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
public class QualificationDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Nombre del elemento calificable
	private String name;
	//Breve descripción del elemento calificable
	private String description;
	//No siempre el nombre es suficiente para describir en la vista al qualification
	//eventualmente se requieren estilos y cosas adicionales que no se deben mostrar en los
	//Reportes. Este atributo permite almacenar este tipo de información
	private String label;
	//Texto corto que identifica a la competencia (Especialmente util en reportes)
	private String code;
	//Permite la ordenación de las competencias, especialmente util en los reportes
	private int priority;
	//Permite catalogar una misma competencia en diferentes niveles
	private int level;
	//Nombre representativo para el nivel de la competencia
	private String levelName;
	//Evaluación a la que pertenece el elemento calificable
	private EvaluationDTO evaluation;
	//En caso de ser requerido, el grupo al que pertenece el elemento
	private QualificationGroupDTO group;
		
	/**
	 * Método que permite obtener el nombre del elemento calificable
	 * @return El nombre configurado para la entidad
	 */
	public String getName() {
		return name;
	}

	/**
	 * Método que permite modificar el nombre del elemento calificable
	 * @param name El nuevo nombre que será asignado al elemento calificable 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Método que permite obtener la descripción del elemento calificable
	 * @return La descripción configurada para la entidad
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Metodo que permite modificar la descripción del elemento calificable
	 * @param description El texto que será relacionado como la nueva descripción
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Método que permite obtener la evaluacion a la que pertenece el {@link QualificationDTO}
	 * @return La evaluación configurada a la que pertenece el {@link QualificationDTO}
	 */
	public EvaluationDTO getEvaluation() {
		return evaluation;
	}

	/**
	 * Método que permite modificar la evaluación a la que pertenece el {@link QualificationDTO}
	 * @param evaluation La nueva evaluación a la que será asociado el {@link QualificationDTO}
	 */
	public void setEvaluation(EvaluationDTO evaluation) {
		this.evaluation = evaluation;
	}

	/**
	 * Método que permite obtener el grupo al que pertenece el {@link QualificationDTO}
	 * @return Si se encuentra configurado, el grupo al que pertenece el {@link QualificationDTO}
	 */
	public QualificationGroupDTO getGroup() {
		return group;
	}

	/**
	 * Método que permite modificar el grupo al que pertence el {@link QualificationDTO}
	 * @param group EL nuevo grupo al que será asociado el {@link QualificationDTO}
	 */
	public void setGroup(QualificationGroupDTO group){
		this.group = group;
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
	 * Método que permite obtener la prioridad de la competencia
	 * @return La prioridad configurada para la competencia
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Método que permite modificar la prioridad de la competencia
	 * @param priority Nueva prioridad de la competencia
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * Método que permite obtener el nivel de la competencias
	 * @return El nivel que ha sido asociado a la competencia
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Método que permite modificar el nivel de la competencia
	 * @param level El nuevo nivel que será asignado a la competencia
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Método que permite obtener el código de la competencia
	 * @return El código asignado a la competencia
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Método que permite modificar el código de la competencias
	 * @param code El nuevo código de la competencia
	 */
	public void setCode(String code) {
		this.code = code;
	}
	

	/**
	 * Método que obtiene el nombre del nivel de la competencia
	 * @return El nombre del nivel de la competencia
	 */
	public String getLevelName() {
		return levelName;
	}

	/**
	 * Método que modifica el nombre del nivel de la competencia
	 * @param levelName El nuevo nombre para el nivel de la competencia
	 */
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s [%s]", super.toString(), this.getName());
	}
}