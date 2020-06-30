package Entity.Servlet;


import Entity.Entity.MacchineAgricole;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "paginaParcoMacchine", urlPatterns = {"/macchineAgricole"})
public class paginaParcoMacchine extends HttpServlet {

    @PersistenceContext
    EntityManager ls;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Query q = ls.createNamedQuery("getMacchine");
        List<MacchineAgricole> mc = q.getResultList();
        request.setAttribute("mc",mc);
        RequestDispatcher rd = request.getRequestDispatcher("/MacchineAgricole.jsp");
        rd.forward(request,response);
    }

}
