//=======================================================================
// ARCHIVO NumericOperator.java
// FECHA CREACIÓN: 25/01/2012
//=======================================================================
package co.zero.common.enumeration;

/**
 * Clase que reune los operadores que se pueden aplicar a un número
 * @author Hernán Tenjo
 * @version 1.0
 */
public enum CompanySettingOperatorType{
	//Operación igual que (==)
	NUMERIC_EQUAL_THAN,
	//Operación diferente de (!=)
	NUMERIC_DIFERENT_THAN,
	//Operación menor que (<)
	NUMERIC_LESS_THAN,
	//Operación menor o igual que (<=)
	NUMERIC_LESS_EQUAL_THAN,
	//Operación mayor o igual que (>=)
	NUMERIC_GREATER_EQUAL_THAN,
	//Operación mayor que (>)
	NUMERIC_GREATER_THAN,
	
	//Mínima cantidad de caracteres
	STRING_MIN_LENGTH,
	//Máxima cantidad de caracteres
	STRING_MAX_LENGTH,
	//Determina si la cadena contiene otra cadena (Un parámetro preconfigurado)
	STRING_CONTAINS;
	
	/**
	 * Método que permite obtener los operadores que funcionan con valores numéricos
	 * @return Arreglo con los operadores que funcionan con valores numéricos
	 */
	private CompanySettingOperatorType[] getNumericOperators(){
		return new CompanySettingOperatorType[]{NUMERIC_EQUAL_THAN, NUMERIC_DIFERENT_THAN,
			NUMERIC_LESS_THAN, NUMERIC_LESS_EQUAL_THAN, NUMERIC_GREATER_EQUAL_THAN, NUMERIC_GREATER_THAN};
	}
	
	/**
	 * Método que permite obtener los operadores que funcionan con cadenas
	 * @return Arreglo con los operadores que funcionan con cadenas
	 */
	private CompanySettingOperatorType[] getStringOperators(){
		return new CompanySettingOperatorType[]{
			STRING_MIN_LENGTH, STRING_MAX_LENGTH, STRING_CONTAINS	
		};
	}
	
	/**
	 * Método que permite obtener los operadores validos para un {@link CompanySettingType}
	 * @param type Tipo del que se desean obtener operadores validos
	 * @return Arreglo con los operadores que aplican para el tipo dado
	 */
	public CompanySettingOperatorType[] getOperatorsForType(CompanySettingType type){
		switch (type) {
		case BOOLEAN:
			return new CompanySettingOperatorType[]{};
		case DATE:
			return new CompanySettingOperatorType[]{};
		case DOUBLE:
		case LONG:
			return getNumericOperators();
		case STRING:
		case TEXT:
			return getStringOperators();
		default:
			return null;
		}
	}
	
}