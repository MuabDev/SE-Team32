

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParkhausServlet
 */
@WebServlet("/Parkhaus")
public class ParkhausServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private static float sum = 0.0f;
	private static float cars = 0.0f;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParkhausServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String[] requestParam = request.getQueryString().split("=");
		String cmd = requestParam[0];
		String arg = requestParam[1];
		
		if("cmd".equals(cmd))
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			switch(arg)
			{
				case "sum":
					out.println(sum);
					System.out.println("sum = " + sum);
					break;
				case "avg":
					if(cars > 0)
					{
						float avg = sum/cars;
						out.println(avg);
						System.out.println("average = " +  avg);
					} else {
						System.err.println("Nulldivision!");
					}
					break;
				default:
					System.out.println("Invalid command: " + arg);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String body = getBody(request);
		String[] params = body.split(",");
		if(params[0].equals("leave") && !(params[4].equals("_")))
		{
			sum += (Float.parseFloat(params[4]))/100;
			cars++;
		}
		System.out.println(body);
	}

	//from lecture
	private static String getBody(HttpServletRequest request) throws IOException
	{
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;
		
		try
		{
			InputStream inputStream = request.getInputStream();
			if(inputStream != null)
			{
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0)
				{
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} 
			else 
			{
				stringBuilder.append("");
			}
		} 
		finally 
		{
			if (bufferedReader != null)
			{
				bufferedReader.close();
			}
		}
		
		return stringBuilder.toString();
	}

}
