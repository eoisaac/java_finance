package org.eoisaac.views;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import org.eoisaac.model.entities.TransactionType;

public class TransactionTableRowRenderer extends DefaultTableCellRenderer {
    private final int hiddenColumnIndex;

    public TransactionTableRowRenderer(int hiddenColumnIndex) {
        this.hiddenColumnIndex = hiddenColumnIndex;
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (column == hiddenColumnIndex) {
            TableColumn columnToHide = table.getColumnModel().getColumn(hiddenColumnIndex);
            columnToHide.setMinWidth(0);
            columnToHide.setMaxWidth(0);
            columnToHide.setPreferredWidth(0);
            
        } else {
            TransactionType transactionType = (TransactionType) table.getModel().getValueAt(row, 0);
            boolean isIncome = transactionType == TransactionType.INCOME;

            Color transactionColor = isIncome ? new Color(200, 255, 200) : new Color(255, 200, 200);
            Color backgroundColor = isSelected ? new Color(204, 204, 255) : transactionColor;

            setBackground(backgroundColor);
        }

        return this;
    }
}

