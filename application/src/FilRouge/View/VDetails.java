package FilRouge.View;

import FilRouge.Controlleur.DBArticle;
import FilRouge.Controlleur.DBLogin;
import FilRouge.Controlleur.DBProvider;
import FilRouge.Model.MArticles;
import Tools.Validator;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VDetails extends javax.swing.JFrame {

    JTable jtable;
    JTable command_table;

    public VDetails(MArticles article, JTable jtable, JTable command_table, int id_user) {
        this.jtable = jtable;
        this.command_table = command_table;
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        id_article_details.setText(String.valueOf(article.getId()));
        product_name_details.setText(article.getName());
        brand_details.setText(article.getBrand());
        product_created_at_details.setText(article.getCreation_date().toString());
        disponibility_details.add(article.getStatus_article());
        provider_details.add(DBProvider.getProvidersByIdFromDB(DBProvider.getProvidersIdByIdArticleFromDB(article.getId())));
        created_by_details.setText(DBLogin.getUser(article.getId_user()));
        origin_details.add(DBArticle.getOriginByIdArticleFromDB(article.getId()));
        if (DBArticle.chekIfToolOrIngredientFromDB(article.getId()) == 1) {
            type_details.add("Ingrédient");
        } else {
            type_details.add("Ustensile");
        }
        ini_v_details();
        int role = DBLogin.getRoleUser(id_user);

        if (role == 3) {
            modify.setVisible(false);
            delete.setVisible(false);
        }

    }

    public void load_article_search(ArrayList<MArticles> arr, JTable jtable) {

        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        model.setRowCount(0);
        jtable.setAutoCreateRowSorter(true);
        DefaultTableModel table = (DefaultTableModel) jtable.getModel();
        for (int i = 0; i < arr.size(); i++) {
            MArticles add = new MArticles();
            add = arr.get(i);
            String show[] = {add.getName(), add.getBrand(), DBProvider.getProvidersByIdFromDB(DBProvider.getProvidersIdByIdArticleFromDB(add.getId())), DBArticle.getOriginByIdArticleFromDB(add.getId()), add.getStatus_article()};
            table.addRow(show);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        product_name_details = new java.awt.TextField();
        brand_details = new java.awt.TextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        product_created_at_details = new java.awt.TextField();
        created_by_details = new java.awt.TextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        modify = new javax.swing.JButton();
        message = new javax.swing.JLabel();
        id_article_details = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        type_details = new java.awt.Choice();
        provider_details = new java.awt.Choice();
        disponibility_details = new java.awt.Choice();
        origin_details = new java.awt.Choice();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel1.setText("Détails de l'article");

        jLabel2.setText("Marque");

        jLabel3.setText("Nom ");

        jLabel4.setText("Fournisseur");

        product_name_details.setBackground(new java.awt.Color(51, 51, 51));
        product_name_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_name_detailsActionPerformed(evt);
            }
        });

        brand_details.setBackground(new java.awt.Color(51, 51, 51));
        brand_details.setEditable(false);
        brand_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brand_detailsActionPerformed(evt);
            }
        });

        jLabel5.setText("Par");

        jLabel6.setText("Date de création");

        product_created_at_details.setBackground(new java.awt.Color(51, 51, 51));
        product_created_at_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_created_at_detailsActionPerformed(evt);
            }
        });

        created_by_details.setBackground(new java.awt.Color(51, 51, 51));
        created_by_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                created_by_detailsActionPerformed(evt);
            }
        });

        jLabel7.setText("Origine");

        jLabel8.setText("Disponibilité ");

        jLabel9.setText("Type");

        delete.setBackground(new java.awt.Color(51, 51, 51));
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Supprimer");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        modify.setBackground(new java.awt.Color(51, 51, 51));
        modify.setForeground(new java.awt.Color(255, 255, 255));
        modify.setText("Modifier");
        modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyActionPerformed(evt);
            }
        });

        jLabel10.setText("ref :");

        type_details.setBackground(new java.awt.Color(51, 51, 51));

        provider_details.setBackground(new java.awt.Color(51, 51, 51));

        disponibility_details.setBackground(new java.awt.Color(51, 51, 51));

        origin_details.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(product_name_details, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                            .addComponent(brand_details, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(product_created_at_details, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(created_by_details, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(143, 143, 143))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addGap(39, 39, 39)
                                .addComponent(id_article_details))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                    .addComponent(type_details, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(44, 44, 44)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(message, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                                            .addComponent(provider_details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(disponibility_details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(origin_details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(368, 368, 368)
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(184, 184, 184)
                    .addComponent(modify, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(954, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(product_created_at_details, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(created_by_details, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id_article_details)
                            .addComponent(jLabel10))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(product_name_details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(brand_details, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 2, Short.MAX_VALUE))
                            .addComponent(provider_details, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(disponibility_details, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(origin_details, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(type_details, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(645, Short.MAX_VALUE)
                    .addComponent(modify, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(76, 76, 76)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void product_name_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_name_detailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_product_name_detailsActionPerformed

    private void brand_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brand_detailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brand_detailsActionPerformed

    private void product_created_at_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_created_at_detailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_product_created_at_detailsActionPerformed

    private void created_by_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_created_by_detailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_created_by_detailsActionPerformed

    private void modifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyActionPerformed

        Validator val = new Validator();
        if (val.stringEntry(product_name_details.getText())) {
            MArticles up = new MArticles();
            up.setId(Integer.parseInt(id_article_details.getText()));
            up.setName(product_name_details.getText());
            up.setOrigin(origin_details.getSelectedItem());
            up.setStatus_article(disponibility_details.getSelectedItem());
            up.setProvider(provider_details.getSelectedItem());
            up.setType(type_details.getSelectedItem());
            System.out.println("détail :" + up.toString());
            try {
                DBArticle.updateArticleToDB(up);
            } catch (SQLException ex) {
                Logger.getLogger(VDetails.class.getName()).log(Level.SEVERE, null, ex);
            }

            reload_articles();
            reload_articles_command();
        } else {
            String message = "Merci de saisir un nom et une adresse valide";
            VError error = new VError(message);
            error.setVisible(true);
        }
    }//GEN-LAST:event_modifyActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        DBArticle.deleteArticleByNameFromDB(product_name_details.getText());
        message.setText("L'article " + product_name_details.getText() + " a été supprimé.");
        product_name_details.setText("");
        brand_details.setText("");
        provider_details.removeAll();
        product_created_at_details.setText("");
        disponibility_details.removeAll();
        provider_details.removeAll();
        created_by_details.setText("");
        origin_details.removeAll();
        type_details.removeAll();
        reload_articles();
        reload_articles_command();
    }//GEN-LAST:event_deleteActionPerformed

    private void reload_articles() {
        ArrayList<MArticles> arr = new ArrayList();
        try {
            arr = DBArticle.getArticlesFromDB();
        } catch (SQLException ex) {
            Logger.getLogger(VDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        model.setRowCount(0);
        jtable.setAutoCreateRowSorter(true);
        DefaultTableModel table = (DefaultTableModel) jtable.getModel();
        for (int i = 0; i < arr.size(); i++) {
            MArticles add = new MArticles();
            add = arr.get(i);
            String show[] = {add.getName(), add.getBrand(), DBProvider.getProvidersByIdFromDB(DBProvider.getProvidersIdByIdArticleFromDB(add.getId())), DBArticle.getOriginByIdArticleFromDB(add.getId()), add.getStatus_article()};
            table.addRow(show);
        }
    }

//    public static void main(String args[]) {
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//            }
//        });
//    }
    public void load_add_article_provider() {
        ArrayList provider_array = new ArrayList<>();
        provider_array = DBProvider.getProvidersArrayListFromDB();
        for (int i = 0; i < provider_array.size(); i++) {
            String to_add = (String) provider_array.get(i);
            if (provider_details.getSelectedItem().equals(to_add)) {
                System.out.println("je fais rien");
            } else {
                System.out.println(i);
                provider_details.add(to_add);
            }
        }

    }

    public void load_add_article_type() {

        if (type_details.getSelectedItem().equals("Ustensile")) {
            type_details.add("Ingredient");
        } else {
            type_details.add("Ustensile");
        }
    }

    public void load_add_article_status() {

        if (disponibility_details.getSelectedItem().equals("Disponible")) {
            disponibility_details.add("Indisponible");
        } else {
            disponibility_details.add("Disponible");
        }
    }

    public void load_add_article_origin() {
        String[] tab = {"France", "Allemagne", "Espagne", "Italie", "Belgique"};
        for (int i = 0; i < tab.length; i++) {
            if (origin_details.getSelectedItem().equals(tab[i])) {
                System.out.println("nope");
            } else {
                origin_details.add(tab[i]);
            }
        }
    }

    public void ini_v_details() {
        load_add_article_status();
        load_add_article_provider();
        load_add_article_type();
        load_add_article_origin();
    }

    private void reload_articles_command() {
        ArrayList<MArticles> arr = new ArrayList();

        try {
            arr = DBArticle.getArticlesForCommandFromDB();
        } catch (SQLException ex) {
            Logger.getLogger(VDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model = (DefaultTableModel) command_table.getModel();
        model.setRowCount(0);
        command_table.setAutoCreateRowSorter(true);
        DefaultTableModel table = (DefaultTableModel) command_table.getModel();
        for (int i = 0; i < arr.size(); i++) {
            MArticles add = new MArticles();
            add = arr.get(i);
            String show[] = {add.getName(), DBProvider.getProvidersByIdFromDB(DBProvider.getProvidersIdByIdArticleFromDB(add.getId())), DBArticle.getOriginByIdArticleFromDB(add.getId()), add.getStatus_article()};
            table.addRow(show);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextField brand_details;
    private java.awt.TextField created_by_details;
    private javax.swing.JButton delete;
    private java.awt.Choice disponibility_details;
    private javax.swing.JLabel id_article_details;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel message;
    private javax.swing.JButton modify;
    private java.awt.Choice origin_details;
    private java.awt.TextField product_created_at_details;
    private java.awt.TextField product_name_details;
    private java.awt.Choice provider_details;
    private java.awt.Choice type_details;
    // End of variables declaration//GEN-END:variables
}
