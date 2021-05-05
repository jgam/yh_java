package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

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
