//=======================================================================
// ARCHIVO ZeroApplicationException.java
// FECHA CREACIÓN: 23/02/2010
//=======================================================================
package co.zero.common.exception;

import co.zero.common.constant.ZeroErrorMessage;

/**
 * Clase que representa a una excepcion de las aplicaciones de Zero
 * @author Hernán Tenjo
 * @version 1.0
 */
public class ZeroApplicationException extends ZeroException{
	private static final long serialVersionUID = 1L;
	//Constantes comunes a todas las excepciones de aplicacion
	//de los modulos
	protected static final int DEFAULT_CODE_RANGE = ZeroException.DEFAULT_CODE_RANGE + 1000;
	public static final int METHOD_NOT_IMPLEMENTED_YET = DEFAULT_CODE_RANGE;
	public static final int ENTITY_ALREADY_EXIST = DEFAULT_CODE_RANGE + 1;
	public static final int ENTITY_NOT_EXIST = DEFAULT_CODE_RANGE + 2;
	public static final int NON_UNIQUE_RESULT = DEFAULT_CODE_RANGE + 3;
	public static final int NULL_GENERIC_OBJECT = DEFAULT_CODE_RANGE + 4;
	public static final int ENTITY_DTO_NOT_EXIST = DEFAULT_CODE_RANGE + 5;
	public static final int DELETING_OBJECT_ALREADY_USED = DEFAULT_CODE_RANGE + 6;
	public static final int FILE_NOT_FOUND = DEFAULT_CODE_RANGE + 7;
	public static final int STRING_TOO_LONG = DEFAULT_CODE_RANGE + 8;
	public static final int UNIQUE_CONSTRAINT_VIOLATION = DEFAULT_CODE_RANGE + 9;
	public static final int REQUIRED_ATTRIBUTE_NOT_FOUND = DEFAULT_CODE_RANGE + 10;
	public static final int DELETING_OBJECT_REQUIRED = DEFAULT_CODE_RANGE + 11;
	public static final int COLLECTION_INVALID = DEFAULT_CODE_RANGE + 12;
	public static final int INVALID_INTROSPECTION_PROCESS = DEFAULT_CODE_RANGE + 13;
	public static final int DATE_WITHOUT_REQUIRED_FORMAT = DEFAULT_CODE_RANGE + 14;
	public static final int INVALID_DATE_RANGE_START_END = DEFAULT_CODE_RANGE + 15;
	public static final int INVALID_NUMBER_AS_STRING_PARSING = DEFAULT_CODE_RANGE + 16;
	public static final int INVALID_PERSISTENT_TYPE = DEFAULT_CODE_RANGE + 17;
	public static final int DELETING_OBJECT_ERROR = DEFAULT_CODE_RANGE + 18;
	public static final int UPDATING_OBJECT_ERROR = DEFAULT_CODE_RANGE + 19;
	public static final int METHOD_WITHOUT_ACCESS_FROM_CLIENT = DEFAULT_CODE_RANGE + 20;
	public static final int FILE_FORMAT_ERROR = DEFAULT_CODE_RANGE + 21;
	public static final int ID_ARRAY_INVALID = DEFAULT_CODE_RANGE + 22;
	public static final int JOB_NULL = DEFAULT_CODE_RANGE + 23;
	public static final int INVALID_ENTITY_ATTRIBUTE = DEFAULT_CODE_RANGE + 24;
	public static final int INVALID_NUMBER_IN_RANGE = DEFAULT_CODE_RANGE + 25;
	public static final int FILE_EXTENSION_INVALID = DEFAULT_CODE_RANGE + 26;

	/**
	 * Metodo constructor de la excepción
	 * @param errorCode Codigo que identifica a la excepción
	 */
	public ZeroApplicationException(int errorCode){
		super(errorCode);
	}
		
	public ZeroApplicationException(String errorMessage){
		super(errorMessage);
	}
	/**
	 * Metodo constructor de la excepcion cuando no se desea 
	 * especificar un codigo de error específico
	 * @param e Excepción original
	 */
	public ZeroApplicationException(Throwable e){
		super(e);
	}
	
	/**
	 * Metodo constructor de la excepción
	 * @param errorCode Codigo que identifica a la excepción
	 * @param e Traza de la excepción original
	 */
	public ZeroApplicationException(int errorCode, Throwable e){
		super(errorCode, e);
	}
	
	/**
	 * Constructor auxiliar cuando solo se requiere de un parámetro 
	 * @param errorCode Codigo que identifica a la excepción
	 * @param parameter Parametro a reemplazar en el mensaje original
	 */
	public ZeroApplicationException(int errorCode, String... parameter){
		super(errorCode, parameter);
	}
	
