package model;

import java.util.List;

public class Community {
    int com=1;
    private int communityId;
    private String communityName;
    private int createdBy;
    private List<Member> members;

    public Community( String communityName, int createdBy) {
        this.communityId = com++;
        this.communityName = communityName;
        this.createdBy = createdBy;
    }

    public int getCommunityId() {
        return communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
