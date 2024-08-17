/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmart.pojo;

/**
 *
 * @author Dell
 */
public class UserPojo {
    public UserPojo()
    {    }

    public UserPojo(String userId, String empId, String password, String userType, String userName) {
        this.userId = userId;
        this.empId = empId;
        this.password = password;
        this.userType = userType;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserPojo{" + "userId=" + userId + ", empId=" + empId + ", password=" + password + ", userType=" + userType + ", userName=" + userName + '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    private String userId;
    private String empId;
    private String password;
    private String userType;
    private String userName;
}
