//=======================================================================
// ARCHIVO OpenResponseText.java
// FECHA CREACIÓN: 10/05/2011
//=======================================================================
package co.zero.evaluation.dto;


/**
 * Clase q modela una respuesta abierta donde el valor de la 
 * respuesta es un arreglo de bytes
 * @author Hernán Tenjo
 * @version 1.0
 */
public class OpenResponseGraphicDTO extends OpenResponseDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Valor de la respuesta cuando no es de tipo texto
	private byte[] responseBytes;

	/**
	 * Método que permite obtener el valor de la respuesta
	 * @return El arreglo de bytes de la respuesta
	 */
	public byte[] getResponseBytes() {
		return responseBytes;
	}

	/**
	 * Método que permite modificar el valor de la respuesta
	 * @param responseBytes El nuevo arreglo de bytes de la respuesta
	 */
	public void setResponseBytes(byte[] responseBytes) {
		this.responseBytes = responseBytes;
	}
}