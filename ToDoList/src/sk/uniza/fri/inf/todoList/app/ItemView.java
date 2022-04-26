/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.inf.todoList.app;

import sk.uniza.fri.inf.todoList.model.TodoList;
import sk.uniza.fri.inf.todoList.model.entity.TodoItem;

import javax.swing.SwingUtilities;
import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.function.Function;

/**
 * @author Unlink
 */
public class ItemView extends javax.swing.JPanel {

    private final TodoItem item;
    private final TodoList todoList;
    private final Function<TodoItem, Boolean> onDelete;
    private final Function<TodoItem, Boolean> onEdit;
    private final Function<TodoItem, Boolean> onItemChecked;


    /**
     * Creates new form ItemView
     *
     * @param item
     * @param onDelete
     */
    public ItemView(TodoItem item, TodoList todoList, Function<TodoItem, Boolean> onDelete, Function<TodoItem, Boolean> onEdit, Function<TodoItem, Boolean> onItemChecked) {
        initComponents();
        this.item = item;

        //Inicializacia view
        this.bindValues();
        this.jExtendedInfoPanel.setVisible(false);
        this.todoList = todoList;
        this.onDelete = onDelete;
        this.onEdit = onEdit;
        this.onItemChecked = onItemChecked;

    }

    private void bindValues() {
        this.jTodoItemName.setText(this.item.getTitle());
        this.jTodoItemChecked.setSelected(this.item.isDone());
        this.jDescription.setText(this.item.getDescription());
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.YYYY HH:mm:ss");

        String created = format.format(Date.from(Instant.ofEpochMilli(item.getCreated())));
        String checked = item.isDone() ? format.format(Date.from(Instant.ofEpochMilli(item.getDoneTime()))) : "N/A";
        this.jTotoInfo.setText("Created: " + created + " Checked: " + checked);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTodoItemChecked = new javax.swing.JCheckBox();
        jTodoItemName = new javax.swing.JLabel();
        jExtendedInfoPanel = new javax.swing.JPanel();
        jDeleteButton = new javax.swing.JButton();
        jEditButton = new javax.swing.JButton();
        jTotoInfo = new javax.swing.JLabel();
        jDescription = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));

        jTodoItemChecked.setBackground(new java.awt.Color(255, 255, 255));
        jTodoItemChecked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTodoItemCheckedActionPerformed(evt);
            }
        });

        jTodoItemName.setText("Text poznamky");
        jTodoItemName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTodoItemName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTodoItemNameMouseClicked(evt);
            }
        });

        jExtendedInfoPanel.setBackground(new java.awt.Color(255, 255, 255));

        jDeleteButton.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jDeleteButton.setText("Delete");
        jDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteButtonActionPerformed(evt);
            }
        });

        jEditButton.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jEditButton.setText("Edit");
        jEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditButtonActionPerformed(evt);
            }
        });

        jTotoInfo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTotoInfo.setText("Created: N/A Checked: N/A");

        jDescription.setEditable(false);
        jDescription.setColumns(20);
        jDescription.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jDescription.setRows(5);

        javax.swing.GroupLayout jExtendedInfoPanelLayout = new javax.swing.GroupLayout(jExtendedInfoPanel);
        jExtendedInfoPanel.setLayout(jExtendedInfoPanelLayout);
        jExtendedInfoPanelLayout.setHorizontalGroup(
            jExtendedInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jExtendedInfoPanelLayout.createSequentialGroup()
                    .addComponent(jTotoInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jEditButton)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jDeleteButton))
                .addComponent(jDescription)
        );
        jExtendedInfoPanelLayout.setVerticalGroup(
            jExtendedInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jExtendedInfoPanelLayout.createSequentialGroup()
                    .addGroup(jExtendedInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jDeleteButton)
                        .addComponent(jEditButton)
                        .addComponent(jTotoInfo))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jExtendedInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jTodoItemName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTodoItemChecked, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTodoItemChecked, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTodoItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jExtendedInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    } // </editor-fold>//GEN-END:initComponents

    private void jDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        todoList.remove(this.item);
        this.onDelete.apply(this.item);
    }

    private void jEditButtonActionPerformed(java.awt.event.ActionEvent evt) {
        ItemForm editDialog = new ItemForm((Frame)SwingUtilities.getRoot(this), todoList, item);
        editDialog.setVisible(true);
        this.bindValues();
        onEdit.apply(item);
    }

    private void jTodoItemNameMouseClicked(java.awt.event.MouseEvent evt) {
        this.jExtendedInfoPanel.setVisible(!this.jExtendedInfoPanel.isVisible());
        this.invalidate();
        this.repaint();
    }

    private void jTodoItemCheckedActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.item.isDone()) {
            this.item.unDone();
        } else {
            this.item.done();
        }
        this.bindValues();
        onItemChecked.apply(item);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jDeleteButton;
    private javax.swing.JTextArea jDescription;
    private javax.swing.JButton jEditButton;
    private javax.swing.JPanel jExtendedInfoPanel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JCheckBox jTodoItemChecked;
    private javax.swing.JLabel jTodoItemName;
    private javax.swing.JLabel jTotoInfo;
    // End of variables declaration//GEN-END:variables
}