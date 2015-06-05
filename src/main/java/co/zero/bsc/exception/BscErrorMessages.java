//=======================================================================
// ARCHIVO HcmErrorMessages.java
// FECHA CREACIÓN: Sep 25, 2009
//=======================================================================
package co.zero.bsc.exception;

import co.zero.common.constant.GenericConstants;

/**
 * Clase con todos los mensajes que se van a utilizar 
 * en el manejo de errores de HCM
 * @author Hernán Tenjo
 * @version 1.0
 */
public class BscErrorMessages {
	public static final String DELETE_BSC_NOT_OWN_GOAL = "::: El usuario con el cargo " +
		"id=["+GenericConstants.MSG_WILDCARD+"]:name=["+GenericConstants.MSG_WILDCARD+"] " +
		"no puede eliminar el objetivo id=["+GenericConstants.MSG_WILDCARD+"]:name["+
		GenericConstants.MSG_WILDCARD+"], ya que no es el propietario";
	
	public static final String DELETE_BSC_GOAL_WITH_CHILDREN = "::: No se puede eliminar el objetivo " +
		"id=["+GenericConstants.MSG_WILDCARD+"] ya que tiene objetivos hijos asociados";
	
	public static final String DELETE_BSC_STRATEGY_WITH_METRICS = "::: No se puede eliminar el macro objetivo " +
		"id=["+GenericConstants.MSG_WILDCARD+"] ya que tiene métricas asociadas";
	
	public static final String DELETE_BSC_METRIC_WITH_GOALS = "::: No se puede eliminar la métrica " +
		"id=["+GenericConstants.MSG_WILDCARD+"] ya que tiene objetivos asociados";
	
	public static final String DELETE_BSC_GOAL_WITH_EVALUATIONS = "::: No se puede eliminar el objetivo con " +
		"id=["+GenericConstants.MSG_WILDCARD+"] ya que tiene evaluaciones asociadas";
	
	public static final String INVALID_BSC_CHILD_METRIC_UPDATE = "::: Intentando modificar la " +
		"métrica de un objetivo, a una métrica de una estrategia ["+GenericConstants.MSG_WILDCARD+"] " +
		"diferente a la del padre ["+GenericConstants.MSG_WILDCARD+"]";
	
	public static final String DELETE_BSC_EVALUATION_WITH_STRATEGIES = "::: No se puede eliminar la Evaluación de " +
		"Desempeño con id=["+GenericConstants.MSG_WILDCARD+"] ya que tiene Macro Estrategias asociadas";
	
	public static final String METRIC_UPDATE_WITH_PARTIALS_ERROR = "::: La metrica [" + GenericConstants.MSG_WILDCARD + 
		"] tiene periodos asignados a métricas parciales. Elimine primero las dependencias";
	
	public static final String METRIC_PERIOD_ALREADY_USED = 
		"::: La metrica ["+GenericConstants.MSG_WILDCARD+"] tiene periodos asignados a métricas " +
				"parciales. Elimine primero las dependencias";
	
	public static final String METRIC_PARTIAL_NOT_DEFINED = 
		"::: No se han definido las métricas parciales para los periodos ["+GenericConstants.MSG_WILDCARD+"]";
	
	public static final String METRIC_UPDATE_WITH_TRACKING = 
		"::: La métrica ["+GenericConstants.MSG_WILDCARD+"] ya tiene objetivos evaluados.";
}