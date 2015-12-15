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
//                entry.getImagePath2(), , image_path2, image_path3, image_path4, image_path5
//                entry.getImagePath3(), , ?, ?, ?, ?
//                entry.getImagePath4(), , e.image_path2, e.image_path3, e.image_path4, e.image_path5
//                entry.getImagePath5()); , e.image_path2, e.image_path3, e.image_path4, e.image_path5,
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
//            entry.setImagePath2(rs.getString("image_path2"));
//            entry.setImagePath3(rs.getString("image_path3"));
//            entry.setImagePath4(rs.getString("image_path4"));
//            entry.setImagePath5(rs.getString("image_path5"));

            User author = new User();
            author.setFirstName(rs.getString("firstname"));
            author.setLastName(rs.getString("lastname"));

            entry.setAuthor(author);

            return entry;
        }
    }
}
