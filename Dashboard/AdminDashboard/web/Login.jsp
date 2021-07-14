<%-- 
    Document   : login
    Created on : Jun 14, 2021, 12:52:59 PM
    Author     : phuct
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
        <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Food Ordering System - Dashboard</title>
        <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="https://zuramai.github.io/mazer/demo/assets/vendors/bootstrap-icons/bootstrap-icons.css">
        <link rel="stylesheet" href="css/app.css">
        <link rel="stylesheet" href="css/auth.css">
        <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
        <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js" type="text/javascript"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="https://code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
        <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
    </head>
              <script text="text/javascript">
                    $(document).ready(function () {
                        $("#form").validate({
                            errorClass: 'error',
                            rules: {
                                //check username input cannot null, min length 8 and max length 30
                                 SigninName: {
                                   required: true,
                                    checkemail: true
                                   
                                },
                                /**
                                 * check password input cannot null, min length 8 and max length 30, 
                                 * and check password must have uuppercase letter , has a digit and special characters
                                 */
                                SigninPassword: {
                                    required: true,
                                    minlength: 8,
                                    maxlength: 20,
                                    checkpass: true
                                },
                            },
                            messages: {
                                //message warning input username
                                SigninName: {
                                    required: "<span class='text-danger'>Please enter email</span>",
                                    checkemail: " <span class='text-danger '>Invalid Email</span>"
                                    
                                },
                                //message warning input password
                               SigninPassword: {
                                    required: "<span class='text-danger '>Please enter password</span>",
                                    minlength: "<span class='text-danger '>Password must be greater than 8 characters</span>",
                                    maxlength: "<span class='text-danger '>Password must be smaller than 20 characters</span>",
                                    checkpass: "<span class='text-danger '>Password must be has a uppercase letter , has a digit and special characters !</span>"
                                },  
                            }
                        });
                        $.validator.addMethod("checkpass", function (value) {
                            var passReg = /^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\d]){1,})(?=(.*[\W]){1,})(?!.*\s).{8,}$/;// regex check password
                            return passReg.test(value);
                        });
                        $.validator.addMethod("checkemail", function (value) {
                            var emailReg = /^[a-zA-z0-9]+([.\-\_][a-zA-z0-9]+)*@[a-zA-z0-9]+([.\-\_][a-zA-z0-9]+)*(.[a-zA-z0-9]{2,})+$/; // regex check email
                            return emailReg.test(value);
                        });
                        $.validator.addMethod("checkurl", function (value) {
                            var webReg = /^(?:http(s)?:\/\/)?[\w.-]+(?:\.[\w\.-]+)+[\w\-\._~:/?#[\]@!\$&'\(\)\*\+,;=.]+$/; // regex check url website 
                            
                            return webReg.test(value);
                        });
                       
                          $.validator.addMethod("checktxtuser", function (value) {
                            var webReg = /^[A-Za-z]+(()[A-Za-z]+)$/;
        //                    let  r  = /^[A-Za-z]+(( )[A-Za-z]+*) +(( )?[A-Za-z]*)$/;
                            if(webReg.test(value)){
                                return true;
                            }else
                                return  false;
                        });
                    });
                </script>


  <%
      if (request.getAttribute("message") != null) {
              String s =  request.getAttribute("message").toString();
          %>
    <script>
        alert("Cant't Login \n Wrong username or password ..");   
    </script>
  <%
      }
  %>
    <body>
        <div id="auth">

            <div class="row h-100">
                <div class="col-lg-5 col-12">
                    <div id="auth-left">
                        <div class="auth-logo">
                            <a href="Login.jsp"><img src="./img/logo.png" alt="Logo" class="w-50 h-50"></a>
                        </div>
                        <h1 class="auth-title">Log in.</h1>
                        <p class="auth-subtitle mb-5">Log in with your data that you entered during registration.</p>

                        <form action="Signin" id="form" method="POST" onsubmit="validateMyForm();">
                            <div class="form-group position-relative has-icon-left mb-4">
                                
                                <input type="text" class="form-control form-control-xl" id="SigninName" name="SigninName"  required placeholder="Email">
                            </div>
                            <div class="form-group position-relative has-icon-left mb-4">
                                <input type="password" id="SigninPassword" name="SigninPassword" class="form-control form-control-xl" placeholder="Password" required>

                            </div>
                            <div class="form-check form-check-lg d-flex align-items-end">
                                <input class="form-check-input me-2" type="checkbox" value="" id="flexCheckDefault">
                                <label class="form-check-label text-gray-600" for="flexCheckDefault">
                                    Keep me logged in
                                </label>
                            </div>
                            <button class="btn btn-primary btn-block btn-lg shadow-lg mt-5">Log in</button>
                        </form>
                        <div class="text-center mt-5 text-lg fs-4">
                            <p class="text-gray-600">Don't have an account? <a href="registerAccount.jsp"
                                                                               class="font-bold">Sign
                                    up</a>.</p>
                            <p><a class="font-bold" href="forgotPassword.jsp">Forgot password?</a>.</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-7 d-none d-lg-block">
                    <div id="auth-right">

                    </div>
                </div>
            </div>

        </div>
    </body>

</html>
