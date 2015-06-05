//=======================================================================
// ARCHIVO HcmPersistentApplicationException.java
// FECHA CREACIÓN: Sep 28, 2009
//=======================================================================
package co.zero.hcm.exception;

import javax.ejb.ApplicationException;

import co.zero.common.exception.ZeroApplicationException;

/**
 * Clase que representa una excepcion generada en un proceso de negocio 
 * en el modulo Hcm
 * @author Hernán Tenjo
 * @version 1.0
 */
@ApplicationException(rollback = true)
public class HcmException extends ZeroApplicationException{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;	
	public static final int DEFAULT_CODE_RANGE = ZeroApplicationException.DEFAULT_CODE_RANGE + 1000;
	public static final int USER_NOT_FOUND = DEFAULT_CODE_RANGE;
	public static final int INVALID_AUTHENTICATION = DEFAULT_CODE_RANGE + 1;
	public static final int USER_INACTIVE = DEFAULT_CODE_RANGE + 2;
	public static final int MODULE_NOT_FOUND = DEFAULT_CODE_RANGE + 3;
	public static final int MODULE_NOT_ACTIVE_FOR_COMPANY = DEFAULT_CODE_RANGE + 4;
	public static final int USER_WITHOUT_PRIVILEGES = DEFAULT_CODE_RANGE + 5;	
	public static final int ADAPT_FILE_TO_BYTES_ERROR = DEFAULT_CODE_RANGE + 6;
	public static final int USER_TYPE_NOT_SUPPORTED = DEFAULT_CODE_RANGE + 7;
	public static final int ILLEGAL_USERNAME = DEFAULT_CODE_RANGE + 8;
	public static final int SCREEN_NOT_CONFIGURED = DEFAULT_CODE_RANGE + 9;
	public static final int FIELD_UI_NOT_CONFIGURED = DEFAULT_CODE_RANGE + 10;
	public static final int DELETE_CURRENT_EMPLOYEE = DEFAULT_CODE_RANGE + 11;
	public static final int CHANGE_PASSWORD_NEW_PASSWORD_CONFIRM_ERROR = DEFAULT_CODE_RANGE + 12;
	public static final int CHANGE_PASSWORD_POLICY_REQUIREMENT_ERROR = DEFAULT_CODE_RANGE + 13;
	public static final int SEND_EMAIL_ERROR = DEFAULT_CODE_RANGE + 14;
	public static final int COMPANY_SETTINGS_NOT_CONFIGURED = DEFAULT_CODE_RANGE + 15;
	public static final int UPDATING_EMPLOYMENT_WITH_EMPLOYEE = DEFAULT_CODE_RANGE + 16;
    public static final int INVALID_DATA_ITEM = DEFAULT_CODE_RANGE + 17;
    public static final int INVALID_USERNAME_FOR_USE = DEFAULT_CODE_RANGE + 18;
	public static final int ZONE_INVALID_CODE = DEFAULT_CODE_RANGE + 19;
	public static final int BUSINESS_UNIT_INVALID_CODE = DEFAULT_CODE_RANGE + 20;
	public static final int PROCESS_INVALID_CODE = DEFAULT_CODE_RANGE + 21;
	public static final int EMPLOYEE_NOT_FOUND = DEFAULT_CODE_RANGE + 22;
		
	/**
	 * Metodo constructor de la excepción
	 * @param errorCode Codigo que identifica a la excepción
	 */
	public HcmException(int errorCode){
		super(errorCode);
	}
		
	/**
	 * Metodo constructor de la excepcion cuando no se desea 
	 * especificar un codigo de error específico
	 * @param e Excepción original
	 */
	public HcmException(Throwable e){
		super(e);
	}
	
	/**
	 * Metodo constructor de la excepción
	 * @param errorCode Codigo que identifica a la excepción
	 * @param e Traza de la excepción original
	 */
	public HcmException(int errorCode, Throwable e){
		super(errorCode, e);
	}
	
	/**
	 * Constructor auxiliar cuando solo se requiere de un parámetro 
	 * @param errorCode Codigo que identifica a la excepción
	 * @param parameter Parametro a reemplazar en el mensaje original
	 */
	public HcmException(int errorCode, String... parameter){
		super(errorCode, parameter);
	}
	
