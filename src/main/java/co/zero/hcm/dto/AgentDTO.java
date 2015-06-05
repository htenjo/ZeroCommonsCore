//=======================================================================
// ARCHIVO EmployeeDTO.java
// FECHA CREACIÓN: Oct 1, 2009
//=======================================================================
package co.zero.hcm.dto;

import java.util.HashSet;
import java.util.Set;


/**
 * Bean que contiene los atributos requeridos en la vista 
 * de un {@link AgentDTO}
 * @author Hernán Tenjo
 * @version 1.0
 */
public class AgentDTO extends PersonDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Compañías con las que el agente tiene relación
	private Set<CompanyDTO> relatedCompanies = new HashSet<CompanyDTO>();
	
	/**
	 * Metodo que permite agregar una compañía a la lista de las 
	 * compañías relacionadas con un agente
	 * @param companyDTO Compañía que se desea agregar
	 */
	public void addRelatedCompany(CompanyDTO companyDTO){
		if(relatedCompanies == null){
			relatedCompanies = new HashSet<CompanyDTO>();
		}
		
		relatedCompanies.add(companyDTO);
	}
	
	/**
	 * Metodo que permite obtener las compañías con las que el 
	 * agente tiene una relacion
	 * @return La lista de compañías relacionadas
	 */	
	public Set<CompanyDTO> getRelatedCompanies() {
		return relatedCompanies;
	}

	/**
	 * Metodo que permite modificar el conjunto de compañías relacionadas
	 * @param relatedCompanies Nuevo conjunto de compañías relacionadas
	 */
	public void setRelatedCompanies(Set<CompanyDTO> relatedCompanies) {
		this.relatedCompanies = relatedCompanies;
	}	
}

