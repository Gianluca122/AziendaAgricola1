package Entity.Servlet;

import Entity.Entity.Bovino;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "paginaBovini", urlPatterns = {"/Bovini"})
public class paginaBovini extends HttpServlet {

    @Resource(mappedName = "java:/AziendaAgricola")
    DataSource db;

    @Override
    public void init() {
        ServletConfig config = getServletConfig();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection c = null;
        try {
            c = db.getConnection();
            Statement s = c.createStatement();
            String query = "SELECT Matricola FROM Bovini";
            ResultSet rs = s.executeQuery(query);
            List<Bovino> b = new LinkedList<>();
            while (rs.next()) {
                Bovino bv = new Bovino();
                bv.setMatricola(rs.getInt(1));
                bv.setData_di_nascita(rs.getInt(2));
                bv.setSesso(rs.getString(3));
                b.add(bv);
            }
            rs.close();
            request.setAttribute("Bovini", b);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(c!=null){
                try{
                    c.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            RequestDispatcher rb = request.getRequestDispatcher("/Bovini.jsp");
            rb.forward(request,response);
        }


        }

}
