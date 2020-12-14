package com.portfolio.biz.product;

import java.util.List;

import com.portfolio.biz.product.dto.ProductVO;
import com.portfolio.biz.utils.Criteria;

public interface ProductService {

	void enrollProduct(ProductVO vo);
	
	List<ProductVO> getProductList(String kind);
	
	ProductVO getProductByProdnum(int prodnum);
	
	void updateProduct(ProductVO vo);
	
	void updateViewnum(ProductVO vo);
	
	List<ProductVO> getProductListPaging(String kind, Criteria criteria);
	
	int countProductList(String kind);
	
	int maxProductNum();
	
	void insertProductImage(ProductVO vo);
	
	List<ProductVO> detailProductImage(int prodnum);
	
	List<ProductVO> getProductCategoryListPaging(String kind, Criteria criteria);
	
	int countCategoryProductList(String kind);
	
	List<ProductVO> getProductCategoryList(String kind);
	
	List<ProductVO> bestProductList();

}