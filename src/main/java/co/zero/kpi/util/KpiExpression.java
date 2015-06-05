//=======================================================================
// ARCHIVO BscExpression.java
// FECHA CREACIÓN: 9/03/2011
//=======================================================================
package co.zero.kpi.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import co.zero.common.constant.GenericConstants;

/**
 * Clase que permite manejar las expresiones construidas para el manejo
 * de un único árbol de objetivos en BSC
 * @author Hernán Tenjo
 * @version 1.0
 */
public class KpiExpression {
	//Simbolo de final de tag como caracter (Para recorridos)
	private char END_FLAG = GenericConstants.GREATER_THAN_CHAR;
	//Simbolo de inicio de tag
	private String START_TAG = GenericConstants.LESS_THAN;
	//Simbolo de final de tag
	private String END_TAG = GenericConstants.GREATER_THAN;
	//Simbolo que divide los atributos de un nodo
	private String ATTR_SEPARATOR = GenericConstants.MSG_WILDCARD;
	//Cantidad de atributos que contienen los nodos de la expresion
	private int attributesCount;
	
	/**
	 * Constructor del ExpressionBuilder por defecto
	 */
	public KpiExpression(){
		this.attributesCount = 4;
	}
	
	/**
	 * Constructor del ExpressionBuilder
	 * @param expAttributesCount Cantidad de atributos que tendrá un nodo de la expresion
	 * p.e. En la expresion '<A1>x1#y1#z1#w1#0<A1@><B1>x2#y2#z2#w2#0</B1></A1>' el nodo
	 * con Id 'A1' presenta 4 atributos (x1,y1,z1,w1). Si la expresion se encuentra
	 * bien formada, todos los nodos deberán tener la misma cantidad de atributos.
	 */
	public KpiExpression(int expAttributesCount){
		this.attributesCount = expAttributesCount;
	}
		
	/**
	 * Metodo que permite obtener los valores hijos de una expresion, donde solo se tienen
	 * en cuenta aquellos que sean expresiones (Los numeros son descartados)
	 * @param node Cadena que se desea analizar
	 * @return Lista con las expresiones hijas de la expresion dada
	 */
	public List<String> getChildren(String node){
		String currentId = getId(node);
		String currentStartTag = getStartTag(currentId);
		String currentEndTag = getEndTag(currentId);
		String currentChildSeparator = getChildSeparator(currentId);
		String[] expressionParts = null, currentValueTokens = null;
		List<String> validChildren = new ArrayList<String>();
		
		node = StringUtils.substringBetween(node, currentStartTag, currentEndTag);
		expressionParts = StringUtils.splitByWholeSeparator(node, ATTR_SEPARATOR, attributesCount);
		validateExpressionParts(expressionParts);
		currentValueTokens = StringUtils.splitByWholeSeparator(
				expressionParts[attributesCount-1], currentChildSeparator);
		
		for(String currentToken : currentValueTokens){			
			if(hasValidBoundaries(currentToken)){
				validChildren.add(currentToken);
			}
		}
		
		return validChildren;
	}	
	
	/**
	 * Metodo que permite obtener el identificador del nodo actual 
	 * @param node Cadena que contiene la expression a analizar
	 * @return El identificador del nodo actual
	 */
	public String getId(String node){
		String currentTagId = StringUtils.EMPTY;
		validateExpressionBoundaries(node);
		
		for(int i=1; i < node.length() && node.charAt(i) != END_FLAG; i++){
			currentTagId += node.charAt(i);
		}
			
		return currentTagId;
	}
	
	/**
	 * Metodo que permite verificar que la expresion empiece con < y termine con >
	 * @param expression Cadena que se desea validar
	 */
	private void validateExpressionBoundaries(String expression){
		if(!(expression.startsWith(START_TAG) && expression.endsWith(END_TAG))){
			throw new IllegalArgumentException("::: Expression mal formada [" + expression + "]");
		}
	}
	
