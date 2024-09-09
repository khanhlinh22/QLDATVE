<%-- 
Document   : index
Created on : May 5, 2024, 1:05:13 AM
Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="mt-1">
    <sec:authorize access="hasRole('ADMIN')">

    </sec:authorize>

    <div>
        <a href="<c:url value="/admin/tuyenxes" />" class="btn btn-info">Thêm hoạt động
        </a>
    </div>
    <table class="table table-striped mt-1">

        <tr>
            <th>ID</th>
            <th>Tên Tuyến </th>
            <th>Điểm Đến</th>
            <th>Điểm Đi</th>
            <th>Tần Suất</th>
            <th>Khoảng Cách</th>
            <th></th>
        </tr>

        <tbody>
            <c:forEach items="${tuyenXes}" var="c">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.tenTuyen}</td>
                    <td>${c.diemDi}</td>
                    <td>${c.diemDen}</td>
                    <td>${c.tanSuat}</td>
                    <td>${c.khoangCach}</td>



                    <c:url value="/admin/tuyenxes/${c.id}" var="url"/>
                    <sec:authorize access="hasRole('ADMIN')">

                    </sec:authorize>
                    <td>
                        <a href="<c:url value="/admin/tuyenxes/${c.id}" />" class="btn btn-info">Cập nhật</a>
                        <button onclick="deleteTuyenXe('${url}')" class="btn btn-danger">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<script src="<c:url value="/js/script.js" />"></script>

