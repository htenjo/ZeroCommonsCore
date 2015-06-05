//=======================================================================
// ARCHIVO BscExpressionBuilder.java
// FECHA CREACIÓN: 11/03/2011
//=======================================================================
package co.zero.bsc.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import co.zero.common.constant.GenericConstants;

/**
 * Clase que permite manajar los múltiples árboles de expresiones
 * generados por el arbol de objetivos en BSC
 * @author Hernán Tenjo
 * @version 1.0
 */
public class BscExpressionBuilder{
	private static final String TREE_SEPARATOR = GenericConstants.PIPE;
	private List<String> wood = new ArrayList<String>();
	private BscExpression expression;
	
	public BscExpressionBuilder(){
		expression = new BscExpression();
	}
	
	/**
	 * Metodo que permite asignar una expresion al builder
	 * @param woodExpression Expresion que contiene el bosque a procesar
	 */
	public void setExpression(String woodExpression){
		String[] trees = StringUtils.split(woodExpression, TREE_SEPARATOR);
	
		if(trees != null){
			for(String tree : trees){
				wood.add(tree);
			}
		}
	}
	
	public void setExpressions(List<String> nodeList){		
		for(String node : nodeList){
			addNode(node);
		}
	}
	
	/**
	 * Metodo que permite agregar un nuevo nodo al bosque
	 * @param node Expresion que se desea agregar
	 * @return La expresion bosque conteniendo al nuevo nodo
	 */
	public String addNode(String node){
		String modifiedTree = null;
		int treeIndex = -1;
		
		for(int i=0; i < wood.size(); i++){
			modifiedTree = wood.get(i);
			
			if(expression.isParent(modifiedTree, node)){
				modifiedTree = expression.addNode(modifiedTree, node);
				treeIndex = i;
				break;
			}
		}
		
		if(treeIndex == -1 && !StringUtils.isBlank(node)){
			wood.add(node);	
		}else{
			wood.set(treeIndex, modifiedTree);	
		}
		
		return StringUtils.join(wood, TREE_SEPARATOR);
	}
	
//	/**
//	 * Metodo que permite mover un nodo en el bosque de expressiones
//	 * @param node El nodo que se desea mover
//	 * @param parendId Identificador del nuevo padre del nodo
//	 * @return Cadena con la expresión que representa al nodo
//	 * @throws HcmException
//	 */
//	public String moveNodeInWood(String nodeId, String newParentId) throws HcmException{
//		String oldTreeParent = null, newTreeParent = null;
//		String node = findNode(nodeId);
//		String currentParentId = expression.getParentId(node);
//		String newWood;
//		
//		//Se verifica si el destino es el mismo bosque
//		validateAsFamily(currentParentId, newParentId);
//		
//		for(int i=0; i < wood.size(); i++){
//			newTreeParent = wood.get(i);
//			
//			if(expression.isParentByNodeId(newTreeParent, newParentId)){
//				node = expression.changeNodeId(node, newId);
//				expression.addNode(newTreeParent, node);
//				break;
//			}
//		}
//		
//		if(StringUtils.isEmpty(newTreeParent)){
//			throw new IllegalArgumentException("El nodo padre no existe");
//		}else{
//			
//		}
//	}
	
//	private void validateAsFamily(String nodeId1, String nodeId2){
//		if(!expression.areFamily(nodeId1, nodeId2)){
//			throw new IllegalArgumentException("::: El movimiento de nodos sólo es posible hacia" +
//			" nodos del mismo bosque (Strategy)");
//		}
//	}
	
	/**
	 * Metodo que permite modificar el porcentaje de contribución del hijo 
	 * con el objetivo del padre
	 * @param nodeId Identificador del nodo del objetivo
	 * @param percent Porcentaje de colaboración del hijo al padre
	 * @return La expresión con la modificación respectiva
	 */
	public String editNodeContributePercent(String nodeId, double percent){
		return editAttributeNode(nodeId, Double.toString(percent), 0);
	}

