package dominio;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Define las caracteristicas y habilidades de un Personaje
 * @since 21/04/2017
 * @version 1.0
 */
public abstract class Personaje extends Peleable implements Serializable {

	protected int energia;
	protected int defensa;
	protected int ataque;
	protected int magia;
	protected String nombreRaza;
	protected int saludTope;
	protected int energiaTope;
	protected int destreza;
	protected int inteligencia;
	protected Casta casta;
	protected int x;
	protected int y;
	protected int experiencia;
	protected int nivel;
	protected int idPersonaje;
	protected Alianza clan = null;
	public static int[] tablaDeNiveles;
	protected String[] habilidadesRaza;

	/**
	 * Inicializa los valores correspondientes a cada nivel del personaje.
	 */
	public static void cargarTablaNivel() {
		Personaje.tablaDeNiveles = new int[101];
		Personaje.tablaDeNiveles[0] = 0;
		Personaje.tablaDeNiveles[1] = 0;
		for (int i = 2; i < 101; i++) {
			Personaje.tablaDeNiveles[i] = Personaje.tablaDeNiveles[i - 1] + 50;
		}
	}

	/**
	 * Inicializa un personaje con determinados parametros.
	 * @param nombre - nombre del personaje
	 * @param casta - casta a la cual pertenece
	 * @param id - numero identificador del personaje
	 * @param incSalud - incremento del atributo salud
	 * @param incEnergia - incremento del atributo energia
	 */
	public Personaje(final String nombre, final Casta casta, final int id, final int incSalud, final int incEnergia) {
		this(nombre, casta, id);
		saludTope += incSalud;
		energiaTope += incEnergia;
		salud = saludTope;
		energia = energiaTope;
	}

	/**
	 * Inicializa un objeto Personaje con determinados parametros.
	 * @param nombre - nombre del personaje
	 * @param casta - casta a la cual pertenece
	 * @param id - numero identificador del personaje
	 * @param incSalud - incremento del atributo salud
	 * @param incEnergia - incremento del atributo energia
	 * @param nomRaza - raza a la cual pertenece
	 * @param habilidadesRaza - array de tipo String que define las habilidades de la raza
	 */
	public Personaje(final String nombre, final Casta casta, final int id, final int incSalud, final int incEnergia,
			final String nomRaza, final String[] habilidadesRaza) {
		this(nombre, casta, id, incSalud, incEnergia);
		this.nombreRaza = nomRaza;
		this.habilidadesRaza = habilidadesRaza;
	}

	/**
	 * Inicializa un objeto Personaje con determinados parametros.
	 * @param nombre - nombre del personaje.
	 * @param casta - casta a la cual pertenece.
	 * @param id - numero identificador del personaje.
	 */
	public Personaje(final String nombre, final Casta casta, final int idPersonaje) {
		this.nombre = nombre;
		this.casta = casta;
		this.idPersonaje = idPersonaje;
		experiencia = 0;
		nivel = 1;
		fuerza = 10 + this.casta.getBonusFuerza();
		inteligencia = 10 + this.casta.getBonusInteligencia();
		destreza = 10 + this.casta.getBonusDestreza();

		x = 0;
		y = 0;

		this.inventario = new Inventario();
		saludTope = 100;
		energiaTope = 100;

		salud = saludTope;
		energia = energiaTope;

		ataque = calcularPuntosDeAtaque();
		defensa = calcularPuntosDeDefensa();
		magia = calcularPuntosDeMagia();
	}

	/**
	 * Asigna un objeto Personaje de acuerdo a determinados parametros.
	 * @param nombre - Nombre del personaje.
	 * @param salud - Cantidad de salud inicial del personaje [0 a 100].
	 * @param energia - Cantidad de energia inicial del personaje [0 a 100].
	 * @param fuerza - Cantidad de fuerza inicial del personaje.
	 * @param destreza - Cantidad de destreza inicial del personaje.
	 * @param inteligencia - Cantidad de inteligencia inicial del personaje.
	 * @param casta - Casta a la que el personaje deberá pertenecer.
	 * @param experiencia - Cantidad de experiencia inicial del personaje.
	 * @param nivel - Nivel inicial del personaje.
	 * @param idPersonaje - Identificador único del personaje.
	 * @param inventario - Inventario del personaje con los items que posee.
	 */
	public Personaje(final String nombre, final int salud, final int energia, final int fuerza, final int destreza,
			final int inteligencia, final Casta casta, final int experiencia, final int nivel, final int idPersonaje,
			final Inventario inventario) {

		this.inventario = inventario;
		this.saludTope = salud;
		this.energiaTope = energia;

		this.nombre = nombre;
		this.salud = this.saludTope + this.inventario.getBonusSalud();
		this.energia = this.energiaTope + this.inventario.getBonusEnergia();
		this.fuerza = fuerza;
		this.destreza = destreza;
		this.inteligencia = inteligencia;
		this.casta = casta;
		this.experiencia = experiencia;
		this.nivel = nivel;
		this.idPersonaje = idPersonaje;

		this.defensa = calcularPuntosDeDefensa() + this.inventario.getBonusDefensa();
		this.ataque = calcularPuntosDeAtaque() + this.inventario.getBonusAtaque();
		this.magia = calcularPuntosDeMagia() + this.inventario.getBonusMagia();
	}

