package web.mongo;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;

import web.mongo.db.ConnectionManager;
import web.mongo.db.modal.Zip;

/**
 * Servlet implementation class FetchZip
 */
@WebServlet("/fetch.do")
public class FetchZip extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FetchZip() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MongoClient connection = ConnectionManager.getMongo();
		MongoDatabase db = ConnectionManager.getDb("test");
		MongoCollection<Document> collection = db.getCollection("zips");

		MongoCursor<Document> cursor = collection.find().limit(30).iterator();

		List<Zip> dataList = new LinkedList<>();

		while (cursor.hasNext()) {
			Document d = (Document) cursor.next();

			Zip zip = new Zip(d.getString("city"), d.getInteger("pop"), d.getString("state"));
			dataList.add(zip);
		}

		//ConnectionManager.close();

		request.setAttribute("list", dataList);
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
