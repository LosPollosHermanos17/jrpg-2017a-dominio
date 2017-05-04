package dominio;

import java.io.Serializable;

/**
 * Define las caracteristicas y habilidades de un Personaje
 * 
 * @since 21/04/2017
 * @version 1.0
 */
public abstract class Personaje extends Peleable implements Serializable {
	// campos de la clase
	
	protected int energia;
	protected int defensa;// depende de la destreza
	protected int ataque;// depende de la fuerza
	protected int magia;// depende de la inteligencia

	
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

	public String[] getHabilidadesRaza() {
		return habilidadesRaza;
	}

	public String[] getHabilidadesCasta() {
		return casta.getHabilidadesCasta();
	}

	/**
	 * Inicializa los valores correspondientes a cada nivel para su posterior
	 * acceso.
	 */
	public static void cargarTablaNivel() {
		Personaje.tablaDeNiveles = new int[101];
		Personaje.tablaDeNiveles[0] = 0;
		Personaje.tablaDeNiveles[1] = 0;
		for (int i = 2; i < 101; i++)
			Personaje.tablaDeNiveles[i] = Personaje.tablaDeNiveles[i - 1] + 50;
	}

	public Personaje(String nombre, Casta casta, int id, int incSalud, int incEnergia) {
		this(nombre, casta, id);
		saludTope += incSalud;
		energiaTope += incEnergia;
		this.setSalud(saludTope);
		energia = energiaTope;
	}
	
	public Personaje(String nombre, Casta casta, int id, int incSalud, int incEnergia, String nomRaza, String[] habilidadesRaza) {
		this(nombre,casta,id,incSalud,incEnergia);
		this.nombreRaza = nomRaza;
		this.habilidadesRaza = habilidadesRaza;
	}
	
