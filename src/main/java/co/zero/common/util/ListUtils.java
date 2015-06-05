//=======================================================================
// ARCHIVO ListUtils.java
// FECHA CREACIÓN: 13/02/2010
//=======================================================================
package co.zero.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import co.zero.common.constant.GenericConstants;
import co.zero.common.dto.EntityDTO;
import co.zero.common.exception.ZeroApplicationException;
import co.zero.common.validator.GenericValidator;

/**
 * Clase que reune funcionalidades relacionadas con operaciones en listas
 * @author Hernán Tenjo
 * @version 1.0
 */
public class ListUtils {
	/**
	 * Metodo auxiliar que permite buscar un {@link EntityDTO} en una lista
	 * @param entityList Lista con los {@link EntityDTO} que se desean procesar
	 * @param entityId Identificador de la {@link EntityDTO} que se desea obtener
	 * @return Null si la lista no contiene la entidad, {@link EntityDTO} de lo contrario
	 */
	public static <T extends EntityDTO> T getEntityDTOFromList(List<T> entityList, long entityId){
		T entityAux = null;
		
		for(T entityDTO : entityList){
			if(entityDTO.getId() == entityId){
				entityAux = entityDTO;
				break;
			}
		}
		
		return entityAux;
	}
	
	/**
	 * Metodo que permite convertir una cadena de números enteros separados 
	 * por comas en una lista de longs.
	 * p.e. "12,3,45,678, 53, 435 , 45" = [12,3,45,678,53,435,45]
	 * @param stringOfLong Cadena que contiene los numeros
	 * @return La lista de numeros encontrados en la cadena
	 * @throws ZeroApplicationException Si la cadena presenta un contenido
	 * diferente a números separados por comas 
	 */
	public static List<Long> splitStringLongAsList(String stringOfLong) throws ZeroApplicationException{
		String[] parts = StringUtils.split(stringOfLong, GenericConstants.COMMA);
		return numericArrayAsList(parts);
	}
	
	/**
	 * Metodo que permite convertir una arreglo de números representados como
	 * cadena en una lista de Longs
	 * @param numericArray Arreglo de cadenas que representan los numeros
	 * @return La lista de numeros del arreglo
	 * @throws ZeroApplicationException Si el arreglo presenta un contenido
	 * diferente a números 
	 */
	public static List<Long> numericArrayAsList(String[] numericArray) throws ZeroApplicationException{
		List<Long> longList = new ArrayList<Long>();
		
		if(numericArray != null){
			for(String part : numericArray){
				part = part.trim();
				
				if(StringUtils.isNumeric(part)){
					longList.add(Long.parseLong(part));
				}else{
					throw new ZeroApplicationException(
							ZeroApplicationException.INVALID_NUMBER_AS_STRING_PARSING);
				}
			}
		}
		
		return longList;
	}
	
	/**
	 * Método que permite transformar una lista de DTOs en un Map que facilita 
	 * las búsquedas.
	 * @param <T> Tipo de los elementos de la lista que se desea adaptar
	 * @param entityList Lista de los elementos que se desea transformar
	 * @return Mapa con los elementos de lista, con key = entity.getId()
	 */
	public static <T extends EntityDTO> Map<Long, T> getEntityDTOListAsMap(List<T> entityList){
		Map<Long, T> entityMap = new HashMap<Long, T>();
		
		if(GenericValidator.isValidCollection(entityList, 1)){
			for(T entity : entityList){
				entityMap.put(entity.getId(), entity);
			}
		}
		
		return entityMap; 
	}
	
	/**
	 * Método que permite obtener los ids de un conjunto de entidades
	 * @param <T> Tipo de las entidades que se desean analizar
	 * @param entityList Lista con las entidades que se desean analizar
	 * @return  Lista con los ids de las entidades 
	 */
	public static <T extends EntityDTO> List<Long> getEntityIdsAsList(Collection<T> entityList){
		List<Long> entityIdList = new ArrayList<Long>();
		
		if(GenericValidator.isValidCollection(entityList, 1)){
			for(T entity : entityList){
				entityIdList.add(entity.getId());
			}
		}
		
		return entityIdList; 
	}
}