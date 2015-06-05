//=======================================================================
// ARCHIVO HcmUtils.java
// FECHA CREACIÓN: 25/11/2009
//=======================================================================
package co.zero.hcm.util;

import java.io.IOException;
import java.io.InputStream;

/**
 * Clase que contiene funciones utilitarias genericas a todos los módulos
 * @author Hernán Tenjo
 * @version 1.0
 */
public class HcmGenericUtils {
	/**
	 * Metodo que permite convertir un input stream a su representación 
	 * como arreglo de bytes
	 * @param inputStream Stream del que se leeran los bytes
	 * @return Arreglo con los bytes del input
	 * @throws IOException Si se producen problemas al obtener la información del inputstrem
	 */
	public static byte[] getBytesFromInputStream(InputStream inputStream) throws IOException {
		byte[] bytes = new byte[inputStream.available()];
		inputStream.read(bytes);
		return bytes;
	}
}
