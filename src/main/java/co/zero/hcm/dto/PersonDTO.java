//=======================================================================
// ARCHIVO PersonDTO.java
// FECHA CREACIÓN: Oct 2, 2009
//=======================================================================
package co.zero.hcm.dto;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;

import co.zero.common.constant.GenericConstants;
import co.zero.common.enumeration.DocumentType;


/**
 * Clase que representa a una persona en el sistema. Una persona 
 * puede ser un empleado, un cliente o cualquiera que tenga 
 * acceso al sistema sin que necesariamente tenga una relación
 * institucional con la empresa
 * @author Hernán Tenjo
 * @version 1.0
 */
public class PersonDTO extends HcmEntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Numero de caracteres permitidos para el nombre
	private static final int NUMBER_CHARACTERS = 28;
	//Usuario asociado a la persona que tiene acceso al sistema
	private UserDTO user;
	//Compañía asociada a la persona
	private CompanyDTO company;
	
	//Atributos duplicados de los extrafields, requeridos por 
	//algunos módulos para poder tener acceso directo a la informacion
	private String firstName;
	private String middleName;
	private String lastName;
	private String motherMaidenName;
	private Date birthDay;
	private String email;
	private String documentNumber;
	private DocumentType documentType;

	/**
	 * Permite obtener el usuario asignado a la persona que 
	 * tiene acceso al sistema
	 * @return El {@link UserDTO}
	 */
	public UserDTO getUser() {
		return user;
	}

	/**
	 * Permite asignar un nuevo {@link UserDTO} a una persona
	 * que tiene acceso al sistema
	 * @param user El objeto con la información del nuevo usuario
	 * que será asignado a la persona
	 */
	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	/**
	 * Obtiene la compañia a la que esta asociada 
	 * la persona en el sistema
	 * @return La compañia
	 */
	public CompanyDTO getCompany() {
		return company;
	}

	/**
	 * Modifica la compañía a la que se encuentra 
	 * relacionada la persona
	 * @param company La nueva compañia de la persona
	 */
	public void setCompany(CompanyDTO company) {
		this.company = company;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the motherMaidenName
	 */
	public String getMotherMaidenName() {
		return motherMaidenName;
	}

	/**
	 * @param motherMaidenName the motherMaidenName to set
	 */
	public void setMotherMaidenName(String motherMaidenName) {
		this.motherMaidenName = motherMaidenName;
	}
	
	/**
	 * @return the birthDay
	 */
	public Date getBirthDay() {
		return birthDay;
	}

	/**
	 * @param birthDay the birthDay to set
	 */
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	/**
	 * Método que permite obtener el email principal de la persona
	 * @return La dirección de correo principal de la persona 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Método que permite modificar el email principal de la persona
	 * @param email Nueva dirección de correo principal de la persona
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Metodo que permite obtener el numero de documento de la persona
	 * @return
	 */
	public String getDocumentNumber() {
		return documentNumber;
	}

	/**
	 * Metodo que permite modificar el numero de documento de la persona
	 * @param documentNumber
	 */
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	/**
	 * Metodo que permite obtener el tipo de documento de la persona
	 * @return
	 */
	public DocumentType getDocumentType() {
		return documentType;
	}

	/**
	 * Metodo que permite modificar el tipo de documento de la persona
	 * @param documentType
	 */
	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}
	
	/**
	 * Metodo que permite obtener el primer nombre y el primer 
	 * apellido de una persona como una sóla cadena
	 * @return El nombre y apellido de la persona
	 */
	public String getNameAndLastName(){
		StringBuilder name = new StringBuilder();
		name.append(getFirstName());
		name.append(GenericConstants.SPACE);
		name.append(getLastName());
		return WordUtils.capitalizeFully(name.toString());
	}
	
	/**
	 * Metodo que permite obtener el nombre completo de la persona
	 * PrimerNombre + SegundoNombre + PrimerApellido + SegundoApellido
	 * @return El nombre completo de la persona
	 */
	public String getFullName(){
		return PersonDTO.getFullName(getFirstName(), getMiddleName(), getLastName(), getMotherMaidenName());
	}
	
	/**
	 * Metodo que permite obtener el nombre completo de la persona
	 * PrimerNombre + SegundoNombre + PrimerApellido + SegundoApellido
	 * @return El nombre completo de la persona
	 */
	public static String getFullName(String firstName, String middleName, String lastName, String motherMaidenName){
		StringBuilder fullName = new StringBuilder();
		fullName.append(firstName);
		
		if(!StringUtils.isBlank(middleName)){
			fullName.append(GenericConstants.SPACE);
			fullName.append(middleName);
		}
		
		if(!StringUtils.isBlank(lastName)){
			fullName.append(GenericConstants.SPACE);
			fullName.append(lastName);
		}
		
		if(!StringUtils.isBlank(motherMaidenName)){
			fullName.append(GenericConstants.SPACE);
			fullName.append(motherMaidenName);
		}
		
		return WordUtils.capitalizeFully(fullName.toString());
	}
	
	/**
	 * Obtiene el nombre completo de la persona, pero restringido a un numero de caracteres
	 * @return El nombre completo de la persona con puntos suspensivos en caso de pasar el 
	 * 			numero de caracteres permitidos
	 */
	public String getRestrictedFullName(){
		return StringUtils.abbreviate(getFullName(), NUMBER_CHARACTERS);
	}
	
	/*
	 * (non-Javadoc)
	 * @see co.zero.common.dto.EntityDTO#toString()
	 */
	@Override
	public String toString() {
		String aux = super.toString();
		aux += " [Nombre: " + this.getFullName();
		aux += "][Fecha de Nacimiento: " + this.birthDay;
		aux += "][Usuario: [" + (getUser() == null ? 
				GenericConstants.EMPTY_STRING : getUser().getUsername());
		aux += "][Email: [" + (this.getEmail() == null ? GenericConstants.EMPTY_STRING : this.getEmail()) + "]";
		return aux;
	}
}