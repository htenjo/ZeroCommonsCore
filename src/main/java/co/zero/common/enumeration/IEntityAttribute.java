//=======================================================================
// ARCHIVO IEntityAttribute.java
// FECHA CREACIÓN: 2012/09/03
//=======================================================================
package co.zero.common.enumeration;

/**
 * Interfaz que define el comportamiento general de las enumeración que reunirán
 * los atributos fijos de las entidades, para permitirles un tratamiento dinámico
 * @author Hernán Tenjo
 * @version 1.0
 */
public interface IEntityAttribute {
	/**
	 * Método que obtiene el nombre de la entidad (DTO) que se está trabajando
	 * @return Nombre de la entidad a la que pertenecen los atributos
	 */
	public abstract String getEntityName();
	
	/**
	 * Método que obtiene el nombre del atributo de la entidad que se está trabajando
	 * @return Nombre del atribuo que se está manejando para la entidad
	 */
	public abstract String getAttributeName();
	
	/**
	 * Método que obtiene el nombre de la entidad sin la jerarquía de paquetes
	 * @return Nombre de la entidad a la que pertenecen los atributos
	 */
	public abstract String getEntitySimpleName();
	
	/**
	 * Método que obtiene la clase de la entidad a la que pertenece el atributo
	 * @return Clase de la entidad a la que pertenece el atributo
	 */
	public abstract Class<?> getEntity();
	
	/**
	 * Método que determina si el atributo es requerido
	 * @return True si el atributo es requerido, False de lo contrario
	 */
	public abstract boolean isRequired();
	
	/**
	 * Método que obtiene la prioridad de aparición del atributo, siendo 1 el más importante.
	 * @return Número que determina la prioridad de aparición del 
	 */
	public abstract int getPriority();
	
	/**
	 * Método que obtiene el indice que identifica de forma única a cada atributo
	 * @return Indice del atributo que se está trabajando
	 */
	public abstract int getIndex();
	
	/**
	 * Método que obtiene el atributo que corresponde al indice dado
	 * @param index Indice del atributo que se desea obtener
	 * @return Atributo correspondiente al indice dado
	 */
	public abstract IEntityAttribute getByIndex(int index);
	
	public abstract boolean hasOptions();
	
	public abstract Object[] getOptions();
}
