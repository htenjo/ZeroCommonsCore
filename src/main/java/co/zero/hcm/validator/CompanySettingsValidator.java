//=======================================================================
// ARCHIVO CompanySettingsValidator.java
// FECHA CREACIÓN: 26/01/2012
//=======================================================================
package co.zero.hcm.validator;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import co.zero.common.enumeration.CompanySettingOperatorType;
import co.zero.hcm.dto.CompanySettingsDTO;

/**
 * Descripción de la clase
 * @author Hernán Tenjo
 * @version 1.0
 */
public class CompanySettingsValidator {
	private List<CompanySettingsDTO> settings;
	
	public CompanySettingsValidator(List<CompanySettingsDTO> settings){
		this.settings = settings;
	}
	
	public boolean validate(List<CompanySettingOperatorType> errors, Object newValue){
		for(CompanySettingsDTO setting : settings){
			switch(setting.getOperator()){
			case NUMERIC_DIFERENT_THAN:
				return validateNumericDiferentOf(errors, (Number)newValue, (Number)setting.getValue());
			case NUMERIC_EQUAL_THAN:
				return validateNumericEqualsThan(errors, (Number)newValue, (Number)setting.getValue());
			case NUMERIC_GREATER_EQUAL_THAN:
				return validateNumericGreaterEqualsThan(errors, (Number)newValue, (Number)setting.getValue());
			case NUMERIC_GREATER_THAN:
				return validateNumericGreaterThan(errors, (Number)newValue, (Number)setting.getValue());
			case NUMERIC_LESS_EQUAL_THAN:
				return validateNumericLessEqualsThan(errors, (Number)newValue, (Number)setting.getValue());
			case NUMERIC_LESS_THAN:
				return validateNumericLessThan(errors, (Number)newValue, (Number)setting.getValue());
			case STRING_CONTAINS:
				return validateStringContains(errors, (String)newValue, (String)setting.getValue());
			case STRING_MIN_LENGTH:
				return validateStringMinLength(errors, (String)newValue, (Number)setting.getValue());
			case STRING_MAX_LENGTH:
				return validateStringMaxLength(errors, (String)newValue, (Number)setting.getValue());
			default:
				return false;
			}
		}
		
		return errors.size() == 0;
	}
	
	/**
	 * Método que permite validar que un valor sea diferente de otro
	 * @param newValue Valor que se desea validar
	 * @param parameterValue Valor contra el que se desea comparar
	 * @return True si newValue != differentValue, false de lo contrario
	 */
	private boolean validateNumericDiferentOf(List<CompanySettingOperatorType> errors, Number newValue, Number parameterValue){
		if(newValue.doubleValue() == parameterValue.doubleValue()){
			errors.add(CompanySettingOperatorType.NUMERIC_DIFERENT_THAN);
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * Método que permite validar que un valor sea igual que otro
	 * @param newValue Valor que se desea validar
	 * @param parameterValue Valor contra el que se desea comparar
	 * @return True si newValue == differentValue, false de lo contrario
	 */
	private boolean validateNumericEqualsThan(List<CompanySettingOperatorType> errors, Number newValue, Number parameterValue){
		if(newValue.doubleValue() == parameterValue.doubleValue()){
			return true;
		}else{
			errors.add(CompanySettingOperatorType.NUMERIC_EQUAL_THAN);
			return false;			
		}
	}
	
	/**
	 * Método que permite validar que un valor sea mayor o igual que otro
	 * @param newValue Valor que se desea validar
	 * @param parameterValue Valor contra el que se desea comparar
	 * @return True si newValue >= differentValue, false de lo contrario
	 */
	private boolean validateNumericGreaterEqualsThan(List<CompanySettingOperatorType> errors, Number newValue, Number parameterValue){
		if(newValue.doubleValue() >= parameterValue.doubleValue()){
			return true;
		}else{
			errors.add(CompanySettingOperatorType.NUMERIC_GREATER_EQUAL_THAN);
			return false;			
		}
	}
	
	/**
	 * Método que permite validar que un valor sea mayor que otro
	 * @param newValue Valor que se desea validar
	 * @param parameterValue Valor contra el que se desea comparar
	 * @return True si newValue > differentValue, false de lo contrario
	 */
	private boolean validateNumericGreaterThan(List<CompanySettingOperatorType> errors, Number newValue, Number parameterValue){
		if(newValue.doubleValue() > parameterValue.doubleValue()){
			return true;
		}else{
			errors.add(CompanySettingOperatorType.NUMERIC_GREATER_THAN);
			return false;			
		}
	}
	
	/**
	 * Método que permite validar que un valor sea menor o igual que otro
	 * @param newValue Valor que se desea validar
	 * @param parameterValue Valor contra el que se desea comparar
	 * @return True si newValue <= differentValue, false de lo contrario
	 */
	private boolean validateNumericLessEqualsThan(List<CompanySettingOperatorType> errors, Number newValue, Number parameterValue){
		if(newValue.doubleValue() <= parameterValue.doubleValue()){
			return true;
		}else{
			errors.add(CompanySettingOperatorType.NUMERIC_LESS_EQUAL_THAN);
			return false;			
		}
	}
	
	/**
	 * Método que permite validar que un valor sea menor que otro
	 * @param newValue Valor que se desea validar
	 * @param parameterValue Valor contra el que se desea comparar
	 * @return True si newValue < differentValue, false de lo contrario
	 */
	private boolean validateNumericLessThan(List<CompanySettingOperatorType> errors, Number newValue, Number parameterValue){
		if(newValue.doubleValue() < parameterValue.doubleValue()){
			return true;
		}else{
			errors.add(CompanySettingOperatorType.NUMERIC_LESS_THAN);
			return false;			
		}
	}
	
	/**
	 * Método que permite validar una cadena contenga a otra
	 * @param newString Cadena que se desea validar
	 * @param parameterString Subcadena que debe estar en newString
	 * @return True parameterString es una subcadena de newString, false de lo contrario
	 */
	private boolean validateStringContains(List<CompanySettingOperatorType> errors, String newString, String parameterString){
		if(StringUtils.contains(newString, parameterString)){
			return true;
		}else{
			errors.add(CompanySettingOperatorType.STRING_CONTAINS);
			return false;			
		}
	}
	
	/**
	 * Método que permite determinar si una cadena contiene un mínimo de caracteres
	 * @param errors Lista donde se agregará el tipo que generó el error si lo hay
	 * @param string Cadena que se desea validar
	 * @param minLength Cantidad de caracteres mínima que debe contener la cadena
	 * @return True si la cadena tiene la cantidad de caracteres requeridos
	 */
	private boolean validateStringMinLength(List<CompanySettingOperatorType> errors, String string, Number minLength){
		if(string != null && string.length() >= minLength.doubleValue()){
			return true;
		}else{
			errors.add(CompanySettingOperatorType.STRING_MIN_LENGTH);
			return false;
		}
	}
	
	/**
	 * Método que permite determinar la cantidad máxima de caracteres de una cadena
	 * @param errors Lista donde se agregará el tipo que generó el error si lo hay
	 * @param string Cadena que se desea validar
	 * @param maxLength Cantidad de caracteres máxima que debe contener la cadena
	 * @return True si la cadena tiene la cantidad de caracteres requeridos
	 */
	private boolean validateStringMaxLength(List<CompanySettingOperatorType> errors, String string, Number maxLength){
		if(string != null && string.length() <= maxLength.doubleValue()){
			return true;
		}else{
			errors.add(CompanySettingOperatorType.STRING_MIN_LENGTH);
			return false;
		}
	}
}

