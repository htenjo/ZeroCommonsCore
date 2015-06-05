//=======================================================================
// ARCHIVO DateUtils.java
// FECHA CREACIÓN: 2012/08/19
//=======================================================================
package co.zero.common.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

import co.zero.common.constant.GenericConstants;

/**
 * Clase que reune funcionalidades utiles relacionadas con el manejo de fechas
 * @author Hernán Tenjo
 * @version 1.0
 */
public class DateUtils {
	/**
	 * Método que calcula la fecha del siguiente dia de la semana (p.e. Jueves) igual al de la fecha dada
	 * @param date Objeto con la fecha que se desea analizar
	 * @return Objeto con la fecha del siguiente día de la semana igual al de la fecha dada
	 */
	public static GregorianCalendar getDateForNextDayOfWeek(GregorianCalendar date){
		GregorianCalendar nextDate = new GregorianCalendar();
		nextDate.setTime(date.getTime());
		nextDate.add(Calendar.DAY_OF_WEEK, GenericConstants.DAYS_OF_WEEK);
		return nextDate;
	}
	
	/**
	 * Método que calcula la siguiente fecha final de un quincena tomando como base la fecha dada
	 * @param date Objeto con la fecha que se desea analizar
	 * @return Objeto con la fecha final de la quincena
	 */
	public static GregorianCalendar getDateForNextTwoWeekEndRange(GregorianCalendar date){
		GregorianCalendar nextDate = new GregorianCalendar();
		nextDate.setTime(date.getTime());
		
		if(date.get(Calendar.DAY_OF_MONTH) <= 15){
			nextDate.set(Calendar.DAY_OF_MONTH, 15);
		}else{
			nextDate.set(Calendar.DAY_OF_MONTH, nextDate.getActualMaximum(Calendar.DAY_OF_MONTH));
		}
		
		return nextDate;
	}
}