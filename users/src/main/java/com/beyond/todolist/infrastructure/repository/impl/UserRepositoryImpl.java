package com.beyond.todolist.infrastructure.repository.impl;

import com.beyond.todolist.core.model.User;
import com.beyond.todolist.infrastructure.entity.UserEntity;
import com.beyond.todolist.infrastructure.repository.DatabaseService;
import com.beyond.todolist.infrastructure.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
    private DatabaseService holder;

    public UserRepositoryImpl(DatabaseService h)
    {
        holder = h;
    }

    @Override
    public int create(UserEntity user)
    {
        String insertPattern = "INSERT INTO homework.person(username, passwd) VALUES('%s', '%s')";
        String sql = String.format(insertPattern, user.username, user.passwd);
        holder.getJdbcTemplate().execute(sql);
        return holder.getJdbcTemplate().queryForObject("SELECT id FROM homework.person WHERE username='" + user.username + "'", Integer.class);
    }

    @Override
    public void update(String username, User user)
    {
        String updatePattern =
                "UPDATE homework.person " +
                        "SET first_name = '%s', last_name = '%s', email = '%s', salary = %f, birthday = '%s', gender_id = %d, profession_id = %d " +
                        "WHERE username = '%s'";
        String sql = String.format(updatePattern,
                user.firstName,
                user.lastName,
                user.email,
                user.salary,
                user.birthday.toString(),
                user.gender.ordinal() + 1,
                1, // TODO: //user.profession.toString(),
                username);
        // TODO: updated_at
        holder.getJdbcTemplate().execute(sql);
    }
}
