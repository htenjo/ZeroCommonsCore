//=======================================================================
// ARCHIVO ExtrafieldDTO.java
// FECHA CREACIÓN: Oct 1, 2009
//=======================================================================
package co.zero.hcm.dto;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.primefaces.model.UploadedFile;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.PersistentType;
import co.zero.hcm.dto.ui.DataItemDTO;

/**
 * Bean que contiene la información requerida por la vista para cualquier campo
 * adicional de una entidad
 * 
 * @author Hernán Tenjo
 * @version 1.0
 */
public class ExtrafieldDTO extends EntityDTO {
	// Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	private static final String IMAGE_EXTENSION = "([^\\s]+(\\.(?i)(jpg|png|gif))$)";
	// Objeto con la definicion del extrafield
	private ExtrafieldMetadataDTO metadata;
	// Variable que toma el valor long de un extrafield de este tipo
	private long longValue;
	// Variable que toma el valor double de un extrafield de este tipo
	private double doubleValue;
	// Variable que toma el valor booleano de un extrafield de este tipo
	private boolean booleanValue;
	// Variable que toma el valor date de un extrafield de este tipo
	private Date dateValue = null;
	// Variable que toma el valor string de un extrafield de este tipo
	private String stringValue = null;
	//Variable que toma el valor texto de un extrafield de este tipo
	private String textValue = null;
	// Variable que le permite al extrafield guardar cualquier tipo de archivo
	private byte[] fileValue = null;
	// Variable que permite establecer el valor de un extrafield con base en
	// el valor asignado a una de las opciones de un DataGroup
	private DataItemDTO dataItemValue;
	// Objeto de Primefaces que permite guardar la imagen
	private UploadedFile uploadedImage;
	// Objeto de Primefaces que permite guardar el archivo que sera persistido
	private UploadedFile uploadedFile;
	//Nombre de la clase a la que pertenece el extrafield
	private String type;
	//Identificador de la entidad a la que pertenece el extrafield
	private long entityId;

	/**
	 * Metodo que permite obtener el item asociado al extrafield
	 * 
	 * @return El
	 */
	public DataItemDTO getDataItemValue() {
		return dataItemValue;
	}

	/**
	 * @param dataItemValue
	 *            the dataItem to set
	 */
	public void setDataItemValue(DataItemDTO dataItemValue) {
		this.dataItemValue = dataItemValue;
	}

	/**
	 * @return the longValue
	 */
	public long getLongValue() {
		return longValue;
	}

	/**
	 * @param longValue
	 *            the longValue to set
	 */
	public void setLongValue(long longValue) {
		this.longValue = longValue;
	}

	/**
	 * @return the doubleValue
	 */
	public double getDoubleValue() {
		return doubleValue;
	}

	/**
	 * @param doubleValue
	 *            the doubleValue to set
	 */
	public void setDoubleValue(double doubleValue) {
		this.doubleValue = doubleValue;
	}

	/**
	 * @return the booleanValue
	 */
	public boolean isBooleanValue() {
		return booleanValue;
	}

	/**
	 * @param booleanValue
	 *            the booleanValue to set
	 */
	public void setBooleanValue(boolean booleanValue) {
		this.booleanValue = booleanValue;
	}

	/**
	 * @return the dateValue
	 */
	public Date getDateValue() {
		return dateValue;
	}

	/**
	 * @param dateValue
	 *            the dateValue to set
	 */
	public void setDateValue(Date dateValue) {
		this.dateValue = dateValue;
	}

	/**
	 * @return the stringValue
	 */
	public String getStringValue() {
		return stringValue;
	}

	/**
	 * @param stringValue
	 *            the stringValue to set
	 */
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	/**
	 * Método que obtiene el valor de tipo texto para el extrafield
	 * @return El valor del tipo texto del extrafield
	 */
	public String getTextValue() {
		return textValue;
	}

