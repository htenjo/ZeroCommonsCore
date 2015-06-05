//=======================================================================
// ARCHIVO BscGoalDTO.java
// FECHA CREACIÓN: 23/12/2010
//=======================================================================
package co.zero.bsc.dto;

import org.apache.commons.lang.StringUtils;

import co.zero.common.constant.GenericConstants;
import co.zero.common.dto.EntityDTO;
import co.zero.hcm.dto.JobDTO;

/**
 * Clase que representa a los objetivos que pueden ser asignados
 * a cada uno de los cargos de la empresa en forma de cascada
 * @author Hernán Tenjo
 * @version 1.0
 */
public class BscGoalDTO extends EntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Nombre representativo del objetivo que se desea alcanzar
	private String name;
	//Breve descripción de lo que se desea realizar con el objetivo
	private String description;
	//Cargo que creó el objetivo (Para poder determinar los permisos de eliminación)
	private JobDTO owner;
	//Metrica con la que será evaluado el objetivo
	private BscMetricDTO metric;
	//Variable auxiliar que permite determinar si el objetivo ha sido terminado
	//para la relacion Job/Goal asociada
	private boolean finalized;
	//Padre del objetivo si este existe
	private BscGoalDTO parent;
	//Ponderación de la colaboración del objetivo sobre el padre
	private double contributeWeight;
	//Atributo util para establecer el order del arbol padre/hijo
	private String position;
		
	/**
	 * Metodo que permite obtener el nombre del objetivo
	 * @return El nombre asociado al objetivo
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo que permite modificar el nombre del objetivo
	 * @param name La nueva cadena que será usada como nombre del objetivo
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Metodo que permite obtener la descripción del objetivo
	 * @return La descripción configurada para el objetivo
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Metodo que permite modificar la descripción del objetivo
	 * @param description El nuevo texto descriptivo del objetivo
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Metodo que permite obtener el cargo de la persona que creo el objetivo
	 * @return El cargo que tiene todos los provilegios sobre el objetivo
	 */
	public JobDTO getOwner() {
		return owner;
	}

	/**
	 * Metodo que permite modificar el cargo que tiene 
	 * todos los privilegios sobre el objetivo
	 * @param owner El nuevo cargo que tendrá todos los privilegios sobre el objetivo
	 */
	public void setOwner(JobDTO owner){
		this.owner = owner;
	}

	/**
	 * Metodo que permite obtener la metrica con la que será evaluado el objetivo
	 * @return La métrica configurada para el objetivo
	 */
	public BscMetricDTO getMetric(){
		return metric;
	}

	/**
	 * Metodo que permite modificar la metrica con la que será evaluado al objetivo
	 * @param metric La nueva metrica con la que será evaluado el objetivo
	 */
	public void setMetric(BscMetricDTO metric){
		this.metric = metric;
	}
	
	/**
	 * Metodo que permite determinar si el objetivo ha sido finalizado
	 * @return TRUE si el objetivo ha sido finalizado, FALSE de lo contrario
	 */
	public boolean isFinalized() {
		return finalized;
	}

	/**
	 * Metodo que permite modificar el estado finalizado del objetivo
	 * @param finalized El nuevo estado finalizado del objetivo (True = finalizado)
	 */
	public void setFinalized(boolean finished) {
		this.finalized = finished;
	}
	
	/**
	 * Metodo que permite obtener el porcentaje en el que la labor
	 * del hijo contribuye a la labor del padre
	 * @return Porcentaje de colaboración del hijo sobre el padre
	 */
	public double getContributeWeight() {
		return contributeWeight;
	}

	/**
	 * Método que permite modificar el porcentaje en el que la labor
	 * del hijo contribuye a la labor del padre
	 * @param contributeWeight El nuevo porcentaje de colaboración
	 */
	public void setContributeWeight(double contributeWeight){
		this.contributeWeight = contributeWeight;
	}

	/**
	 * Metodo que permite obtener el padre del objetivo
	 * @return El objetivo padre configurado para este objetivo
	 */
	public BscGoalDTO getParent() {
		return parent;
	}

	/**
	 * Metodo que permite modificar el padrel del objetivo
	 * @param parent El nuevo padre del objetivo
	 */
	public void setParent(BscGoalDTO parent) {
		this.parent = parent;
	}
	
	/**
	 * Metodo que permite obtener la posición del objetivo en el arbol
	 * @return La posicion configurada para el arbol
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * Metodo que permite modificar la posicion del objetivo en el arbol
	 * @param position La nueva posición del objetivo en el arbol
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
	 * Método que permite determinar la profundidad del nodo del objetivo, en el 
	 * arbol de expresiones
	 * @return La profundidad del nodo del objetivo
	 */
	public int getDeep(){
		if(StringUtils.isBlank(position)){
			return -1;
		}else{
			return StringUtils.split(position, GenericConstants.DOT).length;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.zero.common.dto.EntityDTO#toString()
	 */
	@Override
	public String toString() {
		StringBuilder text = new StringBuilder(super.toString());
		long ownerId = owner == null ? 0 : owner.getId();
		long metricId = metric == null ? 0 : metric.getId();
		long parentId = parent == null ? 0 : parent.getId();
				
		text.append(" [name = " + name + "]");
		text.append(" [description = " + description + "]");
		text.append(" [finalized = " + finalized + "]");
		text.append(" [contributeWeight = " + contributeWeight + "]");
		text.append(" [position = " + position + "]");
		text.append(" [ownerId = " + ownerId + "]");
		text.append(" [metricId = " + metricId + "]");
		text.append(" [parentId = " + parentId + "]");
		return text.toString();
	}
}