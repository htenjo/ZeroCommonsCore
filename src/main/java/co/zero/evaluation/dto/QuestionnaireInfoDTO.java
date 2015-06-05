//=======================================================================
// ARCHIVO QuestionnaireInfo.java
// FECHA CREACIÓN: 2013/02/21
//=======================================================================
package co.zero.evaluation.dto;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.evaluation.ThreesixtyRelationType;

/**
 * DTO con la información plana del empleado en una evaluación
 * @author Hernán Tenjo
 * @version 1.0
 */
public class QuestionnaireInfoDTO extends EntityDTO{
	private static final long serialVersionUID = 1L;
	private long solvedQuestionnaireId;
	private long companyId;
	private long evaluationId;
	//================================  Información requerida para el evaluador (eva) ================================
	private long evaluatorId;
	private long evaDivisionId;
	private String evaDivisionName;
	private String evaDivisionPosition;
	private long evaJobId;
	private String evaJobName;
	private long evaEmploymentId;
	private String evaEmploymentName;
	private int evaEmploymentLevel;
	private String evaEmploymentLevelName;
	private long evaPersonId;
	private String evaFirstName;
	private String evaMiddleName;
	private String evaLastName;
	private String evaMotherMaidenName;
	//================================  Información requerida para la relación (rel) ================================
	private ThreesixtyRelationType relationType;
	//================================  Información requerida para el evaluado (evd) ================================
	private Long evaluatedId;
	private Long evdDivisionId;
	private String evdDivisionName;
	private String evdDivisionPosition;
	private Long evdJobId;
	private String evdJobName;
	private Long evdEmploymentId;
	private String evdEmploymentName;
	private Integer evdEmploymentLevel;
	private Long evdPersonId;
	private String evdEmploymentLevelName;
	private String evdFirstName;
	private String evdMiddleName;
	private String evdLastName;
	private String evdMotherMaidenName;
	
	/**
	 * Método que obtiene el identificador de la division a la que pertenece el evaluador
	 * @return the evaDivisionId
	 */
	public long getEvaDivisionId() {
		return evaDivisionId;
	}

	/**
	 * Modifica el id de la division a la que pertenece el evaluador
	 * @param evaDivisionId the evaDivisionId to set
	 */
	public void setEvaDivisionId(long evaDivisionId) {
		this.evaDivisionId = evaDivisionId;
	}

	/**
	 * Método que obtiene el nombre de la division a la que pertenece el evaluador
	 * @return the evaDivisionName
	 */
	public String getEvaDivisionName() {
		return evaDivisionName;
	}

	/**
	 * Método que modifica el nombre de la division del evaluador
	 * @param evaDivisionName the evaDivisionName to set
	 */
	public void setEvaDivisionName(String evaDivisionName) {
		this.evaDivisionName = evaDivisionName;
	}

	/**
	 * Método que obtiene la posición de la division del evaluador
	 * @return the evaDivisionPosition
	 */
	public String getEvaDivisionPosition() {
		return evaDivisionPosition;
	}
	
	/**
	 * Método que modifica la posición de la division del evaluador
	 * @param evaDivisionPosition the evaDivisionPosition to set
	 */
	public void setEvaDivisionPosition(String evaDivisionPosition) {
		this.evaDivisionPosition = evaDivisionPosition;
	}

	/**
	 * Método que obtiene el identificador del cargo del evaluador
	 * @return the evaJobId
	 */
	public long getEvaJobId() {
		return evaJobId;
	}

	/**
	 * Método que modifica el identificador del cargo del evaluador
	 * @param evaJobId the evaJobId to set
	 */
	public void setEvaJobId(long evaJobId) {
		this.evaJobId = evaJobId;
	}

	/**
	 * Método que obtiene el nombre del cargo del evaluador
	 * @return the evaJobName
	 */
	public String getEvaJobName() {
		return evaJobName;
	}

	/**
	 * Método que modifica el nombre del cargo del evaluador
	 * @param evaJobName the evaJobName to set
	 */
	public void setEvaJobName(String evaJobName) {
		this.evaJobName = evaJobName;
	}

	/**
	 * Método que obtiene el identificador del puesto del evaluador
	 * @return the evaEmploymentId
	 */
	public long getEvaEmploymentId() {
		return evaEmploymentId;
	}

