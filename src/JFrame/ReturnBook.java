/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class ReturnBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public ReturnBook() {
        initComponents();
        
        
        //roundForm
        
        setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),40,40));
    }
    
    
    
    //return the book
    public boolean returnBook(){
        boolean isReturn = false;
        int bookId = Integer.parseInt(txtBookID.getText());
         int studentId = Integer.parseInt(txtStudentid.getText());
         
         try{
             Connection con = DBconnection.getConnection();
             
             
             String sql = "update issue_book_details set status=? where student_id=? and book_id=? and status=?";
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1,"return");
             pst.setInt(2, studentId);
             pst.setInt(3, bookId);
             pst.setString(4, "pending");
             
            int rowCount = pst.executeUpdate();
             
             if(rowCount>0){
                 isReturn = true;
             }else{
                 isReturn=false;
             }
                     
                     
             
             
             
         }catch(Exception e ){
             e.printStackTrace();
         }
        return isReturn;
    }
    
     public void getIssueBookDetails(){
         
         
         int bookId = Integer.parseInt(txtBookID.getText());
         int studentId = Integer.parseInt(txtStudentid.getText());
         
         try{
             Connection con = DBconnection.getConnection();
             String sql = "select * from issue_book_details where book_id=? and student_id=? and status = ?";
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1, bookId);
             pst.setInt(2, studentId);
             pst.setString(3, "pending");
             
             
             ResultSet rs = pst.executeQuery();
             if(rs.next()){
                 
                 lblIssueId.setText(rs.getString("id"));
                 lblBookName.setText(rs.getString("book_name"));
                 lblStudentName.setText(rs.getString("student_name"));
                 lblIssueDate.setText(rs.getString("issue_date"));
                 lblDueDate.setText(rs.getString("due_date"));
                 lblBookError.setText("");
                 
             }else{
                 lblBookError.setText("No record found");
                 lblIssueId.setText("");
                 lblBookName.setText("");
                 lblStudentName.setText("");
                 lblIssueDate.setText("");
                 lblDueDate.setText("");
                
                 
             }
             
             

         }catch(Exception e){
             e.printStackTrace();
         }
         
         
     }
    
   

    
   
    
    public void updateBookCount(){
        int bookId = Integer.parseInt(txtBookID.getText());
        try{
            Connection con = DBconnection.getConnection();
            String sql = "update book_details set quantity=quantity+1 where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            
            int rowCount  =  pst.executeUpdate();
           
           if(rowCount>0){
               JOptionPane.showMessageDialog(this, "Book count Updated");
               lblIssueId.setText("");
                 lblBookName.setText("");
                 lblStudentName.setText("");
                 lblIssueDate.setText("");
                 lblDueDate.setText("");
                
                }else{
              JOptionPane.showMessageDialog(this, "Cannot Update Book Count");
               
           }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblIssueId = new javax.swing.JLabel();
        lblBookName = new javax.swing.JLabel();
        lblStudentName = new javax.swing.JLabel();
        lblDueDate = new javax.swing.JLabel();
        lblBookError = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblIssueDate = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtBookID = new app.bolivia.swing.JCTextField();
        txtStudentid = new app.bolivia.swing.JCTextField();
        jLabel18 = new javax.swing.JLabel();
        rSMaterialButtonCircle7 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle8 = new necesario.RSMaterialButtonCircle();
        jPanel8 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 0, 102));
        setMinimumSize(new java.awt.Dimension(1280, 740));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1280, 740));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 340, 4));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel5.setText("  BOOK DETAILS");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 260, -1));

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Due Date :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, -1, -1));

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Book  Name :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Student Name :");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        lblIssueId.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblIssueId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lblIssueId, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 200, 20));

        lblBookName.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblBookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lblBookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 200, 20));

        lblStudentName.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblStudentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lblStudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 200, 20));

        lblDueDate.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblDueDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lblDueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 560, 200, 20));

        lblBookError.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblBookError.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lblBookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 580, 200, 20));

        jLabel13.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Issue Date :");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, -1, -1));

        lblIssueDate.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblIssueDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lblIssueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, 200, 20));

        jLabel14.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Issue ID :");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 390, 750));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JFrame/close.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 30, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JFrame/close.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 20, 30));

        jPanel7.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 340, 4));

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel7.setText("   RETURN BOOK");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 310, -1));

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("Book ID :");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        txtBookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txtBookID.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        txtBookID.setPhColor(new java.awt.Color(102, 102, 102));
        txtBookID.setPlaceholder("Enter Book ID");
        txtBookID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBookIDFocusLost(evt);
            }
        });
        txtBookID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookIDActionPerformed(evt);
            }
        });
        jPanel3.add(txtBookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 240, -1));

        txtStudentid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txtStudentid.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        txtStudentid.setPhColor(new java.awt.Color(102, 102, 102));
        txtStudentid.setPlaceholder("Enter Student ID");
        txtStudentid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStudentidFocusLost(evt);
            }
        });
        txtStudentid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentidActionPerformed(evt);
            }
        });
        jPanel3.add(txtStudentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 240, -1));

        jLabel18.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 51));
        jLabel18.setText("Student ID :");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        rSMaterialButtonCircle7.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle7.setText("Return Book");
        rSMaterialButtonCircle7.setFont(new java.awt.Font("Roboto Medium", 1, 17)); // NOI18N
        rSMaterialButtonCircle7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle7MouseClicked(evt);
            }
        });
        rSMaterialButtonCircle7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle7ActionPerformed(evt);
            }
        });
        jPanel3.add(rSMaterialButtonCircle7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, 220, 60));

        rSMaterialButtonCircle8.setBackground(new java.awt.Color(102, 102, 255));
        rSMaterialButtonCircle8.setText(" Find");
        rSMaterialButtonCircle8.setFont(new java.awt.Font("Roboto Medium", 1, 17)); // NOI18N
        rSMaterialButtonCircle8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle8MouseClicked(evt);
            }
        });
        rSMaterialButtonCircle8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle8ActionPerformed(evt);
            }
        });
        jPanel3.add(rSMaterialButtonCircle8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 220, 60));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 450, 760));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.setForeground(new java.awt.Color(255, 0, 0));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/library-2.png"))); // NOI18N
        jLabel9.setText("Issue ID :");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 350, Short.MAX_VALUE))
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 760));

        setSize(new java.awt.Dimension(1264, 701));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage hp = new HomePage();
        hp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void txtBookIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBookIDFocusLost
       
        
        
        
       
    }//GEN-LAST:event_txtBookIDFocusLost

    private void txtBookIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookIDActionPerformed

    private void txtStudentidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStudentidFocusLost
      
    }//GEN-LAST:event_txtStudentidFocusLost

    private void txtStudentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentidActionPerformed

    private void rSMaterialButtonCircle7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle7ActionPerformed
if(returnBook()==true){
    JOptionPane.showMessageDialog(this, "Book return successfully");
    updateBookCount();
}    else{
    JOptionPane.showMessageDialog(this, "Book return fail");
    
}
       
        
        
        
        
        
        
        
      

    }//GEN-LAST:event_rSMaterialButtonCircle7ActionPerformed

    private void rSMaterialButtonCircle7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle7MouseClicked

    private void rSMaterialButtonCircle8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle8MouseClicked

    private void rSMaterialButtonCircle8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle8ActionPerformed
        getIssueBookDetails();
    }//GEN-LAST:event_rSMaterialButtonCircle8ActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblBookError;
    private javax.swing.JLabel lblBookName;
    private javax.swing.JLabel lblDueDate;
    private javax.swing.JLabel lblIssueDate;
    private javax.swing.JLabel lblIssueId;
    private javax.swing.JLabel lblStudentName;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle7;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle8;
    private app.bolivia.swing.JCTextField txtBookID;
    private app.bolivia.swing.JCTextField txtStudentid;
    // End of variables declaration//GEN-END:variables
}
