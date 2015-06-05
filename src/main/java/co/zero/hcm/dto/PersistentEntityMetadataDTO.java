//=======================================================================
// ARCHIVO PersistentEntityMetadataDTO.java
// FECHA CREACIÓN: Sep 25, 2009
//=======================================================================
package co.zero.hcm.dto;

import co.zero.common.dto.EntityDTO;

/**
 * Bean que contiene los atributos requeridos en la vista 
 * de un {@link PersistentEntityMetadataDTO}
 * @author Hernán Tenjo
 * @version 1.0
 */
public class PersistentEntityMetadataDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;	
	//Nombre de la entidad
	private String name;
	//En caso de ser requerido, es el label para visualizar el nombre de la entidad 
	private String niceName;
	//Breve descripción de la funcionalidad de la entidad
	private String description;
	//Clase que representa a la entidad persistente
	private String clazz;
	//Determina si la entidad debe ser configurada para todas las compañias
	private boolean required;
	//Determina si la entidad tiene relaciones significativas diferentes a la compañía
	private boolean related;
	//Determina si la entidad tiene informacion basica asociada
	private boolean basicInformation;
	//Determina si pueden existir varias entidades asociadas a este PEM (Como los empleados)
	private boolean dynamic;
	
	/**
	 * Metodo que permite obtener el nombre de la entidad
	 * @return name El nombre asociado a la entidad
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Metodo que permite actualizar el nombre de la entidad 
	 * @param name El nuevo nombre de la entidad
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Metodo que permite obtener el label de la entidad
	 * @return niceName El label de la entidad
	 */
	public String getNiceName() {
		return niceName;
	}
	
	/**
	 * Metodo que permite actualizar el label de la entidad 
	 * @param niceName El nuevo nombre que será visualizado
	 */
	public void setNiceName(String niceName) {
		this.niceName = niceName;
	}
	
	/**
	 * Metodo que permite obtener la descripcion 
	 * de la funcionalidad de la entidad
	 * @return La descripción que tiene asociada la entidad
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Metodo que permite actualizar la descripción de la entidad
	 * @param description Una nueva descripción que será relacionada 
	 * a la entidad
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Metodo que permite obtener de nombre de la clase  
	 * que representa a la entidad persistente
	 * @return Nombre de la clase
	 */
	public String getClazz() {
		return clazz;
	}

	/**
	 * Metodo que permite modificar el nombre de la clase
	 * que representa a la entidad persistente 
	 * @param clazz El nombre de la nueva clase
	 */
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	/**
	 * Determina si la entidad es requerida para todas las compañías
	 * @return True si la entidad es requerida, false de lo contrario
	 */
	public boolean isRequired(){
		return required;
	}

	/**
	 * Metodo que permite modificar el requerimiento para todas las compañías
	 * @param required True si la entidad es requerida para todas las compañías
	 *  False de lo contrario
	 */
	public void setRequired(boolean required) {
		this.required = required;
	}
	
	/**
	 * Determina si la entidad tiene relaciones significativas
	 * @return True si la entidad tienen relaciones significativas, false de lo contrario 
	 */
	public boolean isRelated(){
		return related;
	}

	/**
	 * Permite cambiar el flag que determina si la entidad tiene relaciones significativas
	 * @param related True si se quiere etiquetar a la entidad con relaciones, false de lo contrario
	 */
	public void setRelated(boolean related) {
		this.related = related;
	}	
	
	/**
	 * Determina si la tiene infromacion basica asociada
	 * @return True si la entidad tiene informacion basica
	 */
	public boolean isBasicInformation() {
		return basicInformation;
	}

	/**
	 * Metodo que permite modificar si la entidad tiene informacion basica o no
	 * @param basicInformation true si tiene informacion requerida 
	 * Ofalse si no la tiene
	 */
	public void setBasicInformation(boolean basicInformation) {
		this.basicInformation = basicInformation;
	}
	
	/**
	 * Método que determina si se podrán tener múltiples entidades relacionadas, es decir, p.e en la creación
	 * de un empleado, se pueden ingresar varios familiares para el mismo empleado mientras que sólo
	 * puede ingresar una vez la información de 
	 * @return True si se pueden relacionar múltiples entidades, false de lo contrario
	 */
	public boolean isDynamic() {
		return dynamic;
	}

	/**
	 * Método que modifica el atributo dynamic del PEM
	 * @param dynamic True si se desea que el PEM sea dinámico, False de lo contrario
	 */
	public void setDynamic(boolean dynamic) {
		this.dynamic = dynamic;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder text = new StringBuilder(super.toString());
		text.append("[Name: " + this.name);
		text.append("][NiceName: " + this.niceName);
		text.append("][Description: " + this.description + "]");
		return text.toString();
	}
}