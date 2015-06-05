//=======================================================================
// ARCHIVO EvaluationType.java
// FECHA CREACIÓN: 9/05/2011
//=======================================================================
package co.zero.common.enumeration.evaluation;

/**
 * Enumeración que contempla las diferentes evaluaciones
 * soportadas en el sistema
 * @author Hernán Tenjo
 * @version 1.0
 */
public enum EvaluationType {
	THREESIXTY(){
		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithQualificationsConfig()
		 */
		@Override
		public boolean isWithQualificationsConfig() {
			return true;
		}

		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithProfilesConfig()
		 */
		@Override
		public boolean isWithProfilesConfig() {
			return true;
		}

		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithQuestionTypesConfig()
		 */
		@Override
		public boolean isWithQuestionTypesConfig() {
			return true;
		}
		
		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithQuestionsConfig()
		 */
		@Override
		public boolean isWithQuestionsConfig() {
			return true;
		}

		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithEvaluatorsConfig()
		 */
		@Override
		public boolean isWithEvaluatorsConfig() {
			return true;
		}

		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithRelationsConfig()
		 */
		@Override
		public boolean isWithRelationsConfig() {
			return true;
		}

		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithTemplatesConfig()
		 */
		@Override
		public boolean isWithTemplatesConfig() {
			return false;
		}

		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithEvaluatedSelectionConfig()
		 */
		@Override
		public boolean isWithEvaluatedSelectionConfig() {
			return false;
		}
	},
	
