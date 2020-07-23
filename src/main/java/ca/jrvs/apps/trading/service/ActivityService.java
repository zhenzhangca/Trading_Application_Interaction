package ca.jrvs.apps.trading.service;


import ca.jrvs.apps.trading.web.resources.ActivityWebResponse;

import java.util.List;

public interface ActivityService {

    List<ActivityWebResponse> getActivityList();
}
