package org.eoisaac.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Instant;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import org.eoisaac.controllers.CategoryController;
import org.eoisaac.controllers.TransactionController;
import org.eoisaac.model.entities.CategoryEntity;
import org.eoisaac.model.entities.TransactionEntity;
import org.eoisaac.model.entities.TransactionSummary;
import org.eoisaac.model.entities.TransactionType;
import org.eoisaac.utils.CurrencyUtils;
import org.eoisaac.utils.DateUtils;
import org.eoisaac.utils.TransactionUtils;

/**
 * @author saulo.cabral
 * @author @eoisaac
 */
public class AppFrame extends JFrame {
  private final CategoryController categoryController;
  private final TransactionController transactionController;

  private List<TransactionEntity> transactions;

  private UUID selectedTransactionId;

  private JLabel confirmDialogMessage;

  private JComboBox<String> transactionCategoryComboBox;
  private JFormattedTextField transactionEntryDateField;
  private JButton deleteTransactionButton;
  private JLabel totalBalance;
  private JTable transactionsTable;

  private JRadioButton transactionTypeIncomeRadioButton;
  private JLabel totalExpense;

  private JLabel alertMessage;
  private JTextField transactionNameField;
  private JLabel totalIncome;
  private JTextField transactionPriceField;

  /** Creates new form AppFrame */
  public AppFrame() {
    transactionController = new TransactionController();
    categoryController = new CategoryController();

    createUIComponents(); // Generates the UI components

    updateTransactionsData(); // Updates the transactions data on the table
  }

