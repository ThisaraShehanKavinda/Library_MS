/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;


import java.awt.geom.RoundRectangle2D;
//import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author PC
 */
public class ManageBooks extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    
    
    String bookName,author;
    int bookID,quantity;
    DefaultTableModel model;
    public ManageBooks() {
        initComponents();
        setBookDetailsIntoTable();
        
        //roundForm
        
        setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),40,40));
        
    }
    
    
    
    //method to clear Table
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel)tblBookDetails.getModel();
        model.setRowCount(0);
    }
    
    
    
    public void setBookDetailsIntoTable(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/library_ms","root","");
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from book_details");
            
            while(rs.next()){
                String bookId = rs.getString("book_ID");
                String bookName1 = rs.getString("book_Name");
                String author1 = rs.getString("author");
                int quantity1 = rs.getInt("quantity");
                
                Object[] obj = {bookId,bookName1,author1,quantity1};
                model =(DefaultTableModel) tblBookDetails.getModel();
                model.addRow(obj);
            }
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
            
    public boolean addBook(){
        
        boolean isAdded = false;
        
        bookID = Integer.parseInt(txtBookID.getText());
        bookName = txtBookName.getText();
        author = txtAutherName.getText();
        quantity = Integer.parseInt(txtQty.getText());
        
        try{
            Connection con = DBconnection.getConnection();
            String sql = "insert into book_details values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1,bookID);
            pst.setString(2, bookName);
            pst.setString(3, author);
            pst.setInt(4,quantity);
            
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
    
    public boolean updateBook(){
        
        boolean isAdded = false;
        bookID = Integer.parseInt(txtBookID.getText());
        bookName = txtBookName.getText();
        author = txtAutherName.getText();
        quantity = Integer.parseInt(txtQty.getText());
        
        try{
            Connection con = DBconnection.getConnection();
            String sql = ("update book_details set book_name = ?,author =?,quantity=? where book_id = ?");
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, bookName);
            pst.setString(2, author);
            pst.setInt(3,quantity);
            pst.setInt(4,bookID);
            
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
    
    public boolean deleteBook(){
        boolean isAdded = false;
        bookID = Integer.parseInt(txtBookID.getText());
        
        try{
            Connection con = DBconnection.getConnection();
            String sql = ("delete from book_details where book_id = ?");
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1,bookID);
            
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
        jLabel8 = new javax.swing.JLabel();
        txtBookID = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        txtBookName = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtAutherName = new app.bolivia.swing.JCTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtQty = new app.bolivia.swing.JCTextField();
        jLabel15 = new javax.swing.JLabel();
        rSMaterialButtonCircle4 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle5 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle7 = new necesario.RSMaterialButtonCircle();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBookDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

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
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 40));

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Enter Book ID");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, -1));

        txtBookID.setBackground(new java.awt.Color(102, 0, 204));
        txtBookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtBookID.setForeground(new java.awt.Color(255, 255, 255));
        txtBookID.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        txtBookID.setPhColor(new java.awt.Color(255, 255, 255));
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
        jPanel1.add(txtBookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 370, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        txtBookName.setBackground(new java.awt.Color(102, 0, 204));
        txtBookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtBookName.setForeground(new java.awt.Color(255, 255, 255));
        txtBookName.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        txtBookName.setPhColor(new java.awt.Color(255, 255, 255));
        txtBookName.setPlaceholder("Enter Book Name");
        txtBookName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBookNameFocusLost(evt);
            }
        });
        txtBookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtBookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 370, -1));

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Enter Book Name");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        txtAutherName.setBackground(new java.awt.Color(102, 0, 204));
        txtAutherName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtAutherName.setForeground(new java.awt.Color(255, 255, 255));
        txtAutherName.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        txtAutherName.setPhColor(new java.awt.Color(255, 255, 255));
        txtAutherName.setPlaceholder("Enter Auther Name");
        txtAutherName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAutherNameFocusLost(evt);
            }
        });
        txtAutherName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAutherNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtAutherName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 370, -1));

        jLabel13.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Auther Name ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));

        txtQty.setBackground(new java.awt.Color(102, 0, 204));
        txtQty.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtQty.setForeground(new java.awt.Color(255, 255, 255));
        txtQty.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        txtQty.setPhColor(new java.awt.Color(255, 255, 255));
        txtQty.setPlaceholder("Enter Quantity");
        txtQty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQtyFocusLost(evt);
            }
        });
        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });
        jPanel1.add(txtQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 370, -1));

        jLabel15.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Quantity");
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

        tblBookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Name", "Auther", "Quantity"
            }
        ));
        tblBookDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tblBookDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tblBookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tblBookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tblBookDetails.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        tblBookDetails.setFuenteFilas(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        tblBookDetails.setFuenteFilasSelect(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        tblBookDetails.setFuenteHead(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        tblBookDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblBookDetails.setRowHeight(23);
        tblBookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBookDetails);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 640, 210));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel3.setText("  MANAGE BOOKS");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 400, 10));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 790, 740));

        setSize(new java.awt.Dimension(1280, 739));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage hp = new HomePage();
        hp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txtBookIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBookIDFocusLost

    }//GEN-LAST:event_txtBookIDFocusLost

    private void txtBookIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookIDActionPerformed

    private void txtBookNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBookNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookNameFocusLost

    private void txtBookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookNameActionPerformed

    private void txtAutherNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAutherNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutherNameFocusLost

    private void txtAutherNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutherNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutherNameActionPerformed

    private void txtQtyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQtyFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtyFocusLost

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtyActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
         if(updateBook() == true){
            JOptionPane.showMessageDialog(this, "Data updated Successfully");
            clearTable();
            setBookDetailsIntoTable();
        }
        else{
            JOptionPane.showMessageDialog(this, "Data update fail");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void rSMaterialButtonCircle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle5ActionPerformed
         if(deleteBook() == true){
            JOptionPane.showMessageDialog(this, "Data deleted Successfully");
            clearTable();
            setBookDetailsIntoTable();
        }
        else{
            JOptionPane.showMessageDialog(this, "Data delete fail");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle5ActionPerformed

    private void rSMaterialButtonCircle7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle7ActionPerformed
        if(addBook() == true){
            JOptionPane.showMessageDialog(this, "Data inserted Successfully");
            clearTable();
            setBookDetailsIntoTable();
        }
        else{
            JOptionPane.showMessageDialog(this, "Data insert fail");
        }
        
    }//GEN-LAST:event_rSMaterialButtonCircle7ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void tblBookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookDetailsMouseClicked
        int rowNo = tblBookDetails.getSelectedRow();
        TableModel model = tblBookDetails.getModel();
        
        txtBookID.setText(model.getValueAt(rowNo,0).toString());
        txtBookName.setText(model.getValueAt(rowNo,1).toString());
        txtAutherName.setText(model.getValueAt(rowNo,2).toString());
        txtQty.setText(model.getValueAt(rowNo,3).toString());
        
        
        
    }//GEN-LAST:event_tblBookDetailsMouseClicked

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
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageBooks().setVisible(true);
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
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle5;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle7;
    private rojeru_san.complementos.RSTableMetro tblBookDetails;
    private app.bolivia.swing.JCTextField txtAutherName;
    private app.bolivia.swing.JCTextField txtBookID;
    private app.bolivia.swing.JCTextField txtBookName;
    private app.bolivia.swing.JCTextField txtQty;
    // End of variables declaration//GEN-END:variables
}
