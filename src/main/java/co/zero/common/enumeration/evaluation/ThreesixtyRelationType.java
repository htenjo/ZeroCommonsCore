//=======================================================================
// ARCHIVO ThreesixtyRelationType.java
// FECHA CREACIÓN: 9/05/2011
//=======================================================================
package co.zero.common.enumeration.evaluation;

import java.util.ArrayList;
import java.util.List;

/**
 * Enumeración que reune los diferentes tipos de relaciones 
 * soportadas por una evaluación de 360°
 * @author Hernán Tenjo
 * @version 1.0
 */
public enum ThreesixtyRelationType{
	//Relación reflexiva entre un evaluador y un evaluado con la misma persona
	SELF(){
		@Override
		public boolean isReflexive(){
			return true;
		}
	},
	
	//Relación entre un jefe y su colaborador
	BOSS(){		
		@Override
		public boolean isReflexive(){
			return false;
		}
	},
	
	//Relación entre dos colegas (Personas del mismo nivel)
	COLLEAGUE(){		
		@Override
		public boolean isReflexive(){
			return false;
		}
	},
	
	//Relación entre un colaborador y su jefe
	COLLABORATOR(){		
		@Override
		public boolean isReflexive(){
			return false;
		}
	},
	
	//Relación entre un evaluado y aquella persona que actua cómo su cliente dentro de la empresa
	CLIENT_INTERNAL(){		
		@Override
		public boolean isReflexive(){
			return false;
		}
	},
	
	//Relación entre un evaluado y aquella persona que actua cómo su cliente fuera de la empresa
	CLIENT_EXTERNAL(){		
		@Override
		public boolean isReflexive(){
			return false;
		}
	},
	
	//Relación entre un evaluado y aquella persona que provee de suministros a la empresa
	SUPPLIER(){		
		@Override
		public boolean isReflexive(){
			return false;
		}
	},
	
	//Relación entre un evaluado y una persona que si bien no es el jefe está a ese nivel
	SUPERVISOR(){		
		@Override
		public boolean isReflexive(){
			return false;
		}
	},
	
	//Relación entre un evaluado y otra persona que tenga una relación X con él
	OBSERVER(){		
		@Override
		public boolean isReflexive(){
			return false;
		}
	},;
	
	/**
	 * Método que permite determinar si el tipo de la relación se puede 
	 * aplicar donde el evaluador y el evaluado con la misma persona
	 */
	public abstract boolean isReflexive();
	
	/**
	 * Método que permite obtener las relaciones reflexivas configuradas
	 * @return Lista con los tipos de relaciones reflexivas configuradas
	 */
	public List<ThreesixtyRelationType> getReflexiveRelations(){
		List<ThreesixtyRelationType> reflexiveList = new ArrayList<ThreesixtyRelationType>();
		
		for(ThreesixtyRelationType type : ThreesixtyRelationType.values()){
			if(type.isReflexive()){
				reflexiveList.add(type);	
			}
		}
		
		return reflexiveList;
	}
	
	/**
	 * Método que permite obtener las relaciones NO reflexivas configuradas
	 * @return Lista con los tipos de relaciones NO reflexivas configuradas
	 */
	public List<ThreesixtyRelationType> getNonReflexiveRelations(){
		List<ThreesixtyRelationType> nonReflexiveList = new ArrayList<ThreesixtyRelationType>();
		
		for(ThreesixtyRelationType type : ThreesixtyRelationType.values()){
			if(!type.isReflexive()){
				nonReflexiveList.add(type);	
			}
		}
		
		return nonReflexiveList;
	}
}