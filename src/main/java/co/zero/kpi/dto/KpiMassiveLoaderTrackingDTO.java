package co.zero.kpi.dto;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.kpi.LoaderState;
import co.zero.common.enumeration.kpi.LoaderType;
import co.zero.hcm.dto.CompanyDTO;

/**
 * Clase que representa un proceso de cargue masivo de cualquiera de los cargadores de KPI
 * 
 * @author Youlyn Chinome
 */
public class KpiMassiveLoaderTrackingDTO extends EntityDTO{
	//Identificador requerido para la serializacion
	private static final long serialVersionUID = 1L;
	//Nombre del archivo que el usuario escogio para cargar
	private String fileName;
	//Numero de registros procesados
	private int recordsProcessed;
	//Archivo de retroalimentacion
	private byte[] feedbackFile = null;
	//Tipo de cargador que se uso el usuario
	private LoaderType loaderType;
	//Estado del cargador
	private LoaderState loaderState;
	//Compania que pertenece el proceso de cargue
	private CompanyDTO company;
	
	/**
	 * Metodo que permite obtener el nombre del archivo que el usuario escogio para cargar
	 * @return El nombre del archivo que el usuario escogio para cargar
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Metodo que permite modificar el nombre del archivo que el usuario escogio para cargar
	 * @param name El nuevo nombre del archivo que el usuario escogio para cargar
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * Metodo que permite obtener el numero de registros procesados
	 * @return El numero de registros procesados
	 */
	public int getRecordsProcessed() {
		return recordsProcessed;
	}

	/**
	 * Metodo que permite modificar el numero de registros procesados
	 * @param recordsProcessed El nuevo numero de registros procesados
	 */
	public void setRecordsProcessed(int recordsProcessed) {
		this.recordsProcessed = recordsProcessed;
	}
	
	/**
	 * Metodo que obtiene el archivo de retroalimentacion
	 * @return Arreglo de bytes que representa el archivo de retroalimentacion
	 */
	public byte[] getFeedbackFile() {
		return feedbackFile;
	}

	/**
	 * Metodo que modifica el archivo de retroalimentacion
	 * @param feedbackFile Nuevo arreglo de bytes que representa el archivo de retroalimentacion
	 */
	public void setFeedbackFile(byte[] feedbackFile) {
		this.feedbackFile = feedbackFile;
	}

	/**
	 * Metodo que permite obtener el tipo de cargador que se uso el usuario
	 * @return El tipo de cargador que se uso el usuario
	 */
	public LoaderType getLoaderType() {
		return loaderType;
	}

	/**
	 * Metodo que permite obtener el tipo de cargador que se uso el usuario
	 * @param loaderType El tipo de cargador que se uso el usuario
	 */
	public void setLoaderType(LoaderType loaderType) {
		this.loaderType = loaderType;
	}

	/**
	 * Metodo que permite obtener el estado del cargador
	 * @return El estado del cargador
	 */
	public LoaderState getLoaderState() {
		return loaderState;
	}

	/**
	 * Metodo que permite obtener el estado del cargador
	 * @param loaderState El estado del cargador
	 */
	public void setLoaderState(LoaderState loaderState) {
		this.loaderState = loaderState;
	}
	
	/**
	 * Metodo que permite obtener la compania a la que pertenece el proceso de cargue
	 * @return La compania a la que pertenece el proceso de cargue
	 */
	public CompanyDTO getCompany() {
		return company;
	}

	/**
	 * Metodo que permite modificar la compania a la que pertenece el proceso de cargue
	 * @param company La compania a la que pertenece el proceso de cargue
	 */
	public void setCompany(CompanyDTO company) {
		this.company = company;
	}
	
	/*
	 * (non-Javadoc)
	 * @see co.zero.common.dto.EntityDTO#toString()
	 */
	@Override
	public String toString() {
		long companyId = this.company == null ? 0 : this.company.getId();
		StringBuilder text = new StringBuilder(super.toString());
		text.append(" [fileName="+this.fileName+"]");
		text.append(" [recordsProcessed="+this.recordsProcessed+"]");
		text.append(" [loaderType="+this.loaderType+"]");
		text.append(" [loaderState="+this.loaderState+"]");
		text.append(" [companyId="+companyId+"]");
		return text.toString();
	}
}