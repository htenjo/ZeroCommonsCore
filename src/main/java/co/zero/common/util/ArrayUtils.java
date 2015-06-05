//=======================================================================
// ARCHIVO ArrayUtils.java
// FECHA CREACIÓN: 17/05/2013
//=======================================================================
package co.zero.common.util;

import org.apache.commons.lang.StringUtils;

/**
 * Clase que contiene funcionalidades utiles en el manejo de arreglos
 * @author Hernán Tenjo
 * @version 1.0
 */
public class ArrayUtils {
	/**
	 * Método que divide una cadena dado un patron de separación
	 * @param text Cadena que se desea dividir
	 * @param pattern Conjunto de caracteres por los que será dividido el texto
	 * @param withTrim Determinar si se desea que los espacios al princio y final de los elementos resultantes sean eliminados
	 * @return Arreglo con las partes resultantes de la división
	 */
	public static String[] splitString(String text, String pattern, boolean withTrim){
		String[] textParts = StringUtils.split(text, pattern);
		
		if(withTrim){
			trimStringArray(textParts);
		}
		
		return textParts;
	}
	
	/**
	 * Método que elimina los espacios al inicio y al final de los elementos de un arreglo de cadenas
	 * @param textParts Arreglo que se desea procesar
	 */
	public static void trimStringArray(String[] textParts){
		int arrayLength = textParts.length;
		
		for(int i=0; i < arrayLength; i++){
			textParts[i] = textParts[i].trim();
		}
	}
}

