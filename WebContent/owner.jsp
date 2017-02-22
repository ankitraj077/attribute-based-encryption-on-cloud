<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>owner</title> <!-- changes made in 3rd commit -->
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/arial.js"></script>
<script type="text/javascript" src="js/cuf_run.js"></script>
<script>
function validate(){
    var nfile=document.name.nfile.value;
    var policy=document.name.policy.value;
    var efile=document.name.efile.value;
    
    if(nfile==0){
        alert("Select file");
        document.name.nfile.focus();
        return false;
    }
    
    if(policy==0){
        alert("Enter file policy");
        document.name.policy.focus();
        return false;
    }
    
    if(efile==0)
    	{
    	alert("Enter name of encrypted file");
    	document.name.efile.focus();
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
        <h1><a href="index.html">Attribute Based Encryption on CLoud</a></h1>
        <h2>Hello, <%= session.getAttribute( "uname" ) %></h2>
      </div>
      <div class="menu_nav">
        <ul>
          <li><h2><a href="logoutservlet"><h3>Logout</h3></a></h2></li>
         <!-- 4th commit owner file -->
        </ul>
      </div>
      <div class="clr"></div>
      <div class="htext">
      
        <form action="redirectcloud.jsp" method="post" onsubmit="return validate()">
        <ul>
        <li><h3>File:</h3><input type="file" name="file" /><br/>
        <li><h3>Policy:</h3><input type="text" name="policy" /><br/>
        <li><h3>Encrypted file name:</h3><input type="text" name="efile" /><br/>
       </ul><br/>
       <input type="submit" value="Submit"></input>
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
