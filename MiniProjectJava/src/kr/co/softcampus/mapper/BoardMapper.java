package kr.co.softcampus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.softcampus.beans.ContentBean;

public interface BoardMapper {

	@Insert("insert into content_table(content_subject,content_text,content_file,"+
			"content_writer_idx,content_board_idx,content_date) values "+
			"(#{content_subject},#{content_text}, #{content_file, jdbcType=VARCHAR}, #{content_writer_idx}, #{content_board_idx}, now())")
	void addContentInfo(ContentBean writeContentBean);
	
	@Select("select board_info_name from board_info_table where board_info_idx = #{board_info_idx}")
	String getBoardInfoName(int board_info_idx);
	
	@Select("SELECT a1.content_idx, a1.content_subject, a2.user_name AS content_writer_name, a1.content_date  FROM " + 
			"content_table a1, user_table a2 " + 
			"WHERE a1.content_writer_idx = a2.user_idx " + 
			"AND a1.content_board_idx=#{board_info_idx} " + 
			"ORDER BY a1.content_idx DESC")
	
	List<ContentBean> getContentList(int board_info_idx);
	
	@Select("SELECT a2.user_name AS content_writer_name, a1.content_date, a1.content_subject, a1.content_text, a1.content_file, a1.content_writer_idx " + 
			"FROM content_table a1, user_table a2 "+ 
			"WHERE a1.content_writer_idx = a2.user_idx " + 
			"AND content_idx=#{content_idx}")
	ContentBean getContentInfo(int content_idx);
}
