<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Milestoner | Log In</title>

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

    <style>

        body{ background-color: white; }

        .navbar{ background-color: rgb(230, 230, 230); }

        /*.navbar-right{margin-right: 1%; }*/

        .navbar-right ul{ list-style-type: none; margin-top: 10px; }

        .navbar-right ul li{ display: inline; }

        .navbar-right ul li a{ padding: 10px 100px; color: gray; font-weight: bold; font-family: 'Ubuntu', sans-serif; text-decoration: none; }

        .navbar-right ul li a:nth-child(1){ padding-right: 0px; }

        .navbar-left a{ text-decoration: none; color: gray; font-weight: bold; font-family: 'Ubuntu', sans-serif;  padding-top: 20px; padding-left: 0px; padding-right: 20px; padding-bottom: 20px;}

        .menu-item{ display: inline; float: left; height: 50px; width: 140px; padding-left: 20px; line-height: 50px; text-align: right;}

        .menu-item:nth-child(1){ text-align: left; }

        .pointer{ height: 15px; width: 15px; transform: rotate(45deg); background-color: red; margin: 1px 0px; }

        .pointer:nth-child(2){ margin-left: 90px; }

        #active-pointer{ background-color: white; }

        .banner-desc, .banner-stats{ margin-top: 5%;  }

        #home-head{ margin-bottom: 50px; font-family: 'Ubuntu', sans-serif; font-weight: bold; color: rgb(100, 100, 100)}

        #home-p1{ color: gray; }

        .btn-txt-decoration{ float: left; display: inline; margin-left: 20px; }

        .btn-txt-decoration:nth-child(1){ margin-top: -5px; font-weight: bold; font-family: 'Ubuntu', sans-serif; }

        .btn-add-milestone{ height: 54px; width: 265px; line-height: 50px; border-radius: 100px; margin-top: 50px; }

        .home-fact{ display: inline; float: left; margin-top: 13%; }

        footer{ position:absolute; bottom: 0; left: 0; height: 60px; width: 100%; background-color: rgb(230, 230, 230);}

        #footer-text{ text-align: center; color: rgb(100, 100, 100); margin: 20px 0px; font-size: 12px; }

    </style>

</head>
<body>


<nav class="navbar">

    <div class="container">

        <div class="navbar-left">
            <a href="#">Milestoner</a>
        </div>

        <div class="navbar-right">

            <div class="menu-item">
                <div>HOME</div>
                <div class="pointer" id="active-pointer"></div>
            </div>

            <div class="menu-item">
                <div>Add milestone</div>
                <div class="pointer"></div>
            </div>

            <div class="menu-item">
                <div>Log In</div>
                <div class="pointer"></div>
            </div>

        </div>

    </div>

</nav>

<section>


</section>


<footer>
    <p id="footer-text">Copyright &copy 2019 by MessageBoard</p>
</footer>

</body>
</html>