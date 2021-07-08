package com.interfile.assessment.bootfaces;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "summaryController")
@ELBeanName(value = "summaryController")
@Join(path = "/summary", to = "/summary-form.jsf")
public class SummaryController {

}
