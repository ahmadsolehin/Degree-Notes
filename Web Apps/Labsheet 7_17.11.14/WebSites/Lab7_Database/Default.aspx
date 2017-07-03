<%@ Page Language="VB" AutoEventWireup="false" CodeFile="Default.aspx.vb" Inherits="_Default" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        <br />
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" 
            ConnectionString="<%$ ConnectionStrings:ConnectionString %>" 
            DeleteCommand="DELETE FROM [Albums] WHERE [AlbumID] = @AlbumID" 
            InsertCommand="INSERT INTO [Albums] ([AlbumID], [Name], [Artist], [Price], [DatePurchased]) VALUES (@AlbumID, @Name, @Artist, @Price, @DatePurchased)" 
            SelectCommand="SELECT * FROM [Albums] WHERE ([Artist] = @Artist) ORDER BY [Artist]" 
            UpdateCommand="UPDATE [Albums] SET [Name] = @Name, [Artist] = @Artist, [Price] = @Price, [DatePurchased] = @DatePurchased WHERE [AlbumID] = @AlbumID">
            <DeleteParameters>
                <asp:Parameter Name="AlbumID" Type="Int32" />
            </DeleteParameters>
            <InsertParameters>
                <asp:Parameter Name="AlbumID" Type="Int32" />
                <asp:Parameter Name="Name" Type="String" />
                <asp:Parameter Name="Artist" Type="String" />
                <asp:Parameter Name="Price" Type="Decimal" />
                <asp:Parameter DbType="Date" Name="DatePurchased" />
            </InsertParameters>
            <SelectParameters>
                <asp:ControlParameter ControlID="TextBox1" Name="Artist" PropertyName="Text" 
                    Type="String" />
            </SelectParameters>
            <UpdateParameters>
                <asp:Parameter Name="Name" Type="String" />
                <asp:Parameter Name="Artist" Type="String" />
                <asp:Parameter Name="Price" Type="Decimal" />
                <asp:Parameter DbType="Date" Name="DatePurchased" />
                <asp:Parameter Name="AlbumID" Type="Int32" />
            </UpdateParameters>
        </asp:SqlDataSource>
        <br />
        <br />
        <asp:DropDownList ID="DropDownList1" runat="server" 
            DataSourceID="SqlDataSource1" DataTextField="Artist" DataValueField="Artist">
        </asp:DropDownList>
&nbsp;<br />
        <br />
&nbsp;&nbsp;&nbsp; Please input Artist :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
&nbsp;&nbsp;&nbsp;
        <asp:Button ID="Button1" runat="server" Text="Search" />
        <br />
        <br />
        <asp:GridView ID="GridView1" runat="server" AllowPaging="True" 
            AllowSorting="True" AutoGenerateColumns="False" CellPadding="4" 
            DataKeyNames="AlbumID" DataSourceID="SqlDataSource1" ForeColor="#333333" 
            GridLines="None">
            <AlternatingRowStyle BackColor="White" />
            <Columns>
                <asp:CommandField ShowDeleteButton="True" ShowEditButton="True" />
                <asp:BoundField DataField="AlbumID" HeaderText="AlbumID" ReadOnly="True" 
                    SortExpression="AlbumID" />
                <asp:BoundField DataField="Name" HeaderText="Name" SortExpression="Name" />
                <asp:BoundField DataField="Artist" HeaderText="Artist" 
                    SortExpression="Artist" />
                <asp:BoundField DataField="Price" HeaderText="Price" SortExpression="Price" />
                <asp:BoundField DataField="DatePurchased" HeaderText="DatePurchased" 
                    SortExpression="DatePurchased" />
            </Columns>
            <EditRowStyle BackColor="#2461BF" />
            <FooterStyle BackColor="#507CD1" Font-Bold="True" ForeColor="White" />
            <HeaderStyle BackColor="#507CD1" Font-Bold="True" ForeColor="White" />
            <PagerStyle BackColor="#2461BF" ForeColor="White" HorizontalAlign="Center" />
            <RowStyle BackColor="#EFF3FB" />
            <SelectedRowStyle BackColor="#D1DDF1" Font-Bold="True" ForeColor="#333333" />
            <SortedAscendingCellStyle BackColor="#F5F7FB" />
            <SortedAscendingHeaderStyle BackColor="#6D95E1" />
            <SortedDescendingCellStyle BackColor="#E9EBEF" />
            <SortedDescendingHeaderStyle BackColor="#4870BE" />
        </asp:GridView>
        <br />
    
    </div>
    </form>
</body>
</html>