  private void createUIComponents() {

    JPanel mainPanel = new JPanel();
    JPanel transactionFormPanel = new JPanel();

    confirmDialogMessage = new JLabel();

    JLabel frameTitle = new JLabel();

    JLabel transactionNameLabel = new JLabel();
    transactionNameField = new JTextField();

    JLabel transactionCategoryLabel = new JLabel();
    transactionCategoryComboBox = new JComboBox<>();

    JLabel transactionPriceLabel = new JLabel();
    transactionPriceField = new JTextField();

    JLabel transactionEntryDateLabel = new JLabel();
    transactionEntryDateField = new JFormattedTextField();

    transactionTypeIncomeRadioButton = new JRadioButton();
    JRadioButton transactionTypeExpenseRadioButton = new JRadioButton();

    JButton createTransactionButton = new JButton();

    JSeparator separator = new JSeparator();
    JScrollPane transactionsTablePanel = new JScrollPane();
    transactionsTable = new JTable();

    alertMessage = new JLabel();

    deleteTransactionButton = new JButton();
    JLabel totalIncomeLabel = new JLabel();
    totalIncome = new JLabel();

    JLabel totalExpenseLabel = new JLabel();
    totalExpense = new JLabel();

    JLabel totalBalanceLabel = new JLabel();
    totalBalance = new JLabel();

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    mainPanel.setBackground(new Color(255, 255, 255));

    confirmDialogMessage.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    confirmDialogMessage.setText("Deseja realmente excluir a transação?");

    transactionFormPanel.setBackground(new Color(204, 204, 255));
    transactionFormPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

    // Transaction Name
    transactionNameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    transactionNameLabel.setText("Nome");

    transactionNameField.setFont(new Font("Segoe UI", Font.PLAIN, 18));

    // Transaction Category
    transactionCategoryLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    transactionCategoryLabel.setText("Classificação");

    // Transaction Value
    transactionCategoryComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    transactionCategoryComboBox.setModel(new DefaultComboBoxModel<>());
    transactionCategoryComboBox.setEditable(true);

    // Transaction Price
    transactionPriceLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    transactionPriceLabel.setText("Valor");

    transactionPriceField.setFont(new Font("Segoe UI", Font.PLAIN, 18));

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
    transactionTypeIncomeRadioButton.setFont(new Font("Segoe UI", Font.PLAIN, 24));
    transactionTypeIncomeRadioButton.setText("Ganho (+)");

    transactionTypeExpenseRadioButton.setBackground(new Color(204, 204, 255));
    transactionTypeExpenseRadioButton.setFont(new Font("Segoe UI", Font.PLAIN, 24));
    transactionTypeExpenseRadioButton.setText("Gasto (-)");

    ButtonGroup transactionTypesGroup = new ButtonGroup();
    transactionTypesGroup.add(transactionTypeIncomeRadioButton);
    transactionTypesGroup.add(transactionTypeExpenseRadioButton);
    transactionTypesGroup.setSelected(transactionTypeIncomeRadioButton.getModel(), true);

    //    transactionTypeIncomeRadioButton.addActionListener(this::handleTransactionTypeSelection);
    //    transactionTypeExpenseRadioButton.addActionListener(this::handleTransactionTypeSelection);

    // Create Transaction Button
    createTransactionButton.setFont(new Font("Segoe UI", Font.PLAIN, 24));
    createTransactionButton.setText("CADASTRAR");

    deleteTransactionButton.setEnabled(false);

    createTransactionButton.addActionListener(this::handleNewTransactionFormSubmit);
    deleteTransactionButton.addActionListener(this::handleDisplayConfirmDialog);

    GroupLayout transactionFormGroupLayout = new GroupLayout(transactionFormPanel);
    transactionFormPanel.setLayout(transactionFormGroupLayout);
    transactionFormGroupLayout.setHorizontalGroup(
        transactionFormGroupLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                transactionFormGroupLayout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        transactionFormGroupLayout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(transactionNameField)
                            .addComponent(transactionCategoryComboBox)
                            .addComponent(transactionPriceField)
                            .addGroup(
                                transactionFormGroupLayout
                                    .createSequentialGroup()
                                    .addGroup(
                                        transactionFormGroupLayout
                                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(transactionNameLabel)
                                            .addComponent(transactionCategoryLabel)
                                            .addComponent(transactionPriceLabel)
                                            .addComponent(transactionEntryDateLabel)
                                            .addComponent(
                                                transactionEntryDateField,
                                                GroupLayout.PREFERRED_SIZE,
                                                137,
                                                GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(
                                GroupLayout.Alignment.TRAILING,
                                transactionFormGroupLayout
                                    .createSequentialGroup()
                                    .addComponent(transactionTypeIncomeRadioButton)
                                    .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.RELATED,
                                        GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addComponent(
                                        transactionTypeExpenseRadioButton,
                                        GroupLayout.PREFERRED_SIZE,
                                        151,
                                        GroupLayout.PREFERRED_SIZE)
                                    .addGap(4, 4, 4)))
                    .addContainerGap())
            .addComponent(separator)
            .addGroup(
                GroupLayout.Alignment.TRAILING,
                transactionFormGroupLayout
                    .createSequentialGroup()
                    .addContainerGap(81, Short.MAX_VALUE)
                    .addComponent(
                        createTransactionButton,
                        GroupLayout.PREFERRED_SIZE,
                        252,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(69, 69, 69)));
    transactionFormGroupLayout.setVerticalGroup(
        transactionFormGroupLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                transactionFormGroupLayout
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
                    .addComponent(transactionPriceLabel)
                    .addGap(6, 6, 6)
                    .addComponent(
                        transactionPriceField,
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
                        transactionFormGroupLayout
                            .createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(transactionTypeIncomeRadioButton)
                            .addComponent(transactionTypeExpenseRadioButton))
                    .addGap(39, 39, 39)
                    .addComponent(createTransactionButton)
                    .addContainerGap(73, Short.MAX_VALUE)));

    // Transactions Table
    transactionsTable.setBorder(BorderFactory.createEtchedBorder());
    transactionsTable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    transactionsTable.setModel(
        new DefaultTableModel(
            new Object[][] {},
            new String[] {"ID", "Tipo", "Nome", "Classificação", "valor", "Data", "Cadastro"}));
    transactionsTablePanel.setViewportView(transactionsTable);

    transactionsTable.addMouseListener(
        new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            handleSelectedTransaction(evt);
          }
        });

    // Delete Transaction Button
    deleteTransactionButton.setText("DEL");

    totalIncomeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    totalIncomeLabel.setText("Recebido:");

    totalIncome.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    totalIncome.setText("0.00");

    totalExpenseLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    totalExpenseLabel.setText("Gastos:");

    totalExpense.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    totalExpense.setText("0.00");

    totalBalanceLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    totalBalanceLabel.setText("Diferença:");

    totalBalance.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    totalBalance.setText("0.00");

    frameTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
    frameTitle.setText("Finanças Anual Seu José");

    alertMessage.setFont(new Font("Segoe UI", Font.BOLD, 14));
    alertMessage.setForeground(new Color(255, 102, 102));

