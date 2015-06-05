/**
 * 
 */
package co.zero.bsc.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import co.zero.bsc.dto.BscGoalDTO;
import co.zero.bsc.dto.BscGoalTrackingPartialDTO;
import co.zero.common.constant.GenericConstants;
import co.zero.common.exception.ZeroException;

/**
 * Represents a Tree of Objects of BscGoal. The Tree is represented as
 * a single rootElement which points to a List<Node<T>> of children. There is
 * no restriction on the number of children that a particular node may have.
 * This Tree provides a method to serialize the Tree into a List by doing a
 * pre-order traversal. It has several methods to allow easy updation of Nodes
 * in the Tree.
 */
public class BscGoalTree{
	private BscGoalDTO root;
	private List<BscGoalTree> children = new ArrayList<BscGoalTree>();
	
	/**
	 * Constructor por defecto del arbol
	 */
	public BscGoalTree(){
	}
	
	/**
	 * Contructor que permite iniciar el arbol con un nodo raiz
	 * @param root
	 */
	public BscGoalTree(BscGoalDTO root){
		setRoot(root);
	}
	
	/**
	 * Método que permite determinar si el objetivo pertenece a este arbol.
	 * Esto quiere decir que la posición del objetivo inicie con la 
	 * posición del nodo padre del árbol
	 * @param node Objeto que se desea agregar al arbol
	 * @return True si el nodo pertenece a la misma "Familia", False de lo contrario
	 */
	public boolean isNodeOfFamily(BscGoalDTO node){
		return isPositionChild(node.getPosition(), this.getRoot().getPosition());
	}
	
	/**
	 * Método que permite agregar un nodo al arbol de objetivos
	 * @param node Objeto que se desea agregar al arbol
	 */
	public void addNode(BscGoalDTO node){
		addNode(this, node);
	}
	
	/**
	 * Método que permite calcular el valor real de aporte de este arbol al nodo root
	 * ValorRealArbol = aporteAlPadre(root) * (∑ valorReal(hijo(i)) * aporteAlPadre(hijo(i)))
	 * @param trackingMap Mapa con la información de seguimiento de cada objetivo
	 * @return El valor real alcanzado por el arbol
	 * @throws ZeroException 
	 */
	public double evaluateRealValue(Map<BscGoalDTO, BscGoalTrackingPartialDTO> trackingMap) throws ZeroException{
		return evaluateRealValue(this, trackingMap);
	}
	
	/**
	 * Método que permite calcular el valor acumulado de aporte de este arbol al nodo root,
	 * cuando el valor acumulado se encuentra en el {@link BscGoalTrackingPartialDTO} final
	 * ValorAcumuladoArbol = aporteAlPadre(root) * (∑ valorAcumulado(hijo(i)) * aporteAlPadre(hijo(i)))
	 * @param trackingMap Mapa con la información de seguimiento de cada objetivo
	 * @return El valor real alcanzado por el arbol
	 * @throws ZeroException 
	 */
	public double evaluateAccumulatedValue(Map<BscGoalDTO, List<BscGoalTrackingPartialDTO>> reportStructure) throws ZeroException{
		if(this.hasChildren()){
			return evaluateAccumulatedValue(this, reportStructure);
		}else{
			return (evaluateAccumulatedValue(this, reportStructure) * this.getRoot().getContributeWeight())/100;
		}
	}
	
	/**
	 * Método que permite calcular el valor real de aporte de este arbol al nodo root
	 * de forma recursiva.
	 * ValorRealArbol = aporteAlPadre(root) * (∑ valorReal(hijo(i)) * aporteAlPadre(hijo(i)))
	 * @param tree Arbol del que se desea obtener del valor real de aporte al padre
	 * @param trackingMap Mapa con la información de seguimiento de cada objetivo
	 * @return El valor real alcanzado por el árbol
	 * @throws ZeroException 
	 */
	private double evaluateRealValue(BscGoalTree tree, Map<BscGoalDTO, BscGoalTrackingPartialDTO> trackingMap) throws ZeroException{
		BscGoalTrackingPartialDTO tracking;
		BscGoalDTO goal = tree.getRoot();
		double score = 0;
		
		if(tree.hasChildren()){
			for(BscGoalTree child : tree.getChildren()){
				score += evaluateRealValue(child, trackingMap);
			}
			
			return (score * goal.getContributeWeight())/100; 
		}else{
			if((tracking = trackingMap.get(goal)) == null){
				return 0;
			}else{
				return (tracking.getReachPercent() * goal.getContributeWeight())/100;
			}
		}
	}
	
