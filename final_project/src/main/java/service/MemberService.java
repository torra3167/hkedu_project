package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import model.Member;
import model.MemberSurvey;
import repository.MemberRepository;
@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	
	public Integer insertMember(Member member) {
		System.out.println("service "+member.getMemberEmail());
		return memberRepository.insertMember(member);
	}
	public void findID(Member member, Model model) {
		System.out.println("service "+member.getMemberEmail());
		Member mb=memberRepository.memberSelect(member);
		int result=0;
		if(mb!=null) {
			if(!mb.getMemberPass().equals(member.getMemberPass())) {
				result=2;
			}else {
				result=3;
			}
		}else {
			result=1;
		}
		model.addAttribute("result", result);
	}
	
	public Integer insertSurvey1(MemberSurvey memberSurvey) {
		System.out.println("service "+memberSurvey.getSurvNo());
		int i=memberRepository.countSurvey();
		System.out.println("insertSurvey1 : " + i);
		String email=memberSurvey.getMemberEmail();
		memberSurvey.setSurvNo(i);
		memberSurvey.setMemberEmail(email);
		return memberRepository.insertSurvey1(memberSurvey);
	}
//	public Integer surveyWrite(MemberSurveyCommand memberSurveyCommand) {
//		System.out.println("service "+memberSurveyCommand.getSurvNo());
//		return memberRepository.survey2Write(memberSurveyCommand);
//	}

}
