package kr.co.parkham.controller.http;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;

@Slf4j
@Controller
@RequestMapping(value = "/web/")
public class WebPageController {
	
    @Autowired
    MessageSource messageSource;
    
    @Autowired
    LocaleResolver localeResolver;

	/**
	 * JSP 호출 테스트
	 * @return
	 */
	@RequestMapping("/jspTest")
	public String welcome() {
		return "test";
	}

	/**
	 * Thymeleaf 호출 테스트
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/thymeleafTest")
	public String thymeleafTest(Model model) throws Exception {
		model.addAttribute("msg", "thymeleafTest!!!!!!!!!!!!!!!!!!!");

		return "thymeleaf/test";
	}
	
    @RequestMapping(value = "/main/i18n.do", method = RequestMethod.GET)
    public String i18n(Locale locale, HttpServletRequest request, Model model) {

        // RequestMapingHandler로 부터 받은 Locale 객체를 출력해 봅니다.
        model.addAttribute("clientLocale", locale);

        // localeResolver 로부터 Locale 을 출력해 봅니다.
        model.addAttribute("sessionLocale", localeResolver.resolveLocale(request));

        // JSP 페이지에서 EL 을 사용해서 arguments 를 넣을 수 있도록 값을 보낸다.
        model.addAttribute("siteCount", messageSource.getMessage("msg.first", null, locale));

        return "main/i18n";
    }
}
