<%-- 
    Document   : UpdateProfile
    Created on : Jun 15, 2021, 8:55:22 PM
    Author     : phuct
--%>

<%@page import="Models.Entity.Account"%>
<%@page import="Models.DAO.AccountDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html><html lang=en>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->

        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link rel="stylesheet" href="https://zuramai.github.io/mazer/demo/assets/vendors/choices.js/choices.min.css" />
        <title>Update Profile Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <hr>
        <div class="container bootstrap snippet">
            <div class="row">
                <div class="col-sm-10"><h1>UPDATE ACCOUNT </h1></div>
                <div class="col-sm-2"><a href="../Admin/index.jsp" class="pull-right"><img title="profile image" class="img-circle img-responsive" src="http://www.gravatar.com/avatar/28fd20ccec6865e2d5f0e1f4446eb7bf?s=100"></a></div>
            </div>
            <div class="row">
                <div class="col-sm-3"><!--left col-->
                    <div class="text-center">
                        <img src="../img/Capture.PNG" class="avatar img-thumbnail img-thumbnail" alt="avatar">
                    </div></hr><br>
                </div><!--/col-3-->
                <div class="col-sm-9">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#home">Home</a></li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active wrapper" id="home">
                            <hr>

                            <form class="form" action="${pageContext.request.contextPath}/UpdateAccount" method="post" id="registrationForm">
                                <%
                                    int id = 0;
                                    if (request.getParameter("id") != null) {
                                        id = Integer.parseInt(request.getParameter("id"));
                                    }
                                    if (id != 0) {
                                        AccountDAO accountDAO = new AccountDAO();
                                        Account account = accountDAO.getAccountById(id);

                                %>
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="first_name"><h4>First name</h4></label>
                                        <input type="number" hidden="" value="<%=account.getaID()%>" class="form-control id" name="id"/>
                                        <input type="text" value="<%=account.getaFirstname()%>"  class="form-control first_name" name="first_name" id="first_name" placeholder="first name" title="enter your first name if any." required />
                                    </div>
                                </div>
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="last_name"><h4>Last name</h4></label>
                                        <input type="text" value="<%=account.getaLastname()%>" class="form-control last_name" name="last_name" id="last_name" placeholder="last name" title="enter your last name if any." required />
                                    </div>
                                </div>

                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="phone"><h4>Phone</h4></label>
                                        <input type="text" value="<%=account.getaPhone()%>" class="form-control phone" name="phone" id="phone" placeholder="enter phone" title="enter your phone number if any." required />
                                    </div>
                                </div>
                                    <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="address"><h4>Address</h4></label>
                                        <input type="text" value="<%=account.getaAddress() %>" class="form-control address" name="address" id="phone" placeholder="enter phone" title="enter your address number if any." required />
                                    </div>
                                </div>
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="email"><h4>Email</h4></label>
                                        <input type="email" value="<%=account.getAemail()%>" class="form-control email" name="email" id="email" placeholder="you@email.com" title="enter your email." required />
                                    </div>
                                </div>
                                <div class="form-group" >
                                    <div class="col-xs-2" style="margin-top: 20px" >
                                        <label class="input-group-text "
                                               for="inputGroupSelect01">Status</label>
                                        <select class="form-select " style="padding-right: 28px" id="inputGroupSelect01" name="selectStatus">
                                            <%
                                                if (account.getaStatus() == 1) {
                                            %>
                                            <option selected>Active</option>
                                            <option value="0">Inactive</option>
                                            <%
                                            } else {
                                            %>
                                            <option value="1">Active</option>
                                            <option selected>Inactive</option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>
                                <%
                                    }
                                %>
                                <div class="form-group">
                                    <div class="col-xs-12">
                                        <br>
                                        <button class="btn btn-lg btn-success saveData" name="saveData" type="submit"><i class="glyphicon glyphicon-ok-sign"></i> Save</button>
                                        <a href="/AdminDashboard/indexAdmin"><button class="btn btn-lg" type="button"><i class="glyphicon glyphicon-repeat"></i> Back</button></a>
                                    </div>
                                </div>
                            </form>
                            <hr>
                        </div><!--/tab-pane-->
                    </div><!--/tab-pane-->
                </div><!--/tab-content-->
            </div><!--/col-9-->
        </div><!--/row-->
        <script src="https://zuramai.github.io/mazer/demo/assets/vendors/perfect-scrollbar/perfect-scrollbar.min.js"></script>
        <script src="https://zuramai.github.io/mazer/demo/assets/js/bootstrap.bundle.min.js"></script>

        <!-- Include Choices JavaScript -->
        <script src="https://zuramai.github.io/mazer/demo/assets/vendors/choices.js/choices.min.js"></script>

        <script src="https://zuramai.github.io/mazer/demo/assets/js/main.js"></script>
    </body>

</html>
