BASE_URL = "localhost:8080/milestone/APIv1/services/";

// when the login btn is clicked get form values send them to the server then if response is valid
// set a


$("#login-btn").click(function () {
        if ($("#email_lg").val() != "" && $("#pwd_lg").val() != ""){
            var payload = {"email": $("#email_lg").val(), "password": $("#pwd_lg").val()};
            payload = JSON.stringify(payload);
            payload = JSON.parse(payload);
            console.log(payload);

            // call api service for login
            serviceHandler("account/login/", payload);

        } else{
            alert("fileds empty!");
        }

    }
);


function serviceHandler(serviceType, payload) {

    console.log("calling service api...");

    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {

        console.log("waiting for response...");

        if (this.readyState == 4 && this.status == 200) {
            console.log("response from the other side of the world");
            console.log(this.response);
        }

    };

    xhttp.open("POST", BASE_URL+serviceType, true);

    xhttp.setRequestHeader("Content-type", "'application/json");

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


