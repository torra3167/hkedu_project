package service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import command.FindIDCommand;
import command.MemberJoinCommand;
import command.MemberSurveyCommand;
import command.MemberUpdateCommand;
import model.Member;
import model.MemberSurvey;
import repository.LoginRepository;
import repository.MemberRepository;

@Service
public class MemberService {
	
	Member member;
	MemberSurvey survey;
	
	@Autowired
	private MemberRepository memberRepository;

	public Integer insertMember(MemberJoinCommand memberJoinCommand) {
		System.out.println("service " + memberJoinCommand.getMemberEmail());
		return memberRepository.insertMember(memberJoinCommand);
	}

	public void findID(FindIDCommand findIDCommand, Model model) {
		/*System.out.println("service " + findIDCommand.getMemberEmail());
		Member mb = memberRepository.memberSelect(findIDCommand);
		int result = 0;
		if (mb != null) {
			if (!mb.getMemberPass().equals(findIDCommand.getMemberPass())) {
				result = 2;
			} else {
				result = 3;
			}
		} else {
			result = 1;
		}
		model.addAttribute("result", result);*/
		
		member=new Member();
		member.setMemberName(findIDCommand.getMemberName());
		System.out.println("memberservice "+findIDCommand.getMemberName());
		member.setMemberPhone(findIDCommand.getMemberPhone());
		System.out.println("memberservice "+findIDCommand.getMemberPhone());
		String i= memberRepository.selectByNameAndPhone(member);
		System.out.println("11111 : " + i);
		model.addAttribute("findEmail",i);
	
	}



	public Member memberInfo(String email) {
		Member member=memberRepository.selectByEmail(email);
		return member;
	}
	
	public boolean survey1Write(MemberSurveyCommand memberSurveyCommand) {
		Integer result=memberRepository.selectSurveyNo();
		System.out.println("SURVEY No "+memberSurveyCommand.getSurvNo());
		if(result==0) {
			result=1;
		}else {
			result=result+1;
		}
		try {
		survey=new MemberSurvey(result, member.getMemberEmail(), memberSurveyCommand.getSurvHeight(), memberSurveyCommand.getSurvWeight(),
				memberSurveyCommand.getSurvEat(), memberSurveyCommand.getSurvBMI(), memberSurveyCommand.getSurvSex(), memberSurveyCommand.getSurvAge(),
				memberSurveyCommand.getSurvLifestyle(), memberSurveyCommand.getSurvPhoto(), memberSurveyCommand.getSurvShape(), memberSurveyCommand.getSurvDisease(),
				memberSurveyCommand.getSurvConcern(), memberSurveyCommand.getSurvCause(), memberSurveyCommand.getSurvCareer());
		int i=memberRepository.survey1Write(survey);
		if(i>0) {
			System.out.println("SURVEY INSERT "+survey.getSurvNo());
			return true;
		}else {
			System.out.println("SURVEY INSERT FALE");
		}
		}catch(Exception e) {
			
		}
		return false;
	}
//	public boolean findID(String name, String phone) {
//		FindIDCommand findID=loginRepository.selectByNameAndPhone(name, phone);
//		return findID(findID.getMemberName(), findID.getMemberPhone());
//	}
//	public Integer surveyWrite(MemberSurveyCommand memberSurveyCommand) {
//		System.out.println("service "+memberSurveyCommand.getSurvNo());
//		return memberRepository.survey2Write(memberSurveyCommand);
//	}

	public Integer updateMember(MemberUpdateCommand memberUpdateCommand) {
		System.out.println("service updateMember "+memberUpdateCommand.getMemberEmail());
		
		Member member=new Member(memberUpdateCommand.getMemberEmail(), memberUpdateCommand.getMemberName(), memberUpdateCommand.getMemberPhone(), memberUpdateCommand.getMemberPass(), memberUpdateCommand.getMemberAddr1(), memberUpdateCommand.getMemberAddr2(), memberUpdateCommand.getMemberAddrNo());
		return memberRepository.updateMember(member);
	}

}
