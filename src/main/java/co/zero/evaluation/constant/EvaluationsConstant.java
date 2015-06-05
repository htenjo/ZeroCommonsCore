//=======================================================================
// ARCHIVO EvaluationsConstant.java
// FECHA CREACIÓN: 09/02/2012
//=======================================================================
package co.zero.evaluation.constant;

/**
 * Clase que reune constantes requeridas por el módulo de evaluaciones
 * @author Hernán Tenjo
 * @version 1.0
 */
public class EvaluationsConstant {
	//Nombre de las relaciones soportadas en español
	public static final String RELATION_SELF_SPANISH = "AUTOEVALUACION";
	public static final String RELATION_BOSS_SPANISH = "JEFE";
	public static final String RELATION_COLLEAGUE_SPANISH = "COLEGA";
	public static final String RELATION_COLLABORATOR_SPANISH = "COLABORADOR";
	public static final String RELATION_INTERNAL_CLIENT_SPANISH = "CLIENTE_INTERNO";
	public static final String RELATION_EXTERNAL_CLIENT_SPANISH = "CLIENTE_EXTERNO";
	public static final String RELATION_SUPPLIER_SPANISH = "PROVEEDOR";
	public static final String RELATION_SUPERVISOR_SPANISH = "SUPERVISOR";
	public static final String RELATION_OBSERVER_SPANISH = "OBSERVADOR";
	public static final String RELATION_OTHERS_KEY_PREFIX = "RELATION_AUX_OTHERS";
	
	public static final int DOFA_SELF_UP_OTHERS_UP_INDEX = 1;
	public static final int DOFA_SELF_UP_OTHERS_DOWN_INDEX = 2;
	public static final int DOFA_SELF_DOWN_OTHERS_UP_INDEX = 3;
	public static final int DOFA_SELF_DOWN_OTHERS_DOWN_INDEX = 4;
}