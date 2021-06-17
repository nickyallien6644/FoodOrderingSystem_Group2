<%-- 
    Document   : index
    Created on : Jun 14, 2021, 1:17:16 AM
    Author     : phuct
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Food Ordering System - Admin Dashboard</title>

        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://zuramai.github.io/mazer/demo/assets/css/bootstrap.css">

        <!--    <link rel="stylesheet" href="https://zuramai.github.io/mazer/demo/assets/vendors/iconly/bold.css">-->
        <link rel="stylesheet" href="css/bold.css">


        <link rel="stylesheet" href="https://zuramai.github.io/mazer/demo/assets/vendors/perfect-scrollbar/perfect-scrollbar.css">
        <!--<link rel="stylesheet" href="css/perfect-scrollbar.css">-->
        <link rel="stylesheet" href="https://zuramai.github.io/mazer/demo/assets/vendors/bootstrap-icons/bootstrap-icons.css">
        <!--    <link rel="stylesheet" href="https://zuramai.github.io/mazer/demo/assets/css/app.css">-->
        <link rel="stylesheet" href="css/app.css">

        <link rel="shortcut icon" href="https://zuramai.github.io/mazer/demo/assets/images/favicon.svg" type="image/x-icon">
      
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

                            <li class="sidebar-item active ">
                                <a href="index.jsp" class='sidebar-link'>
                                    <i class="bi bi-grid-fill"></i>
                                    <span>Dashboard</span>
                                </a>
                            </li>
