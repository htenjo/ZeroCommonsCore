//=======================================================================
// ARCHIVO ZeroLogMessage.java
// FECHA CREACIÓN: 19/01/2011
//=======================================================================
package co.zero.common.log;

import co.zero.common.constant.GenericConstants;

/**
 * Esta Clase contiene todos los mensajes de log referentes a los servicios del sistema
 * @author Andres Diaz
 * @version 1.0
 */ 
public class ZeroLogMessage {
	public static final String ENTER_METHOD_MESSAGE = 
		"::: CLASS=[" + GenericConstants.MSG_WILDCARD + "]:METHOD_IN=[" + 
		GenericConstants.MSG_WILDCARD + "]:PARAMS=["+GenericConstants.MSG_WILDCARD+"]";
	
	public static final String EXIT_METHOD_MESSAGE = 
		"::: CLASS=[" + GenericConstants.MSG_WILDCARD + "]:METHOD_OUT=[" + 
		GenericConstants.MSG_WILDCARD + "]:PARAMS=["+GenericConstants.MSG_WILDCARD+"]";

	public static final String ENTER_WEB_METHOD_MESSAGE =
		"::: METHOD_IN=[" + GenericConstants.MSG_WILDCARD + "]:PARAMS=[" +
		GenericConstants.MSG_WILDCARD+"]" + "::: USER=[" + GenericConstants.MSG_WILDCARD + 
		"]:HOST=[" + GenericConstants.MSG_WILDCARD + "]:IP=[" + GenericConstants.MSG_WILDCARD + "]" +
		":PORT=[" + GenericConstants.MSG_WILDCARD + "]";
	
	public static final String EXIT_WEB_METHOD_MESSAGE = 
		"::: METHOD_OUT=[" + GenericConstants.MSG_WILDCARD + "]:PARAMS=["+
		GenericConstants.MSG_WILDCARD+"]" + "::: USER=[" + GenericConstants.MSG_WILDCARD + 
		"]:HOST=[" + GenericConstants.MSG_WILDCARD + "]:IP=[" + GenericConstants.MSG_WILDCARD + "]" +
		":PORT=[" + GenericConstants.MSG_WILDCARD + "]";
}