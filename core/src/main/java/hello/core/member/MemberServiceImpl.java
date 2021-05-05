package hello.core.member;

//this class saves members to the db, currently in java
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

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
