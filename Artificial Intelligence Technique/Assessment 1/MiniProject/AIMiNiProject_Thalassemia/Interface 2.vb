Public Class Talasemia

    Dim maxRow As Integer
    Dim maxColumn As Integer
    Dim maxRow2 As Integer
    Dim maxColumn2 As Integer


    Private talasemiacasebase(34, 9)
    Dim localsims(40, 13) As Double
    'Dim globalsim(40) As Double
    Dim globalsim(maxRow - 1) As Double
    Private weight(0, 7)
    Dim weight2 As Double = 0
    Dim input(7)
    Dim range(7) As Double
    'Dim localsim(8) As Double


    Private Sub Talasemia_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load


        Dim newconnection As OleDb.OleDbConnection

        newconnection = New OleDb.OleDbConnection("Provider=Microsoft.ACE.OLEDB.12.0;Data Source=TalasemiaProject.accdb;Persist Security Info=False;")

        Try
            'try to open the connection
            Call newconnection.Open()
        Catch ex As Exception
            'MessageBox.Show("Error, check the database.", " Error Message ", MessageBoxButtons.OK, MessageBoxIcon.Information)

        End Try

        If newconnection.State = ConnectionState.Open Then
            'MessageBox.Show("Connection Successfull")

            Dim SQL As New OleDb.OleDbCommand("SELECT * FROM Talasemia", newconnection)
            Dim DataAdapter As New OleDb.OleDbDataAdapter(SQL)
            Dim DataTable As New DataTable("caseBaseTable")
            DataAdapter.Fill(DataTable)
            'DataGridView1.DataSource = DataTable

            For n As Integer = 0 To 33 'numbers of rows of data in database
                For x As Integer = 0 To 9 'numbers of columns of data in database
                    talasemiacasebase(n, x) = DataTable.Rows.Item(n).Item(x)
                    If IsNumeric(talasemiacasebase(n, x)) = True Then
                        'Do nothing
                    Else
                        If talasemiacasebase(n, x) = "Yes" Then
                            talasemiacasebase(n, x) = 1
                        ElseIf talasemiacasebase(n, x) = "No" Then
                            talasemiacasebase(n, x) = 0
                        Else
                            'Do Nothing

                        End If
                    End If
                    maxColumn = DataTable.Columns.Count

                Next
                maxRow = DataTable.Rows.Count
            Next n
        End If

        Label1.Text = maxColumn
        Label6.Text = maxRow

        newconnection.Close()

        importWeight()
    End Sub

    Sub importWeight()
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


            For m As Integer = 0 To 0 'only one row exist
                For y As Integer = 0 To 7 'numbers of columns of data in database
                    weight(m, y) = DataTable2.Rows.Item(m).Item(y)
                    maxColumn2 = DataTable2.Columns.Count

                Next
                maxRow2 = DataTable2.Rows.Count
            Next


        End If

        Label10.Text = maxColumn2
        Label14.Text = maxRow2

        newconnection2.Close()

        'Total Weight
        For w1 = 0 To maxRow2 - 1
            For w2 = 0 To maxColumn2 - 1
                'Calculate total weight 
                weight2 = weight2 + weight(w1, w2)
            Next
        Next

        Label16.Text = weight2

    End Sub
    Sub calculatelocalsim()

        Dim localsim(maxRow) As Double
        Dim globalsim(maxRow) As Double

        input(1) = hb.Text
        input(2) = mcv.Text
        input(3) = mch.Text
        input(4) = mchc.Text
        input(5) = hba2.Text
        input(6) = hbf.Text
        input(7) = pcv.Text

        'For HNC case
        'For i = 1 To 7
        'If IsNumeric(input(i)) = True Then ' convert HNC value to 0 = yes , 1 = no
        'Do nothing
        'Else 'convert yes and no
        'If input(i) = "Yes" Then
        'input(i) = 1
        'ElseIf input(i) = "No" Then
        'input(i) = 0
        'Else
        'do nothing

        'End If
        'End If
        'Next

        range(1) = 16.6 - 4.8
        range(2) = 94.3 - 56.8
        range(3) = 31.8 - 14.4
        range(4) = 35.2 - 25.3
        range(5) = 37.7 - 0.2
        range(6) = 5.1 - 0.2
        range(7) = 51.4 - 18.9

        'calculate the local sims for first 6 columns.

        For k = 0 To maxRow - 1
            Dim global1 As Double = 0
            For j = 1 To 7

                'Missing input handling
                If input(j) = "" Then
                    MessageBox.Show("Please fill in the form.", " Error Message ", MessageBoxButtons.OK, MessageBoxIcon.Information)
                    Return
                    labno.Focus()

                End If
                'Calculate Local Similarities

                'Calculate |a-b|
                localsim(j) = (Math.Abs(input(j) - talasemiacasebase(k, j)))

                'Calculate 1-|a-b|
                localsim(j) = 1 - localsim(j)

                'Calculate 1-|a-b|/ range

                localsim(j) = localsim(j) / range(j)


                localsim(j) = Format(localsim(j), "0.00")

                localsim(j) = localsim(j) * weight(0, j)
                global1 = global1 + localsim(j)

            Next j
            global1 = global1 / weight2
            globalsim(k) = global1

        Next k



        'DETERMINE CLASS 

        'Declaration for sorting
        Dim iFirst As Decimal
        Dim iLast As Decimal
        Dim temp As Double

        'Determine Class
        iFirst = LBound(globalsim)

        For temp = LBound(globalsim) To UBound(globalsim)
            If globalsim(temp) < globalsim(iLast) Then iLast = temp
        Next temp

        Label17.Text = talasemiacasebase(iFirst, maxColumn - 1)

        Label18.Text = (Math.Abs(globalsim(iFirst))) * 100



    End Sub


    Private Sub InstructionToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs)
        Instruction.Show()
    End Sub

    Private Sub AboutToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs)
        About.Show()
    End Sub


    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click


        calculatelocalsim()


        Dim fmtStr As String = "{0,-10}{1,12}"
        output.Items.Clear()
        output.Items.Add("**************************************")
        output.Items.Add("THALASSEMIA BLOOD RESULT")
        output.Items.Add("**************************************")
        output.Items.Add("Here are calculation to conduct accuracy test Thalassemia  ,")
        output.Items.Add("")
        output.Items.Add("")
        output.Items.Add(String.Format(fmtStr, "LabNo:", labno.Text))
        output.Items.Add(String.Format(fmtStr, "Age:", age.Text))
        output.Items.Add(String.Format(fmtStr, "Gender:", gender.Text))
        output.Items.Add("")
        output.Items.Add("Based on LabReport,")
        output.Items.Add("")
        output.Items.Add(String.Format(fmtStr, "Your Thalassemia result :", Label17.Text))
        output.Items.Add("")
        output.Items.Add(String.Format(fmtStr, "With the percentage (%) of similarity towards Medical Cases:", Label18.Text))




    End Sub

    Private Sub ExitToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ExitToolStripMenuItem.Click
        Dim warning As String
        warning = MsgBox("Are you sure to exit the system?", MsgBoxStyle.YesNo, "Exit Sytem")
        If warning = vbYes Then
            End

        End If
    End Sub

    Private Sub MenuToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MenuToolStripMenuItem.Click
        Me.Hide()
        About.Show()
    End Sub

    Private Sub InstructionToolStripMenuItem1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles InstructionToolStripMenuItem1.Click
        Me.Hide()
        Instruction.Show()
    End Sub

    Private Sub output_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles output.SelectedIndexChanged

    End Sub
End Class
