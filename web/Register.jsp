<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register your account</title>
    <link rel="stylesheet" href="material-design-iconic-font.min.css">
    <link rel="stylesheet" href="css/register.css" >
    <style>
        .form-submit {
        margin-bottom: 10px;
    }
        .loginhere {
        margin-top: 5px; 
    }
    </style>
</head>

<body style="background-image: url(img/Fpt02.jpg);">
    <div class="main">

        <section class="signup">
            
            <div class="container">
                <div class="signup-content">
                    <form action="register" method="POST" id="signup-form" class="signup-form">
                        <h2 class="form-title">Create account</h2>
                        
                        <p class="text-danger" style="font-size: 23px;">
                        ${message}
                        </p>
                        <div class="form-group">
                            <input type="text" class="form-input" name="name" id="name" placeholder="Your Name"/>
                        </div>
                        <div class="form-group">
                            <input type="email" class="form-input" name="email" id="email" placeholder="Your Email"/>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-input" name="password" id="password" placeholder="Password"/>
                            <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                            <i class="bi bi-eye-slash" id="togglePassword"></i>
                        </div>
                        
                        <div class="form-group">
                            <input type="password" class="form-input" name="re_password" id="re_password" placeholder="Repeat your password"/>
                        </div>
                        
                        <div class="form-group">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="Sign up"/>
                        </div>
                    </form>
                    <p class="loginhere">
                        Have already an account ? <a href="Login.jsp" class="loginhere-link">Login here</a>
                    </p>
                </div>
            </div>
        </section>

    </div>   
</body>
</html>
