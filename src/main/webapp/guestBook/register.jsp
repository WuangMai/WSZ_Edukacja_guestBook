<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/header.jsp" %>

<div class="container-fluid">
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Księga Gości</h1>
    </div>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Rejestracja nowego użytkownika</h6>
        </div>

        <div class="card-body">
            <div class="mx-5" style="width: auto">
                <form method="post" action="<c:url value="/register"/>">
                    <div class="form-group">
                        <label for="name">Imię</label>
                        <input type="text" name="name" class="form-control" id="name" aria-describedby="text">
                    </div>
                    <div class="form-group">
                        <label for="surname">Nazwisko</label>
                        <input type="text" name="surname" class="form-control " id="surname"  aria-describedby="text">
                    </div>
                    <div class="form-group">
                        <label for="email">Adres email</label>
                        <input type="email" name="email" class="form-control" id="email" aria-describedby="emailHelp">
                    </div>
                    <div class="form-group">
                        <label for="phone">Telefon</label>
                        <input type="number" name="phone" class="form-control" id="phone" aria-describedby="phone">
                    </div>
                    <div class="form-group">
                        <label for="pass"> Hasło</label>
                        <input type="password" name="password" class="form-control" id="pass" aria-describedby="password">
                    </div>
                    <div class="form-group">
                        <label for="re-pass"> Powtórz Hasło</label>
                        <input type="password" name="re-password" class="form-control" id="re-pass">
                    </div>
                    <button type="submit" id="addBtn" class="btn btn-primary " name="action" value="add" onmouseover="checkAndDisable()">Rejestracja</button>
                    <button type="submit" id="back" class="btn btn-secondary" name="action" value="back">Wróć</button>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="/theme/js/validation.js"></script>
<%@ include file="/footer.jsp" %>
