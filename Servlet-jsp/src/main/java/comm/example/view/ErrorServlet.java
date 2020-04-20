package comm.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorServlet
 */
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
		}

		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doProcess(request, response);
		}


		private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
			// TODO Auto-generated method stub
			
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			List<String> errors=(List<String>) request.getAttribute("error");
			for(String e:errors)
			{
				out.println(e);
			}
			
			
		}

	}
