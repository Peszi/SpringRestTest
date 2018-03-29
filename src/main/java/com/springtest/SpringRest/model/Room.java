package com.springtest.SpringRest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "room", cascade = CascadeType.MERGE)
    @JsonBackReference
    private Set<User> users = new HashSet<>();

    public Room() {}

    public Set<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void removeUser(User user) {
        this.users.remove(user);
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //    private Long id;
//    private String name;
//
////    @OneToMany(cascade = CascadeType.ALL,
////                fetch = FetchType.LAZY,
////                mappedBy = "game")
//    private List<User> users = new ArrayList<>();
//
//    public Room() {}
//
//    public Room(String name) {
//        this.name = name;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }
//
//    public void addUser(User user) {
//        this.users.add(user);
//    }
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "game_id")
//    public Long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return this.name;
//    }
//
//    @OneToMany(targetEntity = User.class, mappedBy = "user.hostGame", cascade = CascadeType.ALL)
//    public List<User> getUsers() {
//        return users;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id != null ? id.equals(room.id) : room.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