	/**
	 * Inicializa un objeto Personaje de acuerdo a determinados parametros.
	 * @param nombre - nombre del personaje.
	 * @param salud - cantidad de salud inicial.
	 * @param energia - cantidad de energia incial.
	 * @param fuerza - cantidad de fuerza inicial.
	 * @param destreza - cantidad de destreza inicial.
	 * @param inteligencia - cantidad de inteligencia inicial.
	 * @param casta - casta a la cual pertenecera.
	 * @param experiencia - puntos de experiencia inicial.
	 * @param nivel - nivel inicial.
	 * @param idPersonaje - numero identificador de personaje.
	 * @param nomRaza - nombre de la raza a la cual pertenecera.
	 * @param habilidadesRaza - habilidades que tendra su raza.
	 * @param inventario - Inventario del personaje con los items que posee.
	 */
	public Personaje(final String nombre, final int salud, final int energia, final int fuerza, final int destreza,
			final int inteligencia, final Casta casta, final int experiencia, final int nivel, final int idPersonaje,
			final String nombreRaza, final String[] habilidadesRaza, final Inventario inventario) {
		this(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje,
				inventario);
		this.nombreRaza = nombreRaza;
		this.habilidadesRaza = habilidadesRaza;
	}

	/**
	 * Devuelve el nombre de la raza.
	 * @return nombre de la raza a la cual pertenece el personaje.
	 */
	public String getNombreRaza() {
		return nombreRaza;
	}

	/**
	 * Asigna el nombre de la raza.
	 * @param nombreRaza nombre de la raza a la cual pertenece el personaje.
	 */
	public void renombrarRaza(final String nombreRaza) {
		this.nombreRaza = nombreRaza;
	}

	/**
	 * Devuelve el ataque.
	 * @return ataque - cantidad de puntos de ataque.
	 */
	public int getAtaque() {
		return ataque;
	}

	/**
	 * Devuelve la magia.
	 * @return magia - cantidad de puntos de magia del personaje.
	 */
	public int getMagia() {
		return magia;
	}

	/**
	 * Asigna la magia.
	 * @param magia - cantidad de puntos de magia del personaje.
	 */
	public void incrementarMagia(final int magia) {
		this.magia += magia;
	}

	/**
	 * Devuelve el clan.
	 * @return la alianza a la cual pertenece el personaje.
	 */
	public Alianza getClan() {
		return clan;
	}

	/**
	 * Asigna el clan.
	 * @param clan - alianza a la cual pertenece el personaje.
	 */
	public void aliarce(final Alianza clan) {
		this.clan = clan;
		clan.agregarPersonaje(this);
	}

	/**
	 * Devuelve la energia.
	 * @return los puntos de energia del personaje.
	 */
	public int getEnergia() {
		return energia;
	}

	/**
	 * Devuelve las habilidades de la raza.
	 * @return habilidades de la raza a la cual pertenece el personaje.
	 */
	public String[] getHabilidadesRaza() {
		return habilidadesRaza;
	}

	/**
	 * Devuelve las habilidades de la Casta.
	 * @return habilidades de la casta a la cual pertenece el personaje.
	 */
	public String[] getHabilidadesCasta() {
		return casta.getHabilidadesCasta();
	}

	/**
	 * Devuelve la destreza.
	 * @return - puntos de destreza del personaje.
	 */
	public int getDestreza() {
		return destreza;
	}

	/**
	 * Devuelve la inteligencia.
	 * @return - puntos de inteligencia del personaje.
	 */
	public int getInteligencia() {
		return inteligencia;
	}

	/**
	 * Devuelve la Casta.
	 * @return - Casta del personaje.
	 */
	public Casta getCasta() {
		return casta;
	}

