package it.polito.tdp.anagrammi.DAO;

import java.sql.*;

public class AnagrammaDAO {
	
	public boolean isCorrect(String anagramma){
		
		String jdbcUrl = "jdbc:mysql://localhost/dizionario?user=root";
		String sql="SELECT nome FROM dizionario.parola WHERE nome=?;";
		
		try {	
			Connection conn = DriverManager.getConnection(jdbcUrl);
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet rs = st.executeQuery();
			boolean ris=false;
			if(rs.next()){
				ris=true;
			}
			conn.close();
			return ris;

		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
		}
	}
}