	/**
	 * Método que modifica el valor de tipo texto para el extrafield
	 * @param textValue El nuevo valor que tomará el extrafield
	 */
	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}
	
	/**
	 * @return the fileValue
	 */
	public byte[] getFileValue() {
		return fileValue;
	}

	/**
	 * @param fileValue
	 *            the fileValue to set
	 */
	public void setFileValue(byte[] fileValue) {
		this.fileValue = fileValue;
	}

	/**
	 * @return the metadata
	 */
	public ExtrafieldMetadataDTO getMetadata() {
		return metadata;
	}

	/**
	 * @param metadata
	 *            the metadata to set
	 */
	public void setMetadata(ExtrafieldMetadataDTO metadata) {
		this.metadata = metadata;
	}

	/**
	 * @return the uploadedFile
	 */
	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	/**
	 * @param uploadedFile
	 */
	public void setUploadedFile(UploadedFile uploadedFile) {
		if(uploadedFile != null){
			this.uploadedFile = uploadedFile;
			fileValue = this.uploadedFile.getContents();
			stringValue = this.uploadedFile.getFileName();
		}
	}

	/**
	 * @return the uploadedImage
	 */
	public UploadedFile getUploadedImage() {
		return uploadedImage;
	}

	/**
	 * @param uploadedImage
	 */
	public void setUploadedImage(UploadedFile uploadedImage) {
		if(uploadedImage != null && uploadedImage.getFileName().matches(IMAGE_EXTENSION)){
			this.uploadedImage = uploadedImage;
			fileValue = this.uploadedImage.getContents();
			stringValue = this.uploadedImage.getFileName();
		}
	}

	/**
	 * Cambia el password de ser necesario
	 * @param passwordTemp
	 */
	public void setPasswordTemp(String passwordTemp) {
		if (!StringUtils.isBlank(passwordTemp) && !passwordTemp.equals(stringValue)) {
			setStringValue(passwordTemp);
		}
	}
	
	/**
	 * Retorna el valor del password que ha sido persistido, pero este no se muestra en el componente de primefaces para los passwords
	 * @return
	 */
	public String getPasswordTemp(){
		return stringValue;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the entityId
	 */
	public long getEntityId() {
		return entityId;
	}

	/**
	 * @param entityId the entityId to set
	 */
	public void setEntityId(long entityId) {
		this.entityId = entityId;
	}

	/**
	 * Metodo que permite obtener el valor segun el tipo actual del extrafield.
	 * Dependiendo del tipo que tenga la variable, se asignará de la forma
	 * adecuada
	 * 
	 * @return El valor del extrafield
	 * @throws IllegalArgumentException
	 *             Si el extrafield no tiene un tipo de dato asociado valido
	 */
	public Object getValue() {
		if (this.metadata.getType().equals(PersistentType.BOOLEAN)) {
			return this.isBooleanValue();
		} else if (this.metadata.getType().equals(PersistentType.DATE)) {
			return this.getDateValue();
		} else if (this.metadata.getType().equals(PersistentType.DOUBLE)) {
			return this.getDoubleValue();
		} else if (this.metadata.getType().equals(PersistentType.FILE)) {
			return this.getFileValue();
		} else if (this.metadata.getType().equals(PersistentType.LONG)) {
			return this.getLongValue();
		} else if (this.metadata.getType().equals(PersistentType.STRING)) {
			return this.getStringValue();
		} else if (this.metadata.getType().equals(PersistentType.TEXT)) {
			return this.getTextValue();
		} else if (metadata.getType().equals(PersistentType.DATA_ITEM)) {
			return this.getDataItemValue();
		} else {
			throw new IllegalArgumentException("::: Tipo de dato no soportado");
		}
	}

	/**
	 * Metodo que permite asignar el valor del extrafield en un tipo
	 * proporcionado. Dependiendo del tipo que tenga la variable, se asignará de
	 * la forma adecuada
	 * 
	 * @param value
	 *            Valor que será asignado al extrafield
	 * @throws IllegalArgumentException
	 *             Si el tipo T no es soportado
	 */
	public void setValue(Object value) {
		if (value instanceof String && metadata.getType() == PersistentType.BOOLEAN) {
			boolean valueBoolean = BooleanUtils.toBoolean((String)value);
			this.setBooleanValue(valueBoolean);
		} else if (value instanceof Boolean && metadata.getType() == PersistentType.BOOLEAN) {
			this.setBooleanValue((Boolean)value);
		} else if (value instanceof Long && metadata.getType() == PersistentType.LONG) {
			this.setLongValue((Long) value);
		} else if (value instanceof Double && metadata.getType() == PersistentType.DOUBLE) {
			this.setDoubleValue((Double) value);
		} else if (value instanceof String && metadata.getType() == PersistentType.STRING) {
			this.setStringValue((String) value);
		} else if (value instanceof String && metadata.getType() == PersistentType.TEXT) {
			this.setTextValue((String) value);
		} else if (value instanceof Date && metadata.getType() == PersistentType.DATE) {
			this.setDateValue((Date) value);
		} else if (value instanceof Calendar && metadata.getType() == PersistentType.DATE) {
			this.setDateValue(((Calendar) value).getTime());
		} else if (value instanceof byte[] && metadata.getType() == PersistentType.FILE) {
			this.setFileValue((byte[]) value);
		} else if (value instanceof DataItemDTO && metadata.getType() == PersistentType.DATA_ITEM) {
			this.setDataItemValue((DataItemDTO) value);
		} else if (value == null) {
			this.setDateValue(null);
			this.setFileValue(null);
			this.setStringValue(null);
			this.setTextValue(null);
		} else {
			throw new IllegalArgumentException("::: Tipo de dato no soportado");
		}
	}

	/**
	 * Retorna una cadena de asteriscos que seran mostrados en las vistas
	 * 
	 * @return
	 */
	public String getPasswordNice() {
		StringBuilder passwordNice = new StringBuilder();
		if (stringValue != null) {
			for (int i = 0; i < stringValue.length(); i++) {
				passwordNice.append("*");
			}
			return passwordNice.toString();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.zero.hcm.dto.EntityDTO#toString()
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder(super.toString());
		s.append("[valor=" + this.getValue() + "]\n");
		return s.toString();
	}
}