	/**
	 * Devuelve la experiencia.
	 * @return - experiencia del personaje.
	 */
	public int getExperiencia() {
		return experiencia;
	}

	/**
	 * Devuelve el nivel.
	 * @return - nivel del personaje.
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * Devuelve el idPersonaje.
	 * @return - identificacion del personaje.
	 */
	public int getIdPersonaje() {
		return idPersonaje;
	}

	/**
	 * Devuelve la defensa.
	 * @return - defensa del personaje.
	 */
	public int getDefensa() {
		return defensa;
	}

	/**
	 * Devuelve la saludTope.
	 * @return - salud maxima del personaje.
	 */
	public int getSaludTope() {
		return saludTope;
	}

	/**
	 * Devuelve la saludTope mas bonus de inventario.
	 * @return - salud maxima del personaje.
	 */
	public int getSaludTopeConBonus() {
		return saludTope + inventario.getBonusSalud();
	}

	/**
	 * Devuelve energiaTope.
	 * @return - energia maxima del personaje.
	 */
	public int getEnergiaTope() {
		return energiaTope;
	}

	/**
	 * Devuelve energiaTope mas bonus de inventario.
	 * @return - energia maxima del personaje.
	 */
	public int getEnergiaTopeConBonus() {
		return energiaTope + inventario.getBonusEnergia();
	}

	/**
	 * Permite atacar a otro personaje.
	 * @param atacado - Personaje a atacar.
	 * @return Devuelve el daño efectivo infligido al personaje.
	 */
	public int atacar(final Peleable atacado) {
		if (this.salud == 0) {
			return 0;
		}
		if (atacado.salud > 0) {
			if (this.random.nextDouble() <= this.casta.getProbabilidadGolpeCritico() + this.destreza / 1000) {
				return atacado.serAtacado(this.golpe_critico());
			} else {
				return atacado.serAtacado(this.ataque);
			}
		}
		return 0;
	}

	/**
	 * Devuelve el daño ocasionado por el realizar el golpe critico.
	 * @return daño ocasionado cuando el personaje realiza un golpe critico.
	 */
	public int golpe_critico() {
		return (int) (ataque * getCasta().getDañoCritico());
	}

	/**
	 * Indica si el personaje puede atacar.
	 * @return booleano que confirma si puede atacar.
	 */
	public boolean puedeAtacar() {
		return energia > 10;
	}

	/**
	 * Devuelve puntos de ataque incrementados segun la fuerza que posee el personaje.
	 * @return la cantidad de puntos de ataque.
	 */
	public int calcularPuntosDeAtaque() {
		return (int) (fuerza * 1.5);
	}

	/**
	 * Devuelve los puntos de defensa incrementados segun la destreza que posee el personaje.
	 * @return la cantidad de puntos de defensa.
	 */
	public int calcularPuntosDeDefensa() {
		return (int) (destreza);
	}

	/**
	 * Devuelve los puntos de magia incrementados segun la inteligencia que posee el personaje.
	 * @return la cantidad de puntos de magia.
	 */
	public int calcularPuntosDeMagia() {
		return (int) (inteligencia * 1.5);
	}

	/**
	 * Restaura la salud del personaje hasta el tope.
	 */
	public void restablecerSalud() {
		salud = saludTope + inventario.getBonusSalud();
	}

	/**
	 * Restaura la energia del personaje hasta el tope.
	 */
	public void restablecerEnergia() {
		energia = energiaTope + inventario.getBonusEnergia();
	}

	/**
	 * Calcula el ataque, defensa y magia.
	 */
	public void modificarAtributos() {
		ataque = calcularPuntosDeAtaque();
		defensa = calcularPuntosDeDefensa();
		magia = calcularPuntosDeMagia();
	}

	/**
	 * Permite que el personaje sea atacado
	 * @param danio : Cantidad que indica el daño a infligir sobre el personaje
	 * @return Devuelve el daño efectivo infligido al personaje
	 */
	public int serAtacado(int danio) {
		if (this.random.nextDouble() >= getCasta().getProbabilidadEvitarDaño()) {
			danio -= defensa;
			if (danio > 0) {
				if (salud <= danio) {
					danio = salud;
					salud = 0;
				} else {
					salud = salud - danio;
				}
				return danio;
			}
			return 0;
		}
		return 0;
	}

