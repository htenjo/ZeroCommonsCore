//=======================================================================
// ARCHIVO HcmErrorMessages.java
// FECHA CREACIÓN: 2021/08/15
//=======================================================================
package co.zero.kpi.exception;

import co.zero.common.constant.GenericConstants;

/**
 * Clase con todos los mensajes que se van a utilizar en el manejo de errores de KPIs
 * @author Hernán Tenjo
 * @version 1.0
 */
public class KpiErrorMessages {
	public static final String DELETE_STRATEGIES_BY_EVALUATION_WITH_DEPENDENCES = "::: No es posible eliminar los KpiStrategy " +
			"relacionados con las evaluaciones [" + GenericConstants.MSG_WILDCARD + "], ya que existen objetivos dependientes";
	public static final String DELETE_METRICS_BY_EVALUATION_WITH_DEPENDENCES =  "::: No es posible eliminar los KpiMétricGeneral " +
			"relacionados con las evaluaciones [" + GenericConstants.MSG_WILDCARD + "], ya que existen objetivos dependientes";
	public static final String METRIC_PERIOD_NOT_AVAILABLE = "::: El periodo [" + GenericConstants.MSG_WILDCARD + 
			"] no se encuentra disponible para ser asignado";
	public static final String UPDATE_METRIC_GENERAL_PERIODICITY_WITH_METRIC_PARTIALS = "::: No es posible actualizar la " +
			"KpiMetricGeneral [" + GenericConstants.MSG_WILDCARD + "], ya que se ha modificado la periodicidad a [" + 
			GenericConstants.MSG_WILDCARD + "] y los periodos actuales presentan KpiMetricPartial asociados";
	
	public static final String METRIC_UPDATE_WITH_PARTIALS_ERROR = "::: La metrica [" + GenericConstants.MSG_WILDCARD + 
		"] tiene periodos asignados a métricas parciales. Elimine primero las dependencias";
	
	public static final String GOAL_INVALID_CODE = "::: El código del objetivo [" + GenericConstants.MSG_WILDCARD + 
			"] ya se encuentra en la estrategia";

	public static final String METRIC_INVALID_CODE = "::: El código de la métrica [" + GenericConstants.MSG_WILDCARD + 
			"] ya se encuentra en la evaluación [" + GenericConstants.MSG_WILDCARD + "]";
	
	public static final String INVALID_EVALUATION_NAME = "::: No se ha encontrado la evaluación KPI con el nombre [" +
			GenericConstants.MSG_WILDCARD + "] en la compañía [" + GenericConstants.MSG_WILDCARD + "]";
	
	public static final String MULTIPLE_EVALUATIONS_WITH_SAME_NAME_IN_COMPANY = "::: Se han encontrado múltiples evaluaciones" +
			" con el nombre [" + GenericConstants.MSG_WILDCARD + "] en la compañía [" + GenericConstants.MSG_WILDCARD + "]";
	
	public static final String INVALID_METRIC_TYPE = "El tipo de métrica [" + GenericConstants.MSG_WILDCARD + "] no es válido";
	
	public static final String METRIC_NOT_FOUNT_BY_CODE = "No se ha encontrado la métrica con código [" + 
			GenericConstants.MSG_WILDCARD + "] en la evaluación [" + GenericConstants.MSG_WILDCARD + "]";
	
	public static final String INVALID_PARTIAL_FORMULA_FOR_DATES = "La formula para el calculo total a través las metricas parciales " +
			"no es válida para la métrica con código [" + GenericConstants.MSG_WILDCARD + "]";
	
	public static final String UNAPPROVED_GOAL = "El objetivo [" + GenericConstants.MSG_WILDCARD + "] no ha sido aprobado";
	
	public static final String PERIOD_NOT_FOUND = "El periodo no ha sido encontrado o ya fue evaluado";
	
	public static final String PERIOD_WITHOUT_TRACKING = "No se puede registrar la evaluacion general del objetivo porque aún quedan periodos sin evaluar";
	
	public static final String GOAL_WITH_TRACKING = "Este indicador ya tiene una evaluacion general registrada";
	
