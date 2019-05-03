<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Milestoner | Dashboard</title>

    <meta property="og:url"           content="http://localhost:8080/milestone/dashboard" />
    <meta property="og:type"          content="website" />
    <meta property="og:title"         content="Milestoner" />
    <meta property="og:description"   content="Milestoner, helps you track and manage your goals with easy!" />
    <meta property="og:image"         content="https://www.your-domain.com/path/image.jpg" />

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="vendors/bootstrap4/css/bootstrap.css">

    <!-- jQuery library -->
    <script src="vendors/jquery/jquery-3.3.1.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="vendors/bootstrap4/js/bootstrap.js"></script>

    <link rel="stylesheet" href="vendors/fontawesome-free-5.4.2-web/css/all.css">

    <link href="https://fonts.googleapis.com/css?family=Ubuntu:400,500" rel="stylesheet">

    <link href="style/dashboard.css" rel="stylesheet">

</head>
<body>

<%
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setDateHeader("Expires", 0);
    response.setHeader("Pragma","no-cache");

    String user = (String) session.getAttribute("user_acc");
    String actvitySession = (String) session.getAttribute("session");

    if(user == null && actvitySession == null) response.sendRedirect("login");

%>


<nav class="navbar navbar-expand-md bg-light navbar-light" style="position: fixed; width: 100%; z-index: 1000;">

    <div class="container">

        <!-- Brand -->
        <a class="navbar-brand" href="http://localhost:8080/milestone/">Milestoner</a>

        <!-- Toggler/collapsibe Button -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Navbar links -->
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/milestone/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/milestone/dashboard">Add Milestone</a>
                </li>
                <li class="nav-item">
                    <%--<a class="nav-link" href="#" id="logout-btn">Log out</a>--%>

                    <form novalidate id="reExdsbn" accept-charset="UTF-8"></form>

                    <input type="text" hidden form="reExdsbn" name="payload" id="payload">

                    <button id="SDXC34DF" name="SDXC34DF" class="btn btn-block"><i class="fa fa-power-off"></i></button>

                </li>
            </ul>
        </div>

        <%

            if (request.getParameter("payload") != null){
                if (request.getParameter("payload").equals("INACTIVE")){
                    session.removeAttribute("user_acc");
                    session.removeAttribute("session");
                    response.sendRedirect("login");
                }
            }
        %>



    </div>

</nav>


<div id="main">

    <div id="init-banner">Milestone dashboard!</div>

    <div class="container" id="search-menu-lg" style="margin-top: 50px;">

        <div id="search-menu-pane" style="width: 94%; height: 50px; margin-left: 6%;">

            <div class="search-menu search-menu-left col-lg-6">

                <div class="search-menu-left-item col-lg-4">
                    <p style="font-size: 28px; font-weight: bold;">Search:</p>
                </div>

                <div class="search-menu-left-item col-lg-8">
                    <input type="text" class="form-control" name="keyword" id="keyword" placeholder="By Milestone description">
                </div>

            </div>

            <div class="search-menu search-menu-right col-lg-6">

                <div class="search-menu-left-item col-lg-2">
                    <p style="font-size: 28px; font-weight: bold;">Or</p>
                </div>

                <div class="search-menu-left-item col-lg-10">
                    <input type="text" class="form-control" name="m-id" id="m-id" placeholder="By Milestone Id number">
                </div>

            </div>

        </div>

    </div>


    <div id="tabination" class="container" style="height: 100px;">
        <div id="tabination-container" class="container" style="width: 89.3%; height: 50px; background-color: rgb(200, 200, 200); float: right; margin-top: 30px; margin-right: 19px; border-radius: 10px;">
            <div class="row">
                <div class="tabs-btn" id="active-tab">ALL MILESTONE</div>
                <div class="tabs-btn">COMPLETED</div>
                <div class="tabs-btn">PENDING</div>
                <div class="tabs-btn">INCOPLETE</div>
            </div>
        </div>
    </div>

    <div id="main-pane" class="col-lg-12">

        <%--<div class="main-pane-container main-pane-left">--%>
            <%--<div class="pg-counter">--%>
                <%--<div class="pg-counter-progress">--%>
                    <%--<div id="pg-cr-countainer">--%>
                        <%--<div class="pg-counter-cr"></div>--%>
                        <%--<div class="pg-counter-cr"></div>--%>
                        <%--<div class="pg-counter-cr"></div>--%>
                        <%--<div class="pg-counter-cr"></div>--%>
                        <%--<div class="pg-counter-cr"></div>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

        <div class="main-pane-container main-pane-right"></div>

            <div id="more-milestone-btn">
                <button>
                    <i class="fa fa-angle-double-down"></i>
                </button>
            </div>


            <div id="footer">
                <span id="footer-text">Copyright &copy 2019 by Milestoner.net</span>
            </div>

    </div>


