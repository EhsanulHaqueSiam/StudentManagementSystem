package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Authorities;

public interface AuthoritiesDAO {

  void addAuthority(Authorities authority);

  void updateAuthority(Authorities authority);

  void deleteAuthority(String authorityName);

  Authorities getAuthorityByName(String authorityName);
}
