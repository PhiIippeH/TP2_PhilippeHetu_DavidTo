package utilitaire;



import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
public class Rendu extends DefaultTableCellRenderer {
	private static final long serialVersionUID = 1L;
    public Component getTableCellRendererComponent(JTable table,//le JTable qui appelle le renderer
    												Object value,//valeur à attribuer à la cellule qui sera affectée par le renderer
    												boolean isSelected,//vrai si la cellule est sélectionnée
    												boolean hasFocus, //vrai si la cellule a le focus
    												int row,//numéro de ligne de la cellule concernée
    												int column//numéro de colonne de la cellule concernée

    												) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setFont(getFont().deriveFont(Font.BOLD));
        setHorizontalAlignment(JLabel.CENTER);
        return this;
    }
}
