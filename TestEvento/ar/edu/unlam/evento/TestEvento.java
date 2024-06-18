package ar.edu.unlam.evento;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestEvento {

	@Test
	public void queSePuedaRegistrarUnEventoEnLaGestionConIdUnico() {
		GestionEvento gestion = new  GestionEvento();
		
		Integer idEvento=1;
		String titulo="Cumple fran";
		String descripcion="Cumpleaños";
		String codigoDeAcceso="uno";
		
		Evento evento= new Evento(idEvento,titulo,descripcion,codigoDeAcceso);
		Evento evento2= new Evento(1,titulo,descripcion,codigoDeAcceso);
		
		
		assertTrue(gestion.registrarEvento(evento));
		assertFalse(gestion.registrarEvento(evento2));
	}
	
	@Test
	public void queSePuedaRegistrarUnUsuarioOrganizadorYParticipanteEnLaGestion() {
		GestionEvento gestion = new  GestionEvento();
		
		Integer idOrganizador=1;
		String nombreOrganizador="fran";
		Integer idParticipante=2;
		String nombreParticipante="Rodrigo";
		
		Usuario usuarioOrganizador= new Organizador(idOrganizador,nombreOrganizador);
		Usuario usuarioParticipante= new Participante(idParticipante,nombreParticipante);
		
		assertTrue(gestion.registrarUsuario(usuarioOrganizador));
		assertTrue(gestion.registrarUsuario(usuarioParticipante));
		
	}
	@Test
	
	public void queUnUsuarioOrganizadorAgregueUnUsuarioAlaListaDeUsuarioDelEvento() throws Exception {
		GestionEvento gestion = new  GestionEvento();
		
		Integer idEvento=1;
		String titulo="Cumple fran";
		String descripcion="Cumpleaños";
		String codigoDeAcceso="uno";
		Evento evento= new Evento(idEvento,titulo,descripcion,codigoDeAcceso);
		gestion.registrarEvento(evento);
		
	
		
		Integer idOrganizador=1;
		String nombreOrganizador="fran";
		Integer idParticipante=2;
		String nombreParticipante="Rodrigo";
		Usuario usuarioOrganizador= new Organizador(idOrganizador,nombreOrganizador);
		Usuario usuarioParticipante= new Participante(idParticipante,nombreParticipante);
		gestion.registrarUsuario(usuarioOrganizador);
	
		evento.usuariosDelEvento.add(usuarioOrganizador);
		
		gestion.registrarUsuario(usuarioParticipante);
		
		
		gestion.agregarUsuarioAEvento(idParticipante,idEvento,codigoDeAcceso,idOrganizador);
		
		Usuario usuarioAgregado= evento.buscarUsuario(idParticipante);
		
		assertNotNull(usuarioAgregado);
	}
	
	
	@Test (expected = Exception.class)
	public void alAgregarUnUsuarioAUnEventoConCodigoDeEventoInvalidoSeLanceCodigoEventoIncorrectoException() throws Exception {
GestionEvento gestion = new  GestionEvento();
		
		Integer idEvento=1;
		String titulo="Cumple fran";
		String descripcion="Cumpleaños";
		String codigoDeAcceso="uno";
		Evento evento= new Evento(idEvento,titulo,descripcion,codigoDeAcceso);
		gestion.registrarEvento(evento);
		
	
		
		Integer idOrganizador=1;
		String nombreOrganizador="fran";
		Integer idParticipante=2;
		String nombreParticipante="Rodrigo";
		Usuario usuarioOrganizador= new Organizador(idOrganizador,nombreOrganizador);
		Usuario usuarioParticipante= new Participante(idParticipante,nombreParticipante);
		gestion.registrarUsuario(usuarioOrganizador);
	
		evento.usuariosDelEvento.add(usuarioOrganizador);
		
		gestion.registrarUsuario(usuarioParticipante);
		
		
		gestion.agregarUsuarioAEvento(idParticipante,idEvento,"ffafasa",idOrganizador);
	}
	
	@Test
	public void AgregarUnaPresentacionEnUnEvento() throws Exception {
GestionEvento gestion = new  GestionEvento();
		
		Integer idEvento=1;
		String titulo="Cumple fran";
		String descripcion="Cumpleaños";
		String codigoDeAcceso="uno";
		Evento evento= new Evento(idEvento,titulo,descripcion,codigoDeAcceso);
		gestion.registrarEvento(evento);
		
	
		
		Integer idOrganizador=1;
		String nombreOrganizador="fran";
		Integer idParticipante=2;
		String nombreParticipante="Rodrigo";
		Usuario usuarioOrganizador= new Organizador(idOrganizador,nombreOrganizador);
		Usuario usuarioParticipante= new Participante(idParticipante,nombreParticipante);
		gestion.registrarUsuario(usuarioOrganizador);
		evento.usuariosDelEvento.add(usuarioOrganizador);
		gestion.registrarUsuario(usuarioParticipante);
		gestion.agregarUsuarioAEvento(idParticipante,idEvento,codigoDeAcceso,idOrganizador);
		
		Integer idPresentacion=1;
		String nombreDelShow="Los Del Fuego";
		Boolean sePresentara=false;
		Show presentacion= new Show(idPresentacion, nombreDelShow, sePresentara);
		gestion.agregarPresentacionAEvento(presentacion,idOrganizador,idEvento,codigoDeAcceso);
		
		
		
		Show agregado=gestion.buscarShow(idEvento,idPresentacion);
		
		assertNotNull(agregado);
	}
	
	
	@Test (expected = Exception.class)
	public void alAgregarUnaPresentacionDuplicadaEnUnEventoSeLanceUnaPresentacionDuplicadaException() throws Exception{
		GestionEvento gestion = new  GestionEvento();
		
		Integer idEvento=1;
		String titulo="Cumple fran";
		String descripcion="Cumpleaños";
		String codigoDeAcceso="uno";
		Evento evento= new Evento(idEvento,titulo,descripcion,codigoDeAcceso);
		gestion.registrarEvento(evento);
		
	
		
		Integer idOrganizador=1;
		String nombreOrganizador="fran";
		Integer idParticipante=2;
		String nombreParticipante="Rodrigo";
		Usuario usuarioOrganizador= new Organizador(idOrganizador,nombreOrganizador);
		Usuario usuarioParticipante= new Participante(idParticipante,nombreParticipante);
		gestion.registrarUsuario(usuarioOrganizador);
		evento.usuariosDelEvento.add(usuarioOrganizador);
		gestion.registrarUsuario(usuarioParticipante);
		gestion.agregarUsuarioAEvento(idParticipante,idEvento,codigoDeAcceso,idOrganizador);
		
		Integer idPresentacion=1;
		String nombreDelShow="Los Del Fuego";
		Boolean sePresentara=false;
		Show presentacion= new Show(idPresentacion, nombreDelShow, sePresentara);
		
		
		gestion.agregarPresentacionAEvento(presentacion,idOrganizador,idEvento,codigoDeAcceso);
		gestion.agregarPresentacionAEvento(presentacion,idOrganizador,idEvento,codigoDeAcceso);
		}
	
	@Test
	
	public void  confirmarPresentacionDeUnEvento() throws Exception {
GestionEvento gestion = new  GestionEvento();
		
		Integer idEvento=1;
		String titulo="Cumple fran";
		String descripcion="Cumpleaños";
		String codigoDeAcceso="uno";
		Evento evento= new Evento(idEvento,titulo,descripcion,codigoDeAcceso);
		gestion.registrarEvento(evento);
		
	
		
		Integer idOrganizador=1;
		String nombreOrganizador="fran";
		Integer idParticipante=2;
		String nombreParticipante="Rodrigo";
		Usuario usuarioOrganizador= new Organizador(idOrganizador,nombreOrganizador);
		Usuario usuarioParticipante= new Participante(idParticipante,nombreParticipante);
		gestion.registrarUsuario(usuarioOrganizador);
		evento.usuariosDelEvento.add(usuarioOrganizador);
		gestion.registrarUsuario(usuarioParticipante);
		gestion.agregarUsuarioAEvento(idParticipante,idEvento,codigoDeAcceso,idOrganizador);
		
		Integer idPresentacion=1;
		String nombreDelShow="Los Del Fuego";
		Boolean sePresentara=false;
		Show presentacion= new Show(idPresentacion, nombreDelShow, sePresentara);
		
		
		gestion.agregarPresentacionAEvento(presentacion,idOrganizador,idEvento,codigoDeAcceso);
		
		gestion.confirmarPresentacion(idPresentacion,idEvento,codigoDeAcceso,idOrganizador);
		
		assertTrue(presentacion.getSePresentara());
	}
	
}
