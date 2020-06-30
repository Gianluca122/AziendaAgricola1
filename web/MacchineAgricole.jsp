<%@ page import="Entity.Entity.MacchineAgricole" %><%--
  Created by IntelliJ IDEA.
  User: Utente
  Date: 24/06/2020
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="mc" class="java.util.List<MacchineAgricole>" scope="request"/>
<html>
<head>Fortunato</head>
<body>
<% for(MacchineAgricole m : mc) { %>
<p> <%=m.getTarga()%>,
    <%=m.getModello()%>,
    <%=m.getNumeroTelaio()%>
</p>
<% } %>
</body>

</html>