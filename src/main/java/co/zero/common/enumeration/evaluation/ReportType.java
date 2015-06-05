//=======================================================================
// ARCHIVO ReportType.java
// FECHA CREACIÓN: 9/05/2012
//=======================================================================
package co.zero.common.enumeration.evaluation;

/**
 * Enumeración que reune los tipos de reportes disponibles en evaluaciones
 * @author hernan
 */
public enum ReportType {
	//------- REPORTES DE COMPETENCIAS
	REPORT_360_JOB_COMPLIMENT_BY_QUALIFICATION_LEVEL,
	REPORT_360_DIVISION_COMPLIMENT_BY_QUALIFICATION_LEVEL,
	REPORT_360_COMPANY_COMPLIMENT_BY_QUALIFICATION_LEVEL,
	REPORT_360_DIVISION_AVG_BY_QUALIFICATION_LEVEL,
	REPORT_360_COMPANY_AVG_BY_QUALIFICATION_LEVEL,
	REPORT_360_COMPANY_AVG_BY_DIVISION,
	REPORT_360_PERSONAL_HUMAN_CAPITAL_SOLIDARIA,
	REPORT_360_PERSONAL_HUMAN_CAPITAL_GPZ,
	REPORT_360_PERSONAL_MASA_2013,
	REPORT_360_EVALUATION_GENERAL_STATE,
	REPORT_360_EVALUATION_RELATIONS_NOT_FINISHED,
	REPORT_360_EFICACIA_PERFORMANCE,
	REPORT_360_EFICACIA_COMPETENCES,
	REPORT_360_EFICACIA_PERFORMANCE_BY_COLLABORATORS,
	REPORT_360_HUMAN_CAPITAL_FUNDAMUJER,
	REPORT_360_HUMAN_CAPITAL_ASSESSMENT,
	REPORT_360_HUMAN_CAPITAL_OPTIMA,
	REPORT_360_PLAIN_QUESTIONNAIRE,
	REPORT_360_QUESTIONNAIRE_SIMPLE_BY_QUALIFICATION,
	REPORT_360_SARACHO,
	REPORT_360_PREFLEX,
	
	//------- REPORTES DE CLIMA
	//Reporte que obtiene los promedios de grupos de competencias x compañía
	REPORT_CLIMATE_COMPANY_BY_QUALIFICATION_GROUP,
	//Reporte que obtiene los promedios de grupos de competencias x división
	REPORT_CLIMATE_DIVISION_BY_QUALIFICATION_GROUP,
	//Reporte que obtiene los promedios de grupos de competencias x división, agrupando
	//adicionalmente por el nombre de la división hasta N nivels, para evitar mostrar
	//divisiones repetidas
	REPORT_CLIMATE_DIVISION_BY_QUALIFICATION_GROUP_AND_DIVISION_NAME,
	REPORT_2646,
	
	//------- REPORTES DE DESEMPEÑO (Reunen competencias + Kpis)
	REPORT_PERFORMANCE_BY_COMPANY,
	//Reporte de segmentación de potencial de Eficacia x División
	REPORT_POTENTIAL_BY_COMPANY,
	//Reporte de segmentación de potencial de Eficacia x Familia de Cargo
	REPORT_POTENTIAL_BY_EMPLOYMENT_LEVEL,
	//Reporte general de desempeño mas competencias de todas las personas en la empresa
	REPORT_PERFORMANCE_PLAIN_TOTAL,
	//Reporte general de desempeño agrupado por división
	REPORT_PERFORMANCE_EFICACIA_BY_DIVISION
}
