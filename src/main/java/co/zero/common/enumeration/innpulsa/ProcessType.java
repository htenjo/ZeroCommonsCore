//=======================================================================
// ARCHIVO ProcessType.java
// FECHA CREACIÓN: 2014/02/19
//=======================================================================
package co.zero.common.enumeration.innpulsa;

/**
 * Clase que define los posibles procesos que se pueden llevar a cabo en el sistema
 * p.e. Un proceso puede ser una evaluación360 y otro una evaluaciónKPI, pero se pueden
 * definir a conveniencia según los requerimientos p.e. Desempeño no es una evaluación sino
 * la combinación de varias y puede ser definida como un proceso independiente
 * @author Hernán Tenjo
 * @version 1.0
 */
public enum ProcessType {
	COMPETENCES,
	CLIMA,
	PERFORMANCE,
	GOALS,
	ACTIVITIES
}
