package ar.edu.unlam.evento;

public class Invitacion {

	Integer id;
	Usuario usuario;
	Integer fecha;
	TipoOperacion tipoDeOperacion;
	public Invitacion(Integer id, Usuario usuario, Integer fecha, TipoOperacion tipoDeOperacion) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.fecha = fecha;
		this.tipoDeOperacion = tipoDeOperacion;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Integer getFecha() {
		return fecha;
	}
	public void setFecha(Integer fecha) {
		this.fecha = fecha;
	}
	public TipoOperacion getTipoDeOperacion() {
		return tipoDeOperacion;
	}
	public void setTipoDeOperacion(TipoOperacion tipoDeOperacion) {
		this.tipoDeOperacion = tipoDeOperacion;
	}
	
	



}
