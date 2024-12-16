<%-- 
    Document   : index
    Created on : Dec 16, 2024, 4:45:10 PM
    Author     : ADMIN
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>View Excel Data</title>
        <style>
            table {
                width: 100%;
                border-collapse: collapse;
            }

            table, th, td {
                border: 1px solid black;
            }

            th, td {
                padding: 10px;
                text-align: left;
            }

            th {
                background-color: #f2f2f2;
            }
        </style>
    </head>
    <body>
        <h1>Excel Data</h1>
        <table>
            <thead>
                <tr>
                    <th>#</th>
                    <th>Data</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<List<String>> data = (List<List<String>>) request.getAttribute("data");
                    if (data != null) {
                        for (int i = 0; i < data.size(); i++) {
                            List<String> row = data.get(i);
                %>
                <tr>
                    <td><%= (i + 1) %></td>
                    <td>
                        <%= String.join(", ", row) %>
                    </td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="2">No data available.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
