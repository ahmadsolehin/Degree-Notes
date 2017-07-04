Public Class AdminWeight
    'Dim weight_modify(7) As Double
    Dim input_Weight(7) As Double
    Dim weight As String
    Dim SQL2 As String

    Private Sub AdminWeight_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load


        'Talasemia.importWeight()

        input_Weight(0) = hbW.Text
        input_Weight(1) = mcvW.Text
        input_Weight(2) = mchW.Text
        input_Weight(3) = mchcW.Text
        input_Weight(4) = hba2W.Text
        input_Weight(5) = hbfW.Text
        input_Weight(6) = pcvW.Text


        
    End Sub

    Sub Import_Weight()

        Dim newconnection2 As OleDb.OleDbConnection

        newconnection2 = New OleDb.OleDbConnection("Provider=Microsoft.ACE.OLEDB.12.0;Data Source=TalasemiaProject.accdb;Persist Security Info=False;")

        Try
            'try to open the connection
            Call newconnection2.Open()
        Catch ex As Exception
            MessageBox.Show("Error, check the database.", " Error Message ", MessageBoxButtons.OK, MessageBoxIcon.Information)

        End Try

        If newconnection2.State = ConnectionState.Open Then
            'MessageBox.Show("Connection Successfull")

            Dim SQL2 As New OleDb.OleDbCommand("SELECT * FROM AdminWeight", newconnection2)
            Dim DataAdapter As New OleDb.OleDbDataAdapter(SQL2)
            Dim DataTable2 As New DataTable("Weight")
            DataAdapter.Fill(DataTable2)
            'DataGridView1.DataSource = DataTable

            weight = DataTable2.Rows(0).Item("ID")
            input_Weight(0) = DataTable2.Rows(0).Item("Hb")
            input_Weight(1) = DataTable2.Rows(0).Item("MCV")
            input_Weight(2) = DataTable2.Rows(0).Item("MCH")
            input_Weight(3) = DataTable2.Rows(0).Item("MCHC")
            input_Weight(4) = DataTable2.Rows(0).Item("HBA2")
            input_Weight(5) = DataTable2.Rows(0).Item("HBF")
            input_Weight(6) = DataTable2.Rows(0).Item("PCV")


            

           

        End If
    End Sub

    
    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        
        SQL2 = "Update ThalassemiaWeight set Hb='" & input_Weight(0) & "',MCV='" & input_Weight(1) & "',MCH='" & input_Weight(2) & "',MCHC='" & input_Weight(3) & "',HBA2='" & input_Weight(4) & "',HBF='" & input_Weight(5) & "',PCV='" & input_Weight(6) & "', where ID='" & weight & "'"
        Import_Weight()
        Dim alert As String
        alert = MsgBox("Success Save Your Data, do you want to RETURN to Main?", MsgBoxStyle.YesNo, "DONE!")
        If alert = vbYes Then
            Me.Hide()
            Welcome.Show()
        ElseIf alert = vbNo Then
            Talasemia.Show()
            Me.Hide()

        End If

    End Sub

    Private Sub LogoutToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles LogoutToolStripMenuItem.Click
        Dim warning As String
        warning = MsgBox("Are you sure to logout?", MsgBoxStyle.YesNo, "LOGOUT")
        If warning = vbYes Then
            Me.Hide()
            Welcome.Show()

        End If
    End Sub
End Class