package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import domain.LoginVO;
import domain.ProductVO;
import service.ProductService;

@Controller
public class ProductController {
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	@RequestMapping(value = "/pin", method = RequestMethod.GET)
	public String insert(LoginVO loginVO, Model model, HttpSession session) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		if(session.getAttribute("loginVO") == null || !loginVO.getId().equals("admin")) {
			System.out.println("need login");
			return "redirect:/main";
		}
		model.addAttribute("productVO", new ProductVO());
		return "/product/insert";
	}
	@RequestMapping(value = "/pin", method = RequestMethod.POST)
	public String insert(ProductVO productVO) throws IOException {
		if(productVO.getDescr().get(0).getOriginalFilename().isEmpty()) {
			return "redirect:/pin";
		}
		String imagesFolder = "C:/Users/GC/Desktop/images";
		File basicFolder = new File(imagesFolder);
		if(!basicFolder.exists()) {
			basicFolder.mkdirs();
		}
		String folderName = productVO.getItem();
		String savePath = imagesFolder+"/"+folderName+"/";
		File Folder = new File(savePath);
		if(!Folder.exists()) {
			Folder.mkdirs();
		}
		List<MultipartFile> descriptFile = productVO.getDescr();
		List<String> originalFiles = new ArrayList<String>();
		List<String> changedFiles = new ArrayList<String>();
		if(descriptFile != null && descriptFile.size() > 0) {
			for(MultipartFile mf : descriptFile) {
				String ofn = mf.getOriginalFilename();
				String fex = ofn.substring(ofn.lastIndexOf("."));
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				String sfn = uuid + fex;
				String tsf = savePath + sfn;
				byte[] fileData = mf.getBytes();
				FileOutputStream fos = new FileOutputStream(tsf);
				fos.write(fileData);
				fos.close();
				originalFiles.add(ofn);
				changedFiles.add(sfn);
			}
		}
		productVO.setOntn(originalFiles.get(0).toString());
		productVO.setCntn(changedFiles.get(0).toString());
		originalFiles.remove(0);
		changedFiles.remove(0);
		productVO.setOndes(originalFiles.toString());
		productVO.setCndes(changedFiles.toString());
		productService.insert(productVO);
		return "redirect:/main";
	}
}
