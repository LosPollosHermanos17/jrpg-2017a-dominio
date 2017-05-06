package dominio;

/**
 * Establece, de acuerdo a la dificultad deseada, el conjunto de caracter�sticas deseadas para estos personajes
 * controlados en forma autom�tica.
 */
public class NonPlayableCharacter extends Peleable {

    private int defensa;
    private int nivel;
    private static final int DIFICULTADALEATORIA = -1;

    public NonPlayableCharacter(final String nombre, final int nivel, final int dificultadNPC) {
        this.setNombre(nombre);
        this.nivel = nivel;
        int dificultad;
        if (dificultadNPC == DIFICULTADALEATORIA) {
            dificultad = MyRandom.nextInt(3);
        } else {
            dificultad = dificultadNPC;
        }

        switch (dificultad) {
        case 0:
            this.setFuerza(10 + (nivel - 1) * 3);
            this.setSalud(30 + (nivel - 1) * 15);
            this.defensa = 2 + (nivel - 1) * 1;
            break;
        case 1:
            this.setFuerza(20 + (nivel - 1) * 6);
            this.setSalud(40 + (nivel - 1) * 20);
            this.defensa = 5 + (nivel - 1) * 2;
            break;
        case 2:
            this.setFuerza(30 + (nivel - 1) * 10);
            this.setSalud(50 + (nivel - 1) * 25);
            this.defensa = 4 + (nivel - 1) * 4;
            break;

        }
    }

    public int otorgarExp() {
        return this.nivel * 30;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(final int nivel) {
        this.nivel = nivel;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(final int defensa) {
        this.defensa = defensa;
    }

    /**
     * Permite atacar a otro personaje
     * @param atacado Personaje a atacar
     * @return Devuelve el daño efectivo infligido al personaje
     */

    public int atacar(final Peleable atacado) {
        if (MyRandom.nextDouble() <= 0.15) {
            return atacado.serAtacado((int) (this.getAtaque() * 1.5));
        } else {
            return atacado.serAtacado(this.getAtaque());
        }
    }

    /**
     * Permite que el personaje sea atacado
     * @param danio : Cantidad que indica el daño a infligir sobre el personaje
     * @return Devuelve el daño efectivo infligido al personaje
     */
    public int serAtacado(int danio) {
        if (MyRandom.nextDouble() >= 0.15) {
            danio -= this.getDefensa() / 2;
            if (danio > 0) {
                this.setSalud(this.getSalud() - danio);
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
        return false;
    }

    public void ganarExperiencia(final int exp) {

    }

    @Override
    public int getAtaque() {
        return this.getFuerza();
    }

    @Override
    public void setAtaque(final int ataque) {
        this.setFuerza(ataque);
    }
}
