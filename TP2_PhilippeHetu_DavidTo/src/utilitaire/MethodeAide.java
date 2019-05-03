package utilitaire;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class MethodeAide {

	public MethodeAide(){
		File fic = new File(System.getProperty("user.dir")+"\\Aide.pdf");
		try {
			Desktop.getDesktop().open(fic);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
