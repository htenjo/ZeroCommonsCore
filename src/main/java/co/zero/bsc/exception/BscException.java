//=======================================================================
// ARCHIVO BscException.java
// FECHA CREACIÓN: Sep 28, 2009
//=======================================================================
package co.zero.bsc.exception;

import javax.ejb.ApplicationException;

import co.zero.common.exception.ZeroApplicationException;

/**
 * Clase que representa una excepcion generada en un proceso de negocio 
 * en el modulo Bsc
 * @author Hernán Tenjo
 * @version 1.0
 */
@ApplicationException(rollback = true)
public class BscException extends ZeroApplicationException{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;	
	protected static final int DEFAULT_CODE_RANGE = ZeroApplicationException.DEFAULT_CODE_RANGE + 2000;
		
	//Excepciones del módulo BSC
	public static final int DELETE_BSC_NOT_OWN_GOAL = DEFAULT_CODE_RANGE + 1;
	public static final int DELETE_BSC_GOAL_WITH_CHILDREN = DEFAULT_CODE_RANGE + 2;
	public static final int DELETE_BSC_EVALUATION_WITH_STRATEGIES = DEFAULT_CODE_RANGE + 3;
	public static final int DELETE_BSC_STRATEGY_WITH_METRICS = DEFAULT_CODE_RANGE + 4;
	public static final int DELETE_BSC_METRIC_WITH_GOALS = DEFAULT_CODE_RANGE + 5;
	public static final int DELETE_BSC_GOAL_WITH_EVALUATIONS = DEFAULT_CODE_RANGE + 6;
	public static final int INVALID_BSC_CHILD_METRIC_UPDATE = DEFAULT_CODE_RANGE + 7;
	public static final int METRIC_UPDATE_WITH_PARTIALS = DEFAULT_CODE_RANGE + 8;
	public static final int METRIC_PERIOD_ALREADY_USED = DEFAULT_CODE_RANGE + 9;
	public static final int METRIC_PARTIAL_NOT_DEFINED = DEFAULT_CODE_RANGE + 10;
	public static final int METRIC_UPDATE_WITH_TRACKING = DEFAULT_CODE_RANGE + 11;
		
	/**
	 * Metodo constructor de la excepción
	 * @param errorCode Codigo que identifica a la excepción
	 */
	public BscException(int errorCode){
		super(errorCode);
	}
		
	/**
	 * Metodo constructor de la excepcion cuando no se desea 
	 * especificar un codigo de error específico
	 * @param e Excepción original
	 */
	public BscException(Throwable e){
		super(e);
	}
	
	/**
	 * Metodo constructor de la excepción
	 * @param errorCode Codigo que identifica a la excepción
	 * @param e Traza de la excepción original
	 */
	public BscException(int errorCode, Throwable e){
		super(errorCode, e);
	}
	
	/**
	 * Constructor auxiliar cuando solo se requiere de un parámetro 
	 * @param errorCode Codigo que identifica a la excepción
	 * @param parameter Parametro a reemplazar en el mensaje original
	 */
	public BscException(int errorCode, String... parameter){
		super(errorCode, parameter);
	}
	
	/**
	 * Constructor auxiliar cuando solo se requiere de un parámetro 
	 * @param errorCode Codigo que identifica a la excepción
	 * @param e Traza de la excepción original
	 * @param parameter Parametro a reemplazar en el mensaje original
	 */
	public BscException(int errorCode, Throwable e, String... parameter){
		super(errorCode, e, parameter);
	}
			
	/*
	 * (non-Javadoc)
	 * @see com.zero.hcm.exception.HcmException#buildMessage()
	 */
	@Override
	protected String buildMessage() {
		switch (errorCode) {
		case DELETE_BSC_NOT_OWN_GOAL:
			return getMessage(BscErrorMessages.DELETE_BSC_NOT_OWN_GOAL);
		case DELETE_BSC_GOAL_WITH_CHILDREN:
			return getMessage(BscErrorMessages.DELETE_BSC_GOAL_WITH_CHILDREN);
		case DELETE_BSC_STRATEGY_WITH_METRICS:
			return getMessage(BscErrorMessages.DELETE_BSC_STRATEGY_WITH_METRICS);
		case DELETE_BSC_METRIC_WITH_GOALS:
			return getMessage(BscErrorMessages.DELETE_BSC_METRIC_WITH_GOALS);
		case DELETE_BSC_GOAL_WITH_EVALUATIONS:
			return getMessage(BscErrorMessages.DELETE_BSC_GOAL_WITH_EVALUATIONS);
		case INVALID_BSC_CHILD_METRIC_UPDATE:
			return getMessage(BscErrorMessages.INVALID_BSC_CHILD_METRIC_UPDATE);
		case DELETE_BSC_EVALUATION_WITH_STRATEGIES:
			return getMessage(BscErrorMessages.DELETE_BSC_EVALUATION_WITH_STRATEGIES);
		case METRIC_UPDATE_WITH_PARTIALS:
			return getMessage(BscErrorMessages.METRIC_UPDATE_WITH_PARTIALS_ERROR);
		case METRIC_PERIOD_ALREADY_USED:
			return getMessage(BscErrorMessages.METRIC_PERIOD_ALREADY_USED);
		case METRIC_PARTIAL_NOT_DEFINED:
			return getMessage(BscErrorMessages.METRIC_PARTIAL_NOT_DEFINED);
		case METRIC_UPDATE_WITH_TRACKING:
			return getMessage(BscErrorMessages.METRIC_UPDATE_WITH_TRACKING);
		default:
			return super.buildMessage();
		}		
	}
}