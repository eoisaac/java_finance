package org.eoisaac.views;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import org.eoisaac.model.entities.TransactionType;

public class TransactionTableRowRenderer extends DefaultTableCellRenderer {
    private final List<String> hiddenColumnNames;

    public TransactionTableRowRenderer(List<String> hiddenColumnNames) {
        this.hiddenColumnNames = hiddenColumnNames;
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        String columnName = table.getColumnName(column);

        if (hiddenColumnNames.contains(columnName)) {
            TableColumn columnToHide = table.getColumnModel().getColumn(column);
            columnToHide.setMinWidth(0);
            columnToHide.setMaxWidth(0);
            columnToHide.setPreferredWidth(0);
            
        } else {
            int TYPE_COLUMN_INDEX = 1;
            TransactionType transactionType = (TransactionType) table.getModel().getValueAt(row, TYPE_COLUMN_INDEX);
            boolean isIncome = transactionType == TransactionType.INCOME;

            Color transactionColor = isIncome ? new Color(200, 255, 200) : new Color(255, 200, 200);
            Color backgroundColor = isSelected ? new Color(204, 204, 255) : transactionColor;

            setBackground(backgroundColor);
        }

        return this;
    }
}

