//=======================================================================
// ARCHIVO KpiException.java
// FECHA CREACIÓN: 2012/08/15
//=======================================================================
package co.zero.kpi.exception;

import javax.ejb.ApplicationException;

import co.zero.common.exception.ZeroApplicationException;
import co.zero.hcm.exception.HcmException;

/**
 * Clase que representa una excepcion generada en un proceso de negocio en el modulo KPI
 * @author Hernán Tenjo
 * @version 1.0
 */
@ApplicationException(rollback = true)
public class KpiException extends ZeroApplicationException{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;	
	public static final int DEFAULT_CODE_RANGE = HcmException.DEFAULT_CODE_RANGE + 3000;
		
	//Excepciones del módulo KPI
	public static final int DELETE_STRATEGIES_BY_EVALUATION_WITH_DEPENDENCIES = DEFAULT_CODE_RANGE + 1;
	public static final int DELETE_METRIC_GENERAL_BY_EVALUATION_WITH_DEPENDENCIES = DEFAULT_CODE_RANGE + 2;
	public static final int METRIC_PERIOD_NOT_AVAILABLE = DEFAULT_CODE_RANGE + 3;
	public static final int UPDATE_METRIC_GENERAL_PERIODICITY_WITH_METRIC_PARTIALS = DEFAULT_CODE_RANGE + 4;
	
	public static final int METRIC_UPDATE_WITH_PARTIALS = DEFAULT_CODE_RANGE + 5;
	public static final int GOAL_INVALID_CODE = DEFAULT_CODE_RANGE + 6;
	public static final int METRIC_INVALID_CODE = DEFAULT_CODE_RANGE + 7;
	public static final int INVALID_EVALUATION_NAME = DEFAULT_CODE_RANGE + 8;
	public static final int MULTIPLE_EVALUATIONS_WITH_SAME_NAME_IN_COMPANY = DEFAULT_CODE_RANGE + 9;
	public static final int INVALID_METRIC_TYPE = DEFAULT_CODE_RANGE + 10;
	public static final int METRIC_NOT_FOUNT_BY_CODE = DEFAULT_CODE_RANGE + 11;
	public static final int INVALID_PARTIAL_FORMULA_FOR_DATES = DEFAULT_CODE_RANGE + 12;
	public static final int UNAPPROVED_GOAL = DEFAULT_CODE_RANGE + 13;
	public static final int PERIOD_NOT_FOUND = DEFAULT_CODE_RANGE + 14;
	public static final int PERIOD_WITHOUT_TRACKING = DEFAULT_CODE_RANGE + 15;
	public static final int GOAL_WITH_TRACKING = DEFAULT_CODE_RANGE + 16;
	
	//Errores para los cargadores genericos de KPI
	public static final int EMPTY_METRIC_TYPE = DEFAULT_CODE_RANGE + 17;
	public static final int EMPTY_OWNER = DEFAULT_CODE_RANGE + 18;
	public static final int INVALID_OWNER = DEFAULT_CODE_RANGE + 19;
	public static final int EMPTY_CODE = DEFAULT_CODE_RANGE + 20;
	public static final int INCORRECT_OWNER = DEFAULT_CODE_RANGE + 21;
	public static final int MULTIPLE_METRICS_WITH_SAME_CODE = DEFAULT_CODE_RANGE + 22;
	public static final int INVALID_METRIC_NAME = DEFAULT_CODE_RANGE + 23;
	public static final int INVALID_VALUE = DEFAULT_CODE_RANGE + 24;
	public static final int EMPTY_GENERAL_FORMULA_TYPE = DEFAULT_CODE_RANGE + 25;
	public static final int EMPTY_PARTIAL_FORMULA_TYPE = DEFAULT_CODE_RANGE + 26;
	public static final int EMPTY_TREND = DEFAULT_CODE_RANGE + 27;
	public static final int INVALID_PERIOD = DEFAULT_CODE_RANGE + 28;
	public static final int METRIC_NOT_EXIST = DEFAULT_CODE_RANGE + 29;
	public static final int EMPTY_RANGE_LABEL = DEFAULT_CODE_RANGE + 30;
	public static final int EMPTY_SEMAPHORE = DEFAULT_CODE_RANGE + 31;
	public static final int INVALID_GOAL_NAME = DEFAULT_CODE_RANGE + 32;
	public static final int MULTIPLE_GOALS_WITH_SAME_CODE = DEFAULT_CODE_RANGE + 33;
	public static final int STRATEGY_NOT_EXIST = DEFAULT_CODE_RANGE + 34;
	public static final int MULTIPLE_STRATEGIES_WITH_SAME_NAME = DEFAULT_CODE_RANGE + 35;
	public static final int GOAL_NOT_EXIST = DEFAULT_CODE_RANGE + 36;
	public static final int NOT_CAN_UPDATE_GOAL = DEFAULT_CODE_RANGE + 37;
	public static final int EMPTY_DIVISION = DEFAULT_CODE_RANGE + 38;
	public static final int NOT_CAN_UPDATE_TRACKINGS = DEFAULT_CODE_RANGE + 39;
	//Eficacia
	public static final int INVALID_ZONE_CODE = DEFAULT_CODE_RANGE + 40;
	public static final int INVALID_PROCESS_CODE = DEFAULT_CODE_RANGE + 41;
	
