//=======================================================================
// ARCHIVO SearchFilter.java
// FECHA CREACIÓN: 31/08/2010
//=======================================================================
package co.zero.common.search;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import co.zero.common.constant.GenericConstants;

/**
 * Clase que representa a un filtro de una búsqueda. Este filtro
 * puede ser tan complejo como se considere necesario al realizar
 * la anidación de filtros.
 * @author Hernán Tenjo
 * @version 1.0
 */
public class SearchFilter implements Serializable{
	private static final long serialVersionUID = 1L;
	//Labels para los operadores que poseen simbolos reservados
	private static final String SQL_OPERATOR_EQUALS_LABEL = "EQUALS";
	private static final String SQL_OPERATOR_DISTINCT_LABEL = "DISTINCT";
	private static final String SQL_OPERATOR_LIKE_START = " LIKE_START ";
	private static final String SQL_OPERATOR_LIKE_END = " LIKE_END ";
	private static final String SQL_OPERATOR_IS_NULL = "IS_NULL";
	private static final String SQL_OPERATOR_IS_NOT_NULL = "IS_NOT_NULL";
	//Nombre del atributo que será filtrado
	private String parameterName;
	//Valor del filtro
	private Object parameterValue;
	//Operador que establecera el filtro
	private String operator;
	//Determina si el valor debe tener comillas
	private boolean hasQuotationMarks = true;
	//Valor que será antepuesto al parameterName
	private String prefix;
	//El filtro puede tener filtros anidados
	private SearchFilter[] filters;
	//Determina si este es un filtro complejo, es decir
	//que está compuesto por 2 filtros
	private boolean isComplexFilter;
	//Nombre de la entidad a la que pertenece el atributo filtrado
	private String entityClass;

	/**
	 * Metodo que permite determinar si al valor del parametro
	 * se le deben agregar o no comillas simples. Únicamente
	 * los numeros y los valores booleanos no deben llevar comillas,
	 * por lo cual se tiene TRUE como valor por defecto
	 * @return TRUE si se deben agregar comillas al parámetro, 
	 * FALSE de lo contrario.
	 */
	public boolean hasQuotationMarks() {
		return hasQuotationMarks;
	}

	/**
	 * Metodo que permite modificar si se agregan comillas al valor
	 * @param hasQuotationMarks TRUE si se desea que se adicionen 
	 * comillas al valor del parametro, FALSE de lo contrario
	 */
	public void setQuotationMarks(boolean hasQuotationMarks) {
		this.hasQuotationMarks = hasQuotationMarks;
	}

	/**
	 * Metodo que permite obtener el operador del filtro
	 * @return El operador que se está utilizando en el filtro
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * Metodo que permite modificar el operador que se esta utilizando
	 * en el filtro
	 * @param operator El nuevo operador del filtro
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * Metodo que permite obtener el nombre del parametro del filtro
	 * @return El nombre del parametro configurado
	 */
	public String getParameterName() {
		return parameterName;
	}
	
	/**
	 * Metodo que permite modificar el nombre del parámetro del filtro
	 * @param parameterName El nuevo nombre del parámetro
	 */
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	
	/**
	 * Metodo que permite obtener el valor del parametro del filtro
	 * @return El valor del parametro configurado
	 */
	public Object getParameterValue() {
		return parameterValue;
	}
	
	/**
	 * Metodo que permite modificar el valor del parámetro del filtro
	 * @param parameterValue Nuevo valor del parametro que tendrá el filtro
	 */
	public void setParameterValue(Object parameterValue) {
		this.parameterValue = parameterValue;
	}
	
	/**
	 * Metodo que permite obtener el nombre de la clase a la que pertenece
	 * el atributo filtrado
	 * @return El nombre de la clase registrado para el atributo
	 */
	public String getEntityClass() {
		return entityClass;
	}

	/**
	 * Metodo que permite modificar el nombre de la clase a la que pertenece
	 * el atributo filtrado
	 * @param entityClass El nombre de la nueva clase que será registrada
	 */
	public void setEntityClass(String entityClass) {
		this.entityClass = entityClass;
	}
	
	/**
	 * Metodo que permite obtener el prefijo del nombre del parametro
	 * @return El prefijo configurado
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * Metodo que permite modificar el prefijo del nombre del parametro
	 * @param prefix El nuevo prefijo a configurar
	 */
	public void setPrefix(String entityClass, String prefix) {
		if(isComplexFilter){
			filters[0].setPrefix(entityClass, prefix);
			filters[1].setPrefix(entityClass, prefix);
		}else{
			if(StringUtils.equals(this.getEntityClass(), entityClass)){
				this.prefix = prefix;	
			}
		}
	}

