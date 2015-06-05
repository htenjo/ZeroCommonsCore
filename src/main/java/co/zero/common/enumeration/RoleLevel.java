//=======================================================================
// ARCHIVO RoleLevel.java
// FECHA CREACIÓN: 14/04/2010
//=======================================================================
package co.zero.common.enumeration;

/**
 * Enumeración que contiene los niveles de roles manejados en el sistema
 * Los niveles de roles se requieren para establecer las prioridades de los roles
 * @author Hernán Tenjo
 * @version 1.0
 */
public enum RoleLevel {
	//Nivel que debería tener todos los privilegios disponibles
	ROOT(){
		public int getLevelPriority(){
			return 100;
		}
	},
	//Nivel que debería tener los privilegios para la gestion de compañías
	MULT_ADMIN(){
		public int getLevelPriority(){
			return 80;
		}
	},
	//Nivel que debería tener los privilegios para la gestion y configuracion de una compañía
	ADMIN(){
		public int getLevelPriority(){
			return 60;
		}
	},
	MANAGER(){
		public int getLevelPriority(){
			return 40;
		}
	},
	//Nivel para los roles que no hacen parte de los roles administrativos
	EMPLOYEE(){
		public int getLevelPriority(){
			return 20;
		}
	},	
	//En caso de no tener un nivel asignado
	NONE(){
		public int getLevelPriority(){
			return 0;
		}
	};
	
	/**
	 * Metodo que determina si este nivel es de mayor rango que el nivel dado
	 * @param level Nivel con el que se desea comparar
	 * @return True si este nivel tiene una prioridad mayor o igual que el nivel dado
	 * 	false de lo contrario
	 */
	public boolean hasMorePriority(RoleLevel level){
		return this.getLevelPriority() > level.getLevelPriority();
	}
	
	/**
	 * Metodo que permite obtener el cardinal que permite organizar los niveles
	 * @return El cardinal que identifica al nivel
	 */
	public abstract int getLevelPriority();
}