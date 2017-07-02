package mensajeria;

import cliente.EscuchaMensajes;
import juego.Juego;

public class ComandoMensajeChat {
	private String from;
	private String to;
	private String message;
	private boolean isPrivate;
	
	
	public ComandoMensajeChat(String from, String to, boolean isPrivate, String message){
		this.from = from;
		this.to = to;
		this.message = message;
		this.isPrivate = isPrivate;
	}
	
	public void resolver(Object obj){
		PacketMessage message = (PacketMessage) obj;
		this.from = message.getFrom();
		this.to = message.getTo();
		this.message = message.getMessage();
		this.isPrivate = message.getStatus();
	}
}
