package ci.kossovo.bank.web.controller;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import ci.kossovo.bank.entites.Client;
import ci.kossovo.bank.web.helpers.Static;
import ci.kossovo.bank.web.models.ApplicationModel;
import ci.kossovo.bank.web.models.Reponse;

@RestController
public class ClientController {

	// point d'entree unique des controllers
	@Autowired
	ApplicationModel application;
	// entete CORS
	@Autowired
	ClientCorsController clientCorsController;

	// liste des messages d'erreurs
	List<String> messages;

	@PostConstruct
	public void init() {
		messages = application.getMessages();
		
	}
// debut methodes locales
	// liste des clients
	// liste des clients
		@RequestMapping(value = "/clients", method = RequestMethod.GET)
		public Reponse getAllClients(HttpServletResponse response) {
			// entêtes CORS
			clientCorsController.getAllClients(response);
			// état de l'application
			if (messages != null) {
				return new Reponse(-1, messages);
			}
			// liste des clients
			try {
				return new Reponse(0, application.getAllClients());
			} catch (Exception e) {
				return new Reponse(1, Static.getErreursForException(e));
			}
		}
}
