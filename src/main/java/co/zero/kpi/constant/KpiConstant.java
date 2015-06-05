/**
 * 
 */
package co.zero.kpi.constant;

import org.apache.commons.lang.StringUtils;

import co.zero.common.enumeration.PeriodicType;
import co.zero.common.exception.ZeroException;

/**
 * Esta clase reune las constantes manejadas por el módulo de KPIs
 * @author TOSHIBA
 */
public class KpiConstant {
	//LAS SIGUIENTES CONSTANTES SON PROVISIONALES, MIENTRAS SE DESARROLLA LA 
	//SELECCIÓN DE LAS COLUMNAS EN LOS CARGADORES MASIVOS
	public static final String METRIC_TYPE_GENERAL = "general";
	public static final String METRIC_TYPE_PARTIAL_ES = "parcial";
	public static final String METRIC_TYPE_PARTIAL_EN = "partial";
	public static final String YES_ES = "si";
	public static final String YES_EN = "yes";
	public static final String NO = "no";
	public static final String TREND_ES = "ascendente";
	public static final String TREND_EN = "ascendant";
	public static final String PERIOD_WEEKLY_ES = "semanal";
	public static final String PERIOD_TWO_WEEKLY_ES = "quincenal";
	public static final String PERIOD_MONTHLY_ES = "mensual";
	public static final String PERIOD_BI_MONTHLY_ES = "bimestral";
	public static final String PERIOD_THREE_MONTHLY_ES = "trimestral";
	public static final String PERIOD_FOURTH_MONTHLY_ES = "cuatrimestral";
	public static final String PERIOD_SIX_MONTHLY_ES = "semestral";
	public static final String PERIOD_YEARLY_ES = "anual";
	
	public static final PeriodicType findPeriodType(String frecuency) throws ZeroException{
		if(StringUtils.equalsIgnoreCase(frecuency, PeriodicType.WEEKLY.toString()) || StringUtils.equalsIgnoreCase(frecuency, PERIOD_WEEKLY_ES)){
			return PeriodicType.WEEKLY;
		}else if(StringUtils.equalsIgnoreCase(frecuency, PeriodicType.TWO_WEEKLY.toString()) || StringUtils.equalsIgnoreCase(frecuency, PERIOD_TWO_WEEKLY_ES)){
			return PeriodicType.TWO_WEEKLY;
		}else if(StringUtils.equalsIgnoreCase(frecuency, PeriodicType.MONTHLY.toString()) || StringUtils.equalsIgnoreCase(frecuency, PERIOD_MONTHLY_ES)){
			return PeriodicType.MONTHLY;
		}else if(StringUtils.equalsIgnoreCase(frecuency, PeriodicType.BI_MONTHLY.toString()) || StringUtils.equalsIgnoreCase(frecuency, PERIOD_BI_MONTHLY_ES)){
			return PeriodicType.BI_MONTHLY;
		}else if(StringUtils.equalsIgnoreCase(frecuency, PeriodicType.THREE_MONTHLY.toString()) || StringUtils.equalsIgnoreCase(frecuency, PERIOD_THREE_MONTHLY_ES)){
			return PeriodicType.THREE_MONTHLY;
		}else if(StringUtils.equalsIgnoreCase(frecuency, PeriodicType.FOURTH_MONTHLY.toString()) || StringUtils.equalsIgnoreCase(frecuency, PERIOD_FOURTH_MONTHLY_ES)){
			return PeriodicType.FOURTH_MONTHLY;
		}else if(StringUtils.equalsIgnoreCase(frecuency, PeriodicType.SIX_MONTHLY.toString()) || StringUtils.equalsIgnoreCase(frecuency, PERIOD_SIX_MONTHLY_ES)){
			return PeriodicType.SIX_MONTHLY;
		}else if(StringUtils.equalsIgnoreCase(frecuency, PeriodicType.YEARLY.toString()) || StringUtils.equalsIgnoreCase(frecuency, PERIOD_YEARLY_ES)){
			return PeriodicType.YEARLY;
		}else{
			return null;
		}
	}
	
}
