package edu.ycp.cs.webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs.frogger.controller.LevelSelectController;
import edu.ycp.cs496.model.Game;
import edu.ycp.cs496.model.persist.PersistenceException;

public class LevelSelectServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		req.getRequestDispatcher("/view/levelSelect.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//Game model = (Game) req.getAttribute("model");
		
		
		Game model = (Game) req.getSession().getAttribute("game");
		if (model == null) {
			throw new ServletException("User is not logged in");
		}
		
		int maxLevel = 1;
		
		LevelSelectController controller = new LevelSelectController();
		controller.setModel(model);
		
		try 
		{
			maxLevel = controller.getMaxLevel();
		} 
		catch (PersistenceException e) 
		{
			e.printStackTrace();
		}
		
		req.getSession().setAttribute("game", model);
		
		if(req.getParameter("Level1Button") != null)
		{
			req.setAttribute("level", 1);
			req.getRequestDispatcher("/view/game.jsp").forward(req, resp);
		}
		else if(req.getParameter("Level2Button") != null)
		{
			req.setAttribute("level", 2);
			req.getRequestDispatcher("/view/game.jsp").forward(req, resp);
		}
		else if(req.getParameter("Level3Button") != null)
		{
			req.setAttribute("level", 3);
			req.getRequestDispatcher("/view/game.jsp").forward(req, resp);
		}
		else if(req.getParameter("Level4Button") != null)
		{
			req.setAttribute("level", 4);
			req.getRequestDispatcher("/view/game.jsp").forward(req, resp);
		}
		else if(req.getParameter("Level5Button") != null)
		{
			req.setAttribute("level", 5);
			req.getRequestDispatcher("/view/game.jsp").forward(req, resp);
		}
		else if(req.getParameter("Level6Button") != null)
		{
			req.setAttribute("level", 6);
			req.getRequestDispatcher("/view/game.jsp").forward(req, resp);
		}
		else if(req.getParameter("Level7Button") != null)
		{
			req.setAttribute("level", 7);
			req.getRequestDispatcher("/view/game.jsp").forward(req, resp);
		}
		else if(req.getParameter("Level8Button") != null)
		{
			req.setAttribute("level", 8);
			req.getRequestDispatcher("/view/game.jsp").forward(req, resp);
		}
		else if(req.getParameter("Level9Button") != null)
		{
			req.setAttribute("level", 9);
			req.getRequestDispatcher("/view/game.jsp").forward(req, resp);
		}
		else if(req.getParameter("Level10Button") != null)
		{
			req.setAttribute("level", 10);
			req.getRequestDispatcher("/view/game.jsp").forward(req, resp);
		}
		else
		{
			req.getRequestDispatcher("/view/levelSelect.jsp").forward(req, resp);
		}
	}
}
