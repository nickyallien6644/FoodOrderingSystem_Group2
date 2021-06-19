<%-- 
    Document   : UpdateProfile
    Created on : Jun 15, 2021, 8:55:22 PM
    Author     : phuct
--%>

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

        <title>Add Product</title>
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
                <div class="col-sm-10"><h1>Add Product</h1></div>
                <div class="col-sm-2"><a href="index.jsp" class="pull-right"><img title="profile image" class="img-circle img-responsive" src="../img/logo.png"></a></div>
            </div>
            <div class="row">
                <div class="col-sm-3"><!--left col-->


                    <div class="text-center">
                        <img src="https://www.pngfind.com/pngs/m/330-3309459_food-logo-transparent-background-hd-png-download.png" class="avatar img-circle img-thumbnail" alt="avatar">
                        <h6>Upload a different photo...</h6>
                        <input type="file" class="text-center center-block file-upload">
                    </div><br>
                </div><!--/col-3-->
                <div class="col-sm-9">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#home">Home</a></li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active" id="home">
                            <form class="form" action="indexAdmin.jsp" method="post" id="registrationForm">
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="first_name"><h4>Product name</h4></label>
                                        <input type="text" class="form-control first_name" name="product name" id="first_name" placeholder="product name" title="enter your first name if any.">
                                    </div>
                                </div>
                                

                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="phone"><h4>Price</h4></label>
                                        <input type="text" class="form-control" name="price of product" id="phone" placeholder="price of product" title="enter your phone number if any.">
                                    </div>
                                </div>
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="email"><h4>Description</h4></label>
                                        <textarea  type="email" class="form-control" name="description" id="email" placeholder="description" title="enter your email."></textarea>
                                    </div>
                                </div>
                               <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="last_name"><h4>Category</h4></label>
                                        <select class="custom-select" id="gender2">
                                            <option selected>Choose...</option>
                                            <option value="1">Food</option>
                                            <option value="2">Drinks</option>
                                        </select> 
                                    </div>
                                </div>
                            </form>
                            <hr>
                        </div><!--/tab-pane-->
                    </div><!--/tab-pane-->
                </div><!--/tab-content-->
            </div><!--/col-9-->
        </div><!--/row-->
        <script>
            $(document).ready(function () {


                var readURL = function (input) {
                    if (input.files && input.files[0]) {
                        var reader = new FileReader();

                        reader.onload = function (e) {
                            $('.avatar').attr('src', e.target.result);
                        }

                        reader.readAsDataURL(input.files[0]);
                    }
                }


                $(".file-upload").on('change', function () {
                    readURL(this);
                });
            });

//            $(".saveData").click(function () {
////                var $row = $(this).closest("tr");    // Find the row
////                var $text = $row.find(".id").text(); // Find the text
//               var $firstName = document.getElementById("first_name").value;
//                if ($firstName) {
////                    var url = "/AdminDashboard/UpdateProfile?id=" + $firstName;
//                      var url = "/AdminDashboard/indexAdmin.jsp";
//
////                    alert("Hello " +$firstName);
//                    window.location.href = url;
//                }
//                // Let's test it out
//
//            });

        </script>
    </body>

</html>
