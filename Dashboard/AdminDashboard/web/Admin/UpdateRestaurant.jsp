<%-- 
    Document   : UpdateProfile
    Created on : Jun 15, 2021, 8:55:22 PM
    Author     : phuct
--%>

<%@page import="Models.Entity.User"%>
<%@page import="Models.Entity.RestaurantName"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Models.Entity.Restaurant"%>
<%@page import="Models.DAO.RestaurantDAO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("LoginUser") == null) {
        response.sendRedirect("../../AdminDashboard/Login.jsp");
    } else {
        User user = (User) session.getAttribute("LoginUser");
        if (user != null) {
            if (user.getRoleID() == 3) {
                response.sendRedirect("../Employee/index.jsp");
            } else if (user.getRoleID() == 4) {
                response.sendRedirect("../Staff/index.jsp");
            }
        }

%>
<!DOCTYPE html><html lang=en>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Food Ordering System - UPDATE Restaurant</title>

        <link href="https://colorlib.com/polygon/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

        <link href="https://colorlib.com/polygon/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">

        <link href="https://colorlib.com/polygon/vendors/nprogress/nprogress.css" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css">
        <link rel="shortcut icon" href="https://zuramai.github.io/mazer/demo/assets/images/favicon.svg" type="image/x-icon">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/perfect-scrollbar.css">
        <link rel="stylesheet" href="https://zuramai.github.io/mazer/demo/assets/vendors/bootstrap-icons/bootstrap-icons.css">
        <link href="${pageContext.request.contextPath}/css/custom.min.css" rel="stylesheet">

        <meta name="robots" content="noindex, nofollow">
    </head>
    <body class="nav-md">
        <div class="container body row">
            <div class=" col-3" style="margin-right: -80px">
                <div class="sidebar-wrapper active">
                    <div class="sidebar-header">
                        <div class="d-flex justify-content-between">
                            <div class="logo">
                                <a href="index.jsp"><img  src="${pageContext.request.contextPath}/img/logo.png" alt="Logo" class="w-50 h-50" srcset=""></a>
                                <h2 class="page-heading"style="font-size: 32px;">FOOD ORDERING MANAGEMENTS</h2>
                            </div>
                            <div class="toggler">
                                <a href="#" class="sidebar-hide d-xl-none d-block"><i class="bi bi-x bi-middle"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="sidebar-menu">
                        <ul class="menu">
                            <li class="sidebar-title">Menu</li>

                            <li class="sidebar-item ">
                                <a href="indexAdmin" class='sidebar-link'>
                                    <i class="bi bi-file-earmark-spreadsheet-fill"></i>
                                    <span>Accounts</span>
                                </a>
                            </li>
                            <li class="sidebar-item active">
                                <a href="IndexRestaurant" class='sidebar-link'>
                                    <i class="bi bi-file-earmark-spreadsheet-fill"></i>
                                    <span>Restaurants</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="main_container  col-9">

                <div class="right_col" role="main">
                    <div class="">
                        <div class="clearfix row">
                            <div class="col-2">
                                <a href="/AdminDashboard/IndexRestaurant"><button type="button" class="btn btn-warning">Back</button></a>
                            </div>
                            <div class="col-6 ml-5 pl-4">
                                <h1>UPDATE RESTAURANT</h1>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-10 col-sm-10">
                                <div class="x_panel">
                                    <div class="x_content">
                                        <form class="" action="${pageContext.request.contextPath}/UpdateResSQL" method="post" novalidate>
                                            <%                                                int id = 0;
                                                if (request.getParameter("id") != null) {
                                                    id = Integer.parseInt(request.getParameter("id"));
                                                }
                                                if (id != 0) {
                                                    RestaurantDAO restaurantDAO = new RestaurantDAO();
                                                    Restaurant restaurant = restaurantDAO.getRestaurantById(id);

                                            %>
                                            <span class="section"></span>
                                            <div class="field item form-group">
                                                <div class="col-md-6 col-sm-6">
                                                    <input class="form-control" hidden="" value="<%=restaurant.getrId()%>"  data-validate-length-range="6"  name="id" required="required" />
                                                </div>
                                            </div>
                                            <div class="field item form-group">
                                                <label class="col-form-label col-md-3 col-sm-3  label-align">Name Restaurant<span class="required">*</span></label>
                                                <div class="col-md-6 col-sm-6">
                                                    <input class="form-control" value="<%=restaurant.getrName()%>"  data-validate-length-range="3"  name="name" placeholder="Ex. Thinh Food, Texas Chicken" required="required" />
                                                </div>
                                            </div>
                                            <div class="field item form-group">
                                                <label class="col-form-label col-md-3 col-sm-3  label-align">Address<span class="required">*</span></label>
                                                <div class="col-md-6 col-sm-6">
                                                    <input class="form-control" class='address' value="<%=restaurant.getrAddress()%>" name="address" placeholder="Ex. Los Angeles, California" required='required' /></div>
                                            </div>
                                            <div class="field item form-group">
                                                <label class="col-form-label col-md-3 col-sm-3  label-align">Time Open<span class="required">*</span></label>
                                                <div class="col-md-6 col-sm-6">
                                                    <input class="form-control" class='time' value="<%=restaurant.getrTimeOpen()%>" type="time" name="timeOpen" required='required'></div>
                                            </div>
                                            <div class="field item form-group">
                                                <label class="col-form-label col-md-3 col-sm-3  label-align">Time Close<span class="required">*</span></label>
                                                <div class="col-md-6 col-sm-6">
                                                    <input class="form-control" class='time' value="<%=restaurant.getrTimeClose()%>" type="time" name="timeClose" required='required'></div>
                                            </div>
                                            <div class="field item form-group">
                                                <label class="col-form-label col-md-3 col-sm-3  label-align">Phone Restaurant<span class="required">*</span></label>
                                                <div class="col-md-6 col-sm-6">
                                                    <input class="form-control" type="tel" class='tel' value="<%=restaurant.getrPhone()%>" name="phone" required='required' data-validate-length-range="8,20" /></div>
                                            </div>

                                            <div class="field item form-group">
                                                <label class="col-form-label col-md-3 col-sm-3  label-align">Image Restaurant<span class="required">*</span></label>
                                                <div class="col-md-6 col-sm-6">
                                                    <input class="form-control" type="text" id="file" class='file' value="<%=restaurant.getrImage()%>" name="file" accept="image/png, image/jpg, image/jpeg" /></div>
                                            </div>
                                            <div class="ln_solid">
                                                <div class="form-group">
                                                    <div class="col-md-6 offset-md-3">
                                                        <button type='submit' class="btn btn-primary">UPDATE RESTAURANT</button>
                                                        <button type='reset' class="btn btn-success">Reset</button>
                                                    </div>
                                                </div>
                                            </div>
                                            <%                                                }
                                            %>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <footer>
                    <div class="pull-right">
                        GROUP 02
                    </div>
                    <div class="clearfix"></div>
                </footer>

            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="https://colorlib.com/polygon/vendors/validator/multifield.js"></script>
        <script src="${pageContext.request.contextPath}/js/validator.js"></script>
        <script>
            // initialize a validator instance from the "FormValidator" constructor.
            // A "<form>" element is optionally passed as an argument, but is not a must
            var validator = new FormValidator({"events": ['blur', 'input', 'change']}, document.forms[0]);
            // on form "submit" event
            document.forms[0].onsubmit = function (e) {
                var submit = true,
                        validatorResult = validator.checkAll(this);
                console.log(validatorResult);
                return !!validatorResult.valid;
            };
            // on form "reset" event
            document.forms[0].onreset = function (e) {
                validator.reset();
            };
            // stuff related ONLY for this demo page:
            $('.toggleValidationTooltips').change(function () {
                validator.settings.alerts = !this.checked;
                if (this.checked)
                    $('form .alert').remove();
            }).prop('checked', false);


        </script>

        <script src="https://colorlib.com/polygon/vendors/jquery/dist/jquery.min.js"></script>

        <script src="https://colorlib.com/polygon/vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>

        <script src="https://colorlib.com/polygon/vendors/fastclick/lib/fastclick.js"></script>

        <script src="https://colorlib.com/polygon/vendors/nprogress/nprogress.js"></script>



        <script src="${pageContext.request.contextPath}/js/custom.min.js"></script>
        <script defer src="https://static.cloudflareinsights.com/beacon.min.js" data-cf-beacon='{"rayId":"66c22f881b172f64","token":"cd0b4b3a733644fc843ef0b185f98241","version":"2021.6.0","si":10}'></script>
    </body>
</html>
<%
    }
%>