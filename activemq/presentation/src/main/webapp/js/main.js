function removeProjectCost(projectId, costId, element) {
    $.ajax({
        url: 'projectCost?projectId=' + projectId + '&projectCostId=' + costId,
        type: 'DELETE',
        success: function(result) {
            element.closest('tr').remove();
        }
    });
}

var rowTemplate = $('<tr><td class="col-md-1"><button data-projectid="" data-costid="" type="button" class="btn btn-danger cost-remove-button"><i class="glyphicon glyphicon-trash"></i>Delete</button></td><td class="col-md-10 cost-value-holder"></td></tr>')

function addProjectCost(cost, projectId) {
    $.ajax({
        url: 'projectCost?projectId=' + projectId + '&projectCost=' + cost,
        type: 'PUT',
        success: function(result) {
            var lasttr = $('#projectCostsId').find('tr:last');
            var tr = rowTemplate.clone();
            tr.find('.cost-remove-button').data('projectid', projectId);
            tr.find('.cost-value-holder').html(cost);
            lasttr.after(tr);
        }
    });
}

function submitProject(projectId, projectTitle, projectDescription) {
    $.ajax({
        url: 'project',
        type: 'POST',
        data: {projectId : projectId, projectTitle : projectTitle, projectDescription : projectDescription},
        success: function(result) {
            $('#inputModal').modal('hide');
        }
    });
}