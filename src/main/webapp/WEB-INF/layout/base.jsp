<%-- 
    Document   : base
    Created on : 13 Dec 2021, 21:58:34
    Author     : sie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tile" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <title><tile:insertAttribute name="title"></tile:insertAttribute></title>
    </head>
    <header class="mb-5"><tile:insertAttribute name="header"/></header>
    <main>
        <div class="container-fluid">
            <div class="row">
                <div class="col"><tile:insertAttribute name="contentLeft"/></div>
                <div class="col-8"><tile:insertAttribute name="contentCenter"/></div>
                <div class="col"><tile:insertAttribute name="contentRight"/></div>
            </div>
        </div>
    </main>
    <footer class="mt-5"><tile:insertAttribute name="footer"/></footer>
</html>