	/**
	 * Constructor auxiliar cuando solo se requiere de un parámetro 
	 * @param errorCode Codigo que identifica a la excepción
	 * @param e Traza de la excepción original
	 * @param parameter Parametro a reemplazar en el mensaje original
	 */
	public HcmException(int errorCode, Throwable e, String... parameter){
		super(errorCode, e, parameter);
	}
			
	/*
	 * (non-Javadoc)
	 * @see co.zero.hcm.exception.HcmException#buildMessage()
	 */
	@Override
	protected String buildMessage() {
		switch (errorCode) {				
		case USER_NOT_FOUND:
			return getMessage(HcmErrorMessages.USER_NOT_FOUND);
		case INVALID_AUTHENTICATION:
			return getMessage(HcmErrorMessages.INVALID_AUTHENTICATION);
		case USER_INACTIVE:
			return getMessage(HcmErrorMessages.USER_INACTIVE);
		case MODULE_NOT_FOUND:
			return getMessage(HcmErrorMessages.MODULE_NOT_FOUND);
		case MODULE_NOT_ACTIVE_FOR_COMPANY:
			return getMessage(HcmErrorMessages.MODULE_NOT_ACTIVE_FOR_COMPANY);
		case USER_WITHOUT_PRIVILEGES:
			return getMessage(HcmErrorMessages.USER_WITHOUT_PRIVILEGES);
		case ADAPT_FILE_TO_BYTES_ERROR:
			return getMessage(HcmErrorMessages.ADAPT_FILE_TO_BYTES_ERROR);
		case USER_TYPE_NOT_SUPPORTED:
			return getMessage(HcmErrorMessages.USER_TYPE_NOT_SUPPORTED);
		case ILLEGAL_USERNAME:
			return getMessage(HcmErrorMessages.ILLEGAL_USERNAME);
		case SCREEN_NOT_CONFIGURED:
			return getMessage(HcmErrorMessages.SCREEN_NOT_CONFIGURED);
		case FIELD_UI_NOT_CONFIGURED:
			return getMessage(HcmErrorMessages.FIELD_UI_NOT_CONFIGURED);
		case DELETE_CURRENT_EMPLOYEE:
			return getMessage(HcmErrorMessages.DELETE_CURRENT_EMPLOYEE);
		case CHANGE_PASSWORD_NEW_PASSWORD_CONFIRM_ERROR:
			return getMessage(HcmErrorMessages.CHANGE_PASSWORD_NEW_PASSWORD_CONFIRM_ERROR);
		case CHANGE_PASSWORD_POLICY_REQUIREMENT_ERROR:
			return getMessage(HcmErrorMessages.CHANGE_PASSWORD_POLICY_REQUIREMENT_ERROR);
		case SEND_EMAIL_ERROR:
			return getMessage(HcmErrorMessages.SEND_EMAIL_ERROR);
		case COMPANY_SETTINGS_NOT_CONFIGURED:
			return getMessage(HcmErrorMessages.COMPANY_SETTINGS_NOT_CONFIGURED);
		case UPDATING_EMPLOYMENT_WITH_EMPLOYEE:
			return getMessage(HcmErrorMessages.UPDATING_EMPLOYMENT_WITH_EMPLOYEE);
        case INVALID_DATA_ITEM:
			return getMessage(HcmErrorMessages.INVALID_DATA_ITEM);
        case INVALID_USERNAME_FOR_USE:
        	return getMessage(HcmErrorMessages.INVALID_USERNAME_FOR_USE);
        case ZONE_INVALID_CODE:
        	return getMessage(HcmErrorMessages.ZONE_INVALID_CODE);
        case BUSINESS_UNIT_INVALID_CODE:
        	return getMessage(HcmErrorMessages.BUSINESS_UNIT_INVALID_CODE);
        case PROCESS_INVALID_CODE:
        	return getMessage(HcmErrorMessages.PROCESS_INVALID_CODE);
		default:
			return super.buildMessage();
		}
	}
}