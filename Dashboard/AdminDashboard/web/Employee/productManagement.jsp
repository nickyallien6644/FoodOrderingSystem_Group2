<%-- 
    Document   : tableDatable
    Created on : Jun 14, 2021, 1:12:44 PM
    Author     : phuct
--%>

<%@page import="Models.DAO.ProductDAO"%>
<%@page import="Models.Entity.ShowProduct"%>
<%@page import="Models.DAO.OrderDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Models.Entity.OrderShow"%>
<%@page import="Models.Entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
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
<html lang="en">
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
                            <li class="sidebar-item">
                                <a href="index.jsp" class='sidebar-link'>
                                    <i class="bi bi-calendar-check"></i>
                                    <span>Order management</span>
                                </a>
                            </li>
                            <li class="sidebar-item active">
                                <a href="productManagement.jsp" class='sidebar-link'>
                                    <i class="bi bi-shop"></i>
                                    <span>Product management</span>
                                </a>
                            </li>

                            <li class="sidebar-item  ">
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
                    <h2>PRODUCT MANAGEMENT</h2>
                </div>
                <div class="page-title">
                    <div class="row">
                        <div class="col-12 col-lg-9">
                            <div class="row" >
                                <%                                    OrderDAO orderDAO = new OrderDAO();
                                    int count[] = orderDAO.countAllOrder();
                                %>
                                <div class="col-6 col-lg-6 col-md-6">
                                    <div class="card" style="padding-bottom: 8px">
                                        <div class="card-body ">
                                            <div class="text-center" style="margin-top: 20px;">
                                                <h5 class="text-muted font-semibold">Orders of Customer complete: <b style="color: black"><%=count[0]%></b></h5>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-6 col-lg-6 col-md-6">
                                    <div class="card" style="padding-bottom: 8px">
                                        <div class="card-body" >
                                            <div class="text-center" style="margin-top: 20px;">
                                                <h5  class="text-muted font-semibold">Orders of Customer incomplete: <b style="color: black"><%=count[1]%></b></h5>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-12 col-lg-3">
                            <div class="card">
                                <div class="card-body" style="margin-bottom: -10px">
                                    <div class="d-flex align-items-center row">
                                        <div class="ms-2 name col-8">
                                            <h5 class="font-bold">EMPLOYEE</h5>
                                            <h6 class="text-muted mb-0"><%=user.getaFirstname()%></h6>
                                        </div>
                                        <div class="btn-group col-3">
                                            <button type="button" class="btn btn-info dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                                            </button>
                                            <ul class="dropdown-menu">
                                                <li><a class="dropdown-item" href="/AdminDashboard/UpdateProfile?id=<%=user.getaID()%>&&check=pass">Account</a></li>
                                                <li><hr class="dropdown-divider"></li>
                                                <li><a class="dropdown-item" href="../logout">Logout</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>                           
                        </div>
                    </div>
                </div>
                <section class="section">
                    <div class="card">
                        <div class="card-body">
                            <div class="row" style="margin-bottom: -5px">
                                <div class="col-12" style="text-align: right">
                                    <a href="AddProduct.jsp"><button class="btn bg-light-success font-bold mx-2">Add new product</button></a>
                                </div>
                            </div>
                            <table class="table table-striped" id="table1">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>Price</th>
                                        <th>Category</th>
                                        <th>Description</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        ProductDAO productDAO = new ProductDAO();
                                        ArrayList<ShowProduct> showProductList = new ArrayList<ShowProduct>();
                                        showProductList = productDAO.showAllProduct(user.getrID());
                                        if (showProductList.size() != 0) {
                                            for (int i = 0; i < showProductList.size(); i++) {
                                    %>
                                    <tr>
                                        <td class="use-address id" ><%=showProductList.get(i).getpID()%></td>
                                        <td class="use-address"><%=showProductList.get(i).getpName()%></td>
                                        <td class="use-address"><%=showProductList.get(i).getPrice()%></td>
                                        <td class="use-address"><%=showProductList.get(i).getCategory()%></td>
                                        <td class="use-address"><%=showProductList.get(i).getpDescription()%> </td>

                                    </tr>
                                    <%
                                            }
                                        }
                                    %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </section>

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

                                        function reload() {
                                            location.reload();
                                            return false;
                                        }

                                        $(".use-address").click(function () {
                                            var $row = $(this).closest("tr");    // Find the row
                                            var $text = $row.find(".id").text(); // Find the text

                                            if ($text) {
                                                var url = "/AdminDashboard/UpdateProduct?id=" + $text;
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
