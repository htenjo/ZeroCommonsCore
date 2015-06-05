//=======================================================================
// ARCHIVO HcmPersistentApplicationException.java
// FECHA CREACIÓN: Sep 28, 2009
//=======================================================================
package co.zero.evaluation.exception;

import javax.ejb.ApplicationException;

import co.zero.common.exception.ZeroApplicationException;
import co.zero.hcm.exception.HcmException;

/**
 * Clase que representa una excepcion generada en un proceso de negocio en el modulo Hcm
 * @author Hernán Tenjo
 * @version 1.0
 */
@ApplicationException(rollback = true)
public class EvaluationException extends ZeroApplicationException{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;	
	public static final int DEFAULT_CODE_RANGE = HcmException.DEFAULT_CODE_RANGE + 2000;
	
	//Excepciones del módulo Evaluations
	public static final int EVALUATION_TYPE_NOT_SUPPORTED = DEFAULT_CODE_RANGE + 1;
	public static final int EVALUATION_TYPES_NOT_CONFIGURED_FOR_COMPANY = DEFAULT_CODE_RANGE + 2;
	public static final int QUESTIONNAIRE_NOT_CONFIGURED_FOR_EVALUATED = DEFAULT_CODE_RANGE + 3;
	public static final int QUESTIONNAIRE_PAGE_ALREADY_SOLVED = DEFAULT_CODE_RANGE + 4;
	public static final int QUESTIONNAIRE_NOT_CONFIGURED_FOR_EVALUATION = DEFAULT_CODE_RANGE + 5;
	public static final int EXPECTED_RELATIONS_NOT_CONFIGURED = DEFAULT_CODE_RANGE + 6;
	public static final int SOCIAL_QUESTIONNAIRE_NOT_CONFIGURED_FOR_EVALUATION = DEFAULT_CODE_RANGE + 7;
	public static final int RESPONSE_OPTION_VALUE_NOT_FOUND_IN_OPTIONS = DEFAULT_CODE_RANGE + 8;
	public static final int QUALIFICATION_NOT_FOUND = DEFAULT_CODE_RANGE + 9;
	public static final int PROFILE_DETAIL_VALUE_ERROR = DEFAULT_CODE_RANGE + 10;
	public static final int DELETING_EVALUATED_ALREADY_IN_USE = DEFAULT_CODE_RANGE + 11;
	public static final int EMPLOYEE_WITHOUT_PROFILE = DEFAULT_CODE_RANGE + 12;
	public static final int RELATION_TYPE_NOT_SUPPORTED = DEFAULT_CODE_RANGE + 13;
	public static final int EVALUATED_WITH_RESPONSES = DEFAULT_CODE_RANGE + 14;
	public static final int QUALIFICATION_MULTIPLE_WITH_SAME_NAME = DEFAULT_CODE_RANGE + 15;
	public static final int QUALIFICATION_GROUP_MULTIPLE_WITH_SAME_NAME = DEFAULT_CODE_RANGE + 16;
	public static final int QUESTION_MULTIPLE_WITH_SAME_LABEL = DEFAULT_CODE_RANGE + 17;
	public static final int QUESTION_TYPE_MULTIPLE_WITH_SAME_LABEL = DEFAULT_CODE_RANGE + 18;
	public static final int REPORT_WITHOUT_INFO = DEFAULT_CODE_RANGE + 19;
	public static final int REPORT_WITHOUT_COMPETENCES = DEFAULT_CODE_RANGE + 20;
	public static final int REPORT_WITHOUT_KPIS = DEFAULT_CODE_RANGE + 21;
	
	/**
	 * Método constructor de la excepción
	 * @param errorCode Codigo que identifica a la excepción
	 */
	public EvaluationException(int errorCode){
		super(errorCode);
	}
		
	/**
	 * Método constructor de la excepcion cuando no se desea 
	 * especificar un codigo de error específico
	 * @param e Excepción original
	 */
	public EvaluationException(Throwable e){
		super(e);
	}
	
	/**
	 * Método constructor de la excepción
	 * @param errorCode Codigo que identifica a la excepción
	 * @param e Traza de la excepción original
	 */
	public EvaluationException(int errorCode, Throwable e){
		super(errorCode, e);
	}
	
	/**
	 * Constructor auxiliar cuando solo se requiere de un parámetro 
	 * @param errorCode Codigo que identifica a la excepción
	 * @param parameter Parametro a reemplazar en el mensaje original
	 */
	public EvaluationException(int errorCode, String... parameter){
		super(errorCode, parameter);
	}
	
