package com.bau.hotel.dao;

import com.bau.hotel.model.Entry;
import com.bau.hotel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EntryDao {

    private JdbcTemplate jdbcTemplate;

    public void addEntry(Entry entry, User user){
        String sql = "INSERT INTO entries (title, entry, author, image_path) VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sql, entry.getTitle(),
                entry.getEntry(),
                user.getId(),
                entry.getImagePath());

        Integer entryId = jdbcTemplate.queryForObject("select SCOPE_IDENTITY( )", Integer.class);
        entry.setId(entryId);


        if( entry.hasAnyTags() ){
            for(  String tagName : entry.getTagList() ){
                Tag tag = getEntryTag(tagName);

                if( tag == null ){
                    sql = "INSERT INTO tags (name) VALUES (?)";
                    jdbcTemplate.update(sql, tagName);
                    tag = getEntryTag(tagName);
                }

                sql = "INSERT INTO entry_tags (entry_id, tag_id) VALUES (?, ?)";
                jdbcTemplate.update(sql, entry.getId(), tag.getId());
            }
        }
    }

    private Tag getEntryTag(String tagName) {
        String sql = "SELECT id, name FROM tags WHERE name = ?";
        Tag tag;
        try{
            tag = jdbcTemplate.queryForObject(sql, new TagRowMapper(), tagName);
        } catch(EmptyResultDataAccessException e){
            tag = null;
        }
        return tag;
    }

    public List<Tag> getTags(Entry entry){
        String sql = "SELECT t.id, t.name FROM tags t, entry_tags e" +
                "  WHERE e.tag_id = t.id AND e.entry_id = ?";

        return jdbcTemplate.query(sql, new TagRowMapper(), entry.getId());
    }

    public Tag getTag(Integer tagId){
        String sql = "SELECT t.id, t.name FROM tags t WHERE t.id = ?";

        try {
            return jdbcTemplate.queryForObject(sql, new TagRowMapper(), tagId);
        } catch(EmptyResultDataAccessException e){
            return  null;
        }
    }

    public List<Tag> getAllTags(){
        String sql = "SELECT t.id, t.name FROM tags t";

        return jdbcTemplate.query(sql, new TagRowMapper());
    }


    public Entry getEntry(int entryId) {
        String sql = "select e.id, e.title, e.entry, e.create_date, e.image_path, u.firstname, u.lastname " +
                     "  from entries e, users u " +
                     " where e.author = u.id " +
                     "   and e.id = ? ";

        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{entryId}, new EntryRowMapper());
        } catch( EmptyResultDataAccessException e ){
            return null;
        }
    }

    public List<Entry> getEntries(){
        String sql = "select e.id, e.title, e.entry, e.create_date, e.image_path, u.firstname, u.lastname " +
                     "  from entries e, users u " +
                     " where e.author = u.id ";

        return jdbcTemplate.query(sql, new EntryRowMapper());
    }

    @Autowired
    public void setDataSource(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static class EntryRowMapper implements RowMapper<Entry> {
        @Override
        public Entry mapRow(ResultSet rs, int rowNum) throws SQLException {
            Entry entry = new Entry();
            entry.setId(rs.getInt("id"));
            entry.setTitle(rs.getString("title"));
            entry.setEntry(rs.getString("entry"));
            entry.setCreateDate(rs.getDate("create_date"));
            entry.setImagePath(rs.getString("image_path"));

            User author = new User();
            author.setFirstName(rs.getString("firstname"));
            author.setLastName(rs.getString("lastname"));

            entry.setAuthor(author);

            return entry;
        }
    }
}
