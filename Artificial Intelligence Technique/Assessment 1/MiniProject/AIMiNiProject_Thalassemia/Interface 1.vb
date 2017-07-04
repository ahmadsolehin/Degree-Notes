Public Class Welcome

    Private Sub welcome_bttn_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles welcome_bttn.Click
        If option_user.Text = "Patient" Then
            Talasemia.Show()
            Me.Hide()

        ElseIf option_user.Text = "Doctor" Then
            AdminSignIn.Show()
            Me.Hide()

        Else
            MessageBox.Show("Please choose one of the options below!", " Error Message ", MessageBoxButtons.OK, MessageBoxIcon.Information)
            Return

        End If

    End Sub

    Private Sub Welcome_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load

    End Sub
End Class