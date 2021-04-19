<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ include file="/header.jsp" %>

<div class="container-fluid">
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Księga gości</h1>
    </div>

    <div class="card shadow mb-5">
        <div class="card-header py-4">
            <h6 class="m-0 font-weight-bold text-primary">Edycja użytkownika</h6>
        </div>

        <div class="mx-md-5" style="width: auto">
            <form method="post" action="<c:url value="/edit"/> ">

                <div class="form-group">
                    <label for="name" class="mt-4">Imię:</label>
                    <input type="text" name="name" class="form-control" id="name" value="${sessionScope.logged.name}">
                </div>

                <div class="form-group">
                    <label for="surname">Nazwisko:</label>
                    <input type="text" name="surname" class="form-control" id="surname"
                           value="${sessionScope.logged.surname}">
                </div>

                <div class="form-group">
                    <label for="nick">Nick:</label>
                    <input type="text" name="nick" class="form-control" id="nick" value="${sessionScope.logged.nick}">
                </div>

                <div class="form-group">
                    <label for="email">Adres email:</label>
                    <input type="email" name="email" class="form-control" id="email"
                           value="${sessionScope.logged.email}">
                </div>

                <div class="form-group">
                    <label for="phone">Telefon:</label>
                    <input type="number" name="phone" class="form-control" id="phone"
                           value="${sessionScope.logged.phone}">
                </div>

                <div class="form-group">
                    <label for="pass"> Hasło</label>
                    <input type="password" name="password" class="form-control" id="pass" value="">
                </div>

                <div class="form-group">
                    <%--                    <label for="userId"> Identyfikator użytkownika:</label>--%>
                    <input type="text" name="userId" class="form-control mb-4" id="userId"
                           value="${sessionScope.logged.userId}" hidden>
                </div>

                <div class="form-group">
                    <%--                    <label for="id"> Identyfikator użytkownika:</label>--%>
                    <input type="text" name="id" class="form-control mb-4 " id="id" value="${sessionScope.logged.id}"
                           hidden>
                </div>

                <button type="submit" class="btn btn-primary mt-2">Zatwierdź</button>
            </form>
            <a href="/profil" class="btn btn-secondary btn-block col-lg-1 ml-0 mb-4">Wróć</a>
        </div>


    </div>
</div>