/**
 * 
 */
package co.zero.common.enumeration.kpi;

/**
 * Enumeración que reune los posibles tipos de cargadores masivos que hay para KPI
 */
public enum LoaderType {
	//Cargador de metricas
	METRIC,
	//Cargador de objetivos
	GOAL,
	//Cargador de evaluaciones
	TRACKING,
	//Cargador de indicadores eficacia
	GOAL_EFICACIA,
	//Cargador de relaciones eficacia
	RELATION_EFICACIA,
	//Cargador de resultados eficacia con modelo
	RESULT_EFICACIA_V1,
	//Caragdor de resultados con eficacia con modelo eficacia
	RESULT_EFICACIA
}
