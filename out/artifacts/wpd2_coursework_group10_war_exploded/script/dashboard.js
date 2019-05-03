var pattern = ["01", "02", "03", "04", "05", "06", "07", "08" , "09" , "10", "11", "12"];
var MILESTONE_ID = "";

// $(window).ready(function () {
//     // for (var i = 1; i < 3; i++) milestoneTemplate("", "", "");
   payload["ACTION"] = "LIST MILESTONE";
   payload["DATA"] = {"user" : sessionStorage.getItem("accuser")};
   var d_payload = JSON.stringify(payload);
   serviceHandler("milestone/list", d_payload, loadMilestoneList);
// });


$(".tabs-btn").click(function(){

    var getPos = $(".tabs-btn").index(this);

    if ($(this).attr("id") !== "active-tab") {

        $(".tabs-btn:eq("+getPos+")").attr("id", "active-tab");

        for (var i = 0; i < $(".tabs-btn").length; i++) {

            if(i === getPos) continue;

            $(".tabs-btn:eq("+i+")").attr("id", "");

            console.log("value of i : "+i);

        }
    }

});

function todaysDate() {
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1; //January is 0!
    var yyyy = today.getFullYear();

    if(dd<10) dd='0'+dd;

    if(mm<10) mm='0'+mm;

    today = yyyy+'-'+mm+'-'+dd;

    return today;
}



$("#add-milestone-btn").click(function () {
    $("#author-create").val(sessionStorage.getItem("Author"));
    var dueCreateDate = $("#duedate-create");
    var actualCreateDate = $("#actualdate-create");
    var today = todaysDate();

    dueCreateDate.attr("min", today);

    dueCreateDate.attr("max", "2030-12-12");

    actualCreateDate.attr("min", today);

    actualCreateDate.attr("max", "2030-12-12");

    $(".milestone-form-container:eq("+0+")").css({"display" : "block"});
    $("#overlay").css({"display" : "block"});

});

$(".cancel-btn").click(function () {
    $(".milestone-form-container").css({"display" : "none"});
    $("#overlay").css({"display" : "none"});
});


$("#create-milestone").click(function () {
    var Author = $("#author-create").val();
    var user = sessionStorage.getItem("accuser");
    var dueDate = $('#duedate-create').val();
    var actualDate = $("#actualdate-create").val();
    var description = $('#description-create').val();

    if (dueDate !== "" && actualDate !== "" && description !== "") {
        payload["DATA"] = {"Author" : Author, "user" : user, "dueDate" : dueDate, "actualCompletionDate" : actualDate, "description" : description };
        var d_payload = JSON.stringify(payload);
        serviceHandler("milestone/create", d_payload, addMilestone);
        $(".cancel-btn").click();
    }else{
        alert("Please fill all field!");
    }


});


function loadMilestoneList(data) {
    var myData = JSON.parse(data);
    console.log(myData);
    var length = myData["response"]["payload"].length;
    for (var i = 0; i < length; i++){
        var mid = "";
        if (myData["response"]["payload"][i]["milestoneId"] < 10) mid += "0";
        mid += myData["response"]["payload"][i]["milestoneId"];
        var mauthor = myData["response"]["payload"][i]["author"];
        var mdueDate = formatDate(myData["response"]["payload"][i]["dueDate"]);
        var mactualCompDate = formatDate(myData["response"]["payload"][i]["actualCompletionDate"]);
        var mDescription = myData["response"]["payload"][i]["description"];
        var mstatus = myData["response"]["payload"][i]["status"];
        var style = "none";
        if (i < 8) style = "block";
        milestoneTemplate(mid, mauthor, mDescription, mdueDate, mactualCompDate, mstatus, style);
    }
    if (length > 8){
        $("#more-milestone-btn").css({"display" : "block"});
    }

    attachItemEvents();
}

function addMilestone(payload) {
    var value = JSON.parse(payload);
    if (value["response"]["status"] === "SUCCESS") {
        var mid = "";
        if (value["response"]["data"]["milestoneId"] < 10) mid += "0";
        mid += value["response"]["data"]["milestoneId"];
        var mauthor = value["response"]["data"]["Author"];
        var mdueDate = formatDate(value["response"]["data"]["dueDate"]);
        var mactualCompDate = formatDate(value["response"]["data"]["actualCompDate"]);
        var mDescription = value["response"]["data"]["Description"];
        var mstatus = value["response"]["data"]["status"];
        var style = "none";
        if (mid < 8) style = "block";
        else $("#more-milestone-btn").css({"display" : "block"});
        milestoneTemplate(mid, mauthor, mDescription, mdueDate, mactualCompDate, mstatus, style);
        attachItemEvents();
    }
}

