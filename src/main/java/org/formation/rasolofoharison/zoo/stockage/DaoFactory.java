package org.formation.rasolofoharison.zoo.stockage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.zip.InflaterInputStream;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.formation.rasolofoharison.zoo.modele.technique.Utilitaire;
import org.formation.rasolofoharison.zoo.service.CagePOJO;

public class DaoFactory {

	private static DaoFactory instance = new DaoFactory();
	public static final String PACKAGE = "org.formation.rasolofoharison.zoo.stockage";
	private Properties props;
	public DaoFactory() {	
//		props = new Properties();
//		try (InputStream fic = this.getClass().getClassLoader().getResourceAsStream("zoo.properties")){
//			props.load(fic);
//		} catch (IOException e) {
//			Utilitaire.logger.log(Level.SEVERE,e.getMessage());		}
//		
	}
	public Properties getProps() {
		return props;
	}
	public void setProps(Properties props) {
		this.props = props;
	}

	public static DaoFactory getInstance() {
		return instance;
	}

	public DaoAccess<CagePOJO> getDao(){
		DaoAccess<CagePOJO> ret = null;
		try {
			InitialContext ctx = new InitialContext();
			ret = (DaoAccess<CagePOJO>) ctx.lookup("java:global/correctionZOO/DaoJPA!org.formation.rasolofoharison.zoo.stockage.DaoAccess");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String choix =props.getProperty("dao");
//		String choix = "DaoJPA";
//				Class<DaoAccess<CagePOJO>> laClasse = null;
//				
//				try {
//					laClasse = (Class<DaoAccess<CagePOJO>>) Class.forName(String.join(".", PACKAGE, choix));
//					ret = laClasse.getConstructor(null).newInstance(null);
//					
//				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
//						| IllegalArgumentException | InvocationTargetException | NoSuchMethodException
//						| SecurityException e) {
//					e.printStackTrace();
//				}
		
		return ret;
		
	}
	
}
