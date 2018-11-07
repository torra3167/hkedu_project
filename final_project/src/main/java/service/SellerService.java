package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import command.SellerJoinCommand;
import exception.IdPasswordNotMatchingException;
import model.Coach;
import model.CoachAuthInfo;
import model.Seller;
import model.SellerAuthInfo;
import repository.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	public Integer insertSeller(SellerJoinCommand sellerJoinCommand) {
		System.out.println("service " + sellerJoinCommand.getSellerEmail());
		return sellerRepository.insertSeller(sellerJoinCommand);
	}
	
	public SellerAuthInfo authenticate(String email, String pw) {
		Seller seller = sellerRepository.selectByEmail(email);
		System.out.println("Service  Seller " + seller);
		// 이메일이 존재하지 않는경우
		if(seller == null) {
			throw new IdPasswordNotMatchingException("아이디가 존재하지않습니다");
		}
		//비밀번호 틀린경우
		if(!seller.getSellerPw().equals(pw)) {
			throw new IdPasswordNotMatchingException("패스워드가 일치하지 않습니다");
		}
		//일치하는 경우
		return new SellerAuthInfo(seller.getSellerEmail(), seller.getSellerPw());
	}
	
}