	CLIMATE(){
		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithQualificationsConfig()
		 */
		@Override
		public boolean isWithQualificationsConfig() {
			return true;
		}

		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithProfilesConfig()
		 */
		@Override
		public boolean isWithProfilesConfig() {
			return false;
		}

		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithQuestionTypesConfig()
		 */
		@Override
		public boolean isWithQuestionTypesConfig() {
			return true;
		}

		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithQuestionsConfig()
		 */
		@Override
		public boolean isWithQuestionsConfig() {
			return true;
		}
		
		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithEvaluatorsConfig()
		 */
		@Override
		public boolean isWithEvaluatorsConfig() {
			return true;
		}
		
		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithRelationsConfig()
		 */
		@Override
		public boolean isWithRelationsConfig() {
			return false;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithTemplatesConfig()
		 */
		@Override
		public boolean isWithTemplatesConfig() {
			return true;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithEvaluatedSelectionConfig()
		 */
		@Override
		public boolean isWithEvaluatedSelectionConfig() {
			return false;
		}
	},
	
	INNOVATION_360(){
		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithQualificationsConfig()
		 */
		@Override
		public boolean isWithQualificationsConfig() {
			return true;
		}

		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithProfilesConfig()
		 */
		@Override
		public boolean isWithProfilesConfig() {
			return true;
		}

		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithQuestionTypesConfig()
		 */
		@Override
		public boolean isWithQuestionTypesConfig() {
			return true;
		}

		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithQuestionsConfig()
		 */
		@Override
		public boolean isWithQuestionsConfig() {
			return true;
		}
		
		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithEvaluatorsConfig()
		 */
		@Override
		public boolean isWithEvaluatorsConfig() {
			return true;
		}
		
		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithRelationsConfig()
		 */
		@Override
		public boolean isWithRelationsConfig() {
			return true;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithTemplatesConfig()
		 */
		@Override
		public boolean isWithTemplatesConfig() {
			return false;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithEvaluatedSelectionConfig()
		 */
		@Override
		public boolean isWithEvaluatedSelectionConfig() {
			return true;
		}
	},
	
	INNOVATION_ORGANIZATION(){

		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithQualificationsConfig()
		 */
		@Override
		public boolean isWithQualificationsConfig() {
			return true;
		}

		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithProfilesConfig()
		 */
		@Override
		public boolean isWithProfilesConfig() {
			return false;
		}

		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithQuestionTypesConfig()
		 */
		@Override
		public boolean isWithQuestionTypesConfig() {
			return true;
		}

		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithQuestionsConfig()
		 */
		@Override
		public boolean isWithQuestionsConfig() {
			return true;
		}
		
		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithEvaluatorsConfig()
		 */
		@Override
		public boolean isWithEvaluatorsConfig() {
			return true;
		}
		
		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithRelationsConfig()
		 */
		@Override
		public boolean isWithRelationsConfig() {
			return false;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithTemplatesConfig()
		 */
		@Override
		public boolean isWithTemplatesConfig() {
			return false;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithEvaluatedSelectionConfig()
		 */
		@Override
		public boolean isWithEvaluatedSelectionConfig() {
			return false;
		}
	},
	
	EVALUATION_2646(){
		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithQualificationsConfig()
		 */
		@Override
		public boolean isWithQualificationsConfig() {
			return true;
		}

		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithProfilesConfig()
		 */
		@Override
		public boolean isWithProfilesConfig() {
			return false;
		}

		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithQuestionTypesConfig()
		 */
		@Override
		public boolean isWithQuestionTypesConfig() {
			return true;
		}

		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithQuestionsConfig()
		 */
		@Override
		public boolean isWithQuestionsConfig() {
			return true;
		}
		
		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithEvaluatorsConfig()
		 */
		@Override
		public boolean isWithEvaluatorsConfig() {
			return true;
		}

		/* (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithRelationsConfig()
		 */
		@Override
		public boolean isWithRelationsConfig() {
			return false;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithTemplatesConfig()
		 */
		@Override
		public boolean isWithTemplatesConfig() {
			return true;
		}
		
		/*
		 * (non-Javadoc)
		 * @see co.zero.common.enumeration.evaluation.EvaluationType#isWithEvaluatedSelectionConfig()
		 */
		@Override
		public boolean isWithEvaluatedSelectionConfig() {
			return false;
		}
	};
	
	/**
	 * Método que permite determinar si el tipo de evaluación requiere
	 * la configuración de Qualifications, para su correcto desarrollo
	 * @return True si se requiere la configuración, false de lo contrario
	 */
	public abstract boolean isWithQualificationsConfig();
	
	/**
	 * Método que permite determinar si el tipo de evaluación requiere
	 * la configuración de Perfiles, para su correcto desarrollo
	 * @return True si se requiere la configuración, false de lo contrario
	 */
	public abstract boolean isWithProfilesConfig();
	
	/**
	 * Método que permite determinar si el tipo de evaluación requiere
	 * la configuración de tipos de pregunta, para su correcto desarrollo
	 * @return True si se requiere la configuración, false de lo contrario
	 */
	public abstract boolean isWithQuestionTypesConfig();
	
	/**
	 * Método que permite determinar si el tipo de evaluación requiere
	 * la configuración de tipos de pregunta, para su correcto desarrollo
	 * @return True si se requiere la configuración, false de lo contrario
	 */
	public abstract boolean isWithQuestionsConfig();
	
	/**
	 * Método que permite determinar si el tipo de evaluación requiere
	 * la configuración de evaluadores, para su correcto desarrollo
	 * @return True si se requiere la configuración, false de lo contrario
	 */
	public abstract boolean isWithEvaluatorsConfig();
	
	/**
	 * Método que permite determinar si el tipo de evaluación requiere
	 * la configuración de relaciones, para su correcto desarrollo
	 * @return True si se requiere la configuración, false de lo contrario
	 */
	public abstract boolean isWithRelationsConfig();
	
	/**
	 * Método que permite determinar si el tipo de evaluación admite la 
	 * configuración desde una plantilla o evaluación predeterminada
	 * @return True si se admite la configuración por medio de plantilla,
	 * False de lo contrario
	 */
	public abstract boolean isWithTemplatesConfig();
	
	/**
	 * Método que permite determinar si el tipo de evaluación admite la
	 * selección de evaluados por parte de los evaluadores, al momento de 
	 * ingresar a resolver una evaluación
	 * @return True si se permite la seleccion de evaluados, false de lo contrario
	 */
	public abstract boolean isWithEvaluatedSelectionConfig();
}