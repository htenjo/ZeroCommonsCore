//=======================================================================
// ARCHIVO PeriodicType.java
// FECHA CREACIÓN: 2012/08/15
//=======================================================================
package co.zero.common.enumeration;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import co.zero.common.util.DateUtils;
import co.zero.common.util.FormatUtils;

/**
 * Enumeración que reune las diferentes clases de periodo admitidas en el sistema
 * @author Hernán Tenjo
 * @version 1.0
 */
public enum PeriodicType {
	//Seguimiento semanal
	WEEKLY(){
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.PeriodicType#getMonthsCount()
		 */
		public int getMonthsCount(){
			return 0;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.PeriodicType#getNextPeriod(java.util.GregorianCalendar)
		 */
		public GregorianCalendar getNextPeriodEndDate(GregorianCalendar date){
			GregorianCalendar dateAux = DateUtils.getDateForNextDayOfWeek(date);
			dateAux.add(Calendar.DAY_OF_MONTH, -1);
			return dateAux;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.PeriodicType#getPeriodStartDate(java.util.GregorianCalendar)
		 */
		public GregorianCalendar getPeriodStartDate(Date date) {
			GregorianCalendar dateAux = new GregorianCalendar();
			dateAux.setTime(date);
			dateAux.add(Calendar.DAY_OF_WEEK, -6);
			return dateAux;
		}
	},
	
	//Seguimiento quincenal
	TWO_WEEKLY(){
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.PeriodicType#getMonthsCount()
		 */
		public int getMonthsCount(){
			return 0;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.PeriodicType#getNextPeriod(java.util.GregorianCalendar)
		 */
		public GregorianCalendar getNextPeriodEndDate(GregorianCalendar date){
			return DateUtils.getDateForNextTwoWeekEndRange(date);
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.PeriodicType#getPeriodStartDate(java.util.GregorianCalendar)
		 */
		public GregorianCalendar getPeriodStartDate(Date date) {
			GregorianCalendar endDate = new GregorianCalendar();
			endDate.setTime(date);
			GregorianCalendar dateAux = new GregorianCalendar();
			dateAux.setTime(date);
			if (endDate.get(Calendar.DAY_OF_MONTH) <= 15) {
				dateAux.set(Calendar.DAY_OF_MONTH, 1);
			} else {
				dateAux.set(Calendar.DAY_OF_MONTH, 15);
			}
			return dateAux;
		}
	},
	
	//Mensual
	MONTHLY(){
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.PeriodicType#getMonthsCount()
		 */
		public int getMonthsCount(){
			return 1;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.PeriodicType#getNextPeriod(java.util.GregorianCalendar)
		 */
		public GregorianCalendar getNextPeriodEndDate(GregorianCalendar date){
			GregorianCalendar nextDate = new GregorianCalendar();
			nextDate.setTime(date.getTime());
			nextDate.add(Calendar.MONTH, getMonthsCount());
			nextDate.add(Calendar.DAY_OF_MONTH, -1);
			return nextDate;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.PeriodicType#getPeriodStartDate(java.util.GregorianCalendar)
		 */
		public GregorianCalendar getPeriodStartDate(Date date) {
			GregorianCalendar dateAux = new GregorianCalendar();
			dateAux.setTime(date);
			dateAux.add(Calendar.MONTH, -1);
			dateAux.set(Calendar.DATE, dateAux.getActualMaximum(Calendar.DAY_OF_MONTH));
			dateAux.add(Calendar.DAY_OF_MONTH, 1);
			return dateAux;
		}
	},
	
	//Bimestral
	BI_MONTHLY(){
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.PeriodicType#getMonthsCount()
		 */
		public int getMonthsCount(){
			return 2;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.PeriodicType#getNextPeriod(java.util.GregorianCalendar)
		 */
		public GregorianCalendar getNextPeriodEndDate(GregorianCalendar date){
			GregorianCalendar nextDate = new GregorianCalendar();
			nextDate.setTime(date.getTime());
			nextDate.add(Calendar.MONTH, getMonthsCount());
			nextDate.add(Calendar.DAY_OF_MONTH, -1);
			return nextDate;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.PeriodicType#getPeriodStartDate(java.util.GregorianCalendar)
		 */
		public GregorianCalendar getPeriodStartDate(Date date) {
			GregorianCalendar dateAux = new GregorianCalendar();
			dateAux.setTime(date);
			dateAux.add(Calendar.MONTH, -2);
			dateAux.set(Calendar.DATE, dateAux.getActualMaximum(Calendar.DAY_OF_MONTH));
			dateAux.add(Calendar.DAY_OF_MONTH, 1);
			return dateAux;
		}
	},
	
	//Trimestral
	THREE_MONTHLY(){
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.PeriodicType#getMonthsCount()
		 */
		public int getMonthsCount(){
			return 3;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.PeriodicType#getNextPeriod(java.util.GregorianCalendar)
		 */
		public GregorianCalendar getNextPeriodEndDate(GregorianCalendar date){
			GregorianCalendar nextDate = new GregorianCalendar();
			nextDate.setTime(date.getTime());
			nextDate.add(Calendar.MONTH, getMonthsCount());
			nextDate.add(Calendar.DAY_OF_MONTH, -1);
			return nextDate;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.PeriodicType#getPeriodStartDate(java.util.GregorianCalendar)
		 */
		public GregorianCalendar getPeriodStartDate(Date date) {
			GregorianCalendar dateAux = new GregorianCalendar();
			dateAux.setTime(date);
			dateAux.add(Calendar.MONTH, -3);
			dateAux.set(Calendar.DATE, dateAux.getActualMaximum(Calendar.DAY_OF_MONTH));
			dateAux.add(Calendar.DAY_OF_MONTH, 1);
			return dateAux;
		}
	},
	
	//Cuatrimestral
	FOURTH_MONTHLY(){
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.PeriodicType#getMonthsCount()
		 */
		public int getMonthsCount(){
			return 4;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.PeriodicType#getNextPeriod(java.util.GregorianCalendar)
		 */
		public GregorianCalendar getNextPeriodEndDate(GregorianCalendar date){
			GregorianCalendar nextDate = new GregorianCalendar();
			nextDate.setTime(date.getTime());
			nextDate.add(Calendar.MONTH, getMonthsCount());
			nextDate.add(Calendar.DAY_OF_MONTH, -1);
			return nextDate;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.PeriodicType#getPeriodStartDate(java.util.GregorianCalendar)
		 */
		public GregorianCalendar getPeriodStartDate(Date date) {
			GregorianCalendar dateAux = new GregorianCalendar();
			dateAux.setTime(date);
			dateAux.add(Calendar.MONTH, -4);
			dateAux.set(Calendar.DATE, dateAux.getActualMaximum(Calendar.DAY_OF_MONTH));
			dateAux.add(Calendar.DAY_OF_MONTH, 1);
			return dateAux;
		}
	},
	
	//Semestral
	SIX_MONTHLY(){
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.PeriodicType#getMonthsCount()
		 */
		public int getMonthsCount(){
			return 6;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.PeriodicType#getNextPeriod(java.util.GregorianCalendar)
		 */
		public GregorianCalendar getNextPeriodEndDate(GregorianCalendar date){
			GregorianCalendar nextDate = new GregorianCalendar();
			nextDate.setTime(date.getTime());
			nextDate.add(Calendar.MONTH, getMonthsCount());
			nextDate.add(Calendar.DAY_OF_MONTH, -1);
			return nextDate;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.PeriodicType#getPeriodStartDate(java.util.GregorianCalendar)
		 */
		public GregorianCalendar getPeriodStartDate(Date date) {
			GregorianCalendar dateAux = new GregorianCalendar();
			dateAux.setTime(date);
			dateAux.add(Calendar.MONTH, -6);
			dateAux.set(Calendar.DATE, dateAux.getActualMaximum(Calendar.DAY_OF_MONTH));
			dateAux.add(Calendar.DAY_OF_MONTH, 1);
			return dateAux;
		}
	},
	
	//Anual
	YEARLY(){
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.PeriodicType#getMonthsCount()
		 */
		public int getMonthsCount(){
			return 12;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.PeriodicType#getNextPeriod(java.util.GregorianCalendar)
		 */
		public GregorianCalendar getNextPeriodEndDate(GregorianCalendar date){
			GregorianCalendar nextDate = new GregorianCalendar();
			nextDate.setTime(date.getTime());
			nextDate.add(Calendar.MONTH, getMonthsCount());
			nextDate.add(Calendar.DAY_OF_MONTH, -1);
			return nextDate;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.PeriodicType#getPeriodStartDate(java.util.GregorianCalendar)
		 */
		public GregorianCalendar getPeriodStartDate(Date date) {
			GregorianCalendar dateAux = new GregorianCalendar();
			dateAux.setTime(date);
			dateAux.add(Calendar.MONTH, -12);
			dateAux.set(Calendar.DATE, dateAux.getActualMaximum(Calendar.DAY_OF_MONTH));
			dateAux.add(Calendar.DAY_OF_MONTH, 1);
			return dateAux;
		}
	};
	
	/**
	 * Método que permite determinar la cantidad de meses que abarca 
	 * el tipo de periodicidad seleccionado 
	 * @return La cantidad de meses que abarca la periodicidad
	 */
	public abstract int getMonthsCount();
	
	/**
	 * Método que obtiene la fecha del siguiente periodo tomando como base la fecha dada
	 * @param date Fecha sobre la que se hará el análisis
	 * @return Fecha del siguiente periodo
	 */
	public abstract GregorianCalendar getNextPeriodEndDate(GregorianCalendar date);
	
	/**
	 * Método que obtiene la fecha de inicio del periodo tomando como base la fecha dada
	 * @param date Fecha sobre la que se hará el análisis
	 * @return Fecha de inicio del periodo
	 */
	public abstract GregorianCalendar getPeriodStartDate(Date date);
	
	public static void main(String[] args) throws ParseException {
		GregorianCalendar date = new GregorianCalendar(2012, 01, 01);
		PeriodicType period = PeriodicType.MONTHLY;
		System.out.println(FormatUtils.formatDate(date.getTime(), "yyyy/MM/dd"));
		
		date = period.getNextPeriodEndDate(date);
		System.out.println(FormatUtils.formatDate(date.getTime(), "yyyy/MM/dd"));
		date.add(Calendar.DAY_OF_MONTH, 1);
		date = period.getNextPeriodEndDate(date);
		System.out.println(FormatUtils.formatDate(date.getTime(), "yyyy/MM/dd"));
		date.add(Calendar.DAY_OF_MONTH, 1);
		date = period.getNextPeriodEndDate(date);
		System.out.println(FormatUtils.formatDate(date.getTime(), "yyyy/MM/dd"));
		date.add(Calendar.DAY_OF_MONTH, 1);
		date = period.getNextPeriodEndDate(date);
		System.out.println(FormatUtils.formatDate(date.getTime(), "yyyy/MM/dd"));
		date.add(Calendar.DAY_OF_MONTH, 1);
		date = period.getNextPeriodEndDate(date);
		System.out.println(FormatUtils.formatDate(date.getTime(), "yyyy/MM/dd"));
		date.add(Calendar.DAY_OF_MONTH, 1);
		date = period.getNextPeriodEndDate(date);
		System.out.println(FormatUtils.formatDate(date.getTime(), "yyyy/MM/dd"));
	}
}