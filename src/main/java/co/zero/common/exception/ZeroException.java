//=======================================================================
// ARCHIVO ZeroException.java
// FECHA CREACIÓN: Sep 25, 2009
//=======================================================================
package co.zero.common.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import co.zero.common.constant.GenericConstants;

/**
 * Clase que abstrae el comportamiento de cualquier excepción de
 * los módulos. Las excepciones concretas deberán especificar 
 * sus propios códigos de error.
 * @author Hernán Tenjo
 * @version 1.0
 */
public abstract class ZeroException extends Exception{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Codigo del error que se generó
	protected int errorCode;
	protected String messages;
	//Lista con los parametros del errors
	private List<String> errorParameters = new ArrayList<String>();
	protected static final int DEFAULT_CODE_RANGE = 0;
	//Codigo de error generico
	public static final int UNKNOWN_EXCEPTION = DEFAULT_CODE_RANGE;
	
	/**
	 * Constructor por defecto de la excepcion
	 */
	protected ZeroException(){		
	}
	
	/**
	 * Metodo constructor de la excepción
	 * @param errorCode Codigo que identifica a la excepción
	 */
	protected ZeroException(int errorCode){
		this.errorCode = errorCode;
	}
	
	protected ZeroException(String messages) {
		this.messages = messages;
	}
		
	/**
	 * Metodo constructor de la excepcion cuando no se desea 
	 * especificar un codigo de error específico
	 * @param e Excepción original
	 */
	protected ZeroException(Throwable e){
		super(e);
	}
	
	/**
	 * Metodo constructor de la excepcion cuando no se desea 
	 * especificar un codigo de error específico
	 * @param e Excepción original
	 * @param parameters Parametros a reemplazar en el mensaje original
	 */
	protected ZeroException(Throwable e, String... parameters){		
		super(e);
		this.errorParameters.addAll(Arrays.asList(parameters));
	}
	
	/**
	 * Metodo constructor de la excepción
	 * @param errorCode Codigo que identifica a la excepción
	 * @param e Traza de la excepción original
	 */
	protected ZeroException(int errorCode, Throwable e){
		super(e);
		this.errorCode = errorCode;
	}
	
	/**
	 * Constructor auxiliar cuando solo se requiere de un parámetro 
	 * @param errorCode Codigo que identifica a la excepción
	 * @param parameters Parametro a reemplazar en el mensaje original
	 */
	protected ZeroException(int errorCode, String... parameters){
		this(errorCode);
		this.errorParameters.addAll(Arrays.asList(parameters));
	}
	
	/**
	 * Constructor auxiliar cuando solo se requiere de un parámetro 
	 * @param errorCode Codigo que identifica a la excepción
	 * @param e Traza de la excepción original
	 * @param parameters Parametro a reemplazar en el mensaje original
	 */
	protected ZeroException(int errorCode, Throwable e, String... parameters){
		this(errorCode, e);
		this.errorParameters.addAll(Arrays.asList(parameters));
	}
	
	/**
	 * Metodo que permite reemplzar los comodines de los mensajes por
	 * los textos dados como parámetros
	 * @param message Mensaje que se desea transformar
	 * @return El mensaje con las transformaciones requeridas
	 */
	protected String getMessage(String message){
		if(errorParameters.isEmpty()){
			message = StringUtils.replace(message, GenericConstants.MSG_WILDCARD, GenericConstants.EMPTY_STRING);
		}else{
			for(String param : errorParameters){
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
	
	/**
	 * Método que permite obtener el código de error de la excepcion
	 * @return the errorCode
	 */
	public String getMessages(){
		return messages;
	}
	
	public int getErrorCode() {
		return errorCode;
	}
	
	/**
	 * Metodo que permite transformar el mensaje con comodines
	 * original de la excepción con los parametros dados
	 * @return Cadena con el mensaje de la excepcion mas informativa
	 */
	protected abstract String buildMessage();

    /**
     * Método que permite asignar parámetros a la excepción, luego que esta ha sido creada
     * @param errorParameters Parámetros del mensaje que será mostrado por la excepción
     */
    public void setErrorParameters(List<String> errorParameters) {
        this.errorParameters = errorParameters;
    }
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		StringBuilder message = new StringBuilder();
		message.append("\n::: Se ha presentado una situación inesperada");
		message.append("\n::: Código de error ["+ this.errorCode+"] \n");
		
		if(!StringUtils.isBlank(super.getMessage())){
			message.append(super.getMessage());
		}
		
		return message.toString();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		return buildMessage();
	}	
}