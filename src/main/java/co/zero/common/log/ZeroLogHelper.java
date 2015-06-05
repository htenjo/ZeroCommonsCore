//=======================================================================
// ARCHIVO ZeroLogHelper.java
// FECHA CREACIÓN: 19/01/2011
//=======================================================================
package co.zero.common.log;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import co.zero.common.constant.GenericConstants;

/**
 * Clase que gestiona la generación de los mensajes de log de la aplicación
 * @author Andres Diaz
 * @version 1.0
 */
public class ZeroLogHelper {
	//Códigos de los mensajes que se desean generar
	private static final int DEFAULT_CODE_RANGE = 0;
	public static final int ENTER_METHOD_MESSAGE = DEFAULT_CODE_RANGE + 1;
	public static final int EXIT_METHOD_MESSAGE = DEFAULT_CODE_RANGE + 2;
	public static final int ENTER_WEB_METHOD_MESSAGE = DEFAULT_CODE_RANGE + 3;
	public static final int EXIT_WEB_METHOD_MESSAGE = DEFAULT_CODE_RANGE + 4;
	
	/**
	 * Metodo que me permite obtener un Mensaje de log partiendo de una clave numerica 
	 * @param logCode : clave numerica que me indica que mensaje de log quiero obtener
	 * @param logParameters : parametros enviados y que seran reemplados en el mensaje
	 * @return String que corresponde al mensaje correspondiente al codigo dado
	 */
	public static String buildMessage(int logCode, String... logParameters) {
		switch (logCode) {
		case ENTER_METHOD_MESSAGE:
			return getMessage(ZeroLogMessage.ENTER_METHOD_MESSAGE, logParameters);
		case EXIT_METHOD_MESSAGE:
			return getMessage(ZeroLogMessage.EXIT_METHOD_MESSAGE, logParameters);
		case ENTER_WEB_METHOD_MESSAGE:
			return getMessage(ZeroLogMessage.ENTER_WEB_METHOD_MESSAGE, logParameters);
		case EXIT_WEB_METHOD_MESSAGE:
			return getMessage(ZeroLogMessage.EXIT_WEB_METHOD_MESSAGE, logParameters);
		default:
			return StringUtils.EMPTY;
		}		
	}
	
	/**
	 * Este Metodo es el encargado de poner los datos respectivos en los mensajes, reemplazando los comodines
	 * @param message : mensaje de log que tiene comodines
	 * @param logParameters : parametros enviados y que seran reemplados en el mensaje
	 * @return String que corresponde al codigo dado
	 */
	private static String getMessage(String message, String... logParameters){
		if(ArrayUtils.getLength(logParameters) == 0){
			StringUtils.replace(message, GenericConstants.MSG_WILDCARD, GenericConstants.EMPTY_STRING);
		}else{
			for(String param : logParameters){
				//Si ya se han realizado todos los reemplazos se termina el ciclo
				if(!message.contains(GenericConstants.MSG_WILDCARD)){
					break;
				}
				
				message = StringUtils.replaceOnce(message, GenericConstants.MSG_WILDCARD, param);
			}
			
			//Si aún quedan parámetros para reemplazar, se reemplazan por vacio
			if(!message.contains(GenericConstants.MSG_WILDCARD)){
				message = StringUtils.replace(message, GenericConstants.MSG_WILDCARD, GenericConstants.EMPTY_STRING);
			}
		}
		
		return message;
	}
}