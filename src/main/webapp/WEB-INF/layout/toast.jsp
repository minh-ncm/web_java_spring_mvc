<%-- 
    Document   : toast
    Created on : 25 Dec 2021, 12:18:03
    Author     : sie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">;
    function popup(){
        let toast = new bootstrap.Toast(document.getElementById("toast"));
        toast.show();
    }
</script>

<button onclick="popup()">popup</button>
<div id="toast" class="toast align-items-center" role="alert" aria-live="assertive" aria-atomic="true">
  <div class="d-flex">
    <div class="toast-body">
    Hello, world! This is a toast message.
   </div>
    <button type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
  </div>
</div>