	/**
	 * Método que modifica el id del puesto del evaluador
	 * @param evaEmploymentId the evaEmploymentId to set
	 */
	public void setEvaEmploymentId(long evaEmploymentId) {
		this.evaEmploymentId = evaEmploymentId;
	}

	/**
	 * Método que obtiene el nombre del puesto del evaluador
	 * @return the evaEmploymentName
	 */
	public String getEvaEmploymentName() {
		return evaEmploymentName;
	}

	/**
	 * Método que modifica el nombre del puesto del evaluador
	 * @param evaEmploymentName the evaEmploymentName to set
	 */
	public void setEvaEmploymentName(String evaEmploymentName) {
		this.evaEmploymentName = evaEmploymentName;
	}

	/**
	 * Método que obtiene el nivel del puesto del evaluador
	 * @return the evaEmploymentLevel
	 */
	public int getEvaEmploymentLevel() {
		return evaEmploymentLevel;
	}

	/**
	 * Método que modifica el nivel del puesto del evaluador
	 * @param evaEmploymentLevel the evaEmploymentLevel to set
	 */
	public void setEvaEmploymentLevel(int evaEmploymentLevel) {
		this.evaEmploymentLevel = evaEmploymentLevel;
	}

	/**
	 * Método que obtiene el nombre del nivel asociado al puesto del evaluador
	 * @return the evaEmploymentLevelName
	 */
	public String getEvaEmploymentLevelName() {
		return evaEmploymentLevelName;
	}
	
	/**
	 * Método que modifica el nombre del nivel asociado al puesto del evaludor
	 * @param evaEmploymentLevelName the evaEmploymentLevelName to set
	 */
	public void setEvaEmploymentLevelName(String evaEmploymentLevelName) {
		this.evaEmploymentLevelName = evaEmploymentLevelName;
	}

	/**
	 * Método que obtiene el identificador de la persona que hace de evaluador
	 * @return the evaPersonId 
	 */
	public long getEvaPersonId() {
		return evaPersonId;
	}

	/**
	 * Método que modifica el identificador de la persona que hace de evaluador
	 * @param evaPersonId the evaPersonId to set
	 */
	public void setEvaPersonId(long evaPersonId) {
		this.evaPersonId = evaPersonId;
	}

	/**
	 * Método que obtiene el primer nombre del evaluador
	 * @return the evaFirstName
	 */
	public String getEvaFirstName() {
		return evaFirstName;
	}

	/**
	 * Método que modifica el primer nombre del evaluador
	 * @param evaFirstName the evaFirstName to set
	 */
	public void setEvaFirstName(String evaFirstName) {
		this.evaFirstName = evaFirstName;
	}

	/**
	 * Método que obtiene el segundo nombre del evaluador
	 * @return the evaMiddleName
	 */
	public String getEvaMiddleName() {
		return evaMiddleName;
	}

	/**
	 * Método que modifica el segundo nombre del evaluador
	 * @param evaMiddleName the evaMiddleName to set
	 */
	public void setEvaMiddleName(String evaMiddleName) {
		this.evaMiddleName = evaMiddleName;
	}

	/**
	 * Método que obtiene el primer apellido del evaluador
	 * @return the evaLastName
	 */
	public String getEvaLastName() {
		return evaLastName;
	}

	/**
	 * Método que modifica el primer apellido del evaluador
	 * @param evaLastName the evaLastName to set
	 */
	public void setEvaLastName(String evaLastName) {
		this.evaLastName = evaLastName;
	}

	/**
	 * Método que obtiene el segundo apellido del evaluador
	 * @return the evaMotherMaidenName
	 */
	public String getEvaMotherMaidenName() {
		return evaMotherMaidenName;
	}

	/**
	 * Método que modifica el segundo apellido del evaluador
	 * @param evaMotherMaidenName the evaMotherMaidenName to set
	 */
	public void setEvaMotherMaidenName(String evaMotherMaidenName) {
		this.evaMotherMaidenName = evaMotherMaidenName;
	}

	/**
	 * Método que obtiene la relación entre el evaluador y el evaluado, si la hay
	 * @return the relationType
	 */
	public ThreesixtyRelationType getRelationType() {
		return relationType;
	}

