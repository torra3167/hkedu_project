package service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import command.SellerApplicationWriteCommand;
import command.SellerJoinCommand;
import command.SellerUpdateCommand;
import command.SellerWithdrawalCommand;
import exception.IdPasswordNotMatchingException;
import model.AuthInfo;
import model.Member;
import model.Seller;
import model.SellerApplication;
import repository.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	
	static final String filePath =
//			"C:\\Users\\HKEDU\\Documents\\hkedu_project\\final_project\\src\\main\\webapp\\WEB-INF\\resource\\";
			"C:\\Users\\HKEDU\\Documents\\hkedu_project\\final_project\\src\\main\\webapp\\WEB-INF\\resource\\";
//			"C:\\Users\\hotelalpha\\Documents\\hkedu_project\\final_project\\src\\main\\webapp\\WEB-INF\\resource\\";
	File file = new File(filePath);
	File file2 = new File(filePath);
	
//	Seller seller;
	
	String originalFile;
	String originalFile2;
	String originalFileExtension;
	String originalFileExtension2;
	String storedFileName;
	String storedFileName2;
	MultipartFile multiFile;
	MultipartFile multiFile2;
	
	public Integer insertSeller(SellerJoinCommand sellerJoinCommand) {
		System.out.println("service " + sellerJoinCommand.getSellerEmail());
		return sellerRepository.insertSeller(sellerJoinCommand);
	}
	
	public AuthInfo authenticate(String email, String pw) {
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
		return new AuthInfo(seller.getSellerEmail(), seller.getSellerPw());
	}

	public Integer updateSeller(SellerUpdateCommand sellerUpdateCommand) {
		System.out.println("Service updateSeller"+ sellerUpdateCommand.getSellerEmail());
		Seller seller = new Seller();
		seller.setSellerEmail(sellerUpdateCommand.getSellerEmail());
		seller.setSellerPw(sellerUpdateCommand.getSellerPw());
		seller.setSellerPhone(sellerUpdateCommand.getSellerPhone());
		return sellerRepository.updateSeller(seller);
	}
	
	
	public Integer deleteSeller(SellerWithdrawalCommand sellerWithdrawalCommand) {
		System.out.println("service deleteSeller" + sellerWithdrawalCommand.getSellerEmail());
		Seller seller = new Seller();
		seller.setSellerEmail(sellerWithdrawalCommand.getSellerEmail());
		seller.setSellerPw(sellerWithdrawalCommand.getSellerPw());
		int result = sellerRepository.deleteSeller(seller);
		return result;
	}

	public void insertSellerApplication(SellerApplicationWriteCommand sellerApplicationWriteCommand, HttpSession session) {
		//sellerEmail
		String sellerEmail = (String) session.getAttribute("email");
		System.out.println("svc insertSellerApplication sellerEmail : " + sellerEmail);
		sellerApplicationWriteCommand.setSellerEmail(sellerEmail);
		System.out.println("svc insertSellerApplication getSellerEmail : " + sellerApplicationWriteCommand.getSellerEmail());
		
		//foodNum
		Integer sellerAppliNo = sellerRepository.selectsellerAppliNo();
		System.out.println("service insertSellerApplication sellerAppliNo : " + sellerAppliNo);
		if(sellerAppliNo == 0) {
			sellerAppliNo = 1;
		} else {
			sellerAppliNo = sellerAppliNo + 1;
		}
		System.out.println("service insertSellerApplication sellerAppliNo : " + sellerAppliNo);
		sellerApplicationWriteCommand.setSellerAppliNo(sellerAppliNo);
		
		//applicationStatus
		sellerApplicationWriteCommand.setApplicationStatus("대기");
		
		//applicationDes
		sellerApplicationWriteCommand.setApplicationDes("대기 중");
		
		//sellerLicenseImage
		multiFile = sellerApplicationWriteCommand.getSellerLicense();
		originalFile = multiFile.getOriginalFilename();
		originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
		storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
		file = new File(filePath + storedFileName);
		
		//sellerBusinessRegistrationImage
		multiFile2 = sellerApplicationWriteCommand.getSellerBusinessRegistration();
		originalFile2 = multiFile.getOriginalFilename();
		originalFileExtension2 = originalFile2.substring(originalFile2.lastIndexOf("."));
		storedFileName2 = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension2;
		file2 = new File(filePath + storedFileName2);
		try {
			multiFile.transferTo(file);
			multiFile2.transferTo(file2);
			SellerApplication sellerApplication = new SellerApplication(
					sellerAppliNo,
					sellerEmail,
					sellerApplicationWriteCommand.getSellerAppliBn(), 
					sellerApplicationWriteCommand.getStoreName(), 
					sellerApplicationWriteCommand.getStoreTelphone(),
					sellerApplicationWriteCommand.getStoreAddr(),
					sellerApplicationWriteCommand.getStoreTerm(),
					sellerApplicationWriteCommand.getApplicationStatus(),
					sellerApplicationWriteCommand.getApplicationDes(),
					multiFile.getSize(), 
					originalFile, 
					storedFileName,
					multiFile2.getSize(), 
					originalFile2, 
					storedFileName2
					);
			System.out.println("svc insertSellerApplication getSellerLicenseOriginal : " + sellerApplication.getSellerLicenseOriginal());
			
			int k = sellerRepository.insertSellerApplication(sellerApplication);
			
			if(k < 1) {
				System.out.println("입점신청서 등록 실패!");
			} else {
				System.out.println("입점신청서 등록 성공!");
				Seller seller = new Seller();
				seller.setSellerEmail(sellerEmail);
				seller.setSellerDivide("w");
				sellerRepository.updateSellerDivide(seller);
				session.setAttribute("divide", "w");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<SellerApplication> selectSellerApplicationList() {
		List<SellerApplication> sellerApplicationList = sellerRepository.selectSellerApplicationList();  
		
		for(Object temp : sellerApplicationList) {
			 SellerApplication sa = (SellerApplication)temp;
			 System.out.println("svc selectSellerApplicationList getSellerBrOriginal : " + sa.getSellerBrOriginal());
		}
		return sellerApplicationList;
	}

	public SellerApplication selectSellerApplication(String sellerEmail) {
		SellerApplication sellerApplication = sellerRepository.selectSellerApplication(sellerEmail);
		return sellerApplication;
	}

	public void deleteSellerApplication(int sellerAppliNo, HttpSession session) {
		System.out.println("svc deleteSellerApplication sellerAppliNo : " + sellerAppliNo);
		int k = sellerRepository.deleteSellerApplication(sellerAppliNo);
		
		if(k < 1) {
			System.out.println("입점신청서 삭제 실패");
		} else {
			System.out.println("입점신청서 삭제 성공!");
			Seller seller = new Seller();
			seller.setSellerEmail((String)session.getAttribute("email"));
			seller.setSellerDivide("ns");
			sellerRepository.updateSellerDivide(seller);
			session.setAttribute("divide", "ns");
		}
	}
	
	
	
}