	/**
	 * Metodo que permite agregar un filtro complejo con la operación AND.
	 * Es decir, se hará un AND entre el resultado de cada uno de los filtro simples
	 * @param filterStart Filtro que estará en el lado izquierdo del AND
	 * @param filterEnd Filtro que estará en el lado derecho del AND
	 */
	public void addFilterAND(SearchFilter filterStart, SearchFilter filterEnd){
		addComplexFilter(filterStart, filterEnd, GenericConstants.SQL_AND_CLAUSE);
	}
	
	/**
	 * Metodo que permite agregar un filtro complejo con la operación OR.
	 * Es decir, se hará un OR entre el resultado de cada uno de los filtro simples
	 * @param filterStart Filtro que estará en el lado izquierdo del OR
	 * @param filterEnd Filtro que estará en el lado derecho del OR
	 */
	public void addFilterOR(SearchFilter filterStart, SearchFilter filterEnd){
		addComplexFilter(filterStart, filterEnd, GenericConstants.SQL_OR_CLAUSE);
	}
		
	/**
	 * Metodo que permite obtener un filtro simple construido que contempla
	 * la operación = (IGUAL) entre el parametro y su valor
	 * @param name Nombre del parametro del filtro
	 * @param value Valor del parametro del filtro
	 * @param hasQuotationMarks Determina si tendrá comillas el valor del parámetro
	 * @return El objeto (FILTRO) que relaciona las anteriores variables
	 */
	public SearchFilter getFilterEquals(String entityClass, 
			String name, Object value, boolean hasQuotationMarks){
		return getFilter(entityClass, name, value, 
				GenericConstants.SQL_OPERATOR_EQUALS, hasQuotationMarks);
	}
	
	/**
	 * Metodo que permite obtener un filtro simple construido que contempla
	 * la operación != (DIFERENTE) entre el parametro y su valor
	 * @param name Nombre del parametro del filtro
	 * @param value Valor del parametro del filtro
	 * @param hasQuotationMarks Determina si tendrá comillas el valor del parámetro
	 * @return El objeto (FILTRO) que relaciona las anteriores variables
	 */
	public SearchFilter getFilterDistinct(String entityClass, 
			String name, Object value, boolean hasQuotationMarks){
		return getFilter(entityClass, name, value, 
				GenericConstants.SQL_OPERATOR_DISTINCT, hasQuotationMarks);
	}
	
	/**
	 * Metodo que permite obtener un filtro simple construido que contempla
	 * la operación IN (Inclusión en un conjunto) entre el parametro y su valor
	 * @param name Nombre del parametro del filtro
	 * @param value Valor del parametro del filtro
	 * @return El objeto (FILTRO) que relaciona las anteriores variables
	 */
	public SearchFilter getFilterIn(String entityClass, String name, String value){
		return getFilter(entityClass, name, value, 
				GenericConstants.SQL_OPERATOR_IN, false);
	}
	
	/**
	 * Metodo que permite obtener un filtro simple construido que contempla
	 * la operación NOT IN (No inclusión en un conjunto) entre el parametro y su valor
	 * @param name Nombre del parametro del filtro
	 * @param value Valor del parametro del filtro
	 * @return El objeto (FILTRO) que relaciona las anteriores variables
	 */
	public SearchFilter getFilterNotIn(String entityClass, String name, String value){
		return getFilter(entityClass, name, value, 
				GenericConstants.SQL_OPERATOR_NOT_IN, false);
	}
	
	/**
	 * Metodo que permite obtener un filtro simple construido que contempla
	 * la operación like (Compara partes de cadena) entre el parametro y su valor
	 * donde el comodin se agrega al inicio y al final del valor del parametro
	 * @param name Nombre del parametro del filtro
	 * @param value Valor del parametro del filtro
	 * @return El objeto (FILTRO) que relaciona las anteriores variables
	 */
	public SearchFilter getFilterLike(String entityClass, String name, String value){
		return getFilter(entityClass, name, value, GenericConstants.SQL_OPERATOR_LIKE, true);
	}
	
	/**
	 * Metodo que permite obtener un filtro simple construido que contempla
	 * la operación like (Compara partes de cadena) entre el parametro y su valor,
	 * donde el comodin se agrega al inicio del valor del parametro
	 * @param name Nombre del parametro del filtro
	 * @param value Valor del parametro del filtro
	 * @return El objeto (FILTRO) que relaciona las anteriores variables
	 */
	public SearchFilter getFilterLikeStart(String entityClass, String name, String value){
		return getFilter(entityClass, name, value, SQL_OPERATOR_LIKE_START, true);
	}
	
