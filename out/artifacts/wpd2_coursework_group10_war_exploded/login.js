var BASE_URL = "http://localhost:8080/milestone/APIv1/services/";


var payload = { "ACTION" : "LOGIN", "APP_VERSION" : "1.0.0", "CLIENT_ID" : "WPD2", "ORIGIN" : "MILESTONER_WEB", "SERVICE" : "M_PLANER", "UUID" : "DS34-DFFX-54HH-C4IO" };

$("#login-btn").click(function () {
        if ($("#email_lg").val() !== "" && $("#pwd_lg").val() !== ""){
            var info = {email: $("#email_lg").val(), password: $("#pwd_lg").val()};
            var mpayload = JSON.stringify(payload);
            serviceHandler("account/login/", mpayload);
        } else{
            alert("fileds empty!");
        }

    }
);


function serviceHandler(serviceType, myPayload) {

    console.log("calling service api...");

    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {

        if (this.readyState === 4 && this.status === 200) {
            console.log("response from the sever");
            console.log(this.responseText);
        }

    };

    var url = BASE_URL+serviceType;

    xhttp.open("POST", url, true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(myPayload);

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


