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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import common.utils.Criteria;
import common.utils.Pagination;
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
		File folder = new File(savePath);
		if(!folder.exists()) {
			folder.mkdirs();
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
	@RequestMapping(value = "/pli")
	public String list(Model model, Criteria criteria) {
		Pagination pagination = new Pagination();
		pagination.setCriteria(criteria);
		pagination.setCount(productService.countActive());
		model.addAttribute("productList", productService.listActive(criteria));
		model.addAttribute("pagination", pagination);
		return "/product/list";
	}
	@RequestMapping(value = "/apl")
	public String adminList(LoginVO loginVO, Model model, Criteria criteria, HttpSession session) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		if(session.getAttribute("loginVO") == null || !loginVO.getId().equals("admin")) {
			System.out.println("need login");
			return "redirect:/main";
		}
		Pagination pagination = new Pagination();
		pagination.setCriteria(criteria);
		pagination.setCount(productService.countAll());
		model.addAttribute("productList", productService.listAll(criteria));
		model.addAttribute("pagination", pagination);
		return "/product/alist";
	}
	@RequestMapping(value = "/pse/{no}")
	public String selectTA(Model model, @PathVariable int no) {
		ProductVO productVO = productService.selectByNoTA(no);
		String destmp = productVO.getCndes();
		String[] descr = destmp.substring(1, destmp.length()-1).split(", ");
		model.addAttribute("productVO", productVO);
		model.addAttribute("descrList", descr);
		return "/product/select";
	}
	@RequestMapping(value = "/aps/{no}")
	public String selectFA(LoginVO loginVO, Model model, HttpSession session, @PathVariable int no) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		if(session.getAttribute("loginVO") == null || !loginVO.getId().equals("admin")) {
			System.out.println("need login");
			return "redirect:/main";
		}
		ProductVO productVO = productService.selectByNoFA(no);
		String destmp = productVO.getCndes();
		String[] descr = destmp.substring(1, destmp.length()-1).split(", ");
		model.addAttribute("productVO", productVO);
		model.addAttribute("descrList", descr);
		return "/product/aselect";
	}
	@RequestMapping(value = "/pup/{no}", method = RequestMethod.GET)
	public String update(LoginVO loginVO, Model model, HttpSession session, @PathVariable int no) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		if(session.getAttribute("loginVO") == null || !loginVO.getId().equals("admin")) {
			System.out.println("need login");
			return "redirect:/main";
		}
		ProductVO productVO = productService.selectByNoFA(no);
		model.addAttribute("productVO", productVO);
		return "/product/update";
	}
	@RequestMapping(value = "/pup/{no}", method = RequestMethod.POST)
	public String update(ProductVO productVO) throws IOException {
		String imagesFolder = "C:/Users/GC/Desktop/images";
		File basicFolder = new File(imagesFolder);
		if(!basicFolder.exists()) {
			basicFolder.mkdirs();
		}
		String folderName = productVO.getItem();
		String savePath = imagesFolder+"/"+folderName+"/";
		File folder = new File(savePath);
		if(!folder.exists()) {
			folder.mkdirs();
		}
		List<MultipartFile> descriptFile = productVO.getDescr();
		List<String> originalFiles = new ArrayList<String>();
		List<String> changedFiles = new ArrayList<String>();
		if(!descriptFile.get(0).getOriginalFilename().isEmpty()) {
			String files[] = folder.list();
			for(int i=0;i<files.length;i++) {
				String fileName=files[i];
				String fpath=folder.getPath()+"/"+fileName;
				File fof = new File(fpath);
				fof.delete();
			}
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
			productVO.setOntn(originalFiles.get(0).toString());
			productVO.setCntn(changedFiles.get(0).toString());
			originalFiles.remove(0);
			changedFiles.remove(0);
			productVO.setOndes(originalFiles.toString());
			productVO.setCndes(changedFiles.toString());
		}
		productService.update(productVO);
		return "redirect:/apl";
	}
	@RequestMapping(value = "/pde/{no}", method = RequestMethod.GET)
	public String delete(LoginVO loginVO, Model model, HttpSession session, @PathVariable int no) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		if(session.getAttribute("loginVO") == null || !loginVO.getId().equals("admin")) {
			System.out.println("need login");
			return "redirect:/main";
		}
		ProductVO productVO = productService.selectByNoFA(no);
		model.addAttribute("productVO", productVO);
		model.addAttribute("loginVO", loginVO);
		return "/product/delete";
	}
	@RequestMapping(value = "/pde/{no}", method = RequestMethod.POST)
	public String delete(LoginVO loginVO, ProductVO productVO, HttpSession session, String pwd) {
		if(!loginVO.getPwd().equals(pwd)) {
			return "redirect:/pde/{no}";
		}
		String imagesFolder = "C:/Users/GC/Desktop/images";
		String folderName = productVO.getItem();
		String savePath = imagesFolder+"/"+folderName+"/";
		File folder = new File(savePath);
		if(folder.exists()) {
			String files[] = folder.list();
			for(int i=0;i<files.length;i++) {
				String fileName=files[i];
				String fpath=folder.getPath()+"/"+fileName;
				File fof = new File(fpath);
				fof.delete();
			}
		}
		folder.delete();
		productService.delete(folderName);
		return "redirect:/apl";
	}
}