	/**
	 * Metodo que permite obtener un filtro simple construido que contempla
	 * la operación like (Compara partes de cadena) entre el parametro y su valor,
	 * donde el comodin se agrega al final del valor del parametro
	 * @param name Nombre del parametro del filtro
	 * @param value Valor del parametro del filtro
	 * @return El objeto (FILTRO) que relaciona las anteriores variables
	 */
	public SearchFilter getFilterLikeEnd(String entityClass, String name, String value){
		return getFilter(entityClass, name, value, SQL_OPERATOR_LIKE_END, true);
	}
	
	/**
	 * Metodo que permite obtener un filtro simple construido que contempla
	 * la operación IS entre el parametro y su valor
	 * @param name Nombre del parametro del filtro
	 * @param value Valor del parametro del filtro
	 * @return El objeto (FILTRO) que relaciona las anteriores variables
	 */
	public SearchFilter getFilterIsNull(String entityClass, String name){
		return getFilter(entityClass, name, null, GenericConstants.SQL_OPERATOR_IS_NULL, false);
	}
	
	/**
	 * Metodo que permite obtener un filtro simple construido que contempla
	 * la operación IS NOT entre el parametro y su valor
	 * @param name Nombre del parametro del filtro
	 * @param value Valor del parametro del filtro
	 * @return El objeto (FILTRO) que relaciona las anteriores variables
	 */
	public SearchFilter getFilterIsNotNull(String entityClass, String name){
		return getFilter(entityClass, name, null, GenericConstants.SQL_OPERATOR_IS_NOT_NULL, false);
	}
	
	/**
	 * Metodo comun que permite obtener un filtro simple construido contemplando
	 * cualquier operación entre el parametro y su valor
	 * @param name Nombre del parametro del filtro
	 * @param value Valor del parametro del filtro
	 * @param operator Operador que se aplicará en el filtro
	 * @param hasQuotationMarks Determina si tendrá comillas el valor del parámetro
	 * @return El objeto (FILTRO) que relaciona las anteriores variables
	 */
	private SearchFilter getFilter(String entityClass, String name, 
			Object value, String operator, boolean hasQuotationMarks){
		SearchFilter filter = new SearchFilter();
		filter.setParameterName(name);
		filter.setParameterValue(value);
		filter.setOperator(operator);
		filter.setQuotationMarks(hasQuotationMarks);
		filter.setEntityClass(entityClass);
		return filter;
	}
	
	/**
	 * Metodo que permite agregar filtros anidados dentro de este. Cuando un filtro
	 * anida a otros filtros, este se vuelve automáticamente un filtro complejo y
	 * los valores asignados como filtro simple dejan de tener relevancia excepto 
	 * el operador. El resultado de un filtro complejo sería FILTRO1 OPERADOR FILTRO2
	 * @param filterStart Filtro que estará a la izquierda del operador
	 * @param filterEnd FIltro que estará a la derecha del operador
	 * @param operator Operador que será aplicado al contenido de cada uno de los filtros
	 */
	private void addComplexFilter(SearchFilter filterStart, SearchFilter filterEnd, String operator){
		if(filters == null){
			filters = new SearchFilter[2];
		}
		
		this.isComplexFilter = true;
		this.setOperator(operator);
		filters[0] = filterStart;
		filters[1] = filterEnd;
	}
	
	/**
	 * Metodo que permite construir la representación del filtro como 
	 * una cadena plana con el contenido de los filtros.
	 * @return Cadena que representa el contenido de los filtros
	 */
	public String buildFilter(){
		StringBuilder filterQuery = new StringBuilder();
		
		if(isValidFilter()){
			filterQuery.append(GenericConstants.SQL_BRACKET_START);
			
			if(isComplexFilter){
				filterQuery.append(filters[0].buildFilter());
				filterQuery.append(this.operator);
				filterQuery.append(filters[1].buildFilter());
			}else{
				if(StringUtils.equals(operator, GenericConstants.SQL_OPERATOR_LIKE)
						|| StringUtils.equals(operator, SQL_OPERATOR_LIKE_START)
						|| StringUtils.equals(operator, SQL_OPERATOR_LIKE_END)){
					filterQuery.append("lower(");
					filterQuery.append(StringUtils.isBlank(prefix) ? StringUtils.EMPTY : prefix);
					filterQuery.append(this.parameterName);
					filterQuery.append(")");
				}else if(StringUtils.equals(operator, GenericConstants.SQL_OPERATOR_IS_NULL) ||
						StringUtils.equals(operator, GenericConstants.SQL_OPERATOR_IS_NOT_NULL)){
					filterQuery.append(StringUtils.isBlank(prefix) ? StringUtils.EMPTY : prefix);
					filterQuery.append(this.parameterName);
				}else{
					filterQuery.append(StringUtils.isBlank(prefix) ? StringUtils.EMPTY : prefix);
					filterQuery.append(this.parameterName);	
				}
				
				if(this.operator.equals(SQL_OPERATOR_LIKE_START) || this.operator.equals(SQL_OPERATOR_LIKE_END)){
					filterQuery.append(GenericConstants.SQL_OPERATOR_LIKE);
				}else{
					filterQuery.append(this.operator);
				}
				
				filterQuery.append(buildParameter());
			}
			
			filterQuery.append(GenericConstants.SQL_BRACKET_END);
		}
		return filterQuery.toString();
	}
	
