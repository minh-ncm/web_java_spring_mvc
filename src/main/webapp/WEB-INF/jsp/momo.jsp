<%-- 
    Document   : momo
    Created on : 25 Dec 2021, 14:39:37
    Author     : sie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<button onclick="momoaa()">click</button>
    <script>
        function momoaa()
        {
            fetch("/charity_network/test/momo/",{
                method:"get",
            }).then(function(res){
                return res.json()
            }).then(function(data){
                console.log(data)
            })
        }
    </script>
