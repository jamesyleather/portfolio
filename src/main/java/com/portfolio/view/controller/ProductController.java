package com.portfolio.view.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.portfolio.biz.employee.dto.AdminVO;
import com.portfolio.biz.product.ProductService;
import com.portfolio.biz.product.dto.ProductVO;
import com.portfolio.biz.utils.Criteria;
import com.portfolio.biz.utils.PageMaker;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "admin_enroll_product", method = RequestMethod.POST)
	public String enrollProductAction(
			@RequestParam(value = "product_image", defaultValue = "", required = false) MultipartFile uploadFile,
			MultipartHttpServletRequest mtfRequest,
			Model model, HttpSession session, ProductVO vo) {
		AdminVO employee = (AdminVO) session.getAttribute("adminUser");

		if (employee == null) {
			return "admin/login";
		} else {
			List<MultipartFile> detailImgFileList = mtfRequest.getFiles("product_detail_image");
			
			int prodnum = productService.maxProductNum();
			
			vo.setProdnum(prodnum);
			
			String thumnailFileName = "";
			if (!uploadFile.isEmpty()) {
				String root_path = session.getServletContext().getRealPath("WEB-INF/resources/product_images/");

				thumnailFileName = uploadFile.getOriginalFilename();

				File file = new File(root_path + thumnailFileName);

				try {
					uploadFile.transferTo(file);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			vo.setImage(thumnailFileName);
			vo.setPrice3(vo.getPrice2() - vo.getPrice1());

			productService.enrollProduct(vo);
			
			if(detailImgFileList.size() < 1) {
				vo.setDetail_image("");
				productService.insertProductImage(vo);
			} else {
				for(MultipartFile mf : detailImgFileList) {
					String fileName = mf.getOriginalFilename();
					String detail_img_root_path = session.getServletContext().getRealPath("WEB-INF/resources/product_images/");
					File detailFile = new File(detail_img_root_path + fileName);
					
					try {
						mf.transferTo(detailFile);
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					vo.setDetail_image(fileName);
					productService.insertProductImage(vo);
				}
			}
			return "redirect:admin_product_list";
		}
	}

	@RequestMapping(value = "admin_product_detail")
	public String productDetailView(@RequestParam(value = "prodnum") int prodnum, HttpSession session, Model model) {
		AdminVO employee = (AdminVO) session.getAttribute("adminUser");

		if (employee == null) {
			return "admin/login";
		} else {
			ProductVO product = productService.getProductByProdnum(prodnum);
			model.addAttribute("product", product);
			
			List<ProductVO> productDetailImage = productService.detailProductImage(prodnum);
			
			model.addAttribute("productDetailImage", productDetailImage);
			return "admin/product/productdetail";
		}
	}

	@RequestMapping(value = "admin_modify_product")
	public String modifyProductView(@RequestParam(value = "prodnum") int prodnum, HttpSession session, Model model) {
		AdminVO employee = (AdminVO) session.getAttribute("adminUser");
		ProductVO product = productService.getProductByProdnum(prodnum);
		String[] kindList = { "", "bag", "wallet", "shoes", "acc" };

		if (employee == null) {
			return "admin/login";
		} else {
			model.addAttribute("product", product);
			model.addAttribute("kindList", kindList);
			return "admin/product/modifyproduct";
		}
	}

	@RequestMapping(value = "admin_update_product", method = RequestMethod.POST)
	public String updateProductAction(@RequestParam(value = "prodnum", defaultValue = "", required = false) int prodnum,
			@RequestParam(value = "product_image", defaultValue = "", required = false) MultipartFile uploadFile,
			HttpSession session, ProductVO vo) {
		AdminVO employee = (AdminVO) session.getAttribute("adminUser");
		ProductVO product = productService.getProductByProdnum(prodnum);

		if (employee == null) {
			return "admin/login";
		} else {

			String fileName = "";
			if (!uploadFile.isEmpty()) {
				String root_path = session.getServletContext().getRealPath("WEB-INF/resources/product_images/");

				fileName = uploadFile.getOriginalFilename();

				File file = new File(root_path + fileName);

				try {
					uploadFile.transferTo(file);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				fileName = product.getImage();
			}

			if (vo.getKind().isEmpty()) {
				vo.setKind(product.getKind());
			}

			vo.setImage(fileName);
			vo.setPrice3(vo.getPrice2() - vo.getPrice1());
			productService.updateProduct(vo);

			return "redirect:admin_product_list";
		}
	}

	@RequestMapping(value = "category")
	public String productListView(@RequestParam(value = "kind", defaultValue = "", required = false) String kind,
			Model model) {
		model.addAttribute("kind", kind);
		
		List<ProductVO> productList = productService.getProductCategoryList(kind);

		model.addAttribute("productList", productList);
		return "product/productlist";
	}
	
	@RequestMapping(value="product_detail")
	public String productDetailView(@RequestParam(value="prodnum", defaultValue="", required = false) int prodnum,
									Model model) {
		ProductVO productVO = productService.getProductByProdnum(prodnum);
		List<ProductVO> productDetailImage = productService.detailProductImage(prodnum);
		
		int view = productVO.getViewnum();
		view++;
		productVO.setViewnum(view);
		
		productService.updateViewnum(productVO);
		
		model.addAttribute("productDetailImage", productDetailImage);
		model.addAttribute("productVO", productVO);
		return "product/productdetail";
	}
}
