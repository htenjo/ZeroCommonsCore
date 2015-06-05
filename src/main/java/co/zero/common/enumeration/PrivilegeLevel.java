//=======================================================================
// ARCHIVO PrivilegeAccessType.java
// FECHA CREACIÓN: 12/04/2010
//=======================================================================
package co.zero.common.enumeration;

/**
 * Enumeracion que relaciona los tipos de privilegios manejados
 * @author Hernán Tenjo
 * @version 1.0
 */
public enum PrivilegeLevel {
	//Privilegio que permite listar un conjunto de entidades
	LIST(){
		public String getLevelIndex(){
			return INDEX_LIST;
		}
	},
	//Privilegio que permite ver la información de una entidad
	VIEW(){
		public String getLevelIndex(){
			return INDEX_VIEW;
		}
	},
	//Privilegio que permite crear una entidad
	CREATE(){
		public String getLevelIndex(){
			return INDEX_CREATE;
		}
	},
	//Privilegio que permite modificar una entidad
	EDIT(){
		public String getLevelIndex(){
			return INDEX_EDIT;
		}
	},
	//Privilegio que permite eliminar una entidad
	DELETE(){
		public String getLevelIndex(){
			return INDEX_DELETE;
		}
	},
	
	REPORT(){
		public String getLevelIndex(){
			return INDEX_REPORT;
		}
	},
	
	REPORT_DIRECTIVE(){
		public String getLevelIndex(){
			return INDEX_REPORT_DIRECTIVE;
		}
	},
	
	REPORT_BOSS(){
		public String getLevelIndex(){
			return INDEX_REPORT_BOSS;
		}
	},
	
	REPORT_MANAGER(){
		public String getLevelIndex(){
			return INDEX_REPORT_MANAGER;
		}
	},
	
	REPORT_EMPLOYEE(){
		public String getLevelIndex(){
			return INDEX_REPORT_EMPLOYEE;
		}
	};
	
	//===== A continuación se crean niveles de privilegios requeridos
	//===== cuando el caso de uso presenta más operaciones de las convencionales
	//===== Estos niveles de privilegio podrán ser utilizados por cada caso de uso
	//===== según convenga, teniendo en cuenta la precedencia ascendente de cada nivel
	
	
	
	//Indices que identifican las operaciones de cada caso de uso
	private static final String INDEX_LIST = "1";
	private static final String INDEX_CREATE = "2";
	private static final String INDEX_VIEW = "3";
	private static final String INDEX_EDIT = "4";
	private static final String INDEX_DELETE = "5";
	private static final String INDEX_REPORT = "6";
	private static final String INDEX_REPORT_DIRECTIVE = "7";
	private static final String INDEX_REPORT_BOSS = "8";
	private static final String INDEX_REPORT_MANAGER = "9";
	private static final String INDEX_REPORT_EMPLOYEE = "10";
	
	/**
	 * Metodo que permite obtener el indice del nivel
	 * @return La cadena que representa al indice del nivel
	 */
	public abstract String getLevelIndex();
}