package ca.jrvs.apps.trading.service.impl;

import ca.jrvs.apps.trading.generated.audit.api.ActivityControllerApi;
import ca.jrvs.apps.trading.generated.audit.model.ActivityResponse;
import ca.jrvs.apps.trading.service.ActivityService;
import ca.jrvs.apps.trading.web.resources.ActivityWebResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ActivityServiceImpl")
@Slf4j
public class ActivityServiceImpl implements ActivityService{

    @Autowired
    private ActivityControllerApi activityControllerApi;

    @Override
    public List<ActivityWebResponse> getActivityList() {
        List<ActivityResponse> activityResponses = activityControllerApi.getActivityListUsingGET();
        List<ActivityWebResponse> activityWebResponses = new ArrayList<>();
        activityResponses.stream().forEach(i->{
            ActivityWebResponse response = convertActivityResponse(i);
            activityWebResponses.add(response);
        });
        return activityWebResponses;
    }

    private ActivityWebResponse convertActivityResponse(ActivityResponse model) {
        return ActivityWebResponse.builder()
                .id(model.getId())
                .activity(model.getActivity())
                .desc(model.getDesc())
                .build();
    }
}
