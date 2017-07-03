
Imports System.Data
Partial Class Default2
    Inherits System.Web.UI.Page

    Function display_product() As String
        Dim ds As New DataSet()
        Dim table As New DataTable()
        Dim str As String = ""
        Dim i As Integer
        ds.ReadXml(Server.MapPath("product.xml"))
        table = ds.Tables(0)

        For i = 0 To 8
            If i Mod 3 = 0 Then
                str &= "<div class='empty'></div>"
            End If

            str &= "<div class='product'>"
            str &= "<img src ='image/" & table.Rows(i)(3) & ".jpg'\><br>"
            str &= "<div class ='title'>" & table.Rows(i)(1) & "</div>"
            str &= "<div class ='price'>" & table.Rows(i)(2) & "</div>"
            str &= "<div class ='cartlink'><a href='default2.aspx?title=" & table.Rows(i)(1) & "'> Add to Cart</a></div>"
            str &= "</div>"

        Next

        Return str
    End Function

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load

        If Not (Request.QueryString("title") Is Nothing) Then
            Session.Add("product_" & Request.QueryString("title"), Request.QueryString("title"))
            Label1.Text = "Product <span id='productname'>" & Request.QueryString("title") & "</span> has been added into your cart!"
            'HyperLink1.Visible = True
        End If
    End Sub
End Class
