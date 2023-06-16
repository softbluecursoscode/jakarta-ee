package br.com.softblue.primefaces;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

@Named
@RequestScoped
public class UploadBean implements Serializable {
	
	private UploadedFile file;
	
	public String upload() {
		String name = file.getFileName();
		long size = file.getSize();
		
		String dir = "D:/Temp";
		copyFileToDir(file, dir);
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "O arquivo " + name + " foi enviado. Tamanho: " + size + " bytes.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		return null;
	}

	private static void copyFileToDir(UploadedFile file, String dir) {
		if (file == null) {
			return;
		}
		
		OutputStream out = null;
		
		try {
			try {
				InputStream in = file.getInputstream();
				
				File outputFile = new File(dir, file.getFileName());	
				out = new FileOutputStream(outputFile);
				
				byte[] buffer = new byte[1024];
				
				while (true) {
					int bytes = in.read(buffer);
					if (bytes < 0) {
						break;
					}
					
					out.write(buffer, 0, bytes);
				}
			} finally {
				if (out != null) {
					out.close();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public UploadedFile getFile() {
		return file;
	}
	
	public void setFile(UploadedFile file) {
		this.file = file;
	}
}
