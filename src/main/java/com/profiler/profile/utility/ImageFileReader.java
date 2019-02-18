package com.profiler.profile.utility;

import java.io.File;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ImageFileReader {

	String GIF = "gif";
	String PNG = "png";
	String JPG = "jpg";
	String BMP = "bmp";
	String JPEG = "jpeg";

	@Value("${image.source.root}")
	private String imageSource;

	// String imgSrc = "static\\heroes";
	public ArrayList<String> imageUrlList(String dirPath, String ctx, String id) { // this is not getting used currently

		ArrayList<String> imgList = new ArrayList<>();
		final File dir = new File(imageSource+dirPath); // TODO:
		System.out.println("image source: " + imageSource+dirPath);																												// see
																														// if
																														// this
																														// can
																														// be
																														// changed
																														// into
																														// relative
																														// path
		
		String ctxPath = "/static/"+id+"/profile/"; // default path
		if(ctx.equalsIgnoreCase("index"))
		{
			//no change
		}else {
			if(ctx.equalsIgnoreCase("profile")) {
				ctxPath = "/static/"+id+"/scenes/scene1/solo/";
			}
			else
				ctxPath = "/static/"+id+"/scenes/scene1/group/";
		}
		for (final File imgFile : dir.listFiles()) {
			if(imgFile.isDirectory()) {
				for (final File tmpFile : imgFile.listFiles())
				{}
			}
			if (this.accept(imgFile)) {
				System.out.println("image names: " + imgFile.getPath());
				imgList.add(ctxPath + imgFile.getName());
//				imgList.add(imgFile.getPath());
				
			}

		}
		return imgList;
	}

	private boolean accept(File file) {
		if (file != null) {
			if (file.isDirectory())
				return false;
			String extension = getExtension(file);
			if (extension != null && isSupported(extension))
				return true;
		}
		return false;
	}

	private String getExtension(File file) {
		if (file != null) {
			String filename = file.getName();
			int dot = filename.lastIndexOf('.');
			if (dot > 0 && dot < filename.length() - 1)
				return filename.substring(dot + 1).toLowerCase();
		}
		return null;
	}

	private boolean isSupported(String ext) {
		return ext.equalsIgnoreCase(GIF) || ext.equalsIgnoreCase(PNG) || ext.equalsIgnoreCase(JPG)
				|| ext.equalsIgnoreCase(BMP) || ext.equalsIgnoreCase(JPEG);
	}

	public String imageUrl(String dirPath, String name) {
		String ctxPath = null;
		final File dir = new File(imageSource + dirPath);
		if (dir.listFiles() != null) {
			for (final File file : dir.listFiles()) {
				ctxPath = "static/" + name + "/profile/" + file.getName();
			}
		}
		return ctxPath;
	}

	public String getLeafDirPath(String dirPath, File dir) {
		for (final File imgFile : dir.listFiles()) {
			if (!imgFile.isDirectory()) {
				return dirPath;
			} else {
				return dirPath = getLeafDirPath(dirPath + "\\" + dir.getName(), imgFile);
			}

		}
		return dirPath;
	}
}