	public static final int METRIC_NOT_PERIODIC = DEFAULT_CODE_RANGE + 42;
	public static final int FILE_SIZE_TOO_LONG = DEFAULT_CODE_RANGE + 43;
	public static final int EMPTY_TRACKING_TYPE = DEFAULT_CODE_RANGE + 44;
	public static final int INVALID_FILE = DEFAULT_CODE_RANGE + 45;
	public static final int MANY_ROWS = DEFAULT_CODE_RANGE + 46;
	public static final int INVALID_GENERAL_FORMULA_FOR_METRIC_NOT_PERIODIC = DEFAULT_CODE_RANGE + 47;
	
	/**
	 * Metodo constructor de la excepción
	 * @param errorCode Codigo que identifica a la excepción
	 */
	public KpiException(int errorCode){
		super(errorCode);
	}
		
	/**
	 * Metodo constructor de la excepcion cuando no se desea 
	 * especificar un codigo de error específico
	 * @param e Excepción original
	 */
	public KpiException(Throwable e){
		super(e);
	}
	
	/**
	 * Metodo constructor de la excepción
	 * @param errorCode Codigo que identifica a la excepción
	 * @param e Traza de la excepción original
	 */
	public KpiException(int errorCode, Throwable e){
		super(errorCode, e);
	}
	
	/**
	 * Constructor auxiliar cuando solo se requiere de un parámetro 
	 * @param errorCode Codigo que identifica a la excepción
	 * @param parameter Parametro a reemplazar en el mensaje original
	 */
	public KpiException(int errorCode, String... parameter){
		super(errorCode, parameter);
	}
	
	/**
	 * Constructor auxiliar cuando solo se requiere de un parámetro 
	 * @param errorCode Codigo que identifica a la excepción
	 * @param e Traza de la excepción original
	 * @param parameter Parametro a reemplazar en el mensaje original
	 */
	public KpiException(int errorCode, Throwable e, String... parameter){
		super(errorCode, e, parameter);
	}
			
