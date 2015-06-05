//=======================================================================
// ARCHIVO GenericConstants.java
// FECHA CREACIÓN: 20/02/2010
//=======================================================================
package co.zero.common.constant;

import org.apache.commons.lang.StringUtils;


/**
 * Clase que permite agrupar las constantes generales
 * comunes a todos los módulos
 * @author Hernán Tenjo
 * @version 1.0
 */
public class GenericConstants {
	//Caracteres frecuentemente usados
	public static final String SPACE = " ";
	public static final String UNDERSCORE = "_";
	public static final String MINUS = " - ";
	public static final String NEW_LINE = "\n";
	public static final String EMPTY_STRING = StringUtils.EMPTY;
	public static final String MSG_WILDCARD = "#";
	public static final String DOT = ".";
	public static final String COMMA = ",";
	public static final String QUOTE = "'";
	public static final String PERCENTAGE = "%";
	public static final String COLON = ":";
	public static final String PIPE = "|";
	public static final String BRACKET_SQUARE_START = "[";
	public static final String BRACKET_SQUARE_END = "]";
	public static final String PESOS = "$";
	public static final String AT = "@";
	public static final String GREATER_THAN = ">";
	public static final String LESS_THAN = "<";
	public static final char GREATER_THAN_CHAR = '>';
	public static final char LESS_THAN_CHAR = '<';
	public static final String SLASH = "/";
	public static final String BACKSLASH = "\\";
	public static final String QUESTION = "?";
	public static final String INVALID_ENTITY_ID = "-1";
	public static final int DEFAUL_BUFFER_SIZE = 1024;
	
	//Constantes para el tratamiento de los Warnings
	public static final String WARNING_UNUSED = "unused";
	public static final String WARNING_UNCHECKED = "unchecked";
	public static final String WARNING_RAWTYPE = "rawtypes";
	public static final String WARNING_DEPRECATED = "deprecation";
	public static final String WARNING_RESTRICTION = "restriction";
	
	//Constantes para formateo de fechas y numeros
	public static final String FORMAT_DATE_SHORT_SLASH = "yyyy/MM/dd";
	public static final String FORMAT_DATE_SHORT = "yyyy-MM-dd";
	public static final String FORMAT_DATE_SHORT_COMPONENT = "dd/MM/yyyy";
	public static final int DAYS_OF_WEEK = 7;
	
	//Tamaños de las columnas de cadenas
	public static final int DB_SIZE_TINY = 60;	
	public static final int DB_SIZE_SMALL = 255;
	public static final int DB_SIZE_MEDIUM = 1000;
	public static final int DB_SIZE_HIGHT = 5000;
	public static final int DB_SIZE_BIG = 10000;	
	public static final int DB_SIZE_EXTRA_BIG = 50000;
	public static final String DB_SIZE_WITHOUT_LIMIT = "TEXT";
	
	//Constantes frecuentemente usadas en utilidades de persistencia
	public static final String SQL_AND_CLAUSE = " AND ";
	public static final String SQL_OR_CLAUSE = " OR ";
	public static final String SQL_ORDER_CLAUSE = " ORDER BY ";
	public static final String SQL_WHERE_CLAUSE = " WHERE ";
	public static final String SQL_FROM_CLAUSE = " FROM ";
	public static final String SQL_ORDER_ASCENDANT = " ASC ";
	public static final String SQL_ORDER_DESCENDANT = " DESC ";
	public static final String SQL_OPERATOR_EQUALS = " = ";
	public static final String SQL_OPERATOR_IN = " IN ";
	public static final String SQL_OPERATOR_NOT_IN = " NOT IN ";
	public static final String SQL_OPERATOR_DISTINCT = " != ";
	public static final String SQL_OPERATOR_LIKE = " LIKE ";
	public static final String SQL_OPERATOR_IS_NULL = " IS NULL ";
	public static final String SQL_OPERATOR_IS_NOT_NULL = " IS NOT NULL ";
	public static final String SQL_BRACKET_START = "(";
	public static final String SQL_BRACKET_END = ")";
	public static final String SQL_INTERSECT_CLAUSE = " INTERSECT ";
	
	//Constantes usadas para referirse a campos de un usuario
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	
	//Constantes para el tratamiento de colores
	public static final String COLOR_RED = "#FF0000";
	public static final String COLOR_WHITE = "#FFFFFF";
	public static final String COLOR_BLACK = "#000000";
	
	//Constantes para codificación de caracteres
	public static final String ENCONDING_UTF_8 = "UTF-8";
	
	//Constantes usadas en los test
	public static final String CHARACTER = "a";
	public static final String ARRAY_BYTES_REPRESENTATION = "::: ARRAY_OF_BYTES :::";
	public static final String BOOLEAN_YES_SPANISH = "SI";
	public static final String BOOLEAN_NO_SPANISH = "NO";
	public static final String ZERO_I18N_ATTRIBUTE = "attribute";
	public static final String ZERO_I18N_BASE_NAME = "com.zero.common.i18n.i18n";
    public static final String I18N_EN_LOCALE = "en";
    public static final String I18N_ES_LOCALE = "es";
    public static final String I18N_PT_LOCALE = "pt";
	public static final String ZERO_I18N_ENTITY_ATTRIBUTE_KEY = "%s.%s.%s";
    public static final String I18N_CREATED_OK_KEY = "generic.register.create.ok";
	public static final String I18N_UPDATED_OK_KEY = "generic.register.update.ok";

	//Colores de las metricas
	public static final String RED = "#f50000";
	public static final String ORANGE = "orange";
	public static final String YELLOW = "#f5c400";
	public static final String GREEN = "#84ba3b";
	public static final String BLUE = "#27a4d9";
	
	//Numeros de los colores de la metrica usados para pintar el semaforo de los kpis
	public static final int RED_NUMBER = 1;
	public static final int ORANGE_NUMBER = 2;
	public static final int YELLOW_NUMBER = 3;
	public static final int GREEN_NUMBER = 4;
	public static final int BLUE_NUMBER = 5;
	
	//Parametros de configuración de correos
	public static final String MAIL_AUTHENTICATE_PARAM = "mail.smtp.auth";
	public static final String MAIL_AUTHENTICATION_MANUAL_REQUIRED_PARAM = "mail.smtp.auth.manual";
	public static final String MAIL_USER_PARAM = "mail.smtp.user";
	public static final String MAIL_PASSWORD_PARAM = "mail.smtp.password";
	public static final String MAIL_PROTOCOL_PARAM = "mail.transport.protocol";
	public static final String MAIL_HOST_PARAM = "mail.smtp.host";
	public static final String MAIL_DEFAULT_BCC = "mail.smtp.default.bcc";
	
	//Comodines que podrán ser reemplazados en un mensaje de correo por
	//login=User.username, password=User.password, name=Person.fullName
	public static final String MAIL_WILDCARD_LOGIN = "#login#";
	public static final String MAIL_WILDCARD_PASSWORD = "#password#";
	public static final String MAIL_WILDCARD_NAME = "#name#";
	
	public static final String MIME_TYPE_EXCEL_2007 = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	public static final String OK = "OK";
	public static final String ERROR = "ERROR";
}
