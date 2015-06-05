//=======================================================================
// ARCHIVO FieldGroupPriorityComparator.java
// FECHA CREACIÓN: 15/07/2010
//=======================================================================
package co.zero.hcm.comparator;

import java.util.Comparator;

import co.zero.hcm.dto.ui.FieldGroupDTO;

/**
 * Clase que permite comparar dos {@link FieldGroupDTO}, tomando como
 * punto de comparación la prioridad asociada a los grupos
 * @author Hernan
 * @version 1.0
 */
public class FieldGroupPriorityComparator implements Comparator<FieldGroupDTO> {
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(FieldGroupDTO group1, FieldGroupDTO group2) {
		if(group1.getPriority() < group2.getPriority()){
			return -1;
		}else if(group1.getPriority() > group2.getPriority()){
			return 1;
		}else{
			return 0;
		}
	}
}