</div>


<div id="overlay">
    <form id="milestone-form" accept-charset="UTF-8"></form>
    <%--create milestone--%>
    <div class="milestone-form-container" id="milestone-form-container-active">
        <div class="m-form-headr">
            <div class="cancel-btn-holder"><span><i class="fa fa-plus cancel-btn"></i></span></div>
            <div>
                <h3 class="act-mile-header">Add Milestone</h3>
            </div>
        </div>
        <div class="milestone-create-form">
            <label for="author-create">Author</label>
            <input type="text" id="author-create" name="author-create" disabled class="form-control">
            <label for="duedate-create">Due date</label>
            <input type="date" name="duedate-create" id="duedate-create" class="form-control">
            <label for="actualdate-create">Actual complition date</label>
            <input type="date" name="actualdate-create" id="actualdate-create" class="form-control">
            <label for="description-create">Milestone description</label>
            <textarea name="description-create" id="description-create" class="form-control"></textarea>
        </div>
        <div class="m-form-footer">
            <button id="create-milestone" class="btn btn-block btn-info">Create milestone</button>
        </div>
    </div>

    <div class="milestone-form-container">
        <div class="m-form-headr">
            <div class="cancel-btn-holder"><span><i class="fa fa-plus cancel-btn"></i></span></div>
            <div>
                <h3 class="act-mile-header">Edit Milestone</h3>
            </div>
        </div>
        <div class="milestone-create-form">
            <label for="author-edit">Author</label>
            <input type="text" id="author-edit" name="author-edit" disabled class="form-control">
            <label for="duedate-edit">Due date</label>
            <input type="date" name="duedate-edit" id="duedate-edit" class="form-control">
            <label for="actualdate-edit">Actual complition date</label>
            <input type="date" name="actualdate-edit" id="actualdate-edit" class="form-control">
            <select id="edit-mstatus" class="form-control">
                <option>Select a status of this milestone</option>
                <option>complete</option>
                <option>incoplete</option>
                <option>pending</option>
            </select>
            <label for="description-edit">Milestone description</label>
            <textarea name="description-edit" id="description-edit" class="form-control"></textarea>
        </div>
        <div class="m-form-footer">
            <button id="edit-milestone" class="btn btn-block btn-info">Save milestone</button>
        </div>
    </div>

    <div class="milestone-form-container" style="margin-top: 14%;">

        <div class="m-form-headr">
            <div class="cancel-btn-holder"><span><i class="fa fa-plus cancel-btn"></i></span></div>
            <div>
                <h3 class="act-mile-header">Delete Milestone</h3>
            </div>
        </div>

        <div class="milestone-create-form">
            <p>Are you sure you want to delete Milestone "<span id="milestone-name">this milestone</span>" This action can to be undone!</p>
        </div>

        <div class="m-form-footer">
            <button id="delete-milestone" class="btn btn-block btn-danger">Delete milestone</button>
        </div>
    </div>


</div>

<div id="add-milestone">
    <div id="add-milestone-btn">
        <i class="fa fa-plus"></i>
    </div>
</div>

<!-- Load Facebook SDK for JavaScript -->
<%--<div id="fb-root"></div>--%>
<%--<script>(function(d, s, id) {--%>
    <%--var js, fjs = d.getElementsByTagName(s)[0];--%>
    <%--if (d.getElementById(id)) return;--%>
    <%--js = d.createElement(s); js.id = id;--%>
    <%--js.src = "https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v3.0";--%>
    <%--fjs.parentNode.insertBefore(js, fjs);--%>
<%--}(document, 'script', 'facebook-jssdk'));</script>--%>

<!-- Your share button code -->
<%--<div class="fb-share-button"--%>
     <%--data-href="https://www.your-domain.com/your-page.html"--%>
     <%--data-layout="button_count">--%>
<%--</div>--%>


<script src="script/client.js"></script>
<script src="script/dashboard.js"></script>

</body>
</html>