package in.srivath.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import in.srivath.dto.BookDto;

import in.srivath.util.ConnectionFactory;

public class BooksDao {
	public BooksDao() {
		System.out.println("BooksDao::Constructor");
	}
	private static final String insertSQL = "INSERT INTO BOOKS VALUES(?,?,?)";

	public boolean saveBook(BookDto book) {
		int count = 0;
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(insertSQL);
			pstmt.setInt(1, book.getBookId());
			pstmt.setString(2, book.getBookName());
			pstmt.setInt(3, book.getBookPrice());
			count = pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count > 0;
	}
}
