package io.duru.projects.sterling.apimodel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * created by dduru on 03/10/2018
 */
@Component
public class ApiContext {

    @Value("${web.root.url:http://localhost:8080}")
    public String webRootUrl;

    @Value("${logo1.default:/img/photos/web_logo_default.png}")
    public String defaultLogoUrl;

}