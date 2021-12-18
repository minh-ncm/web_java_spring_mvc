/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function validateBid() {
    let amount = document.getElementById("bidAmount").value;
    let parts = amount.split(".");
    let errorText = "";
    if (parts[0].length <= 15 && amount.length > 0)
        return true;
    if (amount.length === 0)
        errorText = "Bid's amount can't be zero";
    if (parts[0].length > 15)
        errorText = "value can't exceed 15 ditgits";

    document.getElementById("bidAmountError").innerHTML = errorText;
    return false;
}

function validateComment() {
    let text = document.getElementById("commentText").value;
    if (text !== "" && text.length < 300)
        return true;
    let errorText;
    if (text === "") 
        errorText = "comment can't be emty";
    if (text.length >= 300)
        errorText = "comment can't have more than 300 characters";
    document.getElementById("commentTextError").innerHTML = errorText;
    return false;
}