//=======================================================================
// ARCHIVO ReportDownloadProcess.java
// FECHA CREACIÓN: 2013/03/15
//=======================================================================
package co.zero.evaluation.dto;

import co.zero.common.dto.EntityDTO;

/**
 * Clase que representa un proceso de descarga de un reporte con items
 * @author Hernán Tenjo
 * @version 1.0
 */
public class ReportDownloadProcessDTO extends EntityDTO{
	private static final long serialVersionUID = 1L;
	public static final int PROCESS_STATUS_NOT_STARTED = 0;
	public static final int PROCESS_STATUS_STARTED = 1;
	public static final int PROCESS_STATUS_FINISHED = 2;
	public static final int PROCESS_STATUS_CANCELING = 3;
	public static final int PROCESS_STATUS_CANCELED = 4;
	public static final int PROCESS_STATUS_WITH_ERROR = 5;
	
	//Configuración del reporte que se está procesando
	private ReportConfigurationDTO configuration;
	//Cantidad total de items que deberán ser procesados
	private int totalItems;
	//Cantidad de items que han sido reportados por el proceso asíncrono como procesados
	private int processedItems;
	//Determina si de forma arbitraria se ha cancelado el proceso
	private boolean processCanceled;
	//Ruta donde quedará el ZIP con la información descargada luego de terminar el proceso
	private String reportDownloadUrl;
	//Determina el estado del proceso
	private int status;
	
	/**
	 * Método que asigna la configuración del reporte que se va a procesar
	 * @return Configuración del reporte relacionada
	 */
	public ReportConfigurationDTO getConfiguration() {
		return configuration;
	}

	/**
	 * Método que modifica la configuración del reporte que se va a procesar
	 * @param configuration La nueva configuración que se desea relacionar
	 */
	public void setConfiguration(ReportConfigurationDTO configuration) {
		this.configuration = configuration;
	}

	/**
	 * Obtiene la cantidad total de items que serán procesados
	 * @return La cantidad total de items
	 */
	public int getTotalItems() {
		return totalItems;
	}

	/**
	 * Modifica la cantidad total de items que serán procesados
	 * @param totalItems La nueva cantidad de items que serán procesados
	 */
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	/**
	 * Métood que obtiene la cantidad de items reportados como procesados
	 * @return La cantidad de items que el proceso asíncrono ha reportado como procesados
	 */
	public int getProcessedItems() {
		return processedItems;
	}

	/**
	 * Método que modifica la cantidad de items reportados como procesados
	 * @param processedItems La nueva cantidad de items procesados
	 */
	public void setProcessedItems(int processedItems) {
		this.processedItems = processedItems;
	}

	/**
	 * Método que determina si se ha solicitado la cancelación del proceso de descarga
	 * @return True si se ha solicitado la cancelación del proceso, false de lo contrario
	 */
	public boolean isProcessCanceled() {
		return processCanceled;
	}

	/**
	 * Método que modifica la solicitud de cancelación del proceso de descarga
	 * @param processCanceled True si se desea cancelar el proceso, false de lo contrario
	 */
	public void setProcessCanceled(boolean processCanceled) {
		this.processCanceled = processCanceled;
	}

	/**
	 * Método que obtiene la url del archivo ZIP que se ha generado al terminar el proceso
	 * @return La URL del archivo ZIP, listo para ser descargado
	 */
	public String getReportDownloadUrl() {
		return reportDownloadUrl;
	}

	/**
	 * Método que modifica la url del archivo ZIP que se ha generado al terminar el proceso
	 * @param reportDownloadUrl La nueva URL del reporte listo para ser descargado
	 */
	public void setReportDownloadUrl(String reportDownloadUrl) {
		this.reportDownloadUrl = reportDownloadUrl;
	}

	/**
	 * Método que obtiene el estado de la operación 
	 * PROCESS_STATUS_NOT_STARTED = Descarga No Iniciada
	 * PROCESS_STATUS_STARTED = Descarga Iniciada
	 * PROCESS_STATUS_FINISHED = Descargar Terminada 
	 * PROCESS_STATUS_CANCELED = Descarga Cancelada
	 * PROCESS_STATUS_WITH_ERROR = Descarga Erronea
	 * @return El indice que identifica el estado de la operación
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Método que modifica el estado de la operación de descarga
	 * @param status
	 */
	public void setStatus(int status) {
		this.status = status;
	}
}