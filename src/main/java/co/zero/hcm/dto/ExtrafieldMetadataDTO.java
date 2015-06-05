//=======================================================================
// ARCHIVO ExtrafieldMetadata.java
// FECHA CREACIÓN: Oct 5, 2009
//=======================================================================
package co.zero.hcm.dto;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.PersistentType;

/**
 * Bean que contiene la información requerida por la vista para 
 * la metadata de cualquier campo adicional de una entidad
 * @author Hernán Tenjo
 * @version 1.0
 */
public class ExtrafieldMetadataDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Nombre unico del campo por entidad
	private String fieldName;
	//Nombre para mostrar del campo
	private String fieldNiceName;
	//Tipo de dato que guarda el extrafield
	private PersistentType type;
	//Determina cuando el extrafield es requerido para el cliente
	private boolean required;
	//Permite relacionar la metadata del extrafield con una entidad	
	private EntityMetadataDTO entityMetadata;
	
	//Indica si el extrafield ha sido seleccionado para agregarlo como parte de un filtro
	private boolean selected;
	
	/**
	 * Permite obtener el nombre del extrafield, el cual 
	 * es único por entidad para una compañia
	 * @return el nombre del extrafield
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * Modifica el nombre del extrafield. No es aconsejable
	 * realizar esto desde un módulo diferente de HCM
	 * ya que es el único que tiene la lógica necesaria para 
	 * este proceso
	 * @param fieldName El nuevo nombre del campo
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * Permite obtener el nombre para mostrar del extrafield
	 * Este nombre es configurado segun la preferencia del cliente
	 * @return el nombre destinado para la vista. En desarrollos futuros
	 * este campo podría tener el key de los mensajes internacionalizados
	 * para los campos más comunes
	 */
	public String getFieldNiceName() {
		return fieldNiceName;
	}

	/**
	 * Permite modificar el nombre destinado para la vista
	 * @param fieldNiceName El nuevo nombre del extrafield
	 */
	public void setFieldNiceName(String fieldNiceName) {
		this.fieldNiceName = fieldNiceName;
	}

	/**
	 * Permite obetner el tipo persistente que tiene el extrafiel
	 * @return El {@link PersistentType} asociado al extrafield
	 */
	public PersistentType getType() {
		return type;
	}

	/**
	 * Permite modificar el tipo persistente que tiene el extrafield
	 * @param type El nuevo {@link PersistentType} que tendrá
	 */
	public void setType(PersistentType type) {
		this.type = type;
	}
	
	/**
	 * Metodo que permite determinar si el extrafield
	 * es requerido para el cliente
	 * @return true si el campo es requerido, false de lo contrario
	 */
	public boolean isRequired() {
		return required;
	}
	
	/**
	 * Metodo que permite modificar la restriccion de requerido
	 * a un extrafield, según las necesidades del cliente
	 * @param required Valor que determina el requerimiento del campo
	 */
	public void setRequired(boolean required) {
		this.required = required;
	}

	/**
	 * Metodo que permite obtener la metadata de la entidad con la 
	 * que la metadata del extrafield se encuentra relacionada
	 * @return La metadata de la entidad
	 */
	public EntityMetadataDTO getEntityMetadata() {
		return entityMetadata;
	}

	/**
	 * Metodo que permite modificar la metadata de la entidad 
	 * @param entityMetadata La nueva metadata de la entidad relacionada
	 */
	public void setEntityMetadata(EntityMetadataDTO entityMetadata) {
		this.entityMetadata = entityMetadata;
	}

	/**
	 * Metodo que permite determinar si este extrafield fue elegido
	 * para agregar al filtro
	 * @return
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * Metodo que setea la propiedad que determina si el extrafield se 
	 * va a agreagar a un filtro
	 * @param selected
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	/*
	 * (non-Javadoc)
	 * @see co.zero.hcm.dto.EntityDTO#toString()
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder(super.toString());
		s.append("[fieldName="+this.getFieldName()+"]");
		s.append("[fieldNiceName="+this.getFieldNiceName()+"]");
		s.append("[type="+this.getType()+"]");
		s.append("[required="+this.isRequired()+"]");
		return s.toString();
	}
}