	/**
	 * Permite que el personaje sea atacado anulando su defensa
	 * @param atacante : Es el personaje que ataca
	 * @return Devuelve si el atacante pudo atacar
	 */
	public boolean serAtacadoSinDefensa(final Personaje atacante) {
		int defensaOriginal = defensa;
		defensa = 0;
		if (serAtacado(atacante.ataque) > 0) {
			defensa = defensaOriginal;
			return true;
		}
		return false;
	}

	/**
	 * Permite que al personaje le roben salud
	 * @param danio : Cantidad que indica el daño que recibe el personaje
	 * @return Devuelve el daño efectivo infligido al personaje
	 */
	public int serRobadoSalud(int danio) {
		danio -= this.defensa;
		if (danio <= 0) {
			return 0;
		}
		if ((salud - danio) >= 0) {
			salud -= danio;
		} else {
			danio = salud;
			salud = 0;
		}
		return danio;
	}

	/**
	 * Permite que al personaje le quiten energia
	 * @param danio : Cantidad que indica el daño que recibe el personaje
	 * @return Devuelve el daño efectivo infligido al personaje
	 */
	public int serDesenergizado(int danio) {
		danio -= this.defensa;
		if (danio <= 0) {
			return 0;
		}
		if ((energia - danio) >= 0) {
			energia -= danio;
		} else {
			danio = energia;
			energia = 0;
		}
		return danio;
	}

	/**
	 * Permite que al personaje le den salud.
	 * @param salud : Cantidad que indica la saluda a agregar.
	 */
	public void serCurado(final int salud) {
		if (this.salud + salud <= this.saludTope + this.inventario.getBonusSalud()) {
			this.salud += salud;
		} else {
			this.salud = this.saludTope + this.inventario.getBonusSalud();
		}
	}

	/**
	 * Permite que al personaje le den salud.
	 * @param aliado : Personaje que le va a dar salud.
	 * @return true si puede ser curado.
	 */
	public boolean serCurado(final Personaje aliado) {
		this.serCurado(aliado.calcularPuntosDeMagia());
		return true;
	}

	/**
	 * Permite que al personaje le roben salud y energia.
	 * @param atacante : Es el personaje que ataca.
	 * @return true si pudo ser robado y desenergizado
	 */
	public boolean serRobadoYDesenergizado(final Personaje atacante) {
		int energiaRobada = serDesenergizado(atacante.calcularPuntosDeMagia());
		int saludRobada = serRobadoSalud(atacante.calcularPuntosDeMagia() / 2);
		atacante.serEnergizado(energiaRobada);
		atacante.serCurado(saludRobada);
		return true;
	}

	/**
	 * Permite que al personaje le den energia.
	 * @param energia :Cantidad que indica la energia a agregar.
	 */
	public void serEnergizado(final int energia) {
		if (this.energia + energia <= this.energiaTope + this.inventario.getBonusEnergia()) {
			this.energia += energia;
		} else {
			this.energia = this.energiaTope + this.inventario.getBonusEnergia();
		}
	}

	/**
	 * Crea una alianza entre personajes.
	 * @param nombreAlianza : Nombre que identificara la nueva alinza.
	 */
	public void crearAlianza(final String nombreAlianza) {
		clan = new Alianza(nombreAlianza);
		clan.agregarPersonaje(this);
	}

	/**
	 * Elimina un personaje de la alianza.
	 */
	public void salirDeAlianza() {
		if (clan != null) {
			clan.eliminarPersonaje(this);
			clan = null;
		}
	}

