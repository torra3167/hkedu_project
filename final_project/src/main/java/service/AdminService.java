package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Seller;
import model.SellerApplication;
import repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;
	
	
	public void updateSellerDivideS(String sellerEmail) {
		adminRepository.updateAppliStatusAprov(sellerEmail);
		int k = adminRepository.updateSellerDivideS(sellerEmail);
		if(k < 1) {
			System.out.println("입점신청서 승인 실패!");
		} else {
			System.out.println("입점신청서 승인 성공!");
		}
	}

	public SellerApplication selectAppliByAppliNo(int sellerAppliNo) {
		SellerApplication sellerApplication = adminRepository.selectAppliByAppliNo(sellerAppliNo);
		return sellerApplication;
	}

	public void updateSellerDivideP(String sellerEmail, String returnCause) {
		SellerApplication sellerApplication = new SellerApplication();
		sellerApplication.setSellerEmail(sellerEmail);
		sellerApplication.setApplicationDes(returnCause);
		adminRepository.updateApplicationStatusReturn(sellerApplication);
		int k = adminRepository.updateSellerDivideW(sellerEmail);
		if(k < 1) {
			System.out.println("입점신청서 반려 실패!");
		} else {
			System.out.println("입점신청서 반려 성공!");
		}
		
	}

	public void deleteSellerApplication(String sellerEmail) {
		int k = adminRepository.deleteSellerApplication(sellerEmail);
		if(k < 1) {
			System.out.println("입점신청서 삭제 실패!");
		} else {
			System.out.println("입점신청서 삭제 성공!");
		}
		
	}

}
