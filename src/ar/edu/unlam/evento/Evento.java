package ar.edu.unlam.evento;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Evento {
Integer id;
String titulo;
String descripcion;
String codigoDeAcceso;
ArrayList<Invitacion>invitaciones;

//1 solo organizador y varios participantes
HashSet<Usuario>usuariosDelEvento;

HashSet<Show>presentaciones;

public Evento(Integer id, String titulo, String descripcion, String codigoDeAcceso) {
	super();
	this.id = id;
	this.titulo = titulo;
	this.descripcion = descripcion;
	this.codigoDeAcceso = codigoDeAcceso;
	this.usuariosDelEvento= new HashSet<>();
	this.invitaciones= new ArrayList<>();
	this.presentaciones= new HashSet<>();
}

@Override
public int hashCode() {
	return Objects.hash(id);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Evento other = (Evento) obj;
	return Objects.equals(id, other.id);
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public String getCodigoDeAcceso() {
	return codigoDeAcceso;
}

public void setCodigoDeAcceso(String codigoDeAcceso) {
	this.codigoDeAcceso = codigoDeAcceso;
}

public ArrayList<Invitacion> getInvitaciones() {
	return invitaciones;
}

public void setInvitaciones(ArrayList<Invitacion> invitaciones) {
	this.invitaciones = invitaciones;
}

public HashSet<Usuario> getUsuariosDelEvento() {
	return usuariosDelEvento;
}

public void setUsuariosDelEvento(HashSet<Usuario> usuariosDelEvento) {
	this.usuariosDelEvento = usuariosDelEvento;
}

public HashSet<Show> getPresentaciones() {
	return presentaciones;
}

public void setPresentaciones(HashSet<Show> presentaciones) {
	this.presentaciones = presentaciones;
}

public void agregarUsuario(Usuario usuarioAagregar, String codigoDeAcceso2, Usuario usuarioOrganizador) throws Exception {
	verificarQueElUsuarioSeaUnOrganizador(usuarioOrganizador);
	verificarQueElCodigoDeAccesoSeaElDelEvento(codigoDeAcceso2);
	this.usuariosDelEvento.add(usuarioAagregar);
	registrarInvitacion(1,usuarioAagregar,16062024,TipoOperacion.enviada);
	
}

private void registrarInvitacion(int id, Usuario usuarioAagregar, int fecha, TipoOperacion operacion) {
	invitaciones.add(new Invitacion(id, usuarioAagregar, fecha, operacion));
	
}

private void verificarQueElCodigoDeAccesoSeaElDelEvento(String codigoDeAcceso2) throws Exception {
	if(!(this.codigoDeAcceso.equals(codigoDeAcceso2))) {
		throw new Exception("Codigo De Acceso Incorrecto");
	}
	
}

private void verificarQueElUsuarioSeaUnOrganizador(Usuario usuarioOrganizador) throws Exception {
	if(!(usuarioOrganizador instanceof Organizador)) {
		throw new Exception("El usuario No Puede agregar Pq No es Un organizador");
	}
	
}

public Usuario buscarUsuario(Integer idParticipante) throws Exception {
	// TODO Auto-generated method stub
	for (Usuario usuario : usuariosDelEvento) {
		if(usuario.getId().equals(idParticipante)) {
			return usuario;
		}
	}
	throw new Exception("El usuario jamas fue agregado");
}

public void agregarPresentacion(Usuario usuarioQueAgrega, Show presentacion, String codigoDeAcceso2) throws Exception {
	verificarQueElUsuarioSeaUnOrganizador(usuarioQueAgrega);
	verificarQueElCodigoDeAccesoSeaElDelEvento(codigoDeAcceso2);
	if(!(this.presentaciones.add(presentacion))) {
		throw new Exception("Presentacion Duplicada");
	};
	registrarInvitacion(2, usuarioQueAgrega, 16062024,TipoOperacion.enviada);
	
}

public Show buscarShow(Integer idPresentacion) throws Exception {
	for (Show presentacion : presentaciones) {
		if(presentacion.getId().equals(idPresentacion)) {
			return presentacion;
		}
	}
	throw new Exception("Show no encontrado");
	
}

public void confirmarPresentacion(Integer idPresentacion, String codigoDeAcceso2, Usuario organizador) throws Exception {
	verificarQueElUsuarioSeaUnOrganizador(organizador);
	verificarQueElCodigoDeAccesoSeaElDelEvento(codigoDeAcceso2);
	Show presentacion=buscarPresentacion(idPresentacion);
	presentacion.setSePresentara(true);
	registrarInvitacion(3, organizador, 16062024, TipoOperacion.confirmo);
	
}

private Show buscarPresentacion(Integer idPresentacion) throws Exception {
for (Show presentacion : presentaciones) {
	if(presentacion.getId().equals(idPresentacion)) {
		return presentacion;
	}
}
	throw new Exception("Presentacion No Encontrada en el evento");
}




}
