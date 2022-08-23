package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
}
