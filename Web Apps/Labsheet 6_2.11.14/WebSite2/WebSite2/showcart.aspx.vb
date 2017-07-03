
Partial Class showcart
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load

        'If (Not IsPostBack) Then
        'ViewState("PreUrl") = Request.UrlReferrer.ToString()
        'End If
       
    End Sub

    Function display_cart() As String
        Dim cnt As Integer
        Dim i As Integer
        Dim str As String = ""

        If Not (Request.QueryString("index") Is Nothing) Then
            Session.RemoveAt(CType(Request.QueryString("index"), Integer))
        End If

        cnt = Session.Count
        If cnt = 0 Then
            str &= "You have not purchased any product yet!"
        End If

        If cnt > 0 Then
            str &= "<table border=1>"
            str &= "<colgroup><col class ='left' /> <col class = 'right' /> </colgroup>"
            For i = 0 To cnt - 1
                str &= "<tr>"
                str &= "<td>" & Session.Item(i).ToString() & "</td><td class ='dellink'><a href='showcart.aspx?index=" & i & "'>Del</a></td>"
                str &= "</tr>"
            Next
            str &= "</table>"
        End If
        Return str
    End Function

    Protected Sub Button1_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles Button1.Click

        'Dim preurl As Object = ViewState("PreUrl")
        'If Not (preurl Is Nothing) Then
        'Response.Redirect(CStr(preurl))
        'End If
        Response.Redirect("Default2.aspx")
    End Sub

    
End Class
