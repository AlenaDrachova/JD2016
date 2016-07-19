<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <p>Login:<b> ${user.login}</b> Email:<b> ${user.email}</b></p>
    <p>Name:<b> ${user.name}</b> Lastname:<b> ${user.lastname}</b></p>
    <p>Address:<b> ${user.address}</b></p>
    <br />

    <p><b>Purchases</b></p>


<br />
<form class="form-horizontal" action="do?command=PROFILE" method="POST">
   <fieldset>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="LogoutButton"></label>
            <div class="col-md-4">
                <button id="LogoutButton" name="LogoutButton" value="1" class="btn btn-danger">GO OUT</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
