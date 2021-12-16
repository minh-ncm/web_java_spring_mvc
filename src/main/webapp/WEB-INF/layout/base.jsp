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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
        <title><tile:insertAttribute name="title"></tile:insertAttribute></title>
    </head>
    <header class="mb-5 sticky-top"><tile:insertAttribute name="header"/></header>
    <main>
        <div class="container-fluid">
            <div class="row">
                <div class="col"><tile:insertAttribute name="contentLeft"/></div>
                <div class="col-8"><tile:insertAttribute name="contentCenter"/></div>
                <div class="col"><tile:insertAttribute name="contentRight"/></div>
            </div>
        </div>
    </main>
    <footer class="mt-5 sticky-bottom"><tile:insertAttribute name="footer"/>
        <footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
    <div class="col-md-4 d-flex align-items-center">
      <span class="text-muted">© 2021 Company, Inc</span>
    </div>

    <ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
      <li class="ms-3"><a class="text-muted" href="https://github.com/u3Vi/web_java_spring_mvc"><svg class="bi" width="24" height="24"><i class="bi bi-github"></i></svg></a></li>
      <li class="ms-3"><a class="text-muted" href="#"><use xlink:href="#instagram"></use></a></li>
      <li class="ms-3"><a class="text-muted" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#facebook"></use></svg></a></li>
    </ul>
  </footer>
    </footer>
</html>
