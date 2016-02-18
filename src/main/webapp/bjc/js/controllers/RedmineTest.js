var BjcScripts = BjcScripts || {};

BjcScripts.RedmineTest = {

    init : function() {
        this.setParameters();
        this.pushButtonEvent();
    },

    setParameters : function() {
        this.$searchData = $('#searchData');
        this.$search = $('#search');
    },

    pushButtonEvent : function() {
        
        this.$search.on('click', function() {
            
            var sendUrl = $('#search').attr('data-action');
            var sendType = 'GET';
            var sendConfig = {};
            sendConfig['sendUrl'] = sendUrl;
            sendConfig['sendType'] = sendType;
            
            var sendKey = 'id';
            var sendVal = $('#id').val();
            var sendDataObject = {
                "id" : sendVal
            };
            var sendData = JSON.stringify(sendDataObject);
            
            BjcScripts.ToServer.doSubmit(sendConfig, sendData)
            .done(function(result) {
                console.log("OK");
                console.log("result : ");
                console.log(result);
                
                var resultJson 
                        = $.parseJSON(JSON.stringify(result));
                var output = "☆☆検索結果☆☆";
                $.each(resultJson, function(i, item) {
                    output =  output + "<br />" + i + " : " + item['subject'];
                    $.each(item, function(j, item2) {
                        output = output + "<br />" + "&ensp;" + j + " : " + item2;
                    });
                });
                
                $('#resultData').html(output);
            })
            .fail(function(result, textStatus) {
                console.log(result.getResponseHeader('Content-Type'));
                console.log("NG : " + textStatus);
                console.log("result : ");
                console.log(result);
            });
        });
    }
};

$(function() {
    "use strict";
    BjcScripts.RedmineTest.init();    
});


