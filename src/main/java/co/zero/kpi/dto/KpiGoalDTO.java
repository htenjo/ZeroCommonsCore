package co.zero.kpi.dto;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import co.zero.common.dto.EntityDTO;
import co.zero.common.enumeration.GoalState;
import co.zero.hcm.dto.EmploymentDTO;
import co.zero.hcm.dto.ProcessDTO;
import co.zero.hcm.dto.ZoneDTO;

/**
 * Clase que define un objetivo de KPIs
 * 
 * @author Youlyn Chinome
 */
public class KpiGoalDTO extends EntityDTO{
	//Identificador requerido para la serialización
	private static final long serialVersionUID = 1L;
	//Nombre representativo del objetivo que se desea alcanzar
	private String name;
	//Breve descripción de lo que se desea realizar con el objetivo
	private String description;
	//Metrica con la que será evaluado el objetivo
	private KpiMetricGeneralDTO metric;
	//Padre del objetivo si este existe
	private KpiGoalDTO parent;
	//Ponderación de la colaboración del objetivo sobre el padre
	private double contributeWeight;
	//Atributo util para establecer el order del arbol padre/hijo
	private String position;
	//Esgtrategia a la que pertenece el objetivo
	private KpiStrategyDTO strategy;
	//Atributo utilitario que permite determinar facilmente si el
	//objetivo ya ha sido finalizado o se encuentra vigente
	private boolean finalized;
	//Cadena que contiene la expresion a evaluar para los reportes
	private String expression;
	// Employment dueño del objetivo
	private EmploymentDTO owner;
	//Comentario del ultimo cambio no aprobado
	private String lastFeedBack;
	//Estado de la solicitud del objetivo
	private GoalState goalState;
	//Lista de los employment asignados al objetivo
	private List<KpiGoalRelationDTO> assigned;
	//Ponderación del objetivo dentro de los objetivos del cargo
	private double weight;
	//Id alfanumerico unico por estrategia para los objetivos
	private String code;
	//Lista de las zonas a las que esta asociado el objetivo
	private Set<ZoneDTO> zones = new LinkedHashSet<ZoneDTO>();
	//Lista de los procesos asociados al objetivo
	private Set<ProcessDTO> processes = new LinkedHashSet<ProcessDTO>();;
	
	/**
	 * Metodo que permite obtener el nombre del objetivo
	 * @return El nombre asociado al objetivo
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo que permite modificar el nombre del objetivo
	 * @param name La nueva cadena que será usada como nombre del objetivo
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Metodo que permite obtener la descripción del objetivo
	 * @return La descripción configurada para el objetivo
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Metodo que permite modificar la descripción del objetivo
	 * @param description El nuevo texto descriptivo del objetivo
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Metodo que permite obtener la metrica con la que será evaluado el objetivo
	 * @return La métrica configurada para el objetivo
	 */
	public KpiMetricGeneralDTO getMetric() {
		return metric;
	}

	/**
	 * Metodo que permite modificar la metrica con la que será evaluado al objetivo
	 * @param metric La nueva metrica con la que será evaluado el objetivo
	 */
	public void setMetric(KpiMetricGeneralDTO metric){
		this.metric = metric;
	}
	
	/**
	 * Metodo que permite obtener el padre del objetivo
	 * @return El objetivo padre configurado para este objetivo
	 */
	public KpiGoalDTO getParent() {
		return parent;
	}

	/**
	 * Metodo que permite modificar el padrel del objetivo
	 * @param parent El nuevo padre del objetivo
	 */
	public void setParent(KpiGoalDTO parent) {
		this.parent = parent;
	}
	
	/**
	 * Metodo que permite obtener el porcentaje en el que la labor
	 * del hijo contribuye a la labor del padre
	 * @return Porcentaje de colaboración del hijo sobre el padre
	 */
	public double getContributeWeight() {
		return contributeWeight;
	}

	/**
	 * Método que permite modificar el porcentaje en el que la labor
	 * del hijo contribuye a la labor del padre
	 * @param contributeWeight El nuevo porcentaje de colaboración
	 */
	public void setContributeWeight(double contributeWeight){
		this.contributeWeight = contributeWeight;
	}
		
