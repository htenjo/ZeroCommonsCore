//=======================================================================
// ARCHIVO GenericValidator.java
// FECHA CREACIÓN: 24/02/2010
//=======================================================================
package co.zero.common.validator;

import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang.math.NumberUtils;

import co.zero.common.dto.EntityDTO;
import co.zero.common.exception.ZeroApplicationException;
import co.zero.common.exception.ZeroException;


/**
 * Clase que reune funcionalidades de validacion generales
 * comunes a los diferentes modulos de Zero
 * @author Hernán Tenjo
 * @version 1.0
 */
public class GenericValidator{
	/**
	 * Metodo que permite validar si un objeto es nulo, generando 
	 * una excepción de aplicación 
	 * @param object El objeto que se desea validar
	 * @param objectClass Nombre de la clase del objeto
	 * @throws ZeroApplicationException si el objeto es nulo
	 */
	public static void validateObjectNull(Object object, Class<?> objectClass) throws ZeroApplicationException{
		if(object == null){
			throw new ZeroApplicationException(ZeroApplicationException.NULL_GENERIC_OBJECT, objectClass.getName());
		}
	}
		
	/**
	 * Metodo que permite determinar si un objeto es nulo
	 * @param object El objeto que se desea validar
	 * @return True si el objeto es nulo, false de lo contrario
	 */
	public static boolean isNull(Object object){
		if(object == null){
			return true;
		}
		
		return false;
	}
	
	/**
	 * Metodo que permite validar si una cadena de texto es
	 * un numero. La cadena es un numero si contiene unicamente
	 * digitos sin espacios
	 * @param text Cadena que será procesada
	 * @return True si la cadena representa un número, false de lo contrario
	 */
	public static boolean isNumeric(String text){
		return NumberUtils.isNumber(text);
	}
	
	/**
	 * Método que permite verificar que un parámetro es un número
	 * @param parameter Cadena que se desea validar como número
	 * @return La cadena si es un número, excepción de lo contrario
	 * @throws ZeroApplicationException Si la cadena no es un número valido
	 */
	public static String validateNumeric(String parameter) throws ZeroApplicationException{
		if(NumberUtils.isNumber(parameter)){
			return parameter;
		}else{
			throw new ZeroApplicationException(
					ZeroApplicationException.INVALID_NUMBER_AS_STRING_PARSING, parameter);
		}
	}
	
	/**
	 * Metodo que permite validar el tamaño de una coleccion
	 * @param <T> Tipo de los elementos que almacena la coleccion
	 * @param elementsClass Clase de los elementos que que almacena la coleccion
	 * @param collection Estructura que se desea validar
	 * @param numElements Cantidad minima de elementos requeridos
	 * @throws ZeroApplicationException
	 */
	public static <T> void validateCollection(Class<T> elementsClass, 
			Collection<T> collection, int numElements) throws ZeroApplicationException{
		validateObjectNull(collection, elementsClass);
		
		if(collection.size() < numElements){
			throw new ZeroApplicationException(
					ZeroApplicationException.COLLECTION_INVALID, Integer.toString(numElements));
		}
	}
	
	/**
	 * Metodo que permite determinar que una colleccion de elementos sea valida
	 * @param collection Estructura que se desea validar
	 * @param numElements Cantidad mínima de elementos requeridos
	 * @return True si la colleccion es valida, false de lo contrario
	 */
	public static <T> boolean isValidCollection(Collection<T> collection, int numElements){				
		return !isNull(collection) && collection.size() >= numElements;
	}
	
	/**
	 * Metodo que permite validar la existencia de una entidad 
	 * @param <T> Tipo de la entidad que se desea validar
	 * @param entityDTOClass Clase de la entidad que se desea validar
	 * @param entityDTO Objeto que se desea validar 
	 * @param id Identificador de la entidad
	 * @throws ZeroApplicationException Si la entidad no existe
	 */
	public static <T extends EntityDTO> void validateEntityDTOExistence( 
			Class<T> entityDto, Long id) throws ZeroApplicationException{
		if(entityDto == null || id < 1){
			throw new ZeroApplicationException(
					ZeroApplicationException.ENTITY_DTO_NOT_EXIST, 
					entityDto.getName(), Long.toString(id));
		}
	}
	
	/**
	 * Método que valida que una fecha inicial de un proceso sea menor o igual que la fecha de finalización del mismo
	 * @param startDate Fecha inicial del proceso que se desea validar
	 * @param endDate Fecha final del proceso que se desea validar
	 * @throws ZeroException:
	 * {@link ZeroApplicationException}.NULL_GENERIC_OBJECT: Si alguna de las fechas son nulas 
	 * {@link ZeroApplicationException}.INVALID_DATE_RANGE_START_END: Si el rango de las fechas es inválido
	 */
	public static void validateStartDateBeforeEndDate(Date startDate, Date endDate) throws ZeroException{
		validateObjectNull(startDate, Date.class);
		validateObjectNull(endDate, Date.class);
		
		if(startDate.after(endDate)){
			throw new ZeroApplicationException(ZeroApplicationException.INVALID_DATE_RANGE_START_END);
		}
	}
}