	/*
	 * (non-Javadoc)
	 * @see co.zero.hcm.exception.HcmException#buildMessage()
	 */
	@Override
	protected String buildMessage() {
		switch (errorCode) {
		case DELETE_STRATEGIES_BY_EVALUATION_WITH_DEPENDENCIES:
			return getMessage(KpiErrorMessages.DELETE_STRATEGIES_BY_EVALUATION_WITH_DEPENDENCES);
		case DELETE_METRIC_GENERAL_BY_EVALUATION_WITH_DEPENDENCIES:
			return getMessage(KpiErrorMessages.DELETE_METRICS_BY_EVALUATION_WITH_DEPENDENCES);
		case METRIC_PERIOD_NOT_AVAILABLE:
			return getMessage(KpiErrorMessages.METRIC_PERIOD_NOT_AVAILABLE);
		case METRIC_UPDATE_WITH_PARTIALS:
			return getMessage(KpiErrorMessages.METRIC_UPDATE_WITH_PARTIALS_ERROR);
		case UPDATE_METRIC_GENERAL_PERIODICITY_WITH_METRIC_PARTIALS:
			return getMessage(KpiErrorMessages.UPDATE_METRIC_GENERAL_PERIODICITY_WITH_METRIC_PARTIALS);
		case GOAL_INVALID_CODE:
			return getMessage(KpiErrorMessages.GOAL_INVALID_CODE);
		case METRIC_INVALID_CODE:
			return getMessage(KpiErrorMessages.METRIC_INVALID_CODE);
		case INVALID_EVALUATION_NAME:
			return getMessage(KpiErrorMessages.INVALID_EVALUATION_NAME);
		case MULTIPLE_EVALUATIONS_WITH_SAME_NAME_IN_COMPANY:
			return getMessage(KpiErrorMessages.MULTIPLE_EVALUATIONS_WITH_SAME_NAME_IN_COMPANY);
		case INVALID_METRIC_TYPE:
			return getMessage(KpiErrorMessages.INVALID_METRIC_TYPE);
		case METRIC_NOT_FOUNT_BY_CODE:
			return getMessage(KpiErrorMessages.METRIC_NOT_FOUNT_BY_CODE);
		case INVALID_PARTIAL_FORMULA_FOR_DATES:
			return getMessage(KpiErrorMessages.INVALID_PARTIAL_FORMULA_FOR_DATES);
		case UNAPPROVED_GOAL:
			return getMessage(KpiErrorMessages.UNAPPROVED_GOAL);
		case PERIOD_NOT_FOUND:
			return getMessage(KpiErrorMessages.PERIOD_NOT_FOUND);
		case PERIOD_WITHOUT_TRACKING:
			return getMessage(KpiErrorMessages.PERIOD_WITHOUT_TRACKING);
		case GOAL_WITH_TRACKING:
			return getMessage(KpiErrorMessages.GOAL_WITH_TRACKING);
		case EMPTY_METRIC_TYPE:
			return getMessage(KpiErrorMessages.EMPTY_METRIC_TYPE);
		case EMPTY_OWNER:
			return getMessage(KpiErrorMessages.EMPTY_OWNER);
		case INVALID_OWNER:
			return getMessage(KpiErrorMessages.INVALID_OWNER);
		case EMPTY_CODE:
			return getMessage(KpiErrorMessages.EMPTY_CODE);
		case INCORRECT_OWNER:
			return getMessage(KpiErrorMessages.INCORRECT_OWNER);
		case MULTIPLE_METRICS_WITH_SAME_CODE:
			return getMessage(KpiErrorMessages.MULTIPLE_METRICS_WITH_SAME_CODE);
		case INVALID_METRIC_NAME:
			return getMessage(KpiErrorMessages.INVALID_METRIC_NAME);
		case INVALID_VALUE:
			return getMessage(KpiErrorMessages.INVALID_VALUE);
		case EMPTY_GENERAL_FORMULA_TYPE:
			return getMessage(KpiErrorMessages.EMPTY_GENERAL_FORMULA_TYPE);
		case EMPTY_PARTIAL_FORMULA_TYPE:
			return getMessage(KpiErrorMessages.EMPTY_PARTIAL_FORMULA_TYPE);
		case EMPTY_TREND:
			return getMessage(KpiErrorMessages.EMPTY_TREND);
		case INVALID_PERIOD:
			return getMessage(KpiErrorMessages.INVALID_PERIOD);
		case METRIC_NOT_EXIST:
			return getMessage(KpiErrorMessages.METRIC_NOT_EXIST);
		case EMPTY_RANGE_LABEL:
			return getMessage(KpiErrorMessages.EMPTY_RANGE_LABEL);
		case EMPTY_SEMAPHORE:
			return getMessage(KpiErrorMessages.EMPTY_SEMAPHORE);
		case INVALID_GOAL_NAME:
			return getMessage(KpiErrorMessages.INVALID_GOAL_NAME);
		case MULTIPLE_GOALS_WITH_SAME_CODE:
			return getMessage(KpiErrorMessages.MULTIPLE_GOALS_WITH_SAME_CODE);
		case STRATEGY_NOT_EXIST:
			return getMessage(KpiErrorMessages.STRATEGY_NOT_EXIST);
		case MULTIPLE_STRATEGIES_WITH_SAME_NAME:
			return getMessage(KpiErrorMessages.MULTIPLE_STRATEGIES_WITH_SAME_NAME);
		case GOAL_NOT_EXIST:
			return getMessage(KpiErrorMessages.GOAL_NOT_EXIST);
		case NOT_CAN_UPDATE_GOAL:
			return getMessage(KpiErrorMessages.NOT_CAN_UPDATE_GOAL);
		case EMPTY_DIVISION:
			return getMessage(KpiErrorMessages.EMPTY_DIVISION);
		case NOT_CAN_UPDATE_TRACKINGS:
			return getMessage(KpiErrorMessages.NOT_CAN_UPDATE_TRACKINGS);
		case INVALID_ZONE_CODE:
			return getMessage(KpiErrorMessages.INVALID_ZONE_CODE);
		case INVALID_PROCESS_CODE:
			return getMessage(KpiErrorMessages.INVALID_PROCESS_CODE);
		case METRIC_NOT_PERIODIC:
			return getMessage(KpiErrorMessages.METRIC_NOT_PERIODIC);
		case FILE_SIZE_TOO_LONG:
			return getMessage(KpiErrorMessages.FILE_SIZE_TOO_LONG);
		case EMPTY_TRACKING_TYPE:
			return getMessage(KpiErrorMessages.EMPTY_TRACKING_TYPE);
		case INVALID_FILE:
			return getMessage(KpiErrorMessages.INVALID_FILE);
		case MANY_ROWS:
			return getMessage(KpiErrorMessages.MANY_ROWS);
		case INVALID_GENERAL_FORMULA_FOR_METRIC_NOT_PERIODIC:
			return getMessage(KpiErrorMessages.INVALID_GENERAL_FORMULA_FOR_METRIC_NOT_PERIODIC);
		default:
			return super.buildMessage();
		}		
	}
}