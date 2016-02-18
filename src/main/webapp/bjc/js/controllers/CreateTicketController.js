var BjcScripts = BjcScripts || {};

BjcScripts.TicketCreateController = {
    
    init : function() {
        this.setParameters();
        this.putButtonEvent();
    },
    
    setParameters : function() {
        
    },
    
    putButtonEvent : function() {
        $("#createTicket").on("click", function(){
            
            var sendUrl = '/BJC/rest/redmineTest/issues2';
            var sendType = 'POST';
            var sendConfig = {};
            sendConfig['sendUrl'] = sendUrl;
            sendConfig['sendType'] = sendType;
            
            var sendKey = '';
            var sendValue = {
                
            };
            var sendDataObject = {};
            sendDataObject['header'] = {
                "system" : "bjc",
                "account" : "test",
                "requestMode" : "test"
            };
            sendDataObject['body'] = {
                "functionName" : "createTicket",
                "functionKey" : sendKey,
                "functionValue" : sendValue
            };
            var sendData = JSON.stringify(sendDataObject);
            
            BjcScripts.ToServer.doSubmit(sendConfig, sendData)
                    .done(function(result) {
                        console.log("OK");
                        console.log("result : ");
                        console.log(result);
                        
                        var resultJson
                            = $.parseJSON(JSON.stringify(result));     
                    })
                    .fail(function(result, textStatus) {
                        console.log(result.getResponseHeader('Content-Type'));
                        console.log("NG : " + textStatus);
                        console.log("result : ");
                        console.log(resutl);
                    });
        });
    }
};

$(function() {
    BjcScripts.TicketCreateController.init();
});