package ci.kossovo.bank.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ci.kossovo.bank.web.models.ApplicationModel;

@Controller
public class ClientCorsController {

	@Autowired
	ApplicationModel clientModel;
//	envoie des options au client
	private void sendOptions(HttpServletResponse response){
		if (clientModel.isCORSneeded()) {
			// on fixe le header CORS
			response.addHeader("Access-Control-Allow-Origin", "*");
			// on autorise certains headers
			response.addHeader("Access-Control-Allow-Headers", "accept, authorization, content-type");
			// on autorise le POST
			response.addHeader("Access-Control-Allow-Methods", "POST");
		}
	}
	@RequestMapping(value="/clients",method=RequestMethod.OPTIONS)
	public void getAllClients(HttpServletResponse response){
		sendOptions(response);
	}
}
