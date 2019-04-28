window.onload = function() {

    var can = document.getElementById('canvas'),

        spanProcent = document.getElementById('procent'),

        c = can.getContext('2d');

    var posX = can.width / 2;
    var posY = can.height / 2;
    var fps = 1000 / 200;
    var procent = 0;

    var oneProcent = 360 / 100;
    var passwordStrength = 0;
    var indColor = "";
    var result = oneProcent * 100;
    var deegres = 0;

    c.lineCap = 'round';


    function strengthMeasure(strength_arg, color){

        $(".canvas-wrap").css({"display": "block"});

        $("#pwd-org").css({"width": "280px"});

        // var acrInterval = setInterval (function() {

        deegres = strength_arg;

        c.clearRect( 0, 0, can.width, can.height );

        procent = deegres / oneProcent;

        spanProcent.innerHTML = procent.toFixed();

        c.beginPath();

        c.arc( posX, posY, 24, (Math.PI/180) * 270, (Math.PI/180) * (270 + 360) );

        c.strokeStyle = '#69797E';

        c.lineWidth = '5';

        c.stroke();

        c.beginPath();

        c.strokeStyle = color;

        c.lineWidth = '5';

        c.arc( posX, posY, 24, (Math.PI/180) * 270, (Math.PI/180) * (270 + deegres) );

        c.stroke();

        // if( deegres >= result ) clearInterval(acrInterval);

        // }, fps);

    }




    $(".tab-menu").click(function(e) {

        var elemPosition = $(".tab-menu").index(this);

        switch(elemPosition){

            case 0:
                //
                $(".app-form-container").css({"height":"440px", "margin-top": "10%"});
                $(".form-container-form:eq(0)").fadeIn();
                $(".form-container-form:eq(1)").css({"display":"none"});
                $(".tab-menu:eq(0)").css({"font-weight": "bolder", "border-bottom": "5px solid white", "margin-top": "52px", "color": "white"});
                $(".tab-menu:eq(2)").css({"font-weight": "normal", "border-bottom": "2px solid #767676", "margin-top": "50px", "color": "#767676"});

                break;

            case 2:
                //
                $(".tab-menu:eq(2)").text("Sign Up");
                $(".app-form-container").css({"margin-top": "5%", "height":"590px"});
                $(".form-container-form:eq(1)").fadeIn(1500);
                $(".form-container-form:eq(0), .form-container-form:eq(2)").css({"display":"none"});
                $(".tab-menu:eq(2)").css({"font-weight": "bolder", "border-bottom": "5px solid white", "margin-top": "52px", "color": "white"});
                $(".tab-menu:eq(0)").css({"font-weight": "normal", "border-bottom": "2px solid #767676", "margin-top": "50px", "color": "#767676", "text-align": "center"});

                break;

            case 3:
                //
                $(".tab-menu:eq(0), .tab-menu:eq(2)").css({"display": "block"});
                $(".tab-menu:eq(1), .tab-menu:eq(3)").css({"display": "none"});
                $(".app-form-container").css({"height":"440px", "margin-top": "10%"});
                $(".form-container-form:eq(0)").fadeIn();
                $(".form-container-form:eq(1)").css({"display":"none"});
                $(".tab-menu:eq(0)").css({"font-weight": "bolder", "border-bottom": "5px solid white", "margin-top": "52px", "color": "white"});
                $(".tab-menu:eq(2)").css({"font-weight": "normal", "border-bottom": "2px solid #767676", "margin-top": "50px", "color": "#767676"});

                break;
        }


    });


    $("#signup-resetp").click(function(){
        $(".app-form-container").css({"height":"325px", "margin-top": "14%"});
        $(".form-container-form:eq(2)").fadeIn(1500);
        $(".form-container-form:eq(0)").css({"display":"none"});
        $(".form-container-form:eq(1)").css({"display":"none"});
        $(".tab-menu:eq(0), .tab-menu:eq(2)").css({"display": "none"});
        $(".tab-menu:eq(1)").css({"font-weight": "bolder", "border-bottom": "5px solid white", "margin-top": "52px", "color": "white", "text-align":"left", "display": "block", "font-size": "15px"});
        $(".tab-menu:eq(3)").css({"font-weight": "bolder", "border-bottom": "2px solid white", "margin-top": "50px", "color": "white", "display": "block"});
    });


    $("#pwd-org").keypress(function() {

        // password length and character combination

        // < 5 weak password n
        // > 5 < 9 medium strength
        // > 8 with character combination both a-zA-Z0-9@!@#$%^&*

        var password_length = $("#pwd-org").val().length;
        var strength = 0;
        if (password_length <= 4) {
            strength++;
            if (passwordStrength <= 80) { passwordStrength+=20; }
            $("#pwd-org, #procent").css({"color": "#FF9800"});
            // $("#strength-ind").innerHTML = strength;
            console.log(passwordStrength);

            indColor = "#FF9800";
            // passwordStrength = 20;
        }else if(password_length > 4 & password_length < 8){
            $("#pwd-org, #procent").css({"color": "#FFEB3B"});
            if (passwordStrength <= 140) { passwordStrength+=20; }
            // strengthMeasure(passwordStrength, "#FFEB3B");
            indColor = "#FFEB3B";
            console.log(passwordStrength);
            // passwordStrength = 50;
        }else if(password_length >= 8){
            $("#pwd-org, #procent").css({"color": "#53D090"});
            if (passwordStrength <= 340) { passwordStrength+=20; }
            // strengthMeasure(passwordStrength, "#53D090");
            indColor = "#53D090";
            console.log(passwordStrength);
            // passwordStrength = 100;
        }else if (password_length <= 0) {
            alert(passwordStrength);
            passwordStrength = 0;
            strengthMeasure(passwordStrength, "#FF9800");
        }

        // alert("new key");

        strengthMeasure(passwordStrength, indColor);

    });


    $(".fa-plus").click(function(){
        $("#prof-img").click();
    });


    $("#resetp-btn").click(function(){

        $(".app-form-container").css({"height":"325px", "margin-top": "14%"});
        $(".form-container-form:eq(3)").fadeIn(1500);
        $(".form-container-form:eq(0)").css({"display":"none"});
        $(".form-container-form:eq(1)").css({"display":"none"});
        $(".form-container-form:eq(2)").css({"display":"none"});
        $(".tab-menu:eq(0), .tab-menu:eq(1), .tab-menu:eq(2), .tab-menu:eq(3)").css({"display": "none"});

        var reload = setInterval(function(){

            $(".app-form-container").css({"height":"440px", "margin-top": "10%"});
            $(".form-container-form:eq(0)").fadeIn(1500);
            $(".form-container-form:eq(1)").css({"display":"none"});
            $(".form-container-form:eq(2)").css({"display":"none"});
            $(".form-container-form:eq(3)").css({"display":"none"});
            $(".tab-menu:eq(0), .tab-menu:eq(2)").css({"display": "block"});

            clearInterval(reload);
        }, 2500);

    });





}


