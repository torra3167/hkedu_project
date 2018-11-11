package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import command.SellerJoinCommand;
import command.SellerUpdateCommand;
import command.SellerWithdrawalCommand;
import exception.IdPasswordNotMatchingException;
import model.Seller;
import model.SellerAuthInfo;
import repository.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private Seller seller;
	
	public Integer insertSeller(SellerJoinCommand sellerJoinCommand) {
		System.out.println("service " + sellerJoinCommand.getSellerEmail());
		return sellerRepository.insertSeller(sellerJoinCommand);
	}
	
	public SellerAuthInfo authenticate(String email, String pw) {
		Seller seller = sellerRepository.selectByEmail(email);
		System.out.println("Service  Seller " + seller.getSellerEmail());
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

	public Integer updateSeller(SellerUpdateCommand sellerUpdateCommand) {
		System.out.println("Service updateSeller"+ sellerUpdateCommand.getSellerEmail());
		seller.setSellerDivide(sellerUpdateCommand.getSellerEmail());
		seller.setSellerPw(sellerUpdateCommand.getSellerPw());
		seller.setSellerPhone(sellerUpdateCommand.getSellerPhone());
		return sellerRepository.updateSeller(seller);
	}
	
	
	public Integer deleteSeller(SellerWithdrawalCommand sellerWithdrawalCommand) {
		System.out.println("service deleteSeller" + sellerWithdrawalCommand.getSellerEmail());
		seller.setSellerEmail(sellerWithdrawalCommand.getSellerEmail());
		seller.setSellerPw(sellerWithdrawalCommand.getSellerPw());
		int result = sellerRepository.deleteSeller(seller);
		return result;
	}
}
