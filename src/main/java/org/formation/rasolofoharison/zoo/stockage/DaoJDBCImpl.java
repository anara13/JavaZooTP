/**
 * 
 */
package org.formation.rasolofoharison.zoo.stockage;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.formation.rasolofoharison.zoo.service.CagePOJO;

/**
 * @author Anais
 *
 */
public class DaoJDBCImpl implements DaoAccess{

	/**
	 * 
	 */
	private DaoJBDCConn binding;
	
	public DaoJDBCImpl() {
		DaoJDBCImpl bdd = new DaoJDBCImpl();	
		List<CagePOJO> lesCages;
		
	}
	
	public void CloseableDaoJDBC() {
		
	}

	@Override
	public List<CagePOJO> lireTous() {
	        PreparedStatement st = null;
	        ResultSet res = null;
	        String requete = "SELECT * FROM animal; SELECT * FROM gazelle;";

	        try {
	            st = binding.getConn().prepareStatement(requete);
	            st.setInt(1, 1);
	            res = st.executeQuery();
	            if (res != null) {
	                while (res.next()) {
	                    System.out.println(String.join(" ",Integer.toString(res.getInt("id")),res.getString("nom")));
	                }

	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
			return null;
			
	}

	@Override
	public void ecrireTous(List elts) {
//		PreparedStatement st = null;
//		ResultSet res = null;
//		String requete = "START TRANSACTION;\r\n"
//				+ "UPDATE animal SET idAnimal=?, codeAnimal=?, nom=?, age=?, poids=?, x=?, y=?;\r\n"
//				+ "UPDATE gazelle SET idAnimal=?, id=?, lgCornes=?;\r\n"
//				+ "COMMIT;\r\n";
		
	}

	@Override
	public Object lire(int cle) {
        PreparedStatement st = null;
        ResultSet res = null;
        String requete = "SELECT * FROM animal WHERE idAnimal=?; SELECT * FROM gazelle WHERE idAnimal=?;";

        try {
            st = binding.getConn().prepareStatement(requete);
            st.setInt(1, 1);
            res = st.executeQuery();
            if (res != null) {
                while (res.next()) {
                    System.out.println(String.join(" ",Integer.toString(res.getInt("id")),res.getString("nom")));
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        
		
		}
        return res;
	}
        
	@Override
	public void modifier(int cle) {
		PreparedStatement st = null;
		ResultSet res = null;
		String requete = "START TRANSACTION;\r\n"
				+ "UPDATE animal SET idAnimal=?, codeAnimal=?, nom=?, age=?, poids=?, x=?, y=?;\r\n"
				+ "UPDATE gazelle SET idAnimal=?, id=?, lgCornes=?;\r\n"
				+ "COMMIT;\r\n";
	}
	

}
