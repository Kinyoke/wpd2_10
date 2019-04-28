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

    <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">

    <style>


        .navbar-nav{ margin-left: auto; }

        .form-container-login{ margin-top: 11%; }

        .form-group{ margin-top: 8%; }

        .form-check{ margin-top: 5%; margin-bottom: 7%; color: rgb(70, 70, 70); }

        @media only screen and (max-width: 480px) {
            .cover img { width: 90%; height: 100%; margin-left: 5%; }

        }

    </style>

</head>
<body>


<nav class="navbar navbar-expand-md bg-light navbar-light">

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
                    <a class="nav-link" href="http://localhost:8080/milestone/login">Log In</a>
                </li>
            </ul>
        </div>



    </div>

</nav>


<section class="cover">
    <img src="images/landingImage.jpg" alt="landingImage">
</section>


<!-- <footer>
    <p id="footer-text">Copyright &copy 2019 by MessageBoard</p>
</footer> -->

</body>
</html>