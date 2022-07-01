package mulesoft;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
public static void main(String [] args) {
	createtable.createNewTable();
	insert("PREMAM","NIVIN PAULY","SAI PALLAVI",2015,"shiv nadar");
	insert("BILLA","Ajithkumar","Anushka",2007,"c.s amudhan");
	insert("TAMIL PADAM","Shiva","Disha",2010,"c.s amudhan");
	insert("KAITHI","Karthick","None",2010,"Lokesh kanagaraj");
	insert("THERI","Vijay","Samantha",2015,"Atlee");
	select.selectAll();
	select.selectactormovie();
}
private static void insert(String moviename,String leadactor,String actress,Integer yearofrelease,String director) {
	Connection con=Dbconnection.connect();
	PreparedStatement ps=null;
	try {
		String sql="INSERT INTO movies(moviename,leadactor,actress,yearofrelease,director) VALUES(?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, moviename);
		ps.setString(2, leadactor);
		ps.setString(3, actress);
		ps.setInt(4,yearofrelease);
		ps.setString(5, director);
		ps.execute();
		System.out.println("Data has been inserted");
	}catch(SQLException e) {
		System.out.println(e.toString());
	}
}
}
