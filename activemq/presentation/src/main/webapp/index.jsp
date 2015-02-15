<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="portfolioBean" class="com.synisys.test.messaging.web.bean.PortfolioBean" scope="session"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Test Portfolio</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <%-- Jasny Bootstrap CSS --%>
    <link href="css/jasny-bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <style>
        body {
            padding-top: 70px;
            /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
        }
    </style>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery Version 1.11.1 -->
    <script src="js/jquery.js"></script>
    <%-- Project Scripts --%>
    <script src="js/main.js"></script>

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Test Portfolio</a>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Page Content -->
<div class="container">

    <div class="row">
        <div class="col-lg-12 text-center table-responsive" id="tableContent">
            <jsp:include page="templates/portfolioTable.jsp?page=1"/>
        </div>
        <div class="col-lg-12">
            <button type="button" class="btn btn-primary data-input-button"
                    data-id="1000">Create Project
            </button>
        </div>
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12 text-center" id="pagination">
        </div>
    </div>
</div>
<!-- /.container -->

<div class="modal fade" id="inputModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel">New message</h4>
            </div>
            <div class="modal-body" id="inputBody">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default project-submit-button">Submit</button>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>


<!-- Bootpag - bootstrap jquery pagination plugin-->
<script src="js/jquery.bootpag.min.js"></script>


<script type="text/javascript">
    $(document).ready(function () {
        $('#pagination').bootpag({
            total: <c:out value="${portfolioBean.pageCount}"/>,
            page: 1,
            maxVisible: 5
        }).on('page', function (event, num) {
            $("#tableContent").load("templates/portfolioTable.jsp?page=" + num);
        });

        $('.data-input-button').on('click', function (event) {
            $('#inputBody').load('templates/input.jsp?id=' + $(this).data('id'), function () {
                $('#inputModal').modal('show');
            });
        });

        $('.project-submit-button').on('click', function (event) {
            submitProject()
        })
    })
</script>
</body>

</html>