    GroupLayout mainLayout = new GroupLayout(mainPanel);
    mainPanel.setLayout(mainLayout);
    mainLayout.setHorizontalGroup(
        mainLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                mainLayout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        mainLayout
                            .createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(
                                transactionFormPanel,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                alertMessage,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        mainLayout
                            .createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(
                                mainLayout
                                    .createSequentialGroup()
                                    .addComponent(totalIncomeLabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(totalIncome)
                                    .addGap(20, 20, 20)
                                    .addComponent(totalExpenseLabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(totalExpense)
                                    .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.RELATED,
                                        GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addComponent(totalBalanceLabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(totalBalance)
                                    .addGap(20, 20, 20)
                                    .addComponent(deleteTransactionButton))
                            .addComponent(
                                transactionsTablePanel,
                                GroupLayout.PREFERRED_SIZE,
                                600,
                                GroupLayout.PREFERRED_SIZE)))
            .addGroup(
                mainLayout
                    .createSequentialGroup()
                    .addGap(363, 363, 363)
                    .addComponent(frameTitle)
                    .addContainerGap(16, Short.MAX_VALUE)));
    mainLayout.setVerticalGroup(
        mainLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                GroupLayout.Alignment.TRAILING,
                mainLayout
                    .createSequentialGroup()
                    .addComponent(frameTitle)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                    .addGroup(
                        mainLayout
                            .createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(transactionsTablePanel)
                            .addComponent(
                                transactionFormPanel,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        mainLayout
                            .createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteTransactionButton)
                            .addComponent(totalIncomeLabel)
                            .addComponent(totalIncome)
                            .addComponent(totalExpenseLabel)
                            .addComponent(totalExpense)
                            .addComponent(totalBalanceLabel)
                            .addComponent(totalBalance)
                            .addComponent(alertMessage))
                    .addContainerGap()));
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(
                mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(
                mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

    pack();
  } // </editor-fold>//GEN-END:initComponents

  private void resetFormFields() { // Resets the form fields
    transactionNameField.setText(""); // Resets the transaction name field
    transactionPriceField.setText(""); // Resets the transaction price field
    transactionEntryDateField.setText(""); // Resets the transaction entry date field
    transactionCategoryComboBox.setSelectedIndex(0); // Resets the transaction category combo box
  }

  private void deleteTransaction(UUID transactionId) { // Deletes a transaction
    boolean deleted =
        transactionController.deleteTransaction(transactionId); // Deletes the transaction
    if (deleted) { // If the transaction was deleted
      selectedTransactionId = null; // Resets the selected transaction id
      deleteTransactionButton.setEnabled(false); // Disables the delete transaction button
      updateTransactionsData(); // Updates the transactions data on the table without the deleted
      // transaction
    }
  }

  private void updateTransactionsData() { // Updates the transactions data on the table
    transactions = transactionController.getAllTransactions(); // or use local variable as cache
    boolean hasTransactions = !transactions.isEmpty(); // Checks if there are transactions

    renderTransactionsTable(); // Renders the transactions table
    renderCategoriesComboBox(); // Renders the categories combo box
    renderTransactionsSummary(); // Renders the transactions summary

    transactionsTable.setVisible(
        hasTransactions); // Shows the transactions table if there are transactions

    if (!hasTransactions) {
      alertMessage.setText("Nenhuma transação cadastrada!");
    }
  }

  private boolean validateAndExtractFormFields() {
    String transactionName = transactionNameField.getText();
    String transactionValue = transactionPriceField.getText();
    String entryDate = transactionEntryDateField.getText();
    String selectedCategory = (String) transactionCategoryComboBox.getSelectedItem();
    boolean isIncome = transactionTypeIncomeRadioButton.isSelected();

    if (transactionName.isEmpty()) {
      alertMessage.setText("O nome da transação não pode ser vazio!");
      return false;
    }

    if (transactionValue.isEmpty()) {
      alertMessage.setText("O valor da transação não pode ser vazio!");
      return false;
    }

    if (entryDate.isEmpty()) {
      alertMessage.setText("A data da transação não pode ser vazia!");
      return false;
    }

    if (selectedCategory.isEmpty()) {
      alertMessage.setText("A categoria da transação não pode ser vazia!");
      return false;
    }

    // Additional validation checks if needed

    return true;
  }

  private void handleNewTransactionFormSubmit(
      ActionEvent evt) { // Handles the new transaction form submit
    String transactionName = transactionNameField.getText(); // Gets the transaction name
    String transactionValue = transactionPriceField.getText(); // Gets the transaction value
    String entryDate = transactionEntryDateField.getText(); // Gets the transaction entry date
    String selectedCategory =
        (String) transactionCategoryComboBox.getSelectedItem(); // Gets the selected category

    boolean isIncome =
        transactionTypeIncomeRadioButton.isSelected(); // Checks if the transaction is income
    TransactionType transactionType =
        isIncome ? TransactionType.INCOME : TransactionType.EXPENSE; // Sets the transaction type

    Instant entryDateInstant =
        DateUtils.convertStringToInstant(entryDate); // Converts the entry date to an instant
    float transactionValueFloat =
        Float.parseFloat(transactionValue); // Converts the transaction value to a float

    Optional<CategoryEntity> category =
        categoryController.createCategory(selectedCategory); // Creates the category

    if (category.isEmpty()) { // If the category was not created
      alertMessage.setText("Ocorreu um erro ao criar a categoria, tente novamente mais tarde!");
      return;
    }

    Optional<TransactionEntity> createdTransaction = // Creates the transaction
        transactionController.createTransaction(
            transactionName,
            transactionType,
            transactionValueFloat,
            entryDateInstant,
            category.get());

    if (createdTransaction.isEmpty()) { // If the transaction was not created
      alertMessage.setText("Ocorreu um erro ao criar a transação, tente novamente mais tarde!");
      return;
    }

    transactions.add(createdTransaction.get()); // Adds the created transaction to the list
    updateTransactionsData(); // Updates the transactions data on the table with the new one

    alertMessage.setText(""); // Resets the alert message
    resetFormFields();
  }

  public void handleSelectedTransaction(MouseEvent evt) { // Handles the selected transaction
    int selectedRow = transactionsTable.getSelectedRow(); // Gets the selected row
    DefaultTableModel tableModel =
        (DefaultTableModel) transactionsTable.getModel(); // Gets the table model
    this.selectedTransactionId =
        (UUID) tableModel.getValueAt(selectedRow, 0); // Gets the selected transaction id

    deleteTransactionButton.setEnabled(true); // Enables the delete transaction button
  }

  private void handleDisplayConfirmDialog(
      ActionEvent actionEvent) { // Handles the display confirm dialog
    System.out.println("Display confirm dialog");
    int result =
        JOptionPane.showOptionDialog( // Displays the confirm dialog
            this, // Sets the parent component
            confirmDialogMessage, // Sets the confirm dialog message
            "Excluir transação", // Sets the confirm dialog title
            JOptionPane.YES_NO_OPTION, // Sets the confirm dialog options
            JOptionPane.WARNING_MESSAGE, // Sets the confirm dialog message type
            null, // Sets the confirm dialog icon
            new Object[] {"Sim", "Não"}, // Sets the confirm dialog buttons
            "No"); // Sets the confirm dialog default button

    if (result == JOptionPane.YES_OPTION) { // If the user clicked the yes button
      deleteTransaction(selectedTransactionId); // Deletes the transaction
    }
  }

  public void renderTransactionsSummary() { // Renders the transactions summary
    TransactionSummary transactionSummary =
        TransactionUtils.calculateTransactionSummary(
            transactions); // Calculates the transaction summary
    totalIncome.setText(
        CurrencyUtils.formatCurrency(transactionSummary.getTotalIncome())); // Sets the total income
    totalExpense.setText(
        CurrencyUtils.formatCurrency(
            transactionSummary.getTotalExpense())); // Sets the total expense
    totalBalance.setText(
        CurrencyUtils.formatCurrency(
            transactionSummary.getTotalBalance())); // Sets the total balance
  }

  private void renderTransactionsTable() { // Renders the transactions table
    DefaultTableModel tableModel =
        (DefaultTableModel) transactionsTable.getModel(); // Gets the table model
    tableModel.setRowCount(0); // Resets the table rows

    List<String> hiddenColumnNames = List.of("ID", "Tipo"); // Sets the hidden column names
    transactionsTable.setDefaultRenderer(
        Object.class,
        new TransactionTableRowRenderer(
            hiddenColumnNames)); // Sets the table row to set the background color of the row (RED
    // or GREEN)

    transactions.forEach( // For each transaction
        transaction -> {
          tableModel.addRow( // Adds the transaction to the table
              new Object[] { // Sets the transaction data
                transaction.getId(), // Sets the transaction id
                transaction.getType(), // Sets the transaction type
                transaction.getName(), // Sets the transaction name
                transaction.getCategory().getName(), // Sets the transaction category name
                CurrencyUtils.formatCurrency(transaction.getPrice()), // Sets the transaction value
                DateUtils.convertInstantToString(
                    transaction.getEntryDate()), // Sets the transaction entry date
                DateUtils.convertInstantToString(
                    transaction.getCreatedAt()), // Sets the transaction created at date
              });
        });
  }

  private void renderCategoriesComboBox() { // Renders the categories combo box
    DefaultComboBoxModel<String> comboBoxModel =
        (DefaultComboBoxModel<String>)
            transactionCategoryComboBox.getModel(); // Gets the combo box model
    comboBoxModel.removeAllElements(); // Removes all elements from the combo box
    categoryController
        .getAllCategories() // Gets all categories
        .forEach( // For each category
            category -> {
              comboBoxModel.addElement(category.getName()); // Adds the category to the combo box
            });
  }
}
