package co.zero.hcm.enumeration;

import co.zero.common.enumeration.RelativeType;
import co.zero.hcm.dto.RelativeDTO;

/**
 * Enumeración que reune los nombres de los atributos de un {@link RelativeDTO},
 * para permitir un tratamiento dinámico a los atributos fijos
 * 
 * @author Carlos Ballesteros
 * @version 1.0
 */
public class RelativeDescriptor extends EntityDescriptor{

	public static final DefaultAttribute DOCUMENT_NUMBER = new DefaultAttribute("DOCUMENT_NUMBER", null , RelativeDTO.class, true, 1, 0,null,String.class);
	public static final DefaultAttribute FIRST_NAME = new DefaultAttribute("FIRST_NAME", "firstName" , RelativeDTO.class, true, 2, 1);
	public static final DefaultAttribute MIDDLE_NAME = new DefaultAttribute("MIDDLE_NAME", "middleName" , RelativeDTO.class, false, 3, 2);
	public static final DefaultAttribute LAST_NAME = new DefaultAttribute("LAST_NAME","lastName", RelativeDTO.class, true, 4, 3);
	public static final DefaultAttribute MOTHER_MAIDEN_NAME = new DefaultAttribute("MOTHER_MAIDEN_NAME","motherMaidenName", RelativeDTO.class, false, 5, 4);
	public static final DefaultAttribute BIRTH_DAY = new DefaultAttribute("BIRTH_DAY","birthDay", RelativeDTO.class, false, 6, 5);
	public static final DefaultAttribute TYPE = new DefaultAttribute("TYPE", null , RelativeDTO.class, true, 7, 6,RelativeType.values(),RelativeType.class);

	private static RelativeDescriptor singleton = new RelativeDescriptor();
	
	public static RelativeDescriptor getSingleton(){
		return singleton;
	}
	
	private RelativeDescriptor() {
		super(RelativeDTO.class);
		addAttribute(DOCUMENT_NUMBER);
		addAttribute(FIRST_NAME);
		addAttribute(MIDDLE_NAME);
		addAttribute(LAST_NAME);
		addAttribute(MOTHER_MAIDEN_NAME);
		addAttribute(BIRTH_DAY);
		addAttribute(TYPE);
		
	}

}
