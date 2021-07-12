package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//this class saves members to the db, currently in java
@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        //here the db needs to be updated
        memberRepository.save(member);
    }
    //override/
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
