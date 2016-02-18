var BjcScripts = BjcScripts || {};

BjcScripts.TicketListController = {
    
    init : function() {
        this.setParameters();
        this.roadTicketList();
        this.putLinkEvent();
    },
    
    setParameters : function() {
        
    },
    
    roadTicketList : function() {
        
        var sendUrl = '/BJC/rest/redmineTest/issues';
        var sendType = 'POST';
        var sendConfig = {};
        sendConfig['sendUrl'] = sendUrl;
        sendConfig['sendType'] = sendType;
        
        var sendkey = '';
        var sendValue = '';
        var sendDataObject = {};
        sendDataObject['header'] = {
            "system" : "bjc",
            "account" : "test",
            "requestMode" : "test"
        };
        sendDataObject['body'] = {
            "functionName" : "ticketList",
            "functionKey" : sendkey,
            "functionValue" : sendValue
        };
        var sendData = JSON.stringify(sendDataObject);
        
        BjcScripts.ToServer.doSubmit(sendConfig, sendData)
                .done(function(result) {
                    console.log("OK");
                    console.log("result : ");
                    console.log(result);
                    
                    var resultJson
                        =$.parseJSON(JSON.stringify(result));
                    var output = 
                            "<table border=1>" +
                            "<thead>" +
                            "<tr><th>チケット番号</th>" +
                            "<th>タイトル</th>" +
                            "<th>作成日</th>" +
                            "<th>作成者</th>" +
                            "</tr>" + 
                            "</thead>";
                    var subject = "";
                    var ticketNo = "";
                    var createDate = "";
                    var createUser = "";

                    $.each(resultJson, function(i, item) {

                        subject = item['subject'];
                        ticketNo = item['id'];
                        createDate = item['createOn'];
                        createUser = item['author']['fullName'];
                        
                        var URL = "./ticketDetail/";
                        output = output + 
                                "<tbody>" +
                                "<tr>" +
                                "<td>" + "<a href='./dammy.html'>" + ticketNo + "</a>" + "</td>" +
                                "<td>" + subject + "</td>" + 
                                "<td>" + createDate + "</td>" + 
                                "<td>" + createUser + "</td>" +
                                "</tr>" +
                                "</tbody>";
                    });
                    output = output +
                            "</table>";
                    console.log(output);
                    $('#ticketList').html(output);
                })
                .fail(function(result, textStatus) {
                    console.log(result.getResponseHeader('Content-Type'));
                    console.log("NG : " + textStatus);
                    console.log("result : ");
                    console.log(result);
                });
                
    }
};

$(function() {
   BjcScripts.TicketListController.init(); 
});