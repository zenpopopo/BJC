var BjcScripts = BjcScripts || {};

BjcScripts.ToServer = {
    
    doSubmit : function(sendConfig, sendData) {
        console.log(sendData);
        console.log(sendConfig['sendUrl']);
        console.log(sendConfig['sendType']);
        if (sendData.length <= 0) {
            alert("入力ないよ");
        } else {
            return $.ajax({
                url:sendConfig['sendUrl'],
                type:sendConfig['sendType'],
                data:sendData,
                timeout: 30000,
                contentType:'application/json;charset=ISO-8859-1',
                datatype: 'Json',
                success: function(response) {
                    console.log("return");
                    console.log("response : " + response );
                },
                error: function(response) {
                    console.log("not return");
                    console.log("response : " + response );
                }
            });
        };
    }  
};