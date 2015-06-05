//=======================================================================
// ARCHIVO ReflectionUtils.java
// FECHA CREACIÓN: 23/02/2010
//=======================================================================
package co.zero.common.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.ArrayUtils;

import co.zero.common.dto.EntityDTO;
import co.zero.common.exception.ZeroApplicationException;

/**
 * Clase que reune funcionalidades relacionadas con el api reflection
 * @author Hernán Tenjo
 * @version 1.0
 */
public class ReflectionUtils {
	/**
	 * Metodo que permite instanciar cualquier clase dados los 
	 * parametros de su constructor
	 * @param <T> Tipo del objeto que se desea crear
	 * @param clazz Clase del objeto que se desea crear
	 * @param params Parametros del constructor de la entidad 
	 * que se desea crear 
	 * @return Una instancia de tipo T
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static <T> T getInstance(Class<T> clazz, Object... params) throws 
		SecurityException, NoSuchMethodException, IllegalArgumentException, 
		InstantiationException, IllegalAccessException, InvocationTargetException{
		Class<?>[] paramClassess = null;
		
		if(!ArrayUtils.isEmpty(params)){
			paramClassess = new Class<?>[params.length];	
			
			for(int i=0; i < paramClassess.length; i++){
				paramClassess[i] = params[i].getClass();
			}
		}
				
		Constructor<T> constructor = clazz.getConstructor(paramClassess);		
		return constructor.newInstance(params);
	}
	
	/**
	 * Metodo que permite dar un valor a un atributo de un objeto conociendo su nombre
	 * @param entityDTO Objeto que contiene el atributo a modificar
	 * @param fieldName Nombre del atributo que se desea modificar
	 * @param value Valor que será asignado al atributo
	 * @throws ZeroApplicationException Si se presentan problemas al asignar el 
	 * valor al atributo con introspeccion
	 */
	public static void setProperty(EntityDTO entityDTO, String fieldName, 
			Object value) throws ZeroApplicationException{
		try {
			BeanUtils.setProperty(entityDTO, fieldName, value);
		} catch (IllegalAccessException e) {
			throw new ZeroApplicationException(
					ZeroApplicationException.INVALID_INTROSPECTION_PROCESS, 
					e, entityDTO.getClass().getName());
		} catch (InvocationTargetException e) {
			throw new ZeroApplicationException(
					ZeroApplicationException.INVALID_INTROSPECTION_PROCESS, 
					e, entityDTO.getClass().getName());
		}
	}
}