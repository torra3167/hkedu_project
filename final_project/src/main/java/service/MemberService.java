package service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import command.FindIDCommand;
import command.MemberJoinCommand;
import command.MemberSurveyCommand;
import command.MemberUpdateCommand;
import command.MemberWithdrawalCommand;
import model.Member;
import model.MemberSurvey;
import repository.MemberRepository;

@Service
public class MemberService {

	Member member;
	MemberSurvey survey;

	@Autowired
	private MemberRepository memberRepository;

	public Integer insertMember(MemberJoinCommand memberJoinCommand) {
		System.out.println("MEMBERSERVICE InsertMember " + memberJoinCommand.getMemberEmail());
		member = new Member(memberJoinCommand.getMemberEmail(), memberJoinCommand.getMemberName(),
				memberJoinCommand.getMemberPhone(), memberJoinCommand.getMemberPass(),
				memberJoinCommand.getMemberAddr1(), memberJoinCommand.getMemberAddr2(),
				memberJoinCommand.getMemberAddrNo(), memberJoinCommand.getMemberDivide());
		return memberRepository.insertMember(member);
	}

	public void findID(FindIDCommand findIDCommand, Model model) {
		member = new Member();
		member.setMemberName(findIDCommand.getMemberName());
		System.out.println("MEMBERSERVICE FindID " + findIDCommand.getMemberName());
		member.setMemberPhone(findIDCommand.getMemberPhone());
		System.out.println("MEMBERSERVICE FindID " + findIDCommand.getMemberPhone());
		String i = memberRepository.selectByNameAndPhone(member);
		model.addAttribute("findEmail", i);

	}

	public Member memberInfo(String email) {
		Member member = memberRepository.selectByEmail(email);
		System.out.println("MEMBERSERVICE MemberInfo " + email);
		return member;
	}

	public Integer updateMember(MemberUpdateCommand memberUpdateCommand) {
		System.out.println("MEMBERSERVICE UpdateMember " + memberUpdateCommand.getMemberEmail());
		Member member = new Member(memberUpdateCommand.getMemberEmail(), memberUpdateCommand.getMemberName(),
				memberUpdateCommand.getMemberPhone(), memberUpdateCommand.getMemberPass(),
				memberUpdateCommand.getMemberAddr1(), memberUpdateCommand.getMemberAddr2(),
				memberUpdateCommand.getMemberAddrNo());
		return memberRepository.updateMember(member);
	}

	public Integer deleteMember(MemberWithdrawalCommand memberWithdrawalCommand, HttpSession session) {
		String email = (String) session.getAttribute("email");
		System.out.println("MEMBERSERVICE DeleteMember " + memberWithdrawalCommand.getMemberEmail());
		member = memberRepository.selectByEmail(email);
		int result = memberRepository.deleteMember(member);
		return result;
	}

	public Integer insertSurvey1(MemberSurveyCommand memberSurveyCommand) {
		System.out.println("memberSurveyCommand.getSurvEat()="+memberSurveyCommand.getSurvEat());
		survey = new MemberSurvey(memberSurveyCommand.getSurvNo(), memberSurveyCommand.getMemberEmail(), memberSurveyCommand.getSurvHeight(),
				memberSurveyCommand.getSurvWeight(), memberSurveyCommand.getSurvEat(), memberSurveyCommand.getSurvBMI(),
				memberSurveyCommand.getSurvSex(), memberSurveyCommand.getSurvAge(),
				memberSurveyCommand.getSurvLifestyle(), memberSurveyCommand.getSurvPhoto(),
				memberSurveyCommand.getSurvShape(), memberSurveyCommand.getSurvDisease(),
				memberSurveyCommand.getSurvConcern(), memberSurveyCommand.getSurvCause(),
				memberSurveyCommand.getSurvCareer());
		
		Integer i = memberRepository.insertSurvey1(survey);
		if (i > 0) {
			System.out.println("SURVEY INSERT " + survey.getSurvNo());
		} else {
			System.out.println("SURVEY INSERT FALE");
		}
		return i;
	}
	
	public MemberSurvey memberSurvey(String email) {
		MemberSurvey memberSurvey=memberRepository.selectSurvByEmail(email);
		System.out.println("MEMBERSERVICE MemberSurvey " + email);
		return memberSurvey;
	}
	
	public Integer updateSurvey2(MemberSurveyCommand memberSurveyCommand) {
		MemberSurvey memberSurvey = new MemberSurvey(
				memberSurveyCommand.getMemberEmail(), memberSurveyCommand.getSurvSex(),
				memberSurveyCommand.getSurvLifestyle(), memberSurveyCommand.getSurvPhoto(),
				memberSurveyCommand.getSurvShape(), memberSurveyCommand.getSurvDisease(),
				memberSurveyCommand.getSurvConcern(), memberSurveyCommand.getSurvCause(),
				memberSurveyCommand.getSurvCareer());
		Integer i=memberRepository.updateSurvey2(memberSurvey);
		System.out.println("service "+i);
		if(i>0) {
			System.out.println("SURVEY UPDATE");
		}else {
			System.out.println("SURVEY UPDATE FALE");
		}
		return i;
	}
}
