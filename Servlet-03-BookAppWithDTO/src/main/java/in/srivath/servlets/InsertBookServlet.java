package in.srivath.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import in.srivath.dao.BooksDao;
import in.srivath.dto.BookDto;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InsertBookServlet")
public class InsertBookServlet extends HttpServlet {
	private BookDto book=new BookDto();
	private BooksDao booksDao=new BooksDao();

	public InsertBookServlet() {
		System.out.println("InsertBookServlet:: Constructor");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

		// capture form data
		int bookId = Integer.parseInt(req.getParameter("bookId"));
		String bookName = req.getParameter("bookName");
		int bookPrice = Integer.parseInt(req.getParameter("bookPrice"));
		
		book.setBookId(bookId);
		book.setBookName(bookName);
		book.setBookPrice(bookPrice);

		// call save method from bookDao class
		boolean bool = booksDao.saveBook(book);

		// send response to client
		PrintWriter writer = res.getWriter();
		String response = "";
		if (bool) {
			response = "Record inserted.";
		} else {
			response = "Insertion failed!";
		}
		writer.append(response);
	}
}
