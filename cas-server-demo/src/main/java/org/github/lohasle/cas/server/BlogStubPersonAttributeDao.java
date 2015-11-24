package org.github.lohasle.cas.server;

import org.jasig.services.persondir.IPersonAttributes;
import org.jasig.services.persondir.support.AttributeNamedPersonImpl;
import org.jasig.services.persondir.support.StubPersonAttributeDao;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lohas on 2015/11/21 0021.
 */
public class BlogStubPersonAttributeDao extends StubPersonAttributeDao {
    private final String sql_getuserinfo = "select id,username,password,email from cas_user where username =?";


    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public IPersonAttributes getPerson(String uid) {
        Map<String, List<Object>> attributes = new HashMap<String, List<Object>>();



        Map<String, Object> stringObjectMap = jdbcTemplate.queryForObject(sql_getuserinfo, new ColumnMapRowMapper(), uid);
        attributes.put("data",Collections.singletonList((Object)stringObjectMap));
        return new AttributeNamedPersonImpl(attributes);
    }

}
