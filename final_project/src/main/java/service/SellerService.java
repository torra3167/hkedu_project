package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import command.SellerJoinCommand;
import model.Seller;
import repository.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	public Integer insertSeller(SellerJoinCommand sellerJoinCommand) {
		System.out.println("service " + sellerJoinCommand.getSellerEmail());
		return sellerRepository.insertSeller(sellerJoinCommand);
	}
	
	/*public void sellerSelect(Seller seller, Model model) {
		System.out.println("service " + seller.getSellerEmail());
		System.out.println("service " + seller.getSellerPw());
		Seller sr = sellerRepository.sellerSelect(seller);
		int result = 0;
		if(sr != null) {
			password媛� ��由� 寃쎌슦
			if(!sr.getSellerPw().equals(seller.getSellerPw())) {
				result = 2;
			}else {
				result = 4;
			}
		}else {
			result = 1;
		}
		model.addAttribute("result", result);
	}*/
	
	
}
