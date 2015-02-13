<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="portfolioBean" class="com.synisys.test.messaging.web.bean.PortfolioBean" scope="session"/>
<table class="table table-hover table-bordered">
    <thead>
    <tr>
        <th>#</th>
        <th class="text-center">Title</th>
        <th class="text-center">Total Cost</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${portfolioBean.getProjectsForPage(param.page)}" var="portfolioProject">
        <tr>
            <th scope="row" class="col-md-1">1</th>
            <td class="col-md-9"><c:out value="${portfolioProject.title}"/></td>
            <td class="col-md-3"><c:out value="${portfolioProject.totalCost}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
