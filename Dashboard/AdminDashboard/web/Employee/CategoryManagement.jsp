<%-- 
    Document   : tableDatable
    Created on : Jun 14, 2021, 1:12:44 PM
    Author     : phuct
--%>

<%@page import="Models.Entity.User"%>
<%@page import="Models.Entity.Category"%>
<%@page import="Models.Entity.Product"%>
<%@page import="Models.DAO.CategoryDAO"%>
<%@page import="Models.DAO.ProductDAO"%>
<%@page import="Models.Entity.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Models.DAO.AccountDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%
        if (session.getAttribute("LoginUser") == null) {
            response.sendRedirect("../../AdminDashboard/Login.jsp");
        } else {
            User user = (User) session.getAttribute("LoginUser");
            if (user != null) {
                if (user.getRoleID() == 2) {
                    response.sendRedirect("../Admin/index.jsp");
                } else if (user.getRoleID() == 4) {
                    response.sendRedirect("../Staff/index.jsp");
                }
            }

    %>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Food Ordering System - Dashboard</title>

        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="../css/bootstrap.css">

        <link rel="stylesheet" href="../css/style.css">

        <link rel="stylesheet" href="../css/perfect-scrollbar.css">
        <link rel="stylesheet" href="https://zuramai.github.io/mazer/demo/assets/vendors/bootstrap-icons/bootstrap-icons.css">
        <link rel="stylesheet" href="../css/app.css">
        <link rel="shortcut icon" href="https://zuramai.github.io/mazer/demo/assets/images/favicon.svg" type="image/x-icon">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </head>

    <body>
        <div id="app">
            <div id="sidebar" class="active">
                <div class="sidebar-wrapper active">
                    <div class="sidebar-header">
                        <div class="d-flex justify-content-between">
                            <div class="logo">
                                <a href="index.jsp"><img  src="../img/logo.png" alt="Logo" class="w-50 h-50" srcset=""></a>
                                <h2 class="page-heading">FOOD ORDERING MANAGEMENTS</h2>
                            </div>
                            <div class="toggler">
                                <a href="#" class="sidebar-hide d-xl-none d-block"><i class="bi bi-x bi-middle"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="sidebar-menu">
                        <ul class="menu">
                            <li class="sidebar-title">Menu</li>
                            <li class="sidebar-item">
                                <a href="index.jsp" class='sidebar-link'>
                                    <i class="bi bi-calendar-check"></i>
                                    <span>Order management</span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a href="productManagement.jsp" class='sidebar-link'>
                                    <i class="bi bi-shop"></i>
                                    <span>Product management</span>
                                </a>
                            </li>

                            <li class="sidebar-item active">
                                <a href="CategoryManagement.jsp" class='sidebar-link'>
                                    <i class="bi bi-grid-fill"></i>
                                    <span>Category management</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                    <button class="sidebar-toggler btn x"><i data-feather="x"></i></button>
                </div>
            </div>


            <div id="main">
                <header class="mb-3">
                    <a href="#" class="burger-btn d-block d-xl-none">
                        <i class="bi bi-justify fs-3"></i>
                    </a>
                </header>

                <div class="page-heading">
                    <div class="page-title">
                        <div class="row">
                            <div class="col-12 col-md-6 order-md-1 order-last">
                                <h2>CATEGORY MANAGEMENT</h2>
                            </div>
                            <div class="col-12 col-md-6 order-md-2 order-first">
                                <div class="card d-flex align-items-center" style="float: right; padding-bottom: 20px; padding-right: 20px;padding-left: 20px;padding-top: 20px;">
                                    <div class="ms-2 name">
                                        <h5 class="font-bold">EMPLOYEE</h5>
                                        <h6 class="text-muted mb-0"><%=user.getaFirstname()%></h6>
                                    </div>
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-info dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                                            Information
                                        </button>
                                        <ul class="dropdown-menu">
                                            <li><a class="dropdown-item" href="/AdminDashboard/UpdateProfile?id=<%=user.getaID()%>&&check=pass">Account</a></li>
                                            <li><hr class="dropdown-divider"></li>
                                            <li><a class="dropdown-item" href="../Login.jsp">Logout</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <section class="section">
                        <div class="card">
                            <div class="card-header">
                                Admin can edit profile as status, name, email, phone, city 
                            </div>
                            <div class="card-right" style="padding-right: 25px">
                                <nav aria-label="breadcrumb" class="breadcrumb-header float-start float-lg-end">
                                    <ol class="breadcrumb">
                                        <div class="breadcrumb-item">
                                            <a href="AddCategory.jsp"><button class="btn bg-light-success font-bold mx-2">Add new category</button></a>
                                        </div>
                                    </ol>
                                </nav>
                            </div>
                            <div class="card-body">
                                <table class="table table-striped" id="table1">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Name</th>
                                            <th>Image</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%                                            CategoryDAO categoryDAO = new CategoryDAO();
                                            ArrayList<Category> listCategories = new ArrayList<Category>();
                                            listCategories = categoryDAO.getAllCategory();
                                            for (int i = 0; i < listCategories.size(); i++) {
                                        %>
                                        <tr>
                                            <td class="use-address id" ><%=listCategories.get(i).getcID()%></td>
                                            <td class="use-address"><%=listCategories.get(i).getcName()%></td>
                                            <td class="use-address"><img src="<%=listCategories.get(i).getiURL()%>"width="100" height="100"></td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </section>
                </div>

                <footer>
                    <div class="footer clearfix mb-0 text-muted">
                        <div class="float-start">
                            <p>2021 &copy; GROUP 2</p>
                        </div>
                        <div class="float-end">
                            <p>Create<span class="text-danger"><i class="bi bi-heart"></i></span> by <a
                                    href="http://ahmadsaugi.com">GROUP 2</a></p>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="../js/perfect-scrollbar.min.js"></script>
        <script src="../js/bootstrap.bundle.min.js"></script>

        <script src="../js/simple-datatables.js"></script>
        <script>
            // Simple Datatable
            let table1 = document.querySelector('#table1');
            let dataTable = new simpleDatatables.DataTable(table1);
        </script>
        <script>
            $(".use-address").click(function () {
                var $row = $(this).closest("tr");    // Find the row
                var $text = $row.find(".id").text(); // Find the text

                if ($text) {
                    var url = "/AdminDashboard/UpdateCategory?id=" + $text;
                    window.location.href = url;
                }
                // Let's test it out

            });

        </script>

        <script src="../js/main.js"></script>
    </body>

</html>
<%
    }
%>