	/**
	 * Método que modifica el tipo de relación entre el evaluador y el evaluado
	 * @param relationType the relationType to set
	 */
	public void setRelationType(ThreesixtyRelationType relationType) {
		this.relationType = relationType;
	}

	/**
	 * Método que obtiene el identificador de la division a la que pertenece el evaluado
	 * @return the evdDivisionId
	 */
	public Long getEvdDivisionId() {
		return evdDivisionId;
	}

	/**
	 * Modifica el id de la division a la que pertenece el evaluado
	 * @param evdDivisionId the evdDivisionId to set
	 */
	public void setEvdDivisionId(Long evdDivisionId) {
		this.evdDivisionId = evdDivisionId;
	}

	/**
	 * Método que obtiene el nombre de la division a la que pertenece el evaluado
	 * @return the evdDivisionName
	 */
	public String getEvdDivisionName() {
		return evdDivisionName;
	}

	/**
	 * Método que modifica el nombre de la division del evaluado
	 * @param evdDivisionName the evdDivisionName to set
	 */
	public void setEvdDivisionName(String evdDivisionName) {
		this.evdDivisionName = evdDivisionName;
	}

	/**
	 * Método que obtiene la posición de la division del evaluado
	 * @return the evdDivisionPosition
	 */
	public String getEvdDivisionPosition() {
		return evdDivisionPosition;
	}
	
	/**
	 * Método que modifica la posición de la division del evaluado
	 * @param evdDivisionPosition the evdDivisionPosition to set
	 */
	public void setEvdDivisionPosition(String evdDivisionPosition) {
		this.evdDivisionPosition = evdDivisionPosition;
	}

	/**
	 * Método que obtiene el identificador del cargo del evaluado
	 * @return the evdJobId
	 */
	public Long getEvdJobId() {
		return evdJobId;
	}

	/**
	 * Método que modifica el identificador del cargo del evaluado
	 * @param evdJobId the evdJobId to set
	 */
	public void setEvdJobId(Long evdJobId) {
		this.evdJobId = evdJobId;
	}

	/**
	 * Método que obtiene el nombre del cargo del evaluado
	 * @return the evdJobName
	 */
	public String getEvdJobName() {
		return evdJobName;
	}

	/**
	 * Método que modifica el nombre del cargo del evaluado
	 * @param evdJobName the evdJobName to set
	 */
	public void setEvdJobName(String evdJobName) {
		this.evdJobName = evdJobName;
	}

	/**
	 * Método que obtiene el identificador del puesto del evaluado
	 * @return the evdEmploymentId
	 */
	public Long getEvdEmploymentId() {
		return evdEmploymentId;
	}

	/**
	 * Método que modifica el id del puesto del evaluado
	 * @param evdEmploymentId the evaEmploymentId to set
	 */
	public void setEvdEmploymentId(Long evdEmploymentId) {
		this.evdEmploymentId = evdEmploymentId;
	}

	/**
	 * Método que obtiene el nombre del puesto del evaluado
	 * @return the evdEmploymentName
	 */
	public String getEvdEmploymentName() {
		return evdEmploymentName;
	}

	/**
	 * Método que modifica el nombre del puesto del evaluado
	 * @param evdEmploymentName the evdEmploymentName to set
	 */
	public void setEvdEmploymentName(String evdEmploymentName) {
		this.evdEmploymentName = evdEmploymentName;
	}

	/**
	 * Método que obtiene el nivel del puesto del evaluado
	 * @return the evdEmploymentLevel
	 */
	public Integer getEvdEmploymentLevel() {
		return evdEmploymentLevel;
	}

	/**
	 * Método que modifica el nivel del puesto del evaluado
	 * @param evdEmploymentLevel the evdEmploymentLevel to set
	 */
	public void setEvdEmploymentLevel(Integer evdEmploymentLevel) {
		this.evdEmploymentLevel = evdEmploymentLevel;
	}

	/**
	 * Método que obtiene el nombre del nivel asociado al puesto del evaluado
	 * @return the evaEmploymentLevelName
	 */
	public String getEvdEmploymentLevelName() {
		return evdEmploymentLevelName;
	}
	
	/**
	 * Método que modifica el nombre del nivel asociado al puesto del evaludo
	 * @param evdEmploymentLevelName the evdEmploymentLevelName to set
	 */
	public void setEvdEmploymentLevelName(String evdEmploymentLevelName) {
		this.evdEmploymentLevelName = evdEmploymentLevelName;
	}

