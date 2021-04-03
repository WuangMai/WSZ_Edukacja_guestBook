<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ include file="/header.jsp" %>

<div class="container-fluid">
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Księga gości</h1>
    </div>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Edycja użytkownika</h6>
        </div>

        <div class="mx-5" style="width: auto">
            <form method="post" action="<c:url value="/edit"/> ">
                <div class="form-group">
                    <label for="name">Imię:</label>
                    <input type="text" name="name" class="form-control" id="name" value="${user.name}">
                </div>

                <div class="form-group">
                    <label for="surname">Nazwisko:</label>
                    <input type="text" name="surname" class="form-control" id="surname" value="${user.surname}">
                </div>

                <div class="form-group">
                    <label for="nick">Nick:</label>
                    <input type="text" name="email" class="form-control" id="nick" value="${user.nick}">
                </div>

                <div class="form-group">
                    <label for="email">Adres email:</label>
                    <input type="email" name="email" class="form-control" id="email" value="${user.email}">
                </div>

                <div class="form-group">
                    <label for="phone">Telefon:</label>
                    <input type="number" name="phone" class="form-control" id="phone" value="${user.phone}">
                </div>

                <div class="form-group">
                    <label for="pass"> Hasło</label>
                    <input type="password" name="password" class="form-control" id="pass" value="">
                </div>

                <button type="submit" class="btn btn-primary">Zatwierdź</button>
            </form>
            <a href="/profil?user=${user.email}" class="btn btn-secondary btn-block col-lg-1 ml-0">Wróć</a>
        </div>


    </div>
</div>