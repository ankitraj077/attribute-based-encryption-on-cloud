<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>REGISTRATION</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/arial.js"></script>
<script type="text/javascript" src="js/cuf_run.js"></script>
<script>
    function validate(){
        var locat=document.name.locat.value;
        var pass=document.name.password.value;
        var cpass=document.name.cpassword.value;
        var uname=document.name.uname.value;
        var profile=document.name.profile.value;
        
        if(locat==0){
            alert("Enter your Location");
            document.name.locat.focus();
            return false;
        }
        if(pass==0){
            alert("Enter your password");
            document.name.password.focus();
            
            return false;
        }
        if(cpass==0){
            alert("Enter your password cofirmation");
            document.name.cpassword.focus();
            
            
            return false;
        }
        if(pass!=cpass){
            alert("Incorrect Confirm password. PLease re-enter");
            document.name.password.focus();
            
            return false;
        }
        if(profile==0){
            alert("Enter your profile");
            document.name.profile.focus();
            return false;
        }
        if(uname==0){
            alert("Please Enter Your Name");
            document.name.uname.focus();
            return false;
        }
    }
</script>
</head>
<body>
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="logo">
        <h1><a href="index.html">Attribute Based Encryption on Cloud</a></h1>
      </div>
      <div class="menu_nav">
      </div>
      <div class="clr"></div>
      <div style="position: absolute;left:210px;top: 100px;">
      <h2>Registraion</h2>
      
      <form action="regisdb.jsp" method="post"name="name"  onsubmit="return validate() ">
          <strong>  
          USERNAME:<BR>
                  <input type="text" name="uname" placeholder="Enter Name"></input><br>
         
          PASSWORD:<br> 
          <input type="password" name="password" placeholder="enter password"></input><br> 
         
          CONFIRM PASSWORD:<br>                
          <input type="password" name="cpassword"placeholder="enter confirm password"></input><br>  
         
          PROFILE :<br>
          <input type="text" name="profile"placeholder="enter your profile"></input><br>
              
          LOCATION:<br>
                  <input type="text" name="locat" placeholder="enter your location"></input><br></br>
              
              <input type="submit" value="SUBMIT"></input>   
              </strong>
      </form>
      
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
   

      </div>
      <div class="sidebar">
        <div class="gadget">
         
          <div class="clr"></div>
      
        </div>
      
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="fbg">
    <div class="fbg_resize">
    
     
   
      <div class="clr"></div>
    </div>
  </div>
  <div class="footer">
   
  </div>
</div>
</body>
</html>

