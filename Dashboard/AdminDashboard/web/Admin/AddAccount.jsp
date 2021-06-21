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
        <title>Add Account Page</title>
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
                <div class="col-sm-10"><h1>ADD NEW ACCOUNT</h1></div>
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

                            <form class="form" action="${pageContext.request.contextPath}/AddAccount" method="post" id="registrationForm" name="add">
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="first_name"><h4>First name</h4></label>
                                        <input type="number" hidden="" value="" class="form-control id" name="id"/>
                                        <input type="text" value=""  class="form-control first_name" name="first_name" id="first_name" placeholder="first name" title="enter your first name if any." required />
                                    </div>
                                </div>
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="last_name"><h4>Last name</h4></label>
                                        <input type="text" value="" class="form-control last_name" name="last_name" id="last_name" placeholder="last name" title="enter your last name if any." required />
                                    </div>
                                </div>

                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="phone"><h4>Phone</h4></label>
                                        <input type="text" value=""  class="form-control phone" name="phone" id="phone" placeholder="enter phone" title="enter your phone number if any." required />
                                    </div>
                                </div>
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="address"><h4>Address</h4></label>
                                        <input type="text" value="" class="form-control address" name="address" id="phone" placeholder="enter address" title="enter your address number if any." required />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="password"><h4>Password</h4></label>
                                        <input type="password" value="" class="form-control email" name="password" id="password" placeholder="enter your password" title="enter your password." required />
                                    </div>
                                </div>
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="email"><h4>Email</h4></label>
                                        <input type="email" value="" class="form-control email" name="email" id="email" placeholder="you@email.com" title="enter your email." required />
                                        <label id="email_error"></label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="confirmPassword"><h4>Confirm Password</h4></label>
                                        <input type="password" value="" class="form-control email" name="confirmPassword" id="email" placeholder="confirm your password" title="enter your confirm password." required />
                                    </div>
                                </div>
                                <div class="form-group" >
                                    <div class="col-xs-2" style="margin-top: 45px" >
                                        <label class="input-group-text"style="font-size: 15px"
                                               for="inputGroupSelect01">Role</label>
                                        <select class="form-select " style="padding-right: 22px" id="inputGroupSelect01" name="selectStatus">
                                            <option value="4" selected>Staff</option>
                                            <option value="3">Employee</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-12">
                                        <br>
                                        <button class="btn btn-lg btn-success saveData" id="addData" name="addData" type="submit"><i class="glyphicon glyphicon-ok-sign"></i>Add</button>
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
        <!--        <script>
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
                </script>-->
        <script>
//            function validateEmail(email) {
//                const re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
//                return re.test(email);
//            }
//
//            function validate() {
//                const $result = $("#email_error");
//                const email = $("#email").val();
//                $result.text("");
//
//                if (validateEmail(email)) {
//                    $result.text("Looks good!");
//                    $result.css("color", "green");
//                } else {
//                    $result.text(email + " Looks bad!");
//                    $result.css("color", "red");
//                }
//                return false;
//            }
//            
//            $("#addData").on("click", validate);
        </script>
        <script src="https://zuramai.github.io/mazer/demo/assets/vendors/perfect-scrollbar/perfect-scrollbar.min.js"></script>
        <script src="https://zuramai.github.io/mazer/demo/assets/js/bootstrap.bundle.min.js"></script>

        <!-- Include Choices JavaScript -->
        <script src="https://zuramai.github.io/mazer/demo/assets/vendors/choices.js/choices.min.js"></script>

        <script src="https://zuramai.github.io/mazer/demo/assets/js/main.js"></script>
    </body>

</html>
