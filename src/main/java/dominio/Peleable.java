package dominio;

/**
 * Define las caracteristicas y habilidades de un objeto Peleable
 * @since 21/04/2017
 * @version 1.0
 */
public abstract class Peleable {
    private int salud;
    private int fuerza;
    private String nombre;

    public abstract int serAtacado(int danio);

    public int getSalud() {
        return this.salud;
    }

    public void setSalud(final int salud) {
        this.salud = salud;
    }

    public int getFuerza() {
        return this.fuerza;
    }

    public void setFuerza(final int fuerza) {
        this.fuerza = fuerza;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public void despuesDeTurno() {

    }

    public abstract boolean serAtacadoSinDefensa(Personaje atacante);
    
    public abstract boolean serCurado(Personaje caster);
    
    public abstract boolean serRobadoYDesenergizado(Personaje atacante);

    public abstract int atacar(Peleable atacado);

    public abstract int otorgarExp();

    public abstract int getAtaque();

    public abstract void setAtaque(int ataque);

    public boolean estaVivo() {
        return salud > 0;
    }

}
