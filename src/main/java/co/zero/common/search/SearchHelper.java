//=======================================================================
// ARCHIVO SearchHelper.java
// FECHA CREACIÓN: 31/08/2010
//=======================================================================
package co.zero.common.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import co.zero.common.constant.GenericConstants;
import co.zero.common.validator.GenericValidator;

/**
 * Clase que colabora en la gestion de las opciones adicionales
 * de busqueda, agrupando los parametros de paginación, de 
 * ordenamiento y los filtros que se pueden realizar sobre una
 * consulta
 * @author Hernán Tenjo
 * @version 1.0
 */
public class SearchHelper implements Serializable{
	private static final long serialVersionUID = 1L;
	private SearchFilter filter = new SearchFilter();
	private List<SearchSorter> sorterList = new ArrayList<SearchSorter>();
	private int maxResults;
	private int startIndex;
	
	/**
	 * Metodo constructor por defecto
	 */
	public SearchHelper(){
	}
	
	/**
	 * Metodo constructor que permite inicial las variables de paginación
	 * @param startIndex Indice donde se empezarán a obtener los resultados
	 * @param maxResults Cantidad máxima de resultados deseados
	 */
	public SearchHelper(int startIndex, int maxResults){
		this.startIndex = startIndex;
		this.maxResults = maxResults;
	}
	
	/**
	 * Metodo que permite obtener la cantidad maxima de resultados 
	 * que se desean por página
	 * @return La cantidad máxima de resultados
	 */
	public int getMaxResults() {
		return maxResults;
	}
	
