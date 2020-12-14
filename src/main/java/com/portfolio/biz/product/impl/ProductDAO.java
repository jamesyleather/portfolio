package com.portfolio.biz.product.impl;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.biz.product.dto.ProductVO;
import com.portfolio.biz.utils.Criteria;

@Repository
public class ProductDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void enrollProduct(ProductVO vo) {
		System.out.println("==> Mybatis로 enrollProduct() 기능 처리");
		mybatis.insert("ProductDAO.enrollProduct", vo);
	}
	
	public List<ProductVO> getProductList(String kind){
		System.out.println("==> Mybatis로 getProductList() 기능 처리");
		return mybatis.selectList("ProductDAO.getProductList", kind);
	}
	
	public List<ProductVO> getProductListPaging(String kind, Criteria criteria){
		System.out.println("==> Mybatis로 getProductListPaging() 기능 처리");
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("kind", kind);
		map.put("criteria", criteria);
		return mybatis.selectList("ProductDAO.getProductListPaging", map);
	}
	
	public ProductVO getProductByProdnum(int prodnum) {
		System.out.println("==> Mybatis로 getProductByProdNum() 기능 처리");
		return mybatis.selectOne("ProductDAO.getProductByProdnum", prodnum);
	}
	
	public void updateProduct(ProductVO vo) {
		System.out.println("==> Mybatis로 updateProduct() 기능 처리");
		mybatis.update("ProductDAO.updateProduct", vo);
	}
	
	public void updateViewnum(ProductVO vo) {
		System.out.println("==> Mybatis로 updateViewnum() 기능 처리");
		mybatis.update("ProductDAO.updateViewnum", vo);
	}
	
	public int countProductList(String kind) {
		System.out.println("==> Mybatis로 countProductList() 기능 처리");
		return mybatis.selectOne("ProductDAO.countProductList", kind);
	}
	
	public int maxProductNum() {
		System.out.println("==> Mybatis로 maxProductNum() 기능 처리");
		return mybatis.selectOne("ProductDAO.maxProductNum");
	}
	
	public void insertProductImage(ProductVO vo) {
		System.out.println("==> Mybatis로 insertProductImage() 기능 처리");
		mybatis.insert("ProductDAO.insertProductImage", vo);
	}
	
	public List<ProductVO> detailProductImage(int prodnum) {
		System.out.println("==> Mybatis로 detailProductImage() 기능 처리");
		return mybatis.selectList("ProductDAO.detailProductImage", prodnum);
	}
	
	public List<ProductVO> getProductCategoryListPaging(String kind, Criteria criteria){
		System.out.println("==> Mybatis로 getProductCategoryListPaging() 기능 처리");
		HashMap<String, Object> map = new HashMap<>();
		map.put("kind", kind);
		map.put("criteria", criteria);
		return mybatis.selectList("ProductDAO.getProductCategoryListPaging", map);
	}
	
	public int countCategoryProductList(String kind) {
		System.out.println("==> Mybatis로 countCategoryProductList() 기능 처리");
		return mybatis.selectOne("ProductDAO.countCategoryProductList", kind);
	}
	
	public List<ProductVO> getProductCategoryList(String kind){
		System.out.println("==> Mybatis로 getProductCategoryList() 기능 처리");
		return mybatis.selectList("ProductDAO.getProductCategoryList", kind);
	}
	
	public List<ProductVO> bestProductList(){
		System.out.println("==> Mybatis로 bestProductList() 기능 처리");
		return mybatis.selectList("ProductDAO.bestProductList");
	}
}
