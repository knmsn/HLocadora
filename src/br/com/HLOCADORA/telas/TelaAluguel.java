/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.HLOCADORA.telas;

import javax.swing.table.*;
import java.sql.*;
import java.util.Calendar;
import br.com.HLOCADORA.dal.ModuloConexao;
import javax.swing.JOptionPane;

import java.io.IOException;



public class TelaAluguel extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
   public void criarAluguel() {
         if(txtNome.getText().equals("") ||  txtCPF.getText().equals("") ||  txtDevolucao.getText().equals("") ||  txtEntrega.getText().equals("")){
              JOptionPane.showMessageDialog(null, "Preencha todos os campos para criar o registro.");
          }
         else{
        // Verificando se ja ha algum dado cadastrado com 
        String sql = "SELECT * FROM alugueis WHERE nome_filme=? and cpf_usuario=? and data_devolucao=? and data_entrega=?";
        
        try {
           
            pst = conexao.prepareStatement(sql);

            
            pst.setString(1, txtNome.getText());
            pst.setString(2, txtCPF.getText());
            pst.setString(3, txtDevolucao.getText());
            pst.setString(4, txtEntrega.getText());

            rs = pst.executeQuery();
            
           
            if (rs.next()) {
                // Caso ja tenha registro
            JOptionPane.showMessageDialog(null, "Ja existeum registro com estes dados");
            
            } else {
                // Caso nao tenha registro
        String sql2 = "insert into alugueis (nome_filme,cpf_usuario,data_devolucao,data_entrega) values (?,?,?,?);";
        
        try {
            
         
            
            // Armazenando a resposta dentro da variavel pst    
            pst = conexao.prepareStatement(sql2);

            // Pegando texto de dentro das labels 
            pst.setString(1, txtNome.getText());
            pst.setString(2, txtCPF.getText());
             pst.setString(3, txtDevolucao.getText());  
            pst.setString(4, txtEntrega.getText());   
            
            pst.executeUpdate();
            
            listarAlugueis();
            
            // Limpando os campos para verificar se o usuario colocou ou nao todos os campos
            txtNome.setText("");
            txtCPF.setText("");
            txtDevolucao.setText("");
            txtEntrega.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         } 
         }
   
    public void listarAlugueis() {
        
        DefaultTableModel hsaktableInicio = (DefaultTableModel) jTInicio.getModel();

        hsaktableInicio.setRowCount(0);

        // Criando SQL para listar todas as aplicacoes WEB
        String sql = "SELECT * FROM alugueis;";

        try {
            // Armazenando a resposta dentro da variavel pst    
            pst = conexao.prepareStatement(sql);

            rs = pst.executeQuery();
            while (rs.next()) {
                
                //int hora = data.get(Calendar.HOUR_OF_DAY);
                //int min = data.get(Calendar.MINUTE);
                //int seg = data.get(Calendar.SECOND);

                // Fazendo WebScrapping
            hsaktableInicio.addRow(new Object[]{rs.getString("id_aluguel"),rs.getString("nome_filme"), rs.getString("cpf_usuario"),rs.getString("data_devolucao"),rs.getString("data_entrega"),rs.getString("status_entrega")});
                

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "3");
        }

    }

    /**
     * Creates new form TelaPrincipal
     */
    
    public void layoutCriar(){
        jButton1.setVisible(true);
   jButton2.setVisible(false);
   jButton3.setVisible(false);
   jButton5.setVisible(false);
   jComboBox1.setVisible(false);
   jLabel8.setVisible(false);
    }
    public TelaAluguel() {
        
        // Estabelecendo conexao com o banco de dados
        conexao = ModuloConexao.conector();
        // Iniciando a funcao padrao para criar os componentes na tela
        initComponents();
        // Ocultando botao editar e apagar e deixando somente o criar
        layoutCriar();
        // Iniciando funcao para popular tabela inicial.
        listarAlugueis();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTInicio = new javax.swing.JTable();
        txtnomeSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCPF = new javax.swing.JTextField();
        txtDevolucao = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtEntrega = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("[HSK] Inicio");

        jTInicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "DATA", "ENTREGA", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTInicioMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTInicio);

        jLabel2.setText("Busca por CPF");

        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Registre novos alugueis aqui");

        jLabel3.setText("Nome do filme");

        jLabel5.setText("Data devolucao");

        jLabel6.setText("CPF cliente");

        jButton1.setText("Registrar entrega");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Apagar entrega");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Editar entrega");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Cancelar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel7.setText("Data entrega");

        jLabel8.setText("Status");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione aqui", "Entregue", "Pendente", " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(145, 145, 145))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                            .addComponent(txtCPF)
                            .addComponent(txtDevolucao)
                            .addComponent(txtEntrega))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(9, 9, 9)
                .addComponent(txtEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton5))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione aqui", "Entregue", "Pendente" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Busca por status");

        jButton6.setText("Buscar");

        jMenu4.setText("Titulos");
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Gerenciar Titulos");
        jMenu4.add(jMenuItem1);

        jMenuItem2.setText("Gerenciar Alugueis");
        jMenu4.add(jMenuItem2);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("Clientes");

        jMenuItem4.setText("Gerenciar Clientes");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("Sobre");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem3.setText("Projeto HLocadora");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtnomeSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6)
                            .addComponent(jButton4))))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtnomeSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );

        setBounds(0, 0, 1340, 561);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        TelaSobre sobre = new TelaSobre();
        sobre.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        criarAluguel();       
    }//GEN-LAST:event_jButton1ActionPerformed

    
        
 
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   if(jTInicio.getSelectedRow() != -1){
       
   DefaultTableModel hsaktableInicio = (DefaultTableModel) jTInicio.getModel(); 
   
   String value = hsaktableInicio.getValueAt(jTInicio.getSelectedRow(), 0).toString();
    
         String sql2 = "DELETE FROM alugueis WHERE id_aluguel=? ;";
        
        try {
            
         
            
            // Armazenando a resposta dentro da variavel pst    
            pst = conexao.prepareStatement(sql2);

            // Pegando texto de dentro das labels 
            pst.setString(1, value);
            pst.executeUpdate();
           layoutCriar();
            // Deixando tudo como o criar
            
            
                        
listarAlugueis();


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
   
   
   //  
   //hsaktableInicio.removeRow(jTInicio.getSelectedRow());
    
   
   }else{
        JOptionPane.showMessageDialog(null, "Selecione alguma linha.");
   }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTInicioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTInicioMousePressed
   jButton1.setVisible(false);
   jButton2.setVisible(true);
   jButton3.setVisible(true);
   jButton5.setVisible(true);
   jComboBox1.setVisible(true);
   jLabel8.setVisible(true);
   DefaultTableModel hsaktableInicio = (DefaultTableModel) jTInicio.getModel(); 
   
   String nome = hsaktableInicio.getValueAt(jTInicio.getSelectedRow(), 1).toString();
   String CPF = hsaktableInicio.getValueAt(jTInicio.getSelectedRow(), 2).toString();
   String Recebimento = hsaktableInicio.getValueAt(jTInicio.getSelectedRow(), 3).toString();
   String Entrega  = hsaktableInicio.getValueAt(jTInicio.getSelectedRow(), 4).toString();
   String Status = hsaktableInicio.getValueAt(jTInicio.getSelectedRow(), 5).toString();
  
    txtNome.setText(nome);
            txtCPF.setText(CPF);
            txtDevolucao.setText(Recebimento);
            txtEntrega.setText(Entrega);
    }//GEN-LAST:event_jTInicioMousePressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