	/**
	 * Metodo que permite obtener la posición del objetivo en el arbol
	 * @return La posicion configurada para el arbol
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * Metodo que permite modificar la posicion del objetivo en el arbol
	 * @param position La nueva posición del objetivo en el arbol
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * Metodo que permite obtener la estrategia a la que pertenece el objetivo
	 * @return La la estrategia a la que pertenece el objetivo
	 */
	public KpiStrategyDTO getStrategy() {
		return strategy;
	}

	/**
	 * Metodo que permite modificar la estrategia a la que pertenece el objetivo
	 * @param strategy La nueva estrategia a la que pertenece el objetivo
	 */
	public void setStrategy(KpiStrategyDTO strategy){
		this.strategy = strategy;
	}
	
	/**
	 * Metodo que permite determinar si el objetivo de la relación
	 * ya ha sido finalizado
	 * @return True si el objetivo ya ha finalizado, False de lo contrario
	 */
	public boolean isFinalized() {
		return finalized;
	}
	
	/**
	 * Metodo que permite modificar el estado finalizado del objetivo de la relación
	 * @param finalized True si el objetivo ya finalizó, False de lo contrario
	 */
	public void setFinalized(boolean finalized) {
		this.finalized = finalized;
	}
	
	/**
	 * Metodo que permite obtener la expresion asociada a la estrategia
	 * @return La expresion configurada hasta el momento en la estrategia
	 */
	public String getExpression() {
		return expression;
	}
	
	/**
	 * Metodo que permite modificar la expresion asociada a la estrategia
	 * @param expression La nueva expresion asociada a la estrategia
	 */
	public void setExpression(String expression) {
		this.expression = expression;
	}

	/**
	 * Método que obtiene el {@link EmploymentDTO} dueño del objetivo
	 * @return El puesto de trabajo que creó el objetivo
	 */
	public EmploymentDTO getOwner() {
		return owner;
	}

	/**
	 * Método que modifica el {@link EmploymentDTO} dueño del objetivo
	 * @param owner El nuevo propietario del objetivo
	 */
	public void setOwner(EmploymentDTO owner) {
		this.owner = owner;
	}

	/**
	 * Metodo que permite obtener el comentario del ultimo cambio no aprobado
	 * @return El comentario del ultimo cambio no aprobado
	 */
	public String getLastFeedBack() {
		return lastFeedBack;
	}

	/**
	 * Metodo que permite modificar el comentario del ultimo cambio no aprobado
	 * @param lastFeedBack El comentario del ultimo cambio no aprobado
	 */
	public void setLastFeedBack(String lastFeedBack) {
		this.lastFeedBack = lastFeedBack;
	}
	
	/**
	 * Método que permite obtener el estado de la solicitud del objetivo
	 * @return El estado de la solicitud del objetivo
	 */
	public GoalState getGoalState() {
		return goalState;
	}
	
	/**
	 * Método que permite modificar el estado de la solicitud del objetivo
	 * @param goalState El estado de la solicitud del objetivo
	 */
	public void setGoalState(GoalState goalState) {
		this.goalState = goalState;
	}

	/**
	 * Metodo que permite obtener la lista de los employment asignados al objetivo
	 * @return Lista de los employment asignados al objetivo
	 */
	public List<KpiGoalRelationDTO> getAssigned() {
		return assigned;
	}

	/**
	 * Metodo que permite modificar los employment asignados al objetivo
	 * @param assigned Lista de los employment asignados al objetivo
	 */
	public void setAssigned(List<KpiGoalRelationDTO> assigned) {
		this.assigned = assigned;
	}
	
	/**
	 * Método que permite obtener la ponderación del objetivo para el cargo
	 * @return El porcentaje de impacto del objetivo sobre el cargo
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Método que permite modificar la ponderación del objetivo para el cargo
	 * @param weight El nuevo porcentaje de ponderación del objetivo sobre el cargo
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * Metodo que permite obtener el id alfanumerico unico por estrategia de los objetivos
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Metodo que permite modificar el id alfanumerico unico por estrategia de los objetivos
	 * @param code Id alfanumerico unico por estrategia de los objetivos
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Metodo que permite agregar un responsable a la lista
	 * @param assigned Nuevo responsable que se desea agregar
	 */
	public void addAssigned(KpiGoalRelationDTO assigned) {
		if (this.assigned == null) {
			this.assigned = new ArrayList<KpiGoalRelationDTO>();
		}
		
		assigned.setGoal(this);
		this.assigned.add(assigned);
	}
	
