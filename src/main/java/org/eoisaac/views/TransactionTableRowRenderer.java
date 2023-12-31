package org.eoisaac.views;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import org.eoisaac.model.entities.TransactionType;

/*
 * That class is responsible for rendering the table rows. It overrides the getTableCellRendererComponent method, which
 * is called by the table to render the cell. It checks if the column name is in the hiddenColumnNames list. If it is,
 * it hides the column (the column is not visible, but it still exists). If it is not, it checks the transaction type.
 * If is INCOME, set the background color to a light green. If it is EXPENSE, set the background color to a light red.
 * If the row is selected, set the background color to a light blue.
 * I found this solution on StackOverflow: https://stackoverflow.com/questions/3875607/change-the-background-color-of-a-row-in-a-jtable
 * */

public class TransactionTableRowRenderer extends DefaultTableCellRenderer {
  private final List<String> hiddenColumnNames; // List of column names to hide

  public TransactionTableRowRenderer(List<String> hiddenColumnNames) { // Constructor
    this.hiddenColumnNames = hiddenColumnNames; // Sets the hiddenColumnNames field
  }

  @Override
  public Component
      getTableCellRendererComponent( // Overrides the getTableCellRendererComponent method
          JTable table,
          Object value,
          boolean isSelected,
          boolean hasFocus,
          int row,
          int column) { // Method parameters
    super.getTableCellRendererComponent(
        table, value, isSelected, hasFocus, row, column); // Calls the super method

    String columnName = table.getColumnName(column); // Gets the column name

    if (hiddenColumnNames.contains(
        columnName)) { // Checks if the column name is in the hiddenColumnNames list
      TableColumn columnToHide =
          table.getColumnModel().getColumn(column); // Gets the column to hide
      columnToHide.setMinWidth(0); // Sets the minimum width of the column to hide to 0
      columnToHide.setMaxWidth(0); // Sets the maximum width of the column to hide to 0
      columnToHide.setPreferredWidth(0); // Sets the preferred width of the column to hide to 0

    } else { // If the column name is not in the hiddenColumnNames list
      int TYPE_COLUMN_INDEX = 1; // Sets the index of the type column
      TransactionType transactionType =
          (TransactionType)
              table.getModel().getValueAt(row, TYPE_COLUMN_INDEX); // Gets the transaction type
      boolean isIncome =
          transactionType == TransactionType.INCOME; // Checks if the transaction type is income

      Color transactionColor =
          isIncome
              ? new Color(200, 255, 200)
              : new Color(255, 200, 200); // Sets the transaction color
      Color backgroundColor =
          isSelected ? new Color(204, 204, 255) : transactionColor; // Sets the background color

      setBackground(backgroundColor); // Sets the background color
    }

    table.addFocusListener( // Adds a focus listener to the table
        new FocusAdapter() { // Creates a new focus adapter
          @Override // Overrides the focusGained method
          public void focusLost(FocusEvent e) { // Method parameters, receives a focus event
            int selectedRow = table.getSelectedRow(); // Gets the selected row
            if (selectedRow != -1) { // Checks if the selected row is not -1
              table.getSelectionModel().clearSelection(); // Clears the selection
            }
          }
        });

    return this; // Returns the component
  }
}
