//=======================================================================
// ARCHIVO ReportItemSelection.java
// FECHA CREACIÓN: 2014/02/19
//=======================================================================
package co.zero.common.enumeration.innpulsa;

/**
 * Enumeración que reune los tipos de items que se pueden seleccionar para un reporte
 * NOTA: Estos items podrán tener un significado diferente dependiendo del contexto del reporte,
 * es decir, un item de tipo empleado puede significar en un reporte EvaluatedId mientras que en otro EvaluatorId
 * @author Hernán Tenjo
 * @version 1.0
 */
public enum ReportItemSelectionType {
	EMPLOYEE_ITEM,
	JOB_ITEM,
	DIVISION_ITEM
}
