<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Milestoner | Home</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

    <link href="https://fonts.googleapis.com/css?family=Ubuntu:400,500" rel="stylesheet">

    <style>


        .navbar-nav{ margin-left: auto; }

        .form-container-login{ margin-top: 11%; }

        .form-group{ margin-top: 8%; }

        .form-check{ margin-top: 5%; margin-bottom: 7%; color: rgb(70, 70, 70); }

        .search-menu{ float: left; height: 70px; }

        .search-menu-left-item{ height: 50px; float: left;

        }

        .tabs-btn{ height: 40px; width: 247.8px; background-color: rgb(200, 200, 200); float: left; display: inline-block; text-align: center; line-height: 40px; font-weight: bold; color: rgb(130, 130, 130); margin-top: 5px; font-family: 'Ubuntu', sans-serif; border-radius: 8px; transition: .2s; }

        #active-tab{ background-color: rgb(170, 170, 170); color: rgb(100, 100, 100); font-size: 13px; }
        /*..tabs-btn:nth-child(2){ border-top-left-radius: 0px; borbl }*/

        .tabs-btn:hover{ cursor: pointer ;}

        #main-pane{ margin-top: 60px; }

        /*.milestone-container{ background-color: red; he}*/

        .main-pane-container{ display: inline-block; float: left; }

        .main-pane-left{ height: 350px; width: 15.5%; position: fixed;}

        .main-pane-right{ width: 76%; margin-left: 15.5%;}

        .pg-counter{ height: 350px; width: 2%; background-color: rgb(200, 200, 200); margin-left: 40%; border-radius: 100px;}

        .pg-counter-progress{ height: 95px; width: 100%; background-color: rgb(160, 160, 160); border-radius: 100px; }

        .pg-counter-cr{ height: 15px; width: 15px; background-color: rgb(200, 200, 200); border-radius: 100%; margin-left: -5px; margin-top: 68.5px; }

        .pg-counter-cr:nth-child(1){ margin-top: 0px; background-color: rgb(160, 160, 160); }

        #pg-cr-countainer{ position: absolute; }

        .milestone-pane{ height: 120px; width: 86.9%; border: 1px solid rgb(200, 200, 200); float: left; display: inline-block; margin-bottom: 30px; }

        .milestone-pane-left{ background-color: rgb(200, 200, 200); width: 11.9%; line-height: 120px; text-align: center; font-size: 40px; font-weight: bold; font-family: 'Ubuntu', sans-serif;  color: gray; }

        .m-desc{ height: 60px; font-size: 23px; font-family: sans-serif;  padding-left: 60px; font-weight: bold; color: gray;}

        .m-meta-dt{ height: 60px;  }

        ul{ list-style-type: none; }

        ul li{ float: left; display: inline-block; padding: 0px 10px; color: rgb(90, 90, 90); }

        /*ul li:nth-child(1){ padding: 10px -100px; }*/

        .dot{ height: 10px; width: 10px; background-color: gray; border-radius: 100%; float: left; display: inline-block; margin: 7px 5px; }

        .form-control{
            border-style: none; border-bottom: 1px solid gray; border-radius: 0px;
        }

        .form-control:focus{ box-shadow: none; }

        #action-items ul{ list-style-type: none; }

        #action-items ul li{ display: block; float: left;  }

    </style>

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


