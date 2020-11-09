import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TableDetails {
	public static void main(String[] args) {
		try {
			PrintWriter printWriter = new PrintWriter(new File("D:\\Java Prog-StudyMaterials\\PlayersDetail.csv"));
			StringBuilder sb = new StringBuilder();
			Connection connection = null;
			EstablishConnection est = new EstablishConnection();
			connection = est.getConnection();
			ResultSet rs = null;

			String query = "select * from players_table";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				sb.append(rs.getString("id"));
				sb.append(",");
				sb.append(rs.getString("name"));
				sb.append(",");
				sb.append(rs.getString("country"));
				sb.append("\r\n");
			}
				printWriter.write(sb.toString());
				printWriter.close();
				System.out.println("Fnished");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
