package com.audio_mart.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.audio_mart.domain.MemberDTO;

@Mapper
public interface MemberMapper {
	public boolean insertMember(MemberDTO params);
	public MemberDTO findByIdx(Long idx);
	public MemberDTO findByCustid(String custid);
	public boolean updateMember(MemberDTO params);
	public boolean deleteMember(Long idx);
	public boolean deleteCartForDeletion(Long idx);
	public List<MemberDTO> memberList();
//	public int selectMemberTotalCount();
}

// 회원가입 시 아이디 중복체크 해야함
