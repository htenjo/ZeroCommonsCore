//=======================================================================
// ARCHIVO EntityDTO.java
// FECHA CREACIÓN: Sep 25, 2009
//=======================================================================
package co.zero.common.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Interface que deben extender todos los DTOs de la aplicación
 * o los EntityDTO especializados requeridos por cada módulo
 * @author Hernán Tenjo
 * @version 1.0
 */
public abstract class EntityDTO implements Serializable{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Identificador unico de la entidad a la que representa el DTO
	protected long id;
	//Fecha en la que se creo el registro 
	protected Date createdDate;
	//Ultima fecha de modificación del registro
	protected Date lastUpdatedDate;

	/**
	 * Permite obtener el identificador único de la entidad
	 * @return el id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Modifica el identificador unico de la entidad
	 * @param id El nuevo identificador de la entidad
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Método que permite obtener la fecha de creación de la entidad si la
	 * información se encuentra disponible
	 * @return La fecha de creación de la entidad si la fecha se encuentra disponible,
	 * null de lo contrario
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Método que permite asignar la fecha de creación de la entidad. La utilización de 
	 * este método no afectará el valor de la entidad persistida
	 * @param createdDate La nueva fecha de creación de la entidad
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	/**
	 * Método que permite obtener la fecha de la última modificación de la entidad si la
	 * información se encuentra disponible
	 * @return La fecha de modificación de la entidad si la fecha se encuentra disponible,
	 * null de lo contrario
	 */
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	/**
	 * Método que permite asignar la fecha de modificación de la entidad. La utilización de
	 * este método no afectará el valor de la entidad persistida
	 * @param lastUpdatedDate La nueva fecha de modificación de la entidad
	 */
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		//Se garantiza que no se hagan comparaciones nulas
		if(obj == null){
			return false;
		}
		//Se garantiza la relacion reflexiva
		if(this == obj){
			 return true;
		}
		//Se garantiza que los dos objetos si sean de la misma clase
		//el instance of solo garantiza que pertenezcan a la misma familia
		if(this.getClass() != obj.getClass()){
			return false;
		}
				
		//Si lo anterior no se cumple se puede pasar a comparar las entidades
		//que contienen el id, atributo diferenciador entre entidades
		return this.getId() == this.getClass().cast(obj).getId();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return (int)this.getId()*17*this.getClass().getName().length();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("::: %s [id=%s]", this.getClass().getSimpleName(), this.id);
	}
	
	/**
	 * Método que permite determinar si el DTO corresponde con una nueva entidad
	 * @return True si es una nueva entidad, false de lo contrario
	 */
	public boolean isNew(){
		return getId() == 0;
	}
}