	public Personaje(String nombre, Casta casta, int id) {
		this.setNombre(nombre);
		this.casta = casta;
		this.idPersonaje = id;
		experiencia = 0;
		nivel = 1;
		this.setFuerza(10);
		inteligencia = 10;
		destreza = 10;
		if (casta instanceof Guerrero)
			this.setFuerza(this.getFuerza()+5);
		if (casta instanceof Hechicero)
			inteligencia += 5;
		if (casta instanceof Asesino)
			destreza += 5;

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
	 * Asigna un objeto Humano y lo inicializa de acuerdo a los parámetros
	 * recibidos
	 * 
	 * @param nombre
	 *            : Nombre del personaje.
	 * @param salud
	 *            : Cantidad de salud inicial del personaje [0 a 100].
	 * @param energia
	 *            : Cantidad de energia inicial del personaje [0 a 100].
	 * @param fuerza
	 *            : Cantidad de fuerza inicial del personaje.
	 * @param destreza
	 *            : Cantidad de destreza inicial del personaje.
	 * @param inteligencia
	 *            : Cantidad de inteligencia inicial del personaje.
	 * @param casta
	 *            : Casta a la que el personaje deberá pertenecer.
	 * @param experiencia
	 *            : Cantidad de experiencia inicial del personaje.
	 * @param nivel
	 *            : Nivel inicial del personaje.
	 * @param idPersonaje
	 *            : Identificador único del personaje
	 */
	public Personaje(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel, int idPersonaje) {

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

	public Personaje(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel, int idPersonaje, String nomRaza, String habilidadesRaza[]) {
		this(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		this.nombreRaza = nomRaza;
		this.habilidadesRaza = habilidadesRaza;
	}
	public String getNombreRaza() {
		return nombreRaza;
	}

	public void setNombreRaza(String nombreRaza) {
		this.nombreRaza = nombreRaza;
	}

	

	

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getMagia() {
		return magia;
	}

	public void setMagia(int magia) {
		this.magia = magia;
	}

	public Alianza getClan() {
		return clan;
	}

	public void setClan(Alianza clan) {
		this.clan = clan;
		clan.añadirPersonaje(this);
	}

	

	

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	

	

	public int getDestreza() {
		return destreza;
	}

	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public Casta getCasta() {
		return casta;
	}

	public void setCasta(Casta casta) {
		this.casta = casta;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getIdPersonaje() {
		return idPersonaje;
	}

	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getSaludTope() {
		return saludTope;
	}

	public void setSaludTope(int saludTope) {
		this.saludTope = saludTope;
	}

	public int getEnergiaTope() {
		return energiaTope;
	}

	public void setEnergiaTope(int energiaTope) {
		this.energiaTope = energiaTope;
	}

	/**
	 * Permite atacar a otro personaje
	 * 
	 * @param atacado
	 *            Personaje a atacar
	 * @return Devuelve el daño efectivo infligido al personaje
	 */
	public int atacar(Peleable atacado) {
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

	public int golpe_critico() {
		return (int) (this.ataque * this.getCasta().getDañoCritico());
	}

	public boolean puedeAtacar() {
		return energia > 10;
	}

	public int calcularPuntosDeAtaque() {
		return (int) (this.getFuerza() * 1.5);
	}

	public int calcularPuntosDeDefensa() {
		return (int) (this.getDestreza());
	}

	public int calcularPuntosDeMagia() {
		return (int) (this.getInteligencia() * 1.5);
	}

	public void restablecerSalud() {
		this.setSalud(this.saludTope);
	}

	public void restablecerEnergia() {
		this.energia = this.energiaTope;
	}

	public void modificarAtributos() {
		this.ataque = this.calcularPuntosDeAtaque();
		this.defensa = this.calcularPuntosDeDefensa();
		this.magia = this.calcularPuntosDeMagia();
	}

	

	/**
	 * Permite que el personaje sea atacado
	 * 
	 * @param daño
	 *            : Cantidad que indica el daño a infligir sobre el personaje
	 * @return Devuelve el daño efectivo infligido al personaje
	 */
	public int serAtacado(int daño) {
		if (MyRandom.nextDouble() >= this.getCasta().getProbabilidadEvitarDaño()) {
			daño -= this.defensa;
			if (daño > 0) {
				if (this.getSalud() <= daño) {
					daño = this.getSalud();
					this.setSalud(0);
				} else {
					this.setSalud(this.getSalud()-daño);
				}
				return daño;
			}
			return 0;
		}
		return 0;
	}

	public int serRobadoSalud(int daño) {
		daño -= this.defensa;
		if (daño <= 0)
			return 0;
		if ((this.getSalud() - daño) >= 0)
			this.setSalud(this.getSalud()-daño);
		else {
			daño = this.getSalud();// le queda menos salud que el daño inflingido
			this.setSalud(0);
		}
		return daño;
	}

	public int serDesernegizado(int daño) {
		daño -= this.defensa;
		if (daño <= 0)
			return 0;
		if ((energia - daño) >= 0)
			energia -= daño;
		else {
			daño = energia;// le queda menos energia que el daño inflingido
			energia = 0;
		}
		return daño;
	}

	public void serCurado(int salud) {
		if ((this.getSalud() + salud) <= this.saludTope)
			this.setSalud(this.getSalud()+salud);
		else
			this.setSalud(this.saludTope);
	}

	public void serEnergizado(int energia) {
		if ((this.energia + energia) <= this.energiaTope)
			this.energia += energia;
		else
			this.energia = this.energiaTope;
	}

	public void crearAlianza(String nombre_alianza) {
		this.clan = new Alianza(nombre_alianza);
		this.clan.añadirPersonaje(this);
	}

	public void salirDeAlianza() {
		if (this.clan != null) {
			this.clan.eliminarPersonaje(this);
			this.clan = null;
		}
	}

	public boolean aliar(Personaje nuevo_aliado) {
		if (this.clan == null) {
			Alianza a = new Alianza("Alianza 1");
			this.clan = a;
			a.añadirPersonaje(this);
		}

		if (nuevo_aliado.clan == null) {
			nuevo_aliado.clan = this.clan;
			this.clan.añadirPersonaje(nuevo_aliado);
			return true;
		} else
			return false;
	}

	public void AsignarPuntosSkills(int fuerza, int destreza, int inteligencia) {
		if (this.getFuerza() + fuerza <= 200)
			this.setFuerza(this.getFuerza()+fuerza);
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

	public boolean ganarExperiencia(int exp) {
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

	public double distanciaCon(Personaje p) {
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}

	public boolean habilidadCasta1(Peleable atacado) {
		return this.getCasta().habilidad1(this, atacado);
	}

	public boolean habilidadCasta2(Peleable atacado) {
		return this.getCasta().habilidad2(this, atacado);
	}

	public boolean habilidadCasta3(Peleable atacado) {
		return this.getCasta().habilidad3(this, atacado);
	}

	public abstract boolean habilidadRaza1(Peleable atacado);

	public abstract boolean habilidadRaza2(Peleable atacado);
}
