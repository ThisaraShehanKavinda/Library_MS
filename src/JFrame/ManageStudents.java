/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;


import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author PC
 */
public class ManageStudents extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    
    
    String studentName,course,branch;
    int studentID;
    DefaultTableModel model;
    public ManageStudents() {
        initComponents();
        setStudentDetailsIntoTable();
        
        
        //roundForm
        
        setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),40,40));
        
    }
    
    
    
    //method to clear Table
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel)tblStudentDetails.getModel();
        model.setRowCount(0);
    }
    
    
    
    public void setStudentDetailsIntoTable(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/library_ms","root","");
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student_details");
            
            while(rs.next()){
                String studentId = rs.getString("student_ID");
                String studentName1 = rs.getString("name");
                String course1 = rs.getString("course");
                String branch1 = rs.getString("branch");
                
                Object[] obj = {studentId,studentName1,course1,branch1};
                model =(DefaultTableModel) tblStudentDetails.getModel();
                model.addRow(obj);
            }
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
            
    public boolean addStudent(){
        
        boolean isAdded = false;
        
        studentID = Integer.parseInt(txtStudentID.getText());
        studentName = txtStudentName.getText();
        course = cmbCourseName.getSelectedItem().toString();
        branch = cmbBranch.getSelectedItem().toString();
        
        try{
            Connection con = DBconnection.getConnection();
            String sql = "insert into student_details values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1,studentID);
            pst.setString(2, studentName);
            pst.setString(3, course);
            pst.setString(4,branch);
            
            int rowCount = pst.executeUpdate();
            
            if(rowCount>0){
                isAdded = true;
            }
            else{
                isAdded =false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return isAdded;
    }
    
    public boolean updateStudent(){
        
        boolean isAdded = false;
        studentID = Integer.parseInt(txtStudentID.getText());
        studentName = txtStudentName.getText();
        course = cmbCourseName.getSelectedItem().toString();
        branch = cmbBranch.getSelectedItem().toString();
        
        try{
            Connection con = DBconnection.getConnection();
            String sql = ("update student_details set name = ?,course =?,branch=? where student_id = ?");
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, studentName);
            pst.setString(2, course);
            pst.setString(3,branch);
            pst.setInt(4,studentID);
            
            int rowCount = pst.executeUpdate();
            
            if(rowCount>0){
                isAdded = true;
            }
            else{
                isAdded =false;
            }
            
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return isAdded;
    }
    
    public boolean deleteStudent(){
        boolean isAdded = false;
        studentID = Integer.parseInt(txtStudentID.getText());
        
        try{
            Connection con = DBconnection.getConnection();
            String sql = ("delete from student_details where student_id = ?");
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1,studentID);
            
            int rowCount = pst.executeUpdate();
            
            if(rowCount>0){
                isAdded = true;
            }
            else{
                isAdded =false;
            }
            
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return isAdded;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtStudentID = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        txtStudentName = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        rSMaterialButtonCircle4 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle5 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle7 = new necesario.RSMaterialButtonCircle();
        cmbBranch = new javax.swing.JComboBox<>();
        cmbCourseName = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStudentDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setForeground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setForeground(new java.awt.Color(255, 0, 0));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 40));

        txtStudentID.setBackground(new java.awt.Color(102, 0, 204));
        txtStudentID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtStudentID.setForeground(new java.awt.Color(255, 255, 255));
        txtStudentID.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        txtStudentID.setPhColor(new java.awt.Color(255, 255, 255));
        txtStudentID.setPlaceholder("Enter Student ID");
        txtStudentID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStudentIDFocusLost(evt);
            }
        });
        txtStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIDActionPerformed(evt);
            }
        });
        jPanel1.add(txtStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 370, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        txtStudentName.setBackground(new java.awt.Color(102, 0, 204));
        txtStudentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtStudentName.setForeground(new java.awt.Color(255, 255, 255));
        txtStudentName.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        txtStudentName.setPhColor(new java.awt.Color(255, 255, 255));
        txtStudentName.setPlaceholder("Enter Student Name");
        txtStudentName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStudentNameFocusLost(evt);
            }
        });
        txtStudentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtStudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 370, -1));

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Enter Student Name");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        jLabel13.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Course Name ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));

        jLabel15.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Branch");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, -1, -1));

        rSMaterialButtonCircle4.setBackground(new java.awt.Color(0, 0, 102));
        rSMaterialButtonCircle4.setText("Update");
        rSMaterialButtonCircle4.setFont(new java.awt.Font("Roboto Medium", 1, 17)); // NOI18N
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 580, 190, 60));

        rSMaterialButtonCircle5.setBackground(new java.awt.Color(153, 0, 0));
        rSMaterialButtonCircle5.setText("Delete");
        rSMaterialButtonCircle5.setFont(new java.awt.Font("Roboto Medium", 1, 17)); // NOI18N
        rSMaterialButtonCircle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle5ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 650, 190, 60));

        rSMaterialButtonCircle7.setBackground(new java.awt.Color(0, 102, 0));
        rSMaterialButtonCircle7.setText("Add");
        rSMaterialButtonCircle7.setFont(new java.awt.Font("Roboto Medium", 1, 17)); // NOI18N
        rSMaterialButtonCircle7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle7ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, 190, 60));

        cmbBranch.setBackground(new java.awt.Color(102, 0, 204));
        cmbBranch.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        cmbBranch.setForeground(new java.awt.Color(255, 255, 255));
        cmbBranch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CS", "IT", "PLAIN", "ELECTRONICS" }));
        jPanel1.add(cmbBranch, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 370, 40));

        cmbCourseName.setBackground(new java.awt.Color(102, 0, 204));
        cmbCourseName.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        cmbCourseName.setForeground(new java.awt.Color(255, 255, 255));
        cmbCourseName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSC", "MSC", "PHD" }));
        jPanel1.add(cmbCourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 370, 40));

        jLabel16.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Enter Student ID");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 740));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JFrame/close.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 30, 30));

        tblStudentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Course", "Branch"
            }
        ));
        tblStudentDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tblStudentDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tblStudentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tblStudentDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tblStudentDetails.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        tblStudentDetails.setFuenteFilas(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        tblStudentDetails.setFuenteFilasSelect(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        tblStudentDetails.setFuenteHead(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        tblStudentDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblStudentDetails.setRowHeight(23);
        tblStudentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblStudentDetails);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 640, 210));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel3.setText("  MANAGE STUDENTS");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, 100));

        jPanel4.setBackground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 510, 10));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JFrame/close.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 30, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 790, 740));

        setSize(new java.awt.Dimension(1280, 739));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage hp = new HomePage();
        hp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txtStudentIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStudentIDFocusLost

    }//GEN-LAST:event_txtStudentIDFocusLost

    private void txtStudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentIDActionPerformed

    private void txtStudentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStudentNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentNameFocusLost

    private void txtStudentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentNameActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
         if(updateStudent() == true){
            JOptionPane.showMessageDialog(this, "Data updated Successfully");
            clearTable();
            setStudentDetailsIntoTable();
        }
        else{
            JOptionPane.showMessageDialog(this, "Data update fail");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void rSMaterialButtonCircle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle5ActionPerformed
         if(deleteStudent() == true){
            JOptionPane.showMessageDialog(this, "Data deleted Successfully");
            clearTable();
            setStudentDetailsIntoTable();
        }
        else{
            JOptionPane.showMessageDialog(this, "Data delete fail");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle5ActionPerformed

    private void rSMaterialButtonCircle7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle7ActionPerformed
        if(addStudent() == true){
            JOptionPane.showMessageDialog(this, "Data inserted Successfully");
            clearTable();
            setStudentDetailsIntoTable();
        }
        else{
            JOptionPane.showMessageDialog(this, "Data insert fail");
        }
        
    }//GEN-LAST:event_rSMaterialButtonCircle7ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void tblStudentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentDetailsMouseClicked
        int rowNo = tblStudentDetails.getSelectedRow();
        TableModel model = tblStudentDetails.getModel();
        
        txtStudentID.setText(model.getValueAt(rowNo,0).toString());
        txtStudentName.setText(model.getValueAt(rowNo,1).toString());
        cmbCourseName.setSelectedItem(model.getValueAt(rowNo,2).toString());
        cmbBranch.setSelectedItem(model.getValueAt(rowNo,3).toString());
        
        
        
    }//GEN-LAST:event_tblStudentDetailsMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbBranch;
    private javax.swing.JComboBox<String> cmbCourseName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle5;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle7;
    private rojeru_san.complementos.RSTableMetro tblStudentDetails;
    private app.bolivia.swing.JCTextField txtStudentID;
    private app.bolivia.swing.JCTextField txtStudentName;
    // End of variables declaration//GEN-END:variables
}
