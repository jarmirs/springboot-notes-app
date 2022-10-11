package com.tts.notes.config;

	import java.util.Arrays;
	import java.util.Collection;

	import org.springframework.security.core.GrantedAuthority;
	import org.springframework.security.core.authority.SimpleGrantedAuthority;
	import org.springframework.security.core.userdetails.UserDetails;

	import com.tts.notes.entity.UserInfo;

	public class CustomUserInfo implements UserDetails {

		private UserInfo userInfo;

		public CustomUserInfo(UserInfo userInfo) {
			super();
			this.userInfo = userInfo;
		}

		public CustomUserInfo() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {

			SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(UserInfo.getRole());

			return Arrays.asList(simpleGrantedAuthority);
		}

		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return UserInfo.getPassword();
		}

		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return UserInfo.getEmail();
		}

		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}

}
