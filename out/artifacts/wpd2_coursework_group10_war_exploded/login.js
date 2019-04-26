var BASE_URL = "http://localhost:8080/milestone/APIv1/services/";

// when the login btn is clicked get form values send them to the server then if response is valid
// set a

var payload = {
    "ACTION" : "LOGIN",
    "APP_VERSION" : "1.0.0",
    "CLIENT_ID" : "WPD2",
    "ORIGIN" : "MILESTONER_WEB",
    "SERVICE" : "M_PLANER",
    "UUID" : "DS34-DFFX-54HH-C4IO"
};

$("#login-btn").click(function () {
        if ($("#email_lg").val() != "" && $("#pwd_lg").val() != ""){
            var mpayload = payload; // {email: $("#email_lg").val(), password: $("#pwd_lg").val()};
            mpayload = JSON.stringify(mpayload);
            // call api service for login
             console.log(mpayload);
            serviceHandler("account/login/", mpayload);
        } else{
            alert("fileds empty!");
        }

    }
);


function serviceHandler(serviceType, payload) {

    console.log("calling service api...");

    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {

        if (this.readyState == 4 && this.status == 200) {
            console.log("response from the sever");
            console.log(this.responseText);
        }

    };

    var url = BASE_URL+serviceType;

    xhttp.open("POST", url, true);
    xhttp.setRequestHeader("Content-type", "'application/json; charset=UTF-8");
    xhttp.setRequestHeader("Accept", "application/json");

    xhttp.send(payload);

}



function urlAutoGen(baseurl){

    call_counter++;

    if (call_counter <= 10) {

        resource_url = baseurl + COUNTRY_CODE[nextCountry] + "/indicators/" + INDICATORS[call_counter-1] + "?format=json&" + "date=2009:2015";

        dataLoader();
    }
}


function extractInfo(response, callback){

    myData = JSON.parse(response);

    for (var i = 0; i < myData[1].length; i++) {

        callback(myData[1][i]["country"]["value"], myData[1][i]["indicator"]["value"], myData[1][i]["date"], myData[1][i]["value"]);

    }

}


