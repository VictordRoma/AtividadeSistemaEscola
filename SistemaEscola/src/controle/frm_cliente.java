/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package controle;

import conexao.Conexao;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dti
 */
public class frm_cliente extends javax.swing.JFrame {

    Conexao con_diretor;

    public frm_cliente() {
        initComponents();
        
        con_diretor = new Conexao();
        con_diretor.conecta();
        con_diretor.executaSQL("select * from tblalunos order by rm");
        preencherTabela();
        posicionarRegistro();
        tblAlunos.setAutoCreateRowSorter(true);

    }

    public void preencherTabela() {
        tblAlunos.getColumnModel().getColumn(0).setPreferredWidth(4);
        tblAlunos.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblAlunos.getColumnModel().getColumn(2).setPreferredWidth(11);
        tblAlunos.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblAlunos.getColumnModel().getColumn(4).setPreferredWidth(100);
        tblAlunos.getColumnModel().getColumn(5).setPreferredWidth(100);

        DefaultTableModel modelo = (DefaultTableModel) tblAlunos.getModel();
        modelo.setNumRows(0);

        try {
            con_diretor.resultset.beforeFirst();
            while (con_diretor.resultset.next()) {
                modelo.addRow(new Object[]{
                    con_diretor.resultset.getString("rm"), 
                    con_diretor.resultset.getString("nome"), 
                    con_diretor.resultset.getString("idade"), 
                    con_diretor.resultset.getString("telefone"), 
                    con_diretor.resultset.getString("email"), 
                    con_diretor.resultset.getString("notafinal"),
                });
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!! :\n " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void posicionarRegistro() {
        try {
            con_diretor.resultset.first(); // posiciona no 1º registro da tabela
            mostrar_Dados(); // chama o método que irá buscar o dado da tabela
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar no primeiro registro: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void mostrar_Dados() {
        try {
            txtRm.setText(con_diretor.resultset.getString("rm")); // associar a caixa de texto ao campo cod
            txtNome.setText(con_diretor.resultset.getString("nome"));
            txtIdade.setText(con_diretor.resultset.getString("idade"));
            txtFone.setText(con_diretor.resultset.getString("telefone"));
            txtEmail.setText(con_diretor.resultset.getString("email"));
            txtNotaFinal.setText(con_diretor.resultset.getString("notafinal"));
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não localizou dados: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtEmail = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlunos = new javax.swing.JTable();
        txt_pesquisa = new javax.swing.JTextField();
        lblRm = new javax.swing.JLabel();
        lblSearch = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        btnVoltarUmRegistro = new javax.swing.JButton();
        lblIdade = new javax.swing.JLabel();
        btnAdiantarUmRegistro = new javax.swing.JButton();
        lblTel = new javax.swing.JLabel();
        btnUltimoRegistro = new javax.swing.JButton();
        lblEmail = new javax.swing.JLabel();
        btnPrimeiroRegistro = new javax.swing.JButton();
        txtIdade = new javax.swing.JTextField();
        btnSair = new javax.swing.JButton();
        txtRm = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        btnAlterar = new javax.swing.JButton();
        txtFone = new javax.swing.JTextField();
        btnGravar = new javax.swing.JButton();
        txtAtrib = new javax.swing.JLabel();
        lblNotaFinal = new javax.swing.JLabel();
        txtNotaFinal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/add.png"))); // NOI18N
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        tblAlunos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "RM", "Nome", "Idade", "Telefone", "Email", "Nota Final"
            }
        ));
        tblAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlunosMouseClicked(evt);
            }
        });
        tblAlunos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblAlunosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblAlunos);

        txt_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pesquisaActionPerformed(evt);
            }
        });
        txt_pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pesquisaKeyReleased(evt);
            }
        });

        lblRm.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblRm.setText("Rm");

        lblSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSearch.setText("Pesquisa por nome do cliente:  ");

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNome.setText("Nome:");

        btnVoltarUmRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/resultset_previous.png"))); // NOI18N
        btnVoltarUmRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarUmRegistroActionPerformed(evt);
            }
        });

        lblIdade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblIdade.setText("Idade:");

        btnAdiantarUmRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/resultset_next.png"))); // NOI18N
        btnAdiantarUmRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdiantarUmRegistroActionPerformed(evt);
            }
        });

        lblTel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTel.setText("Telefone:");

        btnUltimoRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/resultset_last.png"))); // NOI18N
        btnUltimoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoRegistroActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEmail.setText("Email:");

        btnPrimeiroRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/resultset_first.png"))); // NOI18N
        btnPrimeiroRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroRegistroActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/door_in.png"))); // NOI18N
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        txtRm.setEditable(false);
        txtRm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRmActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/application_delete.png"))); // NOI18N
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/application_edit.png"))); // NOI18N
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/disk.png"))); // NOI18N
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        txtAtrib.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtAtrib.setForeground(new java.awt.Color(153, 0, 0));
        txtAtrib.setText("Atribuindo o aluno ao Sistema");
        txtAtrib.setToolTipText("");

        lblNotaFinal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNotaFinal.setText("Nota Final:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(lblSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdade)
                            .addComponent(lblRm)
                            .addComponent(lblNome)
                            .addComponent(lblTel)
                            .addComponent(lblEmail)
                            .addComponent(lblNotaFinal))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNotaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtRm, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtIdade)
                                .addComponent(txtNome)
                                .addComponent(txtFone)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtAtrib)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(btnPrimeiroRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnVoltarUmRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdiantarUmRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUltimoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(txtAtrib)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRm)
                    .addComponent(txtRm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdade)
                    .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTel)
                    .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNotaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNotaFinal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUltimoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnVoltarUmRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAdiantarUmRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnPrimeiroRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // limpa a caixa de texto em questão
        txtNome.setText("");
        txtIdade.setText("");
        txtFone.setText("");
        txtEmail.setText("");
        txtNotaFinal.setText("");
        txtNome.requestFocus(); // posiciona o cursor neste campo para digitação
    }//GEN-LAST:event_btnNovoActionPerformed

    private void tblAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlunosMouseClicked
        int linha_selecionada = tblAlunos.getSelectedRow();
        txtRm.setText(tblAlunos.getValueAt(linha_selecionada, 0).toString());
        txtNome.setText(tblAlunos.getValueAt(linha_selecionada, 1).toString());
        txtIdade.setText(tblAlunos.getValueAt(linha_selecionada, 2).toString());
        txtFone.setText(tblAlunos.getValueAt(linha_selecionada, 3).toString());
        txtEmail.setText(tblAlunos.getValueAt(linha_selecionada, 4).toString());
        txtNotaFinal.setText(tblAlunos.getValueAt(linha_selecionada, 5).toString());


    }//GEN-LAST:event_tblAlunosMouseClicked

    private void tblAlunosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblAlunosKeyPressed
        // evento que sincroniza a grid com as setas do teclado
        int linha_selecionada = tblAlunos.getSelectedRow();
        txtRm.setText(tblAlunos.getValueAt(linha_selecionada, 0).toString());
        txtNome.setText(tblAlunos.getValueAt(linha_selecionada, 1).toString());
        txtIdade.setText(tblAlunos.getValueAt(linha_selecionada, 2).toString());
        txtFone.setText(tblAlunos.getValueAt(linha_selecionada, 3).toString());
        txtEmail.setText(tblAlunos.getValueAt(linha_selecionada, 4).toString());
        txtNotaFinal.setText(tblAlunos.getValueAt(linha_selecionada, 5).toString());
    }//GEN-LAST:event_tblAlunosKeyPressed

    private void txt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pesquisaActionPerformed

    private void txt_pesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisaKeyReleased
        try {
            String pesquisa = "select * from tblalunos where nome like '" + txt_pesquisa.getText() + "%'";
            con_diretor.executaSQL(pesquisa);

            if (con_diretor.resultset.first()) {
                preencherTabela();
            } else {
                JOptionPane.showMessageDialog(null, "\n Não existe dados com este paramêtro!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados!! :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_txt_pesquisaKeyReleased

    private void btnVoltarUmRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarUmRegistroActionPerformed
        try {
            int linha_selecionada = con_diretor.resultset.getInt(1);
            if (linha_selecionada > 1) {
                con_diretor.resultset.previous();
            } else {
                con_diretor.resultset.first();
            }

            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível acessar o registro anterior: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnVoltarUmRegistroActionPerformed

    private void btnAdiantarUmRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdiantarUmRegistroActionPerformed
        int i = tblAlunos.getRowCount();

        try {
            int linha_selecionada = con_diretor.resultset.getInt(1);
            if (linha_selecionada < i) {
                con_diretor.resultset.next();
            } else {
                con_diretor.resultset.last();
            }

            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível acessar o próximo registro: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAdiantarUmRegistroActionPerformed

    private void btnUltimoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoRegistroActionPerformed
        try {
            con_diretor.resultset.last();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível acessar o último registro: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnUltimoRegistroActionPerformed

    private void btnPrimeiroRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroRegistroActionPerformed
        try {
            con_diretor.resultset.first();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registro: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnPrimeiroRegistroActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void txtRmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRmActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String sql = "";
        try {
            int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir o registro: ", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION, 3);
            if (resposta == 0) {
                sql = "delete from tblalunos where rm = " + txtRm.getText();
                int excluir = con_diretor.statement.executeUpdate(sql);
                if (excluir == 1) {
                    JOptionPane.showMessageDialog(null, "Exclusão realizada com sucessso!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    con_diretor.executaSQL("select * from tblalunos order by rm");
                    con_diretor.resultset.first();
                    preencherTabela();
                    posicionarRegistro();
                } else {
                    JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (SQLException excecao) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão: " + excecao, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        String nome = txtNome.getText();
        String idade = txtIdade.getText();
        String telefone = txtFone.getText();
        String email = txtEmail.getText();
        String notafinal = txtNotaFinal.getText();
        String sql = "";
        String msg = "";

        try {
            if (txtRm.getText().equals("")) {
                sql = "insert into tblalunos (nome, idade, telefone, email, notafinal) values ('" + nome + "','" + idade + "','" + telefone + "','" + email + "','" + notafinal + "')";
                msg = "Gravação de um novo registro";
            } else {
                sql = "update tblalunos set nome='" + nome + "',idade='" + idade + "',telefone='" + telefone + "', email='" + email + "', notafinal='" + notafinal + "'  where rm = " + txtRm.getText();
                msg = "Alteração de registro";
            }

            con_diretor.statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, msg + " realizada com sucesso!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

            con_diretor.executaSQL("select * from tblalunos order by rm");
            con_diretor.resultset.first();
            preencherTabela();
            posicionarRegistro();
            mostrar_Dados();
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        String nome = txtNome.getText();
        String idade = txtIdade.getText();
        String telefone = txtFone.getText();
        String email = txtEmail.getText();
        String notafinal = txtNotaFinal.getText();

        try {
            String insert_sql = "insert into tblalunos (nome, idade, telefone, email, notafinal) values ('" + nome + "','" + idade + "','" + telefone + "','" + email + "','" + notafinal + "')";
            con_diretor.statement.executeUpdate(insert_sql);
            JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!", "Mensagem do Programa:", JOptionPane.INFORMATION_MESSAGE);
            con_diretor.executaSQL("select * from tblalunos order by rm");
            con_diretor.resultset.first();
            preencherTabela();
            posicionarRegistro();
            mostrar_Dados();
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnGravarActionPerformed

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
            java.util.logging.Logger.getLogger(frm_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdiantarUmRegistro;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPrimeiroRegistro;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnUltimoRegistro;
    private javax.swing.JButton btnVoltarUmRegistro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNotaFinal;
    private javax.swing.JLabel lblRm;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblTel;
    private javax.swing.JTable tblAlunos;
    private javax.swing.JLabel txtAtrib;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFone;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNotaFinal;
    private javax.swing.JTextField txtRm;
    private javax.swing.JTextField txt_pesquisa;
    // End of variables declaration//GEN-END:variables
}
