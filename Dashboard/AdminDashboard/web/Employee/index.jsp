<%-- 
    Document   : tableDatable
    Created on : Jun 14, 2021, 1:12:44 PM
    Author     : phuct
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                    <h3>Order management</h3>
                </div>
                    <div class="page-title">
                        <div class="row">
                            <div class="col-12 col-lg-9">
                            <div class="row" >
                                <div class="col-6 col-lg-6 col-md-6">
                                    <div class="card" >
                                        <div class="card-body "style="margin-bottom: 6px">
                                            <div class="row" style="padding-top: 7px">
                                                <div class="col-md-4 ">
                                                    <div class="stats-icon purple">
                                                        <i class="iconly-boldShow"></i>
                                                    </div>
                                                </div>
                                                <div class="col-md-8" >
                                                    <h6 class="text-muted font-semibold">Orders of Customer complete</h6>
                                                    <h6 class="font-extrabold mb-0">999</h6>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-6 col-lg-6 col-md-6">
                                    <div class="card">
                                        <div class="card-body"  style="margin-bottom: 6px">
                                            <div class="row" style="padding-top: 7px">
                                                <div class="col-md-4">
                                                    <div class="stats-icon blue">
                                                        <i class="iconly-boldProfile"></i>
                                                    </div>
                                                </div>
                                                <div class="col-md-8">
                                                    <h6 class="text-muted font-semibold">Orders of Customer incomplete</h6>
                                                    <h6 class="font-extrabold mb-0">10</h6>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </div>
                            <div class="col-12 col-lg-3">
                            <div class="card">
                                <div class="card-body py-4 px-5">
                                    <div class="d-flex align-items-center">
                                        <div class="avatar avatar-xl">
                                            <img src="https://zuramai.github.io/mazer/demo/assets/images/faces/1.jpg" alt="Face 1">
                                        </div>
                                        <div class="ms-3 name">
                                            <h5 class="font-bold">EMPLOYEE01</h5>
                                            <h6 class="text-muted mb-0">@KHANGNV</h6>
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
                                <div class="dataTable-wrapper dataTable-loading no-footer sortable searchable fixed-columns"><div class="dataTable-top"><div class="dataTable-dropdown"><select class="dataTable-selector form-select"><option value="5">5</option><option value="10" selected="">10</option><option value="15">15</option><option value="20">20</option><option value="25">25</option></select><label>entries per page</label></div><div class="dataTable-search"><input class="dataTable-input" placeholder="Search..." type="text"></div></div><div class="dataTable-container"><table class="table table-striped dataTable-table" id="table1">
                            </table>
                                <table class="table table-striped" id="table1">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Customer</th>
                                            <th>Phone</th>
                                            <th>Address</th>
                                            <th>Total</th>
                                            <th>Date</th>
                                            <th>Status</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            for(int i= 0;i<4;i++){
                                        %>
                                        <tr>
                                            <td class="use-address id" ><%=i+1%></td>
                                            <td class="use-address">Bach Nguyen Phuc Thinh<%=i+1%></td>
                                            <td class="use-address">076 4820 8838</td>
                                            <td class="use-address">Hau Giang</td>
                                            <td class="use-address">100.000VND</td>
                                            <td class="use-address">18/06/2021</td>
                                            <td class="use-address">
                                                <span class="badge bg-light-danger">Unconfimred</span>
                                            </td>
                                            <td>
                                                <button class="bg-light-primary">Confirm</button>
                                            </td>
                                        </tr>
                                        <%
                                                            }
                                        %>
                                        <%
                                            for(int i= 4;i<9;i++){
                                        %>
                                        <tr>
                                            <td class="use-address id" ><%=i+1%></td>
                                            <td class="use-address">Hua Quoc Vinh<%=i+1%></td>
                                            <td class="use-address">076 4820 8838</td>
                                            <td class="use-address">Can Tho</td>
                                            <td class="use-address">100.000VND</td>
                                            <td class="use-address">18/06/2021</td>
                                            <td class="use-address">
                                                <span class="badge bg-light-success">Confimred</span>
                                            </td>
                                            <td>
                                            </td>
                                        </tr>
                                        <%
                                                            }
                                        %>
                                    </tbody>
                                </table>
                                <div class="dataTable-bottom"><div class="dataTable-info">Showing 1 to 10 of 26 entries</div><ul class="pagination pagination-primary float-end dataTable-pagination"><li class="page-item pager"><a href="#" class="page-link" data-page="1">‹</a></li><li class="page-item active"><a href="#" class="page-link" data-page="1">1</a></li><li class="page-item"><a href="#" class="page-link" data-page="2">2</a></li><li class="page-item"><a href="#" class="page-link" data-page="3">3</a></li><li class="page-item pager"><a href="#" class="page-link" data-page="2">›</a></li></ul></div></div>

                            </div>
                        </div>
                    </section>

                <footer>
                    <div class="footer clearfix mb-0 text-muted">
                        <div class="float-start">
                            <p>2021 &copy; Group2</p>
                        </div>
                        <div class="float-end">
                            <p>Create<span class="text-danger"><i class="bi bi-heart"></i></span> by <a
                                    href="http://ahmadsaugi.com">GROUP 2</a></p>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="js/perfect-scrollbar.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>

        <script src="js/simple-datatables.js"></script>
        <script>
            // Simple Datatable
            let table1 = document.querySelector('#table1');
            let dataTable = new simpleDatatables.DataTable(table1);
        </script>

        <script src="js/main.js"></script>
    </body>

</html>
