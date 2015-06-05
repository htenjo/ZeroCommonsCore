package co.zero.hcm.dto;

import java.io.Serializable;

import co.zero.common.enumeration.PersistentType;


/**
 * Contiene los atributos necesarios para armar los filtros de cada uno de los extrafields
 * 
 * @author Youlyn
 *
 */
public class EntityFilterNodeDTO implements Serializable{

	/*
	 * Operadores
	 */
	public static final String LIKE_OPERATOR = "LIKE";
	public static final String LESS_THAN = "LESS_THAN";
	public static final String LESS_EQUAL = "LESS_EQUAL";
	public static final String EQUALS = "EQUALS";
	public static final String GREATER_EQUAL = "GREATER_EQUAL";
	public static final String GREATER_THAN = "GREATER_THAN";
	public static final String LESS_THAN_OPERATOR = "<";
	public static final String LESS_EQUAL_OPERATOR = "<=";
	public static final String EQUALS_OPERATOR = "=";
	public static final String GREATER_EQUAL_OPERATOR = ">=";
	public static final String GREATER_THAN_OPERATOR = ">";
	
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Extrafield al que pertenece el filtro
	private ExtrafieldMetadataDTO extrafieldMetadata;
	//Nombre del atributo de la entidad
	private String name;
	//Llave del nombre del campo basico internacionalizado
	private String i18nName;
	//Operador que sera utilizado en el where
	private String operator;
	//Valor contra el que se comparara en el filtro
	private Object value;
	//Tipo de dato del nodo
	private PersistentType type;
	
	/**
	 * Metodo que permite obtener el extrafield al que pertence el filtro. Este puede ser null si se trata de un campo basico
	 * @return
	 */
	public ExtrafieldMetadataDTO getExtrafieldMetadata() {
		return extrafieldMetadata;
	}
	
	/**
	 * Metodo que permite modificar el extrafield del filtro
	 * @param extrafieldMetadata
	 */
	public void setExtrafieldMetadata(ExtrafieldMetadataDTO extrafieldMetadata) {
		this.extrafieldMetadata = extrafieldMetadata;
	}
	
	/**
	 * Metodo que permite obtener el nombre del campo de la entidad
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Metodo que permite modificar el nombre del campo de la entidad
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Metodo que permite obtener la llave de internacionalizacion que lleva el nombre del campo
	 * @return
	 */
	public String getI18nName() {
		return i18nName;
	}
	
	/**
	 * Metodo que permite modificar la llave de internacionalizacion que lleva el nombre del campo
	 * @param i18nName
	 */
	public void setI18nName(String i18nName) {
		this.i18nName = i18nName;
	}
	
	/**
	 * Metodo que permite obtener el operador de la comparacion
	 * @return
	 */
	public String getOperator() {
		return operator;
	}
	
	/**
	 * Metodo que permite modificar el operador de la comparacion
	 * @param operator
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	/**
	 * Metodo que permite obtener el valor con el que se desea comparar
	 * @return
	 */
	public Object getValue() {
		return value;
	}
	
	/**
	 * Metodo que permite modificar el valor con el que se desea comparar
	 * @param value
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * Metodo que permite obtener el tipo de dato del campo
	 * @return
	 */
	public PersistentType getType() {
		if(extrafieldMetadata != null){
			return extrafieldMetadata.getType();
		}
		return type;
	}

	/**
	 * Metodo que permite modificar el tipo de dato del campo
	 * @param type
	 */
	public void setType(PersistentType type) {
		this.type = type;
	}
	
}