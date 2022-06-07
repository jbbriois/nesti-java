package FilRouge.View;


import FilRouge.Controlleur.DBLogin;
import FilRouge.Controlleur.DBOrder;
import FilRouge.Model.MArticles;
import FilRouge.Model.MOrder;
import Tools.Validator;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VDetailsCommand extends javax.swing.JFrame {

    JTable jtable;
    JTable order_tracking;
    MArticles article;

    public VDetailsCommand(MArticles article, JTable jtable,JTable order_tracking, int id_user_to) throws SQLException {
        initComponents();
        load_packaging();
        load_unit();
        this.article = article;
        this.jtable = jtable;
        this.order_tracking= order_tracking;
        name_art_tc.setText(article.getName());
        provider_art_tc.setText(article.getProvider());
        origin_art_tc.setText(article.getOrigin());
        String id = String.valueOf(id_user_to);
        id_user.setText(id);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int role = DBLogin.getRoleUser(id_user_to);
        if (role == 3) {
            command_button.setVisible(false);
        }

    }

    public void load_unit() throws SQLException {

        ArrayList<String> unit = new ArrayList<String>();
        unit = DBOrder.GetUnitFromDB();
        for (int i = 0; i < unit.size(); i++) {
            String to_add = unit.get(i);
            unit_choice.add(to_add);
        }
    }

    public void load_packaging() throws SQLException {
        ArrayList<String> packaging = new ArrayList<String>();
        packaging = DBOrder.GetPackagingFromDB();
        for (int i = 0; i < packaging.size(); i++) {
            String to_add = packaging.get(i);
            pack_choice.add(to_add);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        provider_art_tc = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        name_art_tc = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        origin_art_tc = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        quantity_field = new java.awt.TextField();
        pack_choice = new java.awt.Choice();
        unit_choice = new java.awt.Choice();
        jLabel7 = new javax.swing.JLabel();
        price_field = new java.awt.TextField();
        error_command_message = new javax.swing.JLabel();
        command_button = new java.awt.Button();
        id_user = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Origine :");

        provider_art_tc.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Commander :");

        name_art_tc.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("De :");

        origin_art_tc.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        jLabel4.setText("Prix             ");

        jLabel5.setText("Quantité");

        jLabel6.setText("Conditionnement");

        quantity_field.setBackground(new java.awt.Color(51, 51, 51));
        quantity_field.setForeground(new java.awt.Color(204, 204, 204));
        quantity_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantity_fieldActionPerformed(evt);
            }
        });

        pack_choice.setBackground(new java.awt.Color(51, 51, 51));
        pack_choice.setForeground(new java.awt.Color(204, 204, 204));

        unit_choice.setBackground(new java.awt.Color(51, 51, 51));
        unit_choice.setForeground(new java.awt.Color(204, 204, 204));

        jLabel7.setText("Unité de mesure");

        price_field.setBackground(new java.awt.Color(51, 51, 51));
        price_field.setForeground(new java.awt.Color(204, 204, 204));
        price_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                price_fieldActionPerformed(evt);
            }
        });

        command_button.setBackground(new java.awt.Color(51, 51, 51));
        command_button.setForeground(new java.awt.Color(204, 204, 204));
        command_button.setLabel("Passez la commande");
        command_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                command_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name_art_tc, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(provider_art_tc, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(origin_art_tc, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(command_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pack_choice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(unit_choice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quantity_field, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(price_field, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                        .addGap(98, 98, 98)
                        .addComponent(error_command_message, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(id_user)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name_art_tc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(origin_art_tc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(provider_art_tc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantity_field, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pack_choice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(unit_choice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(price_field, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
                    .addComponent(error_command_message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addComponent(command_button, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(id_user)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void price_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_price_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_price_fieldActionPerformed

    private void quantity_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantity_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantity_fieldActionPerformed

    private void command_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_command_buttonActionPerformed

        Validator val = new Validator();
        if ("".equals(quantity_field.getText()) && "".equals(price_field.getText())) {
            String message = "Merci de saisir une quantité et un prix valide";
            VError error = new VError(message);
            error.setVisible(true);
        } else {
            if (val.numericEntry(parseFloat(quantity_field.getText())) && val.numericEntry(parseFloat(price_field.getText()))) {
                MOrder order = new MOrder();
                String to_parse_pack = pack_choice.getSelectedItem();
                String[] id_pack = to_parse_pack.split("-");
                int id_pack_to_db = parseInt(id_pack[0]);
                order.setId_package(id_pack_to_db);
                order.setKind_package(pack_choice.getSelectedItem());
                String to_parse_mesure = unit_choice.getSelectedItem();
                String[] id_mesure = to_parse_mesure.split("-");
                int id_unit_to_db = parseInt(id_mesure[0]);
                order.setId_mesure(id_unit_to_db);
                order.setName_mesure(unit_choice.getSelectedItem());
                order.setQuantity(parseFloat(quantity_field.getText()));
                order.setPrice(parseFloat(price_field.getText()));
                order.setId_user(parseInt(id_user.getText()));
                order.setArticle(article);                
                try {
                    DBOrder.addCommandToDB(order);
                } catch (SQLException ex) {
                    Logger.getLogger(VDetailsCommand.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                String message = "Merci de saisir un nom et une adresse valide";
                VError error = new VError(message);
                error.setVisible(true);
            }
    }//GEN-LAST:event_command_buttonActionPerformed
        try {
            System.out.println("ici");
            load_order_tracking_without_listener();
        } catch (SQLException ex) {
            Logger.getLogger(VDetailsCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void load_order_tracking_without_listener() throws SQLException {
        ArrayList<MOrder> arr = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) order_tracking.getModel();
        model.setRowCount(0);
        order_tracking.setAutoCreateRowSorter(true);
        arr = DBOrder.GetOrdersFromDB();
        DefaultTableModel table = (DefaultTableModel) order_tracking.getModel();
        for (int i = 0; i < arr.size(); i++) {
            MOrder add = new MOrder();
            add = arr.get(i);
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String dateToStr = dateFormat.format(add.getCreation_date());
            String show[] = {String.valueOf(add.getId_order()), add.getArticle().getName(), add.getStatus(), dateToStr};
            table.addRow(show);
        }

    }

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VDetailsCommand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VDetailsCommand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VDetailsCommand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VDetailsCommand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                //   new VDetailsCommand().setVisible(true);
//            }
//        });
//    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button command_button;
    private javax.swing.JLabel error_command_message;
    private javax.swing.JLabel id_user;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel name_art_tc;
    private javax.swing.JLabel origin_art_tc;
    private java.awt.Choice pack_choice;
    private java.awt.TextField price_field;
    private javax.swing.JLabel provider_art_tc;
    private java.awt.TextField quantity_field;
    private java.awt.Choice unit_choice;
    // End of variables declaration//GEN-END:variables
}
