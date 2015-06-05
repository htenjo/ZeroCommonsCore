//=======================================================================
// ARCHIVO ActivityTracking.java
// FECHA CREACIÓN: 15/04/2012
//=======================================================================
package co.zero.goals.dto.development;

import java.util.Date;

import co.zero.common.dto.EntityDTO;

/**
 * Clase que modela a una actividad ideada para complementar una
 * estrategia, la cual intentará mejorar un aspecto importante faltante
 * en el desarrollo de una competencia
 * @author Hernán Tenjo
 * @version 1.0
 */
public class ActivityTrackingDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Relación que generó los tracking asociados
	private ActivityEmployeeDTO activityEmployee;
	//Determina si el empleado asistió a la actividad
	private boolean participate;
	//Estados (1-4) que puede tener una actividad (0-25%, 26-50%, 51-75%, 76-100%)
	private int trackingState;
	//Comentario adicional que puede agregar el jefe como evaluador de la actividad
	private String comment;
	//Determina si es el tracking que se tendrá en cuenta para los reportes
	private boolean currentTracking;
	//Determina si el tracking registrará datos de evaluación
	private boolean withEvaluation;
	//Determina si la evaluación ha sido aprobada
	private boolean approved;
	//Valor obtenido en la evaluación
	private double realScore;
	//Valor que se debia obtener en la evaluación
	private double expectedScore;
	//Fecha de inicio del seguimiento
	private Date startDate;
	//Fecha de finalización del seguimiento
	private Date endDate;
	//Determina si el tracking ya ha sido 
	private boolean evaluated;
	//Texto que describe la métrica con la que fue evaluado el seguimiento
	private String indicator;
	
	/**
	 * Método que obtiene la relación que generó (padre) los tracking asociados
	 * @return El {@link ActivityEmployeeDTO} asociado
	 */
	public ActivityEmployeeDTO getActivityEmployee() {
		return activityEmployee;
	}

	/**
	 * Método que modifica la relación que generó los tracking asociados
	 * @param activityEmployee El nuevo {@link ActivityEmployee} que será padre de los tracking relacionados
	 */
	public void setActivityEmployee(ActivityEmployeeDTO activityEmployee) {
		this.activityEmployee = activityEmployee;
	}
	
	/**
	 * Método que determina si el empleado participó en la evaluacion
	 * @return True si el empleado participó en la evaluación, false de lo contrario
	 */
	public boolean isParticipate() {
		return participate;
	}

	/**
	 * Método que modifica el estado de la participación del empleado en la actividad
	 * @param participate True si el empleado participó, false de lo contrario
	 */
	public void setParticipate(boolean participate) {
		this.participate = participate;
	}

	/**
	 * Método que obtiene el estado de la actividad para el periodo evaluado
	 * @return El estado de la actividad al momento de realizar el seguimiento:
	 * 1: Avance entre  0% - 25% = Color Rojo
	 * 2: Avance entre 26% - 50% = Color Naranja
	 * 3: Avance entre 51% - 75% = Color Amarillo
	 * 4: Avance entre 76% - 100%= Color Verde
	 */
	public int getTrackingState() {
		return trackingState;
	}

	/**
	 * Método que modifica el estado de la actividad para el periodo evaluado
	 * @param trackingState El nuevo estado de la actividad
	 */
	public void setTrackingState(int trackingState) {
		this.trackingState = trackingState;
	}

	/**
	 * Método que obtiene el comentario dado por el evaluador de la actividad
	 * @return Texto con el comentario del estado de la actividad
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Método que modifica el comentario dado por el evaluador de la actividad
	 * @param comment Texto con el comentario del estado de la activida
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * Método que determina si este tracking será el que se tenga en cuenta para los reportes
	 * @return True si es el tracking que será mostrado en los reportes 
	 */
	public boolean isCurrentTracking() {
		return currentTracking;
	}

	/**
	 * Método que modifica el estado que permite determinar si este trackin será el que 
	 * se tenga en cuenta para los reportes
	 * @param currentTracking True si se quiere que este tracking sea el que muestre en los reportes
	 */
	public void setCurrentTracking(boolean currentTracking) {
		this.currentTracking = currentTracking;
	}

	/**
	 * Método que determina si el tracking desea registrar info de evaluación
	 * @return True si se va a registrar información de evaluación de la actividad
	 */
	public boolean isWithEvaluation() {
		return withEvaluation;
	}

	/**
	 * Método que modifica si se desea registrar la información de la evaluación
	 * @param withEvaluation True si se desea registrar la información de la evaluación
	 */
	public void setWithEvaluation(boolean withEvaluation) {
		this.withEvaluation = withEvaluation;
	}

	/**
	 * Método que determina si se aprobó la evaluación realizada en la evaluación
	 * @return True si se aprobó la evaluación, false de lo contrario
	 */
	public boolean isApproved() {
		return approved;
	}

	/**
	 * Método que modifica el estado de evaluación aprobada de la evaluación 
	 * @param approved True si aprobó la evaluación, false de lo contrario
	 */
	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	/**
	 * Método que obtiene el valor obtenido en la evaluación de la actividad
	 * @return El valor obtenido en la evaluación
	 */
	public double getRealScore() {
		return realScore;
	}

	/**
	 * Método que modifica el valor obtenido en la evaluación de la actividad
	 * @param realScore El valor que se desea asignar a la evaluación de la actividad
	 */
	public void setRealScore(double realScore) {
		this.realScore = realScore;
	}

	/**
	 * Método que obtiene el valor esperado para la evlauación de la actividad
	 * @return El valor que se esperaba alcanzada el empleado en la actividad
	 */
	public double getExpectedScore() {
		return expectedScore;
	}

	/**
	 * Método que modifica el valor esperado para la evaluación de la actividad
	 * @param expectedScore El nuevo valor esperado para la evaluación de la actividad
	 */
	public void setExpectedScore(double expectedScore) {
		this.expectedScore = expectedScore;
	}
	

	/**
	 * Método que obtiene la fecha de inicio del seguimiento
	 * @return La fecha de inicio del seguimiento configurada
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Método que modifica la fecha de inicio del seguimiento
	 * @param startDate La nueva fecha de inicio del seguimiento
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Método que obtiene la fecha de finalización del seguimiento
	 * @return La fecha de finalización del seguimiento
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Método que modifica la fecha de finalización del seguimiento
	 * @param endDate La nueva fecha de finalización del seguimiento 
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	

	/**
	 * Método que determina si el tracking ha sido evaluado
	 * @return True si el tracking ha sido evaluado, false de lo contrario
	 */
	public boolean isEvaluated() {
		return evaluated;
	}

	/**
	 * Método que modifica el estado evaluado del tracking
	 * @param evaluated True si se desea que el tracking figure como evaluado, false de lo contrario
	 */
	public void setEvaluated(boolean evaluated) {
		this.evaluated = evaluated;
	}
	
	/**
	 * Método que obtiene el texto que describe el indicador de evaluación
	 * @return El texto del indicador
	 */
	public String getIndicator() {
		return indicator;
	}

	/**
	 * Método que modifica el texto que describe el indicador de evaluacion
	 * @param indicator El nuevo indicador con el que se evaluó la actividad
	 */
	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}
	
	/**
	 * Método que determina si el seguimiento se encuentra apto para ser evaluado 
	 * @return True si el periodo se encuentra apto para ser evaluado, false de lo contrario
	 */
	public boolean isReadyForEvaluate(){
		Date currentDate = new Date();
		
		if(!evaluated && startDate.before(currentDate)){
			return true;
		}else{
			return false;
		}
	}
}