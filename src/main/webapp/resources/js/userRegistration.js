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
        errorText = "Account must have an avatar.";
    else
        errorText = "Avatar must be a jpg or png image.";
    document.getElementById("imageFileError").innerHTML = errorText;
    return false;
}