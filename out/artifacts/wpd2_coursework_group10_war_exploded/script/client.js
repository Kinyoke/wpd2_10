var BASE_URL = "http://localhost:8080/milestone/APIv1/services/";


var payload = {
    "ACTION" : "LOGIN",
    "APP_VERSION" : "1.0.0",
    "CLIENT_ID" : "WPD2",
    "DATA" : "custom_data",
    "ORIGIN" : "MILESTONER_WEB",
    "SERVICE" : "M_PLANER",
    "UUID" : "DS34-DFFX-54HH-C4IO"
};

var months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];

var actComDate = "", dueDate = "";



setInterval(function () {
    $("#logout-btn").click();
}, 1000*60*30);


$("#SDXC34DF").click(function () {
    var user = sessionStorage.getItem("accuser");
    var session = sessionStorage.getItem("sessionid");
    payload["DATA"] = {"emailAddress" : user, "session" : session };
    var d_payload = JSON.stringify(payload);
    serviceHandler("account/logout/", d_payload, logOut);
});

function logOut(arg){
    var val = JSON.parse(arg);
    var lgbtn = $("#SDXC34DF");
    if (val["response"]["status"] === "INACTIVE"){
        lgbtn.attr("form", "reExdsbn");
        $("#payload").val("INACTIVE");
        sessionStorage.clear();
        lgbtn.click();
    }

}

$("#login-btn").click(function () {

    var email = $("#email_lg").val();
    var password = $("#pwd_lg").val();

    if (email !== "" && password !== ""){
        payload["DATA"] = {"emailAddress" : email, "password": password};
        var d_payload = JSON.stringify(payload);
        serviceHandler("account/login/", d_payload, logIn);
    } else{
        alert("fileds empty!");
    }

});

function logIn(arg){
    var val = JSON.parse(arg);
    var lgbtn = $("#login-btn");

    console.log(val);

    switch (val["response"]["status"]) {
        case "ACK":
        case "ACTIVE":
            $("#data-form").val(val["response"]["user"]+","+val["response"]["session"]);
            sessionStorage.setItem("accuser", val["response"]["user"]);
            sessionStorage.setItem("sessionid", val["response"]["session"]);
            sessionStorage.setItem("Author", val["response"]["firstName"]+" "+val["response"]["secondName"]);
            lgbtn.attr("form", "user-form");
            lgbtn.click();
            break;
        case "NOACC":
            alert(val["response"]["message"]);
            break;
        case "WPSWD":
            alert(val["response"]["message"]);
            break;
    }

}

$("#signup-btn").click(function () {

    var fullName  = $("#uname").val();
    var emailAddress = $("#email_r").val();
    var password = $("#pswd_r").val();
    var password_confirmation = $("#pswd_con").val();

    // implement input validation somewhere else to catter for wide range of scenarios
    if (fullName !== "" && emailAddress !== "" && password !== "" && password_confirmation !== ""){


        var firstName = "";
        var middleName = "";
        var lastName = "";

        if (fullName.split(" ").length >= 3){
            firstName = fullName.split(" ")[0];
            middleName = fullName.split(" ")[1];
            lastName = fullName.split(" ")[2];

            if (password_confirmation === password){
                payload["DATA"] = {"firstName" : firstName, "middleName" : middleName, "lastName" : lastName, "emailAddress" : emailAddress, "password" : password };
                var d_payload = JSON.stringify(payload);
                serviceHandler("account/signup/", d_payload, register);
            } else{
                alert("Password do not match!");
            }

        }else{
            alert("Enter first, middle and last name with space in between!");
        }

    }else{
        alert("Please fill all the fields!");
    }

});

function register(arg) {
    var val = JSON.parse(arg);

    var sbtn = $("#signup-btn");

    switch (val["response"]["status"]) {
        case "success":
            $("#data-form").val(val["response"]["user"]+","+val["response"]["session"]);
            sessionStorage.setItem("accuser", val["response"]["user"]);
            sessionStorage.setItem("sessionid", val["response"]["session"]);
            sbtn.attr("form", "user-form");
            sbtn.click();
            break;
        case "exist":
            alert(val["response"]["message"]);
            break;
    }

}



function serviceHandler(serviceType, myPayload, callback) {

    console.log("calling service api...");

    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {

        if (this.readyState === 4 && this.status === 200) {
            console.log(this.responseText);
            callback(this.responseText);
        }

    };

    var url = BASE_URL+serviceType;

    xhttp.open("POST", url, true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(myPayload);

}