	public static final String EMPTY_METRIC_TYPE = "Debe indicar el tipo de métrica que desea cargar";
	
	public static final String EMPTY_OWNER = "Debe indicar el usuario al que pertenece la métrica";
	
	public static final String INVALID_OWNER = "El usuario indicado no existe en el sistema";
	
	public static final String EMPTY_CODE = "Es obligatorio que indique un código válido";
	
	public static final String INCORRECT_OWNER = "Esta métrica ya existe sin embargo el dueño no corresponde a esta";
	
	public static final String INVALID_METRIC_NAME = "Debe espicificar el nombre de la métrica";
	
	public static final String INVALID_VALUE = "El valor es inválido";
	
	public static final String MULTIPLE_METRICS_WITH_SAME_CODE = "Existen varias métricas con el mismo código en la evaluación indicada";
	
	public static final String EMPTY_GENERAL_FORMULA_TYPE = "Como se ha indicado que la métrica tiene valor calculado, debe elegir una fórmula válida para"
			+ " la métrica general";
	
	public static final String EMPTY_PARTIAL_FORMULA_TYPE = "Como se ha indicado que la métrica tiene valor calculado basado en sus métricas parciales, "
			+ "debe elegir una fórmula válida para la métrica general";
	
	public static final String EMPTY_TREND = "Debe indicar la tendencia de la métrica";
	
	public static final String INVALID_PERIOD = "El periodo especificado es inválido";
	
	public static final String METRIC_NOT_EXIST = "No existe ninguna métrica con este código y perteneciente a la evaluación indicada";
	
	public static final String EMPTY_RANGE_LABEL = "La métrica a la cual desea guardar el valor de métrica es discreta, por tanto es obligatorio"
			+ " que indique las etiquetas de los rangos";
	
	public static final String EMPTY_SEMAPHORE = "La métrica es discreta por tanto debe indicar el color del semáforo de cumplimiento del rango";
	
	public static final String INVALID_GOAL_NAME = "Debe indicar un nombre para el objetivo";
	
	public static final String MULTIPLE_GOALS_WITH_SAME_CODE = "Existen varios objetivos con el mismo código en la evaluación indicada";
	
	public static final String STRATEGY_NOT_EXIST = "No existe ninguna macro estrategia en la evaluación con el nombre indicado";
	
	public static final String MULTIPLE_STRATEGIES_WITH_SAME_NAME = "Existen varias macro estrategias con el mismo nombre en la evaluación indicada";
	
	public static final String GOAL_NOT_EXIST = "No existe ningun objetivo en la evaluación con el código indicado";
	
	public static final String NOT_CAN_UPDATE_GOAL = "No puede actualizar el objetivo ya que el estado es pendiente o aprobado";
	
	public static final String EMPTY_DIVISION = "Debe indicar el nombre de la división";
	
	public static final String NOT_CAN_UPDATE_TRACKINGS = "Este objetivo ya tiene una evaluación general registrada por tanto ninguna evaluación parcial"
			+ " puede ser modificada";
	
	public static final String INVALID_ZONE_CODE = "No existe una zona con este código";
	
	public static final String INVALID_PROCESS_CODE = "No existe un proceso con este código";
	
	public static final String METRIC_NOT_PERIODIC = "La métrica general a la que quiere asociar la métrica parcial no es periodica";
	
	public static final String FILE_SIZE_TOO_LONG = "No se puede cargar un archivo de más de 5MB";
	
	public static final String EMPTY_TRACKING_TYPE = "Debe indicar el tipo de evaluación que desea cargar";
	
	public static final String INVALID_FILE = "El archivo es inválido y no se pudo leer";
	
	public static final String MANY_ROWS = "El archivo no puede tener más de 20.000 filas. Verifique que no exitan celdas vacías, con espacios en blanco, bordes o formatos que puedan hacer parecer que el archivo tiene más filas de información.";
	
	public static final String INVALID_GENERAL_FORMULA_FOR_METRIC_NOT_PERIODIC = "Fórmula inválida para una metrica no periodica";
}