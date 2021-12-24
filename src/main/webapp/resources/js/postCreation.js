/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function validateImageFile() {
    let file = document.getElementById("imageFile");
    let errorText = "";
    if ((file.value.endsWith(".jpg") || file.value.endsWith(".png")))
        return true;
    else if (file.files.length === 0)
        errorText = "Post  must have an thumbnail";
    else
        errorText = "Thumbnail must be a jpg or png image.";
    document.getElementById("imageFileError").innerHTML = errorText;
    return false;
}

function validateEndDate(){
    let endDate = document.getElementById("endDate").value;
    if (endDate == "") {
        document.getElementById("endDateError").innerHTML = "Ending date can't be empty";
        return false;
    }
        
    if (new Date(endDate) < new Date()) {
        document.getElementById("endDateError").innerHTML = "Ending date must be after current time";
        return false;
    }
    return false;
}

function validatePostCreateForm(){    
    let foo1 = validateImageFile();
    let foo2 = validateEndDate();
    return foo1 && foo2;
}