//=======================================================================
// ARCHIVO ReportEvaluatedStatistics.java
// FECHA CREACIÓN: 2013/03/05
//=======================================================================
package co.zero.evaluation.dto;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.evaluation.ThreesixtyRelationType;
import co.zero.common.enumeration.innpulsa.QuestionnaireRelation;

/**
 * Clase que agrupa los resultados dados para un evaluado en una evaluación de 360
 * Esta agrupación permitirá la fácil generación de reportes y análisis estadísticos al unirse
 * con la tabla {@link QuestionnaireInfo}
 * @author Hernán Tenjo
 * @version 1.0
 */
public class ReportEvaluatedStatisticsDTO extends EntityDTO{
	private static final long serialVersionUID = 1L;
	//Evaluación en la que se recopilaron los datos
	private long evaluationId;
	//Evaluado al que pertenecen los datos
	private long evaluatedId;
	//Información de la competencia por la que se registraron los datos
	private long quaId;
	private String quaName;
	private String quaDescription;
	private int quaLevel;
	private String quaLevelName;
	private String quaCode;
	private int quaPriority;
	private Long quaGroupId;
	private String quaGroupName;
	//Relación que ha generado la información
	private ThreesixtyRelationType relationType;
	//Relación que ha generado la información (sólo para HcmV4)
	private QuestionnaireRelation relationV4;
	//Suma de los valores de las respuestas dadas
	private double sumResponses;
	//Cantidad de respuestas dadas
	private double countResponses;
	//Valor minimo esperado para la competencia
	private double minimum;
	//Valor máximo de las opciones de respuestas (Para este tipo de estadística, 
	//se debe contar con un único tipo de pregunta, de lo contrario se seleccionará la mayor de todas
	//y podría generar ruido con respecto a los resultados)
	private double maxResponseOptions;
	//Cadena con las preguntas que no han superado el minimo esperado de la competencia, separadas por :|: 
	private String questionsToImprove;
	//Cadena con los mensajes de feedBack dados por los evaluadores, separados :|:
	private String feedBack;
	
	/**
	 * @return the evaluationId
	 */
	public long getEvaluationId() {
		return evaluationId;
	}
	/**
	 * @param evaluationId the evaluationId to set
	 */
	public void setEvaluationId(long evaluationId) {
		this.evaluationId = evaluationId;
	}
	/**
	 * @return the evaluatedId
	 */
	public long getEvaluatedId() {
		return evaluatedId;
	}
	/**
	 * @param evaluatedId the evaluatedId to set
	 */
	public void setEvaluatedId(long evaluatedId) {
		this.evaluatedId = evaluatedId;
	}
	/**
	 * @return the quaId
	 */
	public long getQuaId() {
		return quaId;
	}
	/**
	 * @param quaId the quaId to set
	 */
	public void setQuaId(long quaId) {
		this.quaId = quaId;
	}
	/**
	 * @return the quaName
	 */
	public String getQuaName() {
		return quaName;
	}
	/**
	 * @param quaName the quaName to set
	 */
	public void setQuaName(String quaName) {
		this.quaName = quaName;
	}
	/**
	 * @return the quaDescription
	 */
	public String getQuaDescription() {
		return quaDescription;
	}
	/**
	 * @param quaDescription the quaDescription to set
	 */
	public void setQuaDescription(String quaDescription) {
		this.quaDescription = quaDescription;
	}
	/**
	 * @return the quaLevel
	 */
	public int getQuaLevel() {
		return quaLevel;
	}
	/**
	 * @param quaLevel the quaLevel to set
	 */
	public void setQuaLevel(int quaLevel) {
		this.quaLevel = quaLevel;
	}
	/**
	 * @return the quaLevelName
	 */
	public String getQuaLevelName() {
		return quaLevelName;
	}
	/**
	 * @param quaLevelName the quaLevelName to set
	 */
	public void setQuaLevelName(String quaLevelName) {
		this.quaLevelName = quaLevelName;
	}
	/**
	 * @return the quaCode
	 */
	public String getQuaCode() {
		return quaCode;
	}
	/**
	 * @param quaCode the quaCode to set
	 */
	public void setQuaCode(String quaCode) {
		this.quaCode = quaCode;
	}
	/**
	 * @return the quaPriority
	 */
	public int getQuaPriority() {
		return quaPriority;
	}
	/**
	 * @param quaPriority the quaPriority to set
	 */
	public void setQuaPriority(int quaPriority) {
		this.quaPriority = quaPriority;
	}
	/**
	 * @return the quaGroupId
	 */
	public Long getQuaGroupId() {
		return quaGroupId;
	}
	/**
	 * @param quaGroupId the quaGroupId to set
	 */
	public void setQuaGroupId(Long quaGroupId) {
		this.quaGroupId = quaGroupId;
	}
	/**
	 * @return the quaGroupName
	 */
	public String getQuaGroupName() {
		return quaGroupName;
	}
	/**
	 * @param quaGroupName the quaGroupName to set
	 */
	public void setQuaGroupName(String quaGroupName) {
		this.quaGroupName = quaGroupName;
	}
	/**
	 * @return the relationType
	 */
	public ThreesixtyRelationType getRelationType() {
		return relationType;
	}
	/**
	 * @param relationType the relationType to set
	 */
	public void setRelationType(ThreesixtyRelationType relationType) {
		this.relationType = relationType;
	}
	/**
	 * @return the sumResponses
	 */
	public double getSumResponses() {
		return sumResponses;
	}
	/**
	 * @param sumResponses the sumResponses to set
	 */
	public void setSumResponses(double sumResponses) {
		this.sumResponses = sumResponses;
	}
	/**
	 * @return the countResponses
	 */
	public double getCountResponses() {
		return countResponses;
	}
	/**
	 * @param countResponses the countResponses to set
	 */
	public void setCountResponses(double countResponses) {
		this.countResponses = countResponses;
	}
	/**
	 * @return the minimum
	 */
	public double getMinimum() {
		return minimum;
	}
	/**
	 * @param minimum the minimum to set
	 */
	public void setMinimum(double minimum) {
		this.minimum = minimum;
	}
	/**
	 * @return the maxResponseOptions
	 */
	public double getMaxResponseOptions() {
		return maxResponseOptions;
	}
	/**
	 * @param maxResponseOptions the maxResponseOptions to set
	 */
	public void setMaxResponseOptions(double maxResponseOptions) {
		this.maxResponseOptions = maxResponseOptions;
	}
	/**
	 * @return the questionsToImprove
	 */
	public String getQuestionsToImprove() {
		return questionsToImprove;
	}
	/**
	 * @param questionsToImprove the questionsToImprove to set
	 */
	public void setQuestionsToImprove(String questionsToImprove) {
		this.questionsToImprove = questionsToImprove;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getFeedBack() {
		return feedBack;
	}
	
	/**
	 * @param feedBack the feedBack to set
	 */
	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}
	/**
	 * @return the relationV4
	 */
	public QuestionnaireRelation getRelationV4() {
		return relationV4;
	}
	/**
	 * @param relationV4 the relationV4 to set
	 */
	public void setRelationV4(QuestionnaireRelation relationV4) {
		this.relationV4 = relationV4;
	}

}
