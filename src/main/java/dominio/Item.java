package dominio;

public class Item {

	private int id;	
	private String nombre;
	private int idTipo;
	private String tipo;
	private int bonoAtaque;
	private int bonoDefensa;
	private int bonoMagia;
	private int bonoSalud;
	private int bonoEnergia;

	private int fuerzaRequerida;
	private int destrezaRequerida;
	private int inteligenciaRequerida;

	public Item(int id, int idTipo, String tipo, String nombre, int bonoAtaque, int bonoDefensa, int bonoMagia, int bonoSalud, int bonoEnergia,
			int fuerzaRequerida, int destrezaRequerida, int inteligenciaRequerida) {

		this.id = id;
		this.idTipo = idTipo;
		this.tipo = tipo;
		this.nombre = nombre;
		this.bonoAtaque = bonoAtaque;
		this.bonoDefensa = bonoDefensa;
		this.bonoMagia = bonoMagia;
		this.bonoSalud = bonoSalud;
		this.bonoEnergia = bonoEnergia;

		this.fuerzaRequerida = fuerzaRequerida;
		this.destrezaRequerida = destrezaRequerida;
		this.inteligenciaRequerida = inteligenciaRequerida;
	}

	public int getId() {
		return id;
	}
	
	public int getIdTipo() {
		return idTipo;
	}
	
	public String getTipo() {
		return tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public int getBonoAtaque() {
		return bonoAtaque;
	}

	public int getBonoDefensa() {
		return bonoDefensa;
	}

	public int getBonoMagia() {
		return bonoMagia;
	}

	public int getBonoSalud() {
		return bonoSalud;
	}

	public int getBonoEnergia() {
		return bonoEnergia;
	}

	public int getFuerzaRequerida() {
		return fuerzaRequerida;
	}

	public int getDestrezaRequerida() {
		return destrezaRequerida;
	}

	public int getInteligenciaRequerida() {
		return inteligenciaRequerida;
	}
	
}
