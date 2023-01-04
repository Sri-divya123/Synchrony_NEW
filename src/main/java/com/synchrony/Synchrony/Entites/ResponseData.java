package com.synchrony.Synchrony.Entites;

public class ResponseData {
	
	private String fileName;
	private String imageURL;
	private String fileType;
	private long filSize;
	public ResponseData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseData(String fileName, String imageURL, String fileType, long filSize) {
		super();
		this.fileName = fileName;
		this.imageURL = imageURL;
		this.fileType = fileType;
		this.filSize = filSize;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public long getFilSize() {
		return filSize;
	}
	public void setFilSize(long filSize) {
		this.filSize = filSize;
	}
	@Override
	public String toString() {
		return "ResponseData [fileName=" + fileName + ", imageURL=" + imageURL + ", fileType=" + fileType + ", filSize="
				+ filSize + "]";
	}
	
	

}
