//=======================================================================
// ARCHIVO HcmErrorMessages.java
// FECHA CREACIÓN: Sep 25, 2009
//=======================================================================
package co.zero.evaluation.exception;

import co.zero.common.constant.GenericConstants;

/**
 * Clase con todos los mensajes que se van a utilizar 
 * en el manejo de errores de HCM
 * @author Hernán Tenjo
 * @version 1.0
 */
public class EvaluationErrorMessages {
	public static final String EVALUATION_TYPE_NOT_SUPPORTED = 
		"::: El tipo de evaluación ["+GenericConstants.MSG_WILDCARD+"] no es soportado actualmente";
	
	public static final String EVALUATION_TYPES_NOT_CONFIGURED_FOR_COMPANY = 
		"::: La compañía ["+GenericConstants.MSG_WILDCARD+"] no tiene ningún " +
				"tipo de evaluación configurada para administrar";
	
	public static final String QUESTIONNAIRE_NOT_CONFIGURED_FOR_EVALUATED = 
		"::: El evaluado ["+GenericConstants.MSG_WILDCARD+"] no tiene configurado un cuestionario";	
	
	public static final String QUESTIONNAIRE_PAGE_ALREADY_SOLVED = 
		"::: Está tratando de guardar la página ["+GenericConstants.MSG_WILDCARD+"] del SolvedQuestionnaire [" +
				GenericConstants.MSG_WILDCARD+"] que ya se encuentra registrada en el sistema";
	
	public static final String QUESTIONNAIRE_NOT_CONFIGURED_FOR_EVALUATION = 
		"::: La evaluacion ["+GenericConstants.MSG_WILDCARD+"] no tiene configurado un cuestionario";
	
	public static final String SOCIAL_QUESTIONNAIRE_NOT_CONFIGURED_FOR_EVALUATION = 
		"::: La evaluacion ["+GenericConstants.MSG_WILDCARD+"] no tiene configurado el cuestionario sociodemográfico";
	
	public static final String EXPECTED_RELATIONS_NOT_CONFIGURED = 
		"::: La cantidad de relaciones esperadas para la evaluación ["+GenericConstants.MSG_WILDCARD+"] debe ser mínimo 1";
	
	public static final String RESPONSE_OPTION_VALUE_NOT_FOUND_IN_OPTIONS = 
		"::: No se ha encontrado un ResponseOption que corresponda con el valor dado ["+GenericConstants.MSG_WILDCARD+"]";
	
	public static final String QUALIFICATION_NOT_FOUND = "::: No se ha encontrado la competencia con el nombre [" +
			GenericConstants.MSG_WILDCARD + "]";
	
	public static final String PROFILE_DETAIL_VALUE_ERROR = "::: El valor mínimo esperado del perfil [" +
			GenericConstants.MSG_WILDCARD + "] debe ser un número válido";
	
	public static final String DELETING_EVALUATED_ALREADY_IN_USE = "::: El evaluado asociado con id [" +
			GenericConstants.MSG_WILDCARD + "] aún se encuentra en uso";
	
	public static final String EMPLOYEE_WITHOUT_PROFILE = "::: El empleado con usuario [" +
			GenericConstants.MSG_WILDCARD + "] no tiene un perfil asociado";
	
	public static final String RELATION_TYPE_NOT_SUPPORTED = "::: La relación [" + 
			GenericConstants.MSG_WILDCARD + "] no es soportada";
	
	public static final String QUALIFICATION_MULTIPLE_WITH_SAME_NAME = "::: Existe mas de una entidad con el mismo nombre [" +
			GenericConstants.MSG_WILDCARD + "]";
	
	public static final String QUALIFICATION_GROUP_MULTIPLE_WITH_SAME_NAME = "::: Existe mas de un grupo con el mismo nombre [" +
			GenericConstants.MSG_WILDCARD + "]";

	public static final String QUESTION_MULTIPLE_WITH_SAME_NAME = "::: Existe mas de una pregunta con el mismo label [" +
			GenericConstants.MSG_WILDCARD + "] en la competencia [" + GenericConstants.MSG_WILDCARD +"]";
	
	public static final String QUESTION_TYPE_MULTIPLE_WITH_SAME_LABEL = "::: Existe mas de un tipo de pregunta con el mismo label [" +
			GenericConstants.MSG_WILDCARD + "]";
	
	public static final String REPORT_WITHOUT_INFO = "::: El reporte no presenta información";
	
	public static final String REPORT_WITHOUT_COMPETENCES = "El empleado no tiene información de competencias, por tanto no se puede generar el reporte";
	
	public static final String REPORT_WITHOUT_KPIS = "El empleado no tiene información de KPI, por tanto no se puede generar el reporte";
}