	/**
	 * Metodo que permite obtener el parámetro del filtro de forma adecuada
	 * según el operador que se esté utilizando
	 * @return 
	 */
	private String buildParameter(){
		String parameter;
		
		if(StringUtils.equals(operator, GenericConstants.SQL_OPERATOR_EQUALS)
				|| StringUtils.equals(operator, GenericConstants.SQL_OPERATOR_DISTINCT)){		
			parameter = GenericConstants.COLON;
			parameter += buildFilterParam();
		}else if(StringUtils.equals(operator, GenericConstants.SQL_OPERATOR_IN)
				|| StringUtils.equals(operator, GenericConstants.SQL_OPERATOR_NOT_IN)){
			parameter = GenericConstants.SQL_BRACKET_START;
			parameter += parameterValue.toString();
			parameter += GenericConstants.SQL_BRACKET_END;
		}else if(StringUtils.equals(operator, GenericConstants.SQL_OPERATOR_IS_NULL)
				|| StringUtils.equals(operator, GenericConstants.SQL_OPERATOR_IS_NOT_NULL)){
			parameter = StringUtils.EMPTY;
		}else if(StringUtils.equals(operator, GenericConstants.SQL_OPERATOR_LIKE)
				|| StringUtils.equals(operator, SQL_OPERATOR_LIKE_START)
				|| StringUtils.equals(operator, SQL_OPERATOR_LIKE_END)){
			parameter = getParameterWithQuots(
					parameterValue.toString().toLowerCase(), operator);
		}else{
			parameter = getParameterWithQuots(parameterValue.toString(), operator);
		}
		
		return parameter;
	}
	
	/**
	 * Metodo que permite determinar si el filtro tiene una estructura valida
	 * @return True si el filtro está bien formado, false de lo contrario
	 */
	public boolean isValidFilter(){
		boolean isValid = false;
		
		if(isComplexFilter){
			if(filters[0] != null && filters[1] != null && 
					!StringUtils.isBlank(operator)){
				isValid = filters[0].isValidFilter() && filters[1].isValidFilter();
			}
		}else{
			if(!StringUtils.isBlank(parameterName) && !StringUtils.isBlank(operator)){
				if((StringUtils.equals(GenericConstants.SQL_OPERATOR_IS_NULL,  operator) ||
						StringUtils.equals(GenericConstants.SQL_OPERATOR_IS_NOT_NULL,  operator))){
					isValid = true;
				}else{
					isValid = parameterValue != null;
				}
			}
		}
		
		return isValid;
	}
	
	/**
	 * Metodo utilitario que permite agregar los elementos adicionales
	 * a los valores de los parametros. El principal elemento tratado son
	 * las comillas simples, pero eventualemente se podrá agregar otros como
	 * los % requeridos con el operador LIKE
	 * @param parameter Valor del parametro que se desea procesar
	 * @param operator Operador que será aplicado, con el cual se determinará
	 * qué elementos adicionales deben ser agregados
	 * @return El valor del parámetro con el formato requerido
	 */
	private String getParameterWithQuots(String parameter, String operator){
		String paramAux = GenericConstants.QUOTE;
		
		if(operator.equals(GenericConstants.SQL_OPERATOR_LIKE)){
			paramAux += GenericConstants.PERCENTAGE;
			paramAux += parameter;
			paramAux += GenericConstants.PERCENTAGE;
		}else if(operator.equals(SQL_OPERATOR_LIKE_START)){
			paramAux += GenericConstants.PERCENTAGE;
			paramAux += parameter;
		}else if(operator.equals(SQL_OPERATOR_LIKE_END)){
			paramAux += parameter;
			paramAux += GenericConstants.PERCENTAGE;
		}else{
			paramAux += parameter;
		}
		
		paramAux += GenericConstants.QUOTE; 
		return  paramAux;
	}
	
