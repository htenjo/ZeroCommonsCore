//=======================================================================
// ARCHIVO ZeroPersistentException.java
// FECHA CREACIÓN: 23/02/2010
//=======================================================================
package co.zero.common.exception;

import co.zero.common.constant.ZeroErrorMessage;

/**
 * Clase que reune a las excepciones que no son generadas 
 * directamente por la aplicacion
 * @author Hernán Tenjo
 * @version 1.0
 */
public class ZeroPersistenceException extends ZeroException{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Codigo de los errores manejados por esta excepcion
	protected static final int DEFAULT_CODE_RANGE = ZeroException.DEFAULT_CODE_RANGE;
	public static final int ILLEGAL_STATE_FOR_ENTITY_MANAGER = DEFAULT_CODE_RANGE + 1;
	public static final int BAD_PARAMETERS_FINDING_ENTITY = DEFAULT_CODE_RANGE + 2;
	public static final int TRANSACTION_REQUIERED = DEFAULT_CODE_RANGE + 3;
	public static final int ILLEGAL_ENTITY_STATE = DEFAULT_CODE_RANGE + 4;
			
	/**
	 * Metodo constructor de la excepción
	 * @param errorCode Codigo que identifica a la excepción
	 */
	public ZeroPersistenceException(int errorCode){
		super(errorCode);
	}
		
	/**
	 * Metodo constructor de la excepcion cuando no se desea 
	 * especificar un codigo de error específico
	 * @param e Excepción original
	 */
	public ZeroPersistenceException(Throwable e){
		super(e);
	}
	
	/**
	 * Metodo constructor de la excepción
	 * @param errorCode Codigo que identifica a la excepción
	 * @param e Traza de la excepción original
	 */
	public ZeroPersistenceException(int errorCode, Throwable e){
		super(errorCode, e);
	}
	
	/**
	 * Constructor auxiliar cuando solo se requiere de un parámetro 
	 * @param errorCode Codigo que identifica a la excepción
	 * @param parameter Parametro a reemplazar en el mensaje original
	 */
	public ZeroPersistenceException(int errorCode, String... parameter){
		super(errorCode, parameter);
	}
	
	/**
	 * Constructor auxiliar cuando solo se requiere de un parámetro 
	 * @param errorCode Codigo que identifica a la excepción
	 * @param e Traza de la excepción original
	 * @param parameter Parametro a reemplazar en el mensaje original
	 */
	public ZeroPersistenceException(int errorCode, Throwable e, String... parameter){
		super(errorCode, e, parameter);
	}
	
	/*
	 * (non-Javadoc)
	 * @see co.zero.hcm.exception.HcmException#buildMessage()
	 */
	@Override
	protected String buildMessage() {			
		switch (errorCode) {
		case ILLEGAL_STATE_FOR_ENTITY_MANAGER:
			return getMessage(ZeroErrorMessage.ILLEGAL_STATE_FOR_ENTITY_MANAGER);
		case BAD_PARAMETERS_FINDING_ENTITY:
			return getMessage(ZeroErrorMessage.BAD_PARAMETERS_FINDING_ENTITY);
		case ILLEGAL_ENTITY_STATE:
			return getMessage(ZeroErrorMessage.ILLEGAL_ENTITY_STATE);
		case TRANSACTION_REQUIERED:
			return getMessage(ZeroErrorMessage.TRANSACTION_REQUIERED);		
		default:
			return getMessage(ZeroErrorMessage.UNKNOWN_EXCEPTION);
		}
	}
}