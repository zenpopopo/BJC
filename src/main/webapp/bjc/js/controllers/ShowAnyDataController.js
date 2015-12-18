var BjcScripts = BjcScripts || {};

BjcScripts.ShowAnyDataController = {

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
            var sendType = 'POST';
            var sendConfig = {};
            sendConfig['sendUrl'] = sendUrl;
            sendConfig['sendType'] = sendType;
            
            var bindKeyMap = {};
            bindKeyMap['pgRank'] = $('#pgRankCd');
            bindKeyMap['mgRank'] = $('#mgRankCd');
            
            var bindKey = bindKeyMap[$("input:radio[name='dataSelect']:checked").val()];
            var sendKey = bindKey.attr('id');
            var sendVal = bindKey.val();
            var sendDataObject = {};
            sendDataObject['header'] = {
                "system" : "bjc",
                "account" : "test",
                "requestMode" : "test"
            };
            sendDataObject['body'] = {
                "functionName" : "showAnyData",
                "functionKey" : sendKey,
                "functionValue" : sendVal
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
                for (var i in resultJson) {
                    output =  output + "<br />" + i + " : " + resultJson[i];
                };
                
                $('#resultData').html(output);
            })
            .fail(function(result) {
                console.log("NG");
                console.log("result : ");
                console.log(result);
            });
        });
    }
};

$(function() {
    "use strict";
    BjcScripts.ShowAnyDataController.init();    
});


