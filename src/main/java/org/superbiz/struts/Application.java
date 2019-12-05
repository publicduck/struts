package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.hibernate.annotations.Filter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }



    // Configure a FilterRegistratonBean for a com.opensymphony.sitemesh.webapp.SiteMeshFilter,
   // which replaces the PageFilter,
   // and use the url pattern of "/*". This filter is smart enough to only apply this filter to the proper files.

        @Bean
        public FilterRegistrationBean<SiteMeshFilter> getFilterRegistratonBean(){
            FilterRegistrationBean<SiteMeshFilter> filter = new FilterRegistrationBean<>();
            filter.setFilter(new SiteMeshFilter());
            filter.addUrlPatterns("/*");
            filter.setOrder(1);
            return filter;
        }

//    Configure a FilterRegistrationBean for the org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter.
//    This filter replaces both the FilterDispatcher and ActionContextCleanUp filters. Set the url pattern for only
//    the Struts endpoints instead of using a url pattern of "/*" as indicated in the web.xm l:

  //          "/"
  //          "/addUserForm.action"
  //          "/addUser.action"
  //          "/findUserForm.action"
  //          "/findUser.action"
 //           "/listAllUsers.action"

    @Bean
    public FilterRegistrationBean<StrutsPrepareAndExecuteFilter> getStrutsPrepareAndExecuteFilter () {
        FilterRegistrationBean<StrutsPrepareAndExecuteFilter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new StrutsPrepareAndExecuteFilter());
        filter.addUrlPatterns("/");
        filter.addUrlPatterns("/addUserForm.action");
        filter.addUrlPatterns("/addUser.action");
        filter.addUrlPatterns("/findUserForm.action");
        filter.addUrlPatterns("/findUser.action");
        filter.addUrlPatterns("/listAllUsers.action");
        filter.setOrder(2);
        return filter;
    }

}
