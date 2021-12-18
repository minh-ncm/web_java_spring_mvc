/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function validateBid() {
    let amount = parseFloat(document.getElementById("bidAmount").value);
    let errorText = "";
    if (amount < 1e16 && amount > 0)
        return true;
    if (amount <= 0 || isNaN(amount))
        errorText = "Bid's amount can't be zero";
    if (amount >= 1e16)
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