<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %>

<div class="container-fluid">
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Księga Gości</h1>
    </div>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Wpisz się do księgi gości!</h6>
        </div>

        <div class="card-body">
            <div class="mx-5 mb-0" style="width: auto">
                <form method="post" action="/entry">
                    <div class="form-group">
                        <label>Twój nick:</label>
                        <label>${sessionScope.logged.nick}</label><br/>
                        <label for="content"> Dodaj wpis:</label>
                    </div>
                    <div class="form-group mt-0">
                        <textarea id="content" name="content" cols="50" rows="7"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary" name="action" value="login">Dodaj</button>
                    <a href="/profil" class="btn btn-secondary">Wróć</a>
                </form>
            </div>
        </div>
    </div>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Ostatnie wpisy:</h6>
        </div>

        <c:forEach items="${entryMap}" var="entry">
            <div class="mx-4 mb-4 mt-3">
                <div class="card bg-secondary text-white shadow">
                    <div class="card-body">
                        <p>${entry.key.content}</p>
                        <div class="text-black-50 font-weight-bold">Autor: ${entry.value.nick}</div>
                        <div class="text-black-50 font-weight-bold">Data: ${entry.key.addedTime}</div>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>
</div>

<%@ include file="/footer.jsp" %>
