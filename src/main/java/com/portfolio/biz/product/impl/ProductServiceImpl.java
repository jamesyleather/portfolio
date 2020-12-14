package com.portfolio.biz.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.biz.product.ProductService;
import com.portfolio.biz.product.dto.ProductVO;
import com.portfolio.biz.utils.Criteria;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public void enrollProduct(ProductVO vo) {
		productDAO.enrollProduct(vo);
	}

	@Override
	public List<ProductVO> getProductList(String kind) {
		return productDAO.getProductList(kind);
	}

	@Override
	public ProductVO getProductByProdnum(int prodnum) {
		return productDAO.getProductByProdnum(prodnum);
	}

	@Override
	public void updateProduct(ProductVO vo) {
		productDAO.updateProduct(vo);
	}

	@Override
	public void updateViewnum(ProductVO vo) {
		productDAO.updateViewnum(vo);
	}

	@Override
	public List<ProductVO> getProductListPaging(String kind, Criteria criteria) {
		return productDAO.getProductListPaging(kind, criteria);
	}

	@Override
	public int countProductList(String kind) {
		return productDAO.countProductList(kind);
	}

	@Override
	public int maxProductNum() {
		return productDAO.maxProductNum();
	}

	@Override
	public void insertProductImage(ProductVO vo) {
		productDAO.insertProductImage(vo);
	}

	@Override
	public List<ProductVO> detailProductImage(int prodnum) {
		return productDAO.detailProductImage(prodnum);
	}

	@Override
	public List<ProductVO> getProductCategoryListPaging(String kind, Criteria criteria) {
		return productDAO.getProductCategoryListPaging(kind, criteria);
	}

	@Override
	public int countCategoryProductList(String kind) {
		return productDAO.countCategoryProductList(kind);
	}

	@Override
	public List<ProductVO> getProductCategoryList(String kind) {
		return productDAO.getProductCategoryList(kind);
	}

	@Override
	public List<ProductVO> bestProductList() {
		return productDAO.bestProductList();
	}

}
