/**
 * 
 */
package co.zero.common.enumeration.kpi;

/**
 * Enumeración que reune los posibles estados del proceso de cargadores masivos
 */
public enum LoaderState {
	//Procesado
	PROCESSED,
	//En proceso
	PROCESS,
	//Ocurrio un error en la lectura del archivo
	FAILED
}
