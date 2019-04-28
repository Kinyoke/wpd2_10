<%@ page import="net.wpd2_coursework_group10.database.DatabaseConnector" %>
<%@ page import="java.security.MessageDigest" %>
<%@ page import="java.math.BigInteger" %>
<%@ page import="java.security.NoSuchAlgorithmException" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
    <meta charset=" UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Milestoner | Login</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

    <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">

    <link href="https://fonts.googleapis.com/css?family=Ubuntu:400,700" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <style>

        body{ background-color: #53D090; font-family: 'Ubuntu', sans-serif; }

        .app-form-container{ margin-top: 10%; width: 370px; background-color: rgb(50 ,50, 50); transition: .3s; border-radius: 40px; }

        #img-holder{ height: 120px; width: 120px; background-color: #69797E; border-radius: 100%; position: absolute; margin: -60px 8.3%; border: 5px solid #767676; z-index: 100;}

        #img-holder img{ width: 92%; margin: 6px 4px; border-bottom-left-radius: 100%; border-bottom-right-radius: 100%; }

        .fa-plus{ height: 22px; width: 22px; text-align: center; line-height: 17px; background-color: #53D090; border-radius: 100%; border: 2px solid white; color: white; margin: 75px 90px; z-index: 200; position: absolute;}

        .fa-plus:hover{ cursor: pointer; }

        .tab-menu{ margin-top: 50px; height: 70px; width: 100%; background-color: rgb(50 ,50, 50); display: inline; float: left; line-height: 85px; text-align: center; border-bottom: 2px solid #767676; color: #767676; font-size: 18px;
            transition: .5s; display: none;}

        .tab-menu:hover{ cursor: pointer; }

        .tab-menu-active{ display: block; }

        #tab-menu-active{ font-weight: bolder; border-bottom: 5px solid white; margin-top: 52px; color: white; }

        .navbar-nav{ margin-left: auto; }

        .form-container-form{ padding-top: 125px; padding-bottom: 20px; display: none; }

        #active-form{ display: block; }

        label{ color: #69797E; font-size: 12px; }

        .form-group{ margin-top: 5%; }

        /*.form-check{ margin-top: 5%; margin-bottom: 7%; color: rgb(70, 70, 70); }*/

        .form-control{ background-color: #69797E; border-color: #69797E; border-radius: 8px; font-size: 12px; }

        .form-control:focus{ background-color: #69797E; border-color: gray; color: white; }

        .btn-block{ margin-top: 30px; margin-bottom: 10px; background-color: #53D090; color: white; border-radius: 10px;}

        /*#strength-ind{ height: 70px; width: 70px; border-radius: 100%; background-color: rgb(50, 50, 50); border: 3px solid #69797E; position: absolute; margin: -55px 225px; color: white; font-size: 18px; text-align: center; line-height: 60px; }*/

        #signup-resetp{ padding: 0px 10px; color: #69797E; font-weight: bold; font-size: 15px; }

        #signup-resetp:hover{ cursor: pointer; }

        .btn-block:hover{ color: white; opacity: 0.9; }

        /*#pwd-org{ width: 280px; }*/

        span#procent {
            display: block;
            position: absolute;
            left: 50%;
            top: 50%;
            font-size: 12px;
            font-weight: bold;
            transform: translate(-50%, -50%);
            color: #FF9800;
        }

        span#procent::after {
            content: '%';
        }

        .canvas-wrap {
            position: absolute;
            width: 50px;
            height: 50px;
            border-radius: 100%;
            background-color: rgb(50, 50, 50);
            margin: -45px 242px;
            display: none;
        }

        #prof-img{
            display: none;
        }

        #spinner-container{ margin: auto; height: 80px; width: 80px; margin-top: -10px;}
        #spinner-text{ height: 20px; width: 100px; margin: auto; padding: 30px 0px; text-align: center; color: rgb(110, 110, 110); font-size: 15px; font-weight: bolder; }

        #loading_spinner{ width: 100%; }

    </style>

</head>
<body>

    <%
        String user = (String) session.getAttribute("user_acc");
        String actvitySession = (String) session.getAttribute("session");

        if(user != null && actvitySession != null) response.sendRedirect("dashboard");
    %>

<section>

    <div class="app-form-container container">

        <div id="img-holder">
            <span id="upload-img-plus"><i class="fa fa-plus"></i></span>
            <img src="images/maleuser.png">
            <input type="file" name="prof-img" id="prof-img">
        </div>

        <div class="container" style="width: 95%;">

            <div>
                <div class="tab-menu col-lg-6 tab-menu-active" id="tab-menu-active">Login</div>
                <div class="tab-menu col-lg-6">Reset Password</div>
                <div class="tab-menu col-lg-6 tab-menu-active">Sign Up</div>
                <div class="tab-menu col-lg-6">Back</div>
            </div>

            <form novalidate id="user-form" accept-charset="UTF-8"></form>

            <div class="form-container-form" id="active-form">

                <div class="form-group">
                    <label for="email_lg">EMAIL</label>
                    <input type="email" class="form-control" id="email_lg" name="email_lg">
                </div>

                <div class="form-group">
                    <label for="pwd_lg">PASSWORD</label>
                    <input type="password" class="form-control" id="pwd_lg" name="pswd_lg">
                </div>

                <input type="text" hidden form="user-form" name="data-form" id="data-form">

                <button id="login-btn" name="login-btn" class="btn btn-block">Submit</button>

                <%
                    if (request.getParameter("data-form") != null){
                        String req = (String) request.getParameter("data-form");
                        String secreteWord = "ULTR415M4N@DARTZ2019";
                        String acc_user = req.split(",")[0];
                        String acc_session = req.split(",")[1];

                        DatabaseConnector databaseConnector = new DatabaseConnector();

                        if (databaseConnector.getCollectionCount("AccountLogs") > 0) {
                            if (acc_session.equals(databaseConnector.getSessionId(acc_user))){
                                try {
                                    MessageDigest md = MessageDigest.getInstance("MD5");
                                    byte[] messageDigest = md.digest((acc_session+secreteWord).getBytes());
                                    BigInteger no = new BigInteger(1, messageDigest);
                                    // Convert message digest into hex value
                                    String hashtext = no.toString(16);
                                    while (hashtext.length() < 32) {
                                        hashtext = "0".concat(hashtext);
                                    }
                                    acc_session = hashtext;
                                }

                                // For specifying wrong message digest algorithms
                                catch (NoSuchAlgorithmException e) {
                                    throw new RuntimeException(e);
                                }

                                session.setAttribute("user_acc", acc_user);
                                session.setAttribute("session", acc_session);

                                response.sendRedirect("dashboard");
                            }
                        }

                    }


                %>

                <p id="signup-resetp" style="text-align: center; margin-top: 20px;"><u>FORGOT YOUR PASSWORD?</u></p>


            </div>


            <div class="form-container-form">

                <!-- <form action="/action_page.php" class="needs-validation" novalidate></form>
-->

                <div class="form-group">
                    <label for="uname">FULL NAME</label>
                    <input type="text" class="form-control" id="uname" name="uname">
                </div>

                <div class="form-group">
                    <label for="email_r">EMAIL</label>
                    <input type="text" class="form-control" id="email_r" placeholder="email" name="email_r">
                </div>

                <div class="form-group">
                    <label for="pswd_r">PASSWORD</label>
                    <input type="password" class="form-control pwd" id="pswd_r" name="pswd_r" required>

                    <div class="canvas-wrap">
                        <canvas id="canvas" width="100" height="100" style=" margin-top: 100px; margin: -24px -25px;"></canvas>
                        <span id="procent"></span>
                    </div>

                </div>


                <div class="form-group">
                    <label for="pswd_con">CONFIRM PASSWORD</label>
                    <input type="password" class="form-control pwd" id="pswd_con" name="pswd_con">
                </div>

                <button type="submit" id="signup-btn" class="btn btn-block">Create account</button>

            </div>



            <div class="form-container-form">

                <!-- <form action="/action_page.php" class="needs-validation" novalidate></form>
-->
                <div class="form-group">
                    <label for="email-reset">EMAIL</label>
                    <input type="email" class="form-control" id="email-reset" name="email-reset">
                </div>


                <button type="submit" class="btn btn-block" id="resetp-btn">Submit</button>


            </div>



            <div class="form-container-form">


                <div id="spinner-container">
                    <img id="loading_spinner" src="images/loading_spinner.gif">
                </div>

                <div id="spinner-text">
                    <span id="loadtext">Loading...</span>
                </div>

            </div>


        </div>


    </div>



</section>


<script src="script/script.js"></script>
<script src="script/client.js"></script>

</body>
</html>