package org.example.domain.issue;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IssueRepository {

    @Select("select * from issues ORDER BY id asc")
    List<IssueEntity> findAll();

    @Insert("insert into issues (summary, description, created_at) values(#{summary},#{description}, current_timestamp)")
    void insert(String summary, String description);
    @Select("select * from issues where Id = #{issueId}")
    IssueEntity findById(long issueId);

    @Update("update issues set id=#{issueId}, summary=#{summary}, description = #{description}, updated_at = current_timestamp where id = #{issueId}")
    void update(long issueId, String summary, String description);

    @Delete("delete from issues where id = #{issueId}")
    void delete(long issueId);
}