	/**
	 * Metodo que permite modificar la cantidad maxima de resultados
	 * que se desen por pagina
	 * @param maxResults La nueva cantidad maxima de resultados 
	 * que se desean obtener
	 */
	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}
	
	/**
	 * Metodo que permite obtener la posicion donde se comenzará
	 * a realizar la paginación 
	 * @return Posicion donde se empezará la obtencion de los resultados
	 */
	public int getStartIndex() {
		return startIndex;
	}
	
	/**
	 * Metodo que permite modificar la posicion donde se comenzará
	 * a realizar la paginación
	 * @param startIndex La nueva posicion donde se empezará la obtención
	 * de los resultados
	 */
	public void setStartIndex(int startResults) {
		this.startIndex = startResults;
	}
	
	/**
	 * Metodo que permite reemplazar el nombre de un parametro en todos los
	 * atributos que gestiona el helper
	 * @param entityDTOClass Clase que contiene el atributo
	 * @param oldAttributeName Nombre del parametro que se desea modificar
	 * @param attributeName Nuevo nombre que tomará el parametro
	 */
	public void replaceSortParameter(String entityDTOClass, 
			String oldAttributeName, String attributeName){		
		for(SearchSorter sorter : sorterList){
			if(sorter.getEntityClass().equals(entityDTOClass) &&
					sorter.getSortAttribute().equals(oldAttributeName)){
				sorter.setSortAttribute(attributeName);
			}
		}
	}
	
	/**
	 * Metodo que permite agregar un parámetro de ordenamiento al helper
	 * NOTA: El orden en el que se agreguen estos parámetros se verá 
	 * reflejado directamente en la prioridad del ordenamiento
	 * @param attribute nombre del parametro por el que se desea ordenar
	 */
	public void addSortParameter(String entityDTOClass, String attribute, boolean ascendant){
		SearchSorter sorter = new SearchSorter(entityDTOClass, attribute, ascendant);
		sorterList.add(sorter);
	}
	
	/**
	 * Metodo que permite modificar el prefijo que será asignado a los atributos de ordenamiento
	 * @param entityClass Clase a la que pertenece el atributo de ordenamiento
	 * @param prefix 
	 */
	public void addPrefixToSorter(String entityDTOClass, String prefix){
		for(SearchSorter sorter : sorterList){
			if(sorter.getEntityClass().equals(entityDTOClass)){
				sorter.setPrefix(prefix);
			}
		}
	}
	
	/**
	 * Metodo que permite obtener el primer ordenador registrado en el helper
	 * @return El primer SearchOrder registrado en el helper
	 */
	public SearchSorter getFirstSorter(){
		if(GenericValidator.isValidCollection(sorterList, 1)){
			return sorterList.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * Metodo que permite construir una cadena con la representación
	 * de todos los ordenadores registrados en el helper
	 * @return Cadena que representa a los parametros de ordenamiento
	 * registrados en el helper
	 */
	public String buildSorter(){
		StringBuilder query = new StringBuilder();
		SearchSorter sorter;
		
		for(int i=0; i < sorterList.size(); i++){
			sorter = sorterList.get(i);
			
			if(!StringUtils.isBlank(sorter.getPrefix())){
				query.append(sorter.getPrefix());
			}
			
			query.append(sorter.getSortAttribute());
			query.append(sorter.isAscendant() ? GenericConstants.SQL_ORDER_ASCENDANT:
				GenericConstants.SQL_ORDER_DESCENDANT);
			
			if(i + 1 < sorterList.size()){
				query.append(GenericConstants.COMMA);
			}
		}
		
		return query.toString();
	}
	
	/**
	 * Metodo que permite construir una cadena con la representación
	 * de los ordenadores registrados en el helper que se encuentran asociados
	 * con una clase especifica (El ordenador puede tener diferentes conceptos
	 * de ordenamientos para diferentes consultas en la operacion)
	 * @return Cadena que representa a los parametros de ordenamiento
	 * registrados en el helper
	 */
	public String buildSorter(String entityClass){
		StringBuilder query = new StringBuilder();
		SearchSorter sorter;
		
		for(int i=0; i < sorterList.size(); i++){
			sorter = sorterList.get(i);
			
			if(StringUtils.equals(sorter.getEntityClass(), entityClass)){
				query.append(GenericConstants.COMMA);
				
				if(!StringUtils.isBlank(sorter.getPrefix())){
					query.append(sorter.getPrefix());
				}
				
				query.append(sorter.getSortAttribute());
				query.append(sorter.isAscendant() ? GenericConstants.SQL_ORDER_ASCENDANT:
					GenericConstants.SQL_ORDER_DESCENDANT);
			}
		}
		
		return query.length() > 1 ? query.substring(1): query.toString();
	}
	
	/**
	 * Método que permite determinar si el helper contiene algún
	 * parámetro válido de ordenación para ser agregado a una consulta
	 * @param entityClass Nombre de la clase dueña de uno de los atributos
	 * que debe existir en el helper para realizar el ordenamiento
	 * @return True si existe un parámetro de ordenamiento para la clase 
	 * dada, false de lo contrario
	 */
	public boolean hasValidSorters(String entityClass){
		return buildSorter(entityClass).length() > 0 ? true : false;
	}
	
	public boolean hasValidSorters(){
		return getFirstSorter() != null;
	}
	
	/**
	 * Método que permite construir la cadena que representa al filtro
	 * para ser agregada en una consulta
	 * @return La cadena que representa al filtro
	 */
	public String buildFilters(){
		return filter.buildFilter();
	}
	
	/**
	 * Método que permite determinar si el helper contiene algún filtro
	 * válido para ser aplicado a una consulta
	 * @return True si contiene algún filtro válido, False de lo contrario
	 */
	public boolean hasValidFilters(){
		return filter.isValidFilter();
	}
	
	/**
	 * Método que permite obtener un mapa con el nombre y el valor de los
	 * parámetros que deben ser agregados a la consulta para ser reemplazados
	 * en el filtro
	 * @return Mapa con los parámetros y sus valores
	 */
	public Map<String, Object> getParameterValues(){
		return filter.getParameterValues();
	}
	
	/**
	 * Metodo que permite modificar el prefijo que será asignado a los atributos de ordenamiento
	 * @param entityClass Clase a la que pertenece el atributo de ordenamiento
	 * @param prefix 
	 */
	public void addPrefixToFilter(String entityDTOClass, String prefix){
		filter.setPrefix(entityDTOClass, prefix);
	}
	
	/**
	 * Metodo que permite construir un filtro con operador =
	 * @param name Nombre del atributo por el que se desea filtrar
	 * @param value Valor del atributo que se está filtrando
	 * @param hasQuotationMarks True si el valor del atributo es
	 * de tipo numérico o booleano
	 * @return El filtro con los parámetros dados
	 */
	public SearchFilter getFilterEquals(String entityClass,
			String name, Object value, boolean hasQuotationMarks){
		return this.filter.getFilterEquals(entityClass, name, value, hasQuotationMarks);
	}
	
	/**
	 * Metodo que permite construir un filtro con operador IN
	 * @param name Nombre del atributo por el que se desea filtrar
	 * @param value Valores del atributo que se está filtrando separados por comas
	 * para crear un filtro del tipo [entity.attribute IN (x1,x2,x3,....,xn)]
	 * @return El filtro con los parámetros dados
	 */
	public SearchFilter getFilterIn(String entityClass, String name, String value){
		return this.filter.getFilterIn(entityClass, name, value);
	}
	
	/**
	 * Metodo que permite construir un filtro con operador NOT IN
	 * @param name Nombre del atributo por el que se desea filtrar
	 * @param value Valores del atributo que se está filtrando separados por comas
	 * para crear un filtro del tipo [entity.attribute NOT IN (x1,x2,x3,....,xn)]
	 * @return El filtro con los parámetros dados
	 */
	public SearchFilter getFilterNotIn(String entityClass, String name, String value){
		return this.filter.getFilterNotIn(entityClass, name, value);
	}
	
	/**
	 * Metodo que permite construir un filtro con operador IS
	 * @param name Nombre del atributo por el que se desea filtrar
	 * @param value Valor del atributo que se está filtrando
	 * @return El filtro con los parámetros dados
	 */
	public SearchFilter getFilterIsNull(String entityClass, String name){
		return this.filter.getFilterIsNull(entityClass, name);
	}
	
	/**
	 * Metodo que permite construir un filtro con operador IS NOT
	 * @param name Nombre del atributo por el que se desea filtrar
	 * @param value Valor del atributo que se está filtrando
	 * @return El filtro con los parámetros dados
	 */
	public SearchFilter getFilterIsNotNull(String entityClass, String name){
		return this.filter.getFilterIsNotNull(entityClass, name);
	}
	
	
	/**
	 * Metodo que permite construir un filtro con operador LIKE,
	 * donde se agrega comodin al inicio y al final del valor del parametro
	 * @param name Nombre del atributo por el que se desea filtrar
	 * @param value Valor del atributo que se está filtrando
	 * @return El filtro con los parámetros dados
	 */
	public SearchFilter getFilterLike(String entityClass, String name, String value){
		return this.filter.getFilterLike(entityClass, name, value);
	}
	
	/**
	 * Metodo que permite construir un filtro con operador LIKE_START, 
	 * donde el comodin se agrega unicamente al inicio del valor del parametro
	 * @param name Nombre del atributo por el que se desea filtrar
	 * @param value Valor del atributo que se está filtrando
	 * @return El filtro con los parámetros dados
	 */
	public SearchFilter getFilterLikeStart(String entityClass, String name, String value){
		return this.filter.getFilterLikeStart(entityClass, name, value);
	}
	
	/**
	 * Metodo que permite construir un filtro con operador LIKE_START, 
	 * donde el comodin se agrega unicamente al final del valor del parametro
	 * @param name Nombre del atributo por el que se desea filtrar
	 * @param value Valor del atributo que se está filtrando
	 * @return El filtro con los parámetros dados
	 */
	public SearchFilter getFilterLikeEnd(String entityClass, String name, String value){
		return this.filter.getFilterLikeEnd(entityClass, name, value);
	}
	
	/**
	 * Metodo que permite construir un filtro con operador !=
	 * @param name Nombre del atributo por el que se desea filtrar
	 * @param value Valor del atributo que se está filtrando
	 * @param hasQuotationMarks True si el valor del atributo es
	 * de tipo numérico o booleano
	 * @return El filtro con los parámetros dados
	 */
	public SearchFilter getFilterDistinct(String entityClass,
			String name, Object value, boolean hasQuotationMarks){
		return this.filter.getFilterDistinct(entityClass, name, value, hasQuotationMarks);
	}
	
	/**
	 * Metodo que permite agregar un filtro simple al helper con operador =
	 * @param entityClass Clase a la que pertenece el atributo filtrado
	 * @param name Nombre del atributo filtrado
	 * @param value Valor del atributo que sera filtrado
	 * @param hasQuotationMarks TRUE si el atributo no es numérico
	 * ni booleano
	 */
	public void addSimpleEqualsFilter(String entityClass, 
			String name, Object value, boolean hasQuotationMarks){
		addSimpleFilter(entityClass, name, value, 
				GenericConstants.SQL_OPERATOR_EQUALS, hasQuotationMarks);
	}
	
	/**
	 * Metodo que permite agregar un filtro simple al helper con operador LIKE
	 * @param entityClass Clase a la que pertenece el atributo filtrado
	 * @param name Nombre del atributo filtrado
	 * @param value Valor del atributo que sera filtrado
	 * @param hasQuotationMarks TRUE si el atributo no es numérico
	 * ni booleano
	 */
	public void addSimpleLikeFilter(String entityClass, String name, String value){
		addSimpleFilter(entityClass, name, value, GenericConstants.SQL_OPERATOR_LIKE, true);
	}
	
	/**
	 * Metodo que permite agregar un filtro simple al helper con operador !=
	 * @param entityClass Clase a la que pertenece el atributo filtrado
	 * @param name Nombre del atributo filtrado
	 * @param value Valor del atributo que sera filtrado
	 * @param hasQuotationMarks TRUE si el atributo no es numérico
	 * ni booleano
	 */
	public void addSimpleDistinctFilter(String entityClass, 
			String name, Object value, boolean hasQuotationMarks){
		addSimpleFilter(entityClass, name, value, 
				GenericConstants.SQL_OPERATOR_DISTINCT, hasQuotationMarks);
	}
	
	/**
	 * Metodo que permite agregar un filtro simple al helper basandose en la info de otro
	 * @param filter Filtro que contiene la informacion a agregar
	 */
	public void addSimpleFilter(SearchFilter filter){
		addSimpleFilter(filter.getEntityClass(), filter.getParameterName(), 
				filter.getParameterValue(), filter.getOperator(), filter.hasQuotationMarks());
	}
	
	/**
	 * Metodo que permite agregar un filtro complejo con la operación AND.
	 * Es decir, se hará un AND entre el resultado de cada uno de los filtro simples
	 * @param filterStart Filtro que estará en el lado izquierdo del AND
	 * @param filterEnd Filtro que estará en el lado derecho del AND
	 */
	public void addComplexFilterAND(SearchFilter filterStart, SearchFilter filterEnd){
		this.filter.addFilterAND(filterStart, filterEnd);
	}
	
	/**
	 * Metodo que permite agregar un filtro complejo con la operación OR.
	 * Es decir, se hará un OR entre el resultado de cada uno de los filtro simples
	 * @param filterStart Filtro que estará en el lado izquierdo del OR
	 * @param filterEnd Filtro que estará en el lado derecho del OR
	 */
	public void addComplexFilterOR(SearchFilter filterStart, SearchFilter filterEnd){
		this.filter.addFilterOR(filterStart, filterEnd);
	}
	
	/**
	 * Metodo que permite agregar un filtro simple al helper con operador dado
	 * @param entityClass Clase a la que pertenece el atributo filtrado
	 * @param name Nombre del atributo filtrado
	 * @param value Valor del atributo que sera filtrado
	 * @param operator Operador que será utilizado en el filtro
	 * @param hasQuotationMarks TRUE si el atributo no es numérico
	 * ni booleano
	 */
	private void addSimpleFilter(String entityClass, String name, Object value, 
			String operator, boolean hasQuotationMarks){
		this.filter.setOperator(operator);
		this.filter.setParameterName(name);
		this.filter.setParameterValue(value);
		this.filter.setQuotationMarks(hasQuotationMarks);
		this.filter.setEntityClass(entityClass);
	}
	
	/**
	 * Método que permite determinar la posicion relativa del elemento
	 * inicial de la página, según el paginador asociado
	 * @return La posicion relativa del primer elemento de la página
	 * p.e. Si se tienen 55 elementos totales, un startIndex = 2 y un
	 * maxResults = 10, el resultado será 21
	 */
	public int getStartElementIndex(){
		return getStartIndex() + 1;
	}
	
	/**
	 * Agrega un nuevo filtro al ya existente
	 * @param filter
	 */
	public void compose(SearchFilter filter){
		if(filter != null){
			if(hasValidFilters()){
				SearchFilter aux = new SearchFilter();
				aux.addFilterAND(this.filter, filter);
				this.filter = aux;
			}else{
				addSimpleFilter(filter);
			}
		}
	}
	
	/**
	 * Método que reemplaza de forma arbitraria el filtro actual del helper
	 * @param filter Nuevo filtro que será utilizado por el helper
	 */
	public void setFilter(SearchFilter filter){
		this.filter = filter;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder auxString = new StringBuilder();
		auxString.append("[startIndex = " + this.startIndex + "]");
		auxString.append("[maxResults = " + this.maxResults + "]");
		auxString.append("[filters={"+ buildFilters() +"}]");
		auxString.append("[sorters={"+ buildSorter() +"}]");
		return auxString.toString();
	}
}