package ci.kossovo.bank.web.helpers;

import java.util.ArrayList;
import java.util.List;

public class Static {

	public Static() {
		super();
		
	}
//	liste des messages d'erreur d'une excepetion
	public static List<String> getErreursForException(Exception exception){
		//on recupere la liste des messges d'erreur  de l'exception
		Throwable cause = exception;
		List<String> erreurs = new ArrayList<String>();
		while (cause!=null) {
		     erreurs.add(cause.getMessage());
		     cause.getCause();
			
		}
		return erreurs;
	}

}
