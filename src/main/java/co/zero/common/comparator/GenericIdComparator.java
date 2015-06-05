//=======================================================================
// ARCHIVO GenericIdComparator.java
// FECHA CREACIÓN: 07/09/2010
//=======================================================================
package co.zero.common.comparator;

import java.util.Comparator;

import co.zero.common.dto.EntityDTO;

/**
 * Clase que permite comparar dos {@link EntityDTO}, tomando como
 * punto de comparación su Id
 * @author Hernan Tenjo
 * @version 1.0
 */
public class GenericIdComparator implements Comparator<EntityDTO> {
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(EntityDTO entity1, EntityDTO entity2) {
		if(entity1.getId() < entity2.getId()){
			return -1;
		}else if (entity1.getId() == entity2.getId()){
			return 0;
		}else{
			return 1;
		}
	}
}