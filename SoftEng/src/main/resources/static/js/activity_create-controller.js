$(document).ready(function(){
    //Handle File Upload
    $(".btn-add").click(function(e){
        e.preventDefault();

        var controlForm = $('.controls:first'),
            currentEntry = $(this).parents('.entry:first'),
            newEntry = $(currentEntry.clone()).appendTo(controlForm);

        newEntry.find('input').val('');
        controlForm.find('.entry:not(:last) .btn-add')
            .removeClass('btn-add').addClass('btn-remove')
            .removeClass('btn-success').addClass('btn-danger')
            .html('<span class="glyphicon glyphicon-minus"></span>');
    });
    $(".btn-remove").click(function(){
        $(this).parents('.entry:first').remove();
        e.preventDefault();
        return false;
    });

    //Handle Address Type
    $("#activity-form-address");
    $("#activity-form-map");

    //Handle Form Submition
    $("#activity-form-submit").click(function(){
        var result_data = {
            "title": $("#activity-form-title").val(),
            "description": $("#activity-form-description").val(),
            "ticket_number": $("#activity-form-ticket_number").val(),
            "ticket_price": $("#activity-form-ticket_price").val(),
            "date": $("#activity-form-date").val(),
            "address": $("#activity-form-address").val()
        };
        console.log("Data: "+JSON.stringify(result_data, null, 2));
        
    });

});

var _validFileExtensions = [".jpg", ".jpeg", ".png"];    
function ValidateSingleInput(oInput) {
    if (oInput.type == "file") {
        var sFileName = oInput.value;
         if (sFileName.length > 0) {
            var blnValid = false;
            for (var j = 0; j < _validFileExtensions.length; j++) {
                var sCurExtension = _validFileExtensions[j];
                if (sFileName.substr(sFileName.length - sCurExtension.length, sCurExtension.length).toLowerCase() == sCurExtension.toLowerCase()) {
                    blnValid = true;
                    break;
                }
            }
             
            if (!blnValid) {
                alert("Sorry, " + sFileName + " is invalid, allowed extensions are: " + _validFileExtensions.join(", "));
                oInput.value = "";
                return false;
            }
        }
    }
    return true;
}