	/**
	 * Método que permite cambiar el nombre de un parámetro 
	 * @param oldParam Antiguo nombre del parámetro
	 * @param newParam Nuevo nombre del parámetro
	 */
	public void replaceParameterName(String oldParam, String newParam){
		if(isComplexFilter){
			filters[0].replaceParameterName(oldParam, newParam);
			filters[1].replaceParameterName(oldParam, newParam);
		}else{
			if(StringUtils.equals(parameterName, oldParam)){
				parameterName = newParam;
			}
		}
	}
	
	/**
	 * Método que permite obtener un mapa con el nombre y el valor de los
	 * parámetros que deben ser agregados a la consulta para ser reemplazados en el filtro
	 * @return Mapa con los parámetros y sus valores
	 */
	public Map<String, Object> getParameterValues(){
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		if(isComplexFilter){
			parameters.putAll(filters[0].getParameterValues());
			parameters.putAll(filters[1].getParameterValues());
		}else{
			if(!(StringUtils.equals(GenericConstants.SQL_OPERATOR_LIKE, operator)
					|| StringUtils.equals(SQL_OPERATOR_LIKE_START, operator)
					|| StringUtils.equals(SQL_OPERATOR_LIKE_END, operator)
					|| StringUtils.equals(GenericConstants.SQL_OPERATOR_IN, operator)
					|| StringUtils.equals(GenericConstants.SQL_OPERATOR_NOT_IN, operator)
					|| StringUtils.equals(GenericConstants.SQL_OPERATOR_IS_NULL, operator)
					|| StringUtils.equals(GenericConstants.SQL_OPERATOR_IS_NOT_NULL, operator))){
				parameters.put(buildFilterParam(), parameterValue);
			}
		}
		
		return parameters;
	}
	
	/**
	 * Método que permite contruir el nombre del atributo por el que se desea filtrar
	 * generando una cadena de la forma [entity.attribute]
	 * @return El nombre del atributo a filtrar
	 */
	private String buildFilterName(){
		String filterName = StringUtils.isBlank(prefix) ? StringUtils.EMPTY : prefix;
		filterName += this.parameterName;
		return filterName;
	}
	
	/**
	 * Método que permite construir el nombre del parámetro por el que se desea filtrar
	 * generando una cadena de la forma [entity_attribute]
	 * @return El nombre del parámetro a filtrar
	 */
	private String buildFilterParam(){
		String filterParam = StringUtils.replaceChars(buildFilterName(), 
				GenericConstants.DOT, GenericConstants.UNDERSCORE);
		filterParam += GenericConstants.UNDERSCORE + getOperatorAsString();
		return filterParam;
	}
	
	/**
	 * Metodo que permite obtener el nombre del operador utilizado
	 * @param operator Operador utilizado en el filtro
	 * @return Nombre que representa al operador del filtro
	 */
	private String getOperatorAsString(){
		if(StringUtils.isBlank(operator)){
			return StringUtils.EMPTY;
		}else{
			if(operator.equals(GenericConstants.SQL_OPERATOR_EQUALS)){
				return SQL_OPERATOR_EQUALS_LABEL;
			}else if(operator.equals(GenericConstants.SQL_OPERATOR_DISTINCT)){
				return SQL_OPERATOR_DISTINCT_LABEL;
			}else if(operator.equals(GenericConstants.SQL_OPERATOR_IS_NULL)){
				return SQL_OPERATOR_IS_NULL;
			}else if(operator.equals(GenericConstants.SQL_OPERATOR_IS_NOT_NULL)){
				return SQL_OPERATOR_IS_NOT_NULL;
			}else{
				return operator.trim();
			}
		}
	}
	
	public static void main(String[] args) {
		SearchHelper helper = new SearchHelper();
		SearchFilter filterNull = helper.getFilterIsNull("SolvedQuestionnaireDTO", "solved");
		SearchFilter filterNotNull = helper.getFilterIsNotNull("SolvedQuestionnaireDTO", "solved");
		SearchFilter filterFalse = helper.getFilterEquals("SolvedQuestionnaireDTO", "solved", false, false);
		SearchFilter filtexComplex = new SearchFilter();
		filtexComplex.addFilterAND(filterNull, filterFalse);
		
		helper.addComplexFilterOR(filtexComplex, filterNotNull);
		helper.addPrefixToFilter("SolvedQuestionnaireDTO", "sq.");
		System.out.println(helper.buildFilters());
		System.out.println(helper.getParameterValues().toString());
	}
}