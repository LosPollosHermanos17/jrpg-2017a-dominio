package mensajeria;
/**
 * Paquete que se encarga del flujo de mensajes del chat.
 * @author dmem2
 *
 */
public class PacketMessage extends Packet {
	private String from;
	private String to;
	private String message;
	private boolean isPrivate;
/**
 * 
 * @param from Emisor.
 * @param to Receptor.
 * @param message Contenido del mensaje.
 * @param isPrivate Establece condiciones de ser necesarias.
 */
	public PacketMessage(String from, String to, String message, boolean isPrivate) {
		super(Command.MESSAGE);
		this.from = from;
		this.to = to;
		this.message = message;
		this.isPrivate = isPrivate;
	}
/**
 * 
 * @return Contenido del mensaje.
 */
	public String getMessage() {
		return this.message;
	}
/**
 * 
 * @return Emisor.
 */
	public String getFrom() {
		return this.from;
	}
/**
 * 
 * @return Receptor.
 */
	public String getTo() {
		return this.to;
	}
/**
 * 
 * @return Devuelve true de ser privado.
 */
	public boolean isPrivate() {
		return this.isPrivate;
	}
}
