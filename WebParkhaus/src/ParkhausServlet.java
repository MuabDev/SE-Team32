

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
	private Berechnung calc = new Berechnung();
	private SumView sum = new SumView();		//initialisiere die Views
	private AvgView avg = new AvgView();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParkhausServlet() 
    {
    	super();
    	sum.subscribe(calc);				//Views in die Liste der Berechnung einfügen
    	avg.subscribe(calc);
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
					out.println(sum.view());
					System.out.println("sum = " + sum.view());
					break;
				case "avg":
					if(calc.getSize() > 0) //nicht durch null teilen
					{
						out.println(avg.view());
						System.out.println("average = " +  avg.view());
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
			calc.addCost(Float.parseFloat(params[4])); //4tes Element sind die Kosten
		}
		System.out.println(body);
	}

	private static String getBody(HttpServletRequest request) throws IOException //von Vorlesung
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
