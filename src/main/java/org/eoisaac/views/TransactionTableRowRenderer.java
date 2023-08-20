package org.eoisaac.views;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import org.eoisaac.model.entities.TransactionType;

public class TransactionTableRowRenderer extends DefaultTableCellRenderer {
    private final List<String> hiddenColumnNames; // List of column names to hide

    public TransactionTableRowRenderer(List<String> hiddenColumnNames) { // Constructor
        this.hiddenColumnNames = hiddenColumnNames; // Sets the hiddenColumnNames field
    }

    @Override
    public Component getTableCellRendererComponent( // Overrides the getTableCellRendererComponent method
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) { // Method parameters
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); // Calls the super method

        String columnName = table.getColumnName(column); // Gets the column name

        if (hiddenColumnNames.contains(columnName)) { // Checks if the column name is in the hiddenColumnNames list
            TableColumn columnToHide = table.getColumnModel().getColumn(column); // Gets the column to hide
            columnToHide.setMinWidth(0); // Sets the minimum width of the column to hide to 0
            columnToHide.setMaxWidth(0); // Sets the maximum width of the column to hide to 0
            columnToHide.setPreferredWidth(0); // Sets the preferred width of the column to hide to 0
            
        } else { // If the column name is not in the hiddenColumnNames list
            int TYPE_COLUMN_INDEX = 1; // Sets the index of the type column
            TransactionType transactionType = (TransactionType) table.getModel().getValueAt(row, TYPE_COLUMN_INDEX); // Gets the transaction type
            boolean isIncome = transactionType == TransactionType.INCOME; // Checks if the transaction type is income

            Color transactionColor = isIncome ? new Color(200, 255, 200) : new Color(255, 200, 200); // Sets the transaction color
            Color backgroundColor = isSelected ? new Color(204, 204, 255) : transactionColor; // Sets the background color

            setBackground(backgroundColor); // Sets the background color
        }

        return this; // Returns the component
    }
}

