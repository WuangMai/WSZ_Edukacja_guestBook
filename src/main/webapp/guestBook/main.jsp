<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ include file="/header.jsp" %>

<div class="container-fluid">
    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Księga Gości</h1>
    </div>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Zapisz się do księgi gości:</h6>
        </div>

<%--TODO dodać takie same przyciski do panelu bocznego--%>
        <div class="card-body d-flex justify-content-center">
            <div class="col-lg-0 ">
                <div class="text-center ">
                    <a href="/login" class="btn btn-primary btn-block" style="width: 200px;"> Logowanie</a>
                    <a href="/register" class="btn btn-primary btn-block"> Rejestracja</a>
                    <a href="/entry" class="btn btn-primary btn-block"> Księga gości</a>
                </div>
            </div>
        </div>
    </div>
</div>


<%@ include file="/footer.jsp" %>