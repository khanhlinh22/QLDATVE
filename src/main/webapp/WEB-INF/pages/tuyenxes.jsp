<%-- 
    Document   : tuyenxes
    Created on : Aug 30, 2024, 6:03:00 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-info mt-1">QUẢN LÝ TUYẾN XE</h1>
<c:url value="/admin/tuyenxes" var="actions" />
<form:form action="${actions}" modelAttribute="tuyenXe" method="post">
    <form:errors path="*" element="div" cssClass="alert alert-danger"></form:errors>
        <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="tenTuyen" placeholder="Nhập tuyến xe" path="tenTuyen" />
        <label for="tenTuyen">Tuyến xe</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="diemDen" placeholder="Nhập điểm đi" path="diemDen" />
        <label for="diemDen">Điểm đi</label>
    </div>
             <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="diemDi" placeholder="Nhập điểm đến" path="diemDi" />
        <label for="diemDi">Điểm đến</label>
    </div>
         <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="tanSuat" placeholder="Nhập tần suất của một chuyến của một tuyến" path="tanSuat" />
        <label for="tanSuat">Tần suất/ Tuyến</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="khoangCach" placeholder="Nhập khoảng cách cua một tuyến" path="khoangCach" />
        <label for="khoangCach">Khoảng Cách/ km</label>
    </div>

   
    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info" type="submit">
            <c:choose>
                <c:when test="${tuyenXe.id > 0}">Cập nhật thông tin</c:when>
                <c:otherwise>Thêm hoạt động</c:otherwise>
            </c:choose>
        </button>
        <form:hidden path="id"/>
    </div>
</div>

</form:form>


