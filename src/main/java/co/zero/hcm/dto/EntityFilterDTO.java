package co.zero.hcm.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Contiene los atributos necesarios para armar los filtros dinamicos
 * 
 * @author Youlyn
 *
 */
public class EntityFilterDTO implements Serializable{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Entidad que ha sido agregada al filtro
	private EntityMetadataDTO entityMetadata;
	//Lista de los nodos del filtro, que corresponde un a cada extrafield y campo basico incluido en el filtro
	private List<EntityFilterNodeDTO> nodes;
	
	/**
	 * Agrega un nuevo nodo al filtro
	 * @param node
	 */
	public void addNode(EntityFilterNodeDTO node){
		if(nodes == null){
			nodes = new ArrayList<EntityFilterNodeDTO>();
		}
		if(!nodes.contains(node)){
			nodes.add(node);
		}
	}
	
	/**
	 * Metodo que permite obtener el entityMD que va a ir el en filtro
	 * @return
	 */
	public EntityMetadataDTO getEntityMetadata() {
		return entityMetadata;
	}
	
	/**
	 * Metodo que permite modificar el entityMD que se va a agregar al filtro
	 * @param entityMetadata
	 */
	public void setEntityMetadata(EntityMetadataDTO entityMetadata) {
		this.entityMetadata = entityMetadata;
	}

	/**
	 * Metodo que permite obtener la lista de los nodos que hacen parte del filtro
	 * @return
	 */
	public List<EntityFilterNodeDTO> getNodes() {
		return nodes;
	}

	/**
	 * Metodo que permite modificar la lista de los nodos del filtro
	 * @param nodes
	 */
	public void setNodes(List<EntityFilterNodeDTO> nodes) {
		this.nodes = nodes;
	}
	
}