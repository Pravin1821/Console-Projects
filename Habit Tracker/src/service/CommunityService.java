package service;

import model.Community;
import model.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommunityService {
    UserService userService = new UserService();
    HashMap<Integer, Community> communityMap = new HashMap<>();
    public void createCommunity(Community community)
    {
        communityMap.put(community.getCommunityId(),community);
        int id = community.getCreatedBy();
        Member member = new Member(userService.getName(id),"Admin");

        System.out.println(community.getCommunityName()+"Community Created");
    }

}
