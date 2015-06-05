//=======================================================================
// ARCHIVO JobNameComparator.java
// FECHA CREACIÓN: 07/09/2010
//=======================================================================
package co.zero.hcm.comparator;

import java.util.Comparator;

import co.zero.hcm.dto.JobDTO;

/**
 * Clase que permite comparar dos {@link JobDTO}, tomando como
 * punto de comparación el nombre
 * @author Hernan
 * @version 1.0
 */
public class JobNameComparator implements Comparator<JobDTO> {
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(JobDTO job1, JobDTO job2) {
		return job1.getName().compareToIgnoreCase(job2.getName());
	}
}