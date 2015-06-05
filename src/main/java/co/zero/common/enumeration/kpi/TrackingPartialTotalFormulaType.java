/**
 * 
 */
package co.zero.common.enumeration.kpi;

/**
 * Enumeración que reune las posibles formas de calcular el total acumulado de las
 * métricas parciales
 * @author hernan
 */
public enum TrackingPartialTotalFormulaType {
	//Se suman los valores reales registrados durante cada periodo
	SUM_REAL_VALUES,
	//Se suman los porcentajes de cumplimiento obtenidos durante cada periodo
	SUM_COMPLIMENT_PERCENT,
	//Se calcula el promedio simple de los valores reales registrados durante cada periodo
	AVERAGE_REAL_VALUES,
	//Se calcula el promedio simple de los porcentajes de cumplimiento obtenido durante cada periodo
	AVERAGE_COMPLIMENT_PERCENT,
	// El valor final del objetivo será tomado del valor real registrado para la última métrica parcial
	ASSIGNED_BY_LAST_PARTIAL_VALUE,
	// El valor final del objetivo será tomado del % de cumplimiento registrado para la última métrica parcial
	ASSIGNED_BY_LAST_PARTIAL_PERCENT
}
