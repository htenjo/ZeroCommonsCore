//=======================================================================
// ARCHIVO HcmException.java
// FECHA CREACIÓN: 25/02/2010
//=======================================================================
package co.zero.goals.services.exceptions;

import co.zero.common.exception.ZeroApplicationException;
import co.zero.hcm.exception.HcmException;

import javax.ejb.ApplicationException;

/**
 * Clase que modela una excepcion generica para el módulo Goal
 * @author Hernán Tenjo
 * @version 1.0
 */
@ApplicationException(rollback = true)
public class GoalException extends ZeroApplicationException{
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_CODE_RANGE = HcmException.DEFAULT_CODE_RANGE + 1000;

	/**
	 * Metodo constructor de la excepción
	 * @param errorCode Codigo que identifica a la excepción
	 */
	public GoalException(int errorCode){
		super(errorCode);
	}
		
	/**
	 * Metodo constructor de la excepcion cuando no se desea 
	 * especificar un codigo de error específico
	 * @param e Excepción original
	 */
	public GoalException(Throwable e){
		super(e);
	}
	
	/**
	 * Metodo constructor de la excepción
	 * @param errorCode Codigo que identifica a la excepción
	 * @param e Traza de la excepción original
	 */
	public GoalException(int errorCode, Throwable e){
		super(errorCode, e);
	}
	
	/**
	 * Constructor auxiliar cuando solo se requiere de un parámetro 
	 * @param errorCode Codigo que identifica a la excepción
	 * @param parameter Parametro a reemplazar en el mensaje original
	 */
	public GoalException(int errorCode, String... parameter){
		super(errorCode, parameter);
	}
	
	/**
	 * Constructor auxiliar cuando solo se requiere de un parámetro 
	 * @param errorCode Codigo que identifica a la excepción
	 * @param e Traza de la excepción original
	 * @param parameter Parametro a reemplazar en el mensaje original
	 */
	public GoalException(int errorCode, Throwable e, String... parameter){
		super(errorCode, e, parameter);
	}
}

