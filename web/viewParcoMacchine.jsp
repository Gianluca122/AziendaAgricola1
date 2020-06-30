<%@ page import="Entity.Entity.MacchineAgricole" %><%--
  Created by IntelliJ IDEA.
  User: Utente
  Date: 30/06/2020
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="ma" class="java.util.List<MacchineAgricole>" scope="request" />
<html>
<head>
    <title>Fortunato</title>
</head>
<body>
<% for(MacchineAgricole m : ma) { %>
<p><%=m.getTarga()%>, <%=m.getModello()%>, <%=m.getNumeroTelaio()%></p>
<% } %>
</body>
</html>
