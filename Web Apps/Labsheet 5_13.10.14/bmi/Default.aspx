<%@ Page Language="VB" AutoEventWireup="false" CodeFile="Default.aspx.vb" Inherits="_Default" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type ="text/css">
    .container
    {
        
        width:600px;
        margin:0 auto;
        padding :10px;
        border:1px solid black;
        border-top:none;
        font-family :Arial ;
        text-align :justify;
        background :#CCCC33;
        line-height:25px;
    }
    h1,h2
    {
        text-align :center ;
    }
    h2
    {
        color:red ;
    }
    .calculator
    {
        width:300px;
        margin:0 auto;
        padding :10px;
        border:1px dotted red;
    }
    
    </style>
</head>
<body>
    <div class ="container">
    <h1> BMI Calculator</h1>
    <p>BMI is a useful measure of overweight and obesity.
     It is calculated from your height and weight. The higher your BMI,
      the higher your risk for certain diseases such as heart disease,
       high blood pressure, type 2 diabetes, and certain cancers. A person’s weight status can be divided into 
        four categories in terms of BMI: Underweight (below 18.5), Normal (18.5 – 24.9), 
        Overweight (25.0 – 29.9), Obese (30.0 and above). </p>
    <h2>Calculate Your BMI Now!</h2>
    <form id="form1" runat="server">
    <div  class= "calculator">
    
        Your Weight: <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
        <br />
        <asp:RangeValidator ID="RangeValidator1" runat="server" 
            ControlToValidate="TextBox1" ErrorMessage="RangeValidator" MaximumValue="200" 
            MinimumValue="1" Type="Integer">Please select range between 1 - 200</asp:RangeValidator>
        <br />
        Your Height:&nbsp; <asp:TextBox ID="TextBox2" runat="server"></asp:TextBox>
        <br />
        <asp:RangeValidator ID="RangeValidator2" runat="server" 
            ControlToValidate="TextBox2" ErrorMessage="RangeValidator" MaximumValue="10" 
            MinimumValue="1" Type="Double">Please insert range between 1 - 10</asp:RangeValidator>
        <br />
        <asp:Button ID="Button1" runat="server" Text="Calculate" />
        <br />
        <br />
        Your BMI is:
        <asp:Label ID="Label1" runat="server" ForeColor="Blue"></asp:Label>
        <br />
        <br />
        Your status:
        <asp:Label ID="Label2" runat="server" ForeColor="#FF3300"></asp:Label>
    
    </div>
    </form>
    <p>BMI is a useful measure of overweight and obesity.
     It is calculated from your height and weight. BMI is an 
     estimate of body fat and a good gauge of your risk for 
     diseases that can occur with more body fat. The higher your BMI,
      the higher your risk for certain diseases such as heart disease,
       high blood pressure, type 2 diabetes, gallstones, breathing problems,
        and certain cancers.
        </p>
        <hr />
        <p style="text-align:center"><small>2013 &copy; Qin Hongwu, UMP</small></p>
    </div>
</body>
</html>
