<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="portfolioBean" class="com.synisys.test.messaging.web.bean.PortfolioBean" scope="session"/>
<c:set var="project" value="${portfolioBean.findProject(param.id)}"/>
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                    aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="exampleModalLabel">New message</h4>
        </div>
        <div class="modal-body">
            <div class="form-group">
                <label for="descriptionId">Title</label>
                <input type="text" class="form-control" id="titleId" placeholder="Enter Title" value="${project.title}">
            </div>
            <div class="form-group">
                <label for="descriptionId">Description</label>
                    <textarea rows="3" class="form-control" id="descriptionId"
                              placeholder="Enter Description">
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
                                <button type="button" class="btn btn-danger">
                                    <i class="glyphicon glyphicon-trash"></i>
                                    Delete
                                </button>
                            </td>
                            <td class="col-md-10">
                                <c:out value="${projectCost.amount}"/>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="input-group">
                    <input id="costId" type="number" class="form-control" placeholder="Enter Cost">
                    <span class="input-group-btn">
                        <button type="button" class="btn btn-default">Add Cost</button>
                    </span>
                </div>
            </div>

        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default">Submit</button>
        </div>
    </div>
</div>
