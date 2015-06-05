//=======================================================================
// ARCHIVO FormatUtils.java
// FECHA CREACIÓN: 20/02/2010
//=======================================================================
package co.zero.common.util;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import co.zero.common.constant.GenericConstants;

import org.apache.commons.lang.StringUtils;

/**
 * Clase que reune funcionalidades relacionadas con el formateo de
 * fechas y numeros
 * @author Hernán Tenjo
 * @version 1.0
 */
public class FormatUtils {
	/**
	 * Metodo que permite convertir una fecha en su representación
	 * como cadena, dado un patro de conversion
	 * @param date Fecha que se desea formatear
	 * @param pattern Patron con el que se realizará el formateo
	 * @return La representación de la fecha como cadena
	 */
	public static String formatDate(Date date, String pattern){
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.format(date);
	}
	
	/**
	 * Metodo que permite convertir una fecha representada como cadena en un objeto fecha
	 * @param pattern Patron de fecha con el que será parseado el recurso
	 * @param source Cadena que representa a una fecha con el patron dado
	 * @return Objeto fecha
	 * @throws ParseException Si se producen errores al realizar el parseo
	 */
	public static Date formatDate(String source, String pattern) throws ParseException{
		if(source == null){
			return null;
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.parse(source);
	}
	
	/**
	 * Metodo que permite formatear un double como moneda
	 * @param value Valor que se desea formatear
	 * @param minDigits Mínima cantidad de digitos decimales
	 * @param maxDigits Máxima cantidad de digitos decimales
	 * @return Cadena con el formato especificada
	 */
	public static String formatCurrency(double value, int minDigits, int maxDigits){
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		formatter.setMinimumFractionDigits(minDigits);
		formatter.setMaximumFractionDigits(maxDigits);
		return formatter.format(value);
	}
	
	/**
	 * Metodo que permite formatear un double en su representación como moneda
	 * @param value Valor que se desea formatear
	 * @param currency Tipo de moneda a la que se desea formatear
	 * @param minDigits Mínima cantidad de digitos decimales
	 * @param maxDigits Máxima cantidad de digitos decimales
	 * @return Cadena con el formato especificada
	 */
	public static String formatCurrency(double value, String currency, int minDigits, int maxDigits){
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		formatter.setMinimumFractionDigits(minDigits);
		formatter.setMaximumFractionDigits(maxDigits);
		formatter.setCurrency(Currency.getInstance(currency));
		return formatter.format(value);
	}
	
	/**
	 * Metodo que permite formatear un double en su representación como moneda
	 * @param value Valor que se desea formatear
	 * @param currency Tipo de moneda a la que se desea formatear
	 * @param minDigits Mínima cantidad de digitos decimales
	 * @param maxDigits Máxima cantidad de digitos decimales
	 * @return Cadena con el formato especificada
	 */
	public static String formatCurrency(double value, Locale currency, int minDigits, int maxDigits){
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		formatter.setMinimumFractionDigits(minDigits);
		formatter.setMaximumFractionDigits(maxDigits);
		formatter.setCurrency(Currency.getInstance(currency));
		System.out.println(formatter.getCurrency().getSymbol());
		return formatter.format(value);
	}
	
	/**
	 * Metodo que permite formatear un double como porcentaje
	 * @param value Valor que se desea formatear
	 * @param minDigits Mínima cantidad de digitos decimales
	 * @param maxDigits Máxima cantidad de digitos decimales
	 * @return Cadena con el formato especificado
	 */
	public static String formatPercentage(double value, int minDigits, int maxDigits){
		NumberFormat formatter = NumberFormat.getPercentInstance();
		formatter.setMinimumFractionDigits(minDigits);
		formatter.setMaximumFractionDigits(maxDigits);
		return formatter.format(value);
	}
	
	/**
	 * Metodo que permite formatear un double con aproximación de decimales
	 * @param value Valor que se desea formatear
	 * @param minDigits Mínima cantidad de digitos decimales
	 * @param maxDigits Máxima cantidad de digitos decimales
	 * @return Cadena con el formato especificado
	 */
	public static String formatNumber(double value, int minDigits, int maxDigits){
		NumberFormat formatter = NumberFormat.getNumberInstance();
		formatter.setMinimumFractionDigits(minDigits);
		formatter.setMaximumFractionDigits(maxDigits);
		return formatter.format(value);
	}
	
	/**
	 * Método que obtiene un mensaje i18n de los recursos predefinidos
	 * @param key Llave del mensaje i18n que se desea obtener
	 * @param locale Objeto que permite determinar el idioma del que será obtenido el mensaje
	 * @param arguments Parámetros adicionales que puede tener el mensaje par ser más genérico
	 * @return Mensaje i18n correspondiente al key dado
	 */
	public static String getI18nMessage(String key, Locale locale, String... arguments) {
		ResourceBundle messages = ResourceBundle.getBundle(GenericConstants.ZERO_I18N_BASE_NAME, locale);
	    MessageFormat formatter = new MessageFormat(GenericConstants.EMPTY_STRING, locale);
	    formatter.applyPattern(messages.getString(key));
	    return formatter.format(arguments);
	}
    
    /**
     * Método que determina si una llave de i18n se encuentra en los archivos disponibles
     * @param key Llave del mensaje i18n que se desea obtener
     * @param arguments Parámetros adicionales que puede tener el mensaje par ser más genérico
     * @return True si se ha e
     */
    public static boolean isI18nKeyInLocales(String key, String... arguments){
        if(!StringUtils.isBlank(getI18nMessage(key, new Locale(GenericConstants.I18N_ES_LOCALE), arguments))){
            return true;
        }else if(!StringUtils.isBlank(getI18nMessage(key, new Locale(GenericConstants.I18N_EN_LOCALE), arguments))){
            return true;
        }else if(!StringUtils.isBlank(getI18nMessage(key, new Locale(GenericConstants.I18N_PT_LOCALE), arguments))){
            return true;
       }else{
            return false;
       }
    }
    
    /**
     * Método que determina si un mensaje i18n se encuentra en los archivos disponibles
     * @param key Llave del mensaje i18n que se desea obtener
     * @param arguments Parámetros adicionales que puede tener el mensaje par ser más genérico
     * @return True si se ha e
     */
    public static boolean isI18nMessageInLocales(String key, String message, String... arguments){
    	String messageAux;
    	
    	if(!StringUtils.isBlank(message)){
    		if(!StringUtils.isBlank((messageAux = getI18nMessage(key, new Locale(GenericConstants.I18N_ES_LOCALE), arguments)))
            		&& StringUtils.equals(message.toLowerCase(), messageAux.toLowerCase())){
                return true;
            }else if(!StringUtils.isBlank((messageAux = getI18nMessage(key, new Locale(GenericConstants.I18N_EN_LOCALE), arguments)))
            		&& StringUtils.equals(message.toLowerCase(), messageAux.toLowerCase())){
            	return true;
            }else if(!StringUtils.isBlank((messageAux = getI18nMessage(key, new Locale(GenericConstants.I18N_PT_LOCALE), arguments)))
            		&& StringUtils.equals(message.toLowerCase(), messageAux.toLowerCase())){
            	return true;
           }
    	}
           
    	return false;
    }
}