	/**
	 * Constructor auxiliar cuando solo se requiere de un parámetro 
	 * @param errorCode Codigo que identifica a la excepción
	 * @param e Traza de la excepción original
	 * @param parameter Parametro a reemplazar en el mensaje original
	 */
	public ZeroApplicationException(int errorCode, Throwable e, String... parameter){
		super(errorCode, e, parameter);
	}
	
	/*
	 * (non-Javadoc)
	 * @see co.zero.hcm.exception.HcmException#buildMessage()
	 */
	@Override
	protected String buildMessage() {
		switch (errorCode) {
		case METHOD_NOT_IMPLEMENTED_YET:
			return getMessage(ZeroErrorMessage.METHOD_NOT_IMPLEMENTED_YET);
		case ENTITY_ALREADY_EXIST:
			return getMessage(ZeroErrorMessage.ENTITY_ALREADY_EXIST);
		case ENTITY_DTO_NOT_EXIST:
			return getMessage(ZeroErrorMessage.ENTITY_DTO_NOT_EXIST);
		case ENTITY_NOT_EXIST:
			return getMessage(ZeroErrorMessage.ENTITY_NOT_EXIST);
		case NON_UNIQUE_RESULT:
			return getMessage(ZeroErrorMessage.NON_UNIQUE_RESULT);
		case NULL_GENERIC_OBJECT:
			return getMessage(ZeroErrorMessage.NULL_GENERIC_OBJECT);
		case DELETING_OBJECT_ALREADY_USED:
			return getMessage(ZeroErrorMessage.DELETE_OBJECT_ALREADY_USED);
		case FILE_NOT_FOUND:
			return getMessage(ZeroErrorMessage.FILE_NOT_FOUND);
		case STRING_TOO_LONG:
			return getMessage(ZeroErrorMessage.STRING_TOO_LONG);
		case UNIQUE_CONSTRAINT_VIOLATION:
			return getMessage(ZeroErrorMessage.UNIQUE_CONSTRAINT_VIOLATION);
		case REQUIRED_ATTRIBUTE_NOT_FOUND:
			return getMessage(ZeroErrorMessage.REQUIRED_ATTRIBUTE_NOT_FOUND);
		case DELETING_OBJECT_REQUIRED:
			return getMessage(ZeroErrorMessage.DELETING_OBJECT_REQUIRED);
		case COLLECTION_INVALID:
			return getMessage(ZeroErrorMessage.COLLECTION_INVALID);
		case INVALID_INTROSPECTION_PROCESS:
			return getMessage(ZeroErrorMessage.INVALID_INTROSPECTION_PROCESS);
		case DATE_WITHOUT_REQUIRED_FORMAT:
			return getMessage(ZeroErrorMessage.DATE_WITHOUT_REQUIRED_FORMAT);
		case INVALID_DATE_RANGE_START_END:
			return getMessage(ZeroErrorMessage.INVALID_DATE_RANGE_START_END);
		case INVALID_NUMBER_AS_STRING_PARSING:
			return getMessage(ZeroErrorMessage.INVALID_NUMBER_AS_STRING_PARSING);
		case INVALID_PERSISTENT_TYPE:
			return getMessage(ZeroErrorMessage.INVALID_PERSISTENT_TYPE);
		case DELETING_OBJECT_ERROR:
			return getMessage(ZeroErrorMessage.DELETING_OBJECT_ERROR);
		case UPDATING_OBJECT_ERROR:
			return getMessage(ZeroErrorMessage.UPDATING_OBJECT_ERROR);
		case METHOD_WITHOUT_ACCESS_FROM_CLIENT:
			return getMessage(ZeroErrorMessage.METHOD_WITHOUT_ACCESS_FROM_CLIENT);
		case FILE_FORMAT_ERROR:
			return getMessage(ZeroErrorMessage.FILE_FORMAT_ERROR);
		case ID_ARRAY_INVALID:
			return getMessage(ZeroErrorMessage.ID_ARRAY_INVALID);
		case INVALID_ENTITY_ATTRIBUTE:
			return getMessage(ZeroErrorMessage.INVALID_ENTITY_ATTRIBUTE);
		case INVALID_NUMBER_IN_RANGE:
			return getMessage(ZeroErrorMessage.INVALID_NUMBER_IN_RANGE);
		case FILE_EXTENSION_INVALID:
			return getMessage(ZeroErrorMessage.FILE_EXTENSION_INVALID);
		default:
			return getMessage(ZeroErrorMessage.UNKNOWN_EXCEPTION);
		}		
	}
}