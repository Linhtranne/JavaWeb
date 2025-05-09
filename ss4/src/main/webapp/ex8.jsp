<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>

<%
    List<Map<String, Object>> revenueList = new ArrayList<>();
    revenueList.add(createRevenue("Tháng 1", 1500));
    revenueList.add(createRevenue("Tháng 2", 2000));
    revenueList.add(createRevenue("Tháng 3", 2500));

    double totalRevenue = 0;
    for (Map<String, Object> revenue : revenueList) {
        totalRevenue += (double) revenue.get("revenue");
    }

    request.setAttribute("revenueList", revenueList);
    request.setAttribute("totalRevenue", totalRevenue);
%>

<html>
<head>
    <title>Danh sách Doanh Thu</title>
    <style>
        table { border-collapse: collapse; width: 60%; margin-top: 20px; }
        th, td { border: 1px solid black; padding: 8px; text-align: center; }
    </style>
</head>
<body>

<h2> sách Doanh Thu</h2>

<table>
    <tr>
        <th>Tháng</th>
        <th>Doanh Thu (VNĐ)</th>
    </tr>

    <c:forEach var="revenue" items="${revenueList}">
        <tr>
            <td>${revenue['month']}</td>
            <td>${revenue['revenue']}</td>
        </tr>
    </c:forEach>
</table>

<p><strong>Tổng doanh thu: </strong>${totalRevenue} VNĐ</p>

<c:choose>
    <c:when test="${totalRevenue > 10000}">
        <p>Doanh thu vượt mức 10,000 VNĐ!</p>
    </c:when>
    <c:otherwise>
        <p>Doanh thu chưa vượt mức 10,000 VNĐ.</p>
    </c:otherwise>
</c:choose>

</body>
</html>

<%!
    private Map<String, Object> createRevenue(String month, double revenue) {
        Map<String, Object> revenueMap = new HashMap<>();
        revenueMap.put("month", month);
        revenueMap.put("revenue", revenue);
        return revenueMap;
    }
%>