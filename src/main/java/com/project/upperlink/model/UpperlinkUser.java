package com.project.upperlink.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "upperlink_user")
public class UpperlinkUser implements UserDetails {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    @Column(length = 512, nullable = false,unique = true)
    private String resume_name;
    private long resume_size;
    @Column(name = "resume_uploadTime")
    private Date resume_uploadTime;
    private byte[] resume_content;
    @Column(length = 512, nullable = false,unique = true)
    private String passport_name;
    private long passport_size;
    @Column(name = "passport_uploadTime")
    private Date passport_uploadTime;
    private byte[] passport_content;
    @Enumerated(EnumType.STRING)
    private UpperlinkUserRole upperlinkUserRole;
    private Boolean locked = false;
    private Boolean enabled = false;

    public UpperlinkUser(String firstName, String lastName, String email, String password, String phoneNumber, String resume_name, long resume_size, Date resume_uploadTime, byte[] resume_content, String passport_name, long passport_size, Date passport_uploadTime, byte[] passport_content, UpperlinkUserRole upperlinkUserRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.resume_name = resume_name;
        this.resume_size = resume_size;
        this.resume_uploadTime = resume_uploadTime;
        this.resume_content = resume_content;
        this.passport_name = passport_name;
        this.passport_size = passport_size;
        this.passport_uploadTime = passport_uploadTime;
        this.passport_content = passport_content;
        this.upperlinkUserRole = upperlinkUserRole;
    }

    public UpperlinkUser(String resume_name, long resume_size, Date resume_uploadTime, byte[] resume_content, String passport_name, long passport_size, Date passport_uploadTime, byte[] passport_content) {
        this.resume_name = resume_name;
        this.resume_size = resume_size;
        this.resume_uploadTime = resume_uploadTime;
        this.resume_content = resume_content;
        this.passport_name = passport_name;
        this.passport_size = passport_size;
        this.passport_uploadTime = passport_uploadTime;
        this.passport_content = passport_content;
    }

    public UpperlinkUser(String firstName, String lastName, String email, String password, String phoneNumber, String resume_name, long resume_size, byte[] resume_content, Date resume_uploadTime, String passport_name, long passport_size, byte[] passport_content, Date passport_uploadTime, UpperlinkUserRole user) {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(upperlinkUserRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