<nav class="navbar navbar-expand-md bg-light navbar-light">

    <div class="container">

        <!-- Brand -->
        <a class="navbar-brand" href="http://localhost:8080/milestone/">Milestoner</a>

        <!-- Toggler/collapsibe Button -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>

        <form novalidate id="reExdsbn" accept-charset="UTF-8"></form>

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
                    <a class="nav-link" href="#" id="logout-btn">Log out</a>

                    <input type="text" hidden form="reExdsbn" name="payload" id="payload">

                    <button id="SDXC34DF" name="SDXC34DF" class="btn btn-block"></button>

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

        <div class="main-pane-container main-pane-left">
            <div class="pg-counter">
                <div class="pg-counter-progress">
                    <div id="pg-cr-countainer">
                        <div class="pg-counter-cr"></div>
                        <div class="pg-counter-cr"></div>
                        <div class="pg-counter-cr"></div>
                        <div class="pg-counter-cr"></div>
                        <div class="pg-counter-cr"></div>
                    </div>
                </div>
            </div>
        </div>


        <div class="main-pane-container main-pane-right">

            <div class="milestone-container">

                <div class="milestone-pane milestone-pane-left">
                    <span class="id-ml">1</span>
                </div>


                <div class="milestone-pane milestone-pane-right">
                    <div class="m-desc col-lg-12 container">
                        <span class="ml-desc">Clean and drinkable water is possible to all citizens of wakanda!</span>
                    </div>
                    <div class="m-meta-dt col-lg-12 container">
                        <div class="m-meta-block">
                            <ul>
                                <li>Author: Jane Doe</li>
                                <li>Due date: 12 may 2019</li>
                                <li>Actual completion date: 22 may 2019</li>
                            </ul>
                        </div>
                        <div class="m-meta-block" style="float: right; margin-right: 65px;">
                            <div id="m-edt-opts">
                                <div id="opt-cir-menu">
                                    <div class="dot"></div>
                                    <div class="dot"></div>
                                    <div class="dot"></div>
                                </div>
                                <div id="opt-content" style="height: 100px; width: 150px; background-color: red;">
                                    <div id="arr-up"><i class="fa fa-sort-up"></i></div>
                                    <div id="action-items">
                                        <ul>
                                            <li>Edit Milestone</li>
                                            <li>Delete Milestone</li>
                                            <li>Share Milestone</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>


            <div class="milestone-container">

                <div class="milestone-pane milestone-pane-left">
                    <span class="id-ml">2</span>
                </div>


                <div class="milestone-pane milestone-pane-right">
                    <div class="m-desc col-lg-12 container">
                        <span class="ml-desc">I believe humans will colonize planet mars some days to come, I hope it not too far.</span>
                    </div>
                    <div class="m-meta-dt col-lg-12 container">
                        <div class="m-meta-block">
                            <ul>
                                <li>Author: John Doe</li>
                                <li>Due date: 12 may 2019</li>
                                <li>Actual completion date: 22 may 2019</li>
                            </ul>
                        </div>
                        <div class="m-meta-block" style="float: right; margin-right: 65px;">
                            <div id="m-edt-opts">
                                <div id="opt-cir-menu">
                                    <div class="dot"></div>
                                    <div class="dot"></div>
                                    <div class="dot"></div>
                                </div>
                                <div id="opt-content"></div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <div class="milestone-container">

                <div class="milestone-pane milestone-pane-left">
                    <span class="id-ml">3</span>
                </div>


                <div class="milestone-pane milestone-pane-right">
                    <div class="m-desc col-lg-12 container">
                        <span class="ml-desc">Clean and drinkable water is possible to all citizens of wakanda!</span>
                    </div>
                    <div class="m-meta-dt col-lg-12 container">
                        <div class="m-meta-block">
                            <ul>
                                <li>Author: Jane Doe</li>
                                <li>Due date: 12 may 2019</li>
                                <li>Actual completion date: 22 may 2019</li>
                            </ul>
                        </div>
                        <div class="m-meta-block" style="float: right; margin-right: 65px;">
                            <div id="m-edt-opts">
                                <div id="opt-cir-menu">
                                    <div class="dot"></div>
                                    <div class="dot"></div>
                                    <div class="dot"></div>
                                </div>
                                <div id="opt-content"></div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <div class="milestone-container">

                <div class="milestone-pane milestone-pane-left">
                    <span class="id-ml">4</span>
                </div>


                <div class="milestone-pane milestone-pane-right">
                    <div class="m-desc col-lg-12 container">
                        <span class="ml-desc">Clean and drinkable water is possible to all citizens of wakanda!</span>
                    </div>
                    <div class="m-meta-dt col-lg-12 container">
                        <div class="m-meta-block">
                            <ul>
                                <li>Author: Jane Doe</li>
                                <li>Due date: 12 may 2019</li>
                                <li>Actual completion date: 22 may 2019</li>
                            </ul>
                        </div>
                        <div class="m-meta-block" style="float: right; margin-right: 65px;">
                            <div id="m-edt-opts">
                                <div id="opt-cir-menu">
                                    <div class="dot"></div>
                                    <div class="dot"></div>
                                    <div class="dot"></div>
                                </div>
                                <div id="opt-content"></div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>


        </div>

    </div>

</div>


<!-- <div id="footer" style="height: 70px; width: 100%; background-color: rgb(200, 200, 200); text-align: center; line-height: 70px;">
    <p id="footer-text" style="color: rgb(100, 100, 100); font-size: 13px; font-family: arial;">Copyright &copy 2019 by Milestoner.net</p>
</div>
-->
<script src="script/dashboard.js"></script>
<script src="script/client.js"></script>

</body>
</html>