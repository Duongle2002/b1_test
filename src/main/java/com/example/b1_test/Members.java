package com.example.b1_test;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/members")
public class Members {

    @GetMapping
    public String getAllMembers(Model model) {
        List<Member> members = new ArrayList<>();
        members.add(new Member(100008, 3, "Lê Hữu Dương"));
        members.add(new Member(100347, 3,"Trần Nữ Hồ Na"));
        members.add(new Member( 99761,3, "Hồ Thăng Thành"));

        model.addAttribute("members", members);
        return "member-list";
    }
}

class Member {
    private int id;
    private int group;
    private String name;

    // Constructor
    public Member(int id, int group, String name) {
        this.id = id;
        this.group = group;
        this.name = name;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return group;
    }

    public void setCode(int group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}