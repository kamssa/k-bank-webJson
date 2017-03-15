package ci.kossovo.bank.web.models;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ci.kossovo.bank.entites.Client;
import ci.kossovo.bank.metier.IClientMetier;
import ci.kossovo.bank.web.helpers.Static;

@Component
public class ApplicationModel implements IClientMetier {

	@Autowired
	private IClientMetier ClientMetier;
	// donnees provenant de la couche metier

	List<Client> clients;
	List<String> messages;
	private boolean CORSneeded;
	
	@PostConstruct
	public void init() {
		try {
			System.out.println("debut de la methode init");
			clients = ClientMetier.getAllClients();
		} catch (Exception e) {
			messages = Static.getErreursForException(e);
		}
	}

	@Override
	public Client saveClient(Client client) {
		// TODO Auto-generated method stub
		return client;
	}


	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return clients;
	}


	public boolean isCORSneeded() {
		return CORSneeded;
	}

	public void setCORSneeded(boolean cORSneeded) {
		CORSneeded = cORSneeded;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

}