function attachItemEvents() {
    var isMenuItemsVisible = false;

    $(".m-edt-opts").click(function () {
        var itemMenuPos = $(".m-edt-opts").index(this);
        if (!isMenuItemsVisible){
            $(".opt-menu-items:eq("+itemMenuPos+")").css({"display" : "block"});
            isMenuItemsVisible = true;
        }else{
            $(".opt-menu-items:eq("+itemMenuPos+")").css({"display" : "none"});
            isMenuItemsVisible = false;
        }
    });

    $(".item-choice-name-em").click(function () {
        var em_item_index = $(".item-choice-name-em").index(this);
        $(".opt-menu-items:eq("+em_item_index+")").css({"display" : "none"});
        // em_item_index+=1;
        $("#author-edit").val(sessionStorage.getItem("Author"));
        dueDate = $(".due-date:eq("+em_item_index+")").text();
        actComDate = $(".actcomp-date:eq("+em_item_index+")").text();
        var dueDateItem = $("#duedate-edit");
        var actualCompDate = $("#actualdate-edit");
        var tmp = dueDate.split(" ");
        for (var i = 0; i < months.length; i++){
            if (months[i] === tmp[1]){
                var month = (i+1)+"";
                if (i < 10) month= "0"+month;
                dueDateItem.val(""+tmp[2]+"-"+month+"-"+tmp[0]+"");
                break;
            }
        }

        tmp = actComDate.split(" ");

        for (var i = 0; i < months.length; i++){

            if (months[i] === tmp[1]){
                var month = (i+1)+"";
                if (i < 10) month= "0"+month;
                actualCompDate      .val(""+tmp[2]+"-"+month+"-"+tmp[0]+"");
                break;
            }
            // if (months[i] === tmp[1]){
            //     var month = (i+1)+"";
            //     if (i < 10) month= "0"+month;
            //     actualCompDate.val(""+month+"-"+tmp[0]+"-"+tmp[2]+"");
            //     break;
            // }
        }

        var today = todaysDate();

        dueDateItem.attr("min", today);

        dueDateItem.attr("max", "2030-12-12");

        actualCompDate.attr("min", today);

        actualCompDate.attr("max", "2030-12-12");

        $("#overlay").css({"display" : "block"});
        $(".milestone-form-container:eq(1)").css({"display" : "block"});
        $("#description-edit").val($(".ml-desc:eq("+em_item_index+")").text());
        isMenuItemsVisible = false;
    });


    $(".item-choice-name-dm").click(function () {
        var dm_item_index = $(".item-choice-name-dm").index(this);
        $(".opt-menu-items:eq("+dm_item_index+")").css({"display" : "none"});
        // dm_item_index+=1;
        $("#overlay").css({"display" : "block"});
        $(".milestone-form-container:eq(2)").css({"display" : "block"});
        $("#milestone-name").text($(".ml-desc:eq("+dm_item_index+")").text());
        MILESTONE_ID = $(".id-ml:eq("+dm_item_index+")").text();
        isMenuItemsVisible = false;
    });


    $(".item-choice-name-sm").click(function () {
        var sm_item_index = $(".item-choice-name-sm").index(this);
        $(".opt-menu-items:eq("+sm_item_index+")").css({"display" : "none"});
        isMenuItemsVisible = false;
    });

}

$("#delete-milestone").click(function () {
    for (var i = 0; i < pattern.length; i++){
        if (MILESTONE_ID === pattern[i]) {
            MILESTONE_ID = ""+(i+1)+"";
            break;
        }
    }
    payload["DATA"] = { "user" : sessionStorage.getItem("accuser"), "id" : MILESTONE_ID };
    var d_payload = JSON.stringify(payload);
    serviceHandler("milestone/delete", d_payload, deleteMilestone);
});

function deleteMilestone(response) {
    var res = JSON.parse(response);
    console.log(res);
    if (res["response"]["status"] === "DELETED") location.href = "dashboard";
}

function formatDate(date) {
    var newdate = date.split("-");
    for (var i = 0; i < pattern.length; i++){
        if (newdate[1] === pattern[i]) {
            newdate[1] = months[i];
            break;
        }
    }

    return newdate[2]+" "+newdate[1]+" "+newdate[0];
}

