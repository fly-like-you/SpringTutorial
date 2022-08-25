package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller //effect: 기능은 없지만 스프링컨테이너가 생성되고 Controller가 있으면 멤버컨트롤러 객체를 생성해서 스프링에 넣어둔다?
// 컨테이너가 이제 Controller를 관리한다
public class MemberController {
    // private final MemberService memberService = new MemberService();
    // -> 다른 컨트롤러에서도 해당 멤버서비스를 사용할 건데 굳이 매번 생성하지 않아도 됨
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
