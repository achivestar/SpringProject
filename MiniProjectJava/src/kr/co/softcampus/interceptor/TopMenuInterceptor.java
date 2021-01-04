package kr.co.softcampus.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.softcampus.beans.BoardInfoBean;
import kr.co.softcampus.beans.UserBean;
import kr.co.softcampus.service.TopMenuService;

public class TopMenuInterceptor implements HandlerInterceptor{

	//@Autowired  //interceptor에서는 빈을 주입 못 받는다 생성자로 빈을 주입 받아라
	private TopMenuService topMenuService;
	private UserBean loginUserBean;
	
	//생성자로 빈을 주입 받아라
	public TopMenuInterceptor(TopMenuService topMenuService, UserBean loginUserBean) {
		this.topMenuService = topMenuService;
		this.loginUserBean = loginUserBean;
	}
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		List<BoardInfoBean> topMenuList = topMenuService.getTopMenuList();
		request.setAttribute("topMenuList", topMenuList);
		request.setAttribute("loginUserBean", loginUserBean);
		return true;
	}
}