	/**
	 * Obtiene los nombres de quienes fueron asignados al objetivo separados por comas
	 * 
	 * @return
	 */
	public String getAllAssigned() {
		StringBuilder names = new StringBuilder();
		for (KpiGoalRelationDTO kpiGoalRelation : assigned) {
			if (kpiGoalRelation instanceof KpiGoalRelationEmploymentDTO) {
				names.append(((KpiGoalRelationEmploymentDTO) kpiGoalRelation).getEmployment().getEmployee().getFullName() + ", ");
			} else if (kpiGoalRelation instanceof KpiGoalRelationDivisionDTO) {
				names.append(((KpiGoalRelationDivisionDTO) kpiGoalRelation).getDivision().getName() + ", ");
			} else if (kpiGoalRelation instanceof KpiGoalRelationCompanyDTO) {
				names.append(((KpiGoalRelationCompanyDTO) kpiGoalRelation).getCompany().getName() + ", ");
			}
		}
		return names.length() > 0 ? names.toString().substring(0, names.length() - 2) : "";
	}
	
	/**
	 * Método que agrega una zona para asociarla al objetivo
	 * @param zone La zona que se desea asociar
	 */
	public void addZone(ZoneDTO zone){
		if(zones == null){
			zones = new LinkedHashSet<ZoneDTO>();
		}
		
		zones.add(zone);
	}

	/**
	 * Método que obtiene las zonas asociadas al objetivo
	 * @return Conjunto de las zonas que estan asociadas al objetivo
	 */
	public Set<ZoneDTO> getZones() {
		return zones;
	}

	/**
	 * Método que modifica las zonas que estan asociadas al objetivo
	 * @param zones El nuevo conjunto de las zonas que van a estar asociadas al objetivo
	 */
	public void setZones(Set<ZoneDTO> zones) {
		this.zones = zones;
	}
	
	/**
	 * Método que agrega un proceso para asociarlo al objetivo
	 * @param process El proceso que se desea asociar
	 */
	public void addProcess(ProcessDTO process){
		if(processes == null){
			processes = new LinkedHashSet<ProcessDTO>();
		}
		
		processes.add(process);
	}

	/**
	 * Método que obtiene los procesos asociados al objetivo
	 * @return Conjunto de los procesos que estan asociados al objetivo
	 */
	public Set<ProcessDTO> getProcesses() {
		return processes;
	}

	/**
	 * Método que modifica los procesos que estan asociados al objetivo
	 * @param processes El nuevo conjunto de los procesos que van a estar asociados al objetivo
	 */
	public void setProcesses(Set<ProcessDTO> processes) {
		this.processes = processes;
	}
	
	/*
	 * (non-Javadoc)
	 * @see co.zero.common.dto.EntityDTO#toString()
	 */
	@Override
	public String toString() {
		long metricId = this.metric == null ? 0 : this.metric.getId();
		long strategyId = this.strategy == null ? 0 : this.strategy.getId();
		long parentId = this.parent == null ? 0 : this.parent.getId();
		long ownerId = this.owner == null ? 0 : this.owner.getId();
		StringBuilder text = new StringBuilder(super.toString());
		text.append(" [name="+this.name+"]");
		text.append(" [description="+this.description+"]");
		text.append(" [metric="+metricId+"]");
		text.append(" [parent="+parentId+"]");
		text.append(" [contributeWeight="+this.contributeWeight+"]");
		text.append(" [position="+this.position+"]");
		text.append(" [strategy="+strategyId+"]");
		text.append(" [owner="+ownerId+"]");
		text.append(" [lastFeedBack="+this.lastFeedBack+"]");
		text.append(" [goalState="+this.goalState+"]");
		text.append(" [code="+this.code+"]");
		return text.toString();
	}
}