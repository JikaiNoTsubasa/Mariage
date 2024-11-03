package ovh.mariage.runnable;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ovh.mariage.model.User;
import ovh.mariage.services.DB;

public class RunCreateUsers {
	
	public static Logger log = LoggerFactory.getLogger(RunCreateUsers.class);

	public static void main(String[] args) throws SQLException {
		log.info("Start loading");
		
		// Test
		DB.getInstance().storeUser(new User("Test User", "test", "M", "fr", false));
		
		// FR groups
		DB.getInstance().storeUser(new User("Mathilde, Anthony et Rose", "M.A.R", "M", "fr", false));
		DB.getInstance().storeUser(new User("Marie-Lise et Jean-Marc", "M.JM", "M", "fr", false));
		DB.getInstance().storeUser(new User("Laure, Quentin et Célestin", "L.Q", "M", "fr", false));
		DB.getInstance().storeUser(new User("Laurence et Philippe", "L.P", "M", "fr", false));
		DB.getInstance().storeUser(new User("Martine et Christian", "M.C", "M", "fr", false));
		DB.getInstance().storeUser(new User("Sandra et Geoffrey", "S.G", "M", "fr", false));
		DB.getInstance().storeUser(new User("Candice, Aurélien et Daryl", "C.A", "M", "fr", false));
		DB.getInstance().storeUser(new User("Marie, Michael et les enfants", "M.M", "M", "fr", false));
		DB.getInstance().storeUser(new User("Katia et Julien", "K.J", "M", "fr", false));
		DB.getInstance().storeUser(new User("Mélody et Joffrey", "M.J", "M", "fr", false));
		DB.getInstance().storeUser(new User("Celsa et Serge", "C.S", "M", "fr", false));
		DB.getInstance().storeUser(new User("Carmen et Bruno", "C.B", "M", "fr", false));
		DB.getInstance().storeUser(new User("Martine et Gilbert", "M.G", "M", "fr", false));
		DB.getInstance().storeUser(new User("Stéphanie, Jérémie et les Filles", "S.J", "M", "fr", false));
		DB.getInstance().storeUser(new User("Isabelle, Xavier et les enfants", "I.X.A", "M", "fr", false));
		DB.getInstance().storeUser(new User("Cathy, David, Maël et Mila", "C.D", "M", "fr", false));
		DB.getInstance().storeUser(new User("Coralie, Jérome et les Filles", "C.J", "M", "fr", false));
		DB.getInstance().storeUser(new User("Lucille, Jimmy et Manon", "L.J.M", "M", "fr", false));
		DB.getInstance().storeUser(new User("Dominique et Jean-Pierre", "D.JP", "M", "fr", false));
		DB.getInstance().storeUser(new User("Babeth et Alain", "B.A", "M", "fr", false));
		DB.getInstance().storeUser(new User("Bertrand et Marie-Noëlle", "B.M", "M", "fr", false));
		DB.getInstance().storeUser(new User("Romaine et Etiènne", "R.E", "M", "fr", false));
		DB.getInstance().storeUser(new User("Sabine et Jonathan", "S.Jo", "M", "fr", false));
		DB.getInstance().storeUser(new User("Séverine, Yann et Violette", "S.Y.V", "M", "fr", false));
		DB.getInstance().storeUser(new User("Cindy, David, Yann et Désiria", "C.D.Y.D", "M", "fr", false));
		DB.getInstance().storeUser(new User("Katia, Moritz, William et Mathias", "K.M.W.M", "M", "fr", false));
		DB.getInstance().storeUser(new User("Loïc' et Celia", "Lo", "M", "fr", false));
		DB.getInstance().storeUser(new User("Stéphane et Louan", "STH", "M", "fr", false));
		DB.getInstance().storeUser(new User("Bruno et famille", "B", "M", "fr", false));
		DB.getInstance().storeUser(new User("Charlène et famille", "Cha", "M", "fr", false));
		DB.getInstance().storeUser(new User("Ludivine et famille", "Lu", "M", "fr", false));
		DB.getInstance().storeUser(new User("Pierre et famille", "Pi", "M", "fr", false));
		DB.getInstance().storeUser(new User("Juliette et Roland", "J.R", "M", "fr", false));
		DB.getInstance().storeUser(new User("Anne et famille", "An", "M", "fr", false));
		DB.getInstance().storeUser(new User("Céline, Didier et Maud", "C.D.M", "M", "fr", false));
		DB.getInstance().storeUser(new User("Elodie, Sacha, Julie et Lana", "E.S.J.L", "M", "fr", false));
		DB.getInstance().storeUser(new User("Coralie, Jonathan et les petis", "C.J.P", "M", "fr", false));
		DB.getInstance().storeUser(new User("Tania, Jeremy et Martin", "T.J.M", "M", "fr", false));
		DB.getInstance().storeUser(new User("Elodie, Michel, Rosalie et Gabriel", "E.M.R.G", "M", "fr", false));
		DB.getInstance().storeUser(new User("Odeleine, François, Margot et Adèle", "O.F.M.A", "M", "fr", false));
		
		// To verify
		DB.getInstance().storeUser(new User("Ludovic et Madame", "LG", "M", "fr", false)); // FIXME to verify
		DB.getInstance().storeUser(new User("Valentine et Monsieur", "Va", "M", "fr", false)); // FIXME to verify
		DB.getInstance().storeUser(new User("Nicolas et Mme", "NIJ", "M", "fr", false)); // FIXME to verify
		
		// FR solo
		DB.getInstance().storeUser(new User("Kévin", "M.K", "M", "fr", true));
		DB.getInstance().storeUser(new User("Cyril", "Cy", "M", "fr", true));
		DB.getInstance().storeUser(new User("Fred", "Fr", "M", "fr", true));
		DB.getInstance().storeUser(new User("Eric", "Er", "M", "fr", true));
		DB.getInstance().storeUser(new User("Emanuel", "Em", "M", "fr", true));
		DB.getInstance().storeUser(new User("Françoise", "F", "F", "fr", true));
		DB.getInstance().storeUser(new User("Solange", "So", "F", "fr", true));
		
		// DE groups
		DB.getInstance().storeUser(new User("Isabella und Markus", "I.M", "M", "de", false));
		DB.getInstance().storeUser(new User("Kim, Stefan, Mila und Felix", "K.S", "M", "de", false));
		DB.getInstance().storeUser(new User("Nadine und familie", "Na", "M", "de", false)); // FIXME to verify
		
		// EN groups
		DB.getInstance().storeUser(new User("Jessica, Luke and children", "J.L", "M", "en", false));
		
		log.info("Finished loading");
	}
}
