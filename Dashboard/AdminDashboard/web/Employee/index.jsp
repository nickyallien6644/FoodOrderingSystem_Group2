<%-- 
    Document   : tableDatable
    Created on : Jun 14, 2021, 1:12:44 PM
    Author     : phuct
--%>

<%@page import="Models.Entity.User"%>
<%@page import="Models.Entity.Restaurant"%>
<%@page import="Models.Entity.Order"%>
<%@page import="Models.DAO.OrderDAO"%>
<%@page import="Models.Entity.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Models.DAO.RestaurantDAO"%>
<%@page import="Models.DAO.AccountDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%
        if (session.getAttribute("LoginUser") == null || session.getAttribute("rID") == null) {
            response.sendRedirect("../../AdminDashboard/Login.jsp");
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
                                <a href="index.jsp"><img src="../img/logo.png" alt="Logo"class="w-50 h-50" srcset=""></a>
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
                            <li class="sidebar-item active">
                                <a href="index.jsp" class='sidebar-link'>
                                    <i class="bi bi-file-earmark-spreadsheet-fill"></i>
                                    <span>Order management</span>
                                </a>
                            </li>

                            <li class="sidebar-item  ">
                                <a href="productManagement.jsp" class='sidebar-link'>
                                    <i class="bi bi-envelope-fill"></i>
                                    <span>Product management</span>
                                </a>
                            </li>

                            <li class="sidebar-item  ">
                                <a href="CategoryManagement.jsp" class='sidebar-link'>
                                    <i class="bi bi-envelope-fill"></i>
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
                                <h2>ORDER MANAGEMENT</h2>
                                <p class="text-subtitle text-muted">Let the admin check the system's account list</p>
                            </div>
                            <div class="col-12 col-md-6 order-md-2 order-first">
                                <div class="card d-flex align-items-center" style="float: right; padding-bottom: 20px; padding-right: 20px;padding-left: 20px;padding-top: 20px;">
                                    <div class="avatar avatar-xl">
                                        <img src="https://zuramai.github.io/mazer/demo/assets/images/faces/1.jpg" alt="Face 1">
                                    </div>
                                    <div class="ms-2 name">
                                        <h5 class="font-bold">EMPLOYEE</h5>
                                        <h6 class="text-muted mb-0"><%
                                                if(session.getAttribute("LoginUser") != null){
                                                User user = (User)session.getAttribute("LoginUser");
                                                user.getaFirstname();
                                            }
                                            %></h6>
                                    </div>
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-info dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                                            Information
                                        </button>
                                        <ul class="dropdown-menu">
                                            <li><a class="dropdown-item" href="#">Account</a></li>
                                            <li><hr class="dropdown-divider"></li>
                                            <a class="dropdown-item" href="../Login.jsp"><li>Logout</li></a>
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
                            <div class="card-body">
                                <table class="table table-striped" id="table1">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Account</th>
                                            <th>Total</th>
                                            <th>Note</th>
                                            <th>Code</th>
                                            <th>Date</th>
                                            <th>Status</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            AccountDAO accountDAO = new AccountDAO();
                                            RestaurantDAO restaurantDAO = new RestaurantDAO();
                                            Account account = new Account();
                                            ArrayList<Order> listOrders = new ArrayList<Order>();
                                            OrderDAO orderDAO = new OrderDAO();
                                            if (session.getAttribute("rID") != null) {
                                                int rID = ((Integer) session.getAttribute("rID")).intValue();
                                                listOrders = orderDAO.getAllOrderByrID(rID);
                                            }
                                            for (int i = 0; i < listOrders.size(); i++) {
                                        %>
                                        <tr>
                                            <td class="use-address id" ><%=listOrders.get(i).getoID()%></td>
                                            <td class="use-address"><%=accountDAO.getAccountById(listOrders.get(i).getaID()).getAemail()%></td>
                                            <td class="use-address"><%=listOrders.get(i).getoAmountTotal()%></td>
                                            <td class="use-address"><%=listOrders.get(i).getoNote()%></td>
                                            <td class="use-address"><%=listOrders.get(i).getoCode()%></td>
                                            <td class="use-address"><%=listOrders.get(i).getoDateCreate()%></td>             

                                            <%
                                                if (listOrders.get(i).getoStatus() == 1) {
                                            %>
                                            <td class="use-address">
                                                <span class="badge bg-success">Paid</span>
                                            </td>
                                            <td class="use-address">
                                            </td>
                                            <%                                            } else if (listOrders.get(i).getoStatus() == 0) {
                                            %>
                                            <td class="use-address">
                                                <span class="badge bg-danger">Unpaid</span>
                                            </td>

                                            <td class="use-address">
                                                <button type="button" class="btn btn-light-warning">Confirm</button>
                                            </td>
                                            <%
                                                }
                                            %>
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

        <script src="../js/main.js"></script>
    </body>

</html>