<!--                            <li class="sidebar-item  ">
                                <a href="tableDatable.jsp" class='sidebar-link'>
                                    <i class="bi bi-file-earmark-spreadsheet-fill"></i>
                                    <span>Datatable</span>
                                </a>
                            </li>-->

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

            <!--            //*******************************************************-->
            <!--            //*******************************************************-->
            <!--            //*******************************************************-->
            <div id="main">
                <header class="mb-3">
                    <a href="#" class="burger-btn d-block d-xl-none">
                        <i class="bi bi-justify fs-3"></i>
                    </a>
                </header>

                <div class="page-heading">
                    <h3>Profile Statistics</h3>
                </div>
                <div class="page-content">
                    <section class="row">
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
                            <div class="row">
                                <div class="col-12">
                                    <div class="card">
                                        <div class="card-header">
                                            <h4>Order statistics</h4>
                                        </div>
                                        <div class="card-body">
                                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                                <li class="nav-item" role="presentation">
                                                    <a class="nav-link active" id="home-tab" data-bs-toggle="tab" href="#home"
                                                       role="tab" aria-controls="home" aria-selected="true">Week</a>
                                                </li>
                                                <li class="nav-item" role="presentation">
                                                    <a class="nav-link" id="profile-tab" data-bs-toggle="tab" href="#profile"
                                                       role="tab" aria-controls="profile" aria-selected="false">Month</a>
                                                </li>
                                                <li class="nav-item" role="presentation">
                                                    <a class="nav-link" id="contact-tab" data-bs-toggle="tab" href="#contact"
                                                       role="tab" aria-controls="contact" aria-selected="false">Year</a>
                                                </li>
                                            </ul>
                                            <div class="tab-content" id="myTabContent">
                                                <div class="tab-pane fade show active" id="home" role="tabpanel"
                                                     aria-labelledby="home-tab">
                                                    <div id="chart-profile-visit-Week"></div>
                                                </div>
                                                <div class="tab-pane fade" id="profile" role="tabpanel"
                                                     aria-labelledby="profile-tab">
                                                    <div id="chart-profile-visit-Month"></div>
                                                </div>
                                                <div class="tab-pane fade" id="contact" role="tabpanel"
                                                     aria-labelledby="contact-tab">
                                                    <div id="chart-profile-visit-Year" ></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12 col-xl-4">
                                    <div class="card" style="padding-bottom: 20px">
                                        <div class="card-header">
                                            <h4>Orders of the day</h4>
                                        </div>
                                        <div class="card-body">
                                            <div class="row " style="margin-top: 50px">
                                                <div class="col-6">
                                                    <div class="d-flex align-items-center">
                                                        <svg class="bi text-primary" width="32" height="32" fill="blue"
                                                             style="width:10px">
                                                        <use
                                                            xlink:href="https://zuramai.github.io/mazer/demo/assets/vendors/bootstrap-icons/bootstrap-icons.svg#circle-fill" />
                                                        </svg>
                                                        <h5 class="mb-0 ms-3">Morning</h5>
                                                    </div>
                                                </div>
                                                <div class="col-6">
                                                    <h5 class="mb-0">230</h5>
                                                </div>
                                                <div class="col-12">
                                                    <div id="chart-europe"></div>
                                                </div>
                                            </div>
                                            <div class="row "style="margin-top: 50px">
                                                <div class="col-6">
                                                    <div class="d-flex align-items-center">
                                                        <svg class="bi text-success" width="32" height="32" fill="blue"
                                                             style="width:10px">
                                                        <use
                                                            xlink:href="https://zuramai.github.io/mazer/demo/assets/vendors/bootstrap-icons/bootstrap-icons.svg#circle-fill" />
                                                        </svg>
                                                        <h5 class="mb-0 ms-3">Afternoon</h5>
                                                    </div>
                                                </div>
                                                <div class="col-6">
                                                    <h5 class="mb-0">60</h5>
                                                </div>
                                                <div class="col-12">
                                                    <div id="chart-america"></div>
                                                </div>
                                            </div>
                                            <div class="row " style="margin-top: 50px">
                                                <div class="col-6">
                                                    <div class="d-flex align-items-center">
                                                        <svg class="bi text-danger" width="32" height="32" fill="blue"
                                                             style="width:10px">
                                                        <use
                                                            xlink:href="https://zuramai.github.io/mazer/demo/assets/vendors/bootstrap-icons/bootstrap-icons.svg#circle-fill" />
                                                        </svg>
                                                        <h5 class="mb-0 ms-3">Night</h5>
                                                    </div>
                                                </div>
                                                <div class="col-6">
                                                    <h5 class="mb-0">95</h5>
                                                </div>
                                                <div class="col-12">
                                                    <div id="chart-indonesia"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12 col-xl-8">
                                    <div class="card">
                                        <div class="card-header">
                                            <h4>Most ordered food / drink of the day</h4>
                                        </div>
                                        <div class="card-body">
                                            <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
                                                <ol class="carousel-indicators">
                                                    <li data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0"
                                                        class="active"></li>
                                                    <li data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"></li>
                                                    <li data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"></li>
                                                </ol>
                                                <div class="carousel-inner">
                                                    <div class="carousel-item active">
                                                        <img src="img/SANDWICH-TRUNG-MAYO.jpg" class="d-block w-100" alt="...">
                                                        <div class="carousel-caption d-none d-md-block">
                                                            <h5 class="bg-dark">Sandwich Egg & Mayonnaise</h5>
                                                            <p class="bg-dark">30.000 đ</p>
                                                        </div>
                                                    </div>
                                                    <div class="carousel-item">
                                                        <img  src="img/BANH-MI-NEM-NUONG.jpg" class="d-block w-100" alt="...">
                                                        <div class="carousel-caption d-none d-md-block">
                                                            <h5 class="bg-dark">Vietnamese Sausages Bread</h5>
                                                            <p class="bg-dark">25.000 đ</p>
                                                        </div>
                                                    </div>
                                                    <div class="carousel-item">
                                                        <img  src="img/MI-TRON-XUC-XICH.jpg" class="d-block w-100" alt="...">
                                                        <div class="carousel-caption d-none d-md-block">
                                                            <h5 class="bg-dark">Mixed Noodles with Sausages</h5>
                                                            <p class="bg-dark">32.000 đ</p>
                                                        </div>
                                                    </div>
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
                                            <h5 class="font-bold">Admin01</h5>
                                            <h6 class="text-muted mb-0">@ThinhBNP</h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--                            <div class="card">
                                                            <div class="card-header">
                                                                <h4>Recent Messages</h4>
                                                            </div>
                                                            <div class="card-content pb-4">
                                                                <div class="recent-message d-flex px-4 py-3">
                                                                    <div class="avatar avatar-lg">
                                                                        <img src="https://zuramai.github.io/mazer/demo/assets/images/faces/4.jpg">
                                                                    </div>
                                                                    <div class="name ms-4">
                                                                        <h5 class="mb-1">Hank Schrader</h5>
                                                                        <h6 class="text-muted mb-0">@johnducky</h6>
                                                                    </div>
                                                                </div>
                                                                <div class="recent-message d-flex px-4 py-3">
                                                                    <div class="avatar avatar-lg">
                                                                        <img src="https://zuramai.github.io/mazer/demo/assets/images/faces/5.jpg">
                                                                    </div>
                                                                    <div class="name ms-4">
                                                                        <h5 class="mb-1">Dean Winchester</h5>
                                                                        <h6 class="text-muted mb-0">@imdean</h6>
                                                                    </div>
                                                                </div>
                                                                <div class="recent-message d-flex px-4 py-3">
                                                                    <div class="avatar avatar-lg">
                                                                        <img src="https://zuramai.github.io/mazer/demo/assets/images/faces/1.jpg">
                                                                    </div>
                                                                    <div class="name ms-4">
                                                                        <h5 class="mb-1">John Dodol</h5>
                                                                        <h6 class="text-muted mb-0">@dodoljohn</h6>
                                                                    </div>
                                                                </div>
                                                                <div class="px-4">
                                                                    <button class='btn btn-block btn-xl btn-light-primary font-bold mt-3'>Start
                                                                        Conversation</button>
                                                                </div>
                                                            </div>
                                                        </div>-->
                            <div class="card" style="margin-top: 70 px; padding-bottom: 32px">
                                <div class="card-header">
                                    <h4>The branch that orders the most</h4>
                                </div>
                                <div class="card-body">
                                    <div id="chart-visitors-profile"></div>
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
        <!--<script src="https://zuramai.github.io/mazer/demo/assets/vendors/perfect-scrollbar/perfect-scrollbar.min.js"></script>-->
        <script src="js/perfect-scrollbar.min.js"></script>

        <!--<script src="https://zuramai.github.io/mazer/demo/assets/js/bootstrap.bundle.min.js"></script>-->
        <script src="js/bootstrap.bundle.min.js"></script>


        <!--<script src="https://zuramai.github.io/mazer/demo/assets/vendors/apexcharts/apexcharts.js"></script>-->
        <script src="js/apexcharts.js"></script>
        <!--<script src="https://zuramai.github.io/mazer/demo/assets/js/pages/dashboard.js"></script>-->
        <script src="js/dashboard.js"></script>


        <!--<script src="https://zuramai.github.io/mazer/demo/assets/js/main.js"></script>-->
        <script src="js/main.js"></script>

    </body>

</html>