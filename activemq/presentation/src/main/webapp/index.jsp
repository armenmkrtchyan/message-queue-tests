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
        <div class="col-lg-12 text-center table-responsive">
            <table class="table table-hover table-bordered">
                <thead>
                <tr>
                    <th>#</th>
                    <th class="text-center">Title</th>
                    <th class="text-center">Total Amount</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row" class="col-md-1">1</th>
                    <td class="col-md-9">First</td>
                    <td class="col-md-3">101</td>
                </tr>
                <tr>
                    <th scope="row" class="col-md-1">2</th>
                    <td class="col-md-9">Second</td>
                    <td class="col-md-3">102</td>
                </tr>
                <tr>
                    <th scope="row" class="col-md-1">3</th>
                    <td class="col-md-9">Third</td>
                    <td class="col-md-3">103</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12 text-center">
            <nav>
                <ul class="pagination">
                    <li class="disabled">
                      <span>
                        <span aria-hidden="true">&laquo;</span>
                      </span>
                    </li>
                    <li class="active">
                        <span>1 <span class="sr-only">(current)</span></span>
                    </li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>
<!-- /.container -->

<!-- jQuery Version 1.11.1 -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

</body>

</html>
