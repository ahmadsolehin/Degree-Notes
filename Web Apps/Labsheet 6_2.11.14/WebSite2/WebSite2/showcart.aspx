<%@ Page Language="VB" AutoEventWireup="false" CodeFile="showcart.aspx.vb" Inherits="showcart" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type ="text/css" >
        #container, #button
        {
            width:500px;
            margin:0 auto;            
        }
        .left
        {
            width:300px;           
            background-color :Fuchsia ;
        }
        .right
        {
            width:150px;            
        }
        td
        {
            height :30px;
        }
        .dellink
        {
            text-align :center;
        }
               
    </style>
</head>
<body>
    <div id="container">
      <h1>Shopping List</h1>
      <%= display_cart() %>    
    </div>
    <form id="form1" runat="server">
    <div id ="button">   
        <br /> 
        <asp:Button ID="Button1" runat="server" Text="Continue Shopping" />
&nbsp;&nbsp;&nbsp;
        <asp:Button ID="Button2" runat="server" Text="Payment" />
    </div>
    <br />
    
    </form>
</body>
</html>
