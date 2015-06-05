//=======================================================================
// ARCHIVO EntityAttributeFactory.java
// FECHA CREACIÓN: 2012/09/10
//=======================================================================
package co.zero.common.factory;

import java.io.Serializable;
import java.util.Map;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.IEntityAttribute;

/**
 * Clase que define el comportamiento general que deben presentar las fabricas de EntityAttribute
 * para cada uno de los módulos
 * @author Hernán Tenjo
 * @version 1.0
 */
public abstract class EntityAttributeFactory implements Serializable{
	//Identificador para la serialización
	private static final long serialVersionUID = 1L;
	//Indices para la fabrica de las entidades de Hcm
	public static final int HCM_ENTITY_INDEX = 0;
	public static final int HCM_DIVISION_ENTITY = HCM_ENTITY_INDEX + 1;
	public static final int HCM_JOB_ENTITY = HCM_ENTITY_INDEX + 2;
	public static final int HCM_EMPLOYEE_ENTITY = HCM_ENTITY_INDEX + 3;
	public static final int HCM_EMPLOYEE_EXPERIENCE_ENTITY = HCM_ENTITY_INDEX + 4;
	public static final int HCM_EMPLOYEE_STUDY_ENTITY = HCM_ENTITY_INDEX + 5;
	public static final int HCM_EMPLOYEE_RELATIVE_ENTITY = HCM_ENTITY_INDEX + 6;
	public static final int HCM_EMPLOYEE_VEHICLE_ENTITY = HCM_ENTITY_INDEX + 7;
	public static final int HCM_EMPLOYEE_LANGUAGE_ENTITY = HCM_ENTITY_INDEX + 8;
	
	//Indices para la fabrica de las entidades de Evaluaciones
	public static final int EVALUATION_ENTITY_INDEX = HCM_ENTITY_INDEX  + 1000;
	public static final int EVALUATION_QUALIFICATION_ENTITY = EVALUATION_ENTITY_INDEX + 1;
	public static final int EVALUATION_QUESTION_ENTITY = EVALUATION_ENTITY_INDEX + 2;
	
	/**
	 * Método que obtiene un arreglo con los atributos fijos especificados por la entidad
	 * @param entityIndex Indice de la entidad de la que se desean los atributos
	 * @return Arreglo con los {@link IEntityAttribute} de la entidad dada
	 */
	public abstract IEntityAttribute[] buildAttributes(int entityIndex);
	
	/**
	 * Método que obtiene la clase de la entidad correspondiente al indice de la fabrica
	 * @param entityIndex Indice de la entidad de la que se desea la clase
	 * @return Clase correspondiente al indice de la entidad dada por la fábrica
	 */
	public abstract Class<? extends EntityDTO> getEntityClass(int entityIndex);
	
	/**
	 * Método que construye un mapa que relaciona el nombre de las entidades de la fabrica con su correspondiente indice
	 * @return Mapa con la estructura <EntityClassName, EntityIndex>
	 */
	public abstract Map<String, Integer> buildEntityNamesWithIndexes();
	
	/**
	 * Método que obtiene un atribute de la entidad, representado como una cadena
	 * @param entityIndex Indice de la entidad de la que se desea el atributo
	 * @param attributeName Representación como cadena del {@link IEntityAttribute} que se desea obtener
	 * @return {@link IEntityAttribute} de la entidad que corresponde con la cadena dada
	 */
	public abstract IEntityAttribute getEntityAttribute(int entityIndex, String attributeName);
	
	/**
	 * Método que obtiene el nombre básico de la clase de la entidad correspondiente al indice de la fabrica
	 * @param entityIndex Indice de la entidad de la que se desea la clase
	 * @return Nombre de la clase, correspondiente al indice de la entidad dada por la fábrica
	 */
	public String getEntitySimpleClassName(int entityIndex) {
		Class<?> entityClass = getEntityClass(entityIndex);
		return entityClass == null ? null : entityClass.getSimpleName();
	}
}