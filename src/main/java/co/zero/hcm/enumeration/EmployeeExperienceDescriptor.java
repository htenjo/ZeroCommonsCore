package co.zero.hcm.enumeration;

import co.zero.hcm.dto.EmployeeExperienceDTO;

/**
 * Enumeración que reune los nombres de los atributos de un {@link EmployeeExperienceDTO},
 * para permitir un tratamiento dinámico a los atributos fijos
 * 
 * @author Carlos Ballesteros
 * @version 1.0
 */
public class EmployeeExperienceDescriptor extends EntityDescriptor{

	public static final DefaultAttribute DOCUMENT_NUMBER = new DefaultAttribute("DOCUMENT_NUMBER", null , EmployeeExperienceDTO.class, true, 1, 0,null,String.class);
	public static final DefaultAttribute JOBNAME = new DefaultAttribute("JOBNAME", "jobName" , EmployeeExperienceDTO.class, true, 2, 1);
	public static final DefaultAttribute START_DATE = new DefaultAttribute("START_DATE","startDate", EmployeeExperienceDTO.class, true, 3, 2);
	public static final DefaultAttribute END_DATE = new DefaultAttribute("END_DATE","endDate", EmployeeExperienceDTO.class, false, 4, 3);
	public static final DefaultAttribute COMPANY_NAME = new DefaultAttribute("COMPANY_NAME","companyName", EmployeeExperienceDTO.class, false, 5, 4);

	private static EmployeeExperienceDescriptor singleton = new EmployeeExperienceDescriptor();
	
	public static EmployeeExperienceDescriptor getSingleton(){
		return singleton;
	}
	
	private EmployeeExperienceDescriptor() {
		super(EmployeeExperienceDTO.class);
		addAttribute(DOCUMENT_NUMBER);
		addAttribute(JOBNAME);
		addAttribute(START_DATE);
		addAttribute(END_DATE);
		addAttribute(COMPANY_NAME);
	}

}