function milestoneTemplate(milestoneId, author, description, duedate, actualcomplitiondate, status, style) {

    var parentContainer = document.getElementsByClassName("main-pane-right")[0];

    var milestoneContainer = document.createElement("div");

    milestoneContainer.setAttribute("class", "milestone-container");

    milestoneContainer.style.display = style;

    var statusHolder = document.createElement("input");

    statusHolder.setAttribute("hidden","true");

    statusHolder.setAttribute("type", "text");

    statusHolder.setAttribute("class", "status-holder");

    statusHolder.value = status;

    var leftPane = document.createElement('div');

    leftPane.setAttribute("class", "milestone-pane milestone-pane-left");

    var rightPane = document.createElement("div");

    rightPane.setAttribute("class", "milestone-pane milestone-pane-right");

    var m_desc = document.createElement("div");

    m_desc.setAttribute("class", "m-desc col-lg-12 container");

    var ml_desc = document.createElement("span");

    ml_desc.setAttribute("class", "ml-desc");

    ml_desc.innerHTML = description;

    m_desc.appendChild(ml_desc);

    var id_ml = document.createElement("span");

    id_ml.setAttribute("class", "id-ml");

    id_ml.innerHTML = milestoneId;

    // var ind = $(".id-ml").length;
    //
    // if ($(".id-ml").length+1 < 10) {
    //     id_ml.innerHTML = "0"+($(".id-ml").length + 1);
    // } else{
    //     id_ml.innerHTML = $(".id-ml").length + 1;
    // }

    var mmetadata = document.createElement("div");

    mmetadata.setAttribute("class", "m-meta-dt col-lg-12 container");

    var mmetablock = document.createElement("div");

    mmetablock.setAttribute("class", "m-meta-block");

    mmetadata.appendChild(mmetablock);

    var unlist = document.createElement("ul");

    var itemli_1 = document.createElement("li");

    itemli_1.innerHTML = "Author: <span class=\"author-name\">"+author+"</span>";

    var itemli_2 = document.createElement("li");

    itemli_2.innerHTML = "Due date: <span class=\"due-date\">"+duedate+"</span>";

    var itemli_3 = document.createElement("li");

    itemli_3.innerHTML = "Actual completion date: <span class=\"actcomp-date\">"+actualcomplitiondate+"</span>";

    unlist.appendChild(itemli_1);

    unlist.appendChild(itemli_2);

    unlist.appendChild(itemli_3);

    mmetablock.appendChild(unlist);

    var mmetablockTwo = document.createElement("div");

    mmetablockTwo.setAttribute("class", "m-meta-block");

    mmetablockTwo.setAttribute("style", "float: right; margin-right: 65px;");

    // mmetablockTwo[mmetablockTwo.length-1].style = "float: right; margin-right: 65px;"; // styles = "float: right; margin-right: 65px;";

    var medit = document.createElement("div");

    medit.setAttribute("class", "m-edt-opts");

    // medit.addEventListener("click", function () {
    //     $(".m-edt-opts").click();
    // });

    var optcir = document.createElement("div");

    optcir.setAttribute("class", "opt-cir-menu");

    var faOne = document.createElement("i");

    faOne.setAttribute("class","fa fa-circle");

    faOne.setAttribute("style", "margin-right: 4px");

    var faTwo = document.createElement("i");

    faTwo.setAttribute("class", "fa fa-circle");

    faTwo.setAttribute("style", "margin-right: 4px");

    var faThree = document.createElement("i");

    faThree.setAttribute("class", "fa fa-circle");

    optcir.appendChild(faOne);

    optcir.appendChild(faTwo);

    optcir.appendChild(faThree);

    medit.appendChild(optcir);

    mmetablockTwo.appendChild(medit);

    mmetadata.appendChild(mmetablockTwo);

    var optmenuitem = document.createElement("div");

    optmenuitem.setAttribute("class", "opt-menu-items");

    var aruppt = document.createElement("div");

    aruppt.setAttribute("class", "arr-up-pt");

    var arrupi = document.createElement("i");

    arrupi.setAttribute("class", "fa fa-sort-up");

    aruppt.appendChild(arrupi);

    var myitems = document.createElement("div");

    myitems.setAttribute("class", "items");

    var ichoiceOne = document.createElement("div");

    ichoiceOne.setAttribute("class","item-choice");

    var subchOne = document.createElement("span");

    subchOne.setAttribute("class", "item-choice-name item-choice-name-em");

    subchOne.innerHTML = "Edit milestone";


    var ichoiceTwo = document.createElement("div");

    ichoiceTwo.setAttribute("class","item-choice");

    var subchTwo = document.createElement("span");

    subchTwo.setAttribute("class", "item-choice-name item-choice-name-dm");

    subchTwo.innerHTML = "Delete milestone";


    var ichoiceThree = document.createElement("div");

    ichoiceThree.setAttribute("class","item-choice");

    var subchThree = document.createElement("span");

    subchThree.setAttribute("class", "item-choice-name item-choice-name-sm");

    subchThree.innerHTML = "Share milestone";

    ichoiceOne.appendChild(subchOne);

    ichoiceTwo.appendChild(subchTwo);

    ichoiceThree.appendChild(subchThree);

    myitems.appendChild(ichoiceOne);

    myitems.appendChild(ichoiceTwo);

    myitems.appendChild(ichoiceThree);

    optmenuitem.appendChild(aruppt);

    optmenuitem.appendChild(myitems);

    mmetadata.appendChild(optmenuitem);

    leftPane.appendChild(id_ml);

    rightPane.appendChild(m_desc);

    rightPane.appendChild(mmetadata);

    milestoneContainer.appendChild(statusHolder);

    milestoneContainer.appendChild(leftPane);

    milestoneContainer.appendChild(rightPane);

    parentContainer.appendChild(milestoneContainer);

}
