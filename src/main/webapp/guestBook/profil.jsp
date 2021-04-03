<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/header.jsp" %>

<div class="container-fluid">
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Księga Gości</h1>
    </div>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Twój profil:</h6>
        </div>

        <div class="card-body">
            <div class="mx-5" style="width: auto">

                <div class="form-group">
                    <label class="col-lg-2">Imię:</label>
                    <label class="col-lg-6">${user.name}</label>

                    <%--                        <input type="text" name="name" class="form-control" id="name" value="${user.name}">--%>
                </div>

                <div class="form-group">
                    <label class="col-lg-2">Nazwisko:</label>
                    <label class="col-lg-6">${user.surname}</label>
                    <%--                        <input type="text" name="surname" class="form-control" id="surname" aria-describedby="text">--%>
                </div>

                <div class="form-group">
                    <label class="col-lg-2">Nick:</label>
                    <label class="col-lg-6">${user.nick}</label>
                    <%--                        <input type="text" name="surname" class="form-control" id="surname" aria-describedby="text">--%>
                </div>

                <div class="form-group">
                    <label class="col-lg-2">Adres email:</label>
                    <label class="col-lg-6">${user.email}</label>
                    <%--                        <input type="email" name="email" class="form-control" id="email" aria-describedby="emailHelp">--%>
                </div>

                <div class="form-group">
                    <label class="col-lg-2">Telefon:</label>
                    <label class="col-lg-6">${ user.phone}</label>
                    <%--                        <input type="number" name="phone" class="form-control" id="phone" aria-describedby="phone">--%>
                </div>
                <div class="form-group">
                    <a href="/edit" class="btn btn-primary btn-block col-lg-6"> Edytuj dane</a>
                    <a href="/logout" class="btn btn-danger btn-block col-lg-6"> Wyloguj się</a>

                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/footer.jsp" %>