	/**
	 * Método que obtiene el identificador de la persona que hace de evaluado
	 * @return the evdPersonId 
	 */
	public Long getEvdPersonId() {
		return evdPersonId;
	}

	/**
	 * Método que modifica el identificador de la persona que hace de evaluado
	 * @param evdPersonId the evdPersonId to set
	 */
	public void setEvdPersonId(Long evdPersonId) {
		this.evdPersonId = evdPersonId;
	}

	/**
	 * Método que obtiene el primer nombre del evaluado
	 * @return the evaFirstName
	 */
	public String getEvdFirstName() {
		return evdFirstName;
	}

	/**
	 * Método que modifica el primer nombre del evaluado
	 * @param evaFirstName the evaFirstName to set
	 */
	public void setEvdFirstName(String evdFirstName) {
		this.evdFirstName = evdFirstName;
	}

	/**
	 * Método que obtiene el segundo nombre del evaluado
	 * @return the evdMiddleName
	 */
	public String getEvdMiddleName() {
		return evdMiddleName;
	}

	/**
	 * Método que modifica el segundo nombre del evaluado
	 * @param evdMiddleName the evdMiddleName to set
	 */
	public void setEvdMiddleName(String evdMiddleName) {
		this.evdMiddleName = evdMiddleName;
	}

	/**
	 * Método que obtiene el primer apellido del evaluado
	 * @return the evaLastName
	 */
	public String getEvdLastName() {
		return evdLastName;
	}

	/**
	 * Método que modifica el primer apellido del evaluado
	 * @param evdLastName the evdLastName to set
	 */
	public void setEvdLastName(String evdLastName) {
		this.evdLastName = evdLastName;
	}

	/**
	 * Método que obtiene el segundo apellido del evaluado
	 * @return the evdMotherMaidenName
	 */
	public String getEvdMotherMaidenName() {
		return evdMotherMaidenName;
	}

	/**
	 * Método que modifica el segundo apellido del evaluado
	 * @param evdMotherMaidenName the evdMotherMaidenName to set
	 */
	public void setEvdMotherMaidenName(String evdMotherMaidenName) {
		this.evdMotherMaidenName = evdMotherMaidenName;
	}
	
	/**
	 * Método que obtiene la empresa a la que pertenece la información
	 * @return the companyId 
	 */
	public long getCompanyId() {
		return companyId;
	}

	/**
	 * Método que modifica la empresa a la que pertenece la información
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	/**
	 * Metodo que obtiene la evaluación a la que pertenece la información
	 * @return the evaluationId
	 */
	public long getEvaluationId() {
		return evaluationId;
	}

	/**
	 * Método que modifica la evaluación a la que pertenece la información
	 * @param evaluationId the evaluationId to set
	 */
	public void setEvaluationId(long evaluationId) {
		this.evaluationId = evaluationId;
	}
	
	/**
	 * @return the solvedQuestionnaireId
	 */
	public long getSolvedQuestionnaireId() {
		return solvedQuestionnaireId;
	}

	/**
	 * @param solvedQuestionnaireId the solvedQuestionnaireId to set
	 */
	public void setSolvedQuestionnaireId(long solvedQuestionnaireId) {
		this.solvedQuestionnaireId = solvedQuestionnaireId;
	}

	/**
	 * Método que obtiene el identificador del evaluador que realiza la evaluación
	 * @return the evaluatorId
	 */
	public long getEvaluatorId() {
		return evaluatorId;
	}

	/**
	 * Método que modifica el identificador del evaluador que realiza la evaluación
	 * @param evaluatorId the evaluatorId to set
	 */
	public void setEvaluatorId(long evaluatorId) {
		this.evaluatorId = evaluatorId;
	}

	/**
	 * Método que obtiene el identificador del evaluado al que se realiza la evaluación
	 * @return the evalautedId
	 */
	public Long getEvaluatedId() {
		return evaluatedId;
	}

	/**
	 * Método que modifica el identificador del evaluado al que se realiza la evaluación
	 * @param evaluatedId the evalautedId to set
	 */
	public void setEvaluatedId(Long evaluatedId) {
		this.evaluatedId = evaluatedId;
	}
}
