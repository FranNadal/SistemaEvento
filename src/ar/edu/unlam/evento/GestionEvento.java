package ar.edu.unlam.evento;

import java.util.HashSet;

public class GestionEvento {

	HashSet<Evento>eventos;
	HashSet<Usuario>usuarios;
	public GestionEvento() {
		super();
		this.eventos= new HashSet<>();
		this.usuarios= new HashSet<>();
	}
	public boolean registrarEvento(Evento evento) {
		// TODO Auto-generated method stub
		return eventos.add(evento);
	}
	public boolean registrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarios.add(usuario);
	}
	
	public Evento buscarEvento(Integer idEvento) throws Exception {
		for (Evento evento : eventos) {
			if(evento.getId().equals(idEvento)) {
				return evento;
			}
		}
		throw new Exception("Evento no encontrado");
		
	}
	public void agregarUsuarioAEvento(Integer idParticipante, Integer idEvento, String codigoDeAcceso, Integer idOrganizador) throws Exception {
	Evento evento=	buscarEvento(idEvento);
	Usuario usuarioAagregar=buscarUsuario(idParticipante);
	Usuario usuarioOrganizador=buscarUsuario(idOrganizador);
		
		evento.agregarUsuario(usuarioAagregar,codigoDeAcceso,usuarioOrganizador);
	}
	private Usuario buscarUsuario(Integer idParticipante) throws Exception {
		for (Usuario usuario : usuarios) {
			if(usuario.getId().equals(idParticipante)) {
				return usuario;
			}
		}
		throw new Exception("Usuario no encontrado");
	}
	
	
	public void agregarPresentacionAEvento(Show presentacion, Integer idOrganizador, Integer idEvento,String codigoDeAcceso) throws Exception {
	Evento evento=buscarEvento(idEvento);
	Usuario usuarioQueAgrega=buscarUsuario(idOrganizador);	
	evento.agregarPresentacion(usuarioQueAgrega,presentacion,codigoDeAcceso);
	}
	
	
	public Show buscarShow(Integer idEvento, Integer idPresentacion) throws Exception {
		Evento eventoEnElQueVoyABuscar=buscarEvento(idEvento);
		
		return eventoEnElQueVoyABuscar.buscarShow(idPresentacion);
	}
	public void confirmarPresentacion(Integer idPresentacion, Integer idEvento, String codigoDeAcceso,
			Integer idOrganizador) throws Exception {
		Evento evento = buscarEvento(idEvento);
		Usuario organizador= buscarUsuario(idOrganizador);
		evento.confirmarPresentacion(idPresentacion,codigoDeAcceso,organizador);
		
	}
	
	
	
}
