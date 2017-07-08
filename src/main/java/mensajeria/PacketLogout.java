package mensajeria;
/**
 * Packet utilizado para desconectar un personaje.
 * @author dmem2
 *
 */
public class PacketLogout extends Packet {
	private int id;
	private String username;
/**
 * genera un paquete en pos del deslogueo.
 * @param id Id del personaje
 * @param username nombre de usuario del personaje dentro del juego
 */
	public PacketLogout(int id, String username) {
		super(Command.LOGOUT);
		this.id = id;
		this.username = username;
	}
/**
 * @return Id del personaje deslogueando.
 */
	public int getId() {
		return id;
	}
/**
 * 
 * @param Id fuerza un valor de id de un personaje.
 */
	public void setId(int id) {
		this.id = id;
	}
/**
 * @return Devuelve el nombre de usuario del personaje.
 */
	public String getUsername() {
		return username;
	}
/**
 * @param username Nombre de usuario del personaje en cuestión.
 */
	public void setUsername(String username) {
		this.username = username;
	}

}
