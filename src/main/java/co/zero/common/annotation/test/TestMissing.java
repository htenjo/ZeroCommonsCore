//=======================================================================
// ARCHIVO TestMissing.java
// FECHA CREACIÓN: 10/06/2010
//=======================================================================
package co.zero.common.annotation.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotación que permite determinar cuáles pruebas hacen falta
 * para un método determinado. Se debe dejar detro de los paquetes a
 * exportar, ya que de lo contrario no seria reutilizable en los demás
 * proyectos
 * @author Hernán Tenjo
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value=ElementType.METHOD)
public @interface TestMissing {
	String[] values();
}