package com.beyond.todolist.infrastructure.repository;

import com.beyond.todolist.core.model.Profession;
import com.beyond.todolist.core.model.ToDo;
import com.beyond.todolist.core.model.User;
import com.beyond.todolist.infrastructure.entity.UserEntity;
import com.beyond.todolist.infrastructure.repository.ProfessionMapper;
import com.beyond.todolist.infrastructure.repository.impl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

@Service
public class DatabaseService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private UserRepositoryImpl urImpl = new UserRepositoryImpl(this);

    public JdbcTemplate getJdbcTemplate()
    {
        return jdbcTemplate;
    }

    public List<Profession> getProfessions()
    {
        return jdbcTemplate.query("SELECT * FROM homework.profession", new ProfessionMapper());
    }

    public boolean userExists(String username)
    {
        final String sql = "SELECT EXISTS(SELECT * FROM homework.person WHERE username = '" + username + "')";
        return jdbcTemplate.queryForObject(sql, Boolean.class);
    }

    public int createUser(String username, String passwd)
    {
        return urImpl.create(new UserEntity(username, passwd));
    }

    public void updateUser(String username, User user)
    {
        urImpl.update(username, user);
    }

    public void addTodo(ToDo todo)
    {
        String insertPattern = "INSERT INTO homework.todo(person_id, description, status_id, is_deleted) VALUES(%d, '%s', %d, false)";
        String sql = String.format(insertPattern, todo.userId, todo.description, todo.statusId);
        jdbcTemplate.execute(sql);
    }
}
