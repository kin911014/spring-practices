package com.douzone.container.user;

import java.util.List;

public class User {
	private int no = 0;
	private String name = "김동은";
	private Friend Friend; 
	private List<String> Friends; 

	public User() {
		
	}
	public User(String name) {
		this.name = name;
	}
	public User(int no, String name) {
		this.no = no;
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public Friend getFriend() {
		return Friend;
	}
	public void setFriend(Friend friend) {
		Friend = friend;
	}
	
	public List<String> getFriends() {
		return Friends;
	}
	public void setFriends(List<String> friends) {
		Friends = friends;
	}
	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", Friend=" + Friend + "]";
	}
	
	
}
