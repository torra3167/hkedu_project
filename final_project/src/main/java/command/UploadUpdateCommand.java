package command;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("serial")
public class UploadUpdateCommand implements Serializable {
	private int uploadNumber;
	private int exerciseCatANumber;
	private int exerciseCatBNumber;
	private int exerciseNumber;
	private String exerciseContent;
	private MultipartFile uploadFile;
	private Long uploadSize;
	private String uploadOriginal;
	private String uploadStored;
	private String uploadDivide;
}
