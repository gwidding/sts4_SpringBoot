package com.audio_mart.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.audio_mart.domain.MemberDTO;

@Mapper
public interface MemberMapper {
	public boolean insertMember(MemberDTO params);
	public MemberDTO selectMemberDetail(String custid);
	public boolean updateMember(MemberDTO params);
	public List<MemberDTO> selectMemberList();
	public boolean signoutMember(String custid);
	public int selectMemberTotalCount();
}
