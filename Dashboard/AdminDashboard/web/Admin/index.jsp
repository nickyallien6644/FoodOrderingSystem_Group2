<%-- 
    Document   : tableDatable
    Created on : Jun 14, 2021, 1:12:44 PM
    Author     : phuct
--%>

<%@page import="Models.Entity.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Models.DAO.AccountDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>DataTable - Mazer Admin Dashboard</title>

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
                                <a href="index.jsp"><img src="img/logo.png" alt="Logo" srcset=""></a>
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

                            <!--                            <li class="sidebar-item  ">
                                                            <a href="index.jsp" class='sidebar-link'>
                                                                <i class="bi bi-grid-fill"></i>
                                                                <span>Dashboard</span>
                                                            </a>
                                                        </li>-->
                            <li class="sidebar-item active">
                                <a href="indexAdmin.jsp" class='sidebar-link'>
                                    <i class="bi bi-file-earmark-spreadsheet-fill"></i>
                                    <span>Datatable</span>
                                </a>
                            </li>
                            <li class="sidebar-title">Pages</li>

                            <li class="sidebar-item  ">
                                <a href="https://zuramai.github.io/mazer/demo/application-email.html" class='sidebar-link'>
                                    <i class="bi bi-envelope-fill"></i>
                                    <span>Email Application</span>
                                </a>
                            </li>

                            <li class="sidebar-item  ">
                                <a href="https://zuramai.github.io/mazer/demo/application-chat.html" class='sidebar-link'>
                                    <i class="bi bi-chat-dots-fill"></i>
                                    <span>Chat Application</span>
                                </a>
                            </li>

                            <li class="sidebar-item  ">
                                <a href="https://zuramai.github.io/mazer/demo/application-gallery.html" class='sidebar-link'>
                                    <i class="bi bi-image-fill"></i>
                                    <span>Photo Gallery</span>
                                </a>
                            </li>
                            <li class="sidebar-title">Raise Support</li>

                            <li class="sidebar-item  ">
                                <a href="https://zuramai.github.io/mazer/docs" class='sidebar-link'>
                                    <i class="bi bi-life-preserver"></i>
                                    <span>Documentation</span>
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
                                <h2>ADMIN PAGE</h2>
                                <p class="text-subtitle text-muted">Let the admin check the system's account list</p>
                            </div>
                            <div class="col-12 col-md-6 order-md-2 order-first">
                                <nav aria-label="breadcrumb" class="breadcrumb-header float-start float-lg-end">
                                    <ol class="breadcrumb">
                                        <!--                                        <li class="breadcrumb-item"><a href="index.jsp">Dashboard</a></li>-->
                                        <li class="breadcrumb-item active" aria-current="page">List Account</li>
                                    </ol>
                                </nav>
                                <div class="float-end ">
                                    <a href="UpdateProfile.jsp"><button class="btn bg-light-success font-bold mx-2 btn-block">Add new account</button></a>
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
                                            <th>Name</th>
                                            <th>Email</th>
                                            <th>Phone</th>
                                            <th>City</th>
                                            <th>Role</th>
                                            <th>Status</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            AccountDAO accountDAO = new AccountDAO();
                                            ArrayList<Account> listAccount = new ArrayList<Account>();
                                            listAccount = accountDAO.getAllAccount();
                                            for (int i = 0; i < listAccount.size(); i++) {
                                        %>
                                        <tr>
                                            <td class="use-address id" ><%=listAccount.get(i).getaID() %></td>
                                            <td class="use-address"><%=listAccount.get(i).getaFirstname()%></td>
                                            <td class="use-address"><%=listAccount.get(i).getAemail()%></td>
                                            <td class="use-address"><%=listAccount.get(i).getaPhone()%></td>
                                            <td class="use-address"><%=listAccount.get(i).getaAddress()%></td>
                                            <%
                                                if (listAccount.get(i).getRoleID() == 1) {
                                            %>
                                            <td class="use-address">Customer</td>
                                            <%
                                            } else if (listAccount.get(i).getRoleID() == 2) {

                                            %>
                                            <td class="use-address">Admin</td>
                                            <% 
                                            } else if (listAccount.get(i).getRoleID() == 3) {
                                            %>
                                            <td class="use-address">Employee</td>
                                            <%
                                                }else if (listAccount.get(i).getRoleID() == 4) {
                                            %>
                                            <td class="use-address">Staff</td>
                                            <%
                                                }
                                            %>
                                            <td class="use-address">
                                                <span class="badge bg-success">Active</span>
                                            </td>
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
                            <p>2021 &copy; Mazer</p>
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
                    var url = "/AdminDashboard/UpdateProfile?id=" + $text;
                    window.location.href = url;
                }
                // Let's test it out

            });

        </script>

        <script src="../js/main.js"></script>
    </body>

</html>
