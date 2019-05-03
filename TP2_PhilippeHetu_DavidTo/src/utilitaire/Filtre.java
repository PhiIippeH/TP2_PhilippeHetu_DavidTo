package utilitaire;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class Filtre extends FileFilter {
	private String[] extension;
	private String description;
	
	public Filtre(String[] ext, String desc) {
		extension = ext;
		description = desc;
	}
	
	boolean appartient(String suffixe) {
		for (int i = 0; i < extension.length; ++i)
			if (suffixe.equals(extension[i]))
				return true;
		return false;
	}

	@Override
	public boolean accept(File f) {
		String suffixe = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');
		if (i > 0 && i < s.length() - 1)// il y a un suffixe dans le nom du fichier
			// récupérer le suffixe
			suffixe = s.substring(i + 1).toLowerCase();
		return suffixe != null && appartient(suffixe);
	}
	

	@Override
	public String getDescription() {
		
		return description;
	}

}
