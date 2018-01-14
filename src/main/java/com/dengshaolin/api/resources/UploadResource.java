package com.dengshaolin.api.resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.restlet.ext.fileupload.RestletFileUpload;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UploadResource extends ServerResource {

	protected static Logger logger = LoggerFactory
			.getLogger(UploadResource.class);

	@Get
	public Representation get() {
		logger.debug("entity: {}", getQuery());
		return new JsonRepresentation(getQuery());
	}

	@Post
	public Representation upload(Representation entity) {
		logger.debug("entity: {}", entity);
		// Disposition disposition = entity.getDisposition();
		// logger.debug("disposition: {}", disposition);
		// Form form = new Form(entity);
		// logger.debug("form: {}", form);
		// Parameter parameter = form.get(0);
		// parameter.getName();
		// logger.debug("parameter: {}\n getName: {}\n getValue: {}", parameter,
		// parameter.getName(), parameter.getValue());
		// String size = form.getFirstValue("size", null);
		// logger.debug("size: {}", size);

		DiskFileItemFactory factory = new DiskFileItemFactory();
		RestletFileUpload upload = new RestletFileUpload(factory);
		List<FileItem> items = null;
		try {
			items = upload.parseRepresentation(entity);
		} catch (FileUploadException e) {
			return new StringRepresentation(e.getLocalizedMessage());
		}

		String filename = "";
		String fieldname = "";
		for (FileItem fi : items) {
			if (fi.isFormField()) {
				fieldname = fi.getFieldName();
				logger.debug("formField: {}", fieldname);
			} else {
				filename = fi.getName();
				this.saveFile(filename, fi.get());
				logger.debug("filename: {}", filename);
				logger.debug("bytes: {}", new String(fi.get()));
			}
		}
		return new StringRepresentation("success");
	}

	@SuppressWarnings("resource")
	private boolean saveFile(String filename, byte[] content) {
		String extName = filename.substring(filename.lastIndexOf("."));
		String newName = new SimpleDateFormat("yyyyMMDDHHmmssms")
				.format(new Date());
		File file = new File(newName + extName);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
//		String path_ = file.getPath();
//		String absPath = file.getAbsolutePath();
//		String parent = file.getParent();
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return false;
		}
		try {
			fos.write(content);
			// fi.write(file);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
