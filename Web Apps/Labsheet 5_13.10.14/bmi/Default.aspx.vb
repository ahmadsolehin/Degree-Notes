
Partial Class _Default
    Inherits System.Web.UI.Page

    Protected Sub Button1_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles Button1.Click
        Dim w As Single
        Dim h As Single
        Dim bmi As Single

        w = TextBox1.Text
        h = TextBox2.Text

        bmi = w / (h * h)

        Label1.Text = bmi.ToString()

        If bmi < 18.5 Then
            Label2.Text = "underweight"
        ElseIf bmi < 24.9 Then
            Label2.Text = "normal"
        ElseIf bmi < 29.9 Then
            Label2.Text = "overweight"
        Else
            Label2.Text = "obese"
        End If


    End Sub
End Class
