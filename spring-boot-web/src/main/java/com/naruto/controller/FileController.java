package com.naruto.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年5月9日
 */
@RestController
@RequestMapping("/file")
public class FileController {

	@RequestMapping("/download")
	public void download(HttpServletRequest request, HttpServletResponse response) {
		String path = "f:/1.xlsx";
		InputStream input = null;
		try {
			input = new FileInputStream(new File(path));
			response.setContentType("application/x-download");
			String downloadFileName = "下载文件.xlsx";
			String fileName = new String(downloadFileName.getBytes("utf-8"), "ISO-8859-1");
			response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
			OutputStream output = response.getOutputStream();
			IOUtils.copy(input, output);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
