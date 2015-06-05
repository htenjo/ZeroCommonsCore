package co.zero.goals.utils;

import java.util.Date;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateUtils;

/**
 * Clase asistente para la comparacion de valores
 * @author Julian Gomez
 */
public class CompareHelper {
    /**
     * Comparar dos valores, teniendo en cuenta la posibilidad de que éstos 
     * puedan ser nulos.
     * @param <T>   Clase del parametro a comparar. Debe extender Comparable
     * @param n1    Primer objeto a comparar.
     * @param n2    Segundo objeto a comparar.
     * @return  Un valor entero que es negativo si el primer parametro es menor 
     * que el segundo, es positivo si el segundo es menor que el primero y 0 si 
     * son iguales. 
     */
    public static <T extends Comparable <? super T>> int compare(T n1, T n2) {
        int result=0;
        if (n1!=null && n2!=null) {
            result=n1.compareTo(n2);
        }
        else if (n1!=null) {
            result=1;
        }
        else if (n2!=null) {
            result=-1;
        }
        
        return result;
    }
    
    /**
     * Comparar dos cadenas de caracteres, teniendo en cuenta la posibilidad de 
     * que éstos puedan ser nulos.
     * @param val1  Primer objeto a comparar.
     * @param val2  Segundo objeto a comparar.
     * @return  Un valor entero que es negativo si el primer parámetro es menor 
     * que el segundo, es positivo si el segundo es menor que el primero y 0 si 
     * son iguales. 
     */
    public static int stringCompare(String val1, String val2) {
        int result=0;
        
        if (val1==null)
            val1="";
        if (val2==null)
            val2="";
        
        result=val1.compareTo(val2);
        
        return result;
    }
    
    /**
     * Comparar dos cadenas de caracteres, teniendo en cuenta la posibilidad de 
     * que éstos puedan ser nulos e ignorando la diferencia entre mayúsculas y
     * minúsculas.
     * @param val1  Primer objeto a comparar.
     * @param val2  Segundo objeto a comparar.
     * @return  Un valor entero que es negativo si el primer parámetro es menor 
     * que el segundo, es positivo si el segundo es menor que el primero y 0 si 
     * son iguales. 
     */
    public static int stringCompareIgnoreCase(String val1, String val2) {
        int result=0;
        if (val1==null)
            val1="";
        if (val2==null)
            val2="";
        
        result=val1.compareToIgnoreCase(val2);
        return result;
    }

    /**
     * Determinar si una cadena es nula o vacía.
     * @param str   Cadena de caracteres a analizar
     * @return true Si la cadena de caracteres es nula, o es una cadena vacía
     */
    public static boolean isEmpty(String str) {
        return str!=null?str.length()==0:true;
    }
    
    /**
     * Checks if two date objects are on the same day ignoring time.
     * @param beginDate
     * @param endDate
     * @return true if they represent the same day 
     */
    public static boolean isSameDay(Date beginDate, Date endDate){
    	return DateUtils.isSameDay(beginDate, endDate);
    }
    
    /**
     * Compare two object Date
     * @param beginDate
     * @param endDate
     * @return A negative integer if the first one is before than second one, 
     * a positive integer if the first one is after than sencod one else zero.
     */
    public static int compareDates(Date beginDate, Date endDate){
    	if(DateUtils.isSameInstant(beginDate, endDate)){
    		return 0;
    	}else{
    		return beginDate.compareTo(endDate);
    	}
    	
    }
    
    /**
     * Checks whether the String a valid Java number.
     * Valid numbers include hexadecimal marked with the 0x  qualifier, 
     * scientific notation and numbers marked with a type qualifier (e.g. 123L).
	 * Null and empty String will return false.
     * @param aNumber
     * @return true if the string is a correctly formatted number
     */
    public static boolean isNumber(String aNumber){
    	return NumberUtils.isNumber(aNumber);
    }
}
