$(".tabs-btn").click(function(){

    var getPos = $(".tabs-btn").index(this);

    if ($(this).attr("id") != "active-tab") {

        $(".tabs-btn:eq("+getPos+")").attr("id", "active-tab");

        for (var i = 0; i < $(".tabs-btn").length; i++) {

            if(i == getPos) continue;

            $(".tabs-btn:eq("+i+")").attr("id", "");

            console.log("value of i : "+i);

        }
    }

});