	/**
	 * Constructor auxiliar cuando solo se requiere de un parámetro 
	 * @param errorCode Codigo que identifica a la excepción
	 * @param e Traza de la excepción original
	 * @param parameter Parametro a reemplazar en el mensaje original
	 */
	public EvaluationException(int errorCode, Throwable e, String... parameter){
		super(errorCode, e, parameter);
	}
			
	/*
	 * (non-Javadoc)
	 * @see co.zero.hcm.exception.HcmException#buildMessage()
	 */
	@Override
	protected String buildMessage() {
		switch (errorCode) {
		case EVALUATION_TYPE_NOT_SUPPORTED:
			return getMessage(EvaluationErrorMessages.EVALUATION_TYPE_NOT_SUPPORTED);
		case EVALUATION_TYPES_NOT_CONFIGURED_FOR_COMPANY:
			return getMessage(EvaluationErrorMessages.EVALUATION_TYPES_NOT_CONFIGURED_FOR_COMPANY);
		case QUESTIONNAIRE_NOT_CONFIGURED_FOR_EVALUATED:
			return getMessage(EvaluationErrorMessages.QUESTIONNAIRE_NOT_CONFIGURED_FOR_EVALUATED);
		case QUESTIONNAIRE_PAGE_ALREADY_SOLVED:
			return getMessage(EvaluationErrorMessages.QUESTIONNAIRE_PAGE_ALREADY_SOLVED);
		case QUESTIONNAIRE_NOT_CONFIGURED_FOR_EVALUATION:
			return getMessage(EvaluationErrorMessages.QUESTIONNAIRE_NOT_CONFIGURED_FOR_EVALUATION);
		case SOCIAL_QUESTIONNAIRE_NOT_CONFIGURED_FOR_EVALUATION:
			return getMessage(EvaluationErrorMessages.SOCIAL_QUESTIONNAIRE_NOT_CONFIGURED_FOR_EVALUATION);
		case EXPECTED_RELATIONS_NOT_CONFIGURED:
			return getMessage(EvaluationErrorMessages.EXPECTED_RELATIONS_NOT_CONFIGURED);
		case RESPONSE_OPTION_VALUE_NOT_FOUND_IN_OPTIONS:
			return getMessage(EvaluationErrorMessages.RESPONSE_OPTION_VALUE_NOT_FOUND_IN_OPTIONS);
		case QUALIFICATION_NOT_FOUND:
			return getMessage(EvaluationErrorMessages.QUALIFICATION_NOT_FOUND);
		case PROFILE_DETAIL_VALUE_ERROR:
			return getMessage(EvaluationErrorMessages.PROFILE_DETAIL_VALUE_ERROR);
		case DELETING_EVALUATED_ALREADY_IN_USE:
			return getMessage(EvaluationErrorMessages.DELETING_EVALUATED_ALREADY_IN_USE);
		case EMPLOYEE_WITHOUT_PROFILE:
			return getMessage(EvaluationErrorMessages.EMPLOYEE_WITHOUT_PROFILE);
		case RELATION_TYPE_NOT_SUPPORTED:
			return getMessage(EvaluationErrorMessages.RELATION_TYPE_NOT_SUPPORTED);
		case QUALIFICATION_MULTIPLE_WITH_SAME_NAME:
			return getMessage(EvaluationErrorMessages.QUALIFICATION_MULTIPLE_WITH_SAME_NAME);
		case QUALIFICATION_GROUP_MULTIPLE_WITH_SAME_NAME:
			return getMessage(EvaluationErrorMessages.QUALIFICATION_GROUP_MULTIPLE_WITH_SAME_NAME);
		case QUESTION_MULTIPLE_WITH_SAME_LABEL:
			return getMessage(EvaluationErrorMessages.QUESTION_MULTIPLE_WITH_SAME_NAME);
		case QUESTION_TYPE_MULTIPLE_WITH_SAME_LABEL:
			return getMessage(EvaluationErrorMessages.QUESTION_TYPE_MULTIPLE_WITH_SAME_LABEL);
		case REPORT_WITHOUT_INFO:
			return getMessage(EvaluationErrorMessages.REPORT_WITHOUT_INFO);
		case REPORT_WITHOUT_COMPETENCES:
			return getMessage(EvaluationErrorMessages.REPORT_WITHOUT_COMPETENCES);
		case REPORT_WITHOUT_KPIS:
			return getMessage(EvaluationErrorMessages.REPORT_WITHOUT_KPIS);
		default:
			return super.buildMessage();
		}		
	}
}