	/**
	 * Metodo que permite determinar si la expresion empieza con < y termina con >
	 * @param expression Cadena que se desea verificar
	 * @return True si la cadena cumple las condiciones, false de lo contrario
	 */
	private boolean hasValidBoundaries(String expression){
		if(expression.startsWith(START_TAG) && expression.endsWith(END_TAG)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Metodo que permite determinar si el valor del nodo contiene nodos internos
	 * @param node Cadena con la expresion que se desea validar
	 * @return True si la expresion contiene un valor complejo, false de lo contrario
	 */
	private boolean hasComplexValue(String node){
		List<String> children = getChildren(node);
		return !CollectionUtils.isEmpty(children);
	}
	
	/**
	 * Metodo que permite validar la estructura de las partes de una expresion 
	 * @param expressionParts Las partes de una expresion que se desean validar
	 */
	private void validateExpressionParts(String[] expressionParts){
		if(expressionParts == null || expressionParts.length != attributesCount){
			throw new IllegalArgumentException("::: Partes mal formadas de la expresion " 
					+ Arrays.toString(expressionParts));
		}
	}
	
	/**
	 * Metodo que permite verificar que la relación entre nodos padre/hijo se válida 
	 * @param childId Identificador del nodo hijo
	 * @param parentId Identificador del nodo padre
	 */
	private void validateParentChildRelation(String childId, String parentId){
		if(StringUtils.isEmpty(parentId)){
			throw new IllegalArgumentException("El padre del nodo debe ser un nodo válido");
		}
		
		if(!StringUtils.startsWith(childId, parentId)){
			throw new IllegalArgumentException("El id del nodo hijo debe corresponder con el del padre");
		}
	}
	
	/**
	 * Metodo que permite construir el tag inicial de un nodo dado su id
	 * @param nodeId Identificador del nodo
	 * @return El tag inicial del nodo dado
	 */
	private String getStartTag(String nodeId){
		return START_TAG + nodeId + END_TAG;
	}
	
	/**
	 * Metodo que permite construir el tag final de un nodo dado su id
	 * @param nodeId Identificador del nodo
	 * @return El tag final del nodo dado
	 */
	private String getEndTag(String nodeId){
		return START_TAG + GenericConstants.SLASH + nodeId + END_TAG;
	}
		
	/**
	 * Metodo que permite construir el tag que separa los valores de un nodo
	 * @param nodeId Identificador del nodo
	 * @return El tag que separa los valores del nodo dado
	 */
	private String getChildSeparator(String nodeId){
		return START_TAG + nodeId + GenericConstants.AT + END_TAG;
	}
	
	/**
	 * Metodo que permite obtener un arreglo con los valores de los atributos del nodo
	 * @param node Cadena que contiene la expresion a analizar
	 * @return Arreglo con los atributos del nodo
	 */
	private String[] getAttributes(String node){
		String currentId = getId(node);
		String plainAttributes = StringUtils.substringBetween(node, getStartTag(currentId), getEndTag(currentId));
		return StringUtils.split(plainAttributes, ATTR_SEPARATOR, attributesCount);
	}
	
	/**
	 * Metodo que permite obtener el valor (numérico) asignado al nodo
	 * @param node Cadena que contiene la expresion a analizar
	 * @return El valor real asignado al nodo
	 */
	public double getAssignedValue(String node){
		String currentId = getId(node);
		String attributeValue = getValue(node);
		String[] values = StringUtils.splitByWholeSeparator(attributeValue, getChildSeparator(currentId), 2);
		return Double.parseDouble(values[0]);
	}
	
	/**
	 * Metodo que permite obtener el valor completo del nodo incluyendo 
	 * al valor real asignado y los valores complejos anidados
	 * @param node Cadena que contiene la expresion a analizar
	 * @return Cadena que contiene el valor completo del nodo
	 */
	private String getValue(String node){
		String[] attributes = getAttributes(node);		
		return attributes[attributesCount - 1];
	}
	
	/**
	 * Metodo que permite obtener el valor del porcentaje en el que
	 * el valor del nodo le colabora al valor del nodo padre
	 * @param node Cadena que contiene la expresion a analizar
	 * @return Porcentaje de colaboración del hijo al padre
	 */
	private double getContributePercent(String node){
		String[] attributes = getAttributes(node);
		return Double.parseDouble(attributes[0]);
	}
	
	/**
	 * Metodo que permite determinar si el valor del nodo NO es calculado
	 * @param node Cadena que contiene la expresion a analizar
	 * @return True si el valor es asignado, False si es calculado
	 */
	private boolean isAssigned(String node){
		String[] attributes = getAttributes(node);
		return Boolean.parseBoolean(attributes[1]);
	}
	

	/**
	 * Metodo que permite obtener el id máximo de los hijos del nodo
	 * @param node Cadena que contiene la expression a analizar
	 * @return El id máximo de los hijos del nodo 
	 */
	private int getMaxChildrenPosition(String node){
		List<String> children = getChildren(node);
		String nodeId = getId(node);
		String currentId;
		int maxPosition = 0, currentPosition = 0;
		
		for(String child : children){
			currentId = getId(child);
			currentId = StringUtils.remove(currentId, nodeId + GenericConstants.DOT);
			currentPosition = Integer.parseInt(currentId);
			maxPosition = maxPosition < currentPosition ? currentPosition : maxPosition;
		}
		
		return maxPosition;
	}
	
	/**
	 * Metodo que permite modificar el identificador de un nodo
	 * y de todos sus hijos
	 * @param node Cadena que contiene la expresion a modificar
	 * @param newId Nuevo identificador que tendrá el nodo
	 * @return Cadena con la información del nodo modificada
	 */
	public String changeNodeId(String node, String newId){
		String nodeId = getId(node);
		String initialStartTag = START_TAG + nodeId;
		String initialEndTag = START_TAG + GenericConstants.SLASH + nodeId;
		String finalStartTag = START_TAG + newId;
		String finalEndTag = START_TAG + GenericConstants.SLASH + newId;
		String modifiedNode = StringUtils.replace(node, initialStartTag, finalStartTag);
		modifiedNode = StringUtils.replace(modifiedNode, initialEndTag, finalEndTag);
		return modifiedNode;
	}
	
	/**
	 * Metodo que permite obtener el identificador del padre del nodo dado
	 * @param node Cadena que contiene la expresión a procesar
	 * @return El identificador del padre
	 */
	public String getParentId(String node){
		String nodeId = getId(node);
		int lastDotIndex = StringUtils.lastIndexOf(nodeId, GenericConstants.DOT);
		return StringUtils.substring(nodeId, 0, lastDotIndex);
	}
	
	/**
	 * Metodo que permite buscar un nodo dentro de la expresión y obtenerlo
	 * junto con todas las expresiones anidadas que contenga
	 * @param expression Cadena que contiene la expresion a analizar
	 * @param nodeId Identificador del nodo que se desea obtener
	 * @return Cadena con el nodo si existe (Si es un valor final será un número)
	 *  null de lo contrario
	 */
	public String getNode(String expression, String nodeId){
		if(!hasValidBoundaries(expression)){
			return StringUtils.EMPTY;
		}else if(StringUtils.equals(nodeId, getId(expression))){
			return expression;
		}else{
			List<String> children = getChildren(expression); 
				
			for(String child : children){
				if(isNodeIdFromTree(child, nodeId)){
					return getNode(child, nodeId);
				}
			}
			
			return null;
		}
	}
	
	/**
	 * Metodo que permite modificar un atributo de un nodo de la expresion
	 * @param expression Cadena que contiene la expresion a analizar
	 * @param nodeId Identificador del nodo del que se desea modificar el atributo
	 * @param index Posición del atributo a modificar donde la posicion inicial es 0
	 * @param value Nuevo valor del atributo
	 * @return La expresión con el atributo modificado
	 */
	public String changeAttribute(String expression, String nodeId, int index, String value){
		String initialNode = getNode(expression, nodeId);
		String modifiedNode = StringUtils.substringBetween(initialNode, getStartTag(nodeId), getEndTag(nodeId));
		String[] attributes = StringUtils.split(modifiedNode, ATTR_SEPARATOR, attributesCount);
				
		if(0 <= index && index < attributes.length - 1){
			attributes[index] = value;
			modifiedNode = StringUtils.join(attributes, ATTR_SEPARATOR);
			modifiedNode = getStartTag(nodeId) + modifiedNode + getEndTag(nodeId);
			return StringUtils.replace(expression, initialNode, modifiedNode);
		}else{
			throw new IndexOutOfBoundsException("El indice del atributo debe ser " +
					"menor a ["+ (attributes.length - 1) +"]");
		}
	}
		
	/**
	 * Metodo que permite modificar el valor completo de un nodo
	 * @param expression Cadena que contiene la expresion a analizar
	 * @param nodeId Identificador del nodo al que se desea modificar el valor
	 * @param value Nueva valor que será asignado al nodo
	 * @return La expresion con el nuevo valor del nodo
	 */
	public String changeValue(String expression, String nodeId, String value){
		String initialNode = getNode(expression, nodeId);
		String modifiedNode = StringUtils.substringBetween(initialNode, getStartTag(nodeId), getEndTag(nodeId));
		String[] attributes = StringUtils.split(modifiedNode, ATTR_SEPARATOR, attributesCount);
		
		attributes[attributesCount - 1] = value;
		modifiedNode = StringUtils.join(attributes, ATTR_SEPARATOR);
		modifiedNode = getStartTag(nodeId) + modifiedNode + getEndTag(nodeId);
		return StringUtils.replace(expression, initialNode, modifiedNode);
	}
	
	/**
	 * Metodo que permite construir un nuevo nodo
	 * @param nodeId Identificador del nuevo nodo
	 * @param attributes Valores de los atributos del nuevo nodo
	 * @param value Valor real asignado al nodo
	 * @return Cadena que representa al nodo
	 */
	public String buildNode(String nodeId, String[] attributes, double value){
		if(attributes == null || attributes.length != attributesCount - 1){
			throw new IllegalArgumentException("Se debe contar con " + (attributesCount - 1) + " atributos exactamente");
		}
		
		String node = getStartTag(nodeId);
		node += StringUtils.join(attributes, ATTR_SEPARATOR);
		node += ATTR_SEPARATOR + value;
		node += getEndTag(nodeId);
		return node;
	}
	
	/**
	 * Metodo que permite eliminar un nodo de la expresion (Podar el arbol)
	 * @param expression Cadena con la expresion que se desea analizar
	 * @param nodeId Identificador del nodo que se desea eliminar
	 * @param nodeParentId Identificador del padre del nodo que se desea eliminar
	 * @return La expresion sin el nodo dado
	 */
	public String deleteNode(String expression, String nodeId){
		String currentNode = getNode(expression, nodeId);
		String nodeParentId = getParentId(currentNode);
		String parentChildSeparator = getChildSeparator(nodeParentId);
		String innerNode = parentChildSeparator + currentNode;
		
		if(StringUtils.countMatches(expression, innerNode) > 0){
			return StringUtils.replace(expression, innerNode, StringUtils.EMPTY);
		}else{
			return StringUtils.replace(expression, currentNode, StringUtils.EMPTY);
		}
	}
	
	/**
	 * Metodo que permite calcular el valor actual de un nodo
	 * @param expression Cadena que contiene la información a procesar
	 * @param nodeId Identificador del nodo que se desea evaluar
	 * @return El valor real alcanzado hasta el momento por el nodo
	 */
	public double evaluateNode(String expression, String nodeId){
		String currentNode = getNode(expression, nodeId);
		String childNode, childId;
		double totalValue = 0;
		double contributePercent = getContributePercent(currentNode);
		boolean isAssigned = isAssigned(currentNode);
		boolean hasComplexValue = hasComplexValue(currentNode);
				
		if(isAssigned || !hasComplexValue){
			//Si el objetivo es calculado y no tiene hijos, se toma el valor asignado
			totalValue = getAssignedValue(currentNode);
		}else{
			for(String child : getChildren(currentNode)){
				childId = getId(child);
				childNode = getNode(child, childId);
				totalValue += evaluateNode(childNode, childId);	
			}
		}
		
		return (totalValue * contributePercent) / 100;
	}
	
	/**
	 * Metodo que permite agregar un nuevo nodo a la expresión.
	 * Una expresion contiene un único árbol, por lo que necesariamente
	 * el nodo debe tener un padre. En caso de ser un nuevo arbol, se debe
	 * crear primero el nodo raiz con el método buildNode(String nodeId, String[] attributes, String value)
	 * para tener una expresion inicial a la cual agregarle el nodo.
	 * @param expression Cadena que contiene la expresión a procesar
	 * @param node Cadena con la información del nuevo nodo
	 * @return La expresion conteniendo al nuevo nodo.
	 */
	public String addNode(String expression, String node){
		String parentNode, modifiedParentNode;
		String[] attributes;
		String nodeId = getId(node);
		String parentId = getParentId(node);
		validateParentChildRelation(nodeId, parentId);
		
		if(!StringUtils.contains(expression, parentId)){
			throw new IllegalArgumentException("::: Imposible encontrar un padre para el nodo");
		}
		
		parentNode = getNode(expression, parentId);
		attributes = getAttributes(parentNode);
		attributes[attributesCount - 1] += getChildSeparator(parentId);
		attributes[attributesCount - 1] += node;
		
		modifiedParentNode = getStartTag(parentId);
		modifiedParentNode += StringUtils.join(attributes, ATTR_SEPARATOR);
		modifiedParentNode += getEndTag(parentId);
		return StringUtils.replace(expression, parentNode, modifiedParentNode);
	}
		
	/**
	 * Metodo que permite modificar el padre de un nodo
	 * @param expression Cadena que contiene la información a procesar
	 * @param nodeId Identificador del nodo que se desea mover
	 * @param newParentId Identificador del nuevo padre del nodo
	 * @return La expresion donde el nodo tiene un nuevo padre
	 */
	public String changeParentNode(String expression, String nodeId, String newParentId){
		String parentNode = getNode(expression, newParentId);
		String initialNode = getNode(expression, nodeId);
		String modifiedNode = initialNode;
		String newNodeId, modifiedExpression;
		int maxChildrenId = 0;
		
		if(StringUtils.isEmpty(newParentId)){
			throw new IllegalArgumentException("El padre del nodo debe ser un nodo válido");
		}
		
		maxChildrenId = getMaxChildrenPosition(parentNode) + 1;
		newNodeId = newParentId + GenericConstants.DOT + maxChildrenId;
		modifiedNode = changeNodeId(modifiedNode, newNodeId);
		modifiedExpression = deleteNode(expression, nodeId);
		return addNode(modifiedExpression, modifiedNode);
	}
	
	/**
	 * Metodo que permite determinar si dos nodos son familia
	 * @param parent Posible padre del nodo hijo
	 * @param child Nodo que se desea validar como hijo del parent
	 * @return True si child es hijo de parent, false de lo contrario
	 */
	public boolean isParent(String parent, String child){
		String parentId = getId(parent);
		String childId = getId(child);
		return StringUtils.startsWith(childId, parentId + GenericConstants.DOT);
	}
	
	/**
	 * Metodo que permite determinar si dos nodos son familia (Puede que los nodos
	 * no pertenezcan al mismo arbol, pero pueden pertenecer al mismo bosque)
	 * @param nodeId1 Identificador del primer nodo a analizar
	 * @param nodeId2 Identificador del segundo nodo a analizar
	 * @return True si los nodos son parientes, False de lo contrario
	 */
	public boolean areFamily(String nodeId1, String nodeId2){
		int firstDotIndex = StringUtils.indexOf(nodeId1, GenericConstants.DOT);
		String rootNode = StringUtils.substring(nodeId1, 0, firstDotIndex);
		return StringUtils.startsWith(nodeId2, rootNode + GenericConstants.DOT);
	}
	
	/**
	 * Metodo que permite determinar si dos nodos son familia.
	 * @param tree Posible padre del nodo hijo
	 * @param childId Identificador del nodo hijo
	 * @return True si childId el es id de un hijo de parent, false de lo contratrio
	 */
	public boolean isNodeIdFromTree(String tree, String childId){
		String parentId = getId(tree);
		return parentId.equals(childId) ||
			StringUtils.startsWith(childId, parentId + GenericConstants.DOT);
	}
//	
//	public static void main(String[] args) {
//		BscExpression expression = new BscExpression();
//		String expressionX = "<48.1>60.0#false#unused#25.0</48.1>";
//		expressionX = expression.addNode(expressionX, "<48.1.1>30.0#true#unused#75.0</48.1.1>");
//		expressionX = expression.addNode(expressionX, "<48.1.2>50.0#true#unused#75.0</48.1.2>");
//		expressionX = expression.addNode(expressionX, "<48.1.3>20.0#true#unused#0.0</48.1.3>");
//		System.out.println(expression.evaluateNode(expressionX, "48.1"));
//		expressionX = "<57.1>40.0#false#unused#30.0</57.1>";
//		expressionX = expression.addNode(expressionX, "<57.1.1>40.0#true#unused#100.0</57.1.1>");
//		expressionX = expression.addNode(expressionX, "<57.1.2>40.0#true#unused#0.0</57.1.2>");
//		expressionX = expression.addNode(expressionX, "<57.1.3>20.0#true#unused#100.0</57.1.3>");
//		System.out.println(expression.evaluateNode(expressionX, "57.1"));
//	}
}