/**
 * 
 */
package co.zero.common.enumeration.kpi;

/**
 * Enumeración que reune los posibles tipos de tendencia que pueden tener
 * los valores de las métricas.
 */
public enum MetricTrendType {
	//Cuando entre mayor sea el valor final mejor
	ASCENDANT,
	//Cuando entre menor sea el valor final mejor
	DESCENDANT,
	//Cuando se requiere que el valor final sea exacto
	EXACT_VALUE
}
