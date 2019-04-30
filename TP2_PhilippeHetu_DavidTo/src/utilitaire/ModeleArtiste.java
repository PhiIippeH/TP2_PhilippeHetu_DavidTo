package utilitaire;

import java.util.ArrayList;


import javax.swing.table.AbstractTableModel;


import modeles.Artiste;

public class ModeleArtiste extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Artiste> data;
	
	private final String [] columns = {"Numero", "Nom", "Membre"};
	
	public ModeleArtiste(ArrayList<Artiste> data) {
		this.data = data;
	}
	
	public void addArtiste(Artiste  employe) {
		data.add(employe);
		fireTableRowsInserted(data.size() -1, data.size() -1);
	}
	
	public void deleteData() {
        int rows = getRowCount();
        if (rows == 0) {
            return;
        }
        data.clear();
        fireTableRowsDeleted(0, rows - 1);
    }
	
	
	public void refresh (ArrayList<Artiste> data) {
		this.data = data;
		this.fireTableDataChanged();
	}
	
	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case 0:
				return data.get(rowIndex).getNumero();
			case 1:
				return data.get(rowIndex).getNom();
			case 2:
				return data.get(rowIndex).getMembre();
			default:
				return null;
		}
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return columns[columnIndex];
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex){
		switch (columnIndex) {
        case 0: return int.class;
        case 1: return String.class;
        case 2: return Boolean.class;
        default: throw new IllegalArgumentException(" index de colonne invalide: " + columnIndex);
	  }
	}

}
