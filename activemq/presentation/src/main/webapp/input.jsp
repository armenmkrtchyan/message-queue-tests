<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Test Input</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

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

</head>

<body style="background-color: #f6f6f6">
<div class="container panel panel-default">
    <div class="row panel-body">
        <div class="col-lg-12">
            <form>
                <div class="form-group">
                    <label for="descriptionId">Title</label>
                    <input type="email" class="form-control" id="titleId" placeholder="Enter Title">
                </div>
                <div class="form-group">
                    <label for="descriptionId">Description</label>
                    <textarea rows="3" class="form-control" id="descriptionId"
                              placeholder="Enter Description"></textarea>
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
                        <tr>
                            <td class="col-md-1">
                                <button type="button" class="btn btn-danger">
                                    <i class="glyphicon glyphicon-trash"></i>
                                    Delete
                                </button>
                            </td>
                            <td class="col-md-10">101</td>
                        </tr>
                        <tr>
                            <td class="col-md-1">
                                <button type="button" class="btn btn-danger">
                                    <i class="glyphicon glyphicon-trash"></i>
                                    Delete
                                </button>
                            </td>
                            <td class="col-md-10">102</td>
                        </tr>
                        <tr>
                            <td class="col-md-1">
                                <button type="button" class="btn btn-danger">
                                    <i class="glyphicon glyphicon-trash"></i>
                                    Delete
                                </button>
                            </td>
                            <td class="col-md-10">103</td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="input-group">
                        <input id="costId" type="number" class="form-control" placeholder="Enter Cost">
                        <span class="input-group-btn">
                            <button type="button" class="btn btn-default">Add Cost</button>
                        </span>
                    </div>
                </div>

                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
    </div>
</div>

<!-- jQuery Version 1.11.1 -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

</body>

</html>