	/**
	 * Metodo que permite cambiar el estado de un nodo entre carculado o asignado
	 * @param node Identificador del nodo del objetivo
	 * @param calculated Determina si el nodo será calculado o asignado
	 * @return La expresión con la modificación respectiva
	 */
	public String editNodeIsCalculated(String node, boolean calculated){
		return editAttributeNode(node, Boolean.toString(calculated), 1);
	}
	
	/**
	 * Metodo que permite modificar un atributo de un nodo 
	 * @param nodeId Cadena con la expresion que representa al nodo
	 * @param value Valor del atributo que se desea modificar
	 * @param index Indice del objetivo que se desea modificar
	 * @return El bosque con la expresión modificada
	 */
	private String editAttributeNode(String nodeId, String value, int index){
		String modifiedTree = null;
		int treeIndex = -1;
		
		for(int i=0; i < wood.size(); i++){
			modifiedTree = wood.get(i);
			
			if(expression.isNodeIdFromTree(modifiedTree, nodeId) ){
				modifiedTree = expression.changeAttribute(modifiedTree, nodeId, index, value);
				treeIndex = i;
				break;
			}
		}
		
		if(treeIndex != -1){
			wood.set(treeIndex, modifiedTree);
		}
		
		return StringUtils.join(wood, TREE_SEPARATOR);
	}
	
	/**
	 * Metodo que permite eliminar un nodo del bosque de expresiones
	 * @param nodeId Identificador del nodo que se desea eliminar
	 * @return El bosque sin el nodo dado
	 */
	public String deleteNode(String nodeId){
		String modifiedTree = null;
		int treeIndex = -1;
		
		for(int i=0; i < wood.size(); i++){
			modifiedTree = wood.get(i);
			
			if(expression.isNodeIdFromTree(modifiedTree, nodeId)){
				modifiedTree = expression.deleteNode(modifiedTree, nodeId);
				treeIndex = i;
				break;
			}
		}
		
		if(treeIndex != -1){
			wood.set(treeIndex, modifiedTree);
		}
		
		return StringUtils.join(wood, TREE_SEPARATOR);
	}
	
	/**
	 * Método que permite buscar un nodo en el bosque de expresiones
	 * @param nodeId Identificador del nodo que se desea obtener
	 * @return Cadena con la expresion del nodo si existe, null de lo contrario
	 */
	public String findNode(String nodeId){
		String modifiedTree;
		
		for(int i=0; i < wood.size(); i++){
			modifiedTree = wood.get(i);
			
			if(expression.isNodeIdFromTree(modifiedTree, nodeId)){
				return expression.getNode(modifiedTree, nodeId);
			}
		}
		
		return null;
	}
	
	/**
	 * Metodo que permite construir un nuevo nodo
	 * @param nodeId Identificador del nuevo nodo
	 * @param attributes Valores de los atributos del nuevo nodo
	 * @param value Valor real asignado al nodo
	 * @return Cadena que representa al nodo
	 */
	public String buildNode(String nodeId, String[] attributes, double value){
		return expression.buildNode(nodeId, attributes, value);
	}
	
	/**
	 * Método que permite evaluar todos los arboles del bosque, y sacar
	 * un promedio de los valores de todos los árboles.
	 * @return Valor asignado al bosque
	 */
	public double evaluateWood(){
		double totalValue = 0;
		String nodeId;
		
		for(String tree : wood){
			nodeId = expression.getId(tree);
			totalValue += expression.evaluateNode(tree, nodeId);
		}
		
		return wood.size() == 0 ? 0 : totalValue / wood.size();
	}
	
	public double evaluateNode(String nodeId){
		String node = findNode(nodeId);
		return expression.evaluateNode(node, nodeId);
	}
	
	public List<String> getChildren(String node){
		return expression.getChildren(node);
	}
	
	public double getAssignedValue(String node){
		return expression.getAssignedValue(node);
	}
}