package ua.com.Service;

import org.springframework.web.multipart.MultipartFile;

public interface FileWriter {
	enum Folder{
		SOMBRA
	}
	
	boolean write(Folder folder, MultipartFile file, int id);

}
