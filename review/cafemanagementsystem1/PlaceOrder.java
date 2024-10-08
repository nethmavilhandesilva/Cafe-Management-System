/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cafemanagementsystem1;

import Common.OpenPdf;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dao.BillDao;
import dao.CategoryDao;
import dao.ProductDao;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Bill;
import model.Category;
import model.Product;

/**
 *
 * @author Sadini Kavindya
 */
public class PlaceOrder extends javax.swing.JFrame {
    public int billId=1;
    public int grandTotal=0;
    public int productPrice=0;
    public int productTotal=0;
    public String emailPattern="^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    public String mobileNumberPattern="^[0-9]*$";
    public String userEmail;

    /**
     * Creates new form PlaceOrder
     */
    public PlaceOrder() {
        initComponents();
    }
     public PlaceOrder(String email) {
        initComponents();
        txtProductName.setEditable(false);
        txtProductPrice.setEditable(false);
        txtProductTotal.setEditable(false);
        btnAddToCart.setEnabled(false);
        btnGenarateBill.setEnabled(false);
        JFormattedTextField tf=((JSpinner.DefaultEditor)jSpinner1.getEditor()).getTextField();
        tf.setEditable(false);
        userEmail=email;
        
    }
    public void productNameByCategory(String category){
        DefaultTableModel dtm=(DefaultTableModel)jTable1.getModel();
        ArrayList<Product>list=ProductDao.getAllRecordsByCategory(category);
        Iterator<Product>itr=list.iterator();
        while(itr.hasNext()){
            Product productObj=itr.next();
            dtm.addRow(new Object[]{productObj.getName()});
        }
    }
        public void filterProductByName(String name,String category){
        DefaultTableModel dtm=(DefaultTableModel)jTable1.getModel();
        ArrayList<Product>list=ProductDao.filterProductByName(name,category);
        Iterator<Product>itr=list.iterator();
        while(itr.hasNext()){
            Product productObj=itr.next();
            dtm.addRow(new Object[]{productObj.getName()});
        }
    } 
        public void clearProductFields(){
            txtProductName.setText("");
            txtProductPrice.setText("");
            jSpinner1.setValue(1);
            txtProductTotal.setText("");
            btnAddToCart.setEnabled(false);
        }
        public void validateFields(){
         String customerNme=txtCustomerName.getText();
         String customerMobileNumber=txtMobileNumber.getText();
         String customerEmail=txtEmail.getText();
         if(!customerEmail.equals("")&&customerMobileNumber.matches(mobileNumberPattern)&&customerMobileNumber.length()==10&&customerEmail.matches(emailPattern)&&grandTotal>0){
             btnGenarateBill.setEnabled(true);
         }
         else{
             btnGenarateBill.setEnabled(false);
         }
        }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMobileNumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbCategory = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtProductPrice = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtProductTotal = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        btnAddToCart = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnGenarateBill = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/place order.png"))); // NOI18N
        jLabel1.setText("Place Order");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 6, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1334, 6, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Bill ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 70, -1, -1));

        jLabel3.setText("//");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 73, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Customer Details");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 105, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        txtCustomerName.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        txtCustomerName.setForeground(new java.awt.Color(0, 0, 0));
        txtCustomerName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCustomerNameKeyReleased(evt);
            }
        });
        getContentPane().add(txtCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 250, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Mobile Number");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        txtMobileNumber.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        txtMobileNumber.setForeground(new java.awt.Color(0, 0, 0));
        txtMobileNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMobileNumberKeyReleased(evt);
            }
        });
        getContentPane().add(txtMobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 250, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Email");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 0, 0));
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 250, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Category");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 70, -1, -1));

        cmbCategory.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        cmbCategory.setForeground(new java.awt.Color(0, 0, 0));
        cmbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoryActionPerformed(evt);
            }
        });
        getContentPane().add(cmbCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 102, 250, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Search");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 140, -1, -1));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(0, 0, 0));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 178, 250, -1));

        jTable1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 210, 250, 365));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Name");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 70, -1, -1));

        txtProductName.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        txtProductName.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 102, 250, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Price");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1035, 70, -1, -1));

        txtProductPrice.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        txtProductPrice.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtProductPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1035, 102, 248, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Quantity");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 140, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Total");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1035, 140, -1, -1));

        txtProductTotal.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        txtProductTotal.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtProductTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1035, 178, 248, -1));

        btnClear.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(0, 0, 0));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear_1.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 229, -1, -1));

        btnAddToCart.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnAddToCart.setForeground(new java.awt.Color(0, 0, 0));
        btnAddToCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add to cart.png"))); // NOI18N
        btnAddToCart.setText("Add To Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddToCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1151, 229, -1, -1));

        jTable2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jTable2.setForeground(new java.awt.Color(0, 0, 0));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price", "Quantity", "Total"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 274, 528, 301));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Grand Total Rs.");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 600, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("00");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(873, 600, -1, -1));

        btnGenarateBill.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnGenarateBill.setForeground(new java.awt.Color(0, 0, 0));
        btnGenarateBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/generate bill & print.png"))); // NOI18N
        btnGenarateBill.setText("Generate Bill And Print");
        btnGenarateBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenarateBillActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenarateBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1072, 600, -1, -1));

        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        getContentPane().add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, 250, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/full-page-background.PNG"))); // NOI18N
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        new Home(userEmail).setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
    billId=Integer.parseInt(BillDao.getId());
    jLabel3.setText(BillDao.getId());
    ArrayList<Category>list=CategoryDao.getAllRecords();
    Iterator<Category>itr=list.iterator();
    while(itr.hasNext()){
        Category categoryObj=itr.next();
        cmbCategory.addItem(categoryObj.getName());
    }
    String category=(String)cmbCategory.getSelectedItem();
        productNameByCategory(category);
    }//GEN-LAST:event_formComponentShown

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
    String name=txtSearch.getText();
    String category=(String)cmbCategory.getSelectedItem();
    filterProductByName(name, category);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    int index=jTable1.getSelectedRow();
    TableModel model=jTable1.getModel();
    String ProductName=model.getValueAt(index,0).toString();
    Product product=ProductDao.getProductByname(ProductName);
     txtProductName.setText(product.getName());
     txtProductPrice.setText(product.getPrice());
     jSpinner1.setValue(1);
     txtProductTotal.setText(product.getPrice());
     productPrice=Integer.parseInt(product.getPrice());
     productTotal=Integer.parseInt(product.getPrice());
     btnAddToCart.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
    int quantity=(Integer)jSpinner1.getValue();
    if(quantity<=1){
        jSpinner1.setValue(1);
        quantity=1;
    }
    productTotal=productPrice*quantity;
    txtProductTotal.setText(String.valueOf(productTotal));
    }//GEN-LAST:event_jSpinner1StateChanged

    private void cmbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoryActionPerformed
    String category=(String)cmbCategory.getSelectedItem();
        productNameByCategory(category);
    }//GEN-LAST:event_cmbCategoryActionPerformed

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
    String name=txtProductName.getText();
    String price=txtProductPrice.getText();
    String quantity=String.valueOf(jSpinner1.getValue());
    DefaultTableModel dtm=(DefaultTableModel)jTable2.getModel();
    dtm.addRow(new Object[]{name,price,quantity,productTotal});
    grandTotal=grandTotal+productTotal;
    jLabel15.setText(String.valueOf(grandTotal));
   
     clearProductFields();
     validateFields();
    

    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
    clearProductFields();   
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtCustomerNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerNameKeyReleased
    validateFields();
    }//GEN-LAST:event_txtCustomerNameKeyReleased

    private void txtMobileNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMobileNumberKeyReleased
    validateFields();    
    }//GEN-LAST:event_txtMobileNumberKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
    validateFields();
    }//GEN-LAST:event_txtEmailKeyReleased

    private void btnGenarateBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenarateBillActionPerformed
    String customerName=txtCustomerName.getText();
    String customerMobileNumber=txtMobileNumber.getText();
    String customerEmail=txtEmail.getText();
    SimpleDateFormat dFormat=new SimpleDateFormat("dd-MM-yyyy");
    Date date=new Date();
    String todaydate=dFormat.format(date);
    String total=String.valueOf(grandTotal);
    String createdBy=userEmail;
    Bill bill=new Bill();
    bill.setId(billId);
    bill.setName(customerName);
    bill.setMobileNumber(customerMobileNumber);
    bill.setEmail(customerEmail);
    bill.setDate(todaydate);
    bill.setTotal(total);
    bill.setCreatedBy(createdBy);
    BillDao.save(bill);
    //Create Doc
    String path="C:\\Users\\Sadini Kavindya\\Desktop\\NVDS CODING" ;
    com.itextpdf.text.Document doc=new com.itextpdf.text.Document();
    try{
        PdfWriter.getInstance(doc,new FileOutputStream(path+""+billId+".pdf"));
        doc.open();
        Paragraph cafeName=new Paragraph("                                                         Cafe Management System\\n");
        doc.add(cafeName);
        Paragraph starLine=new Paragraph("*********************************************************************************************************");
        doc.add(starLine);
        Paragraph paragraph3=new Paragraph("\tBill ID:"+billId+"\nCustomer Name:"+customerName+"\nTotal Paid:"+grandTotal);
        doc.add(paragraph3);
        doc.add(starLine);
        PdfPTable tb1=new PdfPTable(4);
        tb1.addCell("Name");
        tb1.addCell("Price");
        tb1.addCell("Quantity");
        tb1.addCell("Total");
        for(int i=0;i<jTable2.getRowCount();i++){
            String n=jTable2.getValueAt(i,0).toString();
            String d=jTable2.getValueAt(i,1).toString();
            String r=jTable2.getValueAt(i,2).toString();
            String q=jTable2.getValueAt(i,3).toString();
            tb1.addCell(n);
            tb1.addCell(d);
            tb1.addCell(r);
            tb1.addCell(q);
        }
        doc.add(tb1);
        doc.add(starLine);
        Paragraph thanksMsg=new Paragraph("Thank You.Please Visit Again(NVDS SOLUTIONS)");
        doc.add(thanksMsg);
        //open pdf
        OpenPdf.OpenById(String.valueOf(billId));
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }
    doc.close();
    setVisible(false);
    new PlaceOrder(createdBy).setVisible(true);
    
    }//GEN-LAST:event_btnGenarateBillActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
    int index=jTable2.getSelectedRow();
    int a=JOptionPane.showConfirmDialog(null,"Do You Wnat To Remove This Product","Select",JOptionPane.YES_NO_OPTION);
    if(a==0){
        TableModel model=jTable2.getModel();
        String total=model.getValueAt(index,3).toString();
        grandTotal=grandTotal-Integer.parseInt(total);
        jLabel15.setText(String.valueOf(grandTotal));
        ((DefaultTableModel)jTable2.getModel()).removeRow(index);
        
    }
    }//GEN-LAST:event_jTable2MouseClicked

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
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlaceOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnGenarateBill;
    private javax.swing.JComboBox<String> cmbCategory;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMobileNumber;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductPrice;
    private javax.swing.JTextField txtProductTotal;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
//Exception in thread "AWT-EventQueue-0" java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because "this.email" is null