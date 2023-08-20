package org.eoisaac.views;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TransactionFormView extends JPanel {

  String[] comboBoxOptions = {"Opção 1", "Opção 2", "Opção 3"};

  // Transaction Name
  private JLabel transactionNameLabel;
  private JTextField transactionNameField;
  // Transaction Category
  private JLabel transactionCategoryLabel;
  private JComboBox<String> transactionCategoryComboBox;
  // Transaction Value
  private JLabel transactionValueLabel;
  private JTextField transactionValueField;

  // Transaction Entry Date
  private JLabel transactionEntryDateLabel;
  private JFormattedTextField transactionEntryDateField;

  // Transaction Type
  private JRadioButton transactionTypeIncomeRadioButton;
  private JRadioButton transactionTypeExpenseRadioButton;

  // Transaction Description
  private JButton createTransactionButton;

  // Separation Line
  private JSeparator separator;

  public void render() {
    createUIComponents();
  }

  private void createUIComponents() {
    transactionNameLabel = new JLabel();
    transactionNameField = new JTextField();

    transactionCategoryLabel = new JLabel();
    transactionCategoryComboBox = new JComboBox<>();

    transactionValueLabel = new JLabel();
    transactionValueField = new JTextField();

    transactionEntryDateLabel = new JLabel();
    transactionEntryDateField = new JFormattedTextField();

    transactionTypeIncomeRadioButton = new JRadioButton();
    transactionTypeExpenseRadioButton = new JRadioButton();

    createTransactionButton = new JButton();

    separator = new JSeparator();

    setBackground(new Color(204, 204, 255));
    setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

    // Transaction Name
    transactionNameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    transactionNameLabel.setText("Nome");

    transactionNameField.setFont(new Font("Segoe UI", Font.PLAIN, 18));

    // Transaction Category
    transactionCategoryLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    transactionCategoryLabel.setText("Classificação");

    transactionCategoryComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    transactionCategoryComboBox.setModel(new DefaultComboBoxModel<>(comboBoxOptions));
    transactionCategoryComboBox.setEditable(true);

    // Transaction Value
    transactionValueLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    transactionValueLabel.setText("Valor");

    transactionValueField.setFont(new Font("Segoe UI", Font.PLAIN, 18));

    // Transaction Entry Date
    transactionEntryDateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    transactionEntryDateLabel.setText("Data");

    try {
      MaskFormatter mask = new MaskFormatter("##/##/####");
      mask.install(transactionEntryDateField);
    } catch (Exception e) {
      System.out.println("Error formatting date field mask");
      e.printStackTrace();
    }

    transactionEntryDateField.setFont(new Font("Segoe UI", Font.PLAIN, 18));

    // Transaction Type
    transactionTypeIncomeRadioButton.setBackground(new Color(204, 204, 255));
    transactionTypeIncomeRadioButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    transactionTypeIncomeRadioButton.setText("Ganho (+)");

    transactionTypeExpenseRadioButton.setBackground(new Color(204, 204, 255));
    transactionTypeExpenseRadioButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    transactionTypeExpenseRadioButton.setText("Gasto (-)");

    ButtonGroup transactionTypeButtonGroup = new ButtonGroup();
    transactionTypeButtonGroup.add(transactionTypeIncomeRadioButton);
    transactionTypeButtonGroup.add(transactionTypeExpenseRadioButton);

    //    transactionTypeIncomeRadioButton.addActionListener(this::handleTransactionTypeSelection);
    //    transactionTypeExpenseRadioButton.addActionListener(this::handleTransactionTypeSelection);

    // Create Transaction Button
    createTransactionButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    createTransactionButton.setText("CADASTRAR");

    createTransactionButton.addActionListener(this::handleNewTransactionFormSubmit);

    GroupLayout transactionFormPanelLayout = new GroupLayout(this);
    setLayout(transactionFormPanelLayout);

    transactionFormPanelLayout.setHorizontalGroup(
        transactionFormPanelLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                transactionFormPanelLayout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        transactionFormPanelLayout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(transactionNameField)
                            .addComponent(transactionCategoryComboBox)
                            .addComponent(transactionValueField)
                            .addGroup(
                                transactionFormPanelLayout
                                    .createSequentialGroup()
                                    .addGroup(
                                        transactionFormPanelLayout
                                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(transactionNameLabel)
                                            .addComponent(transactionCategoryLabel)
                                            .addComponent(transactionValueLabel)
                                            .addComponent(transactionEntryDateLabel)
                                            .addComponent(
                                                transactionEntryDateField,
                                                GroupLayout.PREFERRED_SIZE,
                                                137,
                                                GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(
                                GroupLayout.Alignment.TRAILING,
                                transactionFormPanelLayout
                                    .createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(transactionTypeIncomeRadioButton)
                                    .addGap(72, 72, 72)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(transactionTypeExpenseRadioButton)
                                    .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
            .addComponent(separator)
            .addGroup(
                GroupLayout.Alignment.TRAILING,
                transactionFormPanelLayout
                    .createSequentialGroup()
                    .addContainerGap(81, Short.MAX_VALUE)
                    .addComponent(
                        createTransactionButton,
                        GroupLayout.PREFERRED_SIZE,
                        252,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(69, 69, 69)));
    transactionFormPanelLayout.setVerticalGroup(
        transactionFormPanelLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                transactionFormPanelLayout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(transactionNameLabel)
                    .addGap(6, 6, 6)
                    .addComponent(
                        transactionNameField,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(transactionCategoryLabel)
                    .addGap(6, 6, 6)
                    .addComponent(
                        transactionCategoryComboBox,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(transactionValueLabel)
                    .addGap(6, 6, 6)
                    .addComponent(
                        transactionValueField,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(transactionEntryDateLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(
                        transactionEntryDateField,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(42, 42, 42)
                    .addComponent(
                        separator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                    .addGap(28, 28, 28)
                    .addGroup(
                        transactionFormPanelLayout
                            .createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(transactionTypeIncomeRadioButton)
                            .addComponent(transactionTypeExpenseRadioButton))
                    .addGap(39, 39, 39)
                    .addComponent(createTransactionButton)
                    .addContainerGap(73, Short.MAX_VALUE)));
  }

  private void handleNewTransactionFormSubmit(ActionEvent evt) {
    String transactionName = transactionNameField.getText();
    String transactionValue = transactionValueField.getText();
    String entryDate = transactionEntryDateField.getText();
    String selectedCategory = (String) transactionCategoryComboBox.getSelectedItem();
    boolean isIncome = transactionTypeIncomeRadioButton.isSelected();
    boolean isExpense = transactionTypeExpenseRadioButton.isSelected();
  }
}
