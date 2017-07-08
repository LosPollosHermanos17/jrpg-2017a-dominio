package mensajeria;

import java.io.Serializable;

/**
 * Clase padre de los demás Packets. Define comando y estado.
 * 
 * @author dmem2
 *
 */
public class Packet implements Serializable {

	private Command command;
	private boolean status;

	/**
	 * constructor por defecto.
	 */
	public Packet() {
	}

	/**
	 * constructor parametrizado.
	 * 
	 * @param command
	 *            Recibe el comando
	 */
	public Packet(Command command) {
		this.command = command;
	}

	/**
	 * Devuelve el comando.
	 * 
	 * @return Valor contenido del comando
	 */
	public Command getCommand() {
		return this.command;
	}

	/**
	 * Devuelve el estado.
	 * 
	 * @return Valor contenido del estado.
	 */
	public boolean getStatus() {
		return this.status;
	}

	/**
	 * método para forzar un comando
	 * 
	 * @param command
	 *            recibe el valor a setear
	 */
	public void setCommand(Command command) {
		this.command = command;
	}

	/**
	 * método para forzar un estado
	 * 
	 * @param command
	 *            recibe el valor a setear
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

}
