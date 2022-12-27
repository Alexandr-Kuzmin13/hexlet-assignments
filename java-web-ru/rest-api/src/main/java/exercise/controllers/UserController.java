package exercise.controllers;

import io.javalin.http.Context;
import io.javalin.apibuilder.CrudHandler;
import io.ebean.DB;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import exercise.domain.User;
import exercise.domain.query.QUser;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.lang3.StringUtils;

public class UserController implements CrudHandler {

    public void getAll(Context ctx) {
        // BEGIN
        List<User> users = new QUser()
                .orderBy()
                .id.asc()
                .findList();

        String json = DB.json().toJson(users);
        ctx.json(json);
        // END
    };

    public void getOne(Context ctx, String id) {
        // BEGIN
        User user = new QUser()
                .id.equalTo(Integer.parseInt(id))
                .findOne();

        String json = DB.json().toJson(user);
        ctx.json(json);
        // END
    };

    public void create(Context ctx) {

        // BEGIN
        String body = ctx.body();
        var user = DB.json().toBean(User.class, body);

        var errors = ctx.bodyValidator(User.class)
                .check(obj -> !obj.getFirstName().isEmpty(), "Имя не должно быть пустым")
                .check(obj -> !obj.getLastName().isEmpty(), "Фамилия не должно быть пустым")
                .check(obj -> EmailValidator.getInstance().isValid(obj.getEmail()), "email должен быть действительным")
                .check(obj ->  StringUtils.isNumeric(obj.getPassword()), "Пароль должен содержать только цифры")
                .check(obj -> !obj.getPassword().isEmpty(), "Пароль не должен быть пустым")
                .check(obj -> obj.getPassword().length() >= 4, "Пароль не должен быть короче 4 символов")
                .errors();

        if (!errors.isEmpty()) {
            ctx.status(422);
            return;
        }

        user.save();

        PrintWriter printWriter;
        try {
            printWriter = ctx.res.getWriter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        printWriter.write("Пользователь создан успешно!");
        // END
    };

    public void update(Context ctx, String id) {
        // BEGIN
        String body = ctx.body();
        User updatedUser = DB.json().toBean(User.class, body);
        updatedUser.setId(id);
        updatedUser.update();
        // END
    };

    public void delete(Context ctx, String id) {
        // BEGIN
        String body = ctx.body();
        var user = DB.json().toBean(User.class, body);
        user.delete();
        // END
    };
}