	/**
	 * Método que permite calcular de forma recursiva el valor acumulado del arbol, según
	 * el tipo de formula configurado. NOTA: El valor acumulado se calcula con base en las hojas del 
	 * arbol, los nodos intermedios sólo ponderan el resultado.
	 * @param tree Arbol que contiene los valores de forma jerarquica
	 * @param detailStructure Mapa que relaciona los objetivos con los tracking registrados
	 * @return
	 * @throws ZeroException
	 */
	private double evaluateAccumulatedValue(BscGoalTree tree, Map<BscGoalDTO, 
			List<BscGoalTrackingPartialDTO>> detailStructure) throws ZeroException{
		BscGoalDTO goal= tree.getRoot();
		BscGoalTrackingPartialDTO trackingFinal = getLastTracking(detailStructure.get(goal));
		double score = 0, realValue = 0, expectedValue = 0;
		
		if(tree.hasChildren()){
			for(BscGoalTree child : tree.getChildren()){
				score += (evaluateAccumulatedValue(child, detailStructure) * child.getRoot().getContributeWeight())/100;
			}
		}else{
			if(trackingFinal != null && trackingFinal.isNotApply()){
				return score;
			}
			
			if(goal.getMetric().isTotalCalculated()){
				switch(goal.getMetric().getPartialFormulaType()){
				case SUM_REAL_VALUES:
					realValue = calculateAccumulatedByRealValueSum(detailStructure.get(goal), goal);
					break;
				case SUM_COMPLIMENT_PERCENT:
					 realValue = calculateAccumulatedByComplimentPercentSum(detailStructure.get(goal), goal);
					 break;
				case AVERAGE_REAL_VALUES:
					realValue = calculateAccumulatedByRealValuaAvg(detailStructure.get(goal), goal);
					break;
				case AVERAGE_COMPLIMENT_PERCENT:
					realValue = calculateAccumulatedByComplimentPercentAvg(detailStructure.get(goal), goal);
					break;
				case ASSIGNED_BY_LAST_PARTIAL_VALUE:
					realValue = calculateAccumulatedByRealValueAsLastValue(detailStructure.get(goal), goal);
					break;
				case ASSIGNED_BY_LAST_PARTIAL_PERCENT:
					realValue = calculateAccumulatedByComplimentPercentLast(detailStructure.get(goal), goal);
					break;
				}
			}else{
				if(trackingFinal != null){
					if(trackingFinal.getPeriod().getMetricPartial().isExpectedDate()){
						return trackingFinal.getReachPercent();
					}else{
						realValue = trackingFinal.getAccumulatedValue();
					}
				}
			}
			
			if(trackingFinal != null){
				expectedValue = trackingFinal.getPeriod().getMetricPartial().getExpectedAccumulatedValue();
				score = trackingFinal.getPeriod().getMetricPartial().isProportionalDirectly() ? 
						(realValue / expectedValue) * 100 : (expectedValue / realValue) * 100;
				score = Double.isNaN(score) || Double.isInfinite(score)? 0 : score;
			}
		}
		
		return score;
	}
	
	/**
	 * Método que permite calcular la suma de los valores reales de los 
	 * {@link BscGoalTrackingPartialDTO} registragos para un objetivo
	 * @param trackingList Lista con los tracking que se desean analizar
	 * @return Valor acumulado de los trackings
	 * @throws ZeroException
	 */
	private double calculateAccumulatedByRealValueSum(
			List<BscGoalTrackingPartialDTO> trackingList, BscGoalDTO goal){
		double score = 0;
		
		for(BscGoalTrackingPartialDTO tracking : trackingList){
			if(tracking != null){
				score += tracking.getPeriod().getMetricPartial().isExpectedDate() ? 0 : tracking.getRealValue();
			}
		}
		
		return score;
	}
	
	private double calculateAccumulatedByRealValueAsLastValue(
			List<BscGoalTrackingPartialDTO> trackingList, BscGoalDTO goal){
		double score = 0;
		
		for(BscGoalTrackingPartialDTO tracking : trackingList){
			if(tracking != null){
				score = tracking.getPeriod().getMetricPartial().isExpectedDate() ? 0 : tracking.getRealValue();
			}
		}
		
		return score;
	}
	
	/**
	 * Método que permite calcular la suma de los valores de cumplimiento de los 
	 * {@link BscGoalTrackingPartialDTO} registragos para un objetivo
	 * @param trackingList Lista con los tracking que se desean analizar
	 * @return Valor acumulado de los trackings
	 * @throws ZeroException
	 */
	private double calculateAccumulatedByComplimentPercentSum(
			List<BscGoalTrackingPartialDTO> trackingList, BscGoalDTO goal) throws ZeroException{
		double score = 0;
		
		for(BscGoalTrackingPartialDTO tracking : trackingList){
			if(tracking != null){
				score += tracking.getReachPercent();
			}
		}
		
		return score;
	}
	
	private double calculateAccumulatedByComplimentPercentLast(
			List<BscGoalTrackingPartialDTO> trackingList, BscGoalDTO goal) throws ZeroException{
		double score = 0;
		
		for(BscGoalTrackingPartialDTO tracking : trackingList){
			if(tracking != null){
				score = tracking.getReachPercent();
			}
		}
		
		return score;
	}
	
