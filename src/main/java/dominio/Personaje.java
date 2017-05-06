package dominio;

import java.io.Serializable;

/**
 * Define las caracteristicas y habilidades de un Personaje
 * 
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
	public static int tablaDeNiveles[];
	protected String[] habilidadesRaza;

	/**
	 * Inicializa los valores correspondientes a cada nivel del personaje.
	 */
	public static void cargarTablaNivel() {
		Personaje.tablaDeNiveles = new int[101];
		Personaje.tablaDeNiveles[0] = 0;
		Personaje.tablaDeNiveles[1] = 0;
		for (int i = 2; i < 101; i++)
			Personaje.tablaDeNiveles[i] = Personaje.tablaDeNiveles[i - 1] + 50;
	}

	/**
	 * Inicializa un personaje con determinados parametros.
	 * 
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
		this.setSalud(saludTope);
		energia = energiaTope;
	}

	/**
	 * Inicializa un objeto Personaje con determinados parametros.
	 * 
	 * @param nombre - nombre del personaje
	 * @param casta - casta a la cual pertenece
	 * @param id - numero identificador del personaje
	 * @param incSalud - incremento del atributo salud
	 * @param incEnergia - incremento del atributo energia
	 * @param nomRaza - raza a la cual pertenece
	 * @param habilidadesRaza - array de tipo String que define las habilidades
	 *        de la raza
	 */
	public Personaje(final String nombre, final Casta casta, final int id, final int incSalud, final int incEnergia,
			final String nomRaza, final String[] habilidadesRaza) {
		this(nombre, casta, id, incSalud, incEnergia);
		this.nombreRaza = nomRaza;
		this.habilidadesRaza = habilidadesRaza;
	}

	/**
	 * Inicializa un objeto Personaje con determinados parametros.
	 * 
	 * @param nombre - nombre del personaje.
	 * @param casta - casta a la cual pertenece.
	 * @param id - numero identificador del personaje.
	 */
	public Personaje(final String nombre, final Casta casta, final int id) {
		this.setNombre(nombre);
		this.casta = casta;
		this.idPersonaje = id;
		experiencia = 0;
		nivel = 1;
		this.setFuerza(10);
		inteligencia = 10;
		destreza = 10;

		// if (casta instanceof Guerrero)
		// this.setFuerza(this.getFuerza()+5);
		// if (casta instanceof Hechicero)
		// inteligencia += 5;
		// if (casta instanceof Asesino)
		// destreza += 5;

		// se utiliza este llamado en reemplazo del trozo
		// de codigo anterior:
		casta.inicializarPersonaje(this);

		x = 0;
		y = 0;
		saludTope = 100;
		energiaTope = 100;

		this.setSalud(saludTope);
		energia = energiaTope;

		ataque = this.calcularPuntosDeAtaque();
		defensa = this.calcularPuntosDeDefensa();
		magia = this.calcularPuntosDeMagia();
	}

	/**
	 * Asigna un objeto Personaje de acuerdo a determinados parametros.
	 * 
	 * @param nombre - Nombre del personaje.
	 * @param salud - Cantidad de salud inicial del personaje [0 a 100].
	 * @param energia - Cantidad de energia inicial del personaje [0 a 100].
	 * @param fuerza - Cantidad de fuerza inicial del personaje.
	 * @param destreza - Cantidad de destreza inicial del personaje.
	 * @param inteligencia - Cantidad de inteligencia inicial del personaje.
	 * @param casta - Casta a la que el personaje deberá pertenecer.
	 * @param experiencia - Cantidad de experiencia inicial del personaje.
	 * @param nivel - Nivel inicial del personaje.
	 * @param idPersonaje - Identificador único del personaje
	 */
	public Personaje(final String nombre, final int salud, final int energia, final int fuerza, final int destreza,
			final int inteligencia, final Casta casta, final int experiencia, final int nivel, final int idPersonaje) {

		this.setNombre(nombre);
		this.setSalud(salud);
		this.energia = energia;
		this.setFuerza(fuerza);
		this.destreza = destreza;
		this.inteligencia = inteligencia;
		this.casta = casta;
		this.experiencia = experiencia;
		this.nivel = nivel;

		this.saludTope = this.getSalud();
		this.energiaTope = this.energia;

		this.idPersonaje = idPersonaje;
		this.defensa = this.calcularPuntosDeDefensa();
		this.ataque = this.calcularPuntosDeAtaque();
		this.magia = this.calcularPuntosDeMagia();
	}

	/**
	 * Inicializa un objeto Personaje de acuerdo a determinados parametros.
	 * 
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
	 */
	public Personaje(final String nombre, final int salud, final int energia, final int fuerza, final int destreza,
			final int inteligencia, final Casta casta, final int experiencia, final int nivel, final int idPersonaje,
			final String nomRaza, final String habilidadesRaza[]) {
		this(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		this.nombreRaza = nomRaza;
		this.habilidadesRaza = habilidadesRaza;
	}

	/**
	 * Devuelve el nombre de la raza.
	 * 
	 * @return nombre de la raza a la cual pertenece el personaje.
	 */
	public String getNombreRaza() {
		return nombreRaza;
	}

	/**
	 * Asigna el nombre de la raza.
	 * 
	 * @param nombreRaza nombre de la raza a la cual pertenece el personaje.
	 */
	public void setNombreRaza(final String nombreRaza) {
		this.nombreRaza = nombreRaza;
	}

	/**
	 * Devuelve el ataque.
	 * 
	 * @return ataque - cantidad de puntos de ataque.
	 */
	public int getAtaque() {
		return ataque;
	}

	/**
	 * Asigna el ataque.
	 * 
	 * @param ataque - cantidad de puntos de ataque.
	 */
	public void setAtaque(final int ataque) {
		this.ataque = ataque;
	}

	/**
	 * Devuelve la magia.
	 * 
	 * @return magia - cantidad de puntos de magia del personaje.
	 */
	public int getMagia() {
		return magia;
	}

	/**
	 * Asigna la magia.
	 * 
	 * @param magia - cantidad de puntos de magia del personaje.
	 */
	public void setMagia(final int magia) {
		this.magia = magia;
	}

	/**
	 * Devuelve el clan.
	 * 
	 * @return la alianza a la cual pertenece el personaje.
	 */
	public Alianza getClan() {
		return clan;
	}

	/**
	 * Asigna el clan.
	 * 
	 * @param clan - alianza a la cual pertenece el personaje.
	 */
	public void setClan(final Alianza clan) {
		this.clan = clan;
		clan.añadirPersonaje(this);
	}

	/**
	 * Devuelve la energia.
	 * 
	 * @return los puntos de energia del personaje.
	 */
	public int getEnergia() {
		return energia;
	}

	/**
	 * Asigna la energia.
	 * 
	 * @param energia - puntos de energia del personaje.
	 */
	public void setEnergia(final int energia) {
		this.energia = energia;
	}

	/**
	 * Devuelve las habilidades de la raza.
	 * 
	 * @return habilidades de la raza a la cual pertenece el personaje.
	 */
	public String[] getHabilidadesRaza() {
		return habilidadesRaza;
	}

	/**
	 * Devuelve las habilidades de la Casta.
	 * 
	 * @return habilidades de la casta a la cual pertenece el personaje.
	 */
	public String[] getHabilidadesCasta() {
		return casta.getHabilidadesCasta();
	}

	/**
	 * Devuelve la destreza.
	 * 
	 * @return - puntos de destreza del personaje.
	 */
	public int getDestreza() {
		return destreza;
	}

	/**
	 * Asigna la destreza.
	 * 
	 * @param destreza - puntos de destreza del personaje.
	 */
	public void setDestreza(final int destreza) {
		this.destreza = destreza;
	}

	/**
	 * Devuelve la inteligencia.
	 * 
	 * @return - puntos de inteligencia del personaje.
	 */
	public int getInteligencia() {
		return inteligencia;
	}

	/**
	 * Asigna la inteligencia.
	 * 
	 * @param inteligencia - puntos de inteligencia del personaje.
	 */
	public void setInteligencia(final int inteligencia) {
		this.inteligencia = inteligencia;
	}

	/**
	 * Devuelve la Casta.
	 * 
	 * @return - Casta del personaje.
	 */
	public Casta getCasta() {
		return casta;
	}

	/**
	 * Asigna la Casta.
	 * 
	 * @param casta - Casta del personaje.
	 */
	public void setCasta(final Casta casta) {
		this.casta = casta;
	}

	/**
	 * Devuelve la experiencia.
	 * 
	 * @return - experiencia del personaje.
	 */
	public int getExperiencia() {
		return experiencia;
	}

	/**
	 * Asigna la experiencia
	 * 
	 * @param experiencia - experiencia del personaje.
	 */
	public void setExperiencia(final int experiencia) {
		this.experiencia = experiencia;
	}

	/**
	 * Devuelve el nivel.
	 * 
	 * @return - nivel del personaje.
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * Asigna el nivel.
	 * 
	 * @param nivel - nivel del personaje.
	 */
	public void setNivel(final int nivel) {
		this.nivel = nivel;
	}

	/**
	 * Devuelve el idPersonaje.
	 * 
	 * @return - identificacion del personaje.
	 */
	public int getIdPersonaje() {
		return idPersonaje;
	}

	/**
	 * Asigna el idPersonaje.
	 * 
	 * @param idPersonaje - identificacion del personaje.
	 */
	public void setIdPersonaje(final int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	/**
	 * Devuelve la defensa.
	 * 
	 * @return - defensa del personaje.
	 */
	public int getDefensa() {
		return defensa;
	}

	/**
	 * Asigna la defensa.
	 * 
	 * @param defensa - defensa del personaje.
	 */
	public void setDefensa(final int defensa) {
		this.defensa = defensa;
	}

	/**
	 * Devuelve la saludTope.
	 * 
	 * @return - salud maxima del personaje.
	 */
	public int getSaludTope() {
		return saludTope;
	}

	/**
	 * Asigna la saludTope.
	 * 
	 * @param saludTope - saluda maxima del personaje.
	 */
	public void setSaludTope(final int saludTope) {
		this.saludTope = saludTope;
	}

	/**
	 * Devuelve energiaTope.
	 * 
	 * @return - energia maxima del personaje.
	 */
	public int getEnergiaTope() {
		return energiaTope;
	}

	/**
	 * Asigna la energiaTope.
	 * 
	 * @param energiaTope - energia maxima del personaje.
	 */
	public void setEnergiaTope(final int energiaTope) {
		this.energiaTope = energiaTope;
	}

	/**
	 * Permite atacar a otro personaje.
	 * 
	 * @param atacado - Personaje a atacar.
	 * @return Devuelve el daño efectivo infligido al personaje.
	 */
	public int atacar(final Peleable atacado) {
		if (this.getSalud() == 0)
			return 0;
		if (atacado.getSalud() > 0) {
			if (MyRandom.nextDouble() <= this.casta.getProbabilidadGolpeCritico() + this.destreza / 1000) {
				return atacado.serAtacado(this.golpe_critico());
			} else {
				return atacado.serAtacado(this.ataque);
			}
		}
		return 0;
	}

	/**
	 * Devuelve el daño ocasionado por el realizar el golpe critico.
	 * 
	 * @return daño ocasionado cuando el personaje realiza un golpe critico.
	 */
	public int golpe_critico() {
		return (int) (this.ataque * this.getCasta().getDañoCritico());
	}

	/**
	 * Indica si el personaje puede atacar.
	 * 
	 * @return booleano que confirma si puede atacar.
	 */
	public boolean puedeAtacar() {
		return energia > 10;
	}

	/**
	 * Devuelve puntos de ataque incrementados segun la fuerza que posee el
	 * personaje.
	 * 
	 * @return la cantidad de puntos de ataque.
	 */
	public int calcularPuntosDeAtaque() {
		return (int) (this.getFuerza() * 1.5);
	}

	/**
	 * Devuelve los puntos de defensa incrementados segun la destreza que posee
	 * el personaje.
	 * 
	 * @return la cantidad de puntos de defensa.
	 */
	public int calcularPuntosDeDefensa() {
		return (int) (this.getDestreza());
	}

	/**
	 * Devuelve los puntos de magia incrementados segun la inteligencia que
	 * posee el personaje.
	 * 
	 * @return la cantidad de puntos de magia.
	 */
	public int calcularPuntosDeMagia() {
		return (int) (this.getInteligencia() * 1.5);
	}

	/**
	 * Restaura la salud del personaje hasta el tope.
	 */
	public void restablecerSalud() {
		this.setSalud(this.saludTope);
	}

	/**
	 * Restaura la energia del personaje hasta el tope.
	 */
	public void restablecerEnergia() {
		this.energia = this.energiaTope;
	}

	/**
	 * 
	 */
	public void modificarAtributos() {
		this.ataque = this.calcularPuntosDeAtaque();
		this.defensa = this.calcularPuntosDeDefensa();
		this.magia = this.calcularPuntosDeMagia();
	}

	/**
	 * Permite que el personaje sea atacado
	 * 
	 * @param danio : Cantidad que indica el daño a infligir sobre el personaje
	 * @return Devuelve el daño efectivo infligido al personaje
	 */
	public int serAtacado(final int danio) {
		if (MyRandom.nextDouble() >= this.getCasta().getProbabilidadEvitarDaño()) {
			danio -= this.defensa;
			if (danio > 0) {
				if (this.getSalud() <= danio) {
					danio = this.getSalud();
					this.setSalud(0);
				} else {
					this.setSalud(this.getSalud() - danio);
				}
				return danio;
			}
			return 0;
		}
		return 0;
	}

	public int serRobadoSalud(final int danio) {
		danio -= this.defensa;
		if (danio <= 0)
			return 0;
		if ((this.getSalud() - danio) >= 0)
			this.setSalud(this.getSalud() - danio);
		else {
			danio = this.getSalud();// le queda menos salud que el daño
									// inflingido
			this.setSalud(0);
		}
		return danio;
	}

	public int serDesernegizado(final int danio) {
		danio -= this.defensa;
		if (danio <= 0)
			return 0;
		if ((energia - danio) >= 0)
			energia -= danio;
		else {
			danio = energia;// le queda menos energia que el daño inflingido
			energia = 0;
		}
		return danio;
	}

	public void serCurado(final int salud) {
		if ((this.getSalud() + salud) <= this.saludTope)
			this.setSalud(this.getSalud() + salud);
		else
			this.setSalud(this.saludTope);
	}

	public void serEnergizado(final int energia) {
		if ((this.energia + energia) <= this.energiaTope)
			this.energia += energia;
		else
			this.energia = this.energiaTope;
	}

	public void crearAlianza(final String nombreAlianza) {
		this.clan = new Alianza(nombreAlianza);
		this.clan.añadirPersonaje(this);
	}

	public void salirDeAlianza() {
		if (this.clan != null) {
			this.clan.eliminarPersonaje(this);
			this.clan = null;
		}
	}

	public boolean aliar(final Personaje nuevoAliado) {
		if (this.clan == null) {
			Alianza a = new Alianza("Alianza 1");
			this.clan = a;
			a.añadirPersonaje(this);
		}

		if (nuevoAliado.clan == null) {
			nuevoAliado.clan = this.clan;
			this.clan.añadirPersonaje(nuevoAliado);
			return true;
		} else
			return false;
	}

	public void AsignarPuntosSkills(final int fuerza, final int destreza, final int inteligencia) {
		if (this.getFuerza() + fuerza <= 200)
			this.setFuerza(this.getFuerza() + fuerza);
		if (this.destreza + destreza <= 200)
			this.destreza += destreza;
		if (this.inteligencia + inteligencia <= 200)
			this.inteligencia += inteligencia;
		this.modificarAtributos();
	}

	public void subirNivel() {

		int acumuladorExperiencia = 0;
		if (this.nivel == 100) {
			return;
		}
		while (this.nivel != 100
				&& (this.experiencia >= Personaje.tablaDeNiveles[this.nivel + 1] + acumuladorExperiencia)) {
			acumuladorExperiencia += Personaje.tablaDeNiveles[this.nivel + 1];
			this.nivel++;
			this.modificarAtributos();
			this.saludTope += 25;
			this.energiaTope += 20;
		}
		this.experiencia -= acumuladorExperiencia;
	}

	public boolean ganarExperiencia(final int exp) {
		this.experiencia += exp;

		if (experiencia >= Personaje.tablaDeNiveles[this.nivel + 1]) {
			subirNivel();
			return true;
		}
		return false;
	}

	public int otorgarExp() {
		return this.nivel * 40;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public double distanciaCon(final Personaje p) {
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}

	public boolean habilidadCasta1(final Peleable atacado) {
		return this.getCasta().habilidad1(this, atacado);
	}

	public boolean habilidadCasta2(final Peleable atacado) {
		return this.getCasta().habilidad2(this, atacado);
	}

	public boolean habilidadCasta3(final Peleable atacado) {
		return this.getCasta().habilidad3(this, atacado);
	}

	public abstract boolean habilidadRaza1(Peleable atacado);

	public abstract boolean habilidadRaza2(Peleable atacado);
}
