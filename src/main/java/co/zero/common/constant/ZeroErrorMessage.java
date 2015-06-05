//=======================================================================
// ARCHIVO ZeroErrorMessage.java
// FECHA CREACIÓN: 23/02/2010
//=======================================================================
package co.zero.common.constant;

/**
 * Clase con los mensajes comunes que se van a utilizar 
 * en el manejo de errores de los módulos de Zero
 * @author Hernán Tenjo
 * @version 1.0
 */
public class ZeroErrorMessage {
	public static final String UNKNOWN_EXCEPTION =
		"\n::: Se ha presentado un error desconocido [message: "+
		GenericConstants.MSG_WILDCARD+"]\n";
	
	public static final String ILLEGAL_STATE_FOR_ENTITY_MANAGER = 
		"\n::: La operacion se encuentra en un estado inválido para el EntityManager " +
		" ["+GenericConstants.MSG_WILDCARD+"]";
		
	public static final String BAD_PARAMETERS_FINDING_ENTITY = 
		"\n::: La clase ["+GenericConstants.MSG_WILDCARD+
		"] no representa a una entidad o \n::: El tipo de dato ["+GenericConstants.MSG_WILDCARD+
		"] no corresponde con el tipo del Id de la entidad";		
	
	public static final String TRANSACTION_REQUIERED = 
		"\n::: El manejador de persistencia requiere de una transacción no existente";
	
	public static final String ENTITY_ALREADY_EXIST =
		"\n::: La entidad ["+GenericConstants.MSG_WILDCARD+
		"] con id ["+GenericConstants.MSG_WILDCARD+"] ya existe en el sistema";
	
	public static final String ENTITY_NOT_EXIST =
		"\n::: La entidad ["+GenericConstants.MSG_WILDCARD+
		"] con id ["+GenericConstants.MSG_WILDCARD+"] no existe en el sistema";
	
	public static final String ENTITY_DTO_NOT_EXIST =
		"\n::: La entidad representada por el DTO ["+GenericConstants.MSG_WILDCARD+
		"] con id ["+GenericConstants.MSG_WILDCARD+"] no existe en el sistema";
	
	public static final String ILLEGAL_ENTITY_STATE = 
		"\n::: La entidad ["+GenericConstants.MSG_WILDCARD+
		"] con id ["+GenericConstants.MSG_WILDCARD+
		"] se encuentra en un estado ["+GenericConstants.MSG_WILDCARD+"] inválido";
	
	public static final String NULL_ENTITY_DTO =
		"\n::: El DTO ["+GenericConstants.MSG_WILDCARD+"] no debe ser nulo";
	
	public static final String NULL_GENERIC_OBJECT =
		"\n::: El Objeto ["+GenericConstants.MSG_WILDCARD+"] no debe ser nulo";
	
	public static final String METHOD_NOT_IMPLEMENTED_YET = 
		"\n::: El metodo ["+GenericConstants.MSG_WILDCARD+
		"] no ha sido implementado aún";
	
	public static final String NON_UNIQUE_RESULT = 
		"\n::: Se encontró mas de un resultado al buscar la entidad ["+ GenericConstants.MSG_WILDCARD+"] " +
		"\n::: por el atributo ["+GenericConstants.MSG_WILDCARD + "] con el valor ["+GenericConstants.MSG_WILDCARD+"]";
	
	public static final String DELETE_OBJECT_ALREADY_USED = 
		"\n::: El objeto ["+GenericConstants.MSG_WILDCARD+"] con id ["+
		GenericConstants.MSG_WILDCARD+"] no se puede eliminar, está siendo usado por ["
		+ GenericConstants.MSG_WILDCARD+"]";
	
	public static final String FILE_NOT_FOUND =
		"\n::: No se ha encontraro el archivo ["+GenericConstants.MSG_WILDCARD+"]";
	
	public static final String STRING_TOO_LONG = 
		"El texto es demasiado largo, se permiten máximo ["+
		GenericConstants.MSG_WILDCARD+"] caracteres";
		
