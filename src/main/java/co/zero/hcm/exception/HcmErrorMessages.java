//=======================================================================
// ARCHIVO HcmErrorMessages.java
// FECHA CREACIÓN: Sep 25, 2009
//=======================================================================
package co.zero.hcm.exception;

import co.zero.common.constant.GenericConstants;

/**
 * Clase con todos los mensajes que se van a utilizar 
 * en el manejo de errores de HCM
 * @author Hernán Tenjo
 * @version 1.0
 */
public class HcmErrorMessages {
	public static final String USER_NOT_FOUND = 
		"::: El usuario ["+GenericConstants.MSG_WILDCARD+
		"] no se ha encontrado en el sistema";
	
	public static final String INVALID_AUTHENTICATION = 
		"::: El password ["+GenericConstants.MSG_WILDCARD+
		"] no es correcto para el usuario";
	
	public static final String USER_INACTIVE = 
		"::: El usuario ["+GenericConstants.MSG_WILDCARD+
		"] se encuentra inactivo";
	
	public static final String MODULE_NOT_FOUND = 
		"::: El módulo con nombre ["+GenericConstants.MSG_WILDCARD+
		"] no se ha encontrado en el sistema";
	
	public static final String MODULE_NOT_ACTIVE_FOR_COMPANY = 
		"::: El módulo ["+GenericConstants.MSG_WILDCARD+
		"] no se encuentra activo para la compañía ["+
		GenericConstants.MSG_WILDCARD+"]";	
	
	public static final String USER_WITHOUT_PRIVILEGES = 
		"::: El usuario ["+GenericConstants.MSG_WILDCARD+
		"] no tiene los roles requeridos " +
		"'n::: para garantizar su ingreso al módulo ["+
		GenericConstants.MSG_WILDCARD+"]";
		
	public static final String ADAPT_FILE_TO_BYTES_ERROR = 
		"::: Se produjo un error al transformar un archivo en un byte[]";
	
	public static final String USER_TYPE_NOT_SUPPORTED = 
		"::: El tipo de usuario ["+GenericConstants.MSG_WILDCARD+
		"] no es soportado actualmente";
	
	public static final String ILLEGAL_USERNAME = 
		"::: El username del usuario no debe ser nulo ni vacio";
	
	public static final String SCREEN_NOT_CONFIGURED = 
		"::: El screen al que intenta acceder asociado al componente [" + 
		GenericConstants.MSG_WILDCARD + "], " + "no se ha configurado apropiadamente";
	
	public static final String FIELD_UI_NOT_CONFIGURED = 
		"::: Los campos del screen asociado al componente ["+
		GenericConstants.MSG_WILDCARD+"], no se han configurado apropiadamente";
	
	public static final String DELETE_CURRENT_EMPLOYEE = 
		"::: Para eliminar el usuario ["+GenericConstants.MSG_WILDCARD+"] " +
				"debe ingresar al sistema con un usuario diferente";
	
	public static final String CHANGE_PASSWORD_NEW_PASSWORD_CONFIRM_ERROR = 
		"::: La nueva clave y su correspondiente confirmación deben ser iguales";
	
	public static final String CHANGE_PASSWORD_POLICY_REQUIREMENT_ERROR = 
		"::: La nueva clave no cumple con los requerimientos [" + GenericConstants.MSG_WILDCARD + "]";
	
	public static final String SEND_EMAIL_ERROR = "::: Error al tratar de enviar email ["+GenericConstants.MSG_WILDCARD+"]";
	
	public static final String COMPANY_SETTINGS_NOT_CONFIGURED = 
			"::: Los CompanySettings no han sido configurados para la compañía [id=" + GenericConstants.MSG_WILDCARD + "]";
	
	public static final String UPDATING_EMPLOYMENT_WITH_EMPLOYEE = 
			"::: El Employment[id= "+GenericConstants.MSG_WILDCARD+"] tiene empleado asociado, por lo que no es posible actualizarlo";
    
    public static final String INVALID_DATA_ITEM = "::: El grupo de opciones no presenta la opción dada ["+GenericConstants.MSG_WILDCARD+"]";
    
    public static final String INVALID_USERNAME_FOR_USE = "::: No es posible utilizar este usuario [" + 
    		GenericConstants.MSG_WILDCARD + "], puede que ya exista en el sistema";
    
    public static final String ZONE_INVALID_CODE = "::: El código de la zona [" + GenericConstants.MSG_WILDCARD + 
			"] ya se encuentra en la compania";
    
    public static final String BUSINESS_UNIT_INVALID_CODE = "::: El código de la unidad de negocio [" + GenericConstants.MSG_WILDCARD + 
			"] ya se encuentra en la compania";
    
    public static final String PROCESS_INVALID_CODE = "::: El código del proceso [" + GenericConstants.MSG_WILDCARD + 
			"] ya se encuentra en la compania";
}