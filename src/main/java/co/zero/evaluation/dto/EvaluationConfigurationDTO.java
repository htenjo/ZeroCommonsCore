//=======================================================================
// ARCHIVO EvaluationConfigurationDTO.java
// FECHA CREACIÓN: 9/05/2011
//=======================================================================
package co.zero.evaluation.dto;

import co.zero.common.dto.EntityDTO;


/**
 * Clase que permite agrupar todas los parámetros de configuración
 * requeridos por una evaluación
 * @author Hernán Tenjo
 * @version 1.0
 */
public class EvaluationConfigurationDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Evaluación a la que pertenecen los parametros de configuración
	private EvaluationDTO evaluation;
	//Ya que las relaciones en las evaluaciones de innovación son generadas
	//cuando el evaluador entra y selecciona las personas a evaluar
	//este atributo define la cantidad de relaciones requeridas 
	//para poder continuar con el proceso
	private int expectedRelations;
	//Mensaje de introducción a la evaluación (HTML)
	private String msgIntroByEvaluation;
	//Mensaje mostrado como encabezado de los cuestionarios sociales(HTML)
	private String msgInstructionsInSocialQuestionnaire;
	//Mensaje mostrado como encabezado de los cuestionarios (HTML)
	private String msgInstructionsInQuestionnaire;
	//Mensaje mostrado al finalizar un cuestionario (HTML)
	private String msgEndQuestionnaire;
	//Mensaje mostrado al finalizar todos los cuestionarios de una evaluación (HTML)
	private String msgEndEvaluation;
	//Determina si la evaluación utilizará un cuestionario para capturar 
	//información sociodemográfica antes del cuestionario principal
	private boolean hasSocialQuestionnaire;
	//Atributo que permite determinar si la información del grupo
	//de competencias será mostrada en el cuestionario
	private boolean showQualificationGroup;
	//Atributo que permite determinar si la información de la competencia
	//será mostrada en el cuestionario
	private boolean showQualification;
	//Atributo que permite determinar si las preguntas del cuestionario serán
	//agrupadas dependiendo del grupo de la competencia relacionada
	private boolean groupByQualificationGroup;
	//Atributo que permite determinar si las preguntas del cuestionario serán
	//agrupadas dependiendo de la competencia relacionada. Esta agrupación puede
	//ser complementaria a groupByQualificationGroup
	private boolean groupByQualification;
	//Cantidad de preguntas que serán presentadas x hoja del cuestionario. 10 por defecto
	private int questionsByPage = 10;
	//Determina si al finalizar el cuestionario se muestra la posibilidad de imprimir el cuestionario
	private boolean showPrintQuestionnaire;
	//Determina si al finalizar el cuestionario se muestra la posibilidad de implimir el cuestionario social
	private boolean showPrintSocialQuestionnaire;
	//Determinar si el cuestionario se podrá editar luego de ser terminado
	private boolean questionnaireEditable;
	//Mensaje mostrado en las evaluaciones de innovación, cuando se presenta la lista 
	//de candidatos a ser evaluados
	private String msgEvaluatedSelection;
	//Mensaje mostrado en el listado de relaciones, en las evaluaciones que las requieren
	private String msgEvaluationRelationList;
	//Permite configurar si se va a mostrar el panel de las competencias del empleado en su index
	private boolean showCompetences;
	
	// Tiempo maximo para contestar una evaluacion en segundos
	private Integer maxTime;


	
	/**
	 * Metodo que permite obtener la cantidad de relaciones esperadas
	 * en una evaluación de innovación
	 * @return La cantidad de relaciones esperadas en la evaluación
	 */
	public int getExpectedRelations() {
		return expectedRelations;
	}

	/**
	 * Metodo que permite modificar la cantidad de relaciones esperadas
	 * en un evaluación de innovación
	 * @param expectedRelations La nueva cantidad de relaciones esperadas
	 */
	public void setExpectedRelations(int expectedRelations) {
		this.expectedRelations = expectedRelations;
	}
	
	/**
	 * Método que permite obtener la evaluación a la que pertecen los 
	 * parámetros de configuración
	 * @return La evaluacion configurada para los parámetros
	 */
	public EvaluationDTO getEvaluation() {
		return evaluation;
	}

	/**
	 * Método que permite modificar la evaluación a la que pertenecen los
	 * parámetros de configuración
	 * @param evaluation La nueva evaluación dueña de los parámetros
	 */
	public void setEvaluation(EvaluationDTO evaluation) {
		this.evaluation = evaluation;
	}
	
	/**
	 * Método que permite obtener el mensaje de introducción a la evaluación
	 * @return El mensaje de introducción configurado
	 */
	public String getMsgIntroByEvaluation() {
		return msgIntroByEvaluation;
	}

	/**
	 * Método que permite modificar el mensaje de introducción a la evaluación
	 * @param message El nuevo mensaje de introducción a la evaluación
	 */
	public void setMsgIntroByEvaluation(String message) {
		this.msgIntroByEvaluation = message;
	}

	/**
	 * Método que permite obtener el mensaje de instrucción, ubicado
	 * en la parte superior del cuestionario
	 * @return El mensaje configurado como intrucciones del cuestionario
	 */
	public String getMsgInstructionsInSocialQuestionnaire() {
		return msgInstructionsInSocialQuestionnaire;
	}

	/**
	 * Método que permite modificar el mensaje de instrucción, ubicado
	 * en la parte superior del cuestionario
	 * @param message El nuevo mensaje a mostrar como instrucciones
	 */
	public void setMsgInstructionsInSocialQuestionnaire(String message) {
		this.msgInstructionsInSocialQuestionnaire = message;
	}
	
	/**
	 * Método que permite obtener el mensaje de instrucción, ubicado
	 * en la parte superior del cuestionario
	 * @return El mensaje configurado como intrucciones del cuestionario
	 */
	public String getMsgInstructionsInQuestionnaire() {
		return msgInstructionsInQuestionnaire;
	}

	/**
	 * Método que permite modificar el mensaje de instrucción, ubicado
	 * en la parte superior del cuestionario
	 * @param message El nuevo mensaje a mostrar como instrucciones
	 */
	public void setMsgInstructionsInQuestionnaire(String message) {
		this.msgInstructionsInQuestionnaire = message;
	}

	/**
	 * Método que permite obtener el mensaje mostrado al finalizar un cuestionario
	 * @return El mensaje configurado para mostrar al finalizar un cuestionario
	 */
	public String getMsgEndQuestionnaire() {
		return msgEndQuestionnaire;
	}

	/**
	 * Método que permite modificar el mensaje mostrado al finalizar un cuestionario
	 * @param message El nuevo mensaje que se desea mostrar
	 */
	public void setMsgEndQuestionnaire(String message) {
		this.msgEndQuestionnaire = message;
	}

	/**
	 * Método que permite obtener el mensaje mostrado al finalizar
	 * todos los cuestionarios de una evaluación
	 * @return El mensaje configurado para mostrar al finalizar una evaluación
	 */
	public String getMsgEndEvaluation() {
		return msgEndEvaluation;
	}

	/**
	 * Método que permite modificar el mensaje mostrado al finalizar
	 * todos los cuestionarios de una evaluación
	 * @param message El nuevo mensaje configurado para mostrar al finalizar una evaluación
	 */
	public void setMsgEndEvaluation(String message) {
		this.msgEndEvaluation = message;
	}

	/**
	 * Método que permite determinar si la evaluación usará un cuestionario
	 * previo para recopilar información sociodemográfica
	 * @return True si se desea utilizar un cuestionario previo, False de lo contrario
	 */
	public boolean isHasSocialQuestionnaire() {
		return hasSocialQuestionnaire;
	}

	/**
	 * Método que permite mofificar el hecho de usar un cuestionario previo
	 * en la evaluación para recopilar información sociodemográfica
	 * @param hasSocialQuestionnaire True si se desea utilizar un cuestionario 
	 * previo, False de lo contrario 
	 */
	public void setHasSocialQuestionnaire(boolean hasSocialQuestionnaire) {
		this.hasSocialQuestionnaire = hasSocialQuestionnaire;
	}
	
	/**
	 * Método que permite determinar si se mostrará la información del 
	 * grupo de competencias en el cuestionario
	 * @return True si se mostrará la información, false de lo contrario
	 */
	public boolean isShowQualificationGroup() {
		return showQualificationGroup;
	}

	/**
	 * Método que permite modificar la aparición de la información del grupo
	 * de competencias en el cuestionario
	 * @param showQualificationGroup True si se desea mostrar la información, 
	 * false de lo contrario
	 */
	public void setShowQualificationGroup(boolean showQualificationGroup) {
		this.showQualificationGroup = showQualificationGroup;
	}

	/**
	 * Método que permite determinar si se mostrará la información de
	 * las competencias en el cuestionario
	 * @return True si se mostrará la información, false de lo contrario
	 */
	public boolean isShowQualification() {
		return showQualification;
	}

	/**
	 * Método que permite modificar la aparición de la información de las
	 * competencias en el cuestionario
	 * @param showQualification True si se desea mostrar la información, 
	 * false de lo contrario
	 */
	public void setShowQualification(boolean showQualification) {
		this.showQualification = showQualification;
	}

	/**
	 * Método que permite determinar si el cuestionario será organizado agrupando
	 * las preguntas por el grupo de competencias asociado
	 * @return True si se agrupará por el grupo de competencias, false de lo contrario
	 */
	public boolean isGroupByQualificationGroup() {
		return groupByQualificationGroup;
	}

	/**
	 * Método que permite modificar la organización de las preguntas del cuestionario,
	 * modificando la agrupación por grupo de compentencias
	 * @param groupByQualificationGroup True si se quiere organizar por el grupo de competencias
	 */
	public void setGroupByQualificationGroup(boolean groupByQualificationGroup) {
		this.groupByQualificationGroup = groupByQualificationGroup;
	}

	/**
	 * Método que permite determinar si el cuestionario será organizado agrupando
	 * las preguntas por la competencia asociada
	 * @return True si se agrupará por la competencia, false de lo contrario
	 */
	public boolean isGroupByQualification() {
		return groupByQualification;
	}

	/**
	 * Método que permite modificar la organización de las preguntas del cuestionario,
	 * modificar la agrupación por competencia
	 * @param groupByQualification True si se quiere organizar por la competencia, false de lo contrario
	 */
	public void setGroupByQualification(boolean groupByQualification) {
		this.groupByQualification = groupByQualification;
	}
	
	/**
	 * Método que permite obtener la cantidad de preguntas que se mostrarán 
	 * por cada página del cuestionario 
	 * @return la cantidad de preguntas configuradas x pagina
	 */
	public int getQuestionsByPage() {
		return questionsByPage;
	}

	/**
	 * Método que permite modificar la cantidad de preguntas que se mostrarán
	 * por cada página del cuestionario
	 * @param questionsByPage La nueva cantidad de preguntas que se mostrarán por página
	 */
	public void setQuestionsByPage(int questionsByPage) {
		this.questionsByPage = questionsByPage;
	}

	/**
	 * Método que permite obtener la cantidad de preguntas que se mostrarán 
	 * por cada página del cuestionario 
	 * @return la cantidad de preguntas configuradas x pagina
	 */
	public Number getQuestionsByPageNumber() {
		return questionsByPage;
	}

	/**
	 * Método que permite modificar la cantidad de preguntas que se mostrarán
	 * por cada página del cuestionario
	 * @param questionsByPage La nueva cantidad de preguntas que se mostrarán por página
	 */
	public void setQuestionsByPageNumber(Number questionsByPage) {
		this.questionsByPage = questionsByPage.intValue();
	}
	

	/**
	 * Método que permite determinar si se va a mostrar el link para la impresión
	 * del cuestionario principal
	 * @return True si se mostrará el link de impresión del cuestionario principal, 
	 * false de lo contrario
	 */
	public boolean isShowPrintQuestionnaire() {
		return showPrintQuestionnaire;
	}

	/**
	 * Método que permite modificar la visibilidad del link de impresión 
	 * del cuestionario principal
	 * @param showPrintQuestionnaire True si se desea mostrar el link de 
	 * impresión del cuestionario principal, false de lo contrario
	 */
	public void setShowPrintQuestionnaire(boolean showPrintQuestionnaire) {
		this.showPrintQuestionnaire = showPrintQuestionnaire;
	}

	/**
	 * Método que permite determinar si se va a mostrar el link para la impresión
	 * del cuestionario sociodemográfico
	 * @return True si se mostrará el link de impresión del cuestionario social,
	 * false de lo contrario
	 */
	public boolean isShowPrintSocialQuestionnaire() {
		return showPrintSocialQuestionnaire;
	}

	/**
	 * Método que permite modificar la visibilidad del link de impresión del cuestionario social
	 * @param showPringSocialQuestionnaire True si se desea mostrar el link de impresión 
	 * del cuestionario social, false de lo contrario
	 */
	public void setShowPrintSocialQuestionnaire(boolean showPringSocialQuestionnaire) {
		this.showPrintSocialQuestionnaire = showPringSocialQuestionnaire;
	}
	

	/**
	 * Método que permite determinar si el cuestionario será editable
	 * @return True si el cuestionario se podrá editar, false de lo contrario
	 */
	public boolean isQuestionnaireEditable() {
		return questionnaireEditable;
	}

	/**
	 * Método que permite modificar la configuración editable del cuestionario
	 * @param questionnaireEditable True si se desea que el cuestionario sea editable, 
	 * false de lo contrario
	 */
	public void setQuestionnaireEditable(boolean questionnaireEditable) {
		this.questionnaireEditable = questionnaireEditable;
	}
	
	/**
	 * Método que obtiene el mensaje que será mostrado en la página de selección
	 * de evaluados en las evaluaciones de innovacion
	 * @return El mensaje configurado para el listado de candidatos a evaluado
	 */
	public String getMsgEvaluatedSelection() {
		return msgEvaluatedSelection;
	}

	/**
	 * Método que modifica el mensaje que será mostrado en la página de selección
	 * @param msgEvaluatedSelection El nuevo mensaje que será mostrado
	 */
	public void setMsgEvaluatedSelection(String msgEvaluatedSelection) {
		this.msgEvaluatedSelection = msgEvaluatedSelection;
	}

	/**
	 * Método que obtiene el mensaje que será mostrado en el listado de relaciones
	 * @return El mensaje configurado para la página de relaciones
	 */
	public String getMsgEvaluationRelationList() {
		return msgEvaluationRelationList;
	}

	/**
	 * Método que modifica el mensaje que será mostrado en el listado de relaciones
	 * @param msgEvaluationRelationList El nuevo mensaje que será mostrado
	 */
	public void setMsgEvaluationRelationList(String msgEvaluationRelationList) {
		this.msgEvaluationRelationList = msgEvaluationRelationList;
	}
	
	/**
	 * Método que permite configurar si se va a mostrar el panel de las competencias del empleado en su index
	 * @return True si se configuro que se va a mostrar el panel, false de lo contrario
	 */
	public boolean isShowCompetences() {
		return showCompetences;
	}

	/**
	 * Método que permite configurar si se va a mostrar el panel de las competencias del empleado en su index
	 * @param showCompetences True si se desea mostrar el panel de las competencias, 
	 * false de lo contrario
	 */
	public void setShowCompetences(boolean showCompetences) {
		this.showCompetences = showCompetences;
	}

	public Integer getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(Integer maxTime) {
		this.maxTime = maxTime;
	}
	
	
}