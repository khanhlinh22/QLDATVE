<%-- 
    Document   : chuyenxeindex
    Created on : Sep 1, 2024, 8:24:13 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="mt-1">
    <sec:authorize access="hasRole('ADMIN')">

    </sec:authorize>

    <div>
        <a href="<c:url value="/admin/chuyenxes" />" class="btn btn-info">Thêm hoạt động
        </a>
    </div>
    <table class="table table-striped mt-1">

        <tr>
            <th>ID</th>
            <th>Ngày giờ khởi hành </th>
            <th>Giá Vé</th>
            <th>Số Ghế</th>
            <th>Trạng Thái</th>
            <th>Tuyến Xe</th
            <th>Xe</th>
            <th>Tài Xế</th>

            <th></th>
        </tr>

        <tbody>
            <c:forEach items="${chuyenXes}" var="c">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.ngayGioKhoiHanh}</td>
                    <td>${c.giaVe}</td>
                    <td>${c.soGhe}</td>
                    <td>${c.trangThai}</td>
                    <td>${c.tuyenXeId.getTenTuyen()}</td
                     <td>${c.xeId.getSoHieu()}</td>
                    <td>${c.hocKiNamHocId.getHocKiId().getHocKi()}</td>
                    <td>${c.taiXeId.getNguoiDung().getHo()}  ${c.taiXeId.getNguoiDung().getTen()}</td>

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