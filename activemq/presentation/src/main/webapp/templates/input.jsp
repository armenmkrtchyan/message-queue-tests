<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="portfolioBean" class="com.synisys.test.messaging.web.bean.PortfolioBean" scope="session"/>
<c:set var="project" value="${portfolioBean.findProject(param.id)}"/>

<div class="form-group">
    <label for="descriptionId">Title</label>
    <input type="text" class="form-control" id="titleId" placeholder="Enter Title" value="${project.title}">
</div>
<div class="form-group">
    <label for="descriptionId">Description</label>
    <textarea rows="3" class="form-control" id="descriptionId" placeholder="Enter Description">
        <c:out value="${project.description}"/>
    </textarea>
</div>
<div class="form-group">
    <label for="projectCostsId">Project Costs</label>
    <table id="projectCostsId" class="table table-hover table-bordered">
        <thead>
        <tr>
            <th></th>
            <th class="text-center">Project Cost</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cost" items="${project.projectCosts}">
            <tr>
                <td class="col-md-1">
                    <button data-projectid="<c:out value="${project.projectId}"/>" data-costid="<c:out value="${cost.id}"/>"
                            type="button" class="btn btn-danger cost-remove-button">
                        <i class="glyphicon glyphicon-trash"></i>
                        Delete
                    </button>
                </td>
                <td class="col-md-10 cost-value-holder">
                    <c:out value="${cost.amount}"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="input-group">
        <input id="costId" type="number" class="form-control" placeholder="Enter Cost">
        <span class="input-group-btn">
            <button data-projectid="<c:out value="${project.projectId}"/>" type="button" class="btn btn-default cost-add-button">Add Cost</button>
        </span>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $('.cost-remove-button').on('click', function (event) {
            var button = $(this);
            removeProjectCost(button.data('projectid'), button.data('costid'), button);
        });
        $('.cost-add-button').on('click', function (event) {
            var button = $(this);
            addProjectCost($('#costId').val(), button.data('projectid'))
        })

    });
</script>