	/**
	 * Método que permite calcular el promedio de los valores reales de los 
	 * {@link BscGoalTrackingPartialDTO} registragos para un objetivo
	 * @param trackingList Lista con los tracking que se desean analizar
	 * @return Valor acumulado de los trackings
	 * @throws ZeroException
	 */
	private double calculateAccumulatedByRealValuaAvg(
			List<BscGoalTrackingPartialDTO> trackingList, BscGoalDTO goal){
		double score = 0;
		
		for(BscGoalTrackingPartialDTO tracking : trackingList){
			if(tracking != null){
				score += tracking.getPeriod().getMetricPartial().isExpectedDate() ? 0 : tracking.getRealValue();
			}
		}
		
		score /= trackingList.size();
		return score;
	}
	
	/**
	 * Método que permite calcular el promedio de los valores de cumplimiento de los 
	 * {@link BscGoalTrackingPartialDTO} registragos para un objetivo
	 * @param trackingList Lista con los tracking que se desean analizar
	 * @return Valor acumulado de los trackings
	 * @throws ZeroException
	 */
	private double calculateAccumulatedByComplimentPercentAvg(
			List<BscGoalTrackingPartialDTO> trackingList, BscGoalDTO goal) throws ZeroException{
		double score = 0;
		
		for(BscGoalTrackingPartialDTO tracking : trackingList){
			if(tracking != null){
				score += tracking.getReachPercent();
			}
		}
		
		score /= trackingList.size();
		return score;
	}
	
	/**
	 * Método que permite determinar si una posición es hija de otra
	 * @param positionChild Posición que se desea analizar
	 * @param positionParent Posible posición padre de la posición analizadas
	 * @return True si positionChild es hija de positionParent
	 */
	public boolean isPositionChild(String positionChild, String positionParent){
		if(positionParent.equals(positionChild) || StringUtils.startsWith(
				positionChild, positionParent + GenericConstants.DOT)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Método que permite agregar un nodo al arbol y permite el llamado
	 * recursivo para buscar la posición adecuada
	 * @param tree Arbol al que se desea agregar el nuevo nodo
	 * @param node Objeto que se desea agregar al arbol
	 */
	private void addNode(BscGoalTree tree, BscGoalDTO node){
		if(tree.getRoot() == null || tree.getRoot().equals(node)){
			tree.setRoot(node);
		}else{
			for(BscGoalTree child : tree.getChildren()){
				if(isPositionChild(node.getPosition(), child.getRoot().getPosition())){
					addNode(child, node);
					return;
				}
			}
			
			//Si no se ha agregado el nodo y el nivel del nuevo nodo es exactamente el nivel
			//del root + 1, es porque es una rama nueva del arbol. De lo contrario se está tratando
			//de agregar un nodo que no tiene padre en el árbol
			if(tree.getRoot().getDeep() + 1 == node.getDeep()){
				tree.getChildren().add(new BscGoalTree(node));	
			}else{
				throw new IllegalArgumentException(String.format("Intentando agregar el objetivo[%s] al root[%s]", 
						node.getPosition(), tree.getRoot().getPosition()));
			}
		}
	}
		
	/**
	 * Método que permite determinar el {@link BscGoalTrackingPartialDTO} más reciente de una lista
	 * @param trackingList Lista con los objetos que se desean analizar
	 * @return El tracking más reciente, null si la lista se encuentra vacia
	 */
	private BscGoalTrackingPartialDTO getLastTracking(List<BscGoalTrackingPartialDTO> trackingList){
		BscGoalTrackingPartialDTO tracking = null;
		
		for(BscGoalTrackingPartialDTO trackingAux : trackingList){
			if(tracking == null || tracking.getPeriod().isBefore(trackingAux.getPeriod())){
				tracking = trackingAux;
			}
		}
		
		return tracking;
	}
	
	/**
	 * Método que permite obtener la raiz del arbol
	 * @return El nodo raiz del arbol
	 */
	public BscGoalDTO getRoot() {
		return root;
	}

	/**
	 * Método que permite modificar la raiz del arbol
	 * @param root El nuevo nodo raiz del arbol
	 */
	public void setRoot(BscGoalDTO root) {
		this.root = root;
	}

	/**
	 * Método que permite obtener los nodos hijos del nodo raiz de este arbol
	 * @return Lista con los arboles hijos del nodo raiz de este arbol
	 */
	public List<BscGoalTree> getChildren() {
		return children;
	}

	/**
	 * Método que permite modificar los hijos del nodo raiz de este arbol
	 * @param children Lista con los nuevos nodos hijos del nodo raiz
	 */
	public void setChildren(List<BscGoalTree> children) {
		this.children = children;
	}
	
	/**
	 * Método que permite determinar si el arbol tiene hijos
	 * @return True si el arbol tiene hijos, false de lo contrario
	 */
	public boolean hasChildren(){
		return this.children != null && this.children.size() > 0 ? true : false;
	}
}