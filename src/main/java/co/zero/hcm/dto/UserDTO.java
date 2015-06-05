//=======================================================================
// ARCHIVO UserDTO.java
// FECHA CREACIÓN: Oct 1, 2009
//=======================================================================
package co.zero.hcm.dto;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import co.zero.common.enumeration.RoleLevel;

/**
 * Clase que reune la información básica de un usuario
 * que se ha autenticado en el sistema
 * @author Hernán Tenjo
 * @version 1.0
 */
public class UserDTO  extends HcmEntityDTO{
	//Identificador requerido para el proceso de serialización
	private static final long serialVersionUID = 1L;
	//Roles que tiene asociado el usuario
	private Set<RoleDTO> roles = new LinkedHashSet<RoleDTO>();
	//Variable que facilita el acceso a todos los privilegios del usuario
	private Set<PrivilegeDTO> privileges = new HashSet<PrivilegeDTO>();
	//Determina si la clave del usuario ha expirado
	private boolean passwordChangeRequiered;
	//Usuario con el que se ha logueado la persona
	private String username;
	//Password con el que se loguea la persona
	private String password;
	//Verificacion del password, especialmente util en la vista 
	private String passwordConfirm;
	//Determina si el usuario se encuentra activo en el sistema
	private boolean enabled;
	//Determina si la clave del usuario ha expirado
	private boolean passwordExpired;	
	//Determina si la cuenta del usuario ha sido bloqueada
	private boolean accountLocked;
	//Determina si la cuenta del usuario ha expirado
	private boolean accountExpired;	

	/**
	 * Determina si la clave ha expirado
	 * @return True Si la clave ha expirado, false de lo contrario 
	 */
	public boolean isPasswordChangeRequiered() {
		return passwordChangeRequiered;
	}

	/**
	 * Modifica el estado de vigencia de la clave
	 * @param passwordExpired True si la clave expiro, false de lo contrario
	 */
	public void setPasswordChangeRequiered(boolean passwordChangeRequiered) {
		this.passwordChangeRequiered = passwordChangeRequiered;
	}
	
	/**
	 * Permite obtener la cadena de validación del usuario
	 * @return La contraseña que tiene el usuario
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Permite modificar la clave que utilizar el usuario
	 * para ser validado en el sistema
	 * @param password El nuevo password
	 */
	public void setPassword(String password) {
		if(StringUtils.isBlank(password)){
			this.password = password;				
		}else{
			this.password = password.trim();
		}
	}

	/**
	 * Permite obtener los roles asociados al usuario
	 * @return Lista con los {@link RoleDTO} asociados
	 */
	public Set<RoleDTO> getRoles() {
		return roles;
	}
	
	/**
	 * Permite modificar la lista de roles que tiene
	 * asignado un usuario 
	 * @param role Nuevo conjunto de roles asignados
	 */
	public void setRoles(Set<RoleDTO> role) {
		this.roles = role;
		
		if(this.roles == null){
			this.roles = new HashSet<RoleDTO>();
		}
		
		privileges.clear();
		
		for(RoleDTO roleAux : roles){
			privileges.addAll(roleAux.getPrivileges());
		}		
	}

	/**
	 * Permite obtener la cadena con la que se identifico
	 * el usuario ante el sistema
	 * @return el username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Permite modificar la cadena con la que se identifica
	 * un usuario ante el sistema
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		if(StringUtils.isBlank(username)){
			this.username = null;
		}else{
			this.username = username.trim();
		}
	}	
	
	/**
	 * Metodo que permite agregar un nuevo rol al usuario
	 * @param role El nuevo rol que se desea agregar
	 */
	public void addRole(RoleDTO role){
		if(this.roles == null){
			this.roles = new HashSet<RoleDTO>();
		}
		
		this.roles.add(role);
		this.privileges.addAll(role.getPrivileges());
	}
	
	/**
	 * Metodo que permite obtener un rol del usuario
	 * si se conoce su nombre
	 * @param roleName Nombre del rol que se desea
	 * @return Null si el usuario no tiene asigando un rol
	 * con el nombre dado, el rol de lo contrario
	 */
	public RoleDTO getRoleByName(String roleName){
		RoleDTO roleDTO = null;
		
		for(RoleDTO dto : roles){
			if(dto.getName().equals(roleName)){
				roleDTO = dto;
				break;
			}
		}
		
		return roleDTO;
	}

	/**
	 * Determina si el usuario se encuentra activo en el sistema
	 * @return True si el usuario esta activo, false de lo contrario
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Permite modificar el estado del usuario
	 * @param enabled El nuevo estado del usuario True = Activo, False de lo contrario
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Determina si la clave ha expirado
	 * @return True Si la clave ha expirado, false de lo contrario 
	 */
	public boolean isPasswordExpired() {
		return passwordExpired;
	}

	/**
	 * Modifica el estado de vigencia de la clave
	 * @param passwordExpired True si la clave expiro, false de lo contrario
	 */
	public void setPasswordExpired(boolean passwordExpired) {
		this.passwordExpired = passwordExpired;
	}

	/**
	 * Determina si la cuenta del usuario ha expirado
	 * @return True si la cuenta ha expirado, False de lo contrario
	 */
	public boolean isAccountExpired() {
		return accountExpired;
	}

	/**
	 * Modifica el estado de vigencia de la cuenta
	 * @param accountExpired true si la cuenta ha expirado, false de lo contrario
	 */
	public void setAccountExpired(boolean accountExpired) {
		this.accountExpired = accountExpired;
	}

	/**
	 * Determina si el usuario ha sido bloqueado por alguna razon
	 * @return True si la cuenta esta bloqueada, false de lo contrario
	 */
	public boolean isAccountLocked() {
		return accountLocked;
	}

	/**
	 * Modifica el estado bloqueado del usuario
	 * @param accountLocked El nuevo estado del usuario, 
	 * True si esta bloqueado, false de lo contrario
	 */
	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}
	
	/**
	 * Metodo que permite obtener TODOS los privilegios que 
	 * tiene asociados el usuario según los roles asignados
	 * @return Conjunto de todos los roles asociados al usuario
	 */
	public Set<PrivilegeDTO> getPrivileges(){		
		return privileges;
	}

	/**
	 * Método que permite 
	 * @return the passwordConfirm
	 */
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	/**
	 * @param passwordConfirm the passwordConfirm to set
	 */
	public void setPasswordConfirm(String passwordConfirm) {
		if(StringUtils.isBlank(passwordConfirm)){
			this.passwordConfirm = passwordConfirm;
		}else{
			this.passwordConfirm = passwordConfirm.trim();
		}
	}
	

	/**
	 * Metodo que permite determinar el maximo nivel
	 * entre los roles asignados al usuario
	 * @return el maximo nivel encontrado entre los roles asignados
	 */
	public RoleLevel getMaxPrivilegedRole(){
		RoleLevel level = RoleLevel.NONE;
		
		for(RoleDTO role : roles){
			if(role.getLevel().hasMorePriority(level)){
				level = role.getLevel();
			}
		}
		
		return level;
	}

	/**
	 * Retorna una cadena de asteriscos que seran mostrados en las vistas
	 * 
	 * @return
	 */
	public String getPasswordNice() {
		StringBuilder passwordNice = new StringBuilder();
		if (password != null) {
			for (int i = 0; i < password.length(); i++) {
				passwordNice.append("*");
			}
			return passwordNice.toString();
		}
		return null;
	}
	
}