layoutCriar();
   txtNome.setText("");
            txtCPF.setText("");
            txtDevolucao.setText("");
            txtEntrega.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
 DefaultTableModel hsaktableInicio = (DefaultTableModel) jTInicio.getModel(); 
   
   String value = hsaktableInicio.getValueAt(jTInicio.getSelectedRow(), 0).toString();
    
         String sql3 = "UPDATE alugueis SET nome_filme=?,cpf_usuario=?,data_devolucao=?,data_entrega=?,status_entrega=? WHERE id_aluguel=? ;";
        
        try {
            
         
            
            // Armazenando a resposta dentro da variavel pst    
            pst = conexao.prepareStatement(sql3);

            // Pegando texto de dentro das labels \
            pst.setString(1, txtNome.getText());
             pst.setString(2, txtCPF.getText());
            pst.setString(3, txtDevolucao.getText());
            pst.setString(4, txtEntrega.getText());
            
            if (jComboBox1.getSelectedIndex() == 1){
            String statusAluguel = "Entregue";
            pst.setString(5, statusAluguel);
        }
            
        if (jComboBox1.getSelectedIndex() == 2){
            String statusAluguel = "Pendente";
            pst.setString(5, statusAluguel);
        }
        
        if (jComboBox1.getSelectedIndex() == 0){
             JOptionPane.showMessageDialog(null, "Selecione um status");
        }
        
         
         
            pst.setString(6, value);
            pst.executeUpdate();
            
            // Resetando os labels
            txtNome.setText("");
            txtCPF.setText("");
            txtDevolucao.setText("");

            
            
            jButton1.setVisible(true);
               jButton2.setVisible(false);
   jButton3.setVisible(false);
   jButton5.setVisible(false);
   
   
           listarAlugueis();


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }  
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed


if(txtnomeSearch.getText().equals("")){
              JOptionPane.showMessageDialog(null, "Preencha o CPF  a ser pesquisado.");
          }
else{

DefaultTableModel hsaktableInicio = (DefaultTableModel) jTInicio.getModel();

        hsaktableInicio.setRowCount(0);

        // Criando SQL para listar todas as aplicacoes WEB
        String sql = "SELECT * FROM alugueis where cpf_usuario=?;";

        try {
            
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtnomeSearch.getText());
            rs = pst.executeQuery();
            
            int rowCount = 0;
            while (rs.next()) {
                rowCount = rowCount + 1;
                
            hsaktableInicio.addRow(new Object[]{rs.getString("id_aluguel"),rs.getString("nome_filme"), rs.getString("cpf_usuario"),rs.getString("data_devolucao"),rs.getString("data_entrega"),rs.getString("status_entrega")});
                

            }
            
            if (rowCount <= 0){
                JOptionPane.showMessageDialog(null, "Nada foi encontrado");
               listarAlugueis();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
      TelaAluguel telafilmes = new TelaAluguel();
       telafilmes.setVisible(true);
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       TelaPrincipal telaprincipal = new TelaPrincipal();
       telaprincipal.setVisible(true);
       this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAluguel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTInicio;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtDevolucao;
    private javax.swing.JTextField txtEntrega;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtnomeSearch;
    // End of variables declaration//GEN-END:variables
}