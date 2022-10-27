package com.cos.security1.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.security1.model.User;

//시큐리티가 /login 주소 요청이 오면 낚아채서 로그인을 진행시킴.
//로그인 진행이 완료가 되면 session을 만들어줌. (Security ContextHolder)
//오브젝트 => Authentication 타입 객체
// Authentication 안에 User 정보가 있어야 함.
//User 오브젝트 타입 = > UserDetails 타입 객체여야 함.

//즉 Security Session = > Authentication = > UserDetails(PrincipalDetails)
public class PrincipalDetails implements UserDetails {

	private User user; // 콤포지션

	public PrincipalDetails(User user) {
		this.user = user;
	}

	// 해당 유저의 권한을 리턴하는 메소드
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList<>();
		collect.add(new GrantedAuthority() {

			@Override
			public String getAuthority() {
				return user.getRole();

			}
		});
		return collect;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
