<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

      <!-- Основное содержимое -->
      <div class="page-header">
        <h1>Все объявления</h1>
        <p class="lead">Пример макета для вывода данных в виде таблицы</p>
      </div>

             <div class="row">
               <div class="col-md-1">№</div>
               <div class="col-md-1">Цена</div>
               <div class="col-md-3">Адрес</div>
               <div class="col-md-3">Описание</div>
               <div class="col-md-1">Число комнат</div>
               <div class="col-md-1">Площадь</div>
               <div class="col-md-1">Этаж</div>
               <div class="col-md-1">Этажность</div>
               <div class="col-md-1">Этажность</div>

             </div>
          <% Integer i=0; %>
          <c:forEach items="${ads}" var="ad">
             <br />
             <div class="row">
               <div class="col-md-1"><% out.print(++i); %></div>
               <div class="col-md-1">${ad.price} </div>
               <div class="col-md-3">${ad.address}</div>
               <div class="col-md-3">${ad.description}</div>
               <div class="col-md-1">${ad.roomCount}</div>
               <div class="col-md-1">${ad.area}</div>
               <div class="col-md-1">${ad.floor}</div>
               <div class="col-md-1">${ad.floors}</div>
             </div>
          </c:forEach>

      <!--
      <h3>Заголовок. Объявления о продаже</h3>
      <p>Строка делится на 12 частей. Для каждой колонки таблицы
         можно указать класс .col-md-N, где N-число частей</p>

      <div class="row">
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-3">.col-md-3</div>
        <div class="col-md-2">.col-md-2</div>
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-2">.col-md-2</div>
      </div>

      <div class="row">
        <div class="col-md-1">Цена</div>
        <div class="col-md-3">Адрес</div>
        <div class="col-md-2">Описание</div>
        <div class="col-md-1">Число комнат</div>
        <div class="col-md-1">Площадь</div>
        <div class="col-md-1">Этаж</div>
        <div class="col-md-1">Этажность</div>
        <div class="col-md-2">Автор</div>
      </div>

     -->




<%@ include file="include/end-html.jsp" %>