	/**
	 * Ingresa un nuevo personaje a la alianza.
	 * @param nuevoAliado : Personaje a ingresar.
	 * @return true si pudo ser añadido.
	 */
	public boolean aliar(final Personaje nuevoAliado) {

		if (this.clan == null) {
			Alianza a = new Alianza("Alianza 1");
			this.clan = a;
			a.agregarPersonaje(this);
		}

		if (nuevoAliado.clan == null) {
			nuevoAliado.clan = this.clan;
			this.clan.agregarPersonaje(nuevoAliado);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Asigna puntos de Skill a un personaje.
	 * @param fuerza : Fuerza a asignar.
	 * @param destreza : Destreza a incrementar.
	 * @param inteligencia : Inteligencia a incrementar.
	 */
	public void AsignarPuntosSkills(final int fuerza, final int destreza, final int inteligencia) {
		final int maxSkill = 200;
		if (this.fuerza + fuerza <= maxSkill) {
			this.fuerza += fuerza;
		}
		if (this.destreza + destreza <= maxSkill) {
			this.destreza += destreza;
		}
		if (this.inteligencia + inteligencia <= maxSkill) {
			this.inteligencia += inteligencia;
		}
		modificarAtributos();
	}

	/**
	 * Aumenta el nivel de un personaje cuando su experiencia es igual a 100.
	 */
	public void subirNivel() {

		int acumuladorExperiencia = 0;
		final int experienciaMaxima = 100;
		final int salud = 25;
		final int energia = 20;

		if (nivel == experienciaMaxima) {
			return;
		}

		while (nivel != experienciaMaxima
				&& (experiencia >= Personaje.tablaDeNiveles[nivel + 1] + acumuladorExperiencia)) {
			acumuladorExperiencia += Personaje.tablaDeNiveles[nivel + 1];
			nivel++;
			modificarAtributos();
			saludTope += salud;
			energiaTope += energia;
		}
		experiencia -= acumuladorExperiencia;
	}

	/**
	 * Verifica si un personaje aumenta su nivel.
	 * @param experiencia : Experiencia recibida.
	 * @return true si sube de nivel.
	 */
	public boolean ganarExperiencia(final int experiencia) {
		this.experiencia += experiencia;

		if (this.experiencia >= Personaje.tablaDeNiveles[this.nivel + 1]) {
			subirNivel();
			return true;
		}
		return false;
	}

	/**
	 * Otorga experiencia a un personaje.
	 * @return el nivel multiplicado por la experiencia obtenida.
	 */
	public int otorgarExp() {
		final int exp = 40;
		return this.nivel * exp;
	}

	/**
	 * Sobreescritura del metodo de objetos Clone.
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 * Verifica la distancia entre dos personajes.
	 * @param p : Personaje a conocer distancia.
	 * @return distancia entre los personajes
	 */
	public double distanciaCon(final Personaje p) {
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}

	/**
	 * Define la habilidad1 del personaje.
	 * @param atacado : Personaje a ser atacado.
	 * @return habilidad dependiendo del personaje atacado.
	 */
	public boolean habilidadCasta1(final Peleable atacado) {
		return getCasta().habilidad1(this, atacado);
	}

	/**
	 * Define la habilidad2 del personaje.
	 * @param atacado : Personaje a ser atacado.
	 * @return habilidad dependiendo del personaje atacado.
	 */
	public boolean habilidadCasta2(final Peleable atacado) {
		return getCasta().habilidad2(this, atacado);
	}

	/**
	 * Define la habilidad3 del personaje.
	 * @param atacado : Personaje a ser atacado.
	 * @return habilidad dependiendo del personaje atacado.
	 */
	public boolean habilidadCasta3(final Peleable atacado) {
		return getCasta().habilidad3(this, atacado);
	}

	/**
	 * Define habilidad de raza.
	 * @param atacado : Personaje a ser atacado.
	 * @return true si obtiene habilidad.
	 */
	public abstract boolean habilidadRaza1(Peleable atacado);

	/**
	 * Define habilidad2 de raza.
	 * @param atacado : Personaje a ser atacado.
	 * @return true si obtiene habilidad.
	 */
	public abstract boolean habilidadRaza2(Peleable atacado);

	/**
	 * Determina si tiene la energia necesaria para realizar una determinada accion.
	 * @param consumo - cantidad de energia a consumir.
	 * @return true si tiene la energia necesaria; false en caso contrario.
	 */
	public boolean tieneEnergia(int consumo) {
		if (energia > consumo)
			return true;
		else
			return false;
	}

	/**
	 * Decrementa el atributo <b>energia</b> segun la cantidad recibida por parametro.
	 * @param decremento - cantidad de energia a decrementar.
	 */
	public void consumirEnergia(int decremento) {
		energia -= decremento;
	}

	/**
	 * Aumenta el atributo <b>defensa</b> segun la cantidad recibida por parametro.
	 * @param incremento - cantidad de defensa a incrementar.
	 */
	public void aumentarDefensa(int incremento) {
		defensa += incremento;
	}

	/**
	 * Actualiza los atributos del personaje.
	 */
	public void actualizarAtributos(HashMap<String, Integer> atributos) {
		this.salud = atributos.get("salud");
		this.energia = atributos.get("energia");
	}

	public void incrementarAtaque(int incAtaque) {
		this.ataque += incAtaque;
	}

	/**
	 * Asigna al personaje un item ganado
	 */
	public boolean ganarItem(Item item) {
		if (this.inventario != null)
			return this.inventario.agregarItem(item);
		return false;
	}
}
