package dominio;

/**
 * Define las caracteristicas y habilidades de un personaje Hechicero
 * 
 * @since 21/04/2017
 * @version 1.0
 */
public class Hechicero extends Casta {

	private final int ENERGIAMINIMA = 10;

	/**
	 * Asigna un objeto Hechicero y lo inicializa de acuerdo a los parámetros
	 * recibidos
	 * @param probCritico : Probabilidad de golpe critico.
	 * @param evasion : Valor de evasion.
	 * @param danioCritico : Valor del daño crítico.
	 */
	public Hechicero(double probCritico, double evasion, double danioCritico) {
		super(probCritico, evasion, danioCritico);
		this.nombreCasta = "Hechicero";
	}

	/**
	 * Asigna un objeto Hechicero y lo inicializa
	 */
	public Hechicero() {
		super();
		this.nombreCasta = "Hechicero";
		habilidadesCasta = new String[] { "Bola de Fuego", "Curar Aliado", "Robar Energia y Salud" };
	}

	/**
	 * Permite a un personaje pueda atacar usando una bola de fuego a otro
	 * @param caster : Es el personaje atacante
	 * @param atacado : Es el personaje que recibe el ataque.
	 * @return True si el personaje pudo atacar al otro personaje.
	 */
	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > ENERGIAMINIMA) {
			caster.setEnergia(caster.getEnergia() - ENERGIAMINIMA);
			if (atacado.serAtacado((int) (caster.calcularPuntosDeMagia() * 1.5)) > 0)
				return true;
		}
		return false;
	}

	/**
	 * Permite que un personaje pueda curar a otro personaje aliado
	 * @param caster : Es el personaje que cura
	 * @param aliado : Es el personaje a curar.
	 * @return True si el personaje pudo curar al otro personaje.
	 */
	public boolean habilidad2(Personaje caster, Peleable aliado) {
		if (caster.getEnergia() > ENERGIAMINIMA) {
			caster.setEnergia(caster.getEnergia() - ENERGIAMINIMA);
			if (aliado instanceof Personaje) {
				((Personaje) aliado).serCurado(caster.calcularPuntosDeMagia());
				return true;
			}
		}
		return false;
	}

	/**
	 * Permite que un personaje pueda robar energia y salud a otro personaje
	 * @param caster : Es el personaje que roba
	 * @param atacado : Es el personaje robado.
	 * @return True si el personaje pudo robar al otro personaje.
	 */
	public boolean habilidad3(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > ENERGIAMINIMA) {
			caster.setEnergia(caster.getEnergia() - ENERGIAMINIMA);
			if (atacado instanceof Personaje) {
				int energiaRobada = ((Personaje) atacado).serDesernegizado(caster.calcularPuntosDeMagia());
				int saludRobada = ((Personaje) atacado).serRobadoSalud(caster.calcularPuntosDeMagia() / 2);
				caster.serEnergizado(energiaRobada);
				caster.serCurado(saludRobada);
				return true;
			}

		}
		return false;
	}

	/**
	 * Inicializa un Personaje de tipo Hechicero, incrementando su atributo
	 * <b>inteligencia</b>.
	 * @param p - objeto Personaje a inicializar.
	 */
	public void inicializarPersonaje(Personaje p) {
		p.setInteligencia(p.getInteligencia() + 5);
	}
}
