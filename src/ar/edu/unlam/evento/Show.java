package ar.edu.unlam.evento;

import java.util.Objects;

public class Show {
Integer id;
String nombreDelShow;
Boolean sePresentara;
public Show(Integer id, String nombreDelShow, Boolean sePresentara) {
	super();
	this.id = id;
	this.nombreDelShow = nombreDelShow;
	this.sePresentara = sePresentara;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getNombreDelShow() {
	return nombreDelShow;
}
public void setNombreDelShow(String nombreDelShow) {
	this.nombreDelShow = nombreDelShow;
}
public Boolean getSePresentara() {
	return sePresentara;
}
public void setSePresentara(Boolean sePresentara) {
	this.sePresentara = sePresentara;
}
@Override
public int hashCode() {
	return Objects.hash(id, nombreDelShow, sePresentara);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Show other = (Show) obj;
	return Objects.equals(id, other.id) && Objects.equals(nombreDelShow, other.nombreDelShow)
			&& Objects.equals(sePresentara, other.sePresentara);
}


}
