/**
 * 
 */
package co.zero.bsc.datastructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import co.zero.bsc.dto.BscGoalDTO;
import co.zero.bsc.dto.BscGoalTrackingPartialDTO;
import co.zero.common.exception.ZeroException;

/**
 * Clase que permite agrupar un conjunto de arboles para formar
 * un bosque de {@link BscGoalDTO}
 * @author hernan
 *
 */
public class BscGoalWood {
	private List<BscGoalTree> trees = new ArrayList<BscGoalTree>();
	
	/**
	 * Método que permite agregar un nodo al bosque
	 * @param goal Objeto que se desea agregar al bosque como un nodo
	 */
	public void insert(BscGoalDTO goal){
		//Se verifica si el nodo pertenece a algún arbol existente
		for(BscGoalTree tree : trees){
			if(tree.isNodeOfFamily(goal)){
				tree.addNode(goal);
				return;
			}
		}
		
		//Si el nodo no fue agregado en ningún árbol, se crea un nuevo arbol en el bosque
		trees.add(new BscGoalTree(goal));
	}
	
	/**
	 * Método que permite agregar una colección de objetivos al bosque
	 * @param goals Colección con los objetivos que se desean agregar
	 */
	public void insert(Collection<BscGoalDTO> goals){
		for(BscGoalDTO goal : goals){
			this.insert(goal);
		}
	}
	
	/**
	 * Método que permite realizar la evaluación jerárquica de un arbol de objetivos
	 * @param trackingMap Mapa que contiene el valor de seguimiento de cada uno de los objetivos
	 * @return El valor real obtenido por todo el arbol
	 * @throws ZeroException 
	 */
	public double evaluateRealValue(Map<BscGoalDTO, BscGoalTrackingPartialDTO> trackingMap) throws ZeroException{
		double score = 0;
		
		for(BscGoalTree tree : trees){
			score += tree.evaluateRealValue(trackingMap);
		}
		
		return score;
	}
	
	public double evaluateAccumulatedValue(Map<BscGoalDTO, 
			List<BscGoalTrackingPartialDTO>> reportStructure) throws ZeroException{
		double score = 0;
		
		for(BscGoalTree tree : trees){
			score += (tree.evaluateAccumulatedValue(reportStructure) * tree.getRoot().getContributeWeight()) / 100;
		}
		
		return score;
	}
}