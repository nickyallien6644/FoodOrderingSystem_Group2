<%-- 
    Document   : index
    Created on : Jun 14, 2021, 1:17:16 AM
    Author     : phuct
--%>

<%@page import="Models.Entity.User"%>
<%@page import="Models.Entity.TotalRevenue"%>
<%@page import="jdk.management.resource.internal.TotalResourceContext"%>
<%@page import="Models.Entity.OrderMostBranch"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.time.LocalDate"%>
<%@page import="Models.Entity.OrderYear"%>
<%@page import="Models.Entity.OrderMonth"%>
<%@page import="Models.Entity.OrderWeek"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Models.Entity.OrderMostDay"%>
<%@page import="Models.DAO.OrderDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("LoginUser") == null) {
        response.sendRedirect("../../AdminDashboard/Login.jsp");
    } else {
        User user = (User) session.getAttribute("LoginUser");
        if (user != null) {

            if (user.getRoleID() == 2) {
                response.sendRedirect("../Admin/index.jsp");
            } else if (user.getRoleID() == 3) {
                response.sendRedirect("../Employee/index.jsp");
            }
        }


%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Food Ordering System - Dashboard</title>

        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://zuramai.github.io/mazer/demo/assets/css/bootstrap.css">
        <link rel="stylesheet" href="../css/bold.css">

        <link rel="stylesheet" href="https://zuramai.github.io/mazer/demo/assets/vendors/perfect-scrollbar/perfect-scrollbar.css">
        <link rel="stylesheet" href="https://zuramai.github.io/mazer/demo/assets/vendors/bootstrap-icons/bootstrap-icons.css">
        <link rel="stylesheet" href="../css/app.css">

        <link rel="shortcut icon" href="https://zuramai.github.io/mazer/demo/assets/images/favicon.svg" type="image/x-icon">

    </head>

    <body>

        <div id="app">
            <div id="sidebar" class="active">
                <div class="sidebar-wrapper active">
                    <div class="sidebar-header">
                        <div class="d-flex justify-content-between">
                            <div class="logo">
                                <a href="index.jsp"><img src="../img/logo.png" alt="Logo" class="w-50 h-50" srcset=""></a>
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

                            <li class="sidebar-item active ">
                                <a href="index.jsp" class='sidebar-link'>
                                    <i class="bi bi-grid-fill"></i>
                                    <span>Staff dashboard</span>
                                </a>
                            </li>

                            <li class="sidebar-item  ">
                                <a href="RestaurantInformation.jsp" class='sidebar-link'>
                                    <i class="bi bi-envelope-fill"></i>
                                    <span>Restaurant information</span>
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
                    <h3>STAFF Dashboard</h3>
                </div>
                <div class="page-title">
                    <section class="row">
                        <div class="col-12 col-lg-9">
                            <div class="row" >
                                <%                                    OrderDAO orderDAO = new OrderDAO();
                                    int count[] = orderDAO.countAllOrder();


                                %>
                                <div class="col-6 col-lg-6 col-md-6 pt-2">
                                    <div class="card" style="padding-bottom: 5px;">
                                        <div class="card-body ">
                                            <div class="" style="margin-top: 20px;">
                                                <h5 class="text-muted font-semibold">Orders of Customer complete: <b style="color: black"><%=count[0]%></b></h5>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-6 col-lg-6 col-md-6 pt-2">
                                    <div class="card" style="padding-bottom: 5px">
                                        <div class="card-body" >
                                            <div class="" style="margin-top: 20px">
                                                <h5  class="text-muted font-semibold">Orders of Customer incomplete: <b style="color: black"><%=count[1]%></b></h5>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12" style="">
                                    <div class="card" style="">
                                        <div class="card-header">
                                            <h4>Order statistics</h4>
                                        </div>
                                        <div class="card-body">
                                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                                <li class="nav-item" role="presentation">
                                                    <a class="nav-link active" id="home-tab" data-bs-toggle="tab" href="#week"
                                                       role="tab" aria-controls="home" aria-selected="true">Week</a>
                                                </li>
                                                <li class="nav-item" role="presentation">
                                                    <a class="nav-link" id="profile-tab" data-bs-toggle="tab" href="#month"
                                                       role="tab" aria-controls="profile" aria-selected="false">Month</a>
                                                </li>
                                                <li class="nav-item" role="presentation">
                                                    <a class="nav-link" id="contact-tab" data-bs-toggle="tab" href="#year"
                                                       role="tab" aria-controls="contact" aria-selected="false">Year</a>
                                                </li>
                                            </ul>
                                            <div class="tab-content" id="myTabContent">
                                                <div class="tab-pane fade show active" id="week" role="tabpanel"
                                                     aria-labelledby="home-tab">
                                                    <div id="chart-profile-visit-Weeks"></div>
                                                </div>
                                                <div class="tab-pane fade" id="month" role="tabpanel"
                                                     aria-labelledby="profile-tab">
                                                    <div id="chart-profile-visit-Months"></div>
                                                </div>
                                                <div class="tab-pane fade" id="year" role="tabpanel"
                                                     aria-labelledby="contact-tab">
                                                    <div id="chart-profile-visit-Years" ></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12 col-xl-8" >
                                    <div class="card">
                                        <div class="card-header">
                                            <h4>Most ordered food / drink of the day</h4>
                                        </div>
                                        <div class="card-body">
                                            <%
                                                ArrayList<OrderMostDay> orderMostList = new ArrayList<OrderMostDay>();
                                                orderMostList = orderDAO.getMostDay(user.getrID());
                                                if (orderMostList.size() == 0) {
                                                    orderMostList = orderDAO.getMostYesterDay();
                                                }
                                            %>
                                            <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
                                                <ol class="carousel-indicators">
                                                    <%  for (int i = 0; i < orderMostList.size(); i++) {
                                                            if (i == 0) {
                                                    %>
                                                    <li data-bs-target="#carouselExampleCaptions" data-bs-slide-to="<%=i%>"
                                                        class="active"></li>
                                                        <%
                                                            }
                                                            if (i != 0) {
                                                        %>
                                                    <li data-bs-target="#carouselExampleCaptions" data-bs-slide-to="<%=i%>"></li>
                                                        <%                                                            }
                                                            }
                                                        %>
                                                </ol>
                                                <div class="carousel-inner">
                                                    <%  for (int i = 0; i < orderMostList.size(); i++) {
                                                            if (i == 0) {
                                                    %>
                                                    <div class="carousel-item active" >
                                                        <div class="d-block" style="text-align: center">
                                                            <img src="<%=orderMostList.get(i).getImage()%>"  style="width:355px; height: 355px;" alt="...">
                                                        </div>
                                                        <div class="carousel-caption d-none d-md-block">
                                                            <h5 class="bg-dark"><%=orderMostList.get(i).getpName()%></h5>
                                                            <p class="bg-dark"><%=orderMostList.get(i).getpPrice()%></p>
                                                        </div>
                                                    </div>
                                                    <%
                                                        }
                                                        if (i != 0) {
                                                    %>
                                                    <div class="carousel-item">
                                                        <div class="d-block" style="text-align: center">
                                                            <img src="<%=orderMostList.get(i).getImage()%>"  style="width:355px; height: 355px;" alt="...">
                                                        </div>
                                                        <div class="carousel-caption d-none d-md-block">
                                                            <h5 class="bg-dark"><%=orderMostList.get(i).getpName()%></h5>
                                                            <p class="bg-dark"><%=orderMostList.get(i).getpPrice()%></p>
                                                        </div>
                                                    </div>
                                                    <%
                                                            }
                                                        }
                                                    %>
                                                </div>
                                                <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button"
                                                   data-bs-slide="prev">
                                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                                    <span class="visually-hidden">Previous</span>
                                                </a>
                                                <a class="carousel-control-next" href="#carouselExampleCaptions" role="button"
                                                   data-bs-slide="next">
                                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                                    <span class="visually-hidden">Next</span>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12 col-xl-4">
                                    <div class="card" >
                                        <div class="card-header">
                                            <h4>Total revenue: </h4>
                                            <h6>(B = bcoin)</h6>
                                        </div>
                                        <%
                                            TotalRevenue totalRevenue = new TotalRevenue();
                                            totalRevenue = orderDAO.getTotalRevenue();
                                            if (totalRevenue != null) {

                                        %>
                                        <div class="card-body">
                                            <div class="row " >
                                                <div class="col-7">
                                                    <div class="d-flex align-items-center">
                                                        <h5 class="mb-0 ms-3 ">Day: <%=totalRevenue.getDay()%></h5>
                                                    </div>
                                                </div>
                                                <div class="col-5">
                                                    <h5 class="mb-0"><%=totalRevenue.getPriceDay()%> B</h5>
                                                </div>
                                                <div class="col-12">
                                                    <!--<div id="chart-europe"></div>-->
                                                </div>
                                            </div>
                                            <div class="row ">
                                                <div class="col-7">
                                                    <div class="d-flex align-items-center">
                                                        <h5 class="mb-0 ms-3">Month: <%=totalRevenue.getMonth()%></h5>
                                                    </div>
                                                </div>
                                                <div class="col-5">

                                                    <h5 class="mb-0"><%=totalRevenue.getPriceMonth()%> B</h5>
                                                </div>
                                                <div class="col-12">
                                                    <!--<div id="chart-america"></div>-->
                                                </div>
                                            </div>
                                            <div class="row ">
                                                <div class="col-7">
                                                    <div class="d-flex align-items-center">
                                                        <h5 class="mb-0 ms-3">Year: <%=totalRevenue.getYear()%></h5>
                                                    </div>
                                                </div>
                                                <div class="col-5">
                                                    <h5 class="mb-0"><%=totalRevenue.getPriceYear()%> B</h5>
                                                </div>
                                                <div class="col-12">
                                                    <!--<div id="chart-indonesia"></div>-->
                                                </div>
                                            </div>
                                        </div>
                                        <%
                                            }
                                        %>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-12 col-lg-3 pt-2">
                            <div class="card">
                                <div class="card-body py-3 px-5">
                                    <div class="d-flex align-items-center">
                                        <div class="ms-2 name" style="padding-right: 7px">
                                            <h5 class="font-bold">STAFF</h5>
                                            <h6 class="text-muted mb-0"><%=user.getaFirstname()%></h6>
                                        </div>
                                        <div class="btn-group">
                                            <button type="button" class="btn btn-info dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                                            </button>
                                            <ul class="dropdown-menu">
                                                <li><a class="dropdown-item" href="#">Account</a></li>
                                                <li><hr class="dropdown-divider"></li>
                                                <li><a class="dropdown-item" href="../logout">Logout</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card" style="margin-top: 50 px; padding-bottom: 70px;">
                                <div class="card-header">
                                    <h4>The branch that orders the most</h4>
                                </div>
                                <div class="card-body">
                                    <div id="chart-visitors-profiles"></div>
                                </div>
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
        <script src="../js/apexcharts.js"></script>
        <!--<script src="../js/dashboard.js"></script>-->

        <script src="../js/main.js"></script>

        <script>
            <%
                ArrayList<OrderWeek> orderWeeks = new ArrayList<OrderWeek>();

                for (int i = 6; i >= 0; i--) {
                    OrderWeek orderWeek = new OrderWeek();
                    ArrayList<OrderWeek> temp = new ArrayList<OrderWeek>();
                    temp = orderDAO.getOrderWeek(i);
                    orderWeek.setCount(temp.get(0).getCount());
                    orderWeek.setDayOfWeek(temp.get(0).getDayOfWeek());
                    orderWeeks.add(orderWeek);
                }
                if (orderWeeks != null) {
            %>

            var date1 = "<%=orderWeeks.get(6).getDayOfWeek().toLocalDate().getDayOfWeek()%>";
            var date2 = "<%=orderWeeks.get(5).getDayOfWeek().toLocalDate().getDayOfWeek()%>";
            var date3 = "<%=orderWeeks.get(4).getDayOfWeek().toLocalDate().getDayOfWeek()%>";
            var date4 = "<%=orderWeeks.get(3).getDayOfWeek().toLocalDate().getDayOfWeek()%>";
            var date5 = "<%=orderWeeks.get(2).getDayOfWeek().toLocalDate().getDayOfWeek()%>";
            var date6 = "<%=orderWeeks.get(1).getDayOfWeek().toLocalDate().getDayOfWeek()%>";
            var date7 = "<%=orderWeeks.get(0).getDayOfWeek().toLocalDate().getDayOfWeek()%>";

            var data1 = <%=orderWeeks.get(0).getCount()%>;
            var data2 = <%=orderWeeks.get(1).getCount()%>;
            var data3 = <%=orderWeeks.get(2).getCount()%>;
            var data4 = <%=orderWeeks.get(3).getCount()%>;
            var data5 = <%=orderWeeks.get(4).getCount()%>;
            var data6 = <%=orderWeeks.get(5).getCount()%>;
            var data7 = <%=orderWeeks.get(6).getCount()%>;

            var optionsProfileVisitWeeks = {
                annotations: {
                    position: 'back'
                },
                dataLabels: {
                    enabled: false
                },
                chart: {
                    type: 'bar',
                    height: 300
                },
                fill: {
                    opacity: 1
                },
                plotOptions: {
                },
                series: [{
                        name: 'Orders',
                        data: [data1, data2, data3, data4, data5, data6, data7]
                    }],
                colors: '#435ebe',
                xaxis: {
                    categories: [date7, date6, date5, date4, date3, date2, date1],
                },
            }
            var chartProfileVisitWeeks = new ApexCharts(document.querySelector("#chart-profile-visit-Weeks"), optionsProfileVisitWeeks);
            chartProfileVisitWeeks.render();
            <%
                }
            %>

            <%
                ArrayList<OrderMonth> orderMonthList = new ArrayList<OrderMonth>();

                for (int i = 11; i >= 0; i--) {
                    OrderMonth orderMonth = new OrderMonth();
                    ArrayList<OrderMonth> temp = new ArrayList<OrderMonth>();
                    temp = orderDAO.getOrderMonth(i, i - 1);
                    orderMonth.setCount(temp.get(0).getCount());
                    orderMonth.setMonth(temp.get(0).getMonth());
                    orderMonthList.add(orderMonth);
                }

                if (orderMonthList != null) {
            %>

            var date1 = "<%=orderMonthList.get(11).getMonth().toLocalDate().getMonth()%>";
            var date2 = "<%=orderMonthList.get(10).getMonth().toLocalDate().getMonth()%>";
            var date3 = "<%=orderMonthList.get(9).getMonth().toLocalDate().getMonth()%>";
            var date4 = "<%=orderMonthList.get(8).getMonth().toLocalDate().getMonth()%>";
            var date5 = "<%=orderMonthList.get(7).getMonth().toLocalDate().getMonth()%>";
            var date6 = "<%=orderMonthList.get(6).getMonth().toLocalDate().getMonth()%>";
            var date7 = "<%=orderMonthList.get(5).getMonth().toLocalDate().getMonth()%>";
            var date8 = "<%=orderMonthList.get(4).getMonth().toLocalDate().getMonth()%>";
            var date9 = "<%=orderMonthList.get(3).getMonth().toLocalDate().getMonth()%>";
            var date10 = "<%=orderMonthList.get(2).getMonth().toLocalDate().getMonth()%>";
            var date11 = "<%=orderMonthList.get(1).getMonth().toLocalDate().getMonth()%>";
            var date12 = "<%=orderMonthList.get(0).getMonth().toLocalDate().getMonth()%>";

            var data1 = <%=orderMonthList.get(0).getCount()%>;
            var data2 = <%=orderMonthList.get(1).getCount()%>;
            var data3 = <%=orderMonthList.get(2).getCount()%>;
            var data4 = <%=orderMonthList.get(3).getCount()%>;
            var data5 = <%=orderMonthList.get(4).getCount()%>;
            var data6 = <%=orderMonthList.get(5).getCount()%>;
            var data7 = <%=orderMonthList.get(6).getCount()%>;
            var data8 = <%=orderMonthList.get(7).getCount()%>;
            var data9 = <%=orderMonthList.get(8).getCount()%>;
            var data10 = <%=orderMonthList.get(9).getCount()%>;
            var data11 = <%=orderMonthList.get(10).getCount()%>;
            var data12 = <%=orderMonthList.get(11).getCount()%>;

            var optionsProfileVisitMonths = {
                annotations: {
                    position: 'back'
                },
                dataLabels: {
                    enabled: false
                },
                chart: {
                    type: 'bar',
                    height: 300
                },
                fill: {
                    opacity: 1
                },
                plotOptions: {
                },
                series: [{
                        name: 'Orders',
                        data: [data1, data2, data3, data4, data5, data6, data7, data8, data9, data10, data11, data12]
                    }],
                colors: '#435ebe',
                xaxis: {
                    categories: [date12, date11, date10, date9, date8, date7, date6, date5, date4, date3, date2, date1],
                },
            }
            var chartProfileVisitMonths = new ApexCharts(document.querySelector("#chart-profile-visit-Months"), optionsProfileVisitMonths);
            chartProfileVisitMonths.render();
            <%
                }
            %>
            <%
                ArrayList<OrderYear> orderYearList = new ArrayList<OrderYear>();

                for (int i = 4; i >= 0; i--) {
                    OrderYear orderyear = new OrderYear();
                    ArrayList<OrderYear> temp = new ArrayList<OrderYear>();
                    temp = orderDAO.getOrderYear(i, i - 1);
                    orderyear.setCount(temp.get(0).getCount());
                    orderyear.setYear(temp.get(0).getYear());
                    orderYearList.add(orderyear);
                }

                if (orderYearList != null) {
            %>

            var date1 = "<%=orderYearList.get(4).getYear().toLocalDate().getYear()%>";
            var date2 = "<%=orderYearList.get(3).getYear().toLocalDate().getYear()%>";
            var date3 = "<%=orderYearList.get(2).getYear().toLocalDate().getYear()%>";
            var date4 = "<%=orderYearList.get(1).getYear().toLocalDate().getYear()%>";
            var date5 = "<%=orderYearList.get(0).getYear().toLocalDate().getYear()%>";

            var data1 = <%=orderYearList.get(0).getCount()%>;
            var data2 = <%=orderYearList.get(1).getCount()%>;
            var data3 = <%=orderYearList.get(2).getCount()%>;
            var data4 = <%=orderYearList.get(3).getCount()%>;
            var data5 = <%=orderYearList.get(4).getCount()%>;


            var optionsProfileVisitYears = {
                annotations: {
                    position: 'back'
                },
                dataLabels: {
                    enabled: false
                },
                chart: {
                    type: 'bar',
                    height: 300
                },
                fill: {
                    opacity: 1
                },
                plotOptions: {
                },
                series: [{
                        name: 'Orders',
                        data: [data1, data2, data3, data4, data5]
                    }],
                colors: '#435ebe',
                xaxis: {
                    categories: [date5, date4, date3, date2, date1],
                },
            }

            var chartProfileVisitYears = new ApexCharts(document.querySelector("#chart-profile-visit-Years"), optionsProfileVisitYears);
            chartProfileVisitYears.render();
            <%
                }
            %>

            var mostOne = '';
            var mostTwo = '';
            var mostThree = '';
            var perOne = '';
            var perTwo = '';
            var perThree = '';
            <%
                ArrayList<OrderMostBranch> orderMostBranchList = new ArrayList<OrderMostBranch>();
                orderMostBranchList = orderDAO.getOrderBranchDay();
                if (orderMostBranchList.size() == 0) {
                    orderMostBranchList = orderDAO.getOrderBranchYesterDay();
                }
                if (orderMostBranchList.size() != 0) {
                    if (orderMostBranchList.size() == 3) {
            %>
            mostOne = '<%=orderMostBranchList.get(0).getrName()%>' + ' - ' + '<%=orderMostBranchList.get(0).getrAddress()%>';
            mostTwo = '<%=orderMostBranchList.get(1).getrName()%>' + ' - ' + '<%=orderMostBranchList.get(1).getrAddress()%>';
            mostThree = '<%=orderMostBranchList.get(2).getrName()%>' + ' - ' + '<%=orderMostBranchList.get(2).getrAddress()%>';

            perOne = <%=orderMostBranchList.get(0).getPercentage()%>;
            perTwo = <%=orderMostBranchList.get(1).getPercentage()%>;
            perThree = <%=orderMostBranchList.get(2).getPercentage()%>;

            var optionsVisitorsProfiles = {
                series: [perOne, perTwo, perThree],
                labels: [mostOne, mostTwo, mostThree],
                colors: ['#435ebe', '#55c6e8', '#00a8ff'],
                chart: {
                    type: 'donut',
                    width: '100%',
                    height: '350px'
                },
                legend: {
                    position: 'bottom'
                },
                plotOptions: {
                    pie: {
                        donut: {
                            size: '30%'
                        }
                    }
                }
            }
            <%
            } else if (orderMostBranchList.size() == 2) {
            %>
            mostOne = '<%=orderMostBranchList.get(0).getrName()%>' + ' - ' + '<%=orderMostBranchList.get(0).getrAddress()%>';
            mostTwo = '<%=orderMostBranchList.get(1).getrName()%>' + ' - ' + '<%=orderMostBranchList.get(1).getrAddress()%>';

            perOne = <%=orderMostBranchList.get(0).getPercentage()%>;
            perTwo = <%=orderMostBranchList.get(1).getPercentage()%>;
            var optionsVisitorsProfiles = {
                series: [perOne, perTwo],
                labels: [mostOne, mostTwo],
                colors: ['#435ebe', '#55c6e8'],
                chart: {
                    type: 'donut',
                    width: '100%',
                    height: '350px'
                },
                legend: {
                    position: 'bottom'
                },
                plotOptions: {
                    pie: {
                        donut: {
                            size: '30%'
                        }
                    }
                }
            }
            <%
            } else if (orderMostBranchList.size() == 1) {
            %>
            mostOne = '<%=orderMostBranchList.get(0).getrName()%>' + ' - ' + '<%=orderMostBranchList.get(0).getrAddress()%>';

            perOne = <%=orderMostBranchList.get(0).getPercentage()%>;
            var optionsVisitorsProfiles = {
                series: [perOne],
                labels: [mostOne],
                colors: ['#435ebe'],
                chart: {
                    type: 'donut',
                    width: '100%',
                    height: '350px'
                },
                legend: {
                    position: 'bottom'
                },
                plotOptions: {
                    pie: {
                        donut: {
                            size: '30%'
                        }
                    }
                }
            }

            <%
                }
            %>
            var chartVisitorsProfiles = new ApexCharts(document.querySelector("#chart-visitors-profiles"), optionsVisitorsProfiles);
            chartVisitorsProfiles.render();

            <%               }
            %>


        </script>
    </body>
</html>
<%
    }
%>