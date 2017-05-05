package dominio;

/**
 * Define las habilidades de un Asesino.
 * @author desconocido
 *
 */

public class Asesino extends Casta {

    /**
     * Cantidad de Habilidades del Asesino.
     */
    private final int cantHabilidades = 3;

    /**
     * Cantidad de energia minima necesaria para ejecutar una hablidad.
     */
    private final int cantEnergiaMinima = 10;

    /**
     * Maxima probabilidad de evitar daño.
     */
    private final double probEvitarDanioMaxima = 0.5;

    /**
     * Probabilidad de evitar daño a incrementar con la
     * ejecución de la habilidad.
     */
    private final double probEvitarDanioAIncrementar = 0.15;

    /**
     * Constructor por defecto.
     * Inicializa un objeto Asesino asignandole las habilidades.
     */
    public Asesino() {
        super();
        this.nombreCasta = "Asesino";
        habilidadesCasta = new String[cantHabilidades];
        habilidadesCasta[0] = "Golpe Critico";
        habilidadesCasta[1] = "Aumentar Evasion";
        habilidadesCasta[2] = "Robar";
    }

    /**
     * Inicializa un objeto Asesino con los parametros especificados,
     * utilizando el constructor de la clase padre "Casta".
     * @param probCrit - probabilidad de golpe crítico inicial.
     * @param evasion - probabilidad de evitar daño inicial.
     * @param danioCrit - cantidad de daño al realizar un golpe crítico.
     */
    public Asesino(final double probCrit, final double evasion,
                      final double danioCrit) {
        super(probCrit, evasion, danioCrit);
        this.nombreCasta = "Asesino";
    }

   /**
    * Define la habilidad1 para la clase Asesino.
    * @param caster - objeto de tipo Personaje atacante.
    * @param atacado - objeto que implementa Peleable atacado.
    * @return true si se puede realizar el ataque o false en caso contrario
    */
    public boolean habilidad1(final Personaje caster, final Peleable atacado) {
      if (caster.getEnergia() > cantEnergiaMinima) {
        caster.setEnergia(caster.getEnergia() - cantEnergiaMinima);
        if (atacado.serAtacado((int) (caster.ataque
                 * caster.getCasta().getDañoCritico())) > 0) {
          return true;
        }
      }
      return false;
     }

    /**
     * Define la habilidad2 para la clase Asesino.
     * @param caster - objeto de tipo Personaje que aumenta su
     *                 probabilidad de evasión.
     * @param atacado - objeto que implementa Peleable atacado.
     * @return true si el personaje pudo aumentar su probabilidad de evasion o
     *         false en caso contrario.
     */
     public boolean habilidad2(final Personaje caster, final Peleable atacado) {
       if (caster.getEnergia() > cantEnergiaMinima) {
         caster.setEnergia(caster.getEnergia() - cantEnergiaMinima);
         if (this.getProbabilidadEvitarDaño()
                 + probEvitarDanioAIncrementar < probEvitarDanioMaxima) {
           this.probabilidadEvitarDaño += probEvitarDanioAIncrementar;
         } else {
         this.probabilidadEvitarDaño = probEvitarDanioMaxima;
         }
         return true;
       }
       return false;
     }

    /**
     * Permite que un personaje pueda robar a otro personaje.
     * @param caster - personaje que roba.
     * @param atacado - personaje robado.
     * @return false siempre.
     */
     public boolean habilidad3(final Personaje caster,
                              final Peleable atacado) {
       return false;
     }


     /**
      * Inicializa un Personaje de tipo Asesino,
      * incrementando su atributo <b>destreza</b>.
      * @param p - objeto Personaje a inicializar.
      */
     public void inicializarPersonaje(Personaje p)
     {
        p.setDestreza(p.getDestreza() + 5);
     }
}