	public static final String UNIQUE_CONSTRAINT_VIOLATION = "\n::: La entidad ["+
		GenericConstants.MSG_WILDCARD+"] viola la restriccion de unicidad " +
				"al intentar guardar el valor["+GenericConstants.MSG_WILDCARD+"]";
	
	public static final String REQUIRED_ATTRIBUTE_NOT_FOUND = 
		"No se encontró el atributo requerido ["+GenericConstants.MSG_WILDCARD+"]";
	
	public static final String DELETING_OBJECT_REQUIRED = 
		"\n::: El objeto ["+GenericConstants.MSG_WILDCARD+"] con id ["+
		GenericConstants.MSG_WILDCARD+"] no se puede eliminar, es un objeto requerido.";
	
	public static final String COLLECTION_INVALID = 
		"La colleccion es nula o no tiene los [" + 
			GenericConstants.MSG_WILDCARD + "] elementos requeridos";
	
	public static final String INVALID_INTROSPECTION_PROCESS = 
		"Esta realizando un proceso de introspección inválido con la entidad [" +
		GenericConstants.MSG_WILDCARD + "]";
	
	public static final String DATE_WITHOUT_REQUIRED_FORMAT = 
		"La fecha no presenta el formato requerido [" + GenericConstants.MSG_WILDCARD + "]";
	
	public static final String INVALID_DATE_RANGE_START_END =
		"La fecha inicial [" + GenericConstants.MSG_WILDCARD + "] debe ser anterior a la final [" +
		GenericConstants.MSG_WILDCARD + "]";
	
	public static final String INVALID_NUMBER_AS_STRING_PARSING =
		"La cadena que intenta convertir [" + GenericConstants.MSG_WILDCARD + "] no representa un número válido";

	public static final String INVALID_PERSISTENT_TYPE = 
		"\n::: Tipo de dato persistente [" +
		GenericConstants.MSG_WILDCARD + "] NO soportado";
	
	public static final String DELETING_OBJECT_ERROR =
		"\n::: Ha ocurrido un error al intentar eliminar el objeto [" +
		GenericConstants.MSG_WILDCARD + "] con id [" + GenericConstants.MSG_WILDCARD + "]." +
		"\n::: Verifique que el objeto no está siendo usado por otra entidad.";
	
	public static final String UPDATING_OBJECT_ERROR =
		"\n::: Ha ocurrido un error al intentar actualizar el objeto [" +
		GenericConstants.MSG_WILDCARD + "] con id [" + GenericConstants.MSG_WILDCARD +"]." +
		"\n::: Verifique que las modificaciones realizadas no afectan atributos requeridos por otras entidades.";
	
	public static final String METHOD_WITHOUT_ACCESS_FROM_CLIENT =
		"\n::: El método [" + GenericConstants.MSG_WILDCARD + "] no se puede " +
				"acceder directamente desde el cliente";
	
	public static final String FILE_FORMAT_ERROR = "\n::: El formato del archivo no es valido, error[" +
			GenericConstants.MSG_WILDCARD + "]";
	
	public static final String ID_ARRAY_INVALID = "\n::: El arreglo de los id para ser eliminados es inválido por ser NULL o vacío, error[" +
			GenericConstants.MSG_WILDCARD + "]";
	
	public static final String INVALID_ENTITY_ATTRIBUTE = "\n::: El atributo [" + GenericConstants.MSG_WILDCARD +
			"] de la entidad [" + GenericConstants.MSG_WILDCARD + "] es inválido.";
	
	public static final String INVALID_NUMBER_IN_RANGE = "::: El numero [" + GenericConstants.MSG_WILDCARD + "] " +
			"debe estar en el rango (" + GenericConstants.MSG_WILDCARD + ", " + GenericConstants.MSG_WILDCARD + ")";
	
	public static final String FILE_EXTENSION_INVALID = "La extensión del archivo es inválida";
}
