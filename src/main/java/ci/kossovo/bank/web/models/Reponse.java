package ci.kossovo.bank.web.models;

public class Reponse {
private int statut;
private Object data ;


public Reponse() {
	super();
	// TODO Auto-generated constructor stub
}

public Reponse(int statut, Object data) {
	super();
	this.statut = statut;
	this.data = data;
}
// methode incremnt 
public void incrStatut(int increment){
	statut+=increment;
}

public int getStatut() {
	return statut;
}
public void setStatut(int statut) {
	this.statut = statut;
}
public Object getData() {
	return data;
}
public void setData(Object data) {
	this.data = data;
}

}
