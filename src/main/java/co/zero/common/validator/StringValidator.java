//=======================================================================
// ARCHIVO StringValidator.java
// FECHA CREACIÓN: 2/03/2010
//=======================================================================
package co.zero.common.validator;

import org.apache.commons.lang.StringUtils;

/**
 * Clase que permite realizar validaciones sobre cadenas de texto
 * @author Hernán Tenjo
 * @version 1.0
 */
public class StringValidator {
	public static boolean isValidLength(String text, int maxLength){
		if(!StringUtils.isBlank(text) && text.length() > maxLength){
			return false;
		}else{
			return true;
		}
	}
}

