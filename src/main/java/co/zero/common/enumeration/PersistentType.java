package co.zero.common.enumeration;

/**
 * Enumeracion que reune a los tipos de datos permitidos
 * para ser persistidos en la BD
 * @author Hernan
 */
public enum PersistentType{
	LONG,
	DOUBLE,
	STRING,
	TEXT,
	DATE,
	BOOLEAN,	
	//TODO: Posiblemente sea mejor crear distinciones
	//entre los tipos de FILE, para en un futuro facilitar
	//la diferenciación entre una imágen y un archivo
	FILE,
	DATA_ITEM
}