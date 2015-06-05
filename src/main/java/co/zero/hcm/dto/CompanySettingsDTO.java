//=======================================================================
// ARCHIVO CompanySettings.java
// FECHA CREACIÓN: Ene 18, 2012
//=======================================================================
package co.zero.hcm.dto;

import java.util.Date;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.CompanySettingLevelType;
import co.zero.common.enumeration.CompanySettingOperatorType;
import co.zero.common.enumeration.CompanySettingPolicyType;
import co.zero.common.enumeration.CompanySettingType;

/**
 * Clase que representa los parámetros de configuración de una compañía
 * @author Hernán Tenjo
 * @version 1.0
 */
public class CompanySettingsDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//El nombre del parámetro que debe ser único por compañía
	private String name;
	//Breve descripción del propósito o función del parámetro
	private String description;
	//Compañía a la que pertenece el parámetro de configuración
	private CompanyDTO company;
	//Tipo de dato que guardará el parámetro
	private CompanySettingType type;
	//Nivel al que pertenece el parámetro que se crea para la compañía
	private CompanySettingLevelType level;
	//Operador que se debe usar en caso de que el tipo lo requiera
	private CompanySettingOperatorType operator;
	//Permite agrupar los parámetros para un propósito común
	private CompanySettingPolicyType policy;
	//Permite determinar si los atributos del parámetro son editables 
	private boolean editable;

	//Valor del parámetro cuando es de tipo cadena
	private String stringValue;
	//Valor del parámetro cuando es de tipo Texto
	private String textValue;
	//Valor del parámetro cuando es de tipo Numérico Entero
	private long longValue;
	//Valor del parámetro cuando es de tipo Numérico Decimal
	private double doubleValue;
	//Valor del parámetro cuando es de tipo Fecha
	private Date dateValue;
	//Valor del parámetro cuando es de tipo Boolean
	private boolean booleanValue;
	
	/**
	 * Método que permite obtener el nombre del parámetro
	 * @return El nombre del parámetro asignado para la compañía
	 */
	public String getName() {
		return name;
	}

	/**
	 * Método que permite modificar el nombre del parámetro
	 * @param name El nuevo nombre que será asignado al parámetro
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Método que permite obtener la descripción del parámetro
	 * @return La descripción del parámetro registrada
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Método que permite modificar la descripción del parámetro
	 * @param description El texto con la nueva descripción del parámetro
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Método que permite obtener el nivel del parámetro (Funcionalidad a la que apoya p.e. Seguridad)
	 * @return Enumeración que representa el nivel del parametro
	 */
	public CompanySettingLevelType getLevel() {
		return level;
	}

	/**
	 * Método que permite modificar el nivel del parámetro
	 * @param level La nueva enumeración que representará al nivel del parámetro
	 */
	public void setLevel(CompanySettingLevelType level) {
		this.level = level;
	}

	/**
	 * Método que permite obtener el tipo de dato que guardará el parámetro
	 * @return El tipo de dato del parámetro
	 */
	public CompanySettingType getType() {
		return type;
	}

	/**
	 * Método que permite modificar el tipo de dato que guardará el parámetro
	 * @param type El nuevo tipo de dato que guardará el parámetro
	 */
	public void setType(CompanySettingType type) {
		this.type = type;
	}
	
	/**
	 * Método que permite obtener el operador del parámetro si lo requiere
	 * @return El operador asignado al parámetro
	 */
	public CompanySettingOperatorType getOperator() {
		return operator;
	}

	/**
	 * Método que permite modificar el operador del parámetro 
	 * @param operator El nuevo operador del parámetro
	 */
	public void setOperator(CompanySettingOperatorType operator) {
		this.operator = operator;
	}

	/**
	 * Método que permite obtener la política a la que apoya el parámetro
	 * @return La política a la que apoya el parámetro
	 */
	public CompanySettingPolicyType getPolicy() {
		return policy;
	}

	/**
	 * Método que permite modificar la política a la que apoya el parámetro
	 * @param policy La nueva política a la que apoyará el parámetro 
	 */
	public void setPolicy(CompanySettingPolicyType policy) {
		this.policy = policy;
	}

	/**
	 * Método que permite determinar si los atributos del parámetro son editables
	 * @return True si los atributos del parámetro son editables, false de lo contrario
	 */
	public boolean isEditable() {
		return editable;
	}

	/**
	 * Método que permite modificar el estado editable de los atributos del parámetro
	 * @param editable True si se desea que los atributos sean editables, false de lo contrario
	 */
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
	/**
	 * Método que permite obtener la compñía dueña del parámetro de configuración
	 * @return La compañía configurada como dueña del parámetro
	 */
	public CompanyDTO getCompany() {
		return company;
	}

	/**
	 * Método que permite modificar la compañía dueña del parámetro de configuración
	 * @param company La nueva compañía a la que se asociará el parámetro
	 */
	public void setCompany(CompanyDTO company) {
		this.company = company;
	}
	
	/**
	 * Método que permite obtener el valor cuando el parámetro es de tipo cadena
	 * @return El valor del parámetro de tipo cadena
	 */
	public String getStringValue() {
		return stringValue;
	}

	/**
	 * Método que permite modificar el valor cuando el parámetro es de tipo cadena
	 * @param stringValue El nuevo valor del parámetro
	 */
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	/**
	 * Método que permite obtener el valor cuando el parámetro es de tipo texto
	 * @return El valor del parámetro de tipo texto
	 */
	public String getTextValue() {
		return textValue;
	}

	/**
	 * Método que permite modificar el valor cuando el parámetro es de tipo texto
	 * @param textValue El nuevo valor del parámetro
	 */
	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}

	/**
	 * Método que permite obtener el valor cuando el parámetro es de tipo Fecha
	 * @return El valor del parámetro de tipo fecha
	 */
	public Date getDateValue() {
		return dateValue;
	}

	/**
	 * Método que permite modificar el valor cuando el parámetro es de tipo Fecha
	 * @param dateValue El nuevo valor del parámetro
	 */
	public void setDateValue(Date dateValue) {
		this.dateValue = dateValue;
	}
	
	/**
	 * Método que permite obtener el valor cuando el parámetro es de tipo Numérico Entero
	 * @return El valor del parámetro de tipo Numérico Entero 
	 */
	public long getLongValue() {
		return longValue;
	}

	/**
	 * Método que permite modificar el valor cuando el parámetro es de tipo Numérico Entero 
	 * @param longValue El nuevo valor del parámetro
	 */
	public void setLongValue(long longValue) {
		this.longValue = longValue;
	}

	/**
	 * Método que permite obtener el valor cuando el parámetro es de tipo Numérico Decimal
	 * @return El valor del parámetro de tipo Numérico Decimal
	 */
	public double getDoubleValue() {
		return doubleValue;
	}

	/**
	 * Método que permite modificar el valor cuando el parámetro es de tipo Numérico Decimal
	 * @param doubleValue El nuevo valor del parámetro
	 */
	public void setDoubleValue(double doubleValue) {
		this.doubleValue = doubleValue;
	}
	
	/**
	 * Método que permite obtener el valor cuando el parámetro es de tipo Boolean
	 * @returnEl valor del parámetro de tipo Boolean
	 */
	public boolean isBooleanValue() {
		return booleanValue;
	}

	/**
	 * Método que permite modificar el valor cuando el parámetro es de tipo Booleano
	 * @param booleanValue El nuevo valor del parámetro
	 */
	public void setBooleanValue(boolean booleanValue) {
		this.booleanValue = booleanValue;
	}

	/**
	 * Método que permite obtener el valor del parámetro sin especificar su tipo
	 * @return El valor del parámetro según el tipo de dato configurado
	 */
	public Object getValue(){
		switch (type) {
		case BOOLEAN:
			return isBooleanValue();
		case DATE:
			return getDateValue();
		case DOUBLE:
			return getDoubleValue();
		case LONG:
			return getLongValue();
		case STRING:
			return getStringValue();
		case TEXT:
			return getTextValue();
		default:
			return null;
		}
	}
	
	/**
	 * Método que permite asignar un valor al parámetro de configuración
	 * @param value El valor que se ha de asignar al parámetro
	 */
	public void setValue(Object value){
		switch (type) {
		case BOOLEAN:
			setBooleanValue((Boolean)value);
		case DATE:
			setDateValue((Date)value);
		case DOUBLE:
			setDoubleValue((Double)value);
		case LONG:
			setLongValue((Long)value);
		case STRING:
			setStringValue((String)value);
		case TEXT:
			setStringValue((String)value);
		default:
		}
	}
}