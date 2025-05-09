<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.ArrayList, com.ss4.ss4.Seat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="seats" class="java.util.ArrayList" scope="session" />
<%
    // Khởi tạo danh sách ghế nếu chưa có
    if (seats.isEmpty()) {
        String[] seatIds = {
                "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10",
                "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10",
                "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10",
                "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10",
                "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "E10"
        };
        for (String id : seatIds) {
            seats.add(new Seat(id, id, 50000, false));
        }
    }

    double totalPrice = 0;
    String[] selectedSeats = request.getParameterValues("selectedSeats");
    if (selectedSeats != null) {
        for (String seatName : selectedSeats) {
            for (Seat seat : (ArrayList<Seat>) seats) {
                if (seat.getName().equals(seatName) && !seat.isBooked()) {
                    seat.setBooked(true);
                    totalPrice += seat.getPrice();
                }
            }
        }
    }
%>
<html>
<head>
    <title>Đặt vé xem phim</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
        }

        h2, h3, h4 {
            margin: 20px 0;
        }

        .seat-container {
            display: grid;
            grid-template-columns: repeat(10, 60px);
            gap: 10px;
            justify-content: center;
        }

        input[type="checkbox"] {
            margin-right: 5px;
        }

        button {
            margin: 20px;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
        }

        button:hover {
            background-color: #0056b3;
        }

        label {
            display: inline-block;
            width: 50px;
            margin-bottom: 10px;
        }

        ul {
            list-style: none;
            padding: 0;
        }

        li {
            margin: 5px 0;
        }

    </style>
</head>
<body>
<h2>Danh sách ghế phòng chiếu số 8</h2>
<form method="post">
    <div class="seat-container">
        <c:forEach var="seat" items="${seats}">
            <label>
                <input type="checkbox" name="selectedSeats" value="${seat.name}"
                       <c:if test="${seat.booked}">disabled</c:if> />
                <span class="<c:if test='${seat.booked}'>booked</c:if>">${seat.name}</span>
            </label>
        </c:forEach>
    </div>
    <button type="submit">Thanh toán</button>
</form>

<% if (selectedSeats != null) { %>
<div class="result">
    <% if (selectedSeats.length > 0) { %>
    <h3>Danh sách ghế đã đặt:</h3>
    <ul>
        <% for (String seatName : selectedSeats) { %>
        <li><%= seatName %> - Giá: 50,000 VND</li>
        <% } %>
    </ul>
    <h4>Tổng tiền: <%= totalPrice %> VND</h4>
    <% } else { %>
    <h4 class="warning">Vui lòng chọn ghế trước khi thanh toán!</h4>
    <% } %>
</div>
<% } %